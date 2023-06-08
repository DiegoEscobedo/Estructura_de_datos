package estructurasNoLineales;

import entradaSalida.SalidaPorDefecto;
import estructurasLineales.ListaEstatica;
import utilerias.comunes.Comparador;
import utilerias.comunes.TipoColumna;
import utilerias.comunes.TipoRenglon;

/**
 * @author diego
 * @version1.0
 */
public class  Matriz2 {
    /**
     * renglones de la matriz
     */
    protected int renglones;
    /**
     * columnas de la matriz
     *
     */
    protected int columnas;
    /**
     * arreglo matriz
     */
    protected Object informacion[][];

    /**
     * Constructor que recibe los renglones y las columnas
     * @param rengolnes Son los renglones
     * @param columnas Son las columnas
     */
    public Matriz2(int rengolnes, int columnas) {
        this.renglones = rengolnes;
        this.columnas = columnas;
        informacion = new Object[rengolnes][columnas];
    }

    /**
     * Contructor que recibe los renglones y las columnas y rellena la matriz
     * @param rengolnes Son los renglones
     * @param columnas Son las columnas
     * @param info Es la informacion con la que se llena
     */
    public Matriz2(int rengolnes, int columnas, Object info) {
        this.renglones = rengolnes;
        this.columnas = columnas;
        informacion = new Object[rengolnes][columnas];
        rellenar(info);
    }

    /**
     * Rellena la matriz
     * @param info Es la informacion con la que se llena
     */
    public void rellenar(Object info) {
        //recorrer todos los renglones
        for (int cadaRenglon = 0; cadaRenglon < renglones; cadaRenglon++) {
            //recorre todas las columnas
            for (int cadaColumna = 0; cadaColumna < columnas; cadaColumna++) {
                    informacion[cadaRenglon][cadaColumna] = info;
            }
        }
    }

    /**
     * Regresa los renglones
     * @return Regresa los renglones
     */
    public int getRenglones() {
        return renglones;
    }

    /**
     * Setea los renglones
     * @param renglones Son los renglones
     */
    public void setRenglones(int renglones) {
        this.renglones = renglones;
    }
    /**
     * Regresa las columnas
     */
    public int getColumnas() {
        return columnas;
    }

    /**
     * Cambia las columnas
     * @param columnas Son las columnas
     */
    public void setColumnas(int columnas) {
        this.columnas = columnas;
    }

    /**
     * Cambia un elemento
     * @param renglon Es el renglon donde lo va a cambiar
     * @param columna Es la columna donde lo va a cambiar
     * @param info Es el elemento que va a insertar en su lugar
     * @return Regresa false si no lo pudo cambiar
     */
    public boolean cambiar(int renglon, int columna, Object info) {
        if (validarRango(renglon, renglones) && validarRango(columna, columnas)) {
            informacion[renglon][columna]= info;
            return true;
        }
        return false;
    }

    /**
     * Lee un elemento de la matriz
     * @param renglon Es el renglon donde lo va a obtener
     * @param columna Es la columna donde lo va a obtener
     * @return Regresa null si no esta
     */
    public Object obtener(int renglon, int columna) {
        if (validarRango(renglon, renglones) && validarRango(columna, columnas)) {
            return informacion[renglon][columna];
        }
        return null;
    }

    /**
     * Valida que este dentro del rango de la matriz
     * @param indice Es el indice
     * @param limiteSup Es el maximo de la matriz
     * @return
     */
    private boolean validarRango(int indice, int limiteSup) {
        return indice >= 0 && indice < limiteSup;
    }

    /**
     *  Imprime la matriz en formato columna por columna.
     */
    public void imprimirPorColumna() {
        //se tratara como rebanadas, donde cada rebanada es una columna
        for (int cadaColumna = 0; cadaColumna < columnas; cadaColumna++) {
            //aqui comienza cada rebanada
            for (int cadaRenglon = 0; cadaRenglon < renglones; cadaRenglon++) {
                    SalidaPorDefecto.terminal(informacion[cadaRenglon][cadaColumna]+ " ");
            }
            //después de todos los renglones de cada rebanada se hace otro salto de linea
            SalidaPorDefecto.terminal("\n");
        }
    }

