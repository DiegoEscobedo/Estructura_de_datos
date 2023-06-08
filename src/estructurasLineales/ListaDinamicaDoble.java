package estructurasLineales;

import entradaSalida.SalidaPorDefecto;
import estructurasLineales.auxiliares.Nodo;
import estructurasLineales.auxiliares.NodoDoble;

public class ListaDinamicaDoble implements Lista{
    NodoDoble primero;
    NodoDoble ultimo;

    public ListaDinamicaDoble() {
        this.primero = null;
        this.ultimo = null;
    }

    /**
     * Este elemento regresa un indicador de si la lista esta vacia
     *
     * @return Regresa true si esta vacia> y false> en caso contrario
     */
    @Override
    public boolean vacio() {
        return primero==null;
    }

    /**
     * Este metodo añade un elemento a la lista
     *
     * @param info Es el nuevo valor a añadir
     * @return Regresa la posicion en donde lo agrega o -1 en caso contrario
     */
    @Override
    public int agregar(Object info) {
        NodoDoble nuevoNodo = new NodoDoble(info);
        if(nuevoNodo != null){
            if(vacio()){
                primero = nuevoNodo;
                ultimo = nuevoNodo;
            }else{
                ultimo.setLigaDer(nuevoNodo);
                nuevoNodo.setLigaIzq(ultimo);
                ultimo=nuevoNodo;
            }
            return 1;
        }
        return -1;
    }

    /**
     * Este metodo imprime las listas como una torre de el ultimo dato al menor
     */
    @Override
    public void imprimir() {
        if(!vacio()){
            NodoDoble temporal = primero;
            SalidaPorDefecto.terminal("null" + " <- ");
            while (temporal.getLigaDer() != null) {
                SalidaPorDefecto.terminal(temporal.getInfo() + " <-> ");
                temporal = temporal.getLigaDer();
            }
            SalidaPorDefecto.terminal(temporal.getInfo() + " -> ");
        }
        SalidaPorDefecto.terminal("null");
    }

    /**
     * Este metodo imprime la lista de forma invertida
     */
    @Override
    public void imprimirinv() {

    }

    /**
     * Este metodo busca un elemento de la lista
     *
     * @param info Es el elemento a buscar
     * @return Regresa el indice de el elemento buscado
     */
    @Override
    public Object buscar(Object info) {
        return null;
    }

    /**
     * Este metodo elimina un elemento de la lista y la reacomoda
     *
     * @param info Es el elemento a eliminar
     * @return Regresa el objeto eliminado
     */
    @Override
    public Object eliminar(Object info) {
        return null;
    }

    /**
     * Indica si la lista actual es igual a la lista2. La
     * igualdad se determina por el contenido de cada elemento en la posición
     * correspondiente al mismo índice
     *
     * @param lista2 Es la lista a comparar
     * @return regresa <true> si son iguales y <false> si no son
     */
    @Override
    public boolean esIgual(Object lista2) {
        return false;
    }

    /**
     * Este metodo cambia in objeto viejo por uno nuevo un numero especificado de veces
     *
     * @param infoViejo Es el objeto a cambiar
     * @param infoNuevo Es el nuevo objeto
     * @param numVeces  Es el numero de veces que se cambiara el objeto
     * @return Regresa true si si se cambiaron los objetos
     */
    @Override
    public boolean cambiar(Object infoViejo, Object infoNuevo, int numVeces) {
        return false;
    }

    /**
     * Busca dentro de un arreglo los
     * elementos indicados por info, si existen muchos elementos o en su caso uno; debe
     * guardar en un arreglo
     *
     * @param info Es el objeto a buscar
     * @ Regresa  las posiciones de todas y cada una de las
     * ocurrencias del elemento buscado.
     */
    @Override
    public ListaEstatica buscarValores(Object info) {
        return null;
    }

    /**
     * Este metodo elimina el ultimo elemento de el arreglo
     *
     * @return Regresa el objeto eliminado
     */
    @Override
    public Object eliminar() {
        if(!vacio()){
            Object respaldo = ultimo.getInfo();
            if(primero == ultimo){
                primero=null;
                ultimo=null;
            }else{
                ultimo=ultimo.getLigaIzq();
                ultimo.setLigaDer(null);
            }
            return respaldo;
        }else{
            return null;
        }
    }

    /**
     * Este metodo vacia la lista
     */
    @Override
    public void vaciar() {

    }

    /**
     * este metodo agrega al final de la lista actual los elementos de la lista 2
     *
     * @param lista2 es la lista a concatenar al final
     * @return REgresa true si si pudo agregarlos
     */
    @Override
    public boolean agregarLista(Object lista2) {
        return false;
    }

    /**
     * Este metodo invierte la lista
     */
    @Override
    public void invertir() {

    }

    /**
     * Este metodo cuenta las veces que esta un Objeto en un arreglo
     *
     * @param info Es el objeto a contar
     * @return Regresa el numero de veces que se encontro
     */
    @Override
    public int contar(Object info) {
        return 0;
    }

    /**
     * este metodo elimina elimina cada elemento de lista2 que
     * se encuentre en la lista actual
     *
     * @param lista2 es la lista de la cual va a eliminar elemntos
     * @return Regresa true si si los pudo eliminar
     */
    @Override
    public boolean eliminarLista(Object lista2) {
        return false;
    }

    /**
     * Este metodo rellena todos los elementos
     * indicados por “cantidad” del arreglo con el “info” indicado
     *
     * @param info     Es el objeto con el cual sera rellenado
     * @param cantidad Es la cantidad de espacios a rellenar
     */
    @Override
    public void rellenar(Object info, int cantidad) {

    }

    /**
     * Este metodo clona la lista actual
     *
     * @return Regresa la lista clonada
     */
    @Override
    public Lista clonar() {
        return null;
    }

    /**
     * Este metodo regresa una lista con los elementos indicados con las posiciones inicial y final del arreglo
     * actual.
     *
     * @param indiceInicial es la posicion inicial del arreglo
     * @param indiceFinal   es la posicion final del arreglo
     * @return Regresa la lista con los 2 elementos de el principio y final
     */
    @Override
    public Lista subLista(int indiceInicial, int indiceFinal) {
        return null;
    }

    /**
     * Indica si la lista2 (que es otro arreglo ordenado) es una sublista o subconjunto
     * de la lista actual.
     *
     * @param lista2 Es la lista a comparar
     * @return Regresa true si si es sub lista
     */
    public boolean esSubLista(Lista lista2) {
        return false;
    }

    /**
     * Debe regresar un arreglo conteniendo los elementos del arreglo
     * actual que se obtienen del arreglo de índices “listaIndices”, el cual contiene las
     * posiciones de los índices de donde se obtendrán los datos a retornar.
     *
     * @param listaIndices Son los indices a regresar.
     * @return Regresa la lista con los indices especificados
     */
    @Override
    public ListaEstatica subLista(ListaEstaticaNumerica listaIndices) {
        return null;
    }

    /**
     * @return
     */
    @Override
    public Object verTope() {
        return null;
    }

    /**
     * @param buffer
     */
    @Override
    public void recibeBuffer(Object[] buffer) {

    }

    /**
     * Este metodo elimina el primer elemento del arreglo
     *
     * @return Regresa el objeto eliminado
     */
    @Override
    public Object eliminarPrimero() {
        return null;
    }

    /**
     * @param maximo
     * @return
     */
    @Override
    public boolean redimensionar(int maximo) {
        return false;
    }
}
