package pruebas;

import entradaSalida.SalidaPorDefecto;
import estructurasNoLineales.ListaDinamicaParalela;

public class PruebaListaDinamicaParalela {
    public static void main(String[] args) {
        ListaDinamicaParalela listaDP = new ListaDinamicaParalela();
        listaDP.agregar("A");
        listaDP.agregar("B");
        listaDP.agregar("C");
        listaDP.agregar("D");
        listaDP.agregar("E");
        listaDP.agregar("F");

        listaDP.imprimir();

        listaDP.eliminar();
        SalidaPorDefecto.terminal("\n");

        listaDP.imprimir();

        SalidaPorDefecto.terminal("Buscando A... " + listaDP.buscar("A"));

    }
}
