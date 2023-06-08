package estructurasLineales.auxiliares;

public class NodoClave {
    protected Object info;
    protected Object clave;
    protected NodoClave ligaDer;
    public NodoClave() {
        clave = null;
        info = null;
        ligaDer = null;
    }
    public NodoClave(Object clave, Object info) {
        this.clave = clave;
        this.info = info;
        ligaDer = null;
    }

    public Object getClave() {
        return clave;
    }

    public void setClave(Object clave) {
        this.clave = clave;
    }

    public Object getInfo() {
        return info;
    }

    public void setInfo(Object info) {
        this.info = info;
    }

    public NodoClave getLigaDer() {
        return ligaDer;
    }

    public void setLigaDer(NodoClave ligaDer) {
        this.ligaDer = ligaDer;
    }

    @Override
    public String toString() {
        return clave.toString() + "|" + info.toString();
    }
}
