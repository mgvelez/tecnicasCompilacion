package finalCompiladores;

import org.antlr.v4.runtime.tree.ParseTree;
import tpDos.TablaSimbolos;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Visitor responsable de generar código de tres direcciones
 * una vez que el análisis semántico EscuchaFinal
 * Cada regla gramatical clave (función, bloque, declaración, instrucción, for, while, etc.) produce las instrucciones adecuadas.
 */

public class CaminanteFinal extends TrabajoFinalBaseVisitor<String> {

    private final TablaSimbolos tablaSimbolos;
    private final List<String> threeAddressCode = new ArrayList<>();

    // Contadores para temps y labels.
    private int tempCounter = 0;
    private int labelCounter = 0;

    public CaminanteFinal(TablaSimbolos tablaSimbolos) {
        this.tablaSimbolos = tablaSimbolos;
    }

    /** Genera un nuevo nombre de variable temporal, p. ej. "t0", "t1", etc. */
    private String newTemp() {
        return "t" + (tempCounter++);
    }

    /** Genera un nuevo label, p. ej. "L0", "L1", etc. */
    private String newLabel() {
        return "L" + (labelCounter++);
    }

    // ------------------------------------------------------------------------
    //   VISITAS PRINCIPALES
    // ------------------------------------------------------------------------

    /**
     * Regla inicial: programa : funcion* EOF ;
     * Visitamos todas las funciones declaradas.
     */
    @Override
    public String visitPrograma(TrabajoFinalParser.ProgramaContext ctx) {
        for (TrabajoFinalParser.FuncionContext funcCtx : ctx.funcion()) {
            visit(funcCtx);
        }
        return null;
    }

    /**
     * funcion : tipoDato ID PA parametros? PC bloque ;
     * Generamos una especie de etiqueta para la función y visitamos su bloque.
     */
    @Override
    public String visitFuncion(TrabajoFinalParser.FuncionContext ctx) {
        String funcName = ctx.ID().getText();
        threeAddressCode.add("\n; --- Función: " + funcName + " ---");
        threeAddressCode.add(funcName + ":");

        // Visitar el bloque
        visit(ctx.bloque());

        // Un "return" implícito si la función es void, etc.:
        // threeAddressCode.add("return");
        return null;
    }

    /**
     * bloque : LLA (instruccion | declaracion)* LLC ;
     * Un bloque envuelve varias declaraciones e instrucciones.
     */
    @Override
    public String visitBloque(TrabajoFinalParser.BloqueContext ctx) {
        for (ParseTree child : ctx.children) {
            // child puede ser una declaración o una instrucción
            visit(child);
        }
        return null;
    }

    /**
     * declaracion : tipoDato listaVariables PYC ;
     * En 3AC, no siempre generamos código por declarar variables.
     * Pero si hay inicializaciones, las podríamos emitir aquí.
     */
    @Override
    public String visitDeclaracion(TrabajoFinalParser.DeclaracionContext ctx) {
        for (TrabajoFinalParser.VariableContext varCtx : ctx.listaVariables().variable()) {
            if (varCtx.ID() == null) {
                System.err.println("Error: Declaración sin identificador en la línea "
                        + ctx.start.getLine());
                continue;
            }
            String nombreVar = varCtx.ID().getText();
            // Si hay inicialización, por ejemplo "ID = expresion"
            if (varCtx.expresion() != null) {
                String rExpr = visit(varCtx.expresion());
                // genera una línea de 3 direcciones, p. ej. "nombreVar = rExpr"
                threeAddressCode.add(nombreVar + " = " + rExpr);
            }
        }
        return null;
    }

    /**
     * instruccion : asignacion
     *             | ifStmt
     *             | forStmt
     *             | whileStmt
     *             | returnStmt
     *             | bloque
     *             | BREAK PYC ;
     * No es estrictamente necesario overridear "visitInstruccion"
     * si ya overrides por separado asignacion, ifStmt, etc.
     * Pero a veces conviene centralizar si hay más lógicas.
     */
    @Override
    public String visitInstruccion(TrabajoFinalParser.InstruccionContext ctx) {
        return super.visitInstruccion(ctx);
        // se puede  verificar el tipo de instrucción y se puede hacer algo, pero no es requerido por el ejercicio:
        // Por ejemplo:
        // - Si es una asignación, se puede generar código 3AC para la asignación.

    }

