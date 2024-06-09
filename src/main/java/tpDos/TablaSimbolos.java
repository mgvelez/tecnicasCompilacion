package tpDos;

import java.util.*;

public class TablaSimbolos {
    private List<Contexto> contextos;
    public TablaSimbolos() {
        this.contextos = new ArrayList<>();
        this.contextos.add(new Contexto());
    }

    public void addContexto() {
        contextos.add(new Contexto());
    }

    public void delContexto() {
        if (contextos.size() > 1) {
            contextos.remove(contextos.size() - 1);
        }
    }

    public Contexto getContextoActual() {
        return contextos.get(contextos.size() - 1);
    }

    public void addIdentificador(Identificador identificador) {
        if (!contextos.isEmpty()) {
            Contexto contextoActual = contextos.get(contextos.size() - 1);
            contextoActual.addIdentificador(identificador.getNombre(),identificador);
        }
    }

    public Identificador buscarIdentificador(String nombre) {
        for (int i = contextos.size() - 1; i >= 0; i--) {
            Identificador ident = contextos.get(i).getIdentificador(nombre);
            if (ident != null) {
                return ident;
            }
        }
        return null;
    }

    public Identificador buscarIdentificadorLocal(String nombre) {
        if (!contextos.isEmpty()) {
            return contextos.get(contextos.size() - 1).getIdentificador(nombre);
        }
        return null;
    }


}
