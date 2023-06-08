package estructurasNoLineales;

import entradaSalida.SalidaPorDefecto;
import estructurasLineales.ListaDinamica;
import estructurasLineales.ListaEstatica;
import estructurasLineales.PilaDinamica;
import estructurasLineales.PilaEstatica;
import estructurasNoLineales.auxiliares.Arista;
import estructurasNoLineales.auxiliares.Vertice;
import estructurasNoLineales.auxiliares.VerticeDinamico;
import utilerias.comunes.Comparador;

/**
 * @author diego
 * @version1.0 
 */
public class GrafoDinamico {
    protected ListaDinamica listaAdyacencia;
    public GrafoDinamico(){
        listaAdyacencia=new ListaDinamica();
    }

    /**
     * Este vmetodo busca un vertice en una sublista de un vertice
     * @param verticeBuscado Es el vertice a buscar
     * @return
     */
    private ListaDinamica buscarVerticeSublista(Object verticeBuscado){
        listaAdyacencia.inicializarIterador();
        while(listaAdyacencia.hayNodo()!=false){
            ListaDinamica subLista = (ListaDinamica) listaAdyacencia.obtenerNodo();
            Vertice verticePrimero = (Vertice) subLista.getPrimero().getInfo();
            if(verticeBuscado.toString().equalsIgnoreCase(verticePrimero.toString())){
                return subLista;
            }
        }
        return null;
    }

    /**
     * Agrea uh vertice
     * @param info Es la info del vertice
     * @return
     */
    public boolean agregarVertice(Object info){
        ListaDinamica subListaVertice = buscarVerticeSublista(info);
        if(subListaVertice==null){
            Vertice vertice = new Vertice();
            vertice.setInfo(info);

            ListaDinamica subListaNueva = new ListaDinamica();
            int retornoSL = subListaNueva.agregar(vertice);
            if(retornoSL==-1){
                return false;
            }
            int retornoLN = listaAdyacencia.agregar(subListaNueva);
            if(retornoLN==-1){
                return false;
            }else{
                return true;
            }
        }else{
            return false;
        }
    }

    /**
     * Agrega una arista
     * @param origen Es el origen
     * @param destino Es el destino
     * @param peso Es el peso de la arista
     * @return Regresa true si lo pudo agregar
     */
    public boolean agregarArista(Object origen, Object destino, double peso){
        ListaDinamica subListaOrigen = buscarVerticeSublista(origen);
        ListaDinamica subListaDestino = buscarVerticeSublista(destino);
        if(subListaOrigen!=null&&subListaDestino!=null){
            VerticeDinamico verticeDestino = new VerticeDinamico(subListaDestino.getPrimero().getInfo(), peso);
            int retorno = subListaOrigen.agregar(verticeDestino);
            if(retorno==-1){
                return false;
            }else{
                return true;
            }
        }else{
            return false;
        }
    }

    /**
     * Imprime el grafo
     */
    public void imprimir(){
        listaAdyacencia.inicializarIterador();
        while (listaAdyacencia.hayNodo() != false) {
            ListaDinamica subLista = (ListaDinamica) listaAdyacencia.obtenerNodo();
            subLista.imprimir();
            SalidaPorDefecto.terminal("\n");
        }
    }

    /**
     * Hace un recorrido profundidad deste un origen
     * @param origen
     * @return
     */
    public ListaDinamica recorridoProfundidad(Object origen){
        PilaDinamica pila = new PilaDinamica();
        ListaDinamica marcados = new ListaDinamica();
        ListaDinamica recorridoSalida = new ListaDinamica();
        //Partir de un nodo origen, marcarlo y ponerlo en la pila
        ListaDinamica subListaOrigen=buscarVerticeSublista(origen);
        if(subListaOrigen==null){
            return null;
        }
        Vertice verticeOrigen = (Vertice) subListaOrigen.getPrimero().getInfo();
        pila.poner(verticeOrigen);
        marcados.agregar(verticeOrigen);

        while(!pila.vacio()) {
            //Mientras halla elementos en la pila sacar 1 y procesar
            Object auxiliador = pila.quitar();
            if (auxiliador instanceof VerticeDinamico vertAct){
                vertAct = (VerticeDinamico) auxiliador;
                recorridoSalida.agregar(vertAct.getInfo());
            }else{
                Vertice vertAct = (Vertice) auxiliador;
                recorridoSalida.agregar(vertAct.getInfo());
                ListaDinamica subLista = buscarVerticeSublista(vertAct);
                //Los vertices adyacentes al nodo acabado de procesar y que no esten marcados, ponerlos en la pila y marcarlos.
                marcarYEmpilarVerticesAdyacentes(subLista, marcados, pila);
            }

        }
        return recorridoSalida;
    }

