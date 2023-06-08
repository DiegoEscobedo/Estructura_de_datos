package estructurasNoLineales;

import entradaSalida.SalidaPorDefecto;
import estructurasLineales.ListaEstatica;
import estructurasLineales.ListaEstaticaNumerica;
import utilerias.comunes.Comparador;
import utilerias.comunes.TipoLogaritmo;

/**
 * @author diego
 * @version 1.0
 */
public class Matriz2Numerica extends Matriz2 {
    public Matriz2Numerica(int rengolnes, int columnas) {
        super(rengolnes, columnas);
        rellenar(0);
    }

    public Matriz2Numerica(int rengolnes, int columnas, Object info) {
        super(rengolnes, columnas);
        rellenar(info);
    }

    /**
     * Valida si los valores son instancias de Number
     *
     * @param info es el objeto a validar
     * @return Regresa true si si es numero
     */
    public boolean validarNumero(Object info) {
        return info instanceof Number;
    }

    /**
     * Rellena la matriz
     *
     * @param info Es la informacion con la que se llena
     */
    public void rellenar(Object info) {
        //valida si indo es numero
        if (validarNumero(info)) {
            super.rellenar(info);
        }
    }

    /**
     * Cambia un elemento
     *
     * @param renglon Es el renglon donde lo va a cambiar
     * @param columna Es la columna donde lo va a cambiar
     * @param info    Es el elemento que va a insertar en su lugar
     * @return Regresa false si no lo pudo cambiar
     */
    @Override
    public boolean cambiar(int renglon, int columna, Object info) {
        if (validarNumero(info)) {
            super.cambiar(renglon, columna, info);
            return true;
        } else {
            return false;
        }
    }

    /**
     * Valida que este dentro del rango de la matriz
     *
     * @param indice    Es el indice
     * @param limiteSup Es el maximo de la matriz
     * @return
     */
    private boolean validarRango(int indice, int limiteSup) {
        return indice >= 0 && indice < limiteSup;
    }

    /**
     * Multiplica el escalar dado por cada posición de la matriz.
     *
     * @param escalar Es el valor a multiplicar
     * @return Regresa true.
     */
    public boolean porEscalar(Number escalar) {
        for (int cadaRenglon = 0; cadaRenglon < getRenglones(); cadaRenglon++) {
            for (int cadaColumna = 0; cadaColumna < getColumnas(); cadaColumna++) {
                if (obtener(cadaRenglon, cadaColumna) != null) {
                    cambiar(cadaRenglon, cadaColumna, ((int) obtener(cadaRenglon, cadaColumna)) * escalar.doubleValue());
                }
            }
        }
        return true;
    }

    /**
     * Multiplica un escalar para cada elemento de la matriz
     * @param escalares Es la lista de escalares a multiplicar
     * @return Regresa false si no lo hace
     */
    public boolean porEscalares(ListaEstaticaNumerica escalares) {
        if (getColumnas() >= escalares.maximo()) {
            for (int cadaRenglon = 0; cadaRenglon < getRenglones(); cadaRenglon++) {
                for (int cadaColumna = 0; cadaColumna < escalares.maximo(); cadaColumna++) {
                    if (obtener(cadaRenglon, cadaColumna) != null) {
                        cambiar(cadaRenglon, cadaColumna, ((int) obtener(cadaRenglon, cadaColumna)) * (int) escalares.obtener(cadaColumna));
                    }
                }
            }
            return true;
        }
        return false;
    }

    /**
     * Suma un escalar a la matriz
     * @param escalar Es el escalar a sumar
     * @return Regresa false si no lo hace
     */
    public boolean sumarEscalar(Number escalar) {
        for (int cadaRenglon = 0; cadaRenglon < getRenglones(); cadaRenglon++) {
            for (int cadaColumna = 0; cadaColumna < getColumnas(); cadaColumna++) {
                if (obtener(cadaRenglon, cadaColumna) != null) {
                    cambiar(cadaRenglon, cadaColumna, ((int) obtener(cadaRenglon, cadaColumna)) + escalar.doubleValue());
                }
            }
        }
        return true;
    }

    /**
     * Suma un escalar para cada elemento de la matriz
     * @param escalares Es la lista de escalares a sumar
     * @return Regresa false si no lo hace
     */
    public boolean sumarEscalares(ListaEstaticaNumerica escalares) {
        if (getColumnas() >= escalares.maximo()) {
            for (int cadaRenglon = 0; cadaRenglon < getRenglones(); cadaRenglon++) {
                for (int cadaColumna = 0; cadaColumna < escalares.maximo(); cadaColumna++) {
                    if (obtener(cadaRenglon, cadaColumna) != null) {
                        cambiar(cadaRenglon, cadaColumna, ((Number)obtener(cadaRenglon, cadaColumna)).doubleValue() + ((Number)escalares.obtener(cadaColumna)).doubleValue());
                    }
                }
            }
            return true;
        }
        return false;
    }

