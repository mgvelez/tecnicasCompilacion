package tpDos;

public class Identificador {
    private String nombre;
    private TipoDato tipoDato;
    private boolean inicializada;
    private boolean utilizada;

    public Identificador(String nombre, TipoDato tipoDato, boolean inicializada, boolean utilizada) {
        this.nombre = nombre;
        this.tipoDato = tipoDato;
        this.inicializada = inicializada;
        this.utilizada = utilizada;
    }

    public String getNombre() {
        return nombre;
    }

    public TipoDato getTipoDato() {
        return tipoDato;
    }

    public boolean isInicializada() {
        return inicializada;
    }

    public void setInicializada(boolean inicializada) {
        this.inicializada = inicializada;
    }

    public boolean isUtilizada() {
        return utilizada;
    }

    public void setUtilizada(boolean utilizada) {
        this.utilizada = utilizada;
    }
    @Override
    public String toString() {
        return "Variable{" +
                "nombre='" + nombre + '\'' +
                ", tipoDato=" + tipoDato +
                ", inicializada=" + inicializada +
                ", utilizada=" + utilizada +
                '}';
    }
}
