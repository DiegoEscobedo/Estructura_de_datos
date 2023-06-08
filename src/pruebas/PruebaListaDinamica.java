package pruebas;

import entradaSalida.SalidaPorDefecto;
import estructurasLineales.Lista;
import estructurasLineales.ListaDinamica;
import estructurasLineales.ListaEstatica;
import estructurasLineales.ListaEstaticaNumerica;
import estructurasLineales.auxiliares.Nodo;
import estructurasNoLineales.Matriz2;
import utilerias.comunes.TipoTabla;
import utilerias.matematicas.RecursividadMatematica;

public class PruebaListaDinamica {
    public static void main(String[] args) {
        ListaDinamica lista = new ListaDinamica();
        lista.agregar("a");
        lista.agregar("b");
        lista.agregar("c");
        lista.agregar("d");
        lista.agregar("f");
        lista.agregar("g");
        lista.imprimirListaEnlazada(lista.getPrimero());
        /*
        lista.rellenar("a", 3);
        SalidaPorDefecto.terminal("imprimir lista1 dinamica.." + "\n");
        lista.imprimir();
        SalidaPorDefecto.terminal("\n");
        SalidaPorDefecto.terminal("Obtener una sublista desde el indice 3 hasta al 6" + "\n");
        lista.subLista(3,6).imprimir();
        SalidaPorDefecto.terminal("Obtener una lista con los indices de la siguiente lista:" + "\n");
        ListaEstaticaNumerica listaindices = new ListaEstaticaNumerica(5);
        listaindices.agregar(0);
        listaindices.agregar(2);
        listaindices.agregar(3);
        listaindices.agregar(5);
        listaindices.agregar(7);
        listaindices.imprimir();
        SalidaPorDefecto.terminal("sublista obtenida:" + "\n");
        lista.subLista(listaindices).imprimir();
        SalidaPorDefecto.terminal("Eliminar la siguiente lista de la lista original" + "\n");
        ListaEstatica listaEliminar = new ListaEstatica(3);
        listaEliminar.agregar("c");
        listaEliminar.agregar("d");
        listaEliminar.agregar("f");
        listaEliminar.imprimir();
        SalidaPorDefecto.terminal("Resultado..." + "\n");
        lista.eliminarLista(listaEliminar);
        lista.imprimir();
        SalidaPorDefecto.terminal("\n");
        SalidaPorDefecto.terminal("Obtener los valores 'a' de la lista original" + "\n");
        lista.buscarValores("a").imprimir();
        */
    }
}