    /**
     * Redefine la matriz
     * @param matriz2 Es la 2da matriz
     * @return Regresa true si lo hace
     */
    public  boolean redefinir(Matriz2Numerica matriz2){

        columnas = matriz2.getColumnas();
        renglones = matriz2.getRenglones();
        informacion = new Object[renglones][columnas];
        for(int cadaRenglon = 0; cadaRenglon < getRenglones(); cadaRenglon++){
            for(int cadaColumna = 0; cadaColumna < getColumnas(); cadaColumna++){
                informacion[cadaRenglon][cadaColumna] = matriz2.obtener(cadaRenglon, cadaColumna);
            }
        }
        return true;
    }

    /**
     * Multiplica por otra matriz
     * @param matriz2 Es la matriz a multiplicar
     * @return Regresa true si lo hace
     */
    public boolean multiplicar(Matriz2Numerica matriz2) {
        double sumatoria = 0;
        Matriz2Numerica matriz21 = new Matriz2Numerica(getRenglones(), matriz2.getColumnas());
        if ((int) Comparador.comparar(getColumnas(), matriz2.getRenglones()) == 0) {
            for (int cadaRenglon = 0; cadaRenglon < getRenglones(); cadaRenglon++) {
                for (int cadaColumna2 = 0; cadaColumna2 < matriz2.getColumnas(); cadaColumna2++) {
                    for (int cadaColumna = 0; cadaColumna < getColumnas(); cadaColumna++) {
                        double valo1 = ((Number) obtener(cadaRenglon, cadaColumna)).doubleValue();
                        double valo2 = ((Number) matriz2.obtener(cadaColumna, cadaColumna2)).doubleValue();

                        sumatoria = sumatoria + valo1 * valo2;

                    }
                    matriz21.cambiar(cadaRenglon, cadaColumna2, sumatoria);
                    sumatoria = 0;

                }

            }
            redefinir(matriz21);

            return true;

        }
        return false;
    }

    /**
     * Sumar con otra matriz
     * @param matriz2 Es la matriz a sumar
     * @return Regresa flase si no son iguales
     */
    public boolean sumar(Matriz2Numerica matriz2) {
        if ((int) Comparador.comparar(getColumnas(), matriz2.getColumnas()) == 0 && (int) Comparador.comparar(getRenglones(), matriz2.getRenglones()) == 0) {
            for (int cadaRenglon = 0; cadaRenglon < matriz2.getRenglones(); cadaRenglon++) {
                for (int cadaColumna = 0; cadaColumna < matriz2.getColumnas(); cadaColumna++) {
                    if (obtener(cadaRenglon, cadaColumna) != null) {
                        cambiar(cadaRenglon, cadaColumna, (((Number) obtener(cadaRenglon, cadaColumna)).doubleValue() + ((Number) matriz2.obtener(cadaRenglon, cadaColumna)).doubleValue()));
                    }
                }
            }
            return true;
        }
        return false;
    }

    /**
     * Eleva a una potencia la matriz
     * @param escalar Es la potencia a elevar
     * @return Regresa true
     */
    public boolean aplicarPotencia(Number escalar) {
        for (int cadaRenglon = 0; cadaRenglon < getRenglones(); cadaRenglon++) {
            for (int cadaColumna = 0; cadaColumna < getColumnas(); cadaColumna++) {
                if (obtener(cadaRenglon, cadaColumna) != null) {
                    cambiar(cadaRenglon, cadaColumna, Math.pow((int) obtener(cadaRenglon, cadaColumna), escalar.doubleValue()));
                }
            }
        }
        return true;
    }

