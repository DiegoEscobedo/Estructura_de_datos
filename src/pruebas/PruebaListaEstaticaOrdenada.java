package pruebas;
import entradaSalida.SalidaPorDefecto;
import estructurasLineales.ListaEstatica;
import estructurasLineales.ListaEstaticaOrdenada;
import utilerias.comunes.TipoOrden;

public class PruebaListaEstaticaOrdenada {
    public static void main(String[] args) {
        ListaEstaticaOrdenada listaord = new ListaEstaticaOrdenada(5, TipoOrden.DEC);
        listaord.agregar(1);
        listaord.agregar(5);
        listaord.agregar(3);
        listaord.agregar(4);
        listaord.agregar(2);
        ListaEstaticaOrdenada lista2 = new ListaEstaticaOrdenada(2, TipoOrden.DEC);
        lista2.agregar(2);
        lista2.agregar(4);
        SalidaPorDefecto.terminal("lista principal : " + "\n");
        listaord.imprimir();
        SalidaPorDefecto.terminal("listas 2(retener)" + "\n");
        lista2.imprimir();
        listaord.retenerLista(lista2);
        SalidaPorDefecto.terminal("retener la lista..."+ "\n");
        listaord.imprimir();
    }

}
