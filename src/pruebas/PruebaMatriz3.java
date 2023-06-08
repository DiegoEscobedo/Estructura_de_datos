package pruebas;

import entradaSalida.SalidaPorDefecto;
import estructurasLineales.ListaEstatica;
import estructurasNoLineales.Matriz2;
import estructurasNoLineales.Matriz3;

public class PruebaMatriz3 {
    public static void main(String[] args) {
        Matriz3 matriz = new Matriz3(4, 3, 5, 0);

        matriz.cambiar(2, 1, 3, 9);
        matriz.cambiar(1, 2, 0, 8);
        matriz.cambiar(0, 0, 0, 7);
        matriz.cambiar(3, 1, 4, 4);
        SalidaPorDefecto.terminal("Otra vez" + "\n");
        matriz.imprimirPorColumna();
        SalidaPorDefecto.terminal("Listas...\n");
        imprimirMatrices(matriz.aMatrices2());
    }

    public static void imprimirMatrices(ListaEstatica matrices) {
        for (int cadaMatriz = 0; cadaMatriz < matrices.cantidad(); cadaMatriz++) {
            Matriz2 matriz2Temp = (Matriz2) matrices.obtener(cadaMatriz);
            matriz2Temp.imprimirPorColumna();
            SalidaPorDefecto.terminal("\n");
        }
    }
}
