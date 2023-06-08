package estructurasNoLineales.auxiliares;

public class Vertice {
    protected int indice;
    protected Object info;

    public int getIndice() {
        return indice;
    }

    public void setIndice(int indice) {
        this.indice = indice;
    }

    public Object getInfo() {
        return info;
    }

    public void setInfo(Object info) {
        this.info = info;
    }

    @Override
    public String toString() {
        return info.toString();
    }
}
