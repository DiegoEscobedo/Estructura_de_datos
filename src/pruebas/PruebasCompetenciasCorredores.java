package pruebas;

import entradaSalida.SalidaPorDefecto;
import estructurasLineales.ListaEstatica;
import registro.competenciasAtleticas.ControlCompetenciasCorredores;
import registro.competenciasAtleticas.Corredor;
import registro.competenciasAtleticas.EventoCompetencia;

public class PruebasCompetenciasCorredores {
    public static void main(String[] args) {
        ControlCompetenciasCorredores competencias = new ControlCompetenciasCorredores(4,3,5);
        competencias.agregarAnio(1989);
        competencias.agregarAnio(2002);
        competencias.agregarAnio(2013);
        competencias.agregarAnio(2021);

        Corredor corredor1 = new Corredor(101,"Duki",23,"Argentina");
        Corredor corredor2 = new Corredor(102,"Ysya",24,"Argentina");
        Corredor corredor3 = new Corredor(103,"NeoPistea",25,"Argentina");

        competencias.agregarCorredor(corredor1);
        competencias.agregarCorredor(corredor2);
        competencias.agregarCorredor(corredor3);

        EventoCompetencia competencia1= new EventoCompetencia("Carrera del Modo Diablo", "Argentina");
        EventoCompetencia competencia2= new EventoCompetencia("Carrera Feliz", "Mexico");
        EventoCompetencia competencia3= new EventoCompetencia("LolaPalooza","Argentina");
        EventoCompetencia competencia4=new EventoCompetencia("CarreraEUSA", "Canada");
        EventoCompetencia competencia5=new EventoCompetencia("Olimpicos", "Mexico");

        competencias.agregarCompetencia(competencia1);
        competencias.agregarCompetencia(competencia2);
        competencias.agregarCompetencia(competencia3);
        competencias.agregarCompetencia(competencia4);
        competencias.agregarCompetencia(competencia5);

        competencias.agregarKeRecorridos(2002,101,"Carrera Feliz", 10.5);
        competencias.agregarKeRecorridos(2013,102,"LolaPalooza", 1.5);
        competencias.agregarKeRecorridos(2021,103,"CarreraEUSA", 3.5);
        competencias.agregarKeRecorridos(2021,103,"Olimpicos", 20.5);

        competencias.agregarKeRecorridos(1989,101,"Carrera del Modo Diablo", 10.5);
        competencias.agregarKeRecorridos(1989,102,"Carrera del Modo Diablo", 10.5);
        competencias.agregarKeRecorridos(1989,103,"Carrera del Modo Diablo", 10.5);

        competencias.imprimirDatosCompetencia();

        ListaEstatica aniosPedidosCorredor = new ListaEstatica(3);
        aniosPedidosCorredor.agregar(1989);
        aniosPedidosCorredor.agregar(2002);
        aniosPedidosCorredor.agregar(2013);
        double kmPedidos = competencias.kmRecorridosPorCorredorPorEvento(101, "Carrera del Modo Diablo", aniosPedidosCorredor);
        SalidaPorDefecto.terminal("La salida acumulada de kms de"+ kmPedidos);
    }
}
