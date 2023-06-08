package estructurasLineales;

import entradaSalida.SalidaPorDefecto;
import utilerias.comunes.Comparador;

import java.util.List;
/**
 * @version1.0
 * @autor:Clase ED
 */
public class ListaEstatica implements VectorLista {
    protected int tope;
    protected int MAXIMO;
    protected Object informacion[];

    public ListaEstatica(int tamanio) {
        MAXIMO = tamanio;
        informacion = new Object[tamanio];
        tope = -1;
    }
    public int getMAXIMO(){
        return MAXIMO;
    }

    public int getTope() {
        return tope;
    }

    @Override
    public boolean vacio() {
        if (tope == -1) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean llena() {
        if (tope == (MAXIMO - 1)) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public int maximo() {
        return MAXIMO;
    }

    @Override
    public int cantidad() {
        return tope+1;
    }

    @Override
    public Object obtener(int indice) {
        if(validarRango(indice)){
            return informacion[indice];
        }else{
            return null;
        }
    }

    @Override
    public boolean cambiar(int indice, Object info) {
        if(indice <= tope){
            informacion[indice] = info;
            return true;
        }
        return false;
    }

    @Override
    public boolean cambiarListaEstatica(ListaEstatica indicesNuevos, ListaEstatica infosNuevos) {
        int indicein = 0;
        int infonuev = 0;
        for(int i = 0; i <= indicesNuevos.cantidad(); i++){
            informacion[i] = new Object[]{indicesNuevos.obtener(indicein), infosNuevos.obtener(infonuev)};
            indicein++;
            infonuev++;
        }
        return true;
    }

    @Override
    public Object eliminar(int i) {
        if(i>=0 && i <= tope) { // si esta
            Object eliminado = informacion[i];
            tope--;
            for (int movs = i; movs <= tope; movs++) {
                informacion[movs] = informacion[movs + 1];
            }
            return eliminado;
        }
        return null;
    }

    @Override
    public int agregar(Object info) {
        if (llena() == false) {
            tope = tope + 1;
            informacion[tope] = info;
            return tope;
        }
        return -1;
    }

    @Override
    public void imprimir() {
        for (int celda = tope; celda >= 0; celda--) {
            SalidaPorDefecto.terminal(informacion[celda] + "\n");
        }
    }

    @Override
    public void imprimirinv() {
        for (int celda = 0; celda <= tope; celda++) {
            SalidaPorDefecto.terminal(informacion[celda] + "\n");
        }
    }

    @Override
    public Object buscar(Object info) {
        int posicion = 0;
        while (posicion <= tope && !info.toString().equalsIgnoreCase(informacion[posicion].toString())) {
            posicion++;
        }
        if (posicion > tope) {
            return -1;
        } else {
            return posicion;
        }
    }

    @Override
    public Object eliminar(Object info) {
        int posicion = (Integer) buscar(info);
        if (posicion >= 0) { // si esta
            Object eliminado = informacion[posicion];
            tope--;
            for (int movs = posicion; movs <= tope; movs++) {
                informacion[movs] = informacion[movs + 1];
            }
            return eliminado;
        } else { // no esta
            return null;
        }
    }

    @Override
    public boolean esIgual(Object lista2) {

        if (lista2 instanceof ListaEstatica) {
            ListaEstatica lista2estatica = (ListaEstatica) lista2;
            if (this.maximo() == lista2estatica.maximo()) {
                for (int i = 0; i <= maximo()-1; i++) {
                    if (this.obtener(i).toString().equalsIgnoreCase(lista2estatica.obtener(i).toString())) {
                        return true;
                    } else {
                        return false;
                    }
                }
            }
        }
        return false;
    }

    @Override
    public boolean cambiar(Object infoViejo, Object infoNuevo, int numVeces) {
        if(numVeces<=tope){
            for(int i = 0; i < numVeces; i++){
                int posicion = (int) buscar(infoViejo);
                informacion[posicion] = infoNuevo;
                return true;
            }

        }
        return false;
    }

    @Override
    public ListaEstatica buscarValores(Object info) {
        int numinf = 0;
        for(int i = 0; i <=tope; i++){
            if(informacion[i].toString().equalsIgnoreCase(info.toString())){
                numinf++;
            }
        }
        ListaEstatica nuevaLista = new ListaEstatica(numinf);
        for(int i = 0; i <=tope; i++){
            if(informacion[i].toString().equalsIgnoreCase(info.toString())){
                nuevaLista.agregar(i);
            }
        }
        return nuevaLista;

    }

    @Override
    public Object eliminar() {
        if(!vacio()) {
            Object eliminado = informacion[tope];
            tope--;
            return eliminado;
        }
        return -1;
    }

    @Override
    public void vaciar() {
        if(!this.vacio()) {
            for(int indice = 0; indice <= tope; indice++) {
                informacion[indice] = null;
            }
        }
    }

    @Override
    public boolean agregarLista(Object lista2) {
        if (lista2 instanceof ListaEstatica) {
            ListaEstatica lista2estatica = (ListaEstatica) lista2;
                for (int i = 0; i <= maximo() - 1; i++) {
                    informacion[tope+1]=lista2estatica.obtener(i);
                    if(tope == maximo()){
                        MAXIMO = MAXIMO+1;
                    }
                }

        }
        return false;
    }

    @Override
    public void invertir() {
        ListaEstatica listaInvertida = new ListaEstatica(getMAXIMO());
        for(int indice=0;indice<=getTope()-1;indice++){
            listaInvertida.informacion[getTope()-1-indice]=informacion[indice];
        }
        for (int indice =0;indice<=tope-1;indice++){
            informacion[indice]=listaInvertida.informacion[indice];
        }
    }

    @Override
    public int contar(Object info) {
        int contador = 0;
           for (int i = 0; i <= cantidad(); i++) {
                    if (info.toString().equalsIgnoreCase(this.obtener(i).toString())){
                    contador++;
               }
           }
           return contador;
    }

    @Override
    public boolean eliminarLista(Object lista2) {
        if (lista2 instanceof ListaEstatica lista2estatica) {
            for (int contador = 0; contador <= lista2estatica.getTope(); contador++) {
                for (int cadaIndice = 0; cadaIndice <= getTope(); cadaIndice++) {
                    if ((int) Comparador.comparar(lista2estatica.obtener(contador), obtener(cadaIndice)) == 0) {
                        eliminar(cadaIndice);
                    }
                }
            }
        }
        return true;
    }

    @Override
    public void rellenar(Object info, int cantidad) {
        if(cantidad <= MAXIMO) {
            vaciar();
            for (int indice = tope; indice <= cantidad; indice++) {
                agregar(info);
            }
        }
    }

    @Override
    public Lista clonar() {
        ListaEstatica nuevaLista = new ListaEstatica(MAXIMO);
        for(int indice = 0; indice <= getTope(); indice++){
            nuevaLista.agregar(informacion[indice]);
        }
        return nuevaLista;
    }

    @Override
    public Lista subLista(int indiceInicial, int indiceFinal) {
        Lista lista = new ListaEstatica(tope);
        int i = 0;
        if((indiceInicial<tope-1&&indiceInicial>=0)&&(indiceFinal<=tope&&indiceFinal>=1)&&(indiceInicial<indiceFinal)) {
            while(indiceInicial<=indiceFinal){
                lista.agregar(this.obtener(indiceInicial));
                indiceInicial++;
            }

        }
        return lista;
    }

    /**
     * Indica si la lista2 (que es otro arreglo ordenado) es una sublista o subconjunto
     * de la lista actual.
     * @param lista2 Es la lista a comparar
     * @return Regresa true si si es sub lista
     */
    public boolean esSubLista(Lista lista2) {
        if(lista2 instanceof ListaEstaticaOrdenada){
            Object objetoInicial = ((ListaEstaticaOrdenada) lista2).obtener(0);
            int posicion = (int)buscar(objetoInicial)-1;
            for(int indice = 0; indice < ((ListaEstaticaOrdenada) lista2).tope;indice++){
                if((int) Comparador.comparar(obtener(posicion), ((ListaEstaticaOrdenada) lista2).obtener(indice)) != 0){
                    return false;
                }
                posicion++;
            }
            return true;
        }
        return false;
    }

    @Override
    public boolean redimensionar(int maximo) {
        ListaEstatica auxiliar = (ListaEstatica) clonar();
        MAXIMO = maximo;
        informacion = new Object[getMAXIMO()];
        for(int cadaIndice = 0; cadaIndice <= getTope(); cadaIndice++){
            informacion[cadaIndice] = auxiliar.obtener(cadaIndice);
        }
        return true;
    }
    private boolean validarRango(int indice){
        if(indice>=0&&indice<=tope){
            return true;
        }else {
            return false;
        }
    }

    @Override
    public ListaEstatica subLista(ListaEstaticaNumerica listaIndices) {
        ListaEstatica listaNueva = new ListaEstatica(listaIndices.tope+1);
        if(vacio() == false){
            for(int indiceLista = 0; indiceLista <= listaIndices.tope; indiceLista++){
                if(obtener((int) listaIndices.obtener(indiceLista)) != null){
                    Object objeto = (obtener((int)listaIndices.obtener(indiceLista)));
                    listaNueva.agregar(objeto);
                }
            }
            return listaNueva;
        }
        return listaNueva;
    }
    @Override
    public Object verTope(){
        if(!vacio()){
            return informacion[tope];
        }else{
            return null;
        }
    }
    @Override
    public void recibeBuffer(Object buffer[]){
        for (int buferIndice=0;buferIndice<=tope;buferIndice++) {
            agregar(buffer[buferIndice]);
        }
    }

    /**
     * @return
     */
    @Override
    public Object eliminarPrimero() {
        return null;
    }
}
