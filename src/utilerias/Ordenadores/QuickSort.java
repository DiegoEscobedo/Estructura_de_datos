package utilerias.Ordenadores;

import entradaSalida.SalidaPorDefecto;
import estructurasLineales.ListaDinamica;
import estructurasLineales.ListaEstatica;
import estructurasLineales.PilaDinamica;
import utilerias.comunes.Comparador;

public class QuickSort {
    public void quickSortRecursivo(ListaEstatica lista) {
        quickSort(lista, 0, lista.getTope());
    }
    private void quickSort(ListaEstatica lista, int indiceIzq, int indiceDer) {
        if (indiceIzq < indiceDer) {
            int pivotindice = particion(lista, indiceIzq, indiceDer);
            quickSort(lista, indiceIzq, pivotindice - 1);
            quickSort(lista, pivotindice + 1, indiceDer);
        }
    }


    private static int particion(ListaEstatica lista, int indiceIzq, int indiceDer) {
        Object pivot = lista.obtener(indiceDer);
        int indice = indiceIzq - 1;

        for (int cadaObjeto = indiceIzq; cadaObjeto < indiceDer; cadaObjeto++) {
            if (lista.obtener(cadaObjeto) != null && (int)Comparador.comparar(lista.obtener(cadaObjeto), pivot) < 0) {
                indice++;
                swap(lista, indice, cadaObjeto);
            }
        }

        swap(lista, indice + 1, indiceDer);
        return indice + 1;
    }

    private static void swap(ListaEstatica lista, int indice, int objeto2) {
        Object temp = lista.obtener(indice);
        lista.cambiar(indice, lista.obtener(objeto2));
        lista.cambiar(objeto2, temp);
        SalidaPorDefecto.terminal("\n");
    }
    public static void quickSort(ListaEstatica lista) {
        if (lista.vacio()) {
            return;
        }

        // Utilizar una pila para almacenar los límites izquierdo y derecho
        PilaDinamica pila = new PilaDinamica();
        pila.poner(0);
        pila.poner(lista.cantidad() - 1);

        while (!pila.vacio()) {
            int high = (int) pila.quitar();
            int low = (int) pila.quitar();

            int pivotIndex = particion(lista, low, high);

            if (pivotIndex - 1 > low) {
                pila.poner(low);
                pila.poner(pivotIndex - 1);
            }

            if (pivotIndex + 1 < high) {
                pila.poner(pivotIndex + 1);
                pila.poner(high);
            }
        }
    }
}
