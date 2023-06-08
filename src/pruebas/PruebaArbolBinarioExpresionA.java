package pruebas;

import entradaSalida.SalidaPorDefecto;
import estructurasLineales.ListaDinamica;




import estructurasLineales.ListaDinamicaClave;
import estructurasNoLineales.ArbolExpresionA;

public class PruebaArbolBinarioExpresionA {
    public static void main(String[] args) {
        ArbolExpresionA arbol = new ArbolExpresionA();
        arbol.crearArbol();
        arbol.imprimir();
        SalidaPorDefecto.terminal("\n");
        arbol.listaDinamicaOperandos();
        arbol.listaDinamicaOperadores();
        arbol.imprimirOperandos();
        SalidaPorDefecto.terminal("\n");
        arbol.imprimirOperadores();
        SalidaPorDefecto.terminal("\n");
        arbol.generarArbolConValores();
        arbol.imprimirArbolConValores();
    }
}