    /**
     * asignacion :
     *    1) ID IGUAL expresion PYC
     *    2) incremento PYC
     */
    @Override
    public String visitAsignacion(TrabajoFinalParser.AsignacionContext ctx) {
        // Caso 1: "ID = expresion;"
        if (ctx.ID() != null && ctx.expresion() != null) {
            String leftVar = ctx.ID().getText();
            String rExpr = visit(ctx.expresion());
            threeAddressCode.add(leftVar + " = " + rExpr);
        }
        // Caso 2: "incremento PYC"
        else if (ctx.incremento() != null) {
            visit(ctx.incremento());
        }
        return null;
    }

    /**
     * incremento : ID (INCREMENTO | DECREMENTO)? #IncrementoOp;
     * Puede aparecer tanto en "expresion" como en "asignacion".
     */
    @Override
    public String visitIncrementoOp(TrabajoFinalParser.IncrementoOpContext ctx) {
        // ID++
        // ID--
        String varName = ctx.ID().getText();
        if (ctx.INCREMENTO() != null) {
            // varName = varName + 1
            threeAddressCode.add(varName + " = " + varName + " + 1");
        } else if (ctx.DECREMENTO() != null) {
            threeAddressCode.add(varName + " = " + varName + " - 1");
        }
        // Si no hubiera operador, es solo el ID (caso raro en la gramática).
        return varName; // Devolvemos la variable
    }

    /**
     * ifStmt : IF PA condicion PC instruccion (ELSE instruccion)? ;
     * Generamos algo como:
     *   if <cond> goto Ltrue
     *   goto Lfalse
     *   Ltrue:
     *     <código if>
     *   goto Lend (si hay else)
     *   Lfalse:
     *     <código else>
     *   Lend:
     */

    @Override
    public String visitIfStmt(TrabajoFinalParser.IfStmtContext ctx) {
        String lblTrue = newLabel(); //verdadero
        String lblFalse = newLabel(); //false
        String lblEnd = newLabel(); // final del if

        // Evaluamos la condición y almacenamos el resultado en una variable temporal
        String condTemp = visit(ctx.condicion());
        // 'condicion' genera una línea como "tX = left <operador> right"
        // simulamos que si tX no es cero, la condición es verdadera

        threeAddressCode.add("if " + condTemp + " != 0 goto " + lblTrue); // Si la condición es verdadera, saltamos al bloque verdadero
        threeAddressCode.add("goto " + lblFalse); // Si no, saltamos al bloque falso

        // Bloque IF
        threeAddressCode.add(lblTrue + ":"); // Inicio del bloque verdadero
        visit(ctx.instruccion(0)); // Procesamos el bloque de código del if
        if (ctx.instruccion().size() > 1) { //chequeamos si hay bloque else
            threeAddressCode.add("goto " + lblEnd); //saltamos al final después de procesar el 'if'
        }

        // Bloque ELSE (si existe)
        threeAddressCode.add(lblFalse + ":"); // Inicio del bloque falso
        if (ctx.instruccion().size() > 1) {
            visit(ctx.instruccion(1));  // Procesamos el bloque de código del else
        }

        // Label final
        if (ctx.instruccion().size() > 1) {
            threeAddressCode.add(lblEnd + ":"); // Final del if-else
        }

        return null;
    }

    /**
     * forStmt : FOR PA (declaracion | expresion) condicion PYC expresion PC instruccion ;
     * Generamos:
     *   - Primero ejecutamos la parte (declaracion|expresion) inicial
     *   - Lstart:
     *       evaluamos condicion
     *       if cond != 0 goto Lbody
     *       goto Lend
     *     Lbody:
     *       visit instruccion (cuerpo for)
     *       visit la expresion final (incremento)
     *       goto Lstart
     *     Lend:
     */
    @Override
    public String visitForStmt(TrabajoFinalParser.ForStmtContext ctx) {
        // inicio del for
        ParseTree initPart = ctx.getChild(2);
        visit(initPart);

        // creacion de etiquetas de inicio, body y fin del bloque
        String lblStart = newLabel();
        String lblBody = newLabel();
        String lblEnd = newLabel();

        // añadimos el label de inicio del bloque
        threeAddressCode.add(lblStart + ":");

        // evaluamos la condición del bucle
        // (está en "condicion" => ctx.condicion())
        String condTemp = visit(ctx.condicion());
        threeAddressCode.add("if " + condTemp + " != 0 goto " + lblBody);
        threeAddressCode.add("goto " + lblEnd);

        // etiqueta cuerpo bucle
        threeAddressCode.add(lblBody + ":");
        // instruccion (cuerpo del for)
        visit(ctx.instruccion());

        // procesamos la expresion de incremento o de le actualizacion
        //    => ctx.expresion() está en la posición: for(...) condicion PYC expresion
        //    la 4ta parte del for es child #?)
        //    for PA (decl|expr) condicion PYC expresion PC
        //    Indices en ctx:
        //      0=FOR, 1=PA, 2=(decl|expr), 3=condicion, 4=PYC, 5=expresion, 6=PC, 7=instruccion
        //    => ctx.getChild(5) => la expresion
        visit(ctx.getChild(5));

        // saltamos al inicio del bucle
        threeAddressCode.add("goto " + lblStart);

        // etiqueta para el final
        threeAddressCode.add(lblEnd + ":");
        return null;
    }

