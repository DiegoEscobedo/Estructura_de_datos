package pruebas;

import entradaSalida.SalidaPorDefecto;
import registro.Diccionario.Concepto;
import registro.Diccionario.DiccionarioConceptos;

public class PruebaDiccionario {
    public static void main(String[] args) {
        DiccionarioConceptos diccionarioConceptos = new DiccionarioConceptos("Diccionario chido");
        Concepto concept1 = new Concepto("automóvil","autocinetum, i n.", "blindado, " +
                "autocinetum loricatum; - cubierto, autocinetum intectum; - eléctrico, autocinetum eléctricum;i.","autoraeda," +
                " autocurrus; automóbilis, is m; automóbile");
        Concepto concept2 = new Concepto("cabecera", "(principio de alguna cosa) caputpĭtis n // (lugar principal) primus locus");
        Concepto concept3 = new Concepto("cabina", "cella, ae f", ": céllula; aedícula; diaeta; cellárium; cubículum", "- telefónica, " +
                "cella vel aedícula telephónica; de acero, cella chalybéia");
        Concepto concept4 = new Concepto("Golear","En el fútbol y otros deportes, marcar muchos goles al equipo contrario, especialmente si se encajan pocos.");

        diccionarioConceptos.agregar(concept1);
        diccionarioConceptos.agregar(concept2);
        diccionarioConceptos.agregar(concept3);
        diccionarioConceptos.agregar(concept4);
        diccionarioConceptos.imprimir();
        SalidaPorDefecto.terminal("\n \n");
        SalidaPorDefecto.terminal(diccionarioConceptos.buscarConcepto("automóvil") +"");
        SalidaPorDefecto.terminal("\n \n");
        diccionarioConceptos.buscarPalabraClave("deportes").imprimir();
    }
}
