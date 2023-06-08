package estructurasLineales.auxiliares;

public class Nodo {
    protected Object info;
    protected Nodo ligaDer;
    public Nodo() {
        info = null;
        ligaDer = null;
    }
    public Nodo(Object info) {
        this.info = info;
        ligaDer = null;
    }

    public Object getInfo() {
        return info;
    }

    public void setInfo(Object info) {
        this.info = info;
    }

    public Nodo getLigaDer() {
        return ligaDer;
    }

    public void setLigaDer(Nodo ligaDer) {
        this.ligaDer = ligaDer;
    }

    @Override
    public String toString() {
        return info.toString();
    }
}
