package estructurasLineales;

public class ColaDinamica implements Lote {
    ListaDinamica cola;

    public ColaDinamica(){
        cola = new ListaDinamica();
    }

    @Override
    public boolean lleno() {
        return false;
    }

    @Override
    public boolean vacio() {
        return cola.vacio();
    }

    @Override
    public boolean poner(Object info) {
        return cola.agregar(info)>0;
    }

    @Override
    public Object quitar() {
        return cola.eliminarPrimero();
    }

    @Override
    public void imprimir() {
        cola.imprimir();
    }

    @Override
    public Object verTope() {
        return cola.verTope();
    }

    public int cantidad(){
        return cola.contarValores();
    }
}
