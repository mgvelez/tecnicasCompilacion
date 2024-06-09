package refactor;

import org.antlr.v4.runtime.tree.TerminalNode;
import tpDos.Contexto;
import tpDos.Identificador;
import tpDos.TablaSimbolos;
import tpDos.TipoDato;

import java.util.List;
import java.util.Map;

import static refactor.RefactorParser.COMA;

public class EscuchaRefactor extends RefactorBaseListener {

    private Integer nodos = 0;
    private Integer hojas = 0;

    private TablaSimbolos tablaSimbolos;

    public EscuchaRefactor() {
        this.tablaSimbolos = new TablaSimbolos();
    }

    @Override
    public void enterPrograma(RefactorParser.ProgramaContext ctx) {
        tablaSimbolos.addContexto();  // Ámbito global
    }

    @Override
    public void exitPrograma(RefactorParser.ProgramaContext ctx) {


        Contexto contexto = tablaSimbolos.getContextoActual();

        for (Map.Entry<String, Identificador> entry : contexto.getIdentificadores().entrySet()) {
            Identificador identificador = entry.getValue();
            if (!identificador.isUtilizada()) {
                System.err.println("Error Semántico - Advertencia: Variable '" + identificador.getNombre() + "' declarada pero no utilizada.");
            }
        }

        tablaSimbolos.delContexto();
        tablaSimbolos.delContexto();
    }


    @Override
    public void exitProgramaMain(RefactorParser.ProgramaMainContext ctx) {
        if (ctx.VOID() == null && ctx.tipoDato() == null) {
            System.err.println("Error: falta el tipo de retorno en la línea " + ctx.start.getLine());
        }
    }


    @Override
    public void exitDeclaracion(RefactorParser.DeclaracionContext ctx) {
        if (ctx.PYC() == null) {
            System.err.println("Error Sintactico: Falta punto y coma al final de la declaración en línea " + ctx.start.getLine());
        }
        if (ctx.listaIdent() != null) {
            List<TerminalNode> comas = ctx.listaIdent().getTokens(COMA);
            List<RefactorParser.IdentContext> ids = ctx.listaIdent().ident();

            if (comas.size() != ids.size() - 1) {
                System.err.println("Error de formato: Las comas en la declaración de variables no coinciden con el número de variables en línea " + ctx.getStart().getLine());
            } else {
                for (RefactorParser.IdentContext id : ids) {
                    boolean inicializada = ctx.IGUAL() != null;
                    Identificador nuevoIdentificador = new Identificador(id.ID().getText(), TipoDato.valueOf(ctx.tipoDato().getText().toUpperCase()), inicializada, false);
                    tablaSimbolos.addIdentificador(nuevoIdentificador);
                }
            }
        }

        if(ctx.ID() != null) {
            Identificador identificador = tablaSimbolos.buscarIdentificadorLocal(ctx.ID().getText());
            if (identificador != null) {
                System.err.println("Error Semántico: El identificador: " + ctx.ID().getText() + " ya existe. Error en la linea: " + ctx.start.getLine());
            } else {
                boolean inicializada = ctx.IGUAL() != null;
                Identificador nuevoIdentificador = new Identificador(ctx.ID().getText(), TipoDato.valueOf(ctx.tipoDato().getText().toUpperCase()), inicializada, false);
                tablaSimbolos.addIdentificador(nuevoIdentificador);
            }
        }

    }

    @Override
    public void exitExpresion(RefactorParser.ExpresionContext ctx) {
        if (ctx.ID() != null) {
            String id = ctx.ID().getText();
            if (tablaSimbolos.buscarIdentificador(id) == null) {
                System.err.println("Error Semántico: Uso de identificador no declarado '" + id + "' en la línea " + ctx.ID().getSymbol().getLine());
            }
        }
        if (ctx.expresion() != null) {
            checkInitialization(ctx);
        }
    }

