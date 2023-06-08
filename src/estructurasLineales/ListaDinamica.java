package estructurasLineales;

import entradaSalida.SalidaPorDefecto;
import estructurasLineales.auxiliares.Nodo;
import estructurasNoLineales.Matriz2;
import utilerias.comunes.Comparador;
import utilerias.comunes.TipoTabla;

/**
 * @author diego
 * @version 1.0
 */
public class ListaDinamica implements Lista{
    protected Nodo primero;

    protected Nodo ultimo;
    protected Nodo nodoActual;

    public ListaDinamica() {
        primero = null;
        ultimo = null;
        nodoActual = null;
    }

    public Nodo getPrimero() {
        return primero;
    }

    public void setPrimero(Nodo primero) {
        this.primero = primero;
    }

    public Nodo getUltimo() {
        return ultimo;
    }

    public void setUltimo(Nodo ultimo) {
        this.ultimo = ultimo;
    }

    public Nodo getNodoActual() {
        return nodoActual;
    }

    public void setNodoActual(Nodo nodoActual) {
        this.nodoActual = nodoActual;
    }

    /**
     * Este elemento regresa un indicador de si la lista esta vacia
     *
     * @return Regresa true si esta <vacia> y <false> en caso contrario
     */
    @Override
    public boolean vacio() {
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
    /**
     * Este metodo añade un elemento a la lista
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
            } else {
                ultimo.setLigaDer(nuevoNodo);
            }
            ultimo = nuevoNodo;
            return 1;
        } else{
            return -1;
        }
    }
    /**
     * Este metodo añade un Nodo al inicio de la lista
     * @param info Es el nuevo valor a añadir
     * @return Regresa la posicion en donde lo agrega o -1 en caso contrario
     */
    public int agregarInicio(Object info) {
        Nodo nuevoNodo = new Nodo(info);
        if (nuevoNodo != null) {
            if (vacio()) {
                primero = nuevoNodo;
                ultimo = nuevoNodo;
            } else {
                nuevoNodo.setLigaDer(primero);
                primero = nuevoNodo;
            }
            return 1;
        } else{
            return -1;
        }
    }
    /**
     * Este metodo imprime las listas como una torre de el ultimo dato al menor
     */
    @Override
    public void imprimir() {
        Nodo temporal = primero;
        while(temporal != null){
            SalidaPorDefecto.terminal(temporal.getInfo()+ " -> ");
            temporal = temporal.getLigaDer();
        }
        SalidaPorDefecto.terminal("null");
    }

    /**
     * Este metodo imprime la lista de forma invertida
     */
    @Override
    public void imprimirinv() {
        inicializarIterador();
        PilaEstatica pila = new PilaEstatica(contarValores());
       while (nodoActual != null) {
            pila.poner(nodoActual.getInfo());
            nodoActual = nodoActual.getLigaDer();
        }
        SalidaPorDefecto.terminal("null");
        while (!pila.vacio()) {
            SalidaPorDefecto.terminal(" <- " + pila.quitar());
        }
    }

    public int buscarPos(Object info) {
        Nodo nodoBuscar = primero;
        int posicion = 0;
        while (nodoBuscar != null && !(info.toString().equalsIgnoreCase(nodoBuscar.getInfo().toString()))){
            nodoBuscar = nodoBuscar.getLigaDer();
            posicion++;
        }
        if (nodoBuscar != null){
            return posicion;
        }
        return -1;
    }
    /**
     * Este metodo busca un elemento de la lista
     *
     * @param info Es el elemento a buscar
     * @return Regresa del elemento buscado
     */
    @Override
    public Object buscar(Object info) {
        Nodo nodoBuscar = primero;
        while (nodoBuscar != null && !(info.toString().equalsIgnoreCase(nodoBuscar.getInfo().toString()))){
            nodoBuscar = nodoBuscar.getLigaDer();
        }
        if (nodoBuscar != null){
            return nodoBuscar.getInfo();
        }
        return null;
    }

    /**
     * Este metodo busca un nodo anterior al que se quiere buscar
     *
     * @param info Es el elemento a buscar
     * @return Regresa la lista con los Nodos anterior y el que se busca;
     */
    public ListaEstatica buscarAnterior(Object info) {
        ListaEstatica listareturn = new ListaEstatica(2);
        Nodo nodoAnterior = primero;
        Nodo nodoBuscar = primero;
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
     * Este metodo elimina un elemento de la lista y la reacomoda
     *
     * @param info Es el elemento a eliminar
     * @return Regresa el objeto eliminado
     */
    @Override
    public Object eliminar(Object info) {
        if(!vacio()) {
            ListaEstatica listaDeBusqueda = buscarAnterior(info);
            Nodo anterior = (Nodo) listaDeBusqueda.obtener(0);
            Nodo nodoBuscado = (Nodo) listaDeBusqueda.obtener(1);
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
                    Nodo siguiente = nodoBuscado.getLigaDer();
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
     * este metodo elimina cada elemento de lista2 que
     * se encuentre en la lista actual
     *
     * @param lista2 es la lista de la cual va a eliminar elemntos
     * @return Regresa true si si los pudo eliminar
     */
    @Override
    public boolean eliminarLista(Object lista2) {
        if(lista2 instanceof ListaEstatica){
            for (int cadaElemnto=0;cadaElemnto<=((ListaEstatica) lista2).getTope();cadaElemnto++){
                inicializarIterador();
                while (nodoActual != null) {
                    if ((int) Comparador.comparar(nodoActual.getInfo(), ((ListaEstatica) lista2).obtener(cadaElemnto)) == 0) {
                        eliminar(((ListaEstatica) lista2).obtener(cadaElemnto));
                    }

                    nodoActual = nodoActual.getLigaDer();
                }
            }
        }
        return true;
    }
    /**
     * Pasa la lista estatica pero descarta los elemntos de la lista que se le pasa como argumento
     * @param elemtosADescartar son los elementos a descartar
     * @return Regresa la lista ya sin los elementos
     */
    public ListaEstatica aListaEstatica(ListaEstatica elemtosADescartar){
        ListaEstatica listaEstatica= aListaEstatica();
        listaEstatica.eliminarLista(elemtosADescartar);
        return listaEstatica;
    }

    /**
     * Convierte la Lista Dinamica a una Lista Estatica
     * @return
     */
    public ListaEstatica aListaEstatica(){
        inicializarIterador();
        ListaEstatica lista = new ListaEstatica(1);
        int contador = 1;
        while (nodoActual != null){
            lista.redimensionar(contador);
            lista.agregar(nodoActual.getInfo());
            nodoActual = nodoActual.getLigaDer();
            contador++;
        }
        return lista;
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
        if(lista2 instanceof ListaDinamica){
            if(contarValores() == ((ListaDinamica) lista2).contarValores()){
                inicializarIterador();
                ((ListaDinamica) lista2).inicializarIterador();
                Nodo otroNodoActual = ((ListaDinamica) lista2).nodoActual;
                while (nodoActual != null){
                    if((int)Comparador.comparar(nodoActual, otroNodoActual) == 0){
                        nodoActual = nodoActual.getLigaDer();
                        otroNodoActual = otroNodoActual.getLigaDer();
                    } else {
                        return false;
                    }
                }
                return true;
            } else{
                return false;
            }
        } else if( lista2 instanceof ListaEstatica){
            if(contarValores() == ((ListaEstatica) lista2).getTope()+1){
                int cadaIndice = 0;
                inicializarIterador();
                while (nodoActual != null){
                    if((int)Comparador.comparar(nodoActual, ((ListaEstatica) lista2).obtener(cadaIndice)) == 0){
                        nodoActual = nodoActual.getLigaDer();
                        cadaIndice++;
                    } else {
                        return false;
                    }
                }
                return true;
            } else {
                return false;
            }
        }
        return false;
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
     * Este metodo cambia in objeto viejo por uno nuevo un numero especificado de veces
     *
     * @param infoViejo Es el objeto a cambiar
     * @param infoNuevo Es el nuevo objeto
     * @param numVeces  Es el numero de veces que se cambiara el objeto
     * @return Regresa true si si se cambiaron los objetos
     */
    @Override
    public boolean cambiar(Object infoViejo, Object infoNuevo, int numVeces) {
        int veces = 0;
        inicializarIterador();
        while (nodoActual != null && veces < numVeces){
            if((int) Comparador.comparar(nodoActual.getInfo(), infoViejo) == 0){
                nodoActual.setInfo(infoNuevo);
                veces++;
            }
            nodoActual = nodoActual.getLigaDer();
        }
        return true;
    }

    /**
     * Busca dentro de un arreglo los
     * elementos indicados por info, si existen muchos elementos o en su caso uno; debe
     * guardar en un arreglo
     *
     * @param info Es el objeto a buscar
     * @Regresa  las posiciones de todas y cada una de las
     * ocurrencias del elemento buscado
     */
    @Override
    public ListaEstatica buscarValores(Object info) {
        ListaEstatica listaEstatica = new ListaEstatica(contarValores());
        int pos=0;
        inicializarIterador();

        while (nodoActual != null){
            if ((int) Comparador.comparar(nodoActual.getInfo(),info)==0){
                listaEstatica.agregar(pos);

            }

            nodoActual = nodoActual.getLigaDer();
            pos++;
        }
        return listaEstatica;
    }

    /**
     * Este metodo elimina el último elemento de el arreglo
     *
     * @return Regresa el objeto eliminado
     */
    @Override
    public Object eliminar() {
        if(!vacio()){
            Object respaldo = ultimo.getInfo();
            if(primero == ultimo){
                respaldo = ultimo.getInfo();
                primero=null;
                ultimo=null;
            }else{
                Nodo penultimo = primero;
                while (penultimo.getLigaDer().getInfo() != ultimo.getInfo()){
                    penultimo = penultimo.getLigaDer();
                }
                ultimo = penultimo;
                penultimo.setLigaDer(null);
            }
            return respaldo;
        }else{
            return null;
        }
    }

    /**
     * Elimina el primer elemento de la lista
     * @return Regresa el elemento eliminado
     */
    @Override
    public Object eliminarPrimero() {
        Object respaldo;
        if(!vacio()){
            if(primero == ultimo){
                respaldo = ultimo.getInfo();
                primero=null;
                ultimo=null;
            }else{
                respaldo = primero.getInfo();
                primero = primero.getLigaDer();
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
        primero = null;
        ultimo = null;
        nodoActual = null;
    }

    /**
     * este metodo agrega al final de la lista actual los elementos de la lista 2
     *
     * @param listaDatos es la lista a concatenar al final
     * @return REgresa true si si pudo agregarlos
     */
    @Override
    public boolean agregarLista(Object listaDatos) {
        if(listaDatos instanceof ListaEstatica){
            for(int cadaIndice = 0; cadaIndice <= ((ListaEstatica) listaDatos).getTope(); cadaIndice++){
                agregar(((ListaEstatica) listaDatos).obtener(cadaIndice));
            }
            return true;
        } else if(listaDatos instanceof ListaDinamica){
            ((ListaDinamica) listaDatos).inicializarIterador();
            while (((ListaDinamica) listaDatos).nodoActual != null){
                agregar(((ListaDinamica) listaDatos).nodoActual);
                ((ListaDinamica) listaDatos).nodoActual = ((ListaDinamica) listaDatos).nodoActual.getLigaDer();
            }
            return true;
        }
        return false;
    }

    /**
     * Este metodo invierte la lista
     */
    @Override
    public void invertir() {
        ListaEstatica auxiliar = clonar().aListaEstatica();
        vaciar();
        while (auxiliar.obtener(0) != null){
            agregar(auxiliar.eliminar());
        }

    }

    /**
     * Este metodo cuenta las veces que esta un Objeto en un arreglo
     *
     * @param info Es el objeto a contar
     * @return Regresa el numero de veces que se encontro
     */
    @Override
    public int contar(Object info) {
        int contador = 0;
        inicializarIterador();
        while (nodoActual != null){
            if(nodoActual.getInfo() == info){
                contador++;
            }
            nodoActual = nodoActual.getLigaDer();
        }
        return contador;
    }

    /**
     * Este metodo rellena todos los elementos
     * indicados por “cantidad” del arreglo con el “info” indicado
     *
     * @param info Es el objeto con el cual sera rellenado
     * @param cantidad Es la cantidad de espacios a rellenar
     */
    @Override
    public void rellenar(Object info, int cantidad) {
        for (int cadaCantidad = 0; cadaCantidad < cantidad; cadaCantidad++) {
            agregar(info);
        }
    }

    /**
     * Este metodo clona la lista actual
     *
     * @return Regresa la lista clonada
     */
    @Override
    public ListaDinamica clonar() {
        inicializarIterador();
        ListaDinamica lista = new ListaDinamica();
        while(nodoActual != null){
            lista.agregar(nodoActual.getInfo());
            nodoActual = nodoActual.getLigaDer();
        }
        return lista;
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
        Lista listanueva = new ListaEstatica(1);
        int cadaIndice = 0;
        int contador = 1;
        inicializarIterador();
        while (nodoActual != null){
            if(cadaIndice == indiceInicial){
                    while(cadaIndice <= indiceFinal && nodoActual != null){
                        listanueva.redimensionar(contador);
                        listanueva.agregar(nodoActual.getInfo());
                        cadaIndice++;
                        nodoActual = nodoActual.getLigaDer();
                        contador++;
                    }
                    break;
            }
            cadaIndice++;
            nodoActual = nodoActual.getLigaDer();
        }
        return listanueva;
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
        ListaEstatica nuevaLista = new ListaEstatica(1);
        int indice;
        int contador = 1;
        for(int cadaIndice = 0; cadaIndice <= listaIndices.tope; cadaIndice++){
            indice = (int) listaIndices.obtener(cadaIndice);
            int cadaIndiceN = 0;
            inicializarIterador();
            while (nodoActual != null){
                if(cadaIndiceN == indice){
                    nuevaLista.redimensionar(contador);
                    nuevaLista.agregar(nodoActual.getInfo());
                    contador++;
                    break;
                }
                cadaIndiceN++;
                nodoActual = nodoActual.getLigaDer();
            }
        }
        return nuevaLista;
    }

    /**
     * @return Regresa el ultimo valor
     */
    @Override
    public Object verTope() {
        return ultimo.getInfo();
    }

    /**
     * @param buffer
     */
    @Override
    public void recibeBuffer(Object[] buffer) {}


    /**
     * Agregua los elementos de una matriz 2d pasada como
     * argumento al final de una lista. Los elementos irán agregando renglón por
     * renglón o columna por columna, según se defina a través de una enumerado
     * (COLUMNA; RENGLON)
     * @param tabla Es la tabla
     * @param enumTipoTabla Es el enum que indica como agregarlos
     * @return Regresa true si puede agregarlos
     */
    public boolean agregarMatriz2D(Matriz2 tabla, TipoTabla enumTipoTabla){

        if (enumTipoTabla==TipoTabla.COLUMNA){
            for (int cadaColumna=0;cadaColumna<tabla.getColumnas();cadaColumna++){
                for (int cadaRenglon=0;cadaRenglon<tabla.getRenglones();cadaRenglon++){
                    agregar(tabla.obtener(cadaRenglon,cadaColumna));

                }
            }
            return true;

        }else if(enumTipoTabla==TipoTabla.RENGLON){
            for (int cadaRenglon=0;cadaRenglon<tabla.getRenglones();cadaRenglon++){
                for (int cadaColumna=0;cadaColumna<tabla.getRenglones();cadaColumna++){
                    agregar(tabla.obtener(cadaRenglon,cadaColumna));

                }
            }
            return true;

        }
        return false;
    }

    /**
     * Cambia un objeto en un indice espicificado
     * @param indice Es el indice del objeto a cambiar
     * @param info Es el nuevo objeto
     * @return Regresa true di lo cambio
     */
    public boolean cambiar(int indice, Object info){
        int cadaIndice = 0;
        inicializarIterador();
        while (nodoActual != null){
            if(cadaIndice == indice){
                nodoActual.setInfo(info);
            }
            cadaIndice++;
            nodoActual = nodoActual.getLigaDer();
        }
        return true;
    }

    /**
     * Obtiene un objeto de un indice especifico
     * @param indice Es el indice
     * @return Regresa el objeto
     */
    public Object obtener(int indice){
        int cadaIndice = 0;
        inicializarIterador();
        while (nodoActual != null){
            if(cadaIndice == indice){
                return nodoActual.getInfo();
            }
            cadaIndice++;
            nodoActual = nodoActual.getLigaDer();
        }
        return null;
    }

    /**
     * REdimensiona la lista dinamica(solo cambia la informacion que contiene segun sea el caso)
     * @param maximo Es el nuevo tamaño
     * @return Regresa true si lo hizo
     */
    @Override
    public boolean redimensionar(int maximo) {
        if (contarValores() < maximo) {
            int cuantosNull = maximo - contarValores();
            for (int cadaValor = 0; cadaValor < cuantosNull; cadaValor++) {
                agregar(null);
            }
        } else if (contarValores() > maximo) {
            int cuantosBorrar = contarValores() - maximo;
            for (int cadaValor = 0; cadaValor < cuantosBorrar; cadaValor++) {
                eliminar();
            }
        }
        return true;
    }

    /**
     * Elimina un objeto en un indice
     * @param indice Es el indice
     * @return Regresa el objeto eliminado
     */
    public Object eliminar(int indice){
        ListaEstatica listaDeNodos;
        int cadaIndice = 0;
        inicializarIterador();
        Object respaldo = null;
        while (nodoActual != null){
            if(cadaIndice == indice){
                respaldo = nodoActual;
                Object info = nodoActual;
                listaDeNodos = buscarAnterior(info);
                Nodo anterior = (Nodo) listaDeNodos.obtener(0);
                Nodo nodoBuscado = (Nodo) listaDeNodos.obtener(1);
                nodoActual = nodoActual.getLigaDer();
                anterior.setLigaDer(nodoActual);
            }
            cadaIndice++;
            nodoActual = nodoActual.getLigaDer();
        }
        return respaldo;
    }

    /**
     * Guarda los elementos de una lista en una matriz 2d. A este
     * método se le pasarán el número de renglones y columnas de la matriz resultante.
     * En caso que no se ajusten de renglones o columnas con la cantidad de elementos
     * de la lista, se deben rellenar con null:
     * @param filas Son el numero de filas
     * @param columnas Es el numero de columnas
     * @return
     */
    public Matriz2 aMatriz2(int filas, int columnas){
        Matriz2 matriz = new Matriz2(filas, columnas, null);
        int cadaCol = 0;
        int cadaFila = 0;
        inicializarIterador();
        while (nodoActual != null){
            if(cadaFila == filas){
                cadaFila = 0;
                cadaCol++;
                matriz.cambiar(cadaFila, cadaCol, nodoActual.getInfo());
            } else {
                matriz.cambiar(cadaFila, cadaCol, nodoActual.getInfo());
            }
            nodoActual = nodoActual.getLigaDer();
            cadaFila++;
        }
        return matriz;
    }
    public static void imprimirListaEnlazada(Nodo nodoTemporal){
        if(nodoTemporal != null){
            SalidaPorDefecto.terminal(nodoTemporal.getInfo() + " -> ");
            imprimirListaEnlazada(nodoTemporal.getLigaDer());
        }else{
            SalidaPorDefecto.terminal("null");
        }
    }
}
