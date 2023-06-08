package estructurasNoLineales;

import entradaSalida.SalidaPorDefecto;
import estructurasLineales.ColaDinamica;
import estructurasLineales.ListaEstatica;
import estructurasLineales.PilaDinamica;
import estructurasLineales.auxiliares.NodoDoble;
import utilerias.comunes.Comparador;

/**
 * @author diego
 * @version1.0
 */
public class ArbolBinario {
    protected NodoDoble raiz;


    public ArbolBinario() {
        this.raiz = null;
    }


    public boolean crearArbol() {
        SalidaPorDefecto.terminal("Dame la raiz \n");
        String info = entradasalida.EntradaPorDefecto.consolaCadenas();
        NodoDoble nodoNuevo = new NodoDoble(info);
        if (nodoNuevo != null) {
            raiz = nodoNuevo;
            crearArbol(raiz);
            return true;
        } else {
            return false;
        }
    }

    /**
     * Este metodo crea un arbol apartir de argumentos del usuario
     * @param subraiz es la subraiz
     */
    private void crearArbol(NodoDoble subraiz) {
        SalidaPorDefecto.terminal("¿ El nodo " + subraiz.getInfo() + "  tiene hijo izquierdo ?  \n");
        String respuestaIzq = entradasalida.EntradaPorDefecto.consolaCadenas();
        if (respuestaIzq.equalsIgnoreCase("Si")) {
            SalidaPorDefecto.terminal("Dame el contenido del hijo izquierdo de " + subraiz.getInfo() + "...  \n");
            String info = entradasalida.EntradaPorDefecto.consolaCadenas();
            NodoDoble nuevoNodoIzq = new NodoDoble(info);
            if (nuevoNodoIzq != null) {
                subraiz.setLigaIzq(nuevoNodoIzq);
                crearArbol(nuevoNodoIzq);
            }
        }
        SalidaPorDefecto.terminal("¿ El nodo " + subraiz.getInfo() + "  tiene hijo derecho ?  \n");
        String respuestaDer = entradasalida.EntradaPorDefecto.consolaCadenas();
        if (respuestaDer.equalsIgnoreCase("Si")) {
            SalidaPorDefecto.terminal("Dame el contenido del hijo derecho de " + subraiz.getInfo() + "...  \n");
            String info = entradasalida.EntradaPorDefecto.consolaCadenas();
            NodoDoble nuevoNodoDer = new NodoDoble(info);
            if (nuevoNodoDer != null) {
                subraiz.setLigaDer(nuevoNodoDer);
                crearArbol(nuevoNodoDer);
            }
        }
    }

    public void imprimirPreorden() {
        imprimirPreorden(raiz);
    }

    public void imprimirInnorden() {
        imprimirInnorden(raiz);
    }

    public void imprimirPostorden() {
        imprimirPostorden(raiz);
    }



    public void imprimirPreorden(NodoDoble subraiz) {
        if(subraiz!=null){
            SalidaPorDefecto.terminal(subraiz.getInfo() + " ");
            imprimirPreorden(subraiz.getLigaIzq());
            imprimirPreorden(subraiz.getLigaDer());
        }
    }

    public void imprimirInnorden(NodoDoble subraiz) {
        if(subraiz!=null){
            imprimirInnorden(subraiz.getLigaIzq());
            SalidaPorDefecto.terminal(subraiz.getInfo() + " ");
            imprimirInnorden(subraiz.getLigaDer());
        }
    }

    public void imprimirPostorden(NodoDoble subraiz) {
        if(subraiz!=null){
            imprimirPostorden(subraiz.getLigaIzq());
            imprimirPostorden(subraiz.getLigaDer());
            SalidaPorDefecto.terminal(subraiz.getInfo() + " ");
        }
    }
    /**
     * Imprime el arbol en postorden sin recursion
     */
    public void imprimirPostordenNoRec(){
        imprimirPostordenNoRec(raiz);
    }

