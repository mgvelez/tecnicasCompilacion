package tpDos;

import java.util.HashMap;
import java.util.Map;

public class Contexto {
    private Map<String, Identificador> identificadores = new HashMap<>();

    public void addIdentificador(String nombre, Identificador identificador) {
        identificadores.put(nombre, identificador);
    }

    public Identificador getIdentificador(String nombre) {
        return identificadores.get(nombre);
    }

    public Map<String, Identificador> getIdentificadores() {
        return identificadores;
    }


}
