package estructurasLineales;
import entradaSalida.SalidaPorDefecto;
import estructurasLineales.auxiliares.Nodo;
import estructurasNoLineales.Matriz2;
import utilerias.comunes.Comparador;
import utilerias.comunes.TipoOrden;
import utilerias.comunes.TipoTabla;

public class ListaDinamicaOrdenada extends ListaDinamica {
    private static TipoOrden orden;
    public ListaDinamicaOrdenada(TipoOrden orden) {
        super();
        ListaDinamicaOrdenada.orden = orden;
    }

    public static void setOrden(TipoOrden orden) {
        ListaDinamicaOrdenada.orden = orden;
    }

    public static TipoOrden getOrden() {
        return orden;
    }
    /**
     * Este metodo busca un elemento de la lista
     *
     * @param info Es el elemento a buscar
     * @return Regresa el indice de el elemento buscado
     */
    @Override
    public Object buscar(Object info) {
        return super.buscar(info);
    }
    /**
     * Este metodo imprime la lista
     */
    @Override
    public void imprimir() {
        super.imprimir();
    }
    /**
     * Este metodo imprime la lista al reves
     */
    @Override
    public void imprimirinv() {
        super.imprimirinv();
    }
    /**
     * Este metodo añade un elemento a la lista de forma ordenada
     *
     * @param info Es el nuevo valor a añadir
     * @return Regresa la posicion en donde lo agrega o -1 en caso contrario
     */
    @Override
    public int agregar(Object info) {
        Nodo nuevoNodo = new Nodo(info);
        if (nuevoNodo != null) {
            if (vacio()) {
                primero = nuevoNodo;
                ultimo = nuevoNodo;
            } else if(primero == ultimo){
                if(orden == TipoOrden.INC) {
                    if ((int) Comparador.comparar(info, primero.getInfo())>0) {
                        primero.setLigaDer(nuevoNodo);
                        ultimo = nuevoNodo;
                    }
                    if ((int) Comparador.comparar(info, primero.getInfo())<0) {
                        Nodo respaldo = ultimo;
                        primero = nuevoNodo;
                        nuevoNodo.setLigaDer(respaldo);
                    }
                    if((int)Comparador.comparar(info, primero.getInfo())==0){
                        return -1;
                    }
                }
                if(orden == TipoOrden.DEC) {
                    if ((int) Comparador.comparar(info, primero.getInfo())>0) {
                        Nodo respaldo = ultimo;
                        primero = nuevoNodo;
                        nuevoNodo.setLigaDer(respaldo);
                    }
                    if ((int) Comparador.comparar(info, primero.getInfo())<0) {
                        primero.setLigaDer(nuevoNodo);
                        ultimo = nuevoNodo;
                    }
                    if((int)Comparador.comparar(info, primero.getInfo())==0){
                        return -1;
                    }
                }
            }else {
                inicializarIterador();
                if(orden == TipoOrden.INC){
                    while(nodoActual.getLigaDer()!=null && (int)Comparador.comparar(info, nodoActual.getInfo())>0){
                        nodoActual = nodoActual.getLigaDer();
                    }
                    if((int)Comparador.comparar(info, nodoActual.getInfo())==0){
                        return -1;
                    }
                    if(nodoActual!=ultimo && nodoActual!=primero){
                        ListaEstatica listaDeBusqueda = buscarAnterior(nodoActual.getInfo());
                        Nodo anterior = (Nodo) listaDeBusqueda.obtener(0);
                        Nodo nodoBuscado = (Nodo) listaDeBusqueda.obtener(1);
                        anterior.setLigaDer(nuevoNodo);
                        nuevoNodo.setLigaDer(nodoBuscado);
                    } else if (nodoActual == primero) {
                        nuevoNodo.setLigaDer(nodoActual);
                        primero = nuevoNodo;
                    } else{
                        if((int)Comparador.comparar(nuevoNodo.getInfo(), ultimo.getInfo())<0){
                            ListaEstatica listaDeBusqueda = buscarAnterior(nodoActual.getInfo());
                            Nodo anterior = (Nodo) listaDeBusqueda.obtener(0);
                            Nodo nodoBuscado = (Nodo) listaDeBusqueda.obtener(1);
                            anterior.setLigaDer(nuevoNodo);
                            nuevoNodo.setLigaDer(nodoBuscado);
                            ultimo = nodoBuscado;
                        }else{
                            nodoActual.setLigaDer(nuevoNodo);
                            ultimo = nuevoNodo;
                        }
                    }
                }
                if(orden == TipoOrden.DEC){
                    while(nodoActual.getLigaDer()!=null && (int)Comparador.comparar(info, nodoActual.getInfo())<0){
                        nodoActual = nodoActual.getLigaDer();
                    }
                    if((int)Comparador.comparar(info, nodoActual.getInfo())==0){
                        return -1;
                    }
                    if(nodoActual!=ultimo && nodoActual!=primero){
                        ListaEstatica listaDeBusqueda = buscarAnterior(nodoActual.getInfo());
                        Nodo anterior = (Nodo) listaDeBusqueda.obtener(0);
                        Nodo nodoBuscado = (Nodo) listaDeBusqueda.obtener(1);
                        anterior.setLigaDer(nuevoNodo);
                        nuevoNodo.setLigaDer(nodoBuscado);
                    } else if (nodoActual == primero) {
                        nuevoNodo.setLigaDer(nodoActual);
                        primero = nuevoNodo;
                    } else{
                        if((int)Comparador.comparar(nuevoNodo.getInfo(), ultimo.getInfo())>0){
                            ListaEstatica listaDeBusqueda = buscarAnterior(nodoActual.getInfo());
                            Nodo anterior = (Nodo) listaDeBusqueda.obtener(0);
                            Nodo nodoBuscado = (Nodo) listaDeBusqueda.obtener(1);
                            anterior.setLigaDer(nuevoNodo);
                            nuevoNodo.setLigaDer(nodoBuscado);
                            ultimo = nodoBuscado;
                        }else{
                            nodoActual.setLigaDer(nuevoNodo);
                            ultimo = nuevoNodo;
                        }
                    }
                }
            }
            return 1;
        } else{
            return -1;
        }
    }
    /**
     * Este metodo elimina un elemento de la lista y la reacomoda
     *
     * @param info Es el elemento a eliminar
     * @return Regresa el objeto eliminado
     */
    @Override
    public Object eliminar(Object info) {
        return super.eliminar(info);
    }
    /**
     * Este metodo añade un Nodo al inicio de la lista
     * @param info Es el nuevo valor a añadir
     * @return Regresa la posicion en donde lo agrega o -1 en caso contrario
     */
    @Override
    public int agregarInicio(Object info) {
        return agregar(info);
    }
    /**
     * Este metodo añade un Nodo al final de la lista
     * @param info Es el nuevo valor a añadir
     * @return Regresa la posicion en donde lo agrega o -1 en caso contrario
     */
    public int agregarFin(Object info) {
        return agregar(info);
    }

