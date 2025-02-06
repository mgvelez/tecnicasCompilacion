package finalCompiladores;

import java.util.*;

public class OptimizadorCodigo {

    /**
     * Optimiza la lista de instrucciones 3AC:
     *  1) elimina asignaciones redundantes,
     *  2) propaga constantes,
     *  3) realiza constant folding en expresiones simples tipo "3 + 4".
     *
     * @param threeAddressCode lista de líneas de código en tres direcciones.
     * @return nueva lista con el código optimizado
     */
    public static List<String> optimizarCodigo(List<String> threeAddressCode) {
        // 1) recopilar usos de variables => un conjunto para saber qué variables se usan
        Set<String> usedVars = recolectarVariablesUsadas(threeAddressCode);

        // 2) hacer la optimización en una segunda pasada
        List<String> optimized = new ArrayList<>();

        // Mapa para guardar valores constantes de variables (propagación)
        Map<String, String> constantValues = new HashMap<>();

        for (String line : threeAddressCode) {
            // Ver si es una asignación "x = <expr>"
            Asignaciones info = parseAssignment(line);
            if (info == null) {
                // línea que no es asignación => la dejamos igual
                optimized.add(line);
                continue;
            }

            // Ej.: info.leftVar = "x", info.rightExpr = "3 + y"
            String leftVar = info.leftVar;
            String rightExpr = info.rightExpr;

            // 2.1 Eliminación de "x = x" (redundante)
            if (leftVar.equals(rightExpr)) {
                // Ej.: w = w
                continue;
            }

            // 2.2 Tokenizar la expresión: operand1, op, operand2
            Expresiones exprParts = parseRightExpression(rightExpr);

            // 2.3 Propagación de constantes
            // Solo si operand es una variable en constantValues, la sustituimos
            if (exprParts.operand1 != null && constantValues.containsKey(exprParts.operand1)) {
                exprParts.operand1 = constantValues.get(exprParts.operand1);
            }
            if (exprParts.operand2 != null && constantValues.containsKey(exprParts.operand2)) {
                exprParts.operand2 = constantValues.get(exprParts.operand2);
            }

            // 2.4 Constant folding (si operand1 y operand2 son numéricos)
            String folded = probarFold(exprParts);
            if (folded != null) {
                rightExpr = folded;  // lo reemplazamos
            } else {
                // Si no se pudo "fold", reconstruimos la expresión
                if (exprParts.operator == null && exprParts.operand1 != null) {
                    rightExpr = exprParts.operand1;
                } else if (exprParts.operator != null && exprParts.operand2 != null) {
                    rightExpr = exprParts.operand1 + " " + exprParts.operator + " " + exprParts.operand2;
                }
                // si exprParts.operand1 es null, es algo no parseado => lo dejamos
            }

            // 2.5 Eliminación de código muerto (si la variable leftVar nunca se usa)
            //    => no agregamos la línea
            //    (si la variable es un temporal, asumimos que no se usa, se elimina)
            if (!usedVars.contains(leftVar)) {
                // la variable no se usa => saltar
                continue;
            }

            // 2.6 Agregar la línea al nuevo código
            String newLine = leftVar + " = " + rightExpr;
            optimized.add(newLine);

            // 2.7 Propagar constante si rightExpr es numérica
            if (isNumeric(rightExpr)) {
                // leftVar se vuelve una constante
                constantValues.put(leftVar, rightExpr);
            } else {
                // si deja de ser una constante, la borramos
                constantValues.remove(leftVar);
            }
        }

        return optimized;
    }

