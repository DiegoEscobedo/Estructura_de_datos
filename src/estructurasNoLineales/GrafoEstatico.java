package estructurasNoLineales;

import entradaSalida.SalidaPorDefecto;
import estructurasLineales.*;
import estructurasNoLineales.auxiliares.Vertice;
import registro.comunes.EtiquetaGrafo;
import utilerias.comunes.TipoOrden;

/**
 * @author diego
 * @version1.0 
 */
public class GrafoEstatico {
    protected Matriz2 aristas;
    protected ListaEstatica vertices;
    protected TipoOrden tipoOrden;

    public GrafoEstatico(int numeroVertices){
        aristas = new Matriz2(numeroVertices,numeroVertices);
        vertices = new ListaEstatica(numeroVertices);
    }
    public GrafoEstatico(int numeroVertices, Object inicializador){
        aristas = new Matriz2(numeroVertices,numeroVertices);
        aristas.rellenar(inicializador);
        vertices = new ListaEstatica(numeroVertices);
    }
    public GrafoEstatico(int numeroVertices,TipoOrden tipoOrden){
        this(numeroVertices);
        this.tipoOrden = tipoOrden;
        if(tipoOrden==TipoOrden.DEC){
            aristas.rellenar(Double.MAX_VALUE);
        }else{
            aristas.rellenar(Double.MIN_VALUE);
        }
        aristas.matrizDiagonal(0.0);
    }
    public boolean agregarVertice(Object info){
        int indiceVertice = (int)vertices.buscar(info);
        if(indiceVertice!=-1){
            return false;
        }else{
            Vertice nuevoVertice= new Vertice();
            nuevoVertice.setInfo(info);
            nuevoVertice.setIndice(vertices.cantidad());
            int retorno = vertices.agregar(nuevoVertice);
            return retorno != -1;
        }
    }

    public boolean agregarArista(Object origen, Object destino){
        return agregarArista(origen,destino,1.0);
    }

    public boolean agregarArista(Object origen, Object destino, double peso){
        int indiceOrigen = (int)vertices.buscar(origen);
        int indiceDestino = (int)vertices.buscar(destino);
        if(indiceOrigen != -1 && indiceDestino != -1){
            return aristas.cambiar(indiceOrigen,indiceDestino, peso);
        }else{
            return false;
        }
    }

    public void imprimir(){
        vertices.imprimir();
        SalidaPorDefecto.terminal("\n");
        aristas.imprimirPorRenglon();
    }

    public ListaDinamica recorridoProfundidad(Object origen){
        PilaEstatica pila = new PilaEstatica(vertices.cantidad());
        ListaEstatica marcados = new ListaEstatica(vertices.cantidad());
        ListaDinamica recorridoSalida = new ListaDinamica();
        marcados.rellenar(false, marcados.getTope());
        //Partir de un nodo origen, marcarlo y ponerlo en la pila
        int indiceOrigen = (int) vertices.buscar(origen);
        if(indiceOrigen==-1){
            return null;
        }
        pila.poner(indiceOrigen);
        marcados.rellenar(false, vertices.cantidad());
        marcados.cambiar(indiceOrigen,true);

        while(!pila.vacio()) {
            //Mientras halla elementos en la pila sacar 1 y procesar
            int indiceVertAct = (int) pila.quitar();
            Vertice verticeActual = (Vertice) vertices.obtener(indiceVertAct);
            recorridoSalida.agregar(verticeActual.getInfo());
            //Los vertices adyacentes al nodo acabado de procesar y que no esten marcados, ponerlos en la pila y marcarlos.
            marcarYEmpilarVerticesAdyacentes(indiceVertAct, marcados, pila);
        }
        return recorridoSalida;
    }

    //Paso 3 del recorrido de profundidad
    private void marcarYEmpilarVerticesAdyacentes(int indiceVerticeOrigen, ListaEstatica marcados, PilaEstatica pila){
        for(int cadaDestino=0; cadaDestino<aristas.getColumnas(); cadaDestino++){
            Double flecha = (Double)aristas.obtener(indiceVerticeOrigen, cadaDestino);
            if(flecha!=null && flecha>0 && !((boolean) marcados.obtener(cadaDestino))){
                marcados.cambiar(cadaDestino, true);
                pila.poner(cadaDestino);
            }
        }
    }