    /**
     * Implemeneta el algoritmo de kruskal al grafo
     * @return Regresa una lista dinamica la cual es el resultado
     */
    public ListaDinamica arbolExpansionMinimaKruskal(){
        ListaDinamica aristasDin = obtenerAristas();
        ListaEstatica aristas = aristasDin.aListaEstatica();
        ListaDinamica arbolExpansionMinima = new ListaDinamica();
        ListaDinamica marcados = new ListaDinamica();
        ordenarAristasPorPeso(aristas);
        for(int cadaArista = 0; cadaArista<aristas.cantidad(); cadaArista++){
            Arista arista = (Arista) aristas.obtener(cadaArista);
            Object origen = arista.getOrigen();
            Object destino = arista.getDestino();
            ListaDinamica subListaOrigen = buscarVerticeSublista(origen);
            ListaDinamica subListaDestino = buscarVerticeSublista(destino);
            if(subListaOrigen != null && subListaDestino != null){
                if(!existeCamino(subListaOrigen, subListaDestino) && marcados.buscar(arista.getOrigen())==null){
                    arbolExpansionMinima.agregar(arista);
                    marcados.agregar(arista.getOrigen());
                }
            }
        } return arbolExpansionMinima;
    }

    private void ordenarAristasPorPeso(ListaEstatica aristas) {
        int cantidad = aristas.cantidad();
        for (int cadaVertice = 0; cadaVertice < cantidad - 1; cadaVertice++) {
            for (int cadaArista = 0; cadaArista < cantidad - cadaVertice - 1; cadaArista++) {
                Arista aristaActual = (Arista) aristas.obtener(cadaArista);
                Arista aristaSiguiente = (Arista) aristas.obtener(cadaArista + 1);
                if ((int)Comparador.comparar(aristaActual.getPeso(), aristaSiguiente.getPeso()) > 0) {
                    // Intercambiar aristaActual y aristaSiguiente
                    aristas.cambiar(cadaArista, aristaSiguiente);
                    aristas.cambiar(cadaArista + 1, aristaActual);
                }
            }
        }
    }
    private boolean existeCamino(ListaDinamica subListaOrigen, ListaDinamica subListaDestino){
        ListaDinamica marcados = new ListaDinamica();
        PilaDinamica pila = new PilaDinamica();
        pila.poner(subListaOrigen.getPrimero().getInfo());
        while(!pila.vacio()){
            Vertice vertice = (Vertice) pila.quitar();
            if(vertice.equals(subListaDestino.getPrimero().getInfo())){
                return true;
            }
            marcados.agregar(vertice.getInfo());
            subListaOrigen.inicializarIterador();
            subListaOrigen.obtenerNodo();
            while(subListaOrigen.hayNodo()){
                VerticeDinamico verticeAdyacente = (VerticeDinamico) subListaOrigen.obtenerNodo();
                if(marcados.buscar(verticeAdyacente.getInfo())!=null){
                    pila.poner(verticeAdyacente);
                }
            }
        } return false;
    }

    //Paso 3 del recorrido de profundidad
    private void marcarYEmpilarVerticesAdyacentes(ListaDinamica sublistaOrigen, ListaDinamica marcados, PilaDinamica pila){
        sublistaOrigen.inicializarIterador();
        sublistaOrigen.obtenerNodo();
        while (sublistaOrigen.hayNodo()==true){
            VerticeDinamico verticeDestino = (VerticeDinamico) sublistaOrigen.obtenerNodo();
            if(marcados.buscar(verticeDestino.getInfo())==null){
                Vertice vertice= new Vertice();
                vertice.setInfo(verticeDestino.getInfo());
                pila.poner(vertice);
                marcados.agregar(verticeDestino.getInfo());
            }
        }
    }
    private ListaDinamica obtenerAristas(){
        ListaDinamica aristas = new ListaDinamica();
        listaAdyacencia.inicializarIterador();
        while(listaAdyacencia.hayNodo()){
            ListaDinamica subLista = (ListaDinamica) listaAdyacencia.obtenerNodo();
            subLista.inicializarIterador();
            subLista.obtenerNodo();
            while (subLista.hayNodo()) {
                VerticeDinamico vertice = (VerticeDinamico) subLista.obtenerNodo();
                aristas.agregar(new Arista(subLista.getPrimero().getInfo(), vertice.getInfo(), vertice.getPeso()));
            }
        }
        return aristas;
    }
}
