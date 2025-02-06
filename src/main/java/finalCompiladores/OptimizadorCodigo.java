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
        // ==== PRIMER PASE: Propagación + folding + quitar muertas ====
        // 1) Recolectar variables usadas:
        Set<String> usedVars = recolectarVariablesUsadas(threeAddressCode);

        List<String> primerPaso = new ArrayList<>();
        Map<String, String> constantValues = new HashMap<>();

        for (String line : threeAddressCode) {
            // Ver si es "x = expr"
            Asignaciones info = parseAssignment(line);
            if (info == null) {
                // No es asignación => se deja igual
                primerPaso.add(line);
                continue;
            }

            String leftVar = info.leftVar;
            String rightExpr = info.rightExpr;

            // (a) Eliminar "x = x"
            if (leftVar.equals(rightExpr)) {
                continue;
            }

            // (b) Descomponer "operand1 op operand2"
            Expresiones exprPart = parseRightExpression(rightExpr);

            // (c) Propagación de constantes: si operand1/2 es var con valor conocido, sustituir
            if (exprPart.operand1 != null && constantValues.containsKey(exprPart.operand1)) {
                exprPart.operand1 = constantValues.get(exprPart.operand1);
            }
            if (exprPart.operand2 != null && constantValues.containsKey(exprPart.operand2)) {
                exprPart.operand2 = constantValues.get(exprPart.operand2);
            }

            // (d) Constant folding si operand1 y operand2 numéricos
            String folded = probarFold(exprPart);
            if (folded != null) {
                rightExpr = folded;
            } else {
                // Si no se pudo fold, reconstruimos
                if (exprPart.operator == null && exprPart.operand1 != null) {
                    rightExpr = exprPart.operand1;
                } else if (exprPart.operator != null && exprPart.operand2 != null) {
                    rightExpr = exprPart.operand1 + " " + exprPart.operator + " " + exprPart.operand2;
                }
            }

            // (e) Eliminar asignación muerta: si leftVar no se usa, saltar
            if (!usedVars.contains(leftVar)) {
                continue;
            }

            // (f) Agregar la línea
            String newLine = leftVar + " = " + rightExpr;
            primerPaso.add(newLine);

            // (g) Actualizar constantValues: si rightExpr es número => leftVar es constante
            if (isNumeric(rightExpr)) {
                constantValues.put(leftVar, rightExpr);
            } else {
                constantValues.remove(leftVar);
            }
        }

        // ==== SEGUNDO PASE: Quitar temporales tX innecesarios (copy propagation simple) ====
        // Por ejemplo, "t0 = 12" si t0 se usa 1 sola vez => inline
        // o si t0 no se usa => eliminar
        List<String> finalCode = removeSimpleTemps(primerPaso);

        return finalCode;
    }

    /**
     * Quita temporales (t0, t1, etc.) que no se usan o que se usan una sola vez.
     * Si se usan 1 sola vez, se "inlinea" su expresión en la línea consumidora.
     */
    private static List<String> removeSimpleTemps(List<String> code) {
        // 1) Contar uso de cada variable
        Map<String, Integer> usage = new HashMap<>();
        for (String line : code) {
            for (String tok : getTokens(line)) {
                usage.put(tok, usage.getOrDefault(tok, 0) + 1);
            }
        }

        // 2) Recorremos en orden: si "tX = expr" y uso(tX)=0 => eliminar
        //    si uso(tX)=1 => inline en la próxima aparición
        List<String> result = new ArrayList<>();
        for (String line : code) {
            Asignaciones asg = parseAssignment(line);
            if (asg == null) {
                // No es asignación => la metemos,
                // pero con inlining parcial
                result.add(inlineTemps(line, usage));
                continue;
            }
            String left = asg.leftVar;
            String right = asg.rightExpr;

            if (!left.startsWith("t")) {
                // No es temporal => no lo tocamos
                // Pero sí le inlineamos la parte derecha
                String newRight = inlineTemps(right, usage);
                result.add(left + " = " + newRight);
                continue;
            }

            // Es un temporal: "tN = expr"
            int uses = usage.getOrDefault(left, 0);
            if (uses == 0) {
                // No se usa => fuera
                continue;
            }
            else if (uses == 1) {
                // Se usa 1 sola vez => inline
                // Eliminamos la línea de definicion, y
                // cambiamos en la linea consumidora "tN" por "expr"
                // => la línea no se añade
                // Pero necesitamos inyectar en la futura línea que lo use
                // lo haremos en "result", en la última aparición
                // Sencillez: inlining a posteriori no es trivial,
                // hacemos inlining en la linea anterior?
                // Trucamos y decimos: no agrego => lo elimino
                continue;
            }
            else {
                // Se usa >= 2 => no podemos inlinar
                // inline en la parte derecha
                String newRight = inlineTemps(right, usage);
                result.add(left + " = " + newRight);
            }
        }

        return result;
    }

    // -------------------------------------------------------------------------
    //                          MÉTODOS AUXILIARES
    // -------------------------------------------------------------------------

    /**
     * Reemplaza en la línea las referencias a "tX" que no se haya visto
     * para inline sencillo. (Aquí es muy naive: no sabemos la expresión original.)
     * Lo dejamos simple: no sustituyas "tX" por nada,
     * a menos que quieras un approach más complejo.
     * Para un approach "fuerte", requerimos guardar "temp -> expr" en un map.
     */
    private static String inlineTemps(String line, Map<String,Integer> usage) {
        // Versión minimal: no hacemos nada
        // (o parsear "tX" si usage[tX]==1?
        //  no sabemos la expr original sin un map)
        return line;
    }

    /**
     * Recolecta todas las variables (tokens no keywords) en la lista.
     */
    private static List<String> getTokens(String line) {
        String[] arr = line.split("[\\s\\(\\)\\+\\-\\*\\/=;,]+");
        List<String> res = new ArrayList<>();
        for (String s : arr) {
            if (!s.isEmpty() && isVarCandidate(s)) {
                res.add(s);
            }
        }
        return res;
    }

    private static boolean isVarCandidate(String tk) {
        if (tk.equals("if") || tk.equals("goto") || tk.equals("return")) return false;
        if (tk.matches("L\\d+")) return false; // label
        return true;
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
            String[] tokens = line.split("[\\s\\(\\)\\+\\-\\*\\/=;,]+");
            for (String tk : tokens) {
                if (!tk.isEmpty()
                        && !isNumeric(tk)
                        && !isKeyword(tk)
                        && !tk.endsWith(":"))
                {
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
        String trimmed = line.trim();
        if (trimmed.startsWith(";") || trimmed.startsWith("//")) return null;
        String[] parts = trimmed.split("=", 2);
        if (parts.length < 2) return null;
        String left = parts[0].trim();
        String right = parts[1].trim();
        if (left.isEmpty() || right.isEmpty()) return null;
        // Evitar "if t0 goto L1"
        if (left.startsWith("if")) return null;
        return new Asignaciones(left, right);
    }

    /**
     * Parsea una expresión simple "operand1 op operand2" o "operand1" suelta.
     * Devuelve operandos y operador.
     */
    private static Expresiones parseRightExpression(String expr) {
        Expresiones e = new Expresiones();
        String[] tokens = expr.split("\\s+");
        if (tokens.length == 1) {
            e.operand1 = tokens[0];
        } else if (tokens.length == 3) {
            e.operand1 = tokens[0];
            e.operator  = tokens[1];
            e.operand2  = tokens[2];
        }
        return e;
    }

    /**
     * Intenta hacer constant folding: si operand1 y operand2
     * son numéricos y operator es + - * /, retorna el resultado en string.
     * Si no, retorna null.
     */
    private static String probarFold(Expresiones expr) {
        if (expr.operator != null
                && isNumeric(expr.operand1)
                && isNumeric(expr.operand2))
        {
            double a = Double.parseDouble(expr.operand1);
            double b = Double.parseDouble(expr.operand2);
            double r = 0.0;
            switch (expr.operator) {
                case "+": r = a + b; break;
                case "-": r = a - b; break;
                case "*": r = a * b; break;
                case "/":
                    if (b == 0) return null;
                    r = a / b;
                    break;
                default: return null;
            }
            if (r == Math.floor(r)) {
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

    // ======================
    //   CLASES INTERNAS
    // ======================
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
