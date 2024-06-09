package tpDos;

import tpuno.TpUnoBaseListener;
import tpuno.TpUnoParser;

import java.util.Map;

public class EscuchaTpUno extends TpUnoBaseListener {

    private Integer nodos = 0;
    private Integer hojas = 0;

    private TablaSimbolos tablaSimbolos;

    public EscuchaTpUno() {
        this.tablaSimbolos = new TablaSimbolos();
    }


    @Override
    public void enterPrograma(TpUnoParser.ProgramaContext ctx) {
        tablaSimbolos.addContexto();
    }

    @Override
    public void exitPrograma(TpUnoParser.ProgramaContext ctx) {
        tablaSimbolos.delContexto();
    }

    @Override
    public String toString() {
        return "Escucha [nodos=" + nodos + ", hojas=" + hojas + "]";
    }
}
