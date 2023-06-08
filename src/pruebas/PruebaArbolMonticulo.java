package pruebas;

import entradaSalida.SalidaPorDefecto;
import estructurasNoLineales.ArbolMonticulo;
import utilerias.comunes.TipoOrden;

public class PruebaArbolMonticulo {
    public static void main(String[] args) {
        ArbolMonticulo arbolM = new ArbolMonticulo(TipoOrden.DEC);
        arbolM.agregar(2);
        arbolM.agregar(3);
        arbolM.agregar(4);
        arbolM.agregar(5);
        arbolM.agregar(6);
        arbolM.agregar(7);
        arbolM.agregar(8);
        arbolM.agregar(1);
        arbolM.imprimirPorAnchura();
        SalidaPorDefecto.terminal("\n");
        arbolM.imprimirInnorden();
        arbolM.eliminar();
        SalidaPorDefecto.terminal("\n");
        arbolM.imprimirPorAnchura();
    }
}
