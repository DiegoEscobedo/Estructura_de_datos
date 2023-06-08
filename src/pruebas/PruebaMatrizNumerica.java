package pruebas;

import entradaSalida.SalidaPorDefecto;
import estructurasLineales.ListaEstaticaNumerica;
import estructurasNoLineales.Matriz2Numerica;
import utilerias.comunes.TipoLogaritmo;

public class PruebaMatrizNumerica {
    public static void main(String[] args) {
        Matriz2Numerica matriz2Numerica = new Matriz2Numerica(4,4, 2);
        matriz2Numerica.cambiar(0,0,5);
        matriz2Numerica.cambiar(0,1,3);
        matriz2Numerica.cambiar(0,2,-4);
        matriz2Numerica.cambiar(0,3,-2);

        matriz2Numerica.cambiar(1,0,8);
        matriz2Numerica.cambiar(1,1,-1);
        matriz2Numerica.cambiar(1,2,0);
        matriz2Numerica.cambiar(1,3,-3);
        SalidaPorDefecto.terminal("Ejecutando el metodo de doblarColumnas()..."+ "\n");
        matriz2Numerica.doblarColumnas();
        matriz2Numerica.imprimirPorRenglon();
        /*Matriz2Numerica matriz2Numerica2 = new Matriz2Numerica(4,4, 2);
        matriz2Numerica.cambiar(0,0,5);
        matriz2Numerica.cambiar(0,1,3);
        matriz2Numerica.cambiar(0,2,-4);
        matriz2Numerica.cambiar(0,3,-2);

        matriz2Numerica.cambiar(1,0,8);
        matriz2Numerica.cambiar(1,1,-1);
        matriz2Numerica.cambiar(1,2,0);
        matriz2Numerica.cambiar(1,3,-3);

        matriz2Numerica2.cambiar(0,0,1);
        matriz2Numerica2.cambiar(0,1,4);
        matriz2Numerica2.cambiar(0,2,0);

        matriz2Numerica2.cambiar(1,0,-5);
        matriz2Numerica2.cambiar(1,1,3);
        matriz2Numerica2.cambiar(1,2,7);

        matriz2Numerica2.cambiar(2,0,0);
        matriz2Numerica2.cambiar(2,1,-9);
        matriz2Numerica2.cambiar(2,2,5);

        matriz2Numerica2.cambiar(3,0,5);
        matriz2Numerica2.cambiar(3,1,1);
        matriz2Numerica2.cambiar(3,2,4);
        SalidaPorDefecto.terminal("Aplicando el metodo de multiplicar matriz... " + "\n");
        matriz2Numerica.multiplicar(matriz2Numerica2);
        matriz2Numerica.imprimirPorRenglon();
        SalidaPorDefecto.terminal("Aplicando el metodo de sumar matriz... " + "\n");
        matriz2Numerica.sumar(matriz2Numerica2);
        matriz2Numerica.imprimirPorRenglon();*/
    }
}
