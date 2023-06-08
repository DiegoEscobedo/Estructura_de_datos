package pruebas;

import arreglosUnidimensionales.Campesino;
import arreglosUnidimensionales.RegistroCampesinos;
import entradaSalida.*;
import estructurasLineales.ListaEstatica;

public class PruebaCampesinos {
    public static void main(String[] args) {
        RegistroCampesinos nuevoRegistro = new RegistroCampesinos("CampesinosAC", 2);
        ListaEstatica toneladasC2 = new ListaEstatica(48);
        double tonelada2 = 30.50;
        for (int num = 0; num < 48; num++) {
            toneladasC2.agregar(tonelada2);
            tonelada2 = tonelada2 + 5.00;
        }
        Campesino campesino2 = new Campesino(2.2, "Pedro", toneladasC2);
        ListaEstatica toneladasC1 = new ListaEstatica(48);
        double tonelada = 100.50;
        for (int num = 0; num < 48; num++) {
            toneladasC1.agregar(tonelada);
            tonelada = tonelada + 10.00;
        }
        Campesino campesino1 = new Campesino(2.1, "Pancho", toneladasC1);
        SalidaPorDefecto.terminal("Tus campesinos son:");
        nuevoRegistro.agregarCampesino(campesino1);
        nuevoRegistro.agregarCampesino(campesino2);
        nuevoRegistro.imprimirDatosRegistro();
        SalidaPorDefecto.terminal("Introduzca el numero de campesino a consultar...");
        double numeroCampesino = Double.parseDouble(entradasalida.EntradaPorDefecto.consolaCadenas());
        if(numeroCampesino == campesino2.getNuemeroCampesino()) {
            SalidaPorDefecto.terminal("Dijite la letre de lo que desea hacer..." + "\n" +
                    "A) El promedio anual de toneladas del campesino." + "\n" +
                    "B.Cuántos meses tuvieron toneladas mayores al promedio anual del campesino" + "\n" +
                    "C)Cuál fue el mes que obtuvo menos toneladas por cada año del campesino " + "\n" +
                    "D) ¿Cuántas toneladas se obtuvieron el último mes de cada año del campesino" + "\n" +
                    "E)Cuántas toneladas se obtuvieron en el segundo trimestre de cada año del campesino " + "\n" +
                    "F)Qué campesino ha realizado peor su trabajo en cada año" + "\n" +
                    "G)Qué mes es el que produce mayores dividendos a los campesinos" + "\n" +
                    "H)Qué época de los años genero mayor ganancia en producción" + "\n" +
                    "I)Ingresar Datos" + "\n" +
                    "j)TODO");
            String letra = entradasalida.EntradaPorDefecto.consolaCadenas();
            letra = letra.toLowerCase();
            if (letra.equals("a")) {
                ListaEstatica promedioAnualCampesino1 = new ListaEstatica(4);
                promedioAnualCampesino1 = nuevoRegistro.promedioAnual(campesino1);
                SalidaPorDefecto.terminal("El promedio del primer año es: " + promedioAnualCampesino1.obtener(0));
                SalidaPorDefecto.terminal("El promedio del segundo año es: " + promedioAnualCampesino1.obtener(1));
                SalidaPorDefecto.terminal("El promedio del tercer año es: " + promedioAnualCampesino1.obtener(2));
                SalidaPorDefecto.terminal("El promedio del cuarto año es: " + promedioAnualCampesino1.obtener(3));
            }
            if (letra.equals("b")) {
                SalidaPorDefecto.terminal("los meses mayores al promedio de cada año son:" + nuevoRegistro.mesesMayoresAlPromedio(campesino1));
            }
            if (letra.equals("c")) {
                SalidaPorDefecto.terminal("Los meses de menor produccion del primer año son:" + campesino1.convertirNumeroaMes((int) nuevoRegistro.mesesConMenorProduccionDelCampesino(campesino1).obtener(0)));
                SalidaPorDefecto.terminal("Los meses de menor produccion del segundo año son:" + campesino1.convertirNumeroaMes((int) nuevoRegistro.mesesConMenorProduccionDelCampesino(campesino1).obtener(1)));
                SalidaPorDefecto.terminal("Los meses de menor produccion del tercer año son:" + campesino1.convertirNumeroaMes((int) nuevoRegistro.mesesConMenorProduccionDelCampesino(campesino1).obtener(2)));
                SalidaPorDefecto.terminal("Los meses de menor produccion del cuarto año son:" + campesino1.convertirNumeroaMes((int) nuevoRegistro.mesesConMenorProduccionDelCampesino(campesino1).obtener(3)));
            }
            if (letra.equals("d")) {
                SalidaPorDefecto.terminal("Las toneladas de el ulimo mes del primer año son: " + nuevoRegistro.toneladasDeLosUltimosMeses(campesino1).obtener(0));
                SalidaPorDefecto.terminal("Las toneladas de el ulimo mes del segundo año son: " + nuevoRegistro.toneladasDeLosUltimosMeses(campesino1).obtener(1));
                SalidaPorDefecto.terminal("Las toneladas de el ulimo mes del tercer año son: " + nuevoRegistro.toneladasDeLosUltimosMeses(campesino1).obtener(2));
                SalidaPorDefecto.terminal("Las toneladas de el ulimo mes del cuarto año son: " + nuevoRegistro.toneladasDeLosUltimosMeses(campesino1).obtener(3));

            }
            if (letra.equals("e")) {
                SalidaPorDefecto.terminal("Las toneladas de el 2do trimestre de el primer año son: " + nuevoRegistro.tonelaasDeLosSegundosTrimestres(campesino1).obtener(0));
                SalidaPorDefecto.terminal("Las toneladas de el 2do trimestre de el segundo año son: " + nuevoRegistro.tonelaasDeLosSegundosTrimestres(campesino1).obtener(1));
                SalidaPorDefecto.terminal("Las toneladas de el 2do trimestre de el tercer año son: " + nuevoRegistro.tonelaasDeLosSegundosTrimestres(campesino1).obtener(2));
                SalidaPorDefecto.terminal("Las toneladas de el 2do trimestre de el cuarto año son: " + nuevoRegistro.tonelaasDeLosSegundosTrimestres(campesino1).obtener(3));
            }
            if (letra.equals("f")) {
                SalidaPorDefecto.terminal("El campesino que realizo peor su trabajo el primer año fue: " + nuevoRegistro.campesinoQueRealizoPeorTrabajo(campesino1, campesino2).obtener(0));
                SalidaPorDefecto.terminal("El campesino que realizo peor su trabajo el segundo año fue: " + nuevoRegistro.campesinoQueRealizoPeorTrabajo(campesino1, campesino2).obtener(1));
                SalidaPorDefecto.terminal("El campesino que realizo peor su trabajo el tercer año fue: " + nuevoRegistro.campesinoQueRealizoPeorTrabajo(campesino1, campesino2).obtener(2));
                SalidaPorDefecto.terminal("El campesino que realizo peor su trabajo el cuarto año fue: " + nuevoRegistro.campesinoQueRealizoPeorTrabajo(campesino1, campesino2).obtener(3));
            }
            if (letra.equals("g")) {
                SalidaPorDefecto.terminal("Que mes produjo mayores dividendos el primer año" + campesino1.convertirNumeroaMes((int) campesino1.mesQueGeneraMasDividendos().obtener(0)));
                SalidaPorDefecto.terminal("Que mes produjo mayores dividendos el segundo año" + campesino1.convertirNumeroaMes((int) campesino1.mesQueGeneraMasDividendos().obtener(1)));
                SalidaPorDefecto.terminal("Que mes produjo mayores dividendos el tercer año" + campesino1.convertirNumeroaMes((int) campesino1.mesQueGeneraMasDividendos().obtener(2)));
                SalidaPorDefecto.terminal("Que mes produjo mayores dividendos el cuarto año" + campesino1.convertirNumeroaMes((int) campesino1.mesQueGeneraMasDividendos().obtener(3)));
            }
            if (letra.equals("h")) {
                SalidaPorDefecto.terminal("En que epoca de lod ultimos 4 años se genero mayor produccion: " + nuevoRegistro.enQueEpocaGeneraMas(campesino1));
            }
            if (letra.equals("i")) {

            }
            if (letra.equals("j")) {
                ListaEstatica promedioAnualCampesino1 = new ListaEstatica(4);
                promedioAnualCampesino1 = nuevoRegistro.promedioAnual(campesino1);
                SalidaPorDefecto.terminal("El promedio del primer año es: " + promedioAnualCampesino1.obtener(0));
                SalidaPorDefecto.terminal("El promedio del segundo año es: " + promedioAnualCampesino1.obtener(1));
                SalidaPorDefecto.terminal("El promedio del tercer año es: " + promedioAnualCampesino1.obtener(2));
                SalidaPorDefecto.terminal("El promedio del cuarto año es: " + promedioAnualCampesino1.obtener(3));

                SalidaPorDefecto.terminal("los meses mayores al promedio de cada año son:" + nuevoRegistro.mesesMayoresAlPromedio(campesino1));

                SalidaPorDefecto.terminal("Los meses de menor produccion del primer año son:" + campesino1.convertirNumeroaMes((int) nuevoRegistro.mesesConMenorProduccionDelCampesino(campesino1).obtener(0)));
                SalidaPorDefecto.terminal("Los meses de menor produccion del segundo año son:" + campesino1.convertirNumeroaMes((int) nuevoRegistro.mesesConMenorProduccionDelCampesino(campesino1).obtener(1)));
                SalidaPorDefecto.terminal("Los meses de menor produccion del tercer año son:" + campesino1.convertirNumeroaMes((int) nuevoRegistro.mesesConMenorProduccionDelCampesino(campesino1).obtener(2)));
                SalidaPorDefecto.terminal("Los meses de menor produccion del cuarto año son:" + campesino1.convertirNumeroaMes((int) nuevoRegistro.mesesConMenorProduccionDelCampesino(campesino1).obtener(3)));

                SalidaPorDefecto.terminal("Las toneladas de el ulimo mes del primer año son: " + nuevoRegistro.toneladasDeLosUltimosMeses(campesino1).obtener(0));
                SalidaPorDefecto.terminal("Las toneladas de el ulimo mes del segundo año son: " + nuevoRegistro.toneladasDeLosUltimosMeses(campesino1).obtener(1));
                SalidaPorDefecto.terminal("Las toneladas de el ulimo mes del tercer año son: " + nuevoRegistro.toneladasDeLosUltimosMeses(campesino1).obtener(2));
                SalidaPorDefecto.terminal("Las toneladas de el ulimo mes del cuarto año son: " + nuevoRegistro.toneladasDeLosUltimosMeses(campesino1).obtener(3));

                SalidaPorDefecto.terminal("Las toneladas de el 2do trimestre de el primer año son: " + nuevoRegistro.tonelaasDeLosSegundosTrimestres(campesino1).obtener(0));
                SalidaPorDefecto.terminal("Las toneladas de el 2do trimestre de el segundo año son: " + nuevoRegistro.tonelaasDeLosSegundosTrimestres(campesino1).obtener(1));
                SalidaPorDefecto.terminal("Las toneladas de el 2do trimestre de el tercer año son: " + nuevoRegistro.tonelaasDeLosSegundosTrimestres(campesino1).obtener(2));
                SalidaPorDefecto.terminal("Las toneladas de el 2do trimestre de el cuarto año son: " + nuevoRegistro.tonelaasDeLosSegundosTrimestres(campesino1).obtener(3));

                SalidaPorDefecto.terminal("El campesino que realizo peor su trabajo el primer año fue: " + nuevoRegistro.campesinoQueRealizoPeorTrabajo(campesino1, campesino2).obtener(0));
                SalidaPorDefecto.terminal("El campesino que realizo peor su trabajo el segundo año fue: " + nuevoRegistro.campesinoQueRealizoPeorTrabajo(campesino1, campesino2).obtener(1));
                SalidaPorDefecto.terminal("El campesino que realizo peor su trabajo el tercer año fue: " + nuevoRegistro.campesinoQueRealizoPeorTrabajo(campesino1, campesino2).obtener(2));
                SalidaPorDefecto.terminal("El campesino que realizo peor su trabajo el cuarto año fue: " + nuevoRegistro.campesinoQueRealizoPeorTrabajo(campesino1, campesino2).obtener(3));

                SalidaPorDefecto.terminal("Que mes produjo mayores dividendos el primer año" + campesino1.convertirNumeroaMes((int) campesino1.mesQueGeneraMasDividendos().obtener(0)));
                SalidaPorDefecto.terminal("Que mes produjo mayores dividendos el segundo año" + campesino1.convertirNumeroaMes((int) campesino1.mesQueGeneraMasDividendos().obtener(1)));
                SalidaPorDefecto.terminal("Que mes produjo mayores dividendos el tercer año" + campesino1.convertirNumeroaMes((int) campesino1.mesQueGeneraMasDividendos().obtener(2)));
                SalidaPorDefecto.terminal("Que mes produjo mayores dividendos el cuarto año" + campesino1.convertirNumeroaMes((int) campesino1.mesQueGeneraMasDividendos().obtener(3)));

                SalidaPorDefecto.terminal("En que epoca de lod ultimos 4 años se genero mayor produccion: " + nuevoRegistro.enQueEpocaGeneraMas(campesino1));
            }
        }
        if(numeroCampesino == campesino1.getNuemeroCampesino()){
            SalidaPorDefecto.terminal("Dijite la letre de lo que desea hacer..." + "\n" +
                    "A) El promedio anual de toneladas del campesino." + "\n" +
                    "B.Cuántos meses tuvieron toneladas mayores al promedio anual del campesino" + "\n" +
                    "C)Cuál fue el mes que obtuvo menos toneladas por cada año del campesino " + "\n" +
                    "D) ¿Cuántas toneladas se obtuvieron el último mes de cada año del campesino" + "\n" +
                    "E)Cuántas toneladas se obtuvieron en el segundo trimestre de cada año del campesino " + "\n" +
                    "F)Qué campesino ha realizado peor su trabajo en cada año" + "\n" +
                    "G)Qué mes es el que produce mayores dividendos a los campesinos" + "\n" +
                    "H)Qué época de los años genero mayor ganancia en producción"+ "\n" +
                    "I)Ingresar Datos" + "\n" +
                    "j)TODO");
            String letra = entradasalida.EntradaPorDefecto.consolaCadenas();
            letra = letra.toLowerCase();
            if(letra.equals("a")){
                ListaEstatica promedioAnualCampesino1 = new ListaEstatica(4);
                promedioAnualCampesino1 = nuevoRegistro.promedioAnual(campesino1);
                SalidaPorDefecto.terminal("El promedio del primer año es: " + promedioAnualCampesino1.obtener(0));
                SalidaPorDefecto.terminal("El promedio del segundo año es: " + promedioAnualCampesino1.obtener(1));
                SalidaPorDefecto.terminal("El promedio del tercer año es: " + promedioAnualCampesino1.obtener(2));
                SalidaPorDefecto.terminal("El promedio del cuarto año es: " + promedioAnualCampesino1.obtener(3));
            }
            if(letra.equals("b")){
                SalidaPorDefecto.terminal("los meses mayores al promedio de cada año son:" + nuevoRegistro.mesesMayoresAlPromedio(campesino1));
            }
            if(letra.equals("c")){
                SalidaPorDefecto.terminal("Los meses de menor produccion del primer año son:" + campesino1.convertirNumeroaMes((int)nuevoRegistro.mesesConMenorProduccionDelCampesino(campesino1).obtener(0)));
                SalidaPorDefecto.terminal("Los meses de menor produccion del segundo año son:" + campesino1.convertirNumeroaMes((int)nuevoRegistro.mesesConMenorProduccionDelCampesino(campesino1).obtener(1)));
                SalidaPorDefecto.terminal("Los meses de menor produccion del tercer año son:" + campesino1.convertirNumeroaMes((int)nuevoRegistro.mesesConMenorProduccionDelCampesino(campesino1).obtener(2)));
                SalidaPorDefecto.terminal("Los meses de menor produccion del cuarto año son:" + campesino1.convertirNumeroaMes((int)nuevoRegistro.mesesConMenorProduccionDelCampesino(campesino1).obtener(3)));
            }
            if(letra.equals("d")){
                SalidaPorDefecto.terminal("Las toneladas de el ulimo mes del primer año son: " + nuevoRegistro.toneladasDeLosUltimosMeses(campesino1).obtener(0));
                SalidaPorDefecto.terminal("Las toneladas de el ulimo mes del segundo año son: " + nuevoRegistro.toneladasDeLosUltimosMeses(campesino1).obtener(1));
                SalidaPorDefecto.terminal("Las toneladas de el ulimo mes del tercer año son: " + nuevoRegistro.toneladasDeLosUltimosMeses(campesino1).obtener(2));
                SalidaPorDefecto.terminal("Las toneladas de el ulimo mes del cuarto año son: " + nuevoRegistro.toneladasDeLosUltimosMeses(campesino1).obtener(3));

            }
            if(letra.equals("e")){
                SalidaPorDefecto.terminal("Las toneladas de el 2do trimestre de el primer año son: " + nuevoRegistro.tonelaasDeLosSegundosTrimestres(campesino1).obtener(0));
                SalidaPorDefecto.terminal("Las toneladas de el 2do trimestre de el segundo año son: " + nuevoRegistro.tonelaasDeLosSegundosTrimestres(campesino1).obtener(1));
                SalidaPorDefecto.terminal("Las toneladas de el 2do trimestre de el tercer año son: " + nuevoRegistro.tonelaasDeLosSegundosTrimestres(campesino1).obtener(2));
                SalidaPorDefecto.terminal("Las toneladas de el 2do trimestre de el cuarto año son: " + nuevoRegistro.tonelaasDeLosSegundosTrimestres(campesino1).obtener(3));
            }
            if(letra.equals("f")){
                SalidaPorDefecto.terminal("El campesino que realizo peor su trabajo el primer año fue: " + nuevoRegistro.campesinoQueRealizoPeorTrabajo(campesino1, campesino2).obtener(0));
                SalidaPorDefecto.terminal("El campesino que realizo peor su trabajo el segundo año fue: " + nuevoRegistro.campesinoQueRealizoPeorTrabajo(campesino1, campesino2).obtener(1));
                SalidaPorDefecto.terminal("El campesino que realizo peor su trabajo el tercer año fue: " + nuevoRegistro.campesinoQueRealizoPeorTrabajo(campesino1, campesino2).obtener(2));
                SalidaPorDefecto.terminal("El campesino que realizo peor su trabajo el cuarto año fue: " + nuevoRegistro.campesinoQueRealizoPeorTrabajo(campesino1, campesino2).obtener(3));
            }
            if(letra.equals("g")){
                SalidaPorDefecto.terminal("Que mes produjo mayores dividendos el primer año" + campesino1.convertirNumeroaMes((int)campesino1.mesQueGeneraMasDividendos().obtener(0)));
                SalidaPorDefecto.terminal("Que mes produjo mayores dividendos el segundo año" + campesino1.convertirNumeroaMes((int)campesino1.mesQueGeneraMasDividendos().obtener(1)));
                SalidaPorDefecto.terminal("Que mes produjo mayores dividendos el tercer año" + campesino1.convertirNumeroaMes((int)campesino1.mesQueGeneraMasDividendos().obtener(2)));
                SalidaPorDefecto.terminal("Que mes produjo mayores dividendos el cuarto año" + campesino1.convertirNumeroaMes((int)campesino1.mesQueGeneraMasDividendos().obtener(3)));
            }
            if(letra.equals("h")){
                SalidaPorDefecto.terminal("En que epoca de lod ultimos 4 años se genero mayor produccion: " + nuevoRegistro.enQueEpocaGeneraMas(campesino1));
            }
            if(letra.equals("i")){

            }
            if(letra.equals("j")){
                ListaEstatica promedioAnualCampesino1 = new ListaEstatica(4);
                promedioAnualCampesino1 = nuevoRegistro.promedioAnual(campesino1);
                SalidaPorDefecto.terminal("El promedio del primer año es: " + promedioAnualCampesino1.obtener(0));
                SalidaPorDefecto.terminal("El promedio del segundo año es: " + promedioAnualCampesino1.obtener(1));
                SalidaPorDefecto.terminal("El promedio del tercer año es: " + promedioAnualCampesino1.obtener(2));
                SalidaPorDefecto.terminal("El promedio del cuarto año es: " + promedioAnualCampesino1.obtener(3));

                SalidaPorDefecto.terminal("los meses mayores al promedio de cada año son:" + nuevoRegistro.mesesMayoresAlPromedio(campesino1));

                SalidaPorDefecto.terminal("Los meses de menor produccion del primer año son:" + campesino1.convertirNumeroaMes((int)nuevoRegistro.mesesConMenorProduccionDelCampesino(campesino1).obtener(0)));
                SalidaPorDefecto.terminal("Los meses de menor produccion del segundo año son:" + campesino1.convertirNumeroaMes((int)nuevoRegistro.mesesConMenorProduccionDelCampesino(campesino1).obtener(1)));
                SalidaPorDefecto.terminal("Los meses de menor produccion del tercer año son:" + campesino1.convertirNumeroaMes((int)nuevoRegistro.mesesConMenorProduccionDelCampesino(campesino1).obtener(2)));
                SalidaPorDefecto.terminal("Los meses de menor produccion del cuarto año son:" + campesino1.convertirNumeroaMes((int)nuevoRegistro.mesesConMenorProduccionDelCampesino(campesino1).obtener(3)));

                SalidaPorDefecto.terminal("Las toneladas de el ulimo mes del primer año son: " + nuevoRegistro.toneladasDeLosUltimosMeses(campesino1).obtener(0));
                SalidaPorDefecto.terminal("Las toneladas de el ulimo mes del segundo año son: " + nuevoRegistro.toneladasDeLosUltimosMeses(campesino1).obtener(1));
                SalidaPorDefecto.terminal("Las toneladas de el ulimo mes del tercer año son: " + nuevoRegistro.toneladasDeLosUltimosMeses(campesino1).obtener(2));
                SalidaPorDefecto.terminal("Las toneladas de el ulimo mes del cuarto año son: " + nuevoRegistro.toneladasDeLosUltimosMeses(campesino1).obtener(3));

                SalidaPorDefecto.terminal("Las toneladas de el 2do trimestre de el primer año son: " + nuevoRegistro.tonelaasDeLosSegundosTrimestres(campesino1).obtener(0));
                SalidaPorDefecto.terminal("Las toneladas de el 2do trimestre de el segundo año son: " + nuevoRegistro.tonelaasDeLosSegundosTrimestres(campesino1).obtener(1));
                SalidaPorDefecto.terminal("Las toneladas de el 2do trimestre de el tercer año son: " + nuevoRegistro.tonelaasDeLosSegundosTrimestres(campesino1).obtener(2));
                SalidaPorDefecto.terminal("Las toneladas de el 2do trimestre de el cuarto año son: " + nuevoRegistro.tonelaasDeLosSegundosTrimestres(campesino1).obtener(3));

                SalidaPorDefecto.terminal("El campesino que realizo peor su trabajo el primer año fue: " + nuevoRegistro.campesinoQueRealizoPeorTrabajo(campesino1, campesino2).obtener(0));
                SalidaPorDefecto.terminal("El campesino que realizo peor su trabajo el segundo año fue: " + nuevoRegistro.campesinoQueRealizoPeorTrabajo(campesino1, campesino2).obtener(1));
                SalidaPorDefecto.terminal("El campesino que realizo peor su trabajo el tercer año fue: " + nuevoRegistro.campesinoQueRealizoPeorTrabajo(campesino1, campesino2).obtener(2));
                SalidaPorDefecto.terminal("El campesino que realizo peor su trabajo el cuarto año fue: " + nuevoRegistro.campesinoQueRealizoPeorTrabajo(campesino1, campesino2).obtener(3));

                SalidaPorDefecto.terminal("Que mes produjo mayores dividendos el primer año" + campesino1.convertirNumeroaMes((int)campesino1.mesQueGeneraMasDividendos().obtener(0)));
                SalidaPorDefecto.terminal("Que mes produjo mayores dividendos el segundo año" + campesino1.convertirNumeroaMes((int)campesino1.mesQueGeneraMasDividendos().obtener(1)));
                SalidaPorDefecto.terminal("Que mes produjo mayores dividendos el tercer año" + campesino1.convertirNumeroaMes((int)campesino1.mesQueGeneraMasDividendos().obtener(2)));
                SalidaPorDefecto.terminal("Que mes produjo mayores dividendos el cuarto año" + campesino1.convertirNumeroaMes((int)campesino1.mesQueGeneraMasDividendos().obtener(3)));

                SalidaPorDefecto.terminal("En que epoca de lod ultimos 4 años se genero mayor produccion: " + nuevoRegistro.enQueEpocaGeneraMas(campesino1));
            }
        }

    }
}
