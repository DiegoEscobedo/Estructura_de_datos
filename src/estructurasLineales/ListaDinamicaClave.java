package estructurasLineales;

import entradaSalida.SalidaPorDefecto;
import estructurasLineales.auxiliares.NodoClave;
import estructurasNoLineales.Matriz2;
import utilerias.comunes.Comparador;

/**
 * @author diego
 * @version 1.0
 */
public class ListaDinamicaClave {
    protected NodoClave primero;

    protected NodoClave ultimo;
    protected NodoClave nodoActual;

    public ListaDinamicaClave() {
        primero = null;
        ultimo = null;
        nodoActual = null;
    }

    public NodoClave getPrimero() {
        return primero;
    }

    public void setPrimero(NodoClave primero) {
        this.primero = primero;
    }

    public NodoClave getUltimo() {
        return ultimo;
    }

    public void setUltimo(NodoClave ultimo) {
        this.ultimo = ultimo;
    }

    public NodoClave getNodoActual() {
        return nodoActual;
    }

    public void setNodoActual(NodoClave nodoActual) {
        this.nodoActual = nodoActual;
    }

    //---------------------------------------------Fin de Codigo Basico-----------------------------------------------//
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

    /**
     * Verifica si existe el nodo
     * @return Regresa false si no
     */
    public boolean hayNodo(){
        return nodoActual != null;
    };

    /**
     * Este metodo busca un nodo anterior al que se quiere buscar
     *
     * @param clave Es el elemento a buscar
     * @return Regresa la lista con los Nodos anterior y el que se busca;
     */
    public ListaEstatica buscarAnteriorClave(Object clave) {
        ListaEstatica listareturn = new ListaEstatica(2);
        NodoClave nodoAnterior = primero;
        NodoClave nodoBuscar = primero;
        while (nodoBuscar != null && !(clave.toString().equalsIgnoreCase(nodoBuscar.getClave().toString()))){
            nodoAnterior = nodoBuscar;
            nodoBuscar = nodoBuscar.getLigaDer();
        }
        if (nodoBuscar != null){
            listareturn.agregar(nodoAnterior);
            listareturn.agregar(nodoBuscar);
        }else{
            listareturn.agregar(null);
            listareturn.agregar(null);
        }
        return listareturn;
    }

    /**
     * Este metodo busca un nodo anterior al que se quiere buscar
     *
     * @param info Es el elemento a buscar
     * @return Regresa la lista con los Nodos anterior y el que se busca;
     */
    public ListaEstatica buscarAnteriorInfo(Object info) {
        ListaEstatica listareturn = new ListaEstatica(2);
        NodoClave nodoAnterior = primero;
        NodoClave nodoBuscar = primero;
        while (nodoBuscar != null && !(info.toString().equalsIgnoreCase(nodoBuscar.getInfo().toString()))){
            nodoAnterior = nodoBuscar;
            nodoBuscar = nodoBuscar.getLigaDer();
        }
        if (nodoBuscar != null){
            listareturn.agregar(nodoAnterior);
            listareturn.agregar(nodoBuscar);
        }else{
            listareturn.agregar(null);
            listareturn.agregar(null);
        }
        return listareturn;
    }

    /**
     * Obtiene un un nodo
     * @return Regresa el nodo
     */
    public Object obtenerNodo(){
        if(hayNodo()){
            Object respaldo = nodoActual.getInfo();
            nodoActual = nodoActual.getLigaDer();
            return respaldo;
        }else{
            return null;
        }
    }

    public boolean agregar(Object clave, Object info){
        NodoClave nuevoNodo = new NodoClave(clave, info);
        if (nuevoNodo != null) {
            if (vacio()) {
                primero = nuevoNodo;
                ultimo = nuevoNodo;
                return true;
            } else {
                inicializarIterador();
                while (nodoActual != null) {
                    if((int)Comparador.comparar(nodoActual.getClave(), nuevoNodo.getClave()) == 0){
                        nodoActual.setInfo(info);
                        return true;
                    }
                    nodoActual = nodoActual.getLigaDer();
                }
                ultimo.setLigaDer(nuevoNodo);
                ultimo = nuevoNodo;
                return true;
            }
        } else{
            return false;
        }
    }

    /**
     * Este metodo elimina un elemento de la lista mediante la clave y la reacomoda
     *
     * @param clave Es la clave del elemento a eliminar
     * @return Regresa el objeto eliminado
     */
    public Object eliminar(Object clave){
        if(!vacio()){
            ListaEstatica listaDeBusqueda = buscarAnteriorClave(clave);
            NodoClave anterior = (NodoClave) listaDeBusqueda.obtener(0);
            NodoClave nodoBuscado = (NodoClave) listaDeBusqueda.obtener(1);
            if (nodoBuscado == null) {
                return null;
            } else {
                Object respaldo;
                if (primero == ultimo) {
                    respaldo = primero.getInfo();
                    primero = null;
                    ultimo = null;
                } else if (nodoBuscado == primero) {
                    respaldo = nodoBuscado.getInfo();
                    primero = primero.getLigaDer();
                } else if (nodoBuscado == ultimo) {
                    respaldo = nodoBuscado.getInfo();
                    anterior.setLigaDer(null);
                    ultimo = anterior;
                } else {
                    NodoClave siguiente = nodoBuscado.getLigaDer();
                    respaldo = nodoBuscado.getInfo();
                    anterior.setLigaDer(siguiente);
                }
                return respaldo;
            }
        }else{
            return null;
        }
    }

    /**
     * Este metodo elimina un elemento de la lista y la reacomoda
     *
     * @param info Es el elemento a eliminar
     * @return Regresa el objeto eliminado
     */
    public Object eliminarContenido(Object info) {
        if(!vacio()) {
            ListaEstatica listaDeBusqueda = buscarAnteriorInfo(info);
            NodoClave anterior = (NodoClave) listaDeBusqueda.obtener(0);
            NodoClave nodoBuscado = (NodoClave) listaDeBusqueda.obtener(1);
            if (nodoBuscado == null) {
                return null;
            } else {
                Object respaldo;
                if (primero == ultimo) {
                    respaldo = primero.getInfo();
                    primero = null;
                    ultimo = null;
                } else if (nodoBuscado == primero) {
                    respaldo = nodoBuscado.getInfo();
                    primero = primero.getLigaDer();
                } else if (nodoBuscado == ultimo) {
                    respaldo = nodoBuscado.getInfo();
                    anterior.setLigaDer(null);
                    ultimo = anterior;
                } else {
                    NodoClave siguiente = nodoBuscado.getLigaDer();
                    respaldo = nodoBuscado.getInfo();
                    anterior.setLigaDer(siguiente);
                }
                return respaldo;
            }
        }else{
            return null;
        }
    }

    /**
     * Este metodo busca un elemento de la lista
     *
     * @param clave Es el elemento a buscar
     * @return Regresa del elemento buscado
     */
    public Object buscar(Object clave) {
        NodoClave nodoBuscar = primero;
        while (nodoBuscar != null && !(clave.toString().equalsIgnoreCase(nodoBuscar.getClave().toString()))){
            nodoBuscar = nodoBuscar.getLigaDer();
        }
        if (nodoBuscar != null){
            return nodoBuscar.getInfo();
        }
        return null;
    }

    /**
     * Este metodo busca un elemento de la lista
     *
     * @param info Es el elemento a buscar
     * @return Regresa del elemento buscado
     */
    public Object buscarContenido(Object info) {
        NodoClave nodoBuscar = primero;
        while (nodoBuscar != null && !(info.toString().equalsIgnoreCase(nodoBuscar.getInfo().toString()))){
            nodoBuscar = nodoBuscar.getLigaDer();
        }
        if (nodoBuscar != null){
            return nodoBuscar.getInfo();
        }
        return null;
    }