    /**
     * Valida si existe un valor 0
     * @return Regresa true si si
     */
    public boolean existeValorCero() {
        for (int cadaRenglon = 0; cadaRenglon < getRenglones(); cadaRenglon++) {
            for (int cadaColumna = 0; cadaColumna < getColumnas(); cadaColumna++) {
                if (((Number) obtener(cadaRenglon, cadaColumna)).doubleValue() == 0) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * Aplica el logaritmo (elemento por elemento) a la matriz
     * @param tipoLogaritmo Es el logaritmo a aplicar
     * @return Regresa true si lo hace
     */
    public boolean aplicarLogaritmo(TipoLogaritmo tipoLogaritmo) {
        if (!existeValorCero()) {
            for (int cadaRenglon = 0; cadaRenglon < getRenglones(); cadaRenglon++) {
                for (int cadaColumna = 0; cadaColumna < getColumnas(); cadaColumna++) {
                    double info = ((Number) obtener(cadaRenglon, cadaColumna)).doubleValue();
                    if (tipoLogaritmo == TipoLogaritmo.BASE10) {
                        cambiar(cadaRenglon, cadaColumna, Math.log10(info));
                    } else if (tipoLogaritmo == TipoLogaritmo.NATURAL) {
                        cambiar(cadaRenglon, cadaColumna, Math.log(info));
                    } else {
                        cambiar(cadaRenglon, cadaColumna, (Math.log(info) / Math.log(2)));
                    }
                }
            }
            return true;
        }
        return false;
    }

    /**
     * Genera una matriz diagonal con el valor proporcionado
     * @param contenido Es el contenido de la matriz
     * @return Regresa false si no lo hace
     */
    public boolean matrizDiagonal(Number contenido){
        if((int)Comparador.comparar(getRenglones(), getColumnas()) == 0){
            //rellenar(0);
            for(int cadaRenglon = 0; cadaRenglon < getRenglones(); cadaRenglon++){
                for(int cadaColumna = 0; cadaColumna < getColumnas(); cadaColumna++){
                    if(cadaColumna == cadaRenglon){
                        cambiar(cadaRenglon,cadaColumna, contenido);
                    }
                }
            }
            return true;
        }
        return false;
    }

    /**
     * Determinar si la matriz es una matriz triangular superior
     * @return Regresa true si lo es
     */
    public boolean esDiagonalSuperior() {
        if ((int) Comparador.comparar(getRenglones(), getColumnas()) == 0) {
            for (int cadaRenglon = 0; cadaRenglon < getRenglones(); cadaRenglon++) {
                for (int cadaColumna = 0; cadaColumna <= cadaRenglon; cadaColumna++) {
                    if (cadaRenglon == cadaColumna) {
                        if (((Number) obtener(cadaRenglon, cadaColumna)).doubleValue() == 0) {
                            return false;
                        }
                    } else if ((int) obtener(cadaRenglon, cadaColumna) != 0) {
                        return false;
                    }
                }
            }
            return true;
        }
        return false;
    }

    /**
     * Determinar si la matriz es una matriz triangular inferior
     * @return Regresa true si lo es
     */
    public boolean esDiagonalInferior() {
        if ((int) Comparador.comparar(getRenglones(), getColumnas()) == 0) {
            for (int cadaRenglon = 0; cadaRenglon < getRenglones(); cadaRenglon++) {
                for (int cadaColumna = cadaRenglon; cadaColumna < getColumnas(); cadaColumna++) {
                    if (cadaRenglon == cadaColumna) {
                        if (((Number) obtener(cadaRenglon, cadaColumna)).doubleValue() == 0) {
                            return false;
                        }
                    } else if ((int) obtener(cadaRenglon, cadaColumna) != 0) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    /**
     * Clona la matriz
     * @return Es la matrzi clonada
     */
    public Matriz2Numerica clonar() {
        Matriz2Numerica matrizClon = new Matriz2Numerica(getRenglones(), getColumnas());
        for (int cadaRenglon = 0; cadaRenglon < getRenglones(); cadaRenglon++) {
            for (int cadaColumna = 0; cadaColumna < getColumnas(); cadaColumna++) {
                matrizClon.cambiar(cadaRenglon, cadaColumna, informacion[cadaRenglon][cadaColumna]);
            }
        }
        return matrizClon;
    }

    /**
     * Determinar la potencia de una matriz
     * @param exponente Es a la potencia que se va a elevar
     * @return Regresa false si no lo hace
     */
    public boolean potencia(int exponente) {
        Matriz2Numerica matrizAuxiliar = clonar();
        if (getRenglones() == getColumnas()) {
            for (int cadaExponente = 1; cadaExponente < exponente; cadaExponente++) {
                multiplicar(matrizAuxiliar);
            }
            return true;
        }
        return false;
    }

    /**
     * Redimensiona (sumando) una matriz por columnas, a la mitad (si la matriz no
     * tiene un número par de columnas, la del centro debe pasar intacta, solo debe
     * acumular las demás)
     * @return regresa true
     */
    public boolean doblarColumnas() {
        int mitad = Math.ceilDiv(getColumnas(), 2);
        Matriz2Numerica matrizAuxiliar = new Matriz2Numerica(getRenglones(), mitad);
        int nuevaColumna = 0;
        if(mitad%2 == 0){
            for(int cadaRenglon = 0; cadaRenglon < getRenglones(); cadaRenglon++){
                for(int cadaColumna = 0; cadaColumna < getColumnas(); cadaColumna = cadaColumna+2){
                    matrizAuxiliar.cambiar(cadaRenglon, nuevaColumna, ((Number) obtener(cadaRenglon, cadaColumna)).doubleValue() + ((Number) obtener(cadaRenglon, cadaColumna+1)).doubleValue());
                    nuevaColumna++;
                }
                nuevaColumna = 0;
            }
        } else {
            for(int cadaRenglon = 0; cadaRenglon < getRenglones(); cadaRenglon++){
                for(int cadaColumna = 0; cadaColumna < mitad-1; cadaColumna = cadaColumna+2){
                    matrizAuxiliar.cambiar(cadaRenglon, nuevaColumna, ((Number) obtener(cadaRenglon, cadaColumna)).doubleValue() + ((Number) obtener(cadaRenglon, cadaColumna+1)).doubleValue());
                    nuevaColumna++;
                }
                nuevaColumna = 0;
            }
            // agrega la columna del medio
            for(int cadaRenglon = 0; cadaRenglon < getRenglones(); cadaRenglon++){
                for(int cadaColumna = mitad-1; cadaColumna < mitad; cadaColumna++){
                    matrizAuxiliar.cambiar(cadaRenglon, Math.ceilDiv(mitad-1, 2), ((Number) obtener(cadaRenglon, cadaColumna)).doubleValue());
                }
            }
            // agrega las sumas de las columnas despues del medio
            int otraColumna = Math.ceilDiv(mitad,2);
            for(int cadaRenglon = 0; cadaRenglon < getRenglones(); cadaRenglon++){
                for(int cadaColumna = mitad; cadaColumna < getColumnas(); cadaColumna = cadaColumna+2){
                    matrizAuxiliar.cambiar(cadaRenglon, otraColumna, ((Number) obtener(cadaRenglon, cadaColumna)).doubleValue() + ((Number) obtener(cadaRenglon, cadaColumna+1)).doubleValue());
                    otraColumna++;
                }
                otraColumna = Math.ceilDiv(mitad, 2);
            }
        }
        redefinir(matrizAuxiliar);
        return true;
    }

    /**
     * Redimensiona (sumando) una matriz por renglones, a la mitad (si la matriz no
     * tiene un número par de renglones, el del centro debe pasar intacto, solo debe
     * acumular los demás)
     * @return Regresa true
     */
    public boolean doblarRenglones() {
        int mitad = Math.ceilDiv(getRenglones(), 2);
        Matriz2Numerica matrizAuxiliar = new Matriz2Numerica(mitad, getColumnas());
        int nuevoRenglon = 0;
        if (mitad % 2 == 0) {
            for(int cadaColumna = 0; cadaColumna < getColumnas(); cadaColumna++){
                for(int cadaRenglon = 0; cadaRenglon < getRenglones(); cadaRenglon=cadaRenglon+2){
                    matrizAuxiliar.cambiar(nuevoRenglon, cadaColumna, ((Number) obtener(cadaRenglon, cadaColumna)).doubleValue() + ((Number) obtener(cadaRenglon+1, cadaColumna)).doubleValue());
                    nuevoRenglon++;
                }
                nuevoRenglon = 0;
            }
        } else {
            for(int cadaColumna = 0; cadaColumna < getColumnas(); cadaColumna++){
                for(int cadaRenglon = 0; cadaRenglon < mitad-1; cadaRenglon=cadaRenglon+2){
                    matrizAuxiliar.cambiar(nuevoRenglon, cadaColumna, ((Number) obtener(cadaRenglon, cadaColumna)).doubleValue() + ((Number) obtener(cadaRenglon+1, cadaColumna)).doubleValue());
                    nuevoRenglon++;
                }
                nuevoRenglon = 0;
            }
            for(int cadaColumna = 0; cadaColumna < getColumnas(); cadaColumna++){
                for(int cadaRenglon = mitad-1; cadaRenglon < mitad; cadaRenglon++){
                    matrizAuxiliar.cambiar(Math.ceilDiv(mitad-1, 2), cadaColumna, ((Number) obtener(cadaRenglon, cadaColumna)).doubleValue());
                }
            }
            int otroRenglon = Math.ceilDiv(mitad,2);
            for(int cadaColumna = 0; cadaColumna < getColumnas(); cadaColumna++){
                for(int cadaRenglon = mitad; cadaRenglon < getRenglones(); cadaRenglon=cadaRenglon+2){
                    matrizAuxiliar.cambiar(otroRenglon, cadaColumna, ((Number) obtener(cadaRenglon, cadaColumna)).doubleValue() + ((Number) obtener(cadaRenglon+1, cadaColumna)).doubleValue());
                    otroRenglon++;
                }
                otroRenglon = Math.ceilDiv(mitad, 2);
            }
        }
        redefinir(matrizAuxiliar);
        return false;
    }
}
