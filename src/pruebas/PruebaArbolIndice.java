package pruebas;

import entradaSalida.SalidaPorDefecto;
import estructurasNoLineales.ArbolIndice;

import java.io.IOException;

public class PruebaArbolIndice {
    public static void main(String[] args) throws IOException {
        ArbolIndice arbolIndice= new ArbolIndice();
        arbolIndice.agregarTabla("D:\\Estructura_de_datos\\orders.txt");
        arbolIndice.agregarTabla2("D:\\Estructura_de_datos\\order_items.txt");
        arbolIndice.imprimir();
        SalidaPorDefecto.terminal("\n");
        arbolIndice.imprimirAnchura();
        SalidaPorDefecto.terminal("\n" + "-----------" + "\n");
        arbolIndice.imprimirTabla2();
        SalidaPorDefecto.terminal("\n" + "-----------" + "\n");
        SalidaPorDefecto.terminal(""+arbolIndice.buscarIndice("2408", "3976"));
        SalidaPorDefecto.terminal("\n" + "-----------" + "\n");
        SalidaPorDefecto.terminal("Orden de la direccion 3976" + arbolIndice.buscarOrden(3976));
        SalidaPorDefecto.terminal("\n" + "-----------" + "\n");
    }
}
