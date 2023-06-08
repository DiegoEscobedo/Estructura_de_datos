package pruebas;

import entradaSalida.SalidaPorDefecto;
import estructurasNoLineales.GrafoDinamico;

public class PruebaGrafoDinamico {
    public static void main(String[] args) {
        GrafoDinamico grafoDinamico = new GrafoDinamico();
        grafoDinamico.agregarVertice("1");
        grafoDinamico.agregarVertice("2");
        grafoDinamico.agregarVertice("3");
        grafoDinamico.agregarVertice("4");
        grafoDinamico.agregarVertice("5");

        grafoDinamico.agregarArista("1", "2", 1.0);
        grafoDinamico.agregarArista("1", "3", 40.0);

        grafoDinamico.agregarArista("2", "1", 1.0);
        grafoDinamico.agregarArista("2", "4", 6.0);
        grafoDinamico.agregarArista("2", "3", 3.0);

        grafoDinamico.agregarArista("3", "2", 3.0);
        grafoDinamico.agregarArista("3", "1", 4.0);
        grafoDinamico.agregarArista("3", "5", 2.0);
        grafoDinamico.agregarArista("3", "4", 4.0);

        grafoDinamico.agregarArista("4", "5", 5.0);
        grafoDinamico.agregarArista("4", "3", 4.0);
        grafoDinamico.agregarArista("4", "2", 6.0);

        grafoDinamico.agregarArista("5", "4", 5.0);
        grafoDinamico.agregarArista("5", "3", 2.0);

        grafoDinamico.imprimir();
        SalidaPorDefecto.terminal("\n");
        grafoDinamico.recorridoProfundidad("1").imprimir();
        SalidaPorDefecto.terminal("\n");
        grafoDinamico.arbolExpansionMinimaKruskal().imprimir();
    }
}
