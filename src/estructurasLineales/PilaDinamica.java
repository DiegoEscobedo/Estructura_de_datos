package estructurasLineales;

public class PilaDinamica implements Lote{

    ListaDinamica pila;

    public PilaDinamica(){
        pila = new ListaDinamica();
    }

    @Override
    public boolean lleno() {
        return false;
    }

    @Override
    public boolean vacio() {
        return pila.vacio();
    }

    @Override
    public boolean poner(Object info) {
        return pila.agregar(info)>0;
    }

    @Override
    public Object quitar() {
        return pila.eliminar();
    }

    @Override
    public void imprimir() {
        pila.imprimir();
    }

    @Override
    public Object verTope() {
        return pila.verTope();
    }
}
