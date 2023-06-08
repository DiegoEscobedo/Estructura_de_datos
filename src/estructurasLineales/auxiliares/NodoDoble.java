package estructurasLineales.auxiliares;

/**
 * @author diego
 * @version 1.0
 */
public class NodoDoble {
    protected NodoDoble ligaIzq;
    protected NodoDoble ligaDer;
    protected Object info;
    public NodoDoble(Object info) {
        this.info = info;
        ligaDer = null;
        ligaIzq = null;
    }

    public NodoDoble getLigaIzq() {
        return ligaIzq;
    }

    public void setLigaIzq(NodoDoble ligaIzq) {
        this.ligaIzq = ligaIzq;
    }

    public NodoDoble getLigaDer() {
        return ligaDer;
    }

    public void setLigaDer(NodoDoble ligaDer) {
        this.ligaDer = ligaDer;
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
