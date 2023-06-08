package estructurasNoLineales.auxiliares;

public class VerticeDinamico {
    protected int indice;
    protected Object info;
    protected double peso;

    public VerticeDinamico(Object info, double peso) {
        this.info = info;
        this.peso = peso;
    }

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

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    @Override
    public String toString() {
        return info + "-" + peso ;
    }
}