    /**
     * Cambia un objeto en un indice espicificado
     * @param clave Es la clave de el objeto a cambiar
     * @param info Es el nuevo objeto
     * @return Regresa true si lo cambio
     */
    public boolean cambiar(Object clave, Object info){
        NodoClave nodoBuscar = primero;
        while (nodoBuscar != null && !(clave.toString().equalsIgnoreCase(nodoBuscar.getClave().toString()))){
            nodoBuscar = nodoBuscar.getLigaDer();
        }
        if (nodoBuscar != null){
            nodoBuscar.setInfo(info);
            return true;
        }
        return false;
    }

    /**
     * Este metodo cambia in objeto viejo por uno nuevo un numero especificado de veces
     *
     * @param infoViejo Es el objeto a cambiar
     * @param infoNuevo Es el nuevo objeto
     * @return Regresa true si si se cambiaron los objetos
     */
    public boolean cambiarValor(Object infoViejo, Object infoNuevo) {
        NodoClave nodoBuscar = primero;
        while (nodoBuscar != null && (int) Comparador.comparar(nodoBuscar.getInfo(), infoViejo) != 0){
            nodoBuscar = nodoBuscar.getLigaDer();
        }
        if(nodoBuscar != null){
            nodoBuscar.setInfo(infoNuevo);
            return true;
        }
        return false;
    }

    /**
     * Este metodo imprime la lista dinamica
     */
    public void imprimir() {
        NodoClave temporal = primero;
        while(temporal != null){
            SalidaPorDefecto.terminal(temporal.toString() + " -> ");
            temporal = temporal.getLigaDer();
        }
        SalidaPorDefecto.terminal("null");
    }

    /**
     * Este metodo imprime las claves de la lista dinamica
     */
    public void imprimirClaves() {
        NodoClave temporal = primero;
        while(temporal != null){
            SalidaPorDefecto.terminal(temporal.getClave() + " -> ");
            temporal = temporal.getLigaDer();
        }
        SalidaPorDefecto.terminal("null");
    }

    /**
     * Este metodo imprime los valores de la lista dinamica
     */
    public void imprimirValores() {
        NodoClave temporal = primero;
        while(temporal != null){
            SalidaPorDefecto.terminal(temporal.getInfo() + " -> ");
            temporal = temporal.getLigaDer();
        }
        SalidaPorDefecto.terminal("null");
    }

    /**
     * Convierte la Lista Dinamica a 2 Listas Estaticas
     * @return
     */
    public ListaEstatica aListaEstatica(){
        ListaEstatica listas = new ListaEstatica(2);
        ListaEstatica listainfos = new ListaEstatica(1);
        ListaEstatica listaclaves = new ListaEstatica(1);
        int contador = 1;
        inicializarIterador();
        while (nodoActual != null){
            listainfos.redimensionar(contador);
            listaclaves.redimensionar(contador);
            listainfos.agregar(nodoActual.getInfo());
            listaclaves.agregar(nodoActual.getClave());
            nodoActual = nodoActual.getLigaDer();
            contador++;
        }
        listas.agregar(listaclaves);
        listas.agregar(listainfos);
        return listas;
    }

    /**
     * Convierte la Lista Dinamica a 2 Listas Dinamicas
     * @return
     */
    public ListaDinamica aListasDinamicas(){
        inicializarIterador();
        ListaDinamica listas = new ListaDinamica();
        ListaDinamica listainfos = new ListaDinamica();
        ListaDinamica listaclaves = new ListaDinamica();
        while (nodoActual != null){
            listainfos.agregar(nodoActual.getInfo());
            listaclaves.agregar(nodoActual.getClave());
            nodoActual = nodoActual.getLigaDer();
        }
        listas.agregar(listaclaves);
        listas.agregar(listainfos);
        return listas;
    }

    /**
     * Cuenta los valores dentro de una lista dinamica
     * @return Regresa el numero de valores
     */
    public int contarValores(){
        int contador = 0;
        inicializarIterador();
        while (nodoActual != null){
            contador++;
            nodoActual = nodoActual.getLigaDer();
        }
        return contador;
    }

