package tpDos;

import java.util.List;

public class Funcion extends Identificador {
    private List<TipoDato> argumentos;

    public Funcion(String nombre, TipoDato tipoDato, boolean inicializada, boolean utilizada, List<TipoDato> argumentos) {
        super(nombre, tipoDato, inicializada, utilizada);
        this.argumentos = argumentos;
    }

    public List<TipoDato> getArgumentos() {
        return argumentos;
    }

    public void setArgumentos(List<TipoDato> argumentos) {
        this.argumentos = argumentos;
    }

}
