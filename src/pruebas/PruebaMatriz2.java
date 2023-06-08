package pruebas;

import entradaSalida.SalidaPorDefecto;
import estructurasLineales.ListaEstatica;
import estructurasNoLineales.Matriz2;
import utilerias.comunes.TipoColumna;
import utilerias.comunes.TipoRenglon;
import utilerias.matematicas.RecursividadMatematica;

/**
 * @author diego
 * @version1.0
 */
public class PruebaMatriz2 {
    public static void main(String[] args) {
        Matriz2 matriz = new Matriz2(5,5);
        matriz.rellenar(5);
        matriz.cambiar(1,1,6);
        matriz.cambiar(1,0,2);
        matriz.cambiar(1,5,1);
        matriz.cambiar(1,0,3);
        RecursividadMatematica.imprimirMatriz2D(matriz, 5,5, 0, 0);

    }
}
