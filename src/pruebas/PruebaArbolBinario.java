package pruebas;

import entradaSalida.SalidaPorDefecto;
import estructurasNoLineales.ArbolBinario;
import estructurasNoLineales.ArbolBinarioBusqueda;
import estructurasNoLineales.ArbolExpresionA;

public class PruebaArbolBinario {
    public static void main(String[] args) {
        ArbolBinario arbol = new ArbolBinario();
        arbol.crearArbol();
        arbol.imprimirInnorden();
        SalidaPorDefecto.terminal("\n");
        arbol.imprimirPostorden();
        SalidaPorDefecto.terminal("\n");
        arbol.imprimirPostordenNoRec();
        SalidaPorDefecto.terminal("\n");
        SalidaPorDefecto.terminal(".........COLA........." + "\n");
        arbol.imprimirPorAnchura();
        SalidaPorDefecto.terminal(".........PILA........." + "\n");
        arbol.imprimirPorAnchuraConPila();
    }
}
