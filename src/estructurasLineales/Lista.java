package estructurasLineales;
/**
 * @version:1.0
 * @autor:ClaseED
 */
public interface Lista {
    /**
     * Este elemento regresa un indicador de si la lista esta vacia
     * @return Regresa true si esta <vacia> y <false> en caso contrario
     */
    public boolean vacio();

    /**
     * Este metodo añade un elemento a la lista
     * @param info Es el nuevo valor a añadir
     * @return Regresa la posicion en donde lo agrega o -1 en caso contrario
     */
    public int agregar(Object info);

    /**
     * Este metodo imprime las listas como una torre de el ultimo dato al menor
     */
    public void imprimir();

    /**
     * Este metodo imprime la lista de forma invertida
     */
    public void imprimirinv();

    /**
     * Este metodo busca un elemento de la lista
     * @param info Es el elemento a buscar
     * @return Regresa el indice de el elemento buscado
     */
    public Object buscar(Object info);

    /**
     * Este metodo elimina un elemento de la lista y la reacomoda
     * @param info Es el elemento a eliminar
     * @return Regresa el objeto eliminado
     */
    public Object eliminar(Object info);

    /**
     *Indica si la lista actual es igual a la lista2. La
     * igualdad se determina por el contenido de cada elemento en la posición
     * correspondiente al mismo índice
     * @param lista2 Es la lista a comparar
     * @return regresa <true> si son iguales y <false> si no son
     */
    public boolean esIgual(Object lista2);

    /**
     *Este metodo cambia in objeto viejo por uno nuevo un numero especificado de veces
     * @param infoViejo Es el objeto a cambiar
     * @param infoNuevo Es el nuevo objeto
     * @param numVeces Es el numero de veces que se cambiara el objeto
     * @return Regresa true si si se cambiaron los objetos
     */
    public boolean cambiar(Object infoViejo, Object infoNuevo, int numVeces);

    /**
     *Busca dentro de un arreglo los
     * elementos indicados por info, si existen muchos elementos o en su caso uno; debe
     * guardar en un arreglo
     * @param info Es el objeto a buscar
     * @ Regresa  las posiciones de todas y cada una de las
     * ocurrencias del elemento buscado.
     */
    public ListaEstatica buscarValores(Object info);

    /**
     * Este metodo elimina el ultimo elemento de el arreglo
     * @returnRegresa el objeto eliminado
     */
    public Object eliminar();

    /**
     * Este metodo vacia la lista
     */
    public void vaciar();

    /**
     * este metodo agrega al final de la lista actual los elementos de la lista 2
     * @param lista2 es la lista a concatenar al final
     * @return REgresa true si si pudo agregarlos
     */
    public boolean agregarLista(Object lista2);

    /**
     * Este metodo invierte la lista
     */
    public void invertir();

    /**
     * Este metodo cuenta las veces que esta un Objeto en un arreglo
     * @param info Es el objeto a contar
     * @return Regresa el numero de veces que se encontro
     */
    public int contar(Object info);

    /**
     * este metodo elimina elimina cada elemento de lista2 que
     * se encuentre en la lista actual
     * @param lista2 es la lista de la cual va a eliminar elemntos
     * @return Regresa true si si los pudo eliminar
     */
    public boolean eliminarLista(Object lista2);

    /**
     * Este metodo rellena todos los elementos
     * indicados por “cantidad” del arreglo con el “info” indicado
     * @param info Es el objeto con el cual sera rellenado
     * @param cantidad Es la cantidad de espacios a rellenar
     */
    public void rellenar(Object info, int cantidad);

    /**
     * Este metodo clona la lista actual
     * @return Regresa la lista clonada
     */
    public Lista clonar();

    /**
     * Este metodo regresa una lista con los elementos indicados con las posiciones inicial y final del arreglo
     * actual.
     * @param indiceInicial es la posicion inicial del arreglo
     * @param indiceFinal es la posicion final del arreglo
     * @return Regresa la lista con los 2 elementos de el principio y final
     */
    public Lista subLista(int indiceInicial, int indiceFinal);


    /**
     * Debe regresar un arreglo conteniendo los elementos del arreglo
     * actual que se obtienen del arreglo de índices “listaIndices”, el cual contiene las
     * posiciones de los índices de donde se obtendrán los datos a retornar.
     * @param listaIndices Son los indices a regresar.
     * @return Regresa la lista con los indices especificados
     */
    public ListaEstatica subLista(ListaEstaticaNumerica listaIndices);
    public Object verTope();
    public void recibeBuffer(Object buffer[]);

    /**
     * Este metodo elimina el primer elemento del arreglo
     *
     * @return Regresa el objeto eliminado
     */
    public Object eliminarPrimero();

    boolean redimensionar(int maximo);
}
