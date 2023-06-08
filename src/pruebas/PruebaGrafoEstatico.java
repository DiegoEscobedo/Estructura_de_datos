package pruebas;

import entradaSalida.SalidaPorDefecto;
import estructurasLineales.ListaDinamica;
import estructurasLineales.ListaEstatica;
import estructurasNoLineales.GrafoEstatico;

public class PruebaGrafoEstatico {
    public static void main(String[] args) {
        GrafoEstatico grafoE = new GrafoEstatico(5,0.0);
        grafoE.agregarVertice("A");
        grafoE.agregarVertice("B");
        grafoE.agregarVertice("C");
        grafoE.agregarVertice("D");
        grafoE.agregarVertice("Z");
        grafoE.agregarArista("A","B");
        grafoE.agregarArista("A","C");
        grafoE.agregarArista("B","C");
        grafoE.agregarArista("B","D");
        grafoE.agregarArista("B","A");
        grafoE.agregarArista("D","C");
        grafoE.agregarArista("D","B");
        grafoE.imprimir();
        SalidaPorDefecto.terminal("\n");
        SalidaPorDefecto.terminal("'A' es camino cerrado? " + grafoE.esCaminoCerrado("A") + "\n");
        SalidaPorDefecto.terminal("Imprime el nuevo orden topoligo... + \n");
        grafoE.ordenacionTopologica2();
        SalidaPorDefecto.terminal("\n");
        SalidaPorDefecto.terminal("De 'A' a 'C' es camino simple? " + grafoE.esCaminoSimple("A", "C"));
        SalidaPorDefecto.terminal("\n");
        SalidaPorDefecto.terminal("El grafo es dirigido? " +grafoE.esDirigido());
        SalidaPorDefecto.terminal("\n");
        SalidaPorDefecto.terminal("El grafo es un arbol? "+ grafoE.esArbol());
        SalidaPorDefecto.terminal("\n");
        SalidaPorDefecto.terminal("Listar todas las aristas... \n" );
        grafoE.listarAristas().imprimir();
        SalidaPorDefecto.terminal("\n");
        SalidaPorDefecto.terminal("Listar aristas de D... \n");
        grafoE.listarAristas("D").imprimir();
        SalidaPorDefecto.terminal("\n");
        SalidaPorDefecto.terminal("Listar vertices... \n");
        grafoE.listarVertices();
        /*
        GrafoEstatico grafo2 = new GrafoEstatico(5,0.0);
        grafo2.agregarVertice("A");
        grafo2.agregarVertice("B");
        grafo2.agregarVertice("C");
        grafo2.agregarVertice("D");
        grafo2.agregarVertice("E");

        grafo2.agregarArista("A","B");
        grafo2.agregarArista("B","D");
        grafo2.agregarArista("B","C");
        grafo2.agregarArista("C","A");
        grafo2.agregarArista("D","C");
        grafo2.agregarArista("D","E");
        grafo2.agregarArista("D","A");
        grafo2.agregarArista("E","C");

        //grafo2.imprimir();
        //grafo2.recorridoProfundidad("A").imprimir();
        //SalidaPorDefecto.terminal("\n");
        //grafo2.recorridoProfundidadXAnchura("A").imprimir();
        */
        /*
        GrafoEstatico grafoEot = new GrafoEstatico(7,0.0);
        grafoEot.agregarVertice("P1");
        grafoEot.agregarVertice("P2");
        grafoEot.agregarVertice("P3");
        grafoEot.agregarVertice("P4");
        grafoEot.agregarVertice("P5");
        grafoEot.agregarVertice("P6");
        grafoEot.agregarVertice("P7");

        grafoEot.agregarArista("P1","P3");
        grafoEot.agregarArista("P2","P3");
        grafoEot.agregarArista("P3","P4");
        grafoEot.agregarArista("P3","P5");
        grafoEot.agregarArista("P4","P5");
        grafoEot.agregarArista("P4","P6");
        grafoEot.agregarArista("P5","P6");
        grafoEot.agregarArista("P5","P7");
        grafoEot.agregarArista("P6","P7");

        grafoEot.ordenacionTopologica().imprimir();
        */
    }
}
