package estructurasLineales;
public class PilaEstatica implements Lote {
    protected ListaEstatica pila;

    public PilaEstatica(int tamanio) {
        pila = new ListaEstatica(tamanio);
    }

    @Override
    public boolean lleno() {
        return pila.llena();
    }

    @Override
    public boolean vacio() {
        return pila.vacio();
    }

    @Override
    public boolean poner(Object info) {
        if(pila.agregar(info)>=0){
            return true;
        }else {
            return false;
        }

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
    public Object verTope(){
        return pila.verTope();
    }
}