    @Override
    public void exitAsignacion(RefactorParser.AsignacionContext ctx) {
        String missingPYCError = "<missing ';'>";
        String controlPYC = ctx.getText();
        if (controlPYC.contains(missingPYCError)) {
            System.err.println("Error Sintactico: Falta punto y coma al final de la declaración en línea " + ctx.start.getLine());
        }
        if (ctx.ID() != null) {
            String id = ctx.ID().getText();
            if (tablaSimbolos.buscarIdentificador(id) == null) {
                System.err.println("Error: Uso de identificador no declarado '" + id + "' en la línea " + ctx.ID().getSymbol().getLine());
            } else {
                if (ctx.IGUAL() != null) {
                    Identificador identificador = tablaSimbolos.buscarIdentificador(ctx.ID().getText());
                    identificador.setInicializada(true);
                    tablaSimbolos.addIdentificador(identificador);
                }
                TipoDato exprType = evaluateExpressionType(ctx.expresion());
                Identificador identificador = tablaSimbolos.buscarIdentificador(ctx.ID().getText());
                if (!identificador.getTipoDato().equals(exprType)) {
                    System.err.println("Error de tipo semánticos: No se puede asignar " + exprType + " a " + identificador.getTipoDato() + " en la línea " + ctx.getStart().getLine());
                }
            }
        }
    }

    private void checkInitialization(RefactorParser.ExpresionContext ctx) {

        if (ctx.NUMERO() == null && ctx.MAS() == null && ctx.MENOS() == null && ctx.MULT() == null && ctx.DIV() == null) {

            Identificador identificador = tablaSimbolos.buscarIdentificador(ctx.ID().getText());
            if (ctx.ID() != null && identificador != null) {
                if (!identificador.isInicializada()) {
                    System.err.println("Error: Variable '" + ctx.ID().getText() + "' utilizada sin haber sido inicializada en línea " + ctx.getStart().getLine());
                } else {
                    identificador.setUtilizada(true);
                }

            }

        }
    }

    private TipoDato evaluateExpressionType(RefactorParser.ExpresionContext ctx) {
        if (ctx.NUMERO() != null) {
            String number = ctx.NUMERO().getText();
            if (number.matches("\\d+")) {
                return TipoDato.INT;
            } else if (number.contains(".") && number.matches("\\d+\\.\\d*")) {
                return TipoDato.FLOAT; // float para cualquier decimal sin especificación
            } else if (number.contains(".") && number.matches("\\d+\\.\\d+f")) {
                return TipoDato.FLOAT; // float explícito, indicado por 'f' al final
            } else if (number.contains(".") && number.matches("\\d+\\.\\d*d")) {
                return TipoDato.DOUBLE; // double explícito, indicado por 'd' al final
            }
        }
        if (ctx.ID() != null) {
            Identificador identificador = tablaSimbolos.buscarIdentificador(ctx.ID().getText());
            if (identificador != null) {
                return identificador.getTipoDato();
            }
        }
        if (ctx.expresion().size() == 2) {
            TipoDato leftType = evaluateExpressionType(ctx.expresion(0));
            TipoDato rightType = evaluateExpressionType(ctx.expresion(1));
            if (leftType == TipoDato.DOUBLE || rightType == TipoDato.DOUBLE) {
                return TipoDato.DOUBLE;
            } else if (leftType == TipoDato.FLOAT || rightType == TipoDato.FLOAT) {
                return TipoDato.FLOAT;
            } else if (leftType == TipoDato.INT || rightType == TipoDato.INT) {
                return TipoDato.INT;
            }

            if (leftType == TipoDato.STRING || rightType == TipoDato.STRING) {
                return TipoDato.STRING;
            }

            if (leftType == TipoDato.CHAR && rightType == TipoDato.CHAR) {
                return TipoDato.CHAR;
            } else if (leftType == TipoDato.CHAR || rightType == TipoDato.CHAR) {
                return TipoDato.INT;
            }

        }
        return null;
    }


    @Override
    public void exitIfStmt(RefactorParser.IfStmtContext ctx) {
        String controlPA = ctx.getText();
        if (controlPA.contains("missing"))
            System.err.println("Error Sintactico: Falta Apertura Parentesis en línea " + ctx.start.getLine());
    }

    @Override
    public void exitForStmt(RefactorParser.ForStmtContext ctx) {
        String missingParentesisError = "<missing '('>";
        String controlPA = ctx.getText();
        if (controlPA.contains(missingParentesisError))
            System.err.println("Error Sintactico: Falta Apertura Parentesis en línea " + ctx.start.getLine());
    }

    @Override
    public void exitWhileStmt(RefactorParser.WhileStmtContext ctx) {
        String controlPA = ctx.getText();
        if (controlPA.contains("missing"))
            System.err.println("Error Sintactico: Falta Apertura Parentesis en línea " + ctx.start.getLine());

    }
}
