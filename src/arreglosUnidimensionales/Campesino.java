package arreglosUnidimensionales;

import estructurasLineales.Lista;
import estructurasLineales.ListaEstatica;
/**
 * @version 1.0
 * @author diego
 */
public class Campesino {
    /**
     * Guarda el numero de el campesino
     */
    protected double nuemeroCampesino;
    /**
     * guarda el nombre de el campesino
     */
    protected String nombre;
    /**
     * Es la lista de las toneladas
     */
    protected ListaEstatica toneladas;

    public Campesino(double nuemeroCampesino, String nombre, ListaEstatica toneladas) {
        this.nuemeroCampesino = nuemeroCampesino;
        this.nombre = nombre;
        this.toneladas = toneladas;
    }

    public Campesino(double nuemeroCampesino, String nombre) {
        this.nuemeroCampesino = nuemeroCampesino;
        this.nombre = nombre;
        this.toneladas = new ListaEstatica(12);
    }

    public double getNuemeroCampesino() {
        return nuemeroCampesino;
    }

    public void setNuemeroCampesino(double nuemeroCampesino) {
        this.nuemeroCampesino = nuemeroCampesino;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public ListaEstatica getToneladas() {
        return toneladas;
    }

    public void setToneladas(ListaEstatica toneladas) {
        this.toneladas = toneladas;
    }

    @Override
    public String toString() {
        return "Campesino{" +
                "nuemeroCampesino=" + nuemeroCampesino +
                ", nombre='" + nombre + '\'' +
                '}';
    }

    /**
     * Este metodo obtiene los promedios de los años de 1 campesino
     * @return Regresa un ListaEstatica con los 4 promedios de cada año
     */
    public ListaEstatica obtenerPromedioCampesino() {
        double promedio = 0.0;
        ListaEstatica promedios = new ListaEstatica(4);
        int meses = 12;
        int cadaMes = 0;
        int años = 1;
        for (int cadaAnio = 0; cadaAnio < 4; cadaAnio++) {
            while(cadaMes < meses) {
                promedio += (double) toneladas.obtener(cadaMes);
                cadaMes++;
            }
            promedio = promedio / toneladas.cantidad();
            promedios.agregar(promedio);
            años++;
            meses = meses + 12;
            promedio = 0.0;
        }
        return promedios;
    }

    /**
     * Este metodo calcula el mes con menos produccion de el campesino
     * @return Regresa una Lista Estatica con los valores de los 4 meses de cada año con menor produccion
     */
    public ListaEstatica mesConMenorProduccion() {
        ListaEstatica mesesConMenorProd = new ListaEstatica(4);
        int meses = 12;
        int cadaMes=0;
        double menor = (double) toneladas.obtener(0);
        for (int cadaAnio = 0; cadaAnio < 4; cadaAnio++) {
            while (cadaMes < meses) {
                if (menor > (double) toneladas.obtener(cadaMes)) {
                    menor = (double) toneladas.obtener(cadaMes);
                    cadaMes++;
                }else{
                    cadaMes++;}
            }
            mesesConMenorProd.agregar(toneladas.buscar(menor));
            meses = meses + 12;
        }
        return mesesConMenorProd;
    }

    /**
     * Este metodo calcula las toneladas de el ultimo mes de cada año
     * @return Regresa las toneladas de el ultimo mes de cada año
     */
    public ListaEstatica toneladasDeUltimoMes(){
        ListaEstatica toneladasDeUltimoMes = new ListaEstatica(4);
        for(int ultimoMes = 11; ultimoMes < 48; ultimoMes = ultimoMes+12){
            toneladasDeUltimoMes.agregar(toneladas.obtener(ultimoMes));
        }
        return toneladasDeUltimoMes;
    }

    /**
     * Este metodo calcula las toneladas de el 2do trimestre de cada año y las regresa
     * @return Regresa el total de las toneladas de los 2dos trimestes de cada año
     */
    public ListaEstatica toneladasDeLosSegundosTrimestres(){
        ListaEstatica toneladasTrimestres = new ListaEstatica(4);
        double sumatoria = 0.0;
        int ultimoMes = 3;
        int conteotrimestral = 6;
        for (int cadaAnio = 0; cadaAnio < 4; cadaAnio++) {
            while (ultimoMes < conteotrimestral) {
                sumatoria += (double)toneladas.obtener(ultimoMes);
                ultimoMes++;
            }
            toneladasTrimestres.agregar(sumatoria);
            conteotrimestral = conteotrimestral +12;
            ultimoMes = ultimoMes + 9;
        }
        return toneladasTrimestres;
    }

    /**
     * Este metodo calcula el promedio de los meses que pertenecen a la primavera
     * @return Regresa el promedio de las 4 Primaveras
     */
    public double promedioDePrimavera(){
        double promedioPrim = 0.0;
        int cadaMesP = 2;
        int mesesP = 5;
        for(int cadaAnio = 0; cadaAnio < 4; cadaAnio++) {
            while (cadaMesP < mesesP) {
                promedioPrim += (double)toneladas.obtener(cadaMesP);
                cadaMesP++;
            }
            cadaMesP = cadaMesP + 9;
            mesesP = mesesP + 12;
        }
        promedioPrim = promedioPrim / 12;
        return promedioPrim;
    }
    /**
     * Este metodo calcula el promedio de los meses que pertenecen a el verano
     * @return Regresa el promedio de los 4 Veranos
     */
    public double promedioDeVerano(){
        double promedioVerano = 0.0;
        int cadaMesP = 5;
        int mesesP = 8;
        for(int cadaAnio = 0; cadaAnio < 4; cadaAnio++) {
            while (cadaMesP < mesesP) {
                promedioVerano += (double)toneladas.obtener(cadaMesP);
                cadaMesP++;
            }
            cadaMesP = cadaMesP + 9;
            mesesP = mesesP + 12;
        }
        promedioVerano = promedioVerano / 12;
        return promedioVerano;
    }
    /**
     * Este metodo calcula el promedio de los meses que pertenecen a el otoño
     * @return Regresa el promedio de los 4 Otoños
     */
    public double promedioDeOtoño(){
        double promedioOtoño = 0.0;
        int cadaMesP = 8;
        int mesesP = 11;
        for(int cadaAnio = 0; cadaAnio < 4; cadaAnio++) {
            while (cadaMesP < mesesP) {
                promedioOtoño += (double)toneladas.obtener(cadaMesP);
                cadaMesP++;
            }
            cadaMesP = cadaMesP + 9;
            mesesP = mesesP + 12;
        }
        promedioOtoño = promedioOtoño / 12;
        return promedioOtoño;
    }
    /**
     * Este metodo calcula el promedio de los meses que pertenecen a el invierno
     * @return Regresa el promedio de los 4 Inviernos
     */
    public double promedioDeInvierno(){
        double promedioInv = 0.0;
        int cadaMesP = 11;
        int mesesP = 14;
        for(int cadaAnio = 0; cadaAnio < 3; cadaAnio++) {
            while (cadaMesP < mesesP) {
                promedioInv += (double)toneladas.obtener(cadaMesP);
                cadaMesP++;
            }
            cadaMesP = cadaMesP + 9;
            mesesP = mesesP + 12;
        }
        promedioInv += (double)toneladas.obtener(0);
        promedioInv += (double)toneladas.obtener(1);
        promedioInv += (double)toneladas.obtener(47);
        promedioInv = promedioInv / 12;
        return promedioInv;
    }

    /**
     *Este metodo calcula el mes de cada año en el que se genero mas toneladas/dividendos
     * @return Regresa los meses de los 4 años en los que se genero mas
     */
    public ListaEstatica mesQueGeneraMasDividendos(){
        ListaEstatica mesesConMayorProd = new ListaEstatica(4);
        int meses = 12;
        int cadaMes=0;
        double mayor = (double) toneladas.obtener(0);
        for (int cadaAnio = 0; cadaAnio < 4; cadaAnio++) {
            while (cadaMes < meses) {
                if (mayor < (double) toneladas.obtener(cadaMes)) {
                    mayor = (double) toneladas.obtener(cadaMes);
                    cadaMes++;
                }else{
                    cadaMes++;
                }
            }
            mesesConMayorProd.agregar(toneladas.buscar(mayor));
            meses = meses + 12;
        }
        return mesesConMayorProd;
    }

    /**
     * Este metodo convierte los numeros de las listas estaticas a el mes segun sea su valos
     * @param numMes Recibe el numero de el mes de la Lista
     * @return Regresa el mes ya convertido segun sea el caso
     */
    public String convertirNumeroaMes(int numMes){
        for(int indice = 0; indice<4 ; indice++) {
            if (numMes == 0 | numMes == 12 | numMes == 24 | numMes == 36) {
                return "Enero";
            }
            if (numMes == 1 | numMes == 13 | numMes == 25 | numMes == 37) {
                return "Febrero";
            }
            if (numMes == 2 | numMes == 14 | numMes == 26 | numMes == 38) {
                return "Marzo";
            }
            if (numMes == 3 | numMes == 15 | numMes == 27 | numMes == 39) {
                return "Abril";
            }
            if (numMes == 4 | numMes == 16 | numMes == 28 | numMes == 40) {
                return "Mayo";
            }
            if (numMes == 5 | numMes == 17 | numMes == 29 | numMes == 41) {
                return "Junio";
            }
            if (numMes == 6 | numMes == 18 | numMes == 30 | numMes == 42) {
                return "Julio";
            }
            if (numMes == 7 | numMes == 19 | numMes == 31 | numMes == 43) {
                return "Agosto";
            }
            if (numMes == 8 | numMes == 20 | numMes == 32 | numMes == 44) {
                return "Septiembre";
            }
            if (numMes == 9 | numMes == 21 | numMes == 33 |numMes == 45) {
                return "Octubre";
            }
            if (numMes == 10 | numMes == 22 | numMes == 34 | numMes == 46) {
                return "Noviembre";
            }
            if (numMes == 11 | numMes == 23 | numMes == 35 | numMes == 47) {
                return "Diciembre";
            }
        }
        return "ninguno";
    }

}