    public ListaDinamica recorridoProfundidadXAnchura(Object origen){
        ColaEstatica pila = new ColaEstatica(vertices.cantidad());
        ListaEstatica marcados = new ListaEstatica(vertices.cantidad());
        ListaDinamica recorridoSalida = new ListaDinamica();
        marcados.rellenar(false, marcados.getTope());
        //Partir de un nodo origen, marcarlo y ponerlo en la pila
        int indiceOrigen = (int) vertices.buscar(origen);
        if(indiceOrigen==-1){
            return null;
        }
        pila.poner(indiceOrigen);
        marcados.rellenar(false, vertices.cantidad());
        marcados.cambiar(indiceOrigen,true);

        while(!pila.vacio()) {
            //Mientras halla elementos en la pila sacar 1 y procesar
            int indiceVertAct = (int) pila.quitar();
            Vertice verticeActual = (Vertice) vertices.obtener(indiceVertAct);
            recorridoSalida.agregar(verticeActual.getInfo());
            //Los vertices adyacentes al nodo acabado de procesar y que no esten marcados, ponerlos en la pila y marcarlos.
            marcarYEmpilarVerticesAdyacentesXAnchura(indiceVertAct, marcados, pila);
        }
        return recorridoSalida;
    }
    private void marcarYEmpilarVerticesAdyacentesXAnchura(int indiceVerticeOrigen, ListaEstatica marcados, ColaEstatica pila){
        for(int cadaDestino=0; cadaDestino<aristas.getColumnas(); cadaDestino++){
            Double flecha = (Double)aristas.obtener(indiceVerticeOrigen, cadaDestino);
            if(flecha!=null && flecha>0 && !((boolean) marcados.obtener(cadaDestino))){
                marcados.cambiar(cadaDestino, true);
                pila.poner(cadaDestino);
            }
        }
    }
    public ListaDinamica ordenacionTopologica() {
        ListaDinamica recorridoOT = new ListaDinamica();
        ColaEstatica cola= new ColaEstatica(vertices.cantidad());
        ListaEstatica marcados = new ListaEstatica(vertices.cantidad());
        ListaEstaticaNumerica incidencias = new ListaEstaticaNumerica(vertices.cantidad());

        incidenciasTodosVertices(incidencias);

        marcados.rellenar(false, vertices.cantidad());
        encolarYMarcarVerticesIncidenciasCero(incidencias, marcados, cola);

        while(!cola.vacio()){
            int indiceVerticeActual=(int)cola.quitar();
            Vertice verticeActual = (Vertice)vertices.obtener(indiceVerticeActual);
            recorridoOT.agregar(verticeActual.getInfo());

            recalcularIncidenciasVertices(incidencias, indiceVerticeActual, marcados);

            encolarYMarcarVerticesIncidenciasCero(incidencias, marcados, cola);
        }
        return recorridoOT;
    }
    //paso 1 de OT
    private int incidenciasVertices(int indiceDestino){
        int numeroIncidencias = 0;
        for(int cadaFilaOrigen = 0; cadaFilaOrigen<aristas.getRenglones(); cadaFilaOrigen++){
            Double flecha = (Double)aristas.obtener(cadaFilaOrigen, indiceDestino);
            if(flecha!=null && flecha>0){
                numeroIncidencias++;
            }
        }
        return numeroIncidencias;
    }
    private void incidenciasTodosVertices(ListaEstatica indiceDestino){
        for(int cadaFilaOrigen = 0; cadaFilaOrigen<aristas.getColumnas(); cadaFilaOrigen++){
            int numeroIncidenciasDestino = incidenciasVertices(cadaFilaOrigen);
            indiceDestino.agregar(numeroIncidenciasDestino);

        }
    }

    //Paso 2 de OT
    private void encolarYMarcarVerticesIncidenciasCero(ListaEstaticaNumerica incidencias, ListaEstatica marcados, ColaEstatica cola)
    {
        for(int cadaVertice = 0; cadaVertice<incidencias.cantidad(); cadaVertice++){
            if((int)incidencias.obtener(cadaVertice)==0 && !((boolean) marcados.obtener(cadaVertice))) {
                cola.poner(cadaVertice);
                marcados.cambiar(cadaVertice, true);
            }
        }
    }

