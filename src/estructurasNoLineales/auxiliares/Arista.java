package estructurasNoLineales.auxiliares;

public class Arista {
    protected Object origen;
    protected Object destino;
    protected double peso;

    public Arista(Object origen, Object destino, double peso){
        this.origen = origen;
        this.destino = destino;
        this.peso = peso;
    }

    public Object getOrigen() {
        return origen;
    }

    public void setOrigen(Object origen) {
        this.origen = origen;
    }

    public Object getDestino() {
        return destino;
    }

    public void setDestino(Object destino) {
        this.destino = destino;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    @Override
    public String toString() {
        return "["+origen+"]";
    }
}
