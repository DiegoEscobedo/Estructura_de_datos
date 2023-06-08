package pruebas;

import entradaSalida.SalidaPorDefecto;
import estructurasLineales.ColaEstatica;

public class PruebaColaEstatica {
    public static void main(String[] args) {
        ColaEstatica cola = new ColaEstatica(5);
        cola.poner("a");
        cola.poner("b");
        cola.poner("c");
        cola.poner("d");
        cola.imprimir();
        SalidaPorDefecto.terminal(""+cola.verInicio() + "\n");
        cola.quitar();
        cola.imprimir();
    }


}