    /**
     * Recolecta todas las variables usadas en el lado derecho de asignaciones o
     * en líneas tipo "if t0 goto L1", "return x", etc.
     * De forma muy simple, busca tokens no numéricos en cada línea.
     *
     * @param code lista de líneas 3AC
     * @return conjunto de nombres de variables usadas
     */
    private static Set<String> recolectarVariablesUsadas(List<String> code) {
        Set<String> used = new HashSet<>();
        for (String line : code) {
            // omitir separaciones por '=' para lineas que no son asignaciones
            // Tomamos todos los tokens a lo bruto
            String[] tokens = line.split("[\\s\\(\\)\\+\\-\\*\\/=;,]+");
            // Ej. "if t0 goto L1" => ["if", "t0", "goto", "L1"]
            // "x = y + 2" => ["x", "y", "2"]
            for (String tk : tokens) {
                if (!tk.isEmpty()
                        && !isNumeric(tk)
                        && !isKeyword(tk)
                        && !tk.endsWith(":"))
                {
                    // lo consideramos variable
                    used.add(tk);
                }
            }
        }
        return used;
    }

    /**
     * Parsea una línea y si es "leftVar = rightExpr" devuelve un objeto,
     * si no, devuelve null.
     */
    private static Asignaciones parseAssignment(String line) {
        // Quitar comentarios y espacios
        String trimmed = line.trim();
        if (trimmed.startsWith(";") || trimmed.startsWith("//")) {
            return null; // es un comentario
        }
        // Separar por '='
        String[] parts = trimmed.split("=", 2);
        if (parts.length < 2) {
            return null; // no es una asignación
        }
        String left = parts[0].trim();
        String right = parts[1].trim();
        // Validar
        if (left.isEmpty() || right.isEmpty()) {
            return null;
        }
        return new Asignaciones(left, right);
    }

    /**
     * Parsea una expresión simple "operand1 op operand2" o "operand1" suelta.
     * Devuelve operandos y operador.
     */
    private static Expresiones parseRightExpression(String expr) {
        Expresiones result = new Expresiones();
        // divido en tokens
        String[] tokens = expr.split("\\s+");
        if (tokens.length == 1) {
            // un único token => operand1
            result.operand1 = tokens[0];
        } else if (tokens.length == 3) {
            // "x + y"
            result.operand1 = tokens[0];
            result.operator  = tokens[1];
            result.operand2  = tokens[2];
        } else {
            // aca se puede optimizar algo más complejo
        }
        return result;
    }

    /**
     * Intenta hacer constant folding: si operand1 y operand2
     * son numéricos y operator es + - * /, retorna el resultado en string.
     * Si no, retorna null.
     */
    private static String probarFold(Expresiones expresion) {
        if (expresion.operator != null
                && isNumeric(expresion.operand1)
                && isNumeric(expresion.operand2))
        {
            double a = Double.parseDouble(expresion.operand1);
            double b = Double.parseDouble(expresion.operand2);
            double r = 0.0;
            switch (expresion.operator) {
                case "+": r = a + b; break;
                case "-": r = a - b; break;
                case "*": r = a * b; break;
                case "/":
                    if (b == 0.0) {
                        // evitamos divisiones por 0 => no do folding
                        return null;
                    }
                    r = a / b;
                    break;
                default: return null;
            }
            // si es un entero exacto, devolvemos int
            if (r == Math.floor(r) && !Double.isInfinite(r)) {
                return String.valueOf((int)r);
            } else {
                return String.valueOf(r);
            }
        }
        return null;
    }

    private static boolean isKeyword(String tk) {
        // Palabras que no queremos considerar "variables"
        // if, goto, return, Lxx, etc.
        // En una implementación real:
        //   if, goto, call, param, return, Lxx: ...
        String lower = tk.toLowerCase();
        return lower.equals("if") || lower.equals("goto")
                || lower.equals("return")
                || lower.equals("call")
                || tk.endsWith(":");
    }

    private static boolean isNumeric(String s) {
        if (s == null || s.isEmpty()) return false;
        try {
            Double.parseDouble(s);
            return true;
        } catch (NumberFormatException ex) {
            return false;
        }
    }

    // Clases internas para estructurar datos
    private static class Asignaciones {
        String leftVar;
        String rightExpr;
        Asignaciones(String l, String r) {
            leftVar = l; rightExpr = r;
        }
    }

    private static class Expresiones {
        String operand1;
        String operator;
        String operand2;
    }

}
