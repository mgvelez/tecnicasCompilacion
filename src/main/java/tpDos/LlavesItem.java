package tpDos;

public class LlavesItem {
    char llave;
    int linea;
    // Clase para guardar un llave y línea
    public LlavesItem(char llave, int linea) {
        this.llave = llave;
        this.linea = linea;
    }

    public char getLlave() {
        return llave;
    }

    public int getLinea() {
        return linea;
    }
}