    /**
     * Imprime la matriz en formato renglón por renglón.
     */
    public void imprimirPorRenglon(){
        for (int cadaRenglon = 0; cadaRenglon < renglones; cadaRenglon++) {
            //aqui comienza cada rebanada
            for (int cadaColumna = 0; cadaColumna < columnas; cadaColumna++) {
                SalidaPorDefecto.terminal(informacion[cadaRenglon][cadaColumna]+ " ");
            }
            //después de todos los renglones de cada rebanada se hace otro salto de linea
            SalidaPorDefecto.terminal("\n");
        }
    }

    /**
     * Hace la transpuesta de la matriz
     */
    public void transpuesta(){
        Matriz2 matrizAuxiliar = new Matriz2(getColumnas(),getRenglones());
        for(int cadaRenglon = 0; cadaRenglon < getColumnas(); cadaRenglon++){
            for(int cadaColumna = 0; cadaColumna < getRenglones(); cadaColumna++){
                matrizAuxiliar.cambiar(cadaRenglon, cadaColumna, informacion[cadaColumna][cadaRenglon]);
            }
        }
        redefinir(matrizAuxiliar);
        /*for(int cadaRenglon = 0; cadaRenglon < getRenglones(); cadaRenglon++) {
            for (int cadaColumna = 0; cadaColumna < getColumnas(); cadaColumna++) {
                cambiar(cadaRenglon, cadaColumna, matrizAuxiliar.informacion[cadaRenglon][cadaColumna]);
            }
        }*/
    }

    /**
     * Genera y regresar una “copia” de la matriz
     * @return Regresa la copia de la matriz
     */
    public Matriz2 clonar(){
        Matriz2 matrizClonada = new Matriz2(getRenglones(), getColumnas());
        for(int cadaRenglon = 0; cadaRenglon < getRenglones(); cadaRenglon++){
            for(int cadaColumna = 0; cadaColumna < getColumnas(); cadaColumna++){
                matrizClonada.cambiar(cadaRenglon, cadaColumna, informacion[cadaRenglon][cadaColumna]);
            }
        }
        return matrizClonada;
    }

    /**
     * Dice si el contenido de dos matrices es igual
     * @param matriz2 Es la 2da matriz
     * @return Regresa true si son iguales
     */
    public boolean esIgual(Matriz2 matriz2){
        for(int cadaRenglon = 0; cadaRenglon < getRenglones(); cadaRenglon++){
            for(int cadaColumna = 0; cadaColumna < getColumnas(); cadaColumna++){
                if((int)Comparador.comparar(obtener(cadaRenglon,cadaColumna), matriz2.obtener(cadaRenglon,cadaColumna)) != 0){
                    return false;
                }
            }
        }
        return true;
    }

    /**
     * Genera un vector columna con los datos especificados por
     * el usuario, a partir de la matriz vacía
     * @param filas Son las filas especificadas
     * @param info es la informacion del vector
     * @return Regresa flse si no lo hizo
     */
    public boolean vectorColumna(int filas, Object info){
        if ((int) Comparador.comparar(getColumnas(),filas)>=0){
            for (int cadaRenglon=0;cadaRenglon<getRenglones();cadaRenglon++){
                cambiar(filas,cadaRenglon,info);
            }
            return true;
        }
        return false;
    }

    /**
     * Genera un vector renglón con los datos especificados por
     * el usuario, a partir de la matriz vacía
     * @param columnas Son las columnas especificadas
     * @param info es la informacion del vector
     * @return Regresa flse si no lo hizo
     */
    public boolean vectorRenglon(int columnas,Object info){
        if ((int) Comparador.comparar(getColumnas(),columnas)>=0){
            for (int cadaColumna=0;cadaColumna<getColumnas();cadaColumna++){
                cambiar(cadaColumna, columnas, info);
            }
            return true;
        }
        return false;
    }

    /**
     * Permite crear/substituir la tabla actual por
     * una pasada como argumento
     * @param matriz2 Es la matriz por la que se va a reemplazar
     */
    public  boolean redefinir(Matriz2 matriz2){

        columnas = matriz2.getColumnas();
        renglones = matriz2.getRenglones();
        informacion = new Object[renglones][columnas];
        for(int cadaRenglon = 0; cadaRenglon < getRenglones(); cadaRenglon++){
            for(int cadaColumna = 0; cadaColumna < getColumnas(); cadaColumna++){
                informacion[cadaRenglon][ cadaColumna]= matriz2.obtener(cadaRenglon, cadaColumna);
            }
        }
        return true;
    }

