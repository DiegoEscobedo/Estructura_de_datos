package estructurasNoLineales;

import entradaSalida.SalidaPorDefecto;
import estructurasLineales.ColaDinamica;
import estructurasLineales.Lista;
import estructurasLineales.ListaDinamica;
import estructurasLineales.ListaEstatica;
import estructurasLineales.auxiliares.Nodo;
import estructurasLineales.auxiliares.NodoBusquedaArbol;
import estructurasLineales.auxiliares.NodoDoble;
import registro.Indice.Orden;
import utils.ArchivoTexto.ArchivoTexto;

import java.io.IOException;
import java.util.Objects;

public class ArbolIndice{
    protected ArbolBinarioBusqueda arbolIndices;

    public ArbolIndice(){
        arbolIndices = new ArbolBinarioBusqueda();
    }

    /**
     * Este metodo agrega la primera tabla al arbol
     * @param archivo Es el archivo de la tabla
     * @throws IOException
     */
    public void agregarTabla(String archivo) throws IOException {
        int posicion = 1;
        ListaEstatica informacion = ArchivoTexto.leerArchivoTabla(archivo, posicion);
        while(informacion!=null&& !Objects.equals(informacion.obtener(0), "")) {
            NodoBusquedaArbol nodoBANuevo = new NodoBusquedaArbol(informacion.obtener(0), informacion.obtener(1));
            arbolIndices.agregar(nodoBANuevo);
            informacion = ArchivoTexto.leerArchivoTabla(archivo, posicion++);
        }
    }

    /**
     * Este metodo agrega la tabla numero 2 a el arbol creando arboles dentro de nodos
     * @param archivo Es el archivo de la tabla 2
     * @throws IOException
     */
    public void agregarTabla2(String archivo) throws IOException {
        if (arbolIndices.raiz == null) {
            return;
        }
        ListaDinamica agregados = new ListaDinamica();
        ColaDinamica cola = new ColaDinamica();
        cola.poner(arbolIndices.raiz);

        while (!cola.vacio()) {
            NodoDoble nodoActual = (NodoDoble) cola.quitar();
            agregarTabla2(archivo, nodoActual, agregados);

            if (nodoActual.getLigaIzq() != null) {
                cola.poner(nodoActual.getLigaIzq());
            }

            if (nodoActual.getLigaDer() != null) {
                cola.poner(nodoActual.getLigaDer());
            }
        }
    }
    private void agregarTabla2(String archivo, NodoDoble subraiz, ListaDinamica agregados) throws IOException {
        int posicion = 1;
        Object marcar = null;
        ListaEstatica informacion = ArchivoTexto.leerArchivoTabla2(archivo, posicion);
        while(informacion!=null && !Objects.equals(informacion.obtener(0), "")) {
            NodoBusquedaArbol nodoBANuevo = new NodoBusquedaArbol(informacion.obtener(0), informacion.obtener(1));
            NodoBusquedaArbol nodoBusquedaArbol = (NodoBusquedaArbol) subraiz.getInfo();
            NodoBusquedaArbol nodoBusquedaArbolIzq = (NodoBusquedaArbol) nodoBusquedaArbol.getLigaIzq();
            NodoBusquedaArbol nodoBusquedaArbolDer = (NodoBusquedaArbol) nodoBusquedaArbol.getLigaDer();
            if(agregados.buscar(nodoBANuevo.getIndice())==null) {
                if (nodoBusquedaArbolIzq == null || Objects.equals(nodoBusquedaArbolIzq.getIndice().toString(), nodoBANuevo.getIndice().toString()) ||
                        nodoBusquedaArbolDer == null) {
                    agregarNodo(nodoBusquedaArbol, nodoBANuevo);
                    marcar = nodoBANuevo.getIndice();
                }
            }
            informacion = ArchivoTexto.leerArchivoTabla2(archivo, posicion++);
        }
        agregados.agregar(marcar);
    }

    private void agregarNodo(NodoBusquedaArbol nodoBusquedaArbol, NodoBusquedaArbol nodoBANuevo) {
        ColaDinamica colaArbol = new ColaDinamica();
        colaArbol.poner(nodoBusquedaArbol);
        while (!colaArbol.vacio()) {
            int size = colaArbol.cantidad();
            boolean agregado = false;
            for (int i = 0; i < size; i++) {
                NodoBusquedaArbol nodoActual1 = (NodoBusquedaArbol) colaArbol.quitar();
                if (nodoActual1.getLigaIzq() == null) {
                    nodoActual1.setLigaIzq(nodoBANuevo);
                    agregado = true;
                    break;
                }
                if (nodoActual1.getLigaDer() == null) {
                    nodoActual1.setLigaDer(nodoBANuevo);
                    agregado = true;
                    break;
                }
                colaArbol.poner(nodoActual1.getLigaIzq());
                colaArbol.poner(nodoActual1.getLigaDer());
            }
            if (agregado) {
                break;
            }
        }
    }

    /**
     * Busca la direccion de un indice
     * @param indice Es el indice
     * @param direccion Es la direccion
     * @return
     */
    public Object buscarIndice(Object indice, Object direccion){
        NodoBusquedaArbol info = new NodoBusquedaArbol(indice, direccion);
        return arbolIndices.buscar(info);
    }

    /**
     * Imprime el arbol por ancura
     */
    public void imprimirAnchura(){
        arbolIndices.imprimirPorAnchura();
    }
    /**
     * Imprime el arbol por Innorden
     */
    public void imprimir() {
        arbolIndices.imprimirInnorden();
    }

    /**
     * Imprme los arboles internoos en los nodos los cuales son de la tabla 2
     */
    public void imprimirTabla2() {
        if (arbolIndices.raiz == null) {
            return;
        }
        ColaDinamica cola = new ColaDinamica();
        cola.poner(arbolIndices.raiz);

        while (!cola.vacio()) {
            ArbolBinarioBusqueda arbol2 = new ArbolBinarioBusqueda();
            NodoDoble nodoActual = (NodoDoble) cola.quitar();
            arbol2.raiz = (NodoBusquedaArbol) nodoActual.getInfo();
            NodoBusquedaArbol nodo = (NodoBusquedaArbol) arbol2.raiz.getLigaDer();
            arbol2.imprimirInnorden();
            SalidaPorDefecto.terminal("\n");

            if (nodoActual.getLigaIzq() != null) {
                cola.poner(nodoActual.getLigaIzq());
            }

            if (nodoActual.getLigaDer() != null) {
                cola.poner(nodoActual.getLigaDer());
            }
        }
    }

    /**
     * Busca una oden en el archivo para acceder a ella de manera rapida sin tener que leer todo el archivo
     * @param direccion Es la direccion de la informacion
     * @return Regresa la orden
     * @throws IOException
     */
    public Object buscarOrden(int direccion) throws IOException {
        ListaEstatica valores = ArchivoTexto.buscar("D:\\Estructura_de_datos\\orders.txt", direccion);
        Orden orden = new Orden();
        if(valores!=null) {
            orden.setId((String) valores.obtener(0));
            orden.setDate((String) valores.obtener(1));
            orden.setMode((String) valores.obtener(2));
            orden.setCustomer_id((String) valores.obtener(3));
            orden.setStatus((String) valores.obtener(4));
            orden.setTotal((String) valores.obtener(5));
            orden.setSales_rep_id((String) valores.obtener(6));
            orden.setPromotion_id((String) valores.obtener(7));
        }
        return orden;
    }
}