    /**
     * whileStmt : WHILE PA condicion PC instruccion ;
     * Similar al for.
     *   Lstart:
     *     if cond != 0 goto Lbody
     *     goto Lend
     *   Lbody:
     *     visit instruccion
     *     goto Lstart
     *   Lend:
     */
    @Override
    public String visitWhileStmt(TrabajoFinalParser.WhileStmtContext ctx) {
        String lblStart = newLabel();
        String lblBody = newLabel();
        String lblEnd = newLabel();

        threeAddressCode.add(lblStart + ":");
        // condición
        String condTemp = visit(ctx.condicion());
        threeAddressCode.add("if " + condTemp + " != 0 goto " + lblBody);
        threeAddressCode.add("goto " + lblEnd);

        // cuerpo
        threeAddressCode.add(lblBody + ":");
        visit(ctx.instruccion());
        threeAddressCode.add("goto " + lblStart);

        threeAddressCode.add(lblEnd + ":");
        return null;
    }

    /**
     * returnStmt : RETURN expresion? PYC ;
     * Generamos "return <expr>" si hay expresión,
     * o "return" si es void.
     */
    @Override
    public String visitReturnStmt(TrabajoFinalParser.ReturnStmtContext ctx) {
        if (ctx.expresion() != null) {
            String rExpr = visit(ctx.expresion());
            threeAddressCode.add("return " + rExpr);
        } else {
            threeAddressCode.add("return");
        }
        return null;
    }

    /**
     * BREAK PYC
     * Aquí hay que saltar a la salida del bucle. Se suele requerir guardar
     * en una pila el label del bucle actual. Para un ejemplo simple,
     * pondremos un comentario indicando 'break' no resuelto.
     */

    // ------------------------------------------------------------------------
    //   EXPRESIONES, TÉRMINOS, FACTORES, CONDICIONES
    // ------------------------------------------------------------------------

    /**
     * condicion : expresion comparador expresion ;
     * Un if typical en 3AC es: if <temp> goto label
     * Donde <temp> es una comparación "tX = left <op> right".
     * Retornamos ese temp.
     */
    @Override
    public String visitCondicion(TrabajoFinalParser.CondicionContext ctx) {
        String left = visit(ctx.expresion(0));
        String right = visit(ctx.expresion(1));
        String op = ctx.comparador().getText(); // <, >, <=, >=, ==, !=

        // Generamos un temp booleano "tX = (left op right)"
        // En 3 direcciones seria como:
        //   tX = left <op> right
        // y luego "if tX != 0 goto (lo que sea)"
        // (significa que se cumple la comparación).
        String temp = newTemp();
        threeAddressCode.add(temp + " = " + left + " " + op + " " + right);
        return temp; // devolvemos la variable temporal booleana
    }

    /**
     * expresion : term ((MAS | MENOS) term)* ;
     * Generamos código para cada operación binaria.
     * Retornamos la ubicación (un temp) donde está el resultado.
     */
    @Override
    public String visitExpresion(TrabajoFinalParser.ExpresionContext ctx) {
        // Obtenemos el resultado del primer termino
        String result = visit(ctx.term(0));

        // Si hay mas terminos, procesamos uno por uno con el operador
        int n = ctx.term().size();
        int indexOp = 1;
        for (int i = 1; i < n; i++) {
            // El operador es ctx.getChild(2*i - 1)
            // o podemos buscar en ctx.MAS(i-1), ctx.MENOS(i-1)
            // mas facil: ctx.getChild(...) o ctx.MAS(i-1) != null
            String op = ctx.getChild(2*i - 1).getText(); // + o -

            String right = visit(ctx.term(i));
            String t = newTemp();
            threeAddressCode.add(t + " = " + result + " " + op + " " + right);
            result = t;
        }
        return result;
    }