    /**
     * Imprime el arbol en postorden sin recursion
     * @param subraiz Es la raiz
     */
    private void imprimirPostordenNoRec(NodoDoble subraiz){
        PilaDinamica nodos = new PilaDinamica();
        NodoDoble nodoActual = subraiz;
        NodoDoble padre = null;
        do{
            while (nodoActual != null){
                nodos.poner(nodoActual);
                nodoActual = nodoActual.getLigaIzq();
            }
            while(nodoActual == null && !nodos.vacio()){
                nodoActual = (NodoDoble) nodos.quitar();
                if(nodoActual.getLigaDer() == null || nodoActual.getLigaDer() == padre){
                    SalidaPorDefecto.terminal(nodoActual.getInfo() + " ");
                    padre = nodoActual;
                    nodoActual = null;
                }else{
                    nodos.poner(nodoActual);
                    nodoActual = nodoActual.getLigaDer();
                }
            }
        }while(!nodos.vacio());
    }

    public NodoDoble getRaiz() {
        return raiz;
    }

    public int altura() {
        return altura( raiz)+1;
    }

    /**
     * Este metodo aclcula la altura del arbol
     * @param nodo es la raiz
     * @return Regresa la altura del arbol
     */
    private int altura(NodoDoble nodo) {
        if (nodo == null) {
            return -1;
        } else {
            int alturaIzq = altura(nodo.getLigaIzq());
            int alturaDer = altura(nodo.getLigaDer());

            if (alturaIzq > alturaDer) {
                return alturaIzq + 1;
            } else {
                return alturaDer + 1;
            }
        }
    }

    public int buscarAlt(Object info) {
        return buscarAlt(raiz, info, 1);
    }


    /**
     * Este metodo busca la altura de un nodo
     * @param subraiz Es la raiz
     * @param info Es la info de el nodo a buscar
     * @param altura Es la altura a la que esta el nodo
     * @return Regresa la altura de el nodo
     */
    private int buscarAlt(NodoDoble subraiz, Object info, int altura) {
        if (subraiz == null) {
            return -1; // Nodo no encontrado
        }

        if ((int)Comparador.comparar(info, subraiz.getInfo()) == 0) {
            return altura; // Nodo encontrado
        }

        int leftLevel = buscarAlt(subraiz.getLigaIzq(), info, altura + 1);

        if (leftLevel != -1) {
            return leftLevel;
        }

        return buscarAlt(subraiz.getLigaDer(), info, altura + 1);
    }

    public ListaEstatica contarNodosXAltura() {
        if (raiz == null) {
            return null;
        }
        ListaEstatica nodosContados = new ListaEstatica(altura());
        nodosContados.rellenar(0, altura());
        contarNodosXAltura(raiz, nodosContados, 0);

        return nodosContados;
    }

    /**
     * Este metodo cuenta los nodos en cada altura del arbol
     * @return Regresa la altura del arbol
     */
    private static void contarNodosXAltura(NodoDoble subraiz, ListaEstatica nodosContados, int altura) {
        if (subraiz == null) {
            return;
        }

        nodosContados.cambiar(altura, (int)nodosContados.obtener(altura)+1);

        contarNodosXAltura(subraiz.getLigaIzq(), nodosContados, altura + 1);
        contarNodosXAltura(subraiz.getLigaDer(), nodosContados, altura + 1);
    }


    public NodoDoble getPadre(NodoDoble hijo){
        return getPadre(raiz, hijo);
    }

    /**
     * Busca el padre de un nodo en particular
     * @param subraiz Es la raiz
     * @param hijo Es la info de el nodo a buscar
     */
    private NodoDoble getPadre(NodoDoble subraiz, NodoDoble hijo){
        // Si la raíz es nula o es el hijo, no hay padre (es huerfano nimodillo)
        if (subraiz == null || hijo == raiz) {
            return null;
        }
        // Si el hijo está en el subárbol izquierdo de la raíz, se busca el padre en ese subárbol
        if (subraiz.getLigaIzq() == hijo) {
            return subraiz;
        }
        // Si el hijo está en el subárbol derecho de la raíz, buscar el padre en ese subárbol
        if (subraiz.getLigaDer() == hijo) {
            return subraiz;
        }
        // Si el hijo no está en el subárbol izquierdo ni derecho, se busca recursivamente en ambos subárboles
        NodoDoble padre = getPadre(subraiz.getLigaIzq(), hijo);
        if (padre != null) {
            return padre;
        }

        padre = getPadre(subraiz.getLigaDer(), hijo);
        if (padre != null) {
            return padre;
        }
        // Si no se encontró el padre en ninguno de los subárboles, devuelbe un null
        return null;
    }