    //Paso 4 de OT
    private void recalcularIncidenciasVertices(ListaEstatica incidencias, int indiceOrigen, ListaEstatica marcados){
        for(int cadaDestino=0; cadaDestino<aristas.getColumnas();cadaDestino++){
            Double flecha = (Double) aristas.obtener(indiceOrigen, cadaDestino);
            if(flecha!=null&&flecha>0&& !((boolean) marcados.obtener(cadaDestino))){
                int incidenciaDestino=(int)incidencias.obtener(cadaDestino);
                incidencias.cambiar(cadaDestino, incidenciaDestino-1);
            }
        }
    }
    public Double metricaDeRutaOptima(Object origen, Object destino){
        Integer indiceDestino = (Integer) vertices.buscar(destino);
        ListaEstatica etiquetasOptimas = (ListaEstatica) rutaMasCorta(origen);
        if(indiceDestino!=-1&&etiquetasOptimas!=null){
            //Si existen el destino y el origen
            EtiquetaGrafo etiquetaDestinoPedido = (EtiquetaGrafo) etiquetasOptimas.obtener(indiceDestino);
            return  etiquetaDestinoPedido.getMetricaAcumulada();
        }
        return null;
    }

    private ListaEstatica rutaMasCorta(Object origen){
        ListaEstatica marcados = new ListaEstatica(vertices.cantidad());
        ListaEstatica etiquetasOptimas = new ListaEstatica(vertices.cantidad());
        //Ruta mas corta:
        //Paso0: Determinar si el origen existe..
        int indiceOrigen = (int)vertices.buscar(origen);
        if(indiceOrigen==-1){
            return null;
        }
        Double infinito = 0.0;
        if(tipoOrden==TipoOrden.DEC){
            infinito = Double.MAX_VALUE;
        }else{
            infinito = Double.MIN_VALUE;
        }
        //Paso1: Inicializar etiquetas
        inicializarEtiquetasOptimas(etiquetasOptimas, infinito, 0.0,  -1, indiceOrigen, 0);
        marcados.rellenar(false, vertices.cantidad());
        marcados.cambiar(indiceOrigen, true);
        //Paso2: Calcular la nueva métrica acumulada (partiendo del vértice actual,
        // al principio el vértice actual es el origen), del vértice actual a cada vecino no marcado;
        // si la métrica acumulada es mejor que la ya conocida, se actualiza.
        int indiceActaul = indiceOrigen;
        for(int iteracion = 1; iteracion<vertices.cantidad();iteracion++) {
            caculcarMetricaAcumuladaVecinos(etiquetasOptimas, indiceActaul, marcados, infinito, iteracion);
            //Paso3: Actualizar el vértice actual y marcarlo como el vértice que tiene más óptima su métrica (uno no marcarlo).
            indiceActaul = actualizarVerticeActual(etiquetasOptimas, marcados, infinito);
            marcados.cambiar(indiceActaul, true);
        }
        return etiquetasOptimas;
    }
    //Paso1
    private void inicializarEtiquetasOptimas(ListaEstatica etiquetasOptimas, Double metricaVertice, Double metricaOrigen, int verticeAnterior, int verticeOrigen, int iteracionInicial){
        for(int cadaVertice = 0; cadaVertice<etiquetasOptimas.maximo(); cadaVertice++){
            EtiquetaGrafo etiquetaNueva = new EtiquetaGrafo();
            etiquetaNueva.setIteracion(iteracionInicial);
            etiquetaNueva.setMetricaAcumulada(metricaVertice);
            etiquetaNueva.setVerticeAnterior(verticeAnterior);
            etiquetasOptimas.agregar(etiquetaNueva);
        }
        EtiquetaGrafo etiquetaOrigen = (EtiquetaGrafo) etiquetasOptimas.obtener(verticeOrigen);
        etiquetaOrigen.setMetricaAcumulada(metricaOrigen);
    }
    //Paso2
    private void caculcarMetricaAcumuladaVecinos(ListaEstatica etiquetasOptimas, int indiceAcctual, ListaEstatica marcados, Double infinito, int iteracion){
        for(int cadaDestinoColumna = 0; cadaDestinoColumna<aristas.getColumnas(); cadaDestinoColumna++){
            Double flechaAdyacente=(Double) aristas.obtener(indiceAcctual, cadaDestinoColumna);
            if(flechaAdyacente!=null&&flechaAdyacente!=0&&flechaAdyacente!=infinito && (boolean)marcados.obtener(cadaDestinoColumna)==false){
                EtiquetaGrafo etiquetasVerticeActual= (EtiquetaGrafo) etiquetasOptimas.obtener(indiceAcctual);
                Double metricaVerticeActual = etiquetasVerticeActual.getMetricaAcumulada();
                double metricaAcumuladaOrigenDestino = metricaVerticeActual + flechaAdyacente;
                EtiquetaGrafo etiquetaDestino =(EtiquetaGrafo) etiquetasOptimas.obtener(cadaDestinoColumna);
                boolean banderaSustitucion = false;
                if(tipoOrden == TipoOrden.DEC){
                    if(metricaAcumuladaOrigenDestino<etiquetaDestino.getMetricaAcumulada()){

                        banderaSustitucion = true;
                    }
                }else{
                    if(metricaAcumuladaOrigenDestino>etiquetaDestino.getMetricaAcumulada()){

                        banderaSustitucion = true;
                    }
                }
                if(banderaSustitucion){
                    etiquetaDestino.setMetricaAcumulada(metricaAcumuladaOrigenDestino);
                    etiquetaDestino.setIteracion(iteracion);
                    etiquetaDestino.setVerticeAnterior(indiceAcctual);
                }
            }
        }
    }

