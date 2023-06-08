package arreglosUnidimensionales;

import entradaSalida.SalidaPorDefecto;
import estructurasLineales.ListaEstatica;

/**
 * @author diego
 * @version 1.0
 */
public class RegistroCampesinos {
    protected ListaEstatica campesinos;
    protected String nombre;
    protected int cantidadCampesinos;

    public RegistroCampesinos(String nombre, int cantidadCampesinos) {
        this.nombre = nombre;
        this.campesinos = new ListaEstatica(cantidadCampesinos);
    }

    public RegistroCampesinos(String nombre) {
        this.nombre = nombre;
    }

    public ListaEstatica promedioAnual(Campesino campesino){
        int pocisionCampesino = (int)campesinos.buscar(campesino);
        if(pocisionCampesino==-1){
            return null;
        }else {
            Campesino campesinotemp = (Campesino) campesinos.obtener(pocisionCampesino);
            return campesinotemp.obtenerPromedioCampesino();
        }
    }
    public int mesesMayoresAlPromedio(Campesino campesino) {
        int mesesMayores = 0;
        int pocisionCampesino = (int) campesinos.buscar(campesino);
        if (pocisionCampesino == -1) {
            return -1;
        } else {
            int meses = 12;
            int cadaMes=0;
            for (int cadaAnio = 0; cadaAnio < 4; cadaAnio++) {
                while (cadaMes < meses) {
                    if ((double)promedioAnual(campesino).obtener(cadaAnio) < (double)campesino.toneladas.obtener(cadaMes)) {
                        mesesMayores++;
                    }
                    cadaMes++;
                }
                meses = meses+12;
            }
        }
        return mesesMayores;
    }
    public ListaEstatica mesesConMenorProduccionDelCampesino(Campesino campesino){
        int pocisionCampesino = (int)campesinos.buscar(campesino);
        if(pocisionCampesino==-1){
            return null;
        }else {
            Campesino campesinotemp = (Campesino) campesinos.obtener(pocisionCampesino);
            return campesinotemp.mesConMenorProduccion();
        }
    }

    public ListaEstatica toneladasDeLosUltimosMeses(Campesino campesino){
        int pocisionCampesino = (int)campesinos.buscar(campesino);
        if(pocisionCampesino==-1){
            return null;
        }else {
            Campesino campesinotemp = (Campesino) campesinos.obtener(pocisionCampesino);
            return campesinotemp.toneladasDeUltimoMes();
        }
    }

    public ListaEstatica tonelaasDeLosSegundosTrimestres(Campesino campesino){
        int pocisionCampesino = (int)campesinos.buscar(campesino);
        if(pocisionCampesino==-1){
            return null;
        }else {
            Campesino campesinotemp = (Campesino) campesinos.obtener(pocisionCampesino);
            return campesinotemp.toneladasDeLosSegundosTrimestres();
        }
    }

    public ListaEstatica campesinoQueRealizoPeorTrabajo(Campesino campesino1, Campesino campesino2){
        ListaEstatica peorCampesino = new ListaEstatica(4);
        int meses = 12;
        int cadaMes = 0;
        for (int cadaAnio = 0; cadaAnio < 4; cadaAnio++) {
            while (cadaMes < meses) {
                if((double)campesino1.obtenerPromedioCampesino().obtener(cadaAnio) < (double)campesino1.obtenerPromedioCampesino().obtener(cadaAnio)){
                    peorCampesino.agregar(campesino1);
                }else{
                    peorCampesino.agregar(campesino2);
                }
                cadaMes++;
            }
            meses = meses +12;
        }
        return peorCampesino;
    }


    public String enQueEpocaGeneraMas(Campesino campesino){
         double promPrimavera = campesino.promedioDePrimavera();
         double promedioVerano = campesino.promedioDeVerano();
         double promedioOtoño = campesino.promedioDeOtoño();
         double promedioInvierno = campesino.promedioDeInvierno();
         if(promPrimavera > promedioVerano && promPrimavera > promedioOtoño && promPrimavera > promedioInvierno){
             return "Primavera";
         }
         if (promedioVerano > promPrimavera && promedioVerano > promedioOtoño && promedioVerano > promedioInvierno){
             return "Verano";
         }
        if (promedioOtoño > promPrimavera && promedioOtoño > promedioVerano && promedioOtoño > promedioInvierno){
            return "Otoño";
        }
        if (promedioInvierno > promPrimavera && promedioInvierno > promedioVerano && promedioInvierno > promedioOtoño){
            return "Invierno";
        }
        return "nada";
    }
    public void imprimirDatosRegistro(){
        SalidaPorDefecto.terminal("Los datos de la empresa " + nombre + " son: \n");
        campesinos.imprimir();
    }
    public boolean agregarCampesino(Campesino objetoCampesino) {
        int retornoCampesino = (Integer) campesinos.buscar(objetoCampesino);
        if (retornoCampesino == -1) {
            int retornoPosicionC = campesinos.agregar(objetoCampesino);
            if (retornoPosicionC >= 0) {
                return true;
            } else {
                return false;
            }
        }else{
            return false;}
    }
}
