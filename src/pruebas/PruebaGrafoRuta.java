package pruebas;

import entradaSalida.SalidaPorDefecto;
import estructurasNoLineales.GrafoEstatico;
import utilerias.comunes.TipoOrden;

public class PruebaGrafoRuta{
    public static void main(String[] args) {
        GrafoEstatico grafo = new GrafoEstatico(8, TipoOrden.DEC);
        grafo.agregarVertice("A");
        grafo.agregarVertice("B");
        grafo.agregarVertice("C");
        grafo.agregarVertice("D");
        grafo.agregarVertice("E");
        grafo.agregarVertice("F");
        grafo.agregarVertice("H");
        grafo.agregarVertice("M");

        grafo.agregarArista("A", "B",3);
        grafo.agregarArista("B", "A",3);

        grafo.agregarArista("A", "C",5);
        grafo.agregarArista("C", "A",5);

        grafo.agregarArista("C", "E",8);
        grafo.agregarArista("E", "C",8);

        grafo.agregarArista("B", "E",1);
        grafo.agregarArista("E", "B",1);

        grafo.agregarArista("C", "D",6);
        grafo.agregarArista("D", "C",6);

        grafo.agregarArista("E", "F",7);
        grafo.agregarArista("F", "E",7);

        grafo.agregarArista("B", "H",4);
        grafo.agregarArista("H", "B",4);

        grafo.agregarArista("H", "F",6);
        grafo.agregarArista("F", "H",6);

        grafo.agregarArista("F", "D",2);
        grafo.agregarArista("D", "F",2);

        grafo.agregarArista("D", "M",6);
        grafo.agregarArista("M", "D",6);

        grafo.agregarArista("M", "H",9);
        grafo.agregarArista("H","M",9);

        grafo.imprimir();

        SalidaPorDefecto.terminal(grafo.metricaDeRutaOptima("A", "M")+ "");
        SalidaPorDefecto.terminal("\n");
        grafo.rutaOptima("A","M").imprimir();
    }
}