    /**
     * Permite agregar una ListaEstatica pasada como argumento
     * como renglón de la matriz existente
     * @param arreglo es el renglon a agregar
     * @return Regresa false si no lo hizo
     */
    public boolean agregarRenglon(ListaEstatica arreglo){
        if((int)Comparador.comparar(getRenglones(), arreglo.maximo()) >= 0){
            for(int cadaRenglon = 0; cadaRenglon <= arreglo.getTope(); cadaRenglon++){
                cambiar(cadaRenglon, 0, arreglo.obtener(cadaRenglon));
            }
            return true;
        }
        return false;
    }

    /**
     * permita agregar una ListaEstatica pasada como argumento
     * como columna de la matriz existente
     * @param arreglo es la columna a agregar
     * @return Regresa false si no lo hizo
     */
    public boolean agregarColumna(ListaEstatica arreglo){
        if((int)Comparador.comparar(getColumnas(), arreglo.maximo()) >= 0){
            for(int cadaColumna = 0; cadaColumna <= arreglo.getTope(); cadaColumna++){
                cambiar(0, cadaColumna, arreglo.obtener(cadaColumna));
            }
            return true;
        }
        return false;
    }

    /**
     * Permite agregar una matriz nueva a la matriz actual. Para
     * esto deberá validar que sea como elementos agregados en columnas
     * @param matriz2 Es la matriz a agregar
     * @return Regresa true siempre
     */
    public boolean agregarMatrizXColumna(Matriz2 matriz2){
        for(int cadaRenglon = 0; cadaRenglon < getRenglones(); cadaRenglon++){
            for(int cadaColumna = 0; cadaColumna < getColumnas(); cadaColumna++){
                cambiar(cadaColumna, cadaRenglon, matriz2.obtener(cadaRenglon, cadaColumna));
            }
        }
        return true;
    }

    /**
     * Permite agregar una matriz nueva a la matriz actual. Para
     * esto deberá validar que sea como elementos agregados en filas
     * @param matriz2 Es la matriz a agregar
     * @return Regresa true siempre
     */
    public boolean agregarMatrizXRenglon(Matriz2 matriz2){
        for(int cadaRenglon = 0; cadaRenglon < getRenglones(); cadaRenglon++){
            for(int cadaColumna = 0; cadaColumna < getColumnas(); cadaColumna++){
                cambiar(cadaRenglon, cadaColumna, matriz2.obtener(cadaColumna, cadaRenglon));
            }
        }
        return true;
    }

    /**
     * Permite pasar una serie de matrices 2D a matriz 3D
     * @param matrices es la lista de matrices
     * @return Regresa la matriz ya transformada
     */
    public Matriz3 aMatriz3(ListaEstatica matrices){
        Matriz3 matriz3 = new Matriz3(getRenglones(),getColumnas(),matrices.maximo());
        Matriz2 matriz2D;
        Object objeto;
        for(int cadaMatriz = 0; cadaMatriz < matrices.maximo(); cadaMatriz++){
            matriz2D = (Matriz2) matrices.obtener(cadaMatriz);
            if((int)Comparador.comparar(getRenglones(), ((Matriz2) matrices.obtener(cadaMatriz)).getRenglones()) >= 0
                    && (int)Comparador.comparar(getColumnas(), ((Matriz2) matrices.obtener(cadaMatriz)).getColumnas()) >= 0){
                for(int cadaRenglon = 0; cadaRenglon < getRenglones(); cadaRenglon++){
                    for(int cadaColumna = 0; cadaColumna < getColumnas(); cadaColumna++){
                        objeto = matriz2D.obtener(cadaRenglon,cadaColumna);
                        matriz3.cambiar(cadaRenglon,cadaColumna,cadaMatriz, objeto);
                    }
                }
            }
        }
        return matriz3;
    }

    /**
     * Este método convierte la matriz actual acomodando cada columna una debajo de otra para
     * formar un vector columna.
     * @return Regresa el Vector
     */
    public ListaEstatica aVectorRenglón(){
        ListaEstatica nuevaLista = new ListaEstatica(getRenglones()*getColumnas());
        for(int nuevoReng = 0; nuevoReng < getRenglones(); nuevoReng++){
            for(int nuevoCol = 0; nuevoCol < getColumnas(); nuevoCol++){
                nuevaLista.agregar(obtener(nuevoReng,nuevoCol));
            }
        }
        return nuevaLista;
    }

