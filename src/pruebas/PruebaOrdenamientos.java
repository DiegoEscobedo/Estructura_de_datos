package pruebas;

import entradaSalida.SalidaPorDefecto;
import estructurasLineales.ListaEstatica;
import utilerias.Ordenadores.QuickSort;

public class PruebaOrdenamientos {
    public static void main(String[] args) {
        QuickSort ordenarQuicksort = new QuickSort();
        ListaEstatica lista = new ListaEstatica(7);
        lista.agregar(17);
        lista.agregar(3);
        lista.agregar(2);
        lista.agregar(10);
        lista.agregar(6);
        lista.agregar(7);
        lista.agregar(5);
        lista.imprimir();
        SalidaPorDefecto.terminal("\n");
        ordenarQuicksort.quickSort(lista);
        lista.imprimir();
    }
}