    /**
     * term : factor ((MULT | DIV) factor)* ;
     * Parecido a expresion, pero con * y /.
     */
    @Override
    public String visitTerm(TrabajoFinalParser.TermContext ctx) {
        String result = visit(ctx.factor(0));
        int n = ctx.factor().size();
        for (int i = 1; i < n; i++) {
            String op = ctx.getChild(2*i - 1).getText(); // * o /
            String right = visit(ctx.factor(i));
            String t = newTemp();
            threeAddressCode.add(t + " = " + result + " " + op + " " + right);
            result = t;
        }
        return result;
    }

    /**
     * factor :
     *   - NUMERO
     *   - ID
     *   - STRING_LITERAL
     *   - PA expresion PC
     *   - incremento
     */
    @Override
    public String visitFactor(TrabajoFinalParser.FactorContext ctx) {
        // NUMERO
        if (ctx.NUMERO() != null) {
            return ctx.NUMERO().getText();
        }
        // ID
        else if (ctx.ID() != null) {
            return ctx.ID().getText();
        }
        // STRING_LITERAL
        else if (ctx.STRING_LITERAL() != null) {
            // Retornamos la cadena tal cual,
            // en 3AC a veces lo almacenamos en un temporal
            String literal = ctx.STRING_LITERAL().getText();
            // literal incluye las comillas, ejemplo: "hola"
            // Lo devolvemos directamente
            return literal;
        }
        // (expresion)
        else if (ctx.expresion() != null) {
            return visit(ctx.expresion());
        }
        // incremento: ID++ o ID--
        else if (ctx.incremento() != null) {
            return visit(ctx.incremento());
        }
        // Caso no contemplado
        return "??factor??";
    }

    // ------------------------------------------------------------------------
    //   MÉTODOS AUXILIARES
    // ------------------------------------------------------------------------

    /**
     * Devuelve el listado de instrucciones en tres direcciones.
     */
    public List<String> getThreeAddressCode() {
        return threeAddressCode;
    }