    /**
     * Este método convierte la matriz actual acomodando cada renglón uno enseguida del otro
     * @return Regresa el Vector
     */
    public ListaEstatica aVectorColumna(){
        ListaEstatica nuevaLista = new ListaEstatica(getRenglones()*getColumnas());
        for(int nuevoReng = 0; nuevoReng < getRenglones(); nuevoReng++){
            for(int nuevoCol = 0; nuevoCol < getColumnas(); nuevoCol++){
                nuevaLista.agregar(obtener(nuevoCol,nuevoReng));
            }
        }
        return nuevaLista;
    }
    /**
     * Elimina una columna de una tabla
     * @param tipoColumna Indica si la columna izquierda o derecha
     * @return Regresa true si si lo hizo
     */
    public boolean quitarColumna(TipoColumna tipoColumna){
        ListaEstatica nuevaLista = new ListaEstatica(getRenglones());
        if(tipoColumna== TipoColumna.DER){
            for(int cadaCol = getColumnas()-1; cadaCol >= 0; cadaCol--){
                for(int cadaReng = 0; cadaReng < getRenglones(); cadaReng++){
                    nuevaLista.agregar(obtener(cadaCol, cadaReng));
                }
                for(int indiceLista = 0; indiceLista < nuevaLista.maximo(); indiceLista++){
                    if(nuevaLista.obtener(indiceLista) != null){
                        return eliminarRenglon(cadaCol+1);
                    }
                }
                nuevaLista.vaciar();
            }
        } else if (tipoColumna==TipoColumna.IZQ) {
            for(int cadaCol = 0; cadaCol < getColumnas(); cadaCol++){
                for(int cadaReng = 0; cadaReng < getRenglones(); cadaReng++){
                    nuevaLista.agregar(obtener(cadaCol, cadaReng));
                }
                for(int indiceLista = 0; indiceLista < nuevaLista.maximo(); indiceLista++){
                    if(nuevaLista.obtener(indiceLista) != null){
                        return eliminarRenglon(cadaCol+1);
                    }
                }
                nuevaLista.vaciar();
            }

        }
        return false;
    }

    /**
     * Elimina una renglon de una tabla
     * @param tipoRenglon Indica si el renglon superior o inferior
     * @return Regresa true si si lo hizo
     */
    public boolean quitarRenglon(TipoRenglon tipoRenglon){
        ListaEstatica nuevaLista = new ListaEstatica(getRenglones());
        if(tipoRenglon== TipoRenglon.INF){
            for(int cadaCol = getColumnas()-1; cadaCol >= 0; cadaCol--){
                for(int cadaReng = 0; cadaReng < getRenglones(); cadaReng++){
                    nuevaLista.agregar(obtener(cadaReng, cadaCol));
                }
                for(int indiceLista = 0; indiceLista < nuevaLista.maximo(); indiceLista++){
                    if(nuevaLista.obtener(indiceLista) != null){
                        return eliminarColumna(cadaCol+1);
                    }
                }
                nuevaLista.vaciar();
            }
        } else if (tipoRenglon==TipoRenglon.SUP) {
            for(int cadaCol = 0; cadaCol < getColumnas(); cadaCol++){
                for(int cadaReng = 0; cadaReng < getRenglones(); cadaReng++){
                    nuevaLista.agregar(obtener(cadaReng, cadaCol));
                }
                for(int indiceLista = 0; indiceLista < nuevaLista.maximo(); indiceLista++){
                    if(nuevaLista.obtener(indiceLista) != null){
                        return eliminarColumna(cadaCol+1);
                    }
                }
                nuevaLista.vaciar();
            }
        }
        return false;
    }

    /**
     * Elimina una fila de una posición de una matriz
     * @param renglon Indica la fila a eliminar
     * @return Regresa true si si la elimino
     */
    public boolean eliminarRenglon(int renglon){
        if(validarRango(renglon-1,getRenglones())){
            for(int cadaColumna = 0; cadaColumna < getColumnas(); cadaColumna++){
                cambiar(cadaColumna, renglon-1, null);
            }
            return true;
        }
        return false;
    }

    /**
     * Elimina una columna de una posición de una matriz
     * @param columna Indica la columna a eliminar
     * @return Regresa true si si la elimino
     */
    public boolean eliminarColumna(int columna){
        if(validarRango(columna-1,getRenglones())){
            for(int cadaRenglon = 0; cadaRenglon < getColumnas(); cadaRenglon++){
                cambiar(columna-1,cadaRenglon,  null);
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
}
