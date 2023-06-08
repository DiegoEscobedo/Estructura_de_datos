package pruebas;

import entradaSalida.SalidaPorDefecto;
import utilerias.matematicas.ListaDinamicaPolinomio;

public class PruebaListaDinamicaPolinomio {
    public static void main(String[] args) {
        ListaDinamicaPolinomio listaPol = new ListaDinamicaPolinomio();
        listaPol.agregarPolinomio("x^5+x^3+x-1",0,"");
        listaPol.imprimir();
        SalidaPorDefecto.terminal("\n");
        //SalidaPorDefecto.terminal(listaPol.sacarNumero("x^5",0,""));
        SalidaPorDefecto.terminal(listaPol.resolverPolinomio(listaPol,1,0) + "");
        SalidaPorDefecto.terminal("\n");
        SalidaPorDefecto.terminal(listaPol.aBinario(listaPol,"1"));

    }
}
