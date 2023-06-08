package pruebas;

import entradaSalida.SalidaPorDefecto;
import estructurasLineales.ListaEstatica;
import estructurasLineales.ListaEstaticaNumerica;

public class PruebaListaEstaticaNumerica {
    public static void main(String[] args) {
        ListaEstaticaNumerica lista = new ListaEstaticaNumerica(4);
        lista.agregar(3);
        lista.agregar(4);
        lista.agregar(5);
        lista.agregar("b");
        lista.agregar(11);
        lista.imprimir();
        ListaEstaticaNumerica lista2 = new ListaEstaticaNumerica(4);
        lista2.agregar(0);
        lista2.agregar(0);
        lista2.agregar(0);
        lista2.agregar(0);
        SalidaPorDefecto.terminal("Vector:" + "\n");
        lista2.imprimir();
        SalidaPorDefecto.terminal("El arreglo es otrogonal?--" + lista.sonLinealmenteDependientes(lista2) +
                " ...Entonces son Linealmente independientes " + lista.sonLinealmenteIndependientes(lista2));
        ;
    }
}
