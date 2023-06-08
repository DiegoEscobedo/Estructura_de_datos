package registro.competenciasAtleticas;

import entradaSalida.SalidaPorDefecto;
import estructurasLineales.ListaEstatica;
import estructurasNoLineales.Matriz3;

public class ControlCompetenciasCorredores {
    protected Matriz3 keRecorridos;
    protected ListaEstatica anios;
    protected ListaEstatica corredores;
    protected ListaEstatica eventosCompetencias;
    public ControlCompetenciasCorredores(int numAnios, int numCorredores, int numeroDeeventosCompetencias){
        keRecorridos  = new Matriz3(numAnios,numCorredores,numeroDeeventosCompetencias);
        anios = new ListaEstatica(numAnios);
        corredores = new ListaEstatica(numCorredores);
        eventosCompetencias = new ListaEstatica(numeroDeeventosCompetencias);
        keRecorridos.rellenar(0.0);
    }
    public boolean agregarAnio(int anio){
        int indiceAnio = (int)anios.buscar(anio);
        if(indiceAnio == -1){
            int retorno=anios.agregar(anio);
            return retorno != -1;
        }else{
            return false;
        }
    }
    public boolean agregarCorredor(Corredor corredor){
        int indiceCorredor = (int)corredores.buscar(corredor);
        if(indiceCorredor == -1){
            int retorno=corredores.agregar(corredor);
            return retorno != -1;
        }else{
            return false;
        }
    }
    public boolean agregarCompetencia(EventoCompetencia evento) {
        int indiceCompetencia = (int) eventosCompetencias.buscar(evento);
        if(indiceCompetencia == -1){
            int retorno=eventosCompetencias.agregar(evento);
            return retorno != -1;
        }else{
            return false;
        }
    }
    public boolean agregarKeRecorridos(int anio, int corredor, String nombreEvento, double kilometros){
        ListaEstatica listaIndices = buscarIndicesCubos(anio,corredor,nombreEvento);
        if(listaIndices != null){//Son buenos los indices
            return keRecorridos.cambiar((int)listaIndices.obtener(0),(int)listaIndices.obtener(1),(int)listaIndices.obtener(2),kilometros);
        }else{
            return false;
        }
    }
    public ListaEstatica buscarIndicesCubos(int anio, int corredor, String nombreEvento){
        int indiceAnio = (int)anios.buscar(anio);
        int indiceCorredor = (int)corredores.buscar(corredor);
        int indiceCompetencia = (int) eventosCompetencias.buscar(nombreEvento);
        if(indiceAnio>=0 && indiceCorredor>=0 && indiceCompetencia>=0){
            ListaEstatica listaIndices = new ListaEstatica(3);
            listaIndices.agregar(indiceAnio);
            listaIndices.agregar(indiceCorredor);
            listaIndices.agregar(indiceCompetencia);
            return listaIndices;
        }
        return null;
    }
    public void imprimirAnios(){
        SalidaPorDefecto.terminal("Anio: \n");
        anios.imprimir();
    }

    public void imprimirCorredores(){
        SalidaPorDefecto.terminal("Corredores: \n");
        corredores.imprimir();
    }

    public void imprimirEventos(){
        SalidaPorDefecto.terminal("Eventos: \n");
        eventosCompetencias.imprimir();
    }

    public void imprimirKm(){
        SalidaPorDefecto.terminal("Kilometros: \n");
        keRecorridos.imprimirPorColumna();
    }

    public void imprimirDatosCompetencia() {
        imprimirAnios();
        imprimirCorredores();
        imprimirEventos();
        imprimirKm();
    }
    public double kmRecorridosPorCorredorPorEvento(int numeroCorredor, String evento, ListaEstatica aniosPedidos){
        double kmAcumulados = 0.0;
        for(int cadaAnio = 0 ; cadaAnio<aniosPedidos.cantidad();cadaAnio++){
            int anioPedido = (int) aniosPedidos.obtener(cadaAnio);
            double kmIndividual=kmRecorridosPorCorredorPorAnioYevento(numeroCorredor,evento,anioPedido);
            if(kmIndividual >= 0){
                kmAcumulados += kmIndividual;
            }else {
                //nada
            }
        }
        return kmAcumulados;
    }
    public double kmRecorridosPorCorredorPorAnioYevento(int numeroCorredor, String evento, int anio){
        ListaEstatica indicesDeCubo = buscarIndicesCubos(anio, numeroCorredor, evento);
        if(indicesDeCubo != null){
            return (double)keRecorridos.obtener((int)indicesDeCubo.obtener(0),(int)indicesDeCubo.obtener(1),(int)indicesDeCubo.obtener(2));
        }else{
            return -1.0;
        }
    }
}
