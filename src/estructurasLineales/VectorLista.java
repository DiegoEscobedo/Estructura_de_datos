package estructurasLineales;
/**
 * @version1.0
 * @autor:Clase ED
 */
public interface VectorLista extends Lista{
    /**
     * Verifica si la lista esta llena
     * @return Regresa <true> si esta llena y <false> si no lo esta
     */
    public boolean llena();

    /**
     * Este metodo regresa el maximo de espacios de la lista
     * @return Regresa el maximo de espacios de la lista
     */
    public int maximo();

    /**
     * Este metodo regresa la cantidad de datos dentro de la lista
     * @return Regresa la cantidad de datos dentro de la lista
     */
    public int cantidad();

    /**
     * Este metodo obtiene el objeto en el indice especificado
     * @param indice Es el indice de el objeto
     * @return Regresa el objeto
     */
    public Object obtener(int indice);

    /**
     * Este metodo cambia el objeto de un indice especificado por otro objeto
     * @param indice Es el indice del objeto que se va a cambiar
     * @param info Es el objeto
     * @return Regresa true si se cambio
     */
    public boolean cambiar(int indice, Object info);

    /**
     * Este objeto Le agrega indices con objetos nuevos a la lista
     * @param indicesNuevos Es el indice nuevo
     * @param infosNuevos Es el objeto nuevo
     * @return Regresa true si si se modifico
     */
    public boolean cambiarListaEstatica(ListaEstatica indicesNuevos, ListaEstatica infosNuevos);

    /**
     * Este metodo elimina un objeto de un indice especificado
     * @param indice Es el indice de el objeto a eliminar
     * @return Regresa el objeto eliminado
     */
    public Object eliminar(int indice);

    /**
     * Este metodo redimensiona el tamaño de el arreglo
     * @param maximo Es la nueva dimension de el arreglo
     * @return Regresa true si si se redimensiono
     */
    public boolean redimensionar(int maximo);

}