    //Paso3
    private int actualizarVerticeActual(ListaEstatica etiquetas, ListaEstatica marcados, Double infinito) {
        double mejor = infinito;
        int indiceMejor = -1;
        for (int cadaVerticeCandidato = 0; cadaVerticeCandidato < etiquetas.cantidad(); cadaVerticeCandidato++) {
            if (!((boolean) marcados.obtener(cadaVerticeCandidato))) {
                EtiquetaGrafo etiquetaCandidato = (EtiquetaGrafo) etiquetas.obtener(cadaVerticeCandidato);
                if (tipoOrden == TipoOrden.DEC) {
                    if (etiquetaCandidato.getMetricaAcumulada() < mejor) {
                        mejor = etiquetaCandidato.getMetricaAcumulada();
                        indiceMejor = cadaVerticeCandidato;
                    }
                } else {
                    if (etiquetaCandidato.getMetricaAcumulada() > mejor) {
                        mejor = etiquetaCandidato.getMetricaAcumulada();
                        indiceMejor = cadaVerticeCandidato;
                    }
                }
            }
        }
        return indiceMejor;
    }

    /**
     * Calcula la ruta optima de un origen a un destino
     * @param origen
     * @param destino
     * @return
     */
    public ListaDinamica rutaOptima(Object origen, Object destino){
        Integer indiceDestino = (Integer) vertices.buscar(destino);
        ListaEstatica etiquetasOptimas = (ListaEstatica) rutaMasCorta(origen);
        etiquetasOptimas.imprimir();
        if(indiceDestino!=-1&&etiquetasOptimas!=null){
            //Si existen el destino y el origen
            int indiceActual = indiceDestino;
            ListaDinamica rutaOptima = new ListaDinamica();
            do{
                Vertice verticeActual = (Vertice) vertices.obtener(indiceActual);
                rutaOptima.agregarInicio(verticeActual);
                EtiquetaGrafo etiquetaVerticeActual = (EtiquetaGrafo)etiquetasOptimas.obtener(indiceActual);
                indiceActual = etiquetaVerticeActual.getVerticeAnterior();
            }while(indiceActual!=-1);
            return rutaOptima;
        }
        return null;
    }


