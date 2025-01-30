package tpDos;

import java.util.HashMap;
import java.util.Map;

public class Contexto {
    private Map<String, Identificador> identificadores = new HashMap<>();

    /**
     * Añade un identificador al contexto.
     * @param nombre El nombre del identificador.
     * @param identificador El objeto Identificador a añadir.
     */
    public void addIdentificador(String nombre, Identificador identificador) {
        identificadores.put(nombre, identificador);
    }

    /**
     * Recupera un identificador del contexto por su nombre.
     * @param nombre El nombre del identificador a buscar.
     * @return El Identificador asociado con el nombre, o null si no se encuentra.
     */
    public Identificador getIdentificador(String nombre) {
        return identificadores.get(nombre);
    }

    /**
     * Devuelve todos los identificadores en este contexto.
     * @return Un Map con todos los identificadores del contexto.
     */
    public Map<String, Identificador> getIdentificadores() {
        return identificadores;
    }


}
