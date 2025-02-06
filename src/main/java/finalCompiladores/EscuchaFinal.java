package finalCompiladores;

import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.tree.TerminalNode;
import tpDos.*;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class EscuchaFinal extends TrabajoFinalBaseListener {
    private TablaSimbolos tablaSimbolos;

    // Trabajamos por separados los errores porque se nos hizo lio :)
    private StringBuilder errors = new StringBuilder();
    private StringBuilder errorSintactico = new StringBuilder();

    // Pila de brackets para '{', '(', '[' etc.
    private Stack<LlavesItem> bracketStack = new Stack<>();
    private List<Contexto> contextosEliminados = new ArrayList<>();
    private boolean nextBloqueEsCuerpoFuncion = false;


    /**
     * Constructor: creamos la tabla de símbolos e iniciamos
     * un contexto global (índice 0).
     */
    public EscuchaFinal() {
        this.tablaSimbolos = TablaSimbolos.getInstance();
    }

    public TablaSimbolos getTablaSimbolos() {
        return tablaSimbolos;
    }

    public String getErrors() {
        return errors.toString();
    }

    public String getErrorSintactico() {
        return errorSintactico.toString();
    }

    /**
     * Control balance de llaves, corchetes y paréntesis.
     */
    @Override
    public void enterPrograma(TrabajoFinalParser.ProgramaContext ctx) {
        // Creamos un contexto global para todo el programa
        this.tablaSimbolos.addContexto();

    }

    // -------------------------------------------------------------------------
    // CONTROL FINAL DEL PROGRAMA
    // -------------------------------------------------------------------------

    /**
     * Control balance de llaves, corchetes y paréntesis.
     */
    @Override
    public void exitPrograma(TrabajoFinalParser.ProgramaContext ctx) {
        while (!bracketStack.isEmpty()) {
            LlavesItem leftover = bracketStack.pop();
            errors.append("Error: Balance incorrecto - No se cerró '")
                    .append(leftover.getLlave())
                    .append("' abierto en la línea ")
                    .append(leftover.getLinea()).append("\n");
        }
        checkUnusedSymbols(tablaSimbolos.getContextoActual());
        Contexto global = tablaSimbolos.getContextoActual();
        contextosEliminados.add(global);
        tablaSimbolos.delContexto();
        // Escribimos la tabla de símbolos a partir de los contextos eliminados (tiene error)
        escribirContextosEliminadosEnArchivo("output/tabla_simbolos.txt");
    }

    // -------------------------------------------------------------------
    //  CONTROL DE BLOQUES Y CONTEXTOS
    // -------------------------------------------------------------------

    /**
     * Entramos a un bloque { ... }, agregamos un nuevo contexto en la tabla de símbolos.
     */
    @Override
    public void enterBloque(TrabajoFinalParser.BloqueContext ctx) {
        tablaSimbolos.addContexto();
        Contexto currentCtx = tablaSimbolos.getContextoActual();
        String blockType = determinarTipoBloque(ctx);
        currentCtx.setContextType(blockType);
    }

    /**
     * Salimos del bloque, borramos Contexto.
     * Revisar si hay variables sin usar en este contexto
     */
    @Override
    public void exitBloque(TrabajoFinalParser.BloqueContext ctx) {
        Contexto contextoFuncion = tablaSimbolos.getContextoActual();
        contextosEliminados.add(contextoFuncion);

        // Revisar si hay variables sin usar en este contexto
        checkUnusedSymbols(tablaSimbolos.getContextoActual());

        // Cerramos el Contexto
        tablaSimbolos.delContexto();
    }


    // -------------------------------------------------------------------------
    //  CONTROL DE LLAVES, PARÉNTESIS Y CORCHETES (visitTerminal)
    // -------------------------------------------------------------------------

    /**
     * Reconocimiento de bloques de código delimitados por llaves y controlar balance
     * de apertura y cierre.
     * Balance de llaves, corchetes y paréntesis.
     * Revisamos cada símbolo terminal: {, }, (, ), [, ] y controlamos balance
     * con la pila bracketStack.
     */
    @Override
    public void visitTerminal(TerminalNode node) {
        int t = node.getSymbol().getType();
        int line = node.getSymbol().getLine();

        switch (t) {
            case TrabajoFinalLexer.LLA: // '{'
                bracketStack.push(new LlavesItem('{', line));
                break;
            case TrabajoFinalLexer.LLC: // '}'
                checkAndPop('}', '{', line);
                break;

            case TrabajoFinalLexer.PA:  // '('
                bracketStack.push(new LlavesItem('(', line));
                break;
            case TrabajoFinalLexer.PC:  // ')'
                checkAndPop(')', '(', line);
                break;

            case TrabajoFinalLexer.CORA: // '['
                bracketStack.push(new LlavesItem('[', line));
                break;
            case TrabajoFinalLexer.CORC: // ']'
                checkAndPop(']', '[', line);
                break;
        }
    }

    /**
     * Método auxiliar que chequea si la pila no está vacía
     * y si coincide la llave de apertura con la de cierre.
     */
    private void checkAndPop(char closing, char expectedOpening, int lineCierre) {
        if (bracketStack.isEmpty()) {
            errors.append("Error: Se encontró '").append(closing)
                    .append("' en línea ").append(lineCierre)
                    .append(" pero no había '").append(expectedOpening)
                    .append("' que lo abra.\n");
        } else {
            LlavesItem top = bracketStack.pop();
            if (top.getLlave() != expectedOpening) {
                errors.append("Error: Se encontró '").append(closing)
                        .append("' en línea ").append(lineCierre)
                        .append(" pero en la pila había '").append(top.getLlave())
                        .append("' abierto en línea ").append(top.getLinea())
                        .append(".\n");
            }
        }
    }

    // -------------------------------------------------------------------------
    //  CONTROL DE FUNCIONES
    // -------------------------------------------------------------------------

    /**
     * funcion : tipoDato ID PA parametros? PC bloque ;
     */
    @Override
    public void enterFuncion(TrabajoFinalParser.FuncionContext ctx) {
        tablaSimbolos.addContexto();
        // Nombre y tipo
        String funcName = ctx.ID().getText();
        String tipoFuncStr = ctx.tipoDato().getText().toUpperCase();

        // Revisamos si el enum TipoDato tiene 'VOID'
        TipoDato funcType;
        try {
            funcType = TipoDato.valueOf(tipoFuncStr);
        } catch (IllegalArgumentException ex) {
            // Para Manejar Datos que no estan en el enum (Probablemnte se pueda borrar)
            if ("VOID".equals(tipoFuncStr)) {
                // Manejo especial para void, o lo agregas a tu enum
                funcType = TipoDato.VOID;
            } else {
                errors.append("Error Semántico: Tipo de función desconocido '")
                        .append(tipoFuncStr).append("' en línea ")
                        .append(ctx.start.getLine()).append("\n");
                funcType = null; // o te sales
            }
        }

        // 3) Creamos un Identificador para la función y lo guardamos en la tabla
        if (funcType != null) {
            Identificador funcIdent = new Identificador(
                    funcName,
                    funcType,
                    false, // una función no se "inicializa" propiamente
                    true   // isFuncion = true (si tu Identificador lo permite)
            );
            // Opcional: Ver si ya existe
            if (tablaSimbolos.buscarIdentificadorLocal(funcName) != null) {
                errors.append("Error Semántico: Función '").append(funcName)
                        .append("' ya existe en este contexto (línea ")
                        .append(ctx.start.getLine()).append(")\n");
            } else {
                tablaSimbolos.addIdentificador(funcIdent);
            }
        }

        // 4) Si hay parámetros, los registramos en la tabla como variables
        //    inicializadas = true
        if (ctx.parametros() != null) {
            for (TrabajoFinalParser.ParametroContext pCtx : ctx.parametros().parametro()) {
                String paramName = pCtx.ID().getText();
                String paramTypeStr = pCtx.tipoDato().getText().toUpperCase();
                TipoDato paramType = null;
                try {
                    paramType = TipoDato.valueOf(paramTypeStr);
                } catch (IllegalArgumentException e) {
                    errors.append("Error Semántico: Tipo de dato de parámetro desconocido '")
                            .append(paramTypeStr).append("' en línea ")
                            .append(ctx.start.getLine()).append("\n");
                }
                if (paramType != null) {
                    // M arcamos 'inicializada = true' porque un parámetrosiempre llega con un valor
                    Identificador paramIdent = new Identificador(paramName, paramType, true, false);

                    // Verificamos si ya existe en este contexto
                    if (tablaSimbolos.buscarIdentificadorLocal(paramName) != null) {
                        errors.append("Error Semántico: El parámetro '").append(paramName)
                                .append("' ya existe en este contexto (línea ")
                                .append(ctx.start.getLine()).append(")\n");
                    } else {
                        tablaSimbolos.addIdentificador(paramIdent);
                    }
                }
            }
        }

        // 5) Chequeo especial si la función se llama 'main'
        if ("main".equals(funcName)) {
            //  Se puede verificar que sea 'void' y que no tenga parámetros, etc.
            if (funcType != TipoDato.VOID) {
                errors.append("Advertencia: Se esperaba 'void main()', pero se detectó otro tipo (línea ")
                        .append(ctx.start.getLine()).append(")\n");
            }
            //Par main forzamos cero parámetros es decir no contemplamos p/ej String args java
            if (ctx.parametros() != null && !ctx.parametros().parametro().isEmpty()) {
                errors.append("Advertencia: 'main' no debería tener parámetros en este lenguaje (línea ")
                        .append(ctx.start.getLine()).append(")\n");
            }
        }
    }

    /**
     * Al salir de la función, cerramos el contexto de la función.
     */
    @Override
    public void exitFuncion(TrabajoFinalParser.FuncionContext ctx) {
        // Terminó el bloque de la función (ya paso por exitBloque),
        // como usamos un contexto disitinto para la funcion lo cerramos aca.
        checkUnusedSymbols(tablaSimbolos.getContextoActual());

        Contexto contextoFuncion = tablaSimbolos.getContextoActual();
        contextosEliminados.add(contextoFuncion);


        // cierra el contexto de la función
        tablaSimbolos.delContexto();
    }

    /**
     * Verificación de la correcta utilización del punto y coma para la terminación de
     * instrucciones.
     */
    @Override
    public void exitDeclaracion(TrabajoFinalParser.DeclaracionContext ctx) {
        // Obtenemos el token real que corresponde a PYC (;)
        Token puntoYcomaToken = ctx.PYC().getSymbol();

        // Segun google si getTokenIndex() < 0, significa que ANTLR realizó error recovery
        // e insertó artificialmente un token <missing ';'> (no lo encontró realmente en el input).
        if (puntoYcomaToken.getTokenIndex() < 0) {
            errorSintactico.append("Error Sintáctico: Falta ';' al final de la declaración (línea ")
                    .append(ctx.start.getLine()).append(")\n");
        }

        // Convertimos la palabra reservada del tipo a nuestro enum
        String tipoTexto = ctx.tipoDato().getText().toUpperCase();
        TipoDato tipoDato;
        try {
            tipoDato = TipoDato.valueOf(tipoTexto);
        } catch (IllegalArgumentException ex) {
            errors.append("Error Semántico: Tipo de dato desconocido '")
                    .append(tipoTexto).append("' en línea ")
                    .append(ctx.start.getLine()).append("\n");
            return; // Salimos si el tipo no es válido
        }

        // Registramos cada variable declarada
        for (TrabajoFinalParser.VariableContext var : ctx.listaVariables().variable()) {
            if (var.ID() == null) {
                errorSintactico.append("Error Sintáctico: Falta nombre de la variable en la declaración (línea ")
                        .append(ctx.start.getLine())
                        .append(")\n");
                continue; // o return, según prefieras
            }

            String nombre = var.ID().getText();
            boolean inicializada = (var.IGUAL() != null);
            Identificador identificador = new Identificador(nombre, tipoDato, inicializada, false);

            // Verificamos si ya existe en este contexto
            if (tablaSimbolos.buscarIdentificadorLocal(nombre) != null) {
                errors.append("Error Semántico: El identificador '")
                        .append(nombre)
                        .append("' ya existe en este contexto (línea ")
                        .append(ctx.start.getLine()).append(")\n");
            } else {
                // Lo agregamos a la tabla
                tablaSimbolos.addIdentificador(identificador);
            }
        }
    }

    @Override
    public void exitAsignacion(TrabajoFinalParser.AsignacionContext ctx) {
        // Caso 1: ID = expresion ;
        if (ctx.ID() != null) {
            String nombre = ctx.ID().getText();
            Identificador identificador = tablaSimbolos.buscarIdentificador(nombre);
            if (identificador == null) {
                errors.append("Error Semántico: Uso de identificador no declarado '")
                        .append(nombre).append("' en línea ")
                        .append(ctx.start.getLine()).append("\n");
            } else {
                // Marcamos que se usa e inicializa
                identificador.setUtilizada(true);
                identificador.setInicializada(true);
            }
        }
        // Caso 2: incremento PYC
        // Se maneja en exitIncrementoOp (porque la subregla es 'incremento : ... #IncrementoOp')

        if (ctx.PYC() == null) {
            errorSintactico.append("Error Sintáctico: Falta ';' al final de la asignación (línea ")
                    .append(ctx.start.getLine()).append(")\n");
        }
    }

    @Override
    public void exitExpresion(TrabajoFinalParser.ExpresionContext ctx) {
        // Aquí se podría hacer chequeos más robusto
        // No Pide la consigna pero ilustramos un chequeo básico:
        if (ctx.term().size() > 1) {
            // Si hay más de un término, hay operación con MAS o MENOS
            // Podrías chequear compatibilidad de tipos entre cada par de terminos
            // Ejemplo de idea (no es un approach 100% completo):
            //   for i in 0 .. (nTerms-2):
            //       TipoDato tLeft = evaluateTermType(ctx.term(i));
            //       TipoDato tRight = evaluateTermType(ctx.term(i+1));
            //       if !areTypesCompatibleForArithmetic(tLeft, tRight) -> error
        }
    }

    private TipoDato evaluateExpressionType(TrabajoFinalParser.TermContext ctx) {
        if (ctx.factor() != null) {
            return evaluateFactorType(ctx.factor(0));
        }
        // asumimos que el tipo de una operación binaria es el tipo de su primer factor
        return evaluateFactorType(ctx.factor(0));
    }

    private TipoDato evaluateFactorType(TrabajoFinalParser.FactorContext ctx) {
        if (ctx.NUMERO() != null) {
            String number = ctx.NUMERO().getText();
            return number.contains(".") ? TipoDato.FLOAT : TipoDato.INT;
        } else if (ctx.ID() != null) {
            String id = ctx.ID().getText();
            Identificador identificador = tablaSimbolos.buscarIdentificador(id);
            return identificador != null ? identificador.getTipoDato() : null;
        } else if (ctx.expresion() != null) {
            return evaluateExpressionType(ctx.expresion().term(0));
        }
        return null; // Manejo de casos no contemplados
    }

    @Override
    public void exitTerm(TrabajoFinalParser.TermContext ctx) {
        // Similar a exitExpresion, si hay varios 'factor', es MULT o DIV
        // Podriamos checker
    }

    @Override
    public void exitIncrementoOp(TrabajoFinalParser.IncrementoOpContext ctx) {
        // Manejo de ID++ o ID--
        String nombre = ctx.ID().getText();
        Identificador identificador = tablaSimbolos.buscarIdentificador(nombre);
        if (identificador == null) {
            errors.append("Error Semántico: Uso de identificador no declarado '")
                    .append(nombre).append("' en línea ")
                    .append(ctx.start.getLine()).append("\n");
        } else {
            // Es un uso y, de alguna forma, también cuenta como inicializado
            identificador.setUtilizada(true);
            identificador.setInicializada(true);
        }
    }

    @Override
    public void exitFactor(TrabajoFinalParser.FactorContext ctx) {
        // Chequeo semántico de factor
        if (ctx.ID() != null) {
            String nombre = ctx.ID().getText();
            Identificador identificador = tablaSimbolos.buscarIdentificador(nombre);
            if (identificador == null) {
                errors.append("Error Semántico: Uso de variable no declarada '")
                        .append(nombre).append("' en línea ")
                        .append(ctx.start.getLine()).append("\n");
            } else {
                // Marcar como utilizada. Revisar si está inicializada
                identificador.setUtilizada(true);
                // Verificamos si está inicializada antes de usarla
                checkInitialization(identificador, ctx.start.getLine());

                if (!identificador.isInicializada()) {
                    errors.append("Error Semántico: Variable '")
                            .append(nombre)
                            .append("' usada sin inicializar (línea ")
                            .append(ctx.start.getLine()).append(")\n");
                }
            }
        }
        // Si es un número o string literal, no hace falta nada especial
        // Si es una subexpresión (PA expresion PC) ya se validó en su exitExpresion
        // Si es incremento, se maneja en exitIncrementoOp
    }

    private void checkInitialization(Identificador identificador, int line) {
        if (!identificador.isInicializada()) {
            errors.append("Error: Variable '").append(identificador.getNombre()).append("' utilizada sin haber sido inicializada en línea ").append(line).append("\n");
        }
    }

    private void checkUnusedSymbols(Contexto contexto) {
        for (Map.Entry<String, Identificador> entry : contexto.getIdentificadores().entrySet()) {
            Identificador identificador = entry.getValue();
            if (!identificador.isUtilizada()) {
                errors.append("Advertencia: '")
                        .append(identificador.getNombre())
                        .append("' fue declarado pero no utilizado en este contexto.\n");
            }
        }
    }

    private void escribirContextosEliminadosEnArchivo(String nombreArchivo) {
        File directorio = new File("output/");
        if (!directorio.exists()) {
            if (!directorio.mkdirs()) {
                System.err.println("Error: No se pudo crear el directorio 'output/'.");
                return;
            }
        }

        // Clono
        List<Contexto> sortedList = new ArrayList<>(contextosEliminados);

        // 2) Ordeno
        sortedList.sort(Comparator.comparingInt(Contexto::getId));

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(nombreArchivo))) {
            writer.write("=== Contextos Eliminados ===\n");

            // 3) Imprimir en orden
            for (Contexto contexto : sortedList) {
                writer.write("Contexto ID=" + contexto.getId()
                        + " (" + contexto.getContextType() + ")\n");

                for (Map.Entry<String, Identificador> e : contexto.getIdentificadores().entrySet()) {
                    writer.write("    " + e.getKey() + ": " + e.getValue() + "\n");
                }
                writer.write("\n");
            }
            writer.write("================================\n");
            System.out.println("Contextos eliminados escritos exitosamente en " + nombreArchivo);

        } catch (IOException e) {
            System.err.println("Error al escribir los contextos eliminados en el archivo: " + e.getMessage());
        }
    }

    private String determinarTipoBloque(TrabajoFinalParser.BloqueContext ctx) {

        ParserRuleContext current = ctx.getParent();

        while (current != null) {
            // 1) ¿Es una función?
            if (current instanceof TrabajoFinalParser.FuncionContext) {
                // nombre de la función
                TrabajoFinalParser.FuncionContext fctx = (TrabajoFinalParser.FuncionContext) current;
                String funcName = fctx.ID().getText();
                return "Cuerpo funcion: " + funcName;
            }

            // 2) ¿Es un if?
            if (current instanceof TrabajoFinalParser.IfStmtContext) {
                return "Bloque IF:";
            }

            // 3) ¿Es un for?
            if (current instanceof TrabajoFinalParser.ForStmtContext) {
                return "Bloque FOR";
            }

            // 4) ¿Es un while?
            if (current instanceof TrabajoFinalParser.WhileStmtContext) {
                return "Bloque WHILE";
            }

            // 5) Si no es ninguna de las anteriores, subimos un nivel
            current = current.getParent();
        }

        // Si nunca encontramos un if/for/while/funcion, es un bloque genérico
        return "Bloque x";
    }
}
