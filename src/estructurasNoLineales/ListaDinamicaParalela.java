package estructurasNoLineales;

import entradaSalida.SalidaPorDefecto;
import estructurasLineales.ListaDinamicaDoble;
import estructurasLineales.auxiliares.NodoDoble;

public class ListaDinamicaParalela{
    protected NodoDoble primero;
    protected NodoDoble ultimo;
    protected NodoDoble ultimo2;
    protected NodoDoble nodoActual;
    protected int cantidad;

    public ListaDinamicaParalela() {
        primero = null;
        ultimo = null;
        ultimo2 = null;
        nodoActual = null;
        cantidad=0;
    }

    public NodoDoble getPrimero() {
        return primero;
    }

    public void setPrimero(NodoDoble primero) {
        this.primero = primero;
    }

    public NodoDoble getUltimo() {
        return ultimo;
    }

    public void setUltimo(NodoDoble ultimo) {
        this.ultimo = ultimo;
    }

    public NodoDoble getNodoActual() {
        return nodoActual;
    }

    public void setNodoActual(NodoDoble nodoActual) {
        this.nodoActual = nodoActual;
    }

    private boolean vacio() {
        if(primero == null){
            return true;
        }else {
            return false;
        }
    }

    public void inicializarIterador(){
        nodoActual = primero;
    }


    public boolean agregar(Object info){
        NodoDoble nuevoNodo = new NodoDoble(info);
        if(nuevoNodo!=null) {
            if (vacio()) {
                primero = nuevoNodo;
                ultimo = nuevoNodo;
                cantidad++;
                return true;
            } else {
                if (cantidad % 2 == 0) {
                    ultimo.setLigaDer(nuevoNodo);
                    ultimo = nuevoNodo;
                } else {
                    if(ultimo2!=null) {
                        ultimo.setLigaIzq(nuevoNodo);
                        ultimo2.setLigaDer(nuevoNodo);
                        nuevoNodo.setLigaIzq(ultimo);
                        ultimo2 = nuevoNodo;
                    }else {
                        ultimo.setLigaIzq(nuevoNodo);
                        nuevoNodo.setLigaIzq(ultimo);
                        ultimo2 = nuevoNodo;
                    }
                }
                cantidad++;
                return true;
            }
        }
        return false;
    }

    public Object eliminar(){
        if(!vacio()) {
            NodoDoble respaldo;
            if (cantidad % 2 == 0) {
                inicializarIterador();
                for (int indice = 0; indice < Math.floorDiv(cantidad, 2) - 1; indice++) {
                    nodoActual = nodoActual.getLigaDer();
                }
                respaldo = nodoActual.getLigaDer();
                nodoActual.setLigaDer(null);
                ultimo = nodoActual;
                cantidad--;
            } else {
                inicializarIterador();
                nodoActual = nodoActual.getLigaIzq();
                for (int indice = 0; indice < Math.floorDiv(cantidad, 2) - 1; indice++) {
                    nodoActual = nodoActual.getLigaDer();
                }
                respaldo = nodoActual.getLigaDer();
                nodoActual.setLigaDer(null);
                ultimo.setLigaIzq(null);
                ultimo2 = nodoActual;
                cantidad--;
            }
            return respaldo;
        }
        return null;
    }

    public Object buscar(Object info){
        if (cantidad % 2 == 0) {
            inicializarIterador();
            for (int i = 0; i < cantidad/2; i++) {
                if(nodoActual.getInfo() == info){
                    return nodoActual.getInfo();
                }
                nodoActual = nodoActual.getLigaDer();
            }
            inicializarIterador();
            nodoActual = nodoActual.getLigaIzq();
            for (int i = 0; i < cantidad/2; i++) {
                if(nodoActual.getInfo() == info){
                    return nodoActual.getInfo();
                }
                nodoActual = nodoActual.getLigaDer();
            }
        } else {
            inicializarIterador();
            for (int i = 0; i < Math.floorDiv(cantidad, 2)+1; i++) {
                if(nodoActual.getInfo() == info){
                    return nodoActual.getInfo();
                }
                nodoActual = nodoActual.getLigaDer();
            }
            inicializarIterador();
            nodoActual = nodoActual.getLigaIzq();
            for (int i = 0; i < Math.floorDiv(cantidad, 2); i++) {
                if(nodoActual.getInfo() == info){
                    return nodoActual.getInfo();
                }
                nodoActual = nodoActual.getLigaDer();
            }
        }
        return null;
    }

    public void imprimir(){
        if (cantidad % 2 == 0) {
            inicializarIterador();
            for (int i = 0; i < cantidad/2; i++) {
                SalidaPorDefecto.terminal(nodoActual.getInfo() + " -> ");
                nodoActual = nodoActual.getLigaDer();
            }
            SalidaPorDefecto.terminal("null \n");
            inicializarIterador();
            nodoActual = nodoActual.getLigaIzq();
            for (int i = 0; i < cantidad/2; i++) {
                SalidaPorDefecto.terminal(nodoActual.getInfo() + " -> ");
                nodoActual = nodoActual.getLigaDer();
            }
            SalidaPorDefecto.terminal("null");
        } else {
            inicializarIterador();
            for (int i = 0; i < Math.floorDiv(cantidad, 2)+1; i++) {
                SalidaPorDefecto.terminal(nodoActual.getInfo() + " -> ");
                nodoActual = nodoActual.getLigaDer();
            }
            SalidaPorDefecto.terminal("null \n");
            inicializarIterador();
            nodoActual = nodoActual.getLigaIzq();
            for (int i = 0; i < Math.floorDiv(cantidad, 2); i++) {
                SalidaPorDefecto.terminal(nodoActual.getInfo() + " -> ");
                nodoActual = nodoActual.getLigaDer();
            }
            SalidaPorDefecto.terminal("null");
        }
    }

}