    /**
     * Elimina el primer elemento de la lista
     * @return Regresa el elemento eliminado
     */
    @Override
    public Object eliminarPrimero(){
        return super.eliminarPrimero();
    }
    /**
     * Elimina el último elemento de la lista
     * @return Regresa el elemento eliminado
     */
    public Object eliminarUltimo(){
        if(!vacio()){
            Object respaldo = ultimo.getInfo();
            if(primero == ultimo){
                primero=null;
                ultimo=null;
            }else{
                ListaEstatica listaDeBusqueda = buscarAnterior(ultimo);
                Nodo anterior = (Nodo) listaDeBusqueda.obtener(0);
                ultimo = anterior;
                ultimo.setLigaDer(null);
            }
            return respaldo;
        }else{
            return null;
        }
    }
    /**
     * este metodo agrega al final de la lista actual los elementos de la lista 2
     *
     * @param listaDatos es la lista a concatenar al final
     * @return REgresa true si si pudo agregarlos
     */
    @Override
    public boolean agregarLista(Object listaDatos) {
        return super.agregarLista(listaDatos);
    }
    /**
     * Agregua los elementos de una matriz 2d pasada como
     * argumento al final de una lista. Los elementos irán agregando renglón por
     * renglón o columna por columna, según se defina a través de una enumerado
     * (COLUMNA; RENGLON)
     * @param tabla Es la tabla
     * @param enumTipoTabla Es el enum que indica como agregarlos
     * @return Regresa true si puede agregarlos
     */
    @Override
    public boolean agregarMatriz2D(Matriz2 tabla, TipoTabla enumTipoTabla){
        return super.agregarMatriz2D(tabla,enumTipoTabla);
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
        return super.eliminarLista(lista2);
    }
    /**
     * este metodo elimina cada elemento de una matriz2D que
     * se encuentre en la lista actual
     *
     * @param matriz es la lista de la cual va a eliminar elemntos
     * @param enumTipoTabla Es el enum que indica como agregarlos
     * @return Regresa true si los pudo eliminar
     */
    public boolean eliminarMatriz2(Matriz2 matriz, TipoTabla enumTipoTabla) {
        if (enumTipoTabla==TipoTabla.COLUMNA){
            for (int cadaColumna=0;cadaColumna<matriz.getColumnas();cadaColumna++){
                for (int cadaRenglon=0;cadaRenglon<matriz.getRenglones();cadaRenglon++){
                    eliminar(matriz.obtener(cadaRenglon,cadaColumna));

                }
            }
            return true;
        }else if(enumTipoTabla==TipoTabla.RENGLON){
            for (int cadaRenglon=0;cadaRenglon<matriz.getRenglones();cadaRenglon++){
                for (int cadaColumna=0;cadaColumna<matriz.getRenglones();cadaColumna++){
                    eliminar(matriz.obtener(cadaRenglon,cadaColumna));
                }
            }
            return true;

        }
        return false;
    }

