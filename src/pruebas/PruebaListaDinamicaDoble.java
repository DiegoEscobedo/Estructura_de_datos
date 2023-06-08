package pruebas;

import estructurasLineales.ListaDinamica;
import estructurasLineales.ListaDinamicaDoble;
import estructurasLineales.auxiliares.NodoDoble;

public class PruebaListaDinamicaDoble {

    public static void main(String[] args) {
        ListaDinamicaDoble lista = new ListaDinamicaDoble();
        lista.imprimir();
        lista.agregar("a");
        lista.agregar("b");
        lista.agregar("z");
        lista.imprimir();
        lista.eliminar();
        lista.imprimir();
    }
}
