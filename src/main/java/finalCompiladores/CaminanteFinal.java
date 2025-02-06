package finalCompiladores;

import org.antlr.v4.runtime.tree.ParseTree;
import tpDos.TablaSimbolos;

import java.util.*;

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

        threeAddressCode.add("if " + condTemp + " goto " + lblTrue); // Si la condición es verdadera, saltamos al bloque verdadero
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
        threeAddressCode.add("if " + condTemp + "goto " + lblBody);
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
        threeAddressCode.add("if " + condTemp + " goto " + lblBody);
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
        Map<String, String> constantValues = new HashMap<>();
        Map<String, String> tempVarMapping = new HashMap<>();
        Set<String> usedVariables = new HashSet<>();
        List<String> optimized = new ArrayList<>();

        // Identificar variables utilizadas en el código
        for (String line : threeAddressCode) {
            String[] parts = line.split("=");
            if (parts.length == 2) {
                String rightExpr = parts[1].trim();
                String[] tokens = rightExpr.split("[\\s+()*/-]");
                for (String token : tokens) {
                    if (!isNumeric(token) && !token.isEmpty()) {
                        usedVariables.add(token);
                    }
                }
            }
        }

        // Optimización del código
        for (String line : threeAddressCode) {
            String[] parts = line.split("=");
            if (parts.length != 2) {
                optimized.add(line);  // Se mantiene cualquier línea que no sea una asignación
                continue;
            }

            String leftVar = parts[0].trim();
            String rightExpr = parts[1].trim();

            // Si leftVar es un temporal ya optimizado, propagamos el valor
            if (tempVarMapping.containsKey(rightExpr)) {
                rightExpr = tempVarMapping.get(rightExpr);
            }

            // Evaluación de expresiones constantes
            rightExpr = evaluateConstantExpression(rightExpr, constantValues);

            // Eliminación de asignaciones redundantes
            if (leftVar.equals(rightExpr)) continue;

            // Eliminación de código muerto (si la variable no se usa)
            if (!usedVariables.contains(leftVar) && leftVar.startsWith("t")) continue;

            // Guardar en temporales o en la lista optimizada
            if (leftVar.startsWith("t")) {
                tempVarMapping.put(leftVar, rightExpr);
            } else {
                optimized.add(leftVar + " = " + rightExpr);
            }

            // Guardar constantes en variables no temporales
            if (!leftVar.startsWith("t") && isNumeric(rightExpr)) {
                constantValues.put(leftVar, rightExpr);
            }
        }

        // Reemplazar el código original con el optimizado
        threeAddressCode.clear();
        threeAddressCode.addAll(optimized);
    }

    // Evaluar expresiones constantes con propagación de constantes
    private String evaluateConstantExpression(String expr, Map<String, String> constantValues) {
        String[] tokens = expr.split("\\s+");
        if (tokens.length < 3) return expr;

        String operand1 = constantValues.getOrDefault(tokens[0], tokens[0]);
        String op = tokens[1];
        String operand2 = constantValues.getOrDefault(tokens[2], tokens[2]);

        if (isNumeric(operand1) && isNumeric(operand2)) {
            int result = evaluateExpression(Integer.parseInt(operand1), Integer.parseInt(operand2), op);
            return String.valueOf(result);
        }
        return expr;
    }

    // Evaluar operaciones aritméticas
    private int evaluateExpression(int operand1, int operand2, String op) {
        switch (op) {
            case "+": return operand1 + operand2;
            case "-": return operand1 - operand2;
            case "*": return operand1 * operand2;
            case "/": return (operand2 != 0) ? operand1 / operand2 : 0;
            default: return 0;
        }
    }

    // Comprobar si una cadena es numérica
    private boolean isNumeric(String str) {
        if (str == null || str.trim().isEmpty()) return false;
        try {
            Double.parseDouble(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }






}

