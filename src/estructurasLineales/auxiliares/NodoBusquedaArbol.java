package estructurasLineales.auxiliares;

public class NodoBusquedaArbol extends NodoDoble{
    protected Object indice;
    protected Object direccion;
    public NodoBusquedaArbol(Object indice, Object direccion){
        super(indice);
        this.indice = indice;
        this.direccion = direccion;
    }

    public Object getIndice() {
        return indice;
    }

    public void setIndice(Object indice) {
        this.indice = indice;
    }

    public Object getDireccion() {
        return direccion;
    }

    public void setDireccion(Object direccion) {
        this.direccion = direccion;
    }

    @Override
    public String toString() {
        return "[ "+info+" - "+direccion+" ]";
    }
}
