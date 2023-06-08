package pruebas;

import entradaSalida.SalidaPorDefecto;
import estructurasLineales.Lista;
import estructurasLineales.ListaDinamicaOrdenada;
import estructurasLineales.ListaEstatica;
import estructurasLineales.ListaEstaticaNumerica;
import estructurasNoLineales.Matriz2;
import utilerias.comunes.TipoTabla;

import static utilerias.comunes.TipoOrden.*;

public class pruebaListaDinamicaOrdenada {
    public static void main(String[] args) {
        ListaDinamicaOrdenada lista = new ListaDinamicaOrdenada(INC); lista.agregar(0); lista.agregar(7); lista.agregar(2);
        lista.agregar(3); lista.agregar(4); lista.agregar(6); lista.agregar(5);lista.agregar(13); lista.agregar(14); lista.agregar(-6);
        //............................................................................................................................................................//
        Matriz2 matriz = new Matriz2(2,2,0); matriz.cambiar(0,0, 2); matriz.cambiar(0,1, 3);
        matriz.cambiar(1,0, 4); matriz.cambiar(1,1, 5);
        SalidaPorDefecto.terminal("Ejecutando el metodo de agregar Matriz2D por renglon y la matriz es la siguiente..." + "\n");
        matriz.imprimirPorRenglon();
        SalidaPorDefecto.terminal("RESULTADO.." + "\n");
        lista.agregarMatriz2D(matriz, TipoTabla.RENGLON);
        lista.imprimir();
        SalidaPorDefecto.terminal("\n");
        SalidaPorDefecto.terminal("Ejecutando el metodo de eliminar una lista y es la siguiente.." + "\n");
        ListaEstatica lista2 = new ListaEstatica(3);lista2.agregar(30);lista2.agregar(0);lista2.agregar(7);
        lista2.imprimir();
        SalidaPorDefecto.terminal("RESULTADO.." + "\n");
        lista.eliminarLista(lista2);
        lista.imprimir();
        SalidaPorDefecto.terminal("\n");
        SalidaPorDefecto.terminal("Ejecutando el metodo de eliminar Matriz2D por renglon y la matriz es la siguiente..." + "\n");
        matriz.imprimirPorRenglon();
        SalidaPorDefecto.terminal("RESULTADO.." + "\n");
        lista.eliminarMatriz2(matriz, TipoTabla.RENGLON);
        lista.imprimir();
        SalidaPorDefecto.terminal("\n");
        SalidaPorDefecto.terminal("Verificar si la siguiente lista es igual.." + "\n");
        lista2.imprimir();
        SalidaPorDefecto.terminal("Es igual.." + lista.esIgual(lista2) + "\n");
        SalidaPorDefecto.terminal("Ejecutando el metodo de cambiar en este caso el -6 por el 60" + "\n");
        lista.cambiar("-6", 60, 1);
        lista.imprimir();
        SalidaPorDefecto.terminal("\n");
        SalidaPorDefecto.terminal("Ejecutando el metodo de buscar valores en este caso el 60 y el resultado es..." + "\n");
        lista.buscarValores(60).imprimir();
        SalidaPorDefecto.terminal("Ejecutando el metodo de eliminar" + "\n");
        lista.eliminar();
        lista.imprimir();
        SalidaPorDefecto.terminal("\n");
        SalidaPorDefecto.terminal("Ejecutando el metodo de invertir" + "\n");
        lista.invertir();
        lista.imprimir();
        SalidaPorDefecto.terminal("\n");
        SalidaPorDefecto.terminal("Ejecutando el metodo de rellenar con el 32 2 veces" + "\n");
        lista.rellenar(32,2);
        lista.imprimir();
        //............................................................................................................................................................//
        SalidaPorDefecto.terminal("\n");
        SalidaPorDefecto.terminal("Ejecutando el metodo de clonar y el resultado es,,," + "\n");
        lista.clonar().imprimir();
        SalidaPorDefecto.terminal("\n");
        SalidaPorDefecto.terminal("Ejecutando el metodo de sub lista con los indices 1 y 3" + "\n");
        lista.subLista(1,3).imprimir();
        SalidaPorDefecto.terminal("\n");
        SalidaPorDefecto.terminal("Ejecutando el metodo de sub lista con la lista de indices siguiente..." + "\n");
        ListaEstaticaNumerica inidces = new ListaEstaticaNumerica(3); inidces.agregar(3);inidces.agregar(5);inidces.agregar(0);
        inidces.imprimir();
        SalidaPorDefecto.terminal("RESULTADO" + "\n");
        lista.subLista(inidces).imprimir();
        SalidaPorDefecto.terminal("Ejecutando el metodo de ver tope y este s: "+ lista.verTope() + "\n");
        SalidaPorDefecto.terminal("Ejecutando el metodo de redimensionar en 2" + "\n");
        lista.redimensionar(2);
        lista.imprimir();
        SalidaPorDefecto.terminal("\n");
        SalidaPorDefecto.terminal("Ejecutando el metodo de vaciar" + "\n");
        lista.vaciar();
        lista.imprimir();
    }

}