    //--------------------------------------------MÉTODOS DE INTERFACE LISTA---------------------------------------------------//

    /**
     * Este elemento regresa un indicador de si la lista esta vacia
     * @return Regresa true si esta <vacia> y <false> en caso contrario
     */
    public boolean vacio(){
        return super.vacio();
    }

    /**
     *Indica si la lista actual es igual a la lista2. La
     * igualdad se determina por el contenido de cada elemento en la posición
     * correspondiente al mismo índice
     * @param lista2 Es la lista a comparar
     * @return regresa <true> si son iguales y <false> si no son
     */
    public boolean esIgual(Object lista2){
        return super.esIgual(lista2);
    }
    /**
     *Este metodo cambia in objeto viejo por uno nuevo un numero especificado de veces
     * @param infoViejo Es el objeto a cambiar
     * @param infoNuevo Es el nuevo objeto
     * @param numVeces Es el numero de veces que se cambiara el objeto
     * @return Regresa true si si se cambiaron los objetos
     */

    public boolean cambiar(Object infoViejo, Object infoNuevo, int numVeces){
        eliminar(infoViejo);
        agregar(infoNuevo);
        return true;
    }

    /**
     * Busca dentro de un arreglo los
     * elementos indicados por info, si existen muchos elementos o en su caso uno; debe
     * guardar en un arreglo
     * @param info Es el objeto a buscar
     * @ Regresa  las posiciones de todas y cada una de las
     * ocurrencias del elemento buscado
     */
    public ListaEstatica buscarValores(Object info){
        return super.buscarValores(info);
    }

    /**
     * Este metodo elimina el ultimo elemento de el arreglo
     * @return Regresa el objeto eliminado
     */
    public Object eliminar(){
        return super.eliminar();
    }

    /**
     * Este metodo vacia la lista
     */
    public void vaciar(){
        super.vaciar();
    }


    /**
     * Este metodo invierte la lista
     */
    public void invertir(){
        if(orden == TipoOrden.DEC){
            setOrden(TipoOrden.INC);
            super.invertir();

        } else if (orden == TipoOrden.INC){
            setOrden(TipoOrden.DEC);
            super.invertir();
        }
    }

    /**
     * Este metodo cuenta las veces que esta un Objeto en un arreglo
     * @param info Es el objeto a contar
     * @return Regresa el numero de veces que se encontro
     */
    public int contar(Object info){
        return super.contar(info);
    }


    /**
     * Este metodo rellena todos los elementos
     * indicados por “cantidad” del arreglo con el “info” indicado
     * @param info Es el objeto con el cual sera rellenado
     * @param cantidad Es la cantidad de espacios a rellenar
     */
    public void rellenar(Object info, int cantidad){
        super.rellenar(info, cantidad);
    }

    /**
     * Este metodo clona la lista actual
     * @return Regresa la lista clonada
     */
    public ListaDinamica clonar(){
        return super.clonar();
    }

    /**
     * Este metodo regresa una lista con los elementos indicados con las posiciones inicial y final del arreglo
     * actual.
     * @param indiceInicial es la posicion inicial del arreglo
     * @param indiceFinal es la posicion final del arreglo
     * @return Regresa la lista con los 2 elementos de el principio y final
     */
    public Lista subLista(int indiceInicial, int indiceFinal){
        return super.subLista(indiceInicial, indiceFinal);
    }


    /**
     * Debe regresar un arreglo conteniendo los elementos del arreglo
     * actual que se obtienen del arreglo de índices “listaIndices”, el cual contiene las
     * posiciones de los índices de donde se obtendrán los datos a retornar.
     * @param listaIndices Son los indices a regresar.
     * @return Regresa la lista con los indices especificados
     */
    public ListaEstatica subLista(ListaEstaticaNumerica listaIndices){
        return super.subLista(listaIndices);
    }

    @Override
    public Object verTope(){
        return super.verTope();
    }

    @Override
    public boolean redimensionar(int maximo){
        return super.redimensionar(maximo);
    }
}
