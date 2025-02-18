package tpDos;

import java.util.*;

public class TablaSimbolos {
    private static TablaSimbolos instance;
    private List<Contexto> contextos;
    private int nextContextId = 0;
    private TablaSimbolos() {
        this.contextos = new ArrayList<>();
    }

    // Singleton pedido por el profe
    public static synchronized TablaSimbolos getInstance() {
        if (instance == null) {
            instance = new TablaSimbolos();
        }
        return instance;
    }

    /**
     * Añade un nuevo contexto al tope de la pila de contextos.
     */
    public void addContexto() {
        Contexto nuevo = new Contexto(nextContextId);
        nextContextId++;
        contextos.add(nuevo);
    }

    /**
     * Elimina el contexto actual si no es el global.
     */
    public void delContexto() {
        if (contextos.size() > 1) {
            contextos.remove(contextos.size() - 1);
        }
    }

    /**
     * Obtiene el contexto actual (el de más arriba en la pila).
     * @return El contexto actual.
     */
    public Contexto getContextoActual() {
        return contextos.get(contextos.size() - 1);
    }

    /**
     * Añade un identificador al contexto actual.
     * @param identificador El identificador a añadir.
     * @throws IllegalArgumentException si el identificador ya existe en el contexto actual.
     */
    public void addIdentificador(Identificador identificador) {
        //System.out.println("Añadiendo identificador: " + identificador.getNombre());
        Contexto contextoActual = getContextoActual();
        if (contextoActual.getIdentificador(identificador.getNombre()) != null) {
            System.out.println("Identificador ya existe: " + identificador.getNombre());
            throw new IllegalArgumentException("El identificador '" + identificador.getNombre() + "' ya existe en el contexto actual.");
        }
        contextoActual.addIdentificador(identificador.getNombre(), identificador);
       // System.out.println("Identificador añadido: " + identificador.getNombre());
    }

    /**
     * Busca un identificador en todos los contextos, comenzando por el más reciente.
     * @param nombre El nombre del identificador a buscar.
     * @return El Identificador si se encuentra, null en caso contrario.
     */
    public Identificador buscarIdentificador(String nombre) {
        for (int i = contextos.size() - 1; i >= 0; i--) {
            Identificador ident = contextos.get(i).getIdentificador(nombre);
            if (ident != null) {
                return ident;
            }
        }
        return null;
    }

    /**
     * Busca un identificador solo en el contexto actual.
     * @param nombre El nombre del identificador a buscar en el contexto actual.
     * @return El Identificador si se encuentra en el contexto actual, null en caso contrario.
     */
    public Identificador buscarIdentificadorLocal(String nombre) {
        return getContextoActual().getIdentificador(nombre);
    }

    /**
     * Imprime TODOS los contextos, uno debajo del otro.
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("=== Tabla de Símbolos ===\n");
        for (Contexto c : contextos) {
            sb.append("Contexto ID=")
                    .append(c.getId())
                    .append(": ")
                    .append(c.getIdentificadores().keySet())
                    .append("\n");
        }
        sb.append("========================\n");
        return sb.toString();
    }

}