    /**
     * Elimina un vértice (dado su nombre) del grafo y
     * todos los procesos que ello conlleva, tenga o no aristas.
     * @param info Vertice a elimina
     * @return Vertice eliminado
     */
    public void eliminarVertice(Object info){
        int posicion;

        // Buscar la posición del vértice en la matriz
        posicion = (int) vertices.buscar(info);

        if (posicion != -1) {
            // Eliminar la fila correspondiente al vértice
            for (int cadaRenglon = posicion; cadaRenglon <= vertices.cantidad() - 1; cadaRenglon++) {
                vertices.cambiar(cadaRenglon, vertices.obtener(cadaRenglon+1));
                for (int cadaColumna = 0; cadaColumna < aristas.getColumnas(); cadaColumna++) {
                    aristas.cambiar(cadaRenglon, cadaColumna, aristas.obtener(cadaRenglon+1, cadaColumna));
                }
            }

            // Eliminar la columna correspondiente al vértice
            for (int cadaRenglon = 0; cadaRenglon < aristas.getRenglones(); cadaRenglon++) {
                for (int cadaColumna = posicion; cadaColumna < aristas.getColumnas()-1; cadaColumna++) {
                    aristas.cambiar(cadaRenglon, cadaColumna, aristas.obtener(cadaRenglon, cadaColumna+1));
                }
            }

            // Ajustar el tamaño de la matriz y la lista de vértices
            ListaEstatica tempVertices = new ListaEstatica(vertices.cantidad() - 1);
            Matriz2 tempAristas = new Matriz2(aristas.getRenglones()-1,aristas.getColumnas()-1);

            for (int cadaVertice = 0; cadaVertice < vertices.cantidad()-1; cadaVertice++) {
                tempVertices.agregar(vertices.obtener(cadaVertice));
            }

            for (int cadaRenglon = 0; cadaRenglon < tempAristas.getRenglones(); cadaRenglon++) {
                for (int cadaColumna = 0; cadaColumna < tempAristas.getColumnas(); cadaColumna++) {
                    tempAristas.cambiar(cadaRenglon, cadaColumna, aristas.obtener(cadaRenglon, cadaColumna));
                }
            }

            vertices = tempVertices;
            aristas = tempAristas;
        }
    }

    /**
     *Calcula si un vertice es adyacente a otro
     * @param origen
     * @param destino
     * @return
     */
    public boolean esAdyacente(Object origen, Object destino){
        int indiceOrg = (int) vertices.buscar(origen);
        int indiceDest = (int) vertices.buscar(destino);
        double valor1 = (double) aristas.obtener(indiceOrg, indiceDest);
        if(valor1>0.0){
            return true;
        }else{
            return false;
        }
    }

    /**
     * Elimina una arista
     */
    public void eliminarArista(Object origen, Object destino){
        double indice = (double) aristas.obtener((Integer) vertices.buscar(origen), (Integer) vertices.buscar(destino));
        if(indice>0.0){
            aristas.cambiar((Integer) vertices.buscar(origen), (Integer) vertices.buscar(destino), 0.0);
        }else{
            SalidaPorDefecto.terminal("No habia arista");
        }
    }

    /**
     * Busca un vertice
     * @param vertice
     * @return
     */
    public Object buscarVertice(Object vertice){
        Vertice verticeBuscado = new Vertice();
        if((int)vertices.buscar(vertice)!=-1){
            verticeBuscado.setInfo(vertices.obtener((int)vertices.buscar(vertice)));
        }else{
            return null;
        }
        return verticeBuscado;
    }

