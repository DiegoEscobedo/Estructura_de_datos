package estructurasLineales;

import utilerias.comunes.Comparador;
import utilerias.comunes.TipoOrden;

import static utilerias.comunes.TipoOrden.*;

/**
 * @author diego
 * @version 1.0
 */
public class ListaEstaticaOrdenada extends ListaEstatica{
    private static TipoOrden orden;

    public ListaEstaticaOrdenada(int tamanio, TipoOrden orden) {
        super(tamanio);
        ListaEstaticaOrdenada.orden = orden;
    }

    public static void setOrden(TipoOrden orden) {
        ListaEstaticaOrdenada.orden = orden;
    }

    public static TipoOrden getOrden() {
        return orden;
    }

    @Override
    public int agregar(Object info){
        if(llena()== false){
            int posicion = (int)buscar(info);
            if(posicion<0){
                tope++;
                posicion = posicion*-1;
                posicion--;
                for(int movs = tope; movs > posicion; movs--){
                    informacion[movs] = informacion[movs-1];
                }
                informacion[posicion] = info;
                return posicion;
            }
            return -1;
        }
        return -1;
    }


    @Override
    public Object buscar(Object info){
        int posicion = 0;
        if(orden == TipoOrden.INC){
            while (posicion <= tope && (int)(Comparador.comparar(info, informacion[posicion])) > 0){
                posicion++;
            }
            //si no esta en
            if(posicion>tope || (int)(Comparador.comparar(info, informacion[posicion])) < 0){
                return (posicion+1)*-1;
            }
            //si si esta
            return posicion+1;
        }
        if(orden == TipoOrden.DEC){
            while (posicion <= tope && (int)(Comparador.comparar(informacion[posicion], info)) > 0){
                posicion++;
            }
            //si no esta en la lista
            if(posicion>tope || (int)(Comparador.comparar(informacion[posicion], info)) < 0){
                return (posicion+1)*-1;
            }
            //si si esta en la lista
            return posicion+1;
        }
        return null;
    }

    public void invertir() {
        ListaEstaticaOrdenada listaAuxiliar = new ListaEstaticaOrdenada(MAXIMO, TipoOrden.DEC);
        for (int indice = 0; indice < MAXIMO; indice++) {
            listaAuxiliar.agregar(obtener(indice));
        }
        vaciar();
        if (getOrden() == TipoOrden.INC) {
            setOrden(TipoOrden.DEC);
            for (int indice = 0; indice < MAXIMO; indice++) {
                agregar(listaAuxiliar.obtener(indice));
            }
        } else if (getOrden() == TipoOrden.DEC) {
            setOrden(TipoOrden.INC);
            for (int indice = 0; indice < MAXIMO; indice++) {
                agregar(listaAuxiliar.obtener(indice));
            }
        }
    }
    @Override
    public boolean cambiar(Object valorViejo, Object valorNuevo, int numOcurrencias){
        if((int)buscar(valorViejo) > 0){
            eliminar(valorViejo);
            agregar(valorNuevo);
            return true;
        }
        return false;
    }

    @Override
    public boolean cambiar(int indice, Object info){
        if(indice <= tope){
            eliminar(indice);
            agregar(info);
            return true;
        }
        return false;
    }

    @Override
    public boolean agregarLista(Object lista2){
        if(lista2 instanceof ListaEstaticaOrdenada){
            for(int indice = 0; indice <= MAXIMO-1; indice++){
                agregar(((ListaEstaticaOrdenada) lista2).obtener(indice));
            }
            return true;
        }
        return false;
    }

    /**
     * Desordena el arreglo
     * @return regresa la lista con el arreglo desordenado
     */
    public Lista arregloDesordenado(){
        ListaEstatica listaDesordenada = new ListaEstatica(MAXIMO);
        for (int cadaElemento = (tope/2)+1;cadaElemento<tope+1;cadaElemento++){
            listaDesordenada.agregar(obtener(cadaElemento));
        }
        for(int cadaElemento = 0; cadaElemento<tope/2+1;cadaElemento++){
            listaDesordenada.agregar(obtener(cadaElemento));
        }
        return listaDesordenada;
    }

    /**
     * Debe cambiar los elementos de lista2 que se encuentren en la lista
     * actual con los elementos de la lista2Nuevos. Cada elemento de lista2 coincide en
     * posición con su nuevo valor a cambiar en lista2Nuebos
     * @param lista2 Es la lista con indices a buscar
     * @param lista2Nueva son los objetos que tiene que insertar
     * @return regresa true si si cambia la lista
     */
    public boolean cambiarLista(Lista lista2, Lista lista2Nueva){
        if(lista2 instanceof ListaEstatica && lista2Nueva instanceof ListaEstatica){
            for(int indice = 0; indice < ((ListaEstatica) lista2).MAXIMO; indice++){
                if((int)Comparador.comparar(((ListaEstatica) lista2).obtener(indice), obtener((int)buscar(((ListaEstatica) lista2).obtener(indice))-1)) == 0){
                    cambiar(obtener((int)buscar(((ListaEstatica) lista2).obtener(indice))-1), ((ListaEstatica) lista2Nueva).obtener(indice), 1 );
                }
            }
            return true;
        }
        return false;
    }

    /**
     * Retiene los objetos de lista 2 que esten  en la lista principal y son los que deja en la lista principal
     * @param lista2 es la lista con los objetos a retener
     * @return regresa true si si tiene objetos iguales
     */
    public boolean retenerLista(Lista lista2){
        if(lista2 instanceof ListaEstatica){
            for(int indice = 0; indice < ((ListaEstatica) lista2).MAXIMO; indice++){
                if((int)Comparador.comparar(((ListaEstatica) lista2).obtener(indice), obtener((int)buscar(((ListaEstatica) lista2).obtener(indice))-1)) == 0){
                    eliminar((int)buscar(((ListaEstatica) lista2).obtener(indice)));
                }
            }
        }
        return false;
    }
    @Override
    public Object verTope(){
        if(!vacio()){
            return informacion[tope];
        }else{
            return null;
        }
    }
}