    /**
     * Guarda los elementos de una lista en una matriz 2d el la primera columna las claves y en la 2da los infos
     * @return
     */
    public Matriz2 aMatriz2(){
        Matriz2 matriz = new Matriz2(contarValores(), 2, null);
        int cadaFila = 0;
        inicializarIterador();
        while (nodoActual != null){
            matriz.cambiar(cadaFila, 0, nodoActual.getClave());
            matriz.cambiar(cadaFila, 1, nodoActual.getInfo());
            nodoActual = nodoActual.getLigaDer();
            cadaFila++;
        }
        return matriz;
    }

    /**
     * Este metodo vacia la lista
     */
    public void vaciar() {
        primero = null;
        ultimo = null;
        nodoActual = null;
    }

    /**
     * Obtiene un objeto de una clave especificada
     * @param clave Es el indice
     * @return Regresa el objeto
     */
    public Object obtener(Object clave){
        inicializarIterador();
        while (nodoActual != null && !(clave.toString().equalsIgnoreCase(nodoActual.getClave().toString()))){
            nodoActual = nodoActual.getLigaDer();
        }
        if (nodoActual != null) {
            return nodoActual;
        }
        return null;
    }

    /**
     * este metodo agrega al final de la lista actual los elementos de la lista 2
     *
     * @param lista2 es la lista a concatenar al final
     * @return REgresa true si si pudo agregarlos
     */
    public boolean agregarLista(ListaDinamicaClave lista2) {
        if(!lista2.vacio()) {
            lista2.inicializarIterador();
            while (lista2.nodoActual != null) {
                agregar(lista2.nodoActual.getClave(), lista2.nodoActual.getInfo());
                lista2.nodoActual = lista2.nodoActual.getLigaDer();
            }
            return true;
        }else {
            return false;
        }
    }

    /**
     * Agrega todos los elementos del arreglo pasado como argumento, donde
     * hay arreglos paralelos de clave y valor respectivamente. Las claves no deben repetirse
     * @param arregloClaves Es el arreglo de Claves
     * @param arregloValores Es el arreglo de los valores
     * @return Regresa true si son de la misma medida y si lo hace
     */
    public boolean agregarListasEstaticas(ListaEstatica arregloClaves, ListaEstatica arregloValores){
        if(arregloClaves.cantidad() == arregloValores.cantidad()){
            int indiceValor = 0;
            for(int indiceClave = 0; indiceClave<arregloClaves.cantidad(); indiceClave++) {
                agregar(arregloClaves.obtener(indiceClave), arregloValores.obtener(indiceValor));
                indiceValor++;
            }
            return true;
        }else{
            return false;
        }
    }

    /**
     * Agrega todos los elementos de la lista pasada como argumento, donde hay
     * listas paralelas de clave y valor respectivamente. Las claves no deben repetirse.
     * @param listaClaves Es el arreglo de Claves
     * @param listaValores Es el arreglo de los valores
     * @return Regresa true si son de la misma medida y si lo hace
     */
    public boolean agregarListasDinamicas(ListaDinamica listaClaves, ListaDinamica listaValores){
        if(listaClaves.contarValores() == listaValores.contarValores()){
            int indiceValor = 0;
            for(int indiceClave = 0; indiceClave<listaClaves.contarValores(); indiceClave++) {
                agregar(listaClaves.obtener(indiceClave), listaValores.obtener(indiceValor));
                indiceValor++;
            }
            return true;
        }else{
            return false;
        }
    }

    /**
     * Agrega todos los elementos de la matriz
     * pasada como argumento, donde la primera columna tiene las claves y la segunda columna
     * tiene los valores. Las claves no deben repetirse y debe validar las dimensiones de la
     * matriz.
     * @param matriz Es la matriz de las claves y valores.
     * @return Regresa true si si puede agregar la matriz
     */
    public boolean agregarMatriz2(Matriz2 matriz){
        if(matriz.getColumnas() == 2){
            for(int indice = 0; indice<matriz.getRenglones(); indice++) {
                agregar(matriz.obtener(indice,0), matriz.obtener(indice,1));
            }
            return true;
        }else{
            return false;
        }
    }
}