    /**
     * Nos dice si un grafo es pseudografo
     * @return
     */
    public boolean esPseudografo() {
        for (int cadaRenglon = 0; cadaRenglon < aristas.getRenglones(); cadaRenglon++) {
            for (int cadaColumna = 0; cadaColumna < aristas.getColumnas(); cadaColumna++) {
                if ((double)aristas.obtener(cadaRenglon, cadaColumna) > 0.0 && (double)aristas.obtener(cadaColumna,cadaRenglon)>0.0) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * Nos dice si el grafo es multigrafo
     * @return
     */
    public boolean esMultigrafo() {
        for (int cadaRenglon = 0; cadaRenglon < aristas.getRenglones(); cadaRenglon++) {
            for (int cadaColumna = 0; cadaColumna < aristas.getColumnas(); cadaColumna++) {
                if(cadaRenglon == cadaColumna){
                    //no permite bucles
                }else {
                    if ((double)aristas.obtener(cadaRenglon, cadaColumna) > 0.0 && (double)aristas.obtener(cadaColumna,cadaRenglon)>0.0) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    /**
     * Nos dice el grado de un vertice
     * @param vertice
     * @return
     */
    public double gradoVertice(Object vertice){
        Vertice verticeNuevo = (Vertice) buscarVertice(vertice);
        double numeroAristas = 0.0;
        if(verticeNuevo!=null){
            for(int cadaColumna = 0; cadaColumna<aristas.getColumnas(); cadaColumna++){
                if((double)aristas.obtener((Integer) vertices.buscar(verticeNuevo), cadaColumna)>0.0){
                    numeroAristas++;
                }
            }
        }
        return numeroAristas;
    }

    /**
     * Nos dice si hay ruta de un destino a un nodo
     * @param origen
     * @param destino
     * @return
     */
    public boolean hayRuta(Object origen, Object destino){
        ListaDinamica recorrido = recorridoProfundidad(origen);
        return recorrido.buscar(destino) != null;
    }

    /**
     * Nos dice si un grafo es conexo
     * @return
     */
    public boolean esConexo(){
        for(int cadaVertice = 0; cadaVertice<vertices.cantidad(); cadaVertice++){
            String origen = vertices.obtener(cadaVertice).toString();
            for(int cadaVertice2 = 0; cadaVertice<vertices.cantidad(); cadaVertice++){
                if(cadaVertice!=cadaVertice2) {
                    String destino = vertices.obtener(cadaVertice2).toString();
                    if(!hayRuta(origen, destino)){
                        return false;
                    }
                }
            }
        }
        return true;
    }

    /**
     * Nos dice si el camino de el vertice es cerrado
     * @param verticeOrigen
     * @return
     */
    public boolean esCaminoCerrado(Object verticeOrigen) {
        int origen = (int) vertices.buscar(verticeOrigen);
        ListaEstatica visitados = new ListaEstatica(vertices.cantidad());
        visitados.rellenar(false, vertices.cantidad());

        visitados.cambiar(origen, true); // Marcar el origen como visitado

        // Realizar el recorrido en profundidad
        for (int indice = 0; indice < vertices.cantidad(); indice++) {
            boolean visitado = (boolean) visitados.obtener(indice);
            if ((double) aristas.obtener(origen, indice) > 0.0 && !visitado) {
                if (recorridoProfundidadDestino(indice, origen, visitados)) {
                    return true;
                }
            }
        }

        return false;
    }

    /**
     * Imprime la ordenacion topologica
     */
    public void ordenacionTopologica2() {
        ListaEstatica visitados = new ListaEstatica(vertices.cantidad());
        visitados.rellenar(false, vertices.cantidad());
        ListaEstatica resultado = new ListaEstatica(vertices.cantidad());

        for (int indice = 0; indice < vertices.cantidad(); indice++) {
            if (!(boolean) visitados.obtener(indice)) {
                recorridoProfundidad(indice, visitados, resultado);
            }
        }

        // Imprimir el resultado de la ordenación topológica
        for (int indice = resultado.cantidad() - 1; indice >= 0; indice--) {
            System.out.print(resultado.obtener(indice) + " ");
        }
    }

    /**
     * Nos dice si el camino del origen al destino es simple
     * @param origen
     * @param destino
     * @return
     */
    public boolean esCaminoSimple(Object origen, Object destino) {
        int nodoOrigen = (int)vertices.buscar(origen);
        int nodoDestino = (int)vertices.buscar(destino);

        ListaEstatica visitados = new ListaEstatica(vertices.cantidad());
        visitados.rellenar(false, vertices.cantidad());
        return recorridoProfundidadDestino(nodoOrigen, nodoDestino, visitados);
    }

    private void recorridoProfundidad(int indiceVertice, ListaEstatica visitados, ListaEstatica resultado) {
        visitados.cambiar(indiceVertice, true);
        for (int indice = 0; indice < vertices.cantidad(); indice++) {
            boolean visitado = (boolean) visitados.obtener(indice);
            if ((double) aristas.obtener(indiceVertice, indice) > 0.0 && !visitado) {
                recorridoProfundidad(indice, visitados, resultado);
            }
        }
        resultado.agregar(vertices.obtener(indiceVertice));
    }

    private boolean recorridoProfundidadDestino(int indiceVertice, int destino, ListaEstatica visitados) {
        visitados.cambiar(indiceVertice, true);
        if (indiceVertice == destino) {
            return true;
        }
        for (int indice = 0; indice < vertices.cantidad(); indice++) {
            boolean visitado  = (boolean) visitados.obtener(indice);
            if ((double)aristas.obtener(indiceVertice, indice)>0.0 && !visitado) {
                if (recorridoProfundidadDestino(indice, destino, visitados)) {
                    return true;
                }
            }
        }
        visitados.cambiar(indiceVertice, false); // Restaurar el estado del visitado
        return false;
    }

    /**
     * Nos dice si un grafo es dirigido
     * @return
     */
    public boolean esDirigido() {
        for (int cadaRenglon = 0; cadaRenglon < vertices.cantidad(); cadaRenglon++) {
            for (int cadaColumna = 0; cadaColumna < vertices.cantidad(); cadaColumna++) {
                if ((double)aristas.obtener(cadaRenglon, cadaColumna) != (double)aristas.obtener(cadaColumna, cadaRenglon)) {
                    return true; // Existe al menos una arista en una dirección diferente
                }
            }
        }
        return false; // Todas las aristas tienen la misma dirección en ambos sentidos
    }

    /**
     * Nos dice si un grafo es un arbol
     * @return
     */
    public boolean esArbol() {
        // Verificar si el grafo tiene el número correcto de aristas
        if (listarAristas().cantidad() != vertices.cantidad() - 1) {
            return false;
        }
        // Verificar si el grafo es conexo
        if (!esConexo()) {
            return false;
        }
        // Verificar si el grafo no tiene ciclos
        if (tieneCiclos()) {
            return false;
        }
        return true; // Cumple todas las condiciones para ser un árbol
    }

    /**
     * Imprime las aristas de el grafo
     * @return
     */
    public ListaEstatica listarAristas(){
        int tamaño = aristas.getColumnas()*aristas.getRenglones();
        ListaEstatica listaAristas = new ListaEstatica(tamaño);
        for (int cadaRenglon = 0; cadaRenglon < aristas.getRenglones(); cadaRenglon++) {
            for (int cadaColumna = 0; cadaColumna < aristas.getColumnas(); cadaColumna++) {
                if((double)aristas.obtener(cadaRenglon, cadaColumna)>0.0){
                    ListaEstatica arista = new ListaEstatica(3);
                    arista.agregar(vertices.obtener(cadaRenglon));
                    arista.agregar(vertices.obtener(cadaColumna));
                    arista.agregar(aristas.obtener(cadaRenglon, cadaColumna));
                    String aristaString = "("+arista.obtener(0)+","+arista.obtener(1)+","+arista.obtener(2)+")";
                    listaAristas.agregar(aristaString);
                }
            }
        }
        return listaAristas;
    }

    /**
     * Imprime las aristas de un verticce
     * @param vertice
     * @return
     */
    public ListaEstatica listarAristas(Object vertice){
        int tamaño = aristas.getColumnas();
        ListaEstatica listaAristas = new ListaEstatica(tamaño);
        int posicion = (int) vertices.buscar(vertice);
        if(posicion!=-1) {
            for (int cadaColumna = 0; cadaColumna < aristas.getColumnas(); cadaColumna++) {
                if ((double) aristas.obtener(posicion, cadaColumna) > 0.0) {
                    ListaEstatica arista = new ListaEstatica(3);
                    arista.agregar(vertices.obtener(posicion));
                    arista.agregar(vertices.obtener(cadaColumna));
                    arista.agregar(aristas.obtener(posicion, cadaColumna));
                    String aristaString = "(" + arista.obtener(0) + "," + arista.obtener(1) + "," + arista.obtener(2) + ")";
                    listaAristas.agregar(aristaString);
                }
            }
        }
        return listaAristas;
    }

    /**
     * Imprime los certices
     */
    public void listarVertices(){
        vertices.imprimir();
    }


    private boolean tieneCiclos() {
        ListaEstatica visitados = new ListaEstatica(vertices.cantidad());
        visitados.rellenar(false, vertices.cantidad());

        for (int indice = 0; indice < vertices.cantidad(); indice++) {
            boolean visitado = (boolean) visitados.obtener(indice);
            if (!visitado) {
                if (tieneCiclosRecursivo(indice, -1, visitados)) {
                    return true;
                }
            }
        }

        return false;
    }
    private boolean tieneCiclosRecursivo(int vertice, int padre, ListaEstatica visitados) {
        visitados.cambiar(vertice, true);
        for (int cadaVertice = 0; cadaVertice < vertices.cantidad(); cadaVertice++) {
            boolean visitado = (boolean) visitados.obtener(cadaVertice);
            if ((double) aristas.obtener(vertice, cadaVertice) > 0.0) {
                if (!visitado) {
                    if (tieneCiclosRecursivo(cadaVertice, vertice, visitados)) {
                        return true;
                    }
                } else if (cadaVertice != padre) {
                    return true;
                }
            }
        }
        return false;
    }



}
