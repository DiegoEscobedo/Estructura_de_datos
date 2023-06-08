package pruebas;

import entradaSalida.SalidaPorDefecto;
import estructurasLineales.ListaEstatica;
/**
 * @version1.0
 * @autor:Clase ED
 */
public class PruebaListaEstatica {
    public static void main(String[] args) {
        ListaEstatica lista = new ListaEstatica(10);
        lista.agregar("a");
        lista.agregar("b");
        lista.agregar("c");
        lista.agregar("d");
        lista.agregar("e");
        lista.agregar("f");
        lista.agregar("a");
        lista.imprimir();
        SalidaPorDefecto.terminal("\n");
        SalidaPorDefecto.terminal("Buscando a f: " + lista.buscar("f") + "\n");
        SalidaPorDefecto.terminal("Buscando a nemo: " + lista.buscar("nemo") + "\n");
        SalidaPorDefecto.terminal("Eliminando a d: " + lista.eliminar("d") + "\n");
        SalidaPorDefecto.terminal("Eliminando a nemo: " + lista.eliminar("nemo") + "\n");
        lista.imprimir();

        ListaEstatica listaclonada = (ListaEstatica) lista.clonar();
        SalidaPorDefecto.terminal("clonando... " + "\n");
        listaclonada.imprimir();
        SalidaPorDefecto.terminal("-------------------"+ "\n");

        SalidaPorDefecto.terminal("Son iguales las listas?" + "\n");
        if (lista.esIgual(listaclonada) == true) {
            SalidaPorDefecto.terminal("si"+ "\n");
        }
        SalidaPorDefecto.terminal("---------------------"+ "\n");

        SalidaPorDefecto.terminal("cambiar de la lista principal a por x"+ "\n");
        lista.cambiar("a","x",1);
        lista.imprimir();
        SalidaPorDefecto.terminal("-----------------------"+ "\n");

        ListaEstatica listavalores = lista.buscarValores("b"+ "\n");
        SalidaPorDefecto.terminal("busca los valores b"+ "\n");
        listavalores.imprimir();
        SalidaPorDefecto.terminal("-----------------------"+ "\n");

        SalidaPorDefecto.terminal("elimina" + lista.eliminar() + "\n");
        lista.imprimir();
        SalidaPorDefecto.terminal("-----------------------"+ "\n");

        ListaEstatica lista2 = new ListaEstatica(10);
        lista.agregar("a");
        lista.agregar("b");
        lista.agregar("c");
        SalidaPorDefecto.terminal("agrega la lista 2 a la lista" + lista.agregarLista(lista2 + "\n"));lista.imprimir();
        SalidaPorDefecto.terminal("-----------------------"+ "\n");

        SalidaPorDefecto.terminal("cuenta las a" + "\n");
        lista.contar("a");
        lista.imprimir();
        SalidaPorDefecto.terminal("-----------------------"+ "\n");

        SalidaPorDefecto.terminal("no me gusto ahora elimina los elementos de las lista 2" + lista.eliminarLista(lista2) + "\n");
        lista.imprimir();
        SalidaPorDefecto.terminal("-----------------------"+ "\n");

        SalidaPorDefecto.terminal("rellena 3 espacios con letras s" + "\n");
        lista.rellenar("s", 1);
        lista.imprimir();
        SalidaPorDefecto.terminal("-----------------------"+ "\n");

        ListaEstatica listarecortada = new ListaEstatica(4);
        SalidaPorDefecto.terminal("dame una lista del 1er al 3er elemento" + "\n");
        lista.subLista(0, 2);
        lista.imprimir();
        SalidaPorDefecto.terminal("-----------------------"+ "\n");

        SalidaPorDefecto.terminal("Cambiame el objeto 1 por una w" + lista.cambiar(0, "w") + "\n");
        lista.imprimir();
        SalidaPorDefecto.terminal("-----------------------"+ "\n");

        SalidaPorDefecto.terminal("redimensiona la lista a 6 elementos" + lista.redimensionar(6) + "\n");
        lista.imprimir();
        SalidaPorDefecto.terminal("-----------------------"+ "\n");

        ListaEstatica listaindices = new ListaEstatica(5);
        listaindices.agregar(0);
        listaindices.agregar(2);
        listaindices.agregar(3);
        ListaEstatica listaobjetos = new ListaEstatica(5);
        listaobjetos.agregar("q");
        listaobjetos.agregar("e");
        listaobjetos.agregar("r");
        SalidaPorDefecto.terminal("cambia la lista por una nueva" + "\n" );
        lista.cambiarListaEstatica(listaindices,listaobjetos);
        lista.imprimir();
        SalidaPorDefecto.terminal("-----------------------"+ "\n");

        SalidaPorDefecto.terminal("vacia la lista");
        lista.vaciar();

        lista.imprimir();
        SalidaPorDefecto.terminal("\n");

    }
}