    /**
     *  realiza optimizaciones simples
     */
    public void optimizeCode() {
        // Mapa para propagación de constantes:
        // Guarda la variable -> valor constante (si lo tiene),
        // o null si no es constante conocido
        Map<String, String> constantValues = new HashMap<>();

        // Mapa para eliminación de subexpresiones repetidas:
        // Expresión normalizada (por ejemplo "10+2") -> variable (por ejemplo "t4")
        // Si se repite la misma expresión, se reutiliza la variable anterior.
        Map<String, String> commonSubexpr = new HashMap<>();

        // Nueva lista de lineas optimizadas
        List<String> optimized = new ArrayList<>();

        for (String line : threeAddressCode) {
            // Asumimos que cada línea es del tipo "left = right"
            // Ej: "t1 = 3", "t2 = t1 + 2", "a = t2", etc.
            String[] parts = line.split("=");
            if (parts.length != 2) {
                // Si no cumple el patrón, la dejamos igual
                optimized.add(line);
                continue;
            }

            String leftVar = parts[0].trim();           // Ej: "t1"
            String rightExpr = parts[1].trim();         // Ej: "3", "t1 + 2"

            // Intentamos parsear la parte derecha para ver si es:
            //    - variable sola (Ej: "t1")
            //    - constante sola (Ej: "3")
            //    - operación binaria (Ej: "t1 + 2")

            // Ver si es del tipo "X op Y"
            String op = null;
            String operand1 = null;
            String operand2 = null;

            // Intentaremos un split rápido por espacio.
            // Ej: "t1 + 2" -> ["t1", "+", "2"]
            String[] tokens = rightExpr.split("\\s+");
            if (tokens.length == 1) {
                // Caso: algo como "3" o "t1"
                operand1 = tokens[0];
            } else if (tokens.length == 3) {
                // Caso: "t1 + 2"
                operand1 = tokens[0];
                op = tokens[1];   // "+", "-", "*", "/"
                operand2 = tokens[2];
            } else {
                // No manejamos casos más complejos
                optimized.add(line);
                continue;
            }

            // Propagación de constantes
            // Si operand1 es una variable y está en constantValues, lo sustituimos.
            String val1 = operand1;
            if (constantValues.containsKey(operand1)) {
                String knownConst = constantValues.get(operand1);
                if (knownConst != null) {
                    val1 = knownConst;  // Sustituimos operand1 por su valor
                }
            }
            //  Si operand2 existe y es una variable con valor constante, lo sustituimos.
            String val2 = operand2;
            if (operand2 != null && constantValues.containsKey(operand2)) {
                String knownConst2 = constantValues.get(operand2);
                if (knownConst2 != null) {
                    val2 = knownConst2;
                }
            }

            // Si op != null, es una operación binaria: "leftVar = val1 op val2"
            // No se pudo hacer la evaluación completa (folding) de constantes, pero sí la propagación
            String newLine;
            if (op != null) {
                if (isNumeric(val1) && isNumeric(val2)) {
                    // Realizamos la operación en tiempo de compilación
                    double num1 = Double.parseDouble(val1);
                    double num2 = Double.parseDouble(val2);
                    double result = 0.0;
                    switch (op) {
                        case "+": result = num1 + num2; break;
                        case "-": result = num1 - num2; break;
                        case "*": result = num1 * num2; break;
                        case "/":
                            // si num2 == 0? manejamos error o lo dejamos
                            result = num1 / num2;
                            break;
                        default:
                            // Operador no reconocido => no optimizamos
                            newLine = leftVar + " = " + val1 + " " + op + " " + val2;
                            optimized.add(newLine);
                            continue;
                    }
                    // Convertimos a int si es entero
                    if ((result == Math.floor(result)) && !Double.isInfinite(result)) {
                        int intResult = (int) result;
                        newLine = leftVar + " = " + intResult;
                        // Registramos que leftVar es constante
                        constantValues.put(leftVar, String.valueOf(intResult));
                    } else {
                        newLine = leftVar + " = " + result;
                        // Registramos que leftVar es constante
                        constantValues.put(leftVar, String.valueOf(result));
                    }
                } else {
                    // No se pudo hacer folding completo, pero sí la propagación
                    // => line: leftVar = val1 op val2
                    String expr = val1 + " " + op + " " + val2;

                    // Chequeamos subexpresión repetida
                    if (commonSubexpr.containsKey(expr)) {
                        // Significa que ya existe "temp = val1 op val2"
                        // Reusamos la variable en lugar de recalcular
                        String existingVar = commonSubexpr.get(expr);
                        // newLine "leftVar = existingVar"
                        newLine = leftVar + " = " + existingVar;

                        // Si existingVar tiene valor constante, lo propagamos
                        if (constantValues.containsKey(existingVar)) {
                            constantValues.put(leftVar, constantValues.get(existingVar));
                        } else {
                            constantValues.put(leftVar, null);
                        }
                    } else {
                        // Nueva subexpresión => guardarla
                        newLine = leftVar + " = " + expr;
                        commonSubexpr.put(expr, leftVar);

                        // leftVar no es necesariamente una constante
                        constantValues.put(leftVar, null);
                    }
                }
                optimized.add(newLine);

            } else {
                // op == null => Asignación simple: "leftVar = val1"

                //  - Si val1 es un número, leftVar -> es constante
                //  - Si val1 es una variable con valor nulo, leftVar también nulo

                if (isNumeric(val1)) {
                    // leftVar = <const>
                    newLine = leftVar + " = " + val1;
                    constantValues.put(leftVar, val1);
                } else {
                    // leftVar = <otraVar> / literal no numérico
                    newLine = leftVar + " = " + val1;

                    // Si la otraVar es un string no numérico, no es una constante
                    // Si la otraVar es un var con un valor en constantValues (Ej: "10"), lo propagamos
                    if (constantValues.containsKey(val1)) {
                        constantValues.put(leftVar, constantValues.get(val1));
                    } else {
                        constantValues.put(leftVar, null);
                    }
                }

                optimized.add(newLine);
            }
        }

        // Reemplazamos la lista original por la optimizada
        threeAddressCode.clear();
        threeAddressCode.addAll(optimized);
    }

    /**
     * Método auxiliar que dice si una string es un número
     */
    private boolean isNumeric(String s) {
        if (s == null) return false;
        try {
            Double.parseDouble(s);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}