    /**
     * Este metodo aclcula si un nodo es raiz, hoja intermedia o una hoja
     * @param subraiz Es la raiz
     * @param info Es la info de el nodo a busCar
     */
    public void tipoNodo(NodoDoble subraiz, Object info){
        if(subraiz!=null) {
            if((int) Comparador.comparar(info, subraiz.getInfo()) == 0) {
                if (subraiz.getLigaIzq() == null && subraiz.getLigaDer() == null) {
                    SalidaPorDefecto.terminal("EL nodo es una hoja y su padre es: " + getPadre(new NodoDoble(info)).getInfo());
                } else if (getPadre(subraiz).getInfo().equals("no tiene")) {
                    SalidaPorDefecto.terminal("El nodo es la raiz");
                } else if (subraiz.getLigaIzq() != null || subraiz.getLigaDer() != null) {
                    SalidaPorDefecto.terminal("EL nodo es una nodo intermedio y su padre es: "+ getPadre(new NodoDoble(info)).getInfo());
                }
            }
            tipoNodo(subraiz.getLigaIzq(), info);
            tipoNodo(subraiz.getLigaDer(), info);
        }

    }

    public void tipoNodo(Object info){
        tipoNodo(raiz, info);
    }

    /**
     * Este metodo calcula si un nodo tiene hermanos
     * @param info Es la info de el nodo a buscar
     */
    public void tieneHermano(Object info){
        if((int)contarNodosXAltura().obtener((buscarAlt(info)-1))>1){
            SalidaPorDefecto.terminal("SI");
        }else{
            SalidaPorDefecto.terminal("NO");
        }
    }
    /**
     * Este metodo imprime el  arbor por la anchura
     */
    public void imprimirPorAnchura(){
        imprimirPorAnchura(raiz);
    }

    /**
     * Este metodo imprime el  arbor por la anchura
     * @param subraiz Es la raiz
     */
    private void imprimirPorAnchura(NodoDoble subraiz){
        ColaDinamica cola = new ColaDinamica();
        cola.poner(subraiz);
        while (!cola.vacio()) {
            NodoDoble nodoActual = (NodoDoble) cola.quitar();
            SalidaPorDefecto.terminal(nodoActual + " ");
            if (nodoActual.getLigaIzq() != null) {
                cola.poner(nodoActual.getLigaIzq());
            }
            if (nodoActual.getLigaDer() != null) {
                cola.poner(nodoActual.getLigaDer());
            }
        }
    }

    /**
     * Este metodo es una simulacion de lo que pasaria si se usa una pila
     * en lugar de una pila para recorrer el arbol
     * @param subraiz Es la raiz
     */
    private void imprimirPorAnchuraConPila(NodoDoble subraiz){
        PilaDinamica pila = new PilaDinamica();
        pila.poner(subraiz);
        while (!pila.vacio()) {
            NodoDoble nodoActual = (NodoDoble) pila.quitar();
            SalidaPorDefecto.terminal(nodoActual + " ");
            if (nodoActual.getLigaIzq() != null) {
                pila.poner(nodoActual.getLigaIzq());
            }
            if (nodoActual.getLigaDer() != null) {
                pila.poner(nodoActual.getLigaDer());
            }
        }
    }
    /**
     * Este metodo es una simulacion de lo que pasaria si se usa una pila
     * en lugar de una pila para recorrer el arbol
     */
    public void imprimirPorAnchuraConPila(){
        imprimirPorAnchuraConPila(raiz);
    }

}