package estructurasNoLineales;

import entradaSalida.SalidaPorDefecto;
import estructurasLineales.ListaEstatica;


public class Matriz3 {
    protected int renglones;
    protected int columnas;
    protected int profundidad;
    protected Object informacion[][][];

    public Matriz3(int rengolnes, int columnas, int profundidad) {
        this.renglones = rengolnes;
        this.columnas = columnas;
        this.profundidad = profundidad;
        informacion = new Object[rengolnes][columnas][profundidad];
    }

    public Matriz3(int rengolnes, int columnas, int profundidad, Object info) {
        this.renglones = rengolnes;
        this.columnas = columnas;
        this.profundidad = profundidad;
        informacion = new Object[rengolnes][columnas][profundidad];
        rellenar(info);
    }

    public void rellenar(Object info) {
        //recorrer todos los renglones
        for (int cadaRenglon = 0; cadaRenglon < renglones; cadaRenglon++) {
            //recorre todas las columnas
            for (int cadaColumna = 0; cadaColumna < columnas; cadaColumna++) {
                //recorre la profundidad
                for (int cadaProfundida = 0; cadaProfundida < profundidad; cadaProfundida++) {
                    //siempre van en ese orden :: renglon, columna, profundidad ::
                    informacion[cadaRenglon][cadaColumna][cadaProfundida] = info;
                }
            }
        }
    }

    public int getRenglones() {
        return renglones;
    }

    public void setRenglones(int renglones) {
        this.renglones = renglones;
    }

    public int getColumnas() {
        return columnas;
    }

    public void setColumnas(int columnas) {
        this.columnas = columnas;
    }

    public int getProfundidad() {
        return profundidad;
    }

    public void setProfundidad(int profundidad) {
        this.profundidad = profundidad;
    }

    public boolean cambiar(int renglon, int columna, int prof, Object info) {
        if (validarRango(renglon, renglones) && validarRango(columna, columnas) && validarRango(prof, profundidad)) {
            informacion[renglon][columna][prof] = info;
            return true;
        }
        return false;
    }

    public Object obtener(int renglon, int columna, int prof) {
        if (validarRango(renglon, renglones) && validarRango(columna, columnas) && validarRango(prof, profundidad)) {
            return informacion[renglon][columna][prof];
        }
        return null;
    }

    private boolean validarRango(int indice, int limiteSup) {
        return indice >= 0 && indice < limiteSup;
    }

    public void imprimirPorColumna() {
        //se tratara como rebanadas, donde cada rebanada es una columna
        for (int cadaRebanada = 0; cadaRebanada < columnas; cadaRebanada++) {
            //aqui comienza cada rebanada
            for (int cadaRenglon = 0; cadaRenglon < renglones; cadaRenglon++) {
                for (int cadaColumna = 0; cadaColumna < profundidad; cadaColumna++) {
                    SalidaPorDefecto.terminal(informacion[cadaRenglon][cadaRebanada][cadaColumna] + " ");
                }
                //despues de cada columna se hace el salto de linea
                SalidaPorDefecto.terminal("\n");
            }
            //despues de todos los renglones de cada rebanada se hace otro salto de linea
            SalidaPorDefecto.terminal("\n");
        }
    }
    public void imprimirPorRenglon() {
        //se tratara como rebanadas, donde cada rebanada es una columna
        for (int cadaRebanada = 0; cadaRebanada < profundidad; cadaRebanada++) {
            //aqui comienza cada rebanada
            for (int cadaRenglon = 0; cadaRenglon < renglones; cadaRenglon++) {

                for (int cadaColumna = 0; cadaColumna < columnas; cadaColumna++) {
                    SalidaPorDefecto.terminal(informacion[cadaRenglon][cadaColumna][cadaRebanada] + " ");
                }
                //despues de cada columna se hace el salto de linea
                SalidaPorDefecto.terminal("\n");
            }
            //despues de todos los renglones de cada rebanada se hace otro salto de linea
            SalidaPorDefecto.terminal("\n");
        }
    }
    public ListaEstatica aMatrices2() {
        ListaEstatica matrices2 = new ListaEstatica(columnas);
        //Obtener cada rebanada (que es una matriz 2D)
        for (int cadaRebanada = 0; cadaRebanada < columnas; cadaRebanada++) {// es la clumna
            Matriz2 matriz2Temporal = new Matriz2(renglones, profundidad);
            for (int renglon = 0; renglon < renglones; renglon++) {
                for (int profCol = 0; profCol < profundidad; profCol++) {
                    //llenar la matriz2
                    matriz2Temporal.cambiar(renglon, profCol, informacion[renglon][cadaRebanada][profCol]);
                }
            }
            //Despues de procesar la matriz2 interna
            matrices2.agregar(matriz2Temporal);
        }
        return matrices2;
    }


}