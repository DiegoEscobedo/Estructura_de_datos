package estructurasNoLineales;

import entradaSalida.SalidaPorDefecto;
import estructurasLineales.ColaDinamica;
import estructurasLineales.ListaEstatica;
import estructurasLineales.auxiliares.Nodo;
import estructurasLineales.auxiliares.NodoDoble;
import utilerias.comunes.Comparador;
import utilerias.comunes.TipoOrden;

/**
 * @author diego
 * @version 1.0
 */
public class ArbolMonticulo extends ArbolBinario{
    protected TipoOrden tipoOrden;

    public ArbolMonticulo(TipoOrden tipoOrden){
        super();
        this.tipoOrden = tipoOrden;
    }

    /**
     * Este metodo agrega y ordena los nodos segun el tipo de orden
     * @param info Es la info del nodo a agregar
     */
    public void agregar(Object info){
        NodoDoble acomodar = agregarNodo(info);
        if(tipoOrden == TipoOrden.DEC){
            oredenarMonticuloDEC(acomodar);
        } else if (tipoOrden == TipoOrden.INC) {
            oredenarMonticuloASC(acomodar);
        }
    }

    /**
     * Este metodo agrega en un espacio disponible el un nodo
     * @param info Es la indo del nodo
     * @return Regresa si si lo agrego
     */
    public NodoDoble agregarNodo(Object info) {
        NodoDoble nodoNuevo = new NodoDoble(info);
        if(nodoNuevo!=null) {
            if (raiz == null) {
                raiz = nodoNuevo;
                return nodoNuevo;
            }
            ColaDinamica cola = new ColaDinamica();
            cola.poner(raiz);
            boolean agregado = false;
            while (!cola.vacio()) {
                NodoDoble nodoActual = (NodoDoble) cola.quitar();
                if (nodoActual.getLigaIzq() == null) {
                    nodoActual.setLigaIzq(nodoNuevo);
                    agregado = true;
                    break;
                }
                if (nodoActual.getLigaDer() == null) {
                    nodoActual.setLigaDer(nodoNuevo);
                    agregado = true;
                    break;
                }
                cola.poner(nodoActual.getLigaIzq());
                cola.poner(nodoActual.getLigaDer());
            }
            if (!agregado) {
                agregarNivel(info);
            }
        }
        return nodoNuevo;
    }
    private NodoDoble agregarNivel(Object info) {
        ColaDinamica cola = new ColaDinamica();
        cola.poner(raiz);
        NodoDoble nodoNuevo = new NodoDoble(info);
        while (!cola.vacio()) {
            int size = cola.cantidad();
            boolean agregado = false;
            for (int i = 0; i < size; i++) {
                NodoDoble nodoActual = (NodoDoble) cola.quitar();
                if (nodoActual.getLigaIzq() == null) {
                    nodoActual.setLigaIzq(nodoNuevo);
                    agregado = true;
                    break;
                }
                if (nodoActual.getLigaDer() == null) {
                    nodoActual.setLigaDer(nodoNuevo);
                    agregado = true;
                    break;
                }
                cola.poner(nodoActual.getLigaIzq());
                cola.poner(nodoActual.getLigaDer());
            }
            if (agregado) {
                break;
            }
        }
        return nodoNuevo;
    }

    /**
     * Este metodo ordena el nodo de forma incremental
     * @param subraiz Es la subraiz de los arboles
     */
    public void oredenarMonticuloASC(NodoDoble subraiz){
        if(subraiz.getInfo()!=null) {
            if ((int) Comparador.comparar(subraiz.getInfo(), raiz.getInfo()) < 0) {
                if(getPadre(subraiz)!=null&&getPadre(subraiz).getLigaIzq()!=null&&getPadre(subraiz).getLigaIzq().getInfo() == subraiz.getInfo()) {
                    getPadre(subraiz).setLigaIzq(null);
                }
                if(getPadre(subraiz)!=null&&getPadre(subraiz).getLigaDer()!=null&&getPadre(subraiz).getLigaDer().getInfo() == subraiz.getInfo()) {
                    getPadre(subraiz).setLigaDer(null);
                }
                NodoDoble respaldo = raiz;

                if(respaldo.getLigaDer()!=null&& respaldo.getLigaIzq()!=null&& (int) Comparador.comparar(respaldo.getLigaDer(), respaldo.getLigaIzq()) < 0){
                    subraiz.setLigaDer(respaldo.getLigaDer());
                    respaldo.setLigaDer(null);
                    subraiz.setLigaIzq(respaldo);
                } else if (respaldo.getLigaDer()==null) {
                    respaldo.setLigaIzq(null);
                    subraiz.setLigaDer(respaldo);
                } else if (respaldo.getLigaIzq()==null) {
                    subraiz.setLigaDer(respaldo.getLigaDer());
                    respaldo.setLigaDer(null);
                    subraiz.setLigaIzq(respaldo);
                } else{
                    subraiz.setLigaIzq(respaldo.getLigaIzq());
                    respaldo.setLigaIzq(null);
                    subraiz.setLigaDer(respaldo);
                }
                raiz = subraiz;
            } else {
                for (int i = 0; i < this.altura(); i++) {
                    NodoDoble nodoPadre = new NodoDoble(null);
                    if (getPadre(subraiz) != null) {
                        nodoPadre = getPadre(subraiz);
                    }
                    NodoDoble nodoAbuelo = new NodoDoble(null);
                    if (getPadre(nodoPadre) != null) {
                        nodoAbuelo = getPadre(nodoPadre);
                    }
                    if (nodoPadre.getInfo() != null) {
                        if (nodoPadre != null && (int) Comparador.comparar(nodoPadre.getInfo(), subraiz.getInfo()) > 0) {
                            if (nodoPadre.getLigaDer() != null && nodoPadre.getLigaDer().getInfo() == subraiz.getInfo()) {
                                NodoDoble aux = nodoPadre.getLigaIzq();
                                if (nodoAbuelo.getInfo() != null) {
                                    if (nodoAbuelo.getLigaDer().getInfo() == nodoPadre.getInfo()) {
                                        nodoAbuelo.setLigaDer(subraiz);
                                    }
                                    if (nodoAbuelo.getLigaIzq().getInfo() == nodoPadre.getInfo()) {
                                        nodoAbuelo.setLigaIzq(subraiz);
                                    }
                                }
                                if (subraiz.getLigaIzq() != null) {
                                    nodoPadre.setLigaIzq(subraiz.getLigaIzq());
                                } else {
                                    nodoPadre.setLigaIzq(null);
                                }
                                if (subraiz.getLigaDer() != null) {
                                    nodoPadre.setLigaDer(subraiz.getLigaDer());
                                } else {
                                    nodoPadre.setLigaDer(null);
                                }
                                subraiz.setLigaDer(nodoPadre);
                                subraiz.setLigaIzq(aux);
                            }
                            if (nodoPadre.getLigaIzq() != null && nodoPadre.getLigaIzq().getInfo() == subraiz.getInfo()) {
                                NodoDoble aux = nodoPadre.getLigaDer();
                                if (nodoAbuelo.getInfo() != null) {
                                    if (nodoAbuelo.getLigaDer().getInfo() == nodoPadre.getInfo()) {
                                        nodoAbuelo.setLigaDer(subraiz);
                                    }
                                    if (nodoAbuelo.getLigaIzq().getInfo() == nodoPadre.getInfo()) {
                                        nodoAbuelo.setLigaIzq(subraiz);
                                    }
                                }
                                if (subraiz.getLigaIzq() != null) {
                                    nodoPadre.setLigaIzq(subraiz.getLigaIzq());
                                } else {
                                    nodoPadre.setLigaIzq(null);
                                }
                                if (subraiz.getLigaDer() != null) {
                                    nodoPadre.setLigaDer(subraiz.getLigaDer());
                                } else {
                                    nodoPadre.setLigaDer(null);
                                }
                                subraiz.setLigaIzq(nodoPadre);
                                subraiz.setLigaDer(aux);
                            }
                        }
                    }
                }
            }
        }
    }
    /**
     * Este metodo ordena el nodo de forma decremental
     * @param subraiz Es la subraiz de los arboles
     */
    public void oredenarMonticuloDEC(NodoDoble subraiz){
        if(subraiz.getInfo()!=null) {
            if ((int) Comparador.comparar(subraiz.getInfo(), raiz.getInfo()) > 0) {
                if(getPadre(subraiz)!=null&&getPadre(subraiz).getLigaIzq()!=null&&getPadre(subraiz).getLigaIzq().getInfo() == subraiz.getInfo()) {
                    getPadre(subraiz).setLigaIzq(null);
                }
                if(getPadre(subraiz)!=null&&getPadre(subraiz).getLigaDer()!=null&&getPadre(subraiz).getLigaDer().getInfo() == subraiz.getInfo()) {
                    getPadre(subraiz).setLigaDer(null);
                }
                NodoDoble respaldo = raiz;
                if(respaldo.getLigaDer()!=null&&respaldo.getLigaIzq()!=null&&(int) Comparador.comparar(respaldo.getLigaDer(), respaldo.getLigaIzq()) > 0){
                    subraiz.setLigaDer(respaldo.getLigaDer());
                    respaldo.setLigaDer(null);
                    subraiz.setLigaIzq(respaldo);
                } else if (respaldo.getLigaDer()==null) {
                    respaldo.setLigaIzq(null);
                    subraiz.setLigaDer(respaldo);
                } else if (respaldo.getLigaIzq()==null) {
                    subraiz.setLigaDer(respaldo.getLigaDer());
                    respaldo.setLigaDer(null);
                    subraiz.setLigaIzq(respaldo);
                } else{

                    subraiz.setLigaIzq(respaldo.getLigaIzq());
                    respaldo.setLigaIzq(null);
                    subraiz.setLigaDer(respaldo);
                }
                raiz = subraiz;
            } else {
                for (int i = 0; i < this.altura(); i++) {
                    NodoDoble nodoPadre = new NodoDoble(null);
                    if (getPadre(subraiz) != null) {
                        nodoPadre = getPadre(subraiz);
                    }
                    NodoDoble nodoAbuelo = new NodoDoble(null);
                    if (getPadre(nodoPadre) != null) {
                        nodoAbuelo = getPadre(nodoPadre);
                    }
                    if (nodoPadre.getInfo() != null) {
                        if (nodoPadre != null && (int) Comparador.comparar(nodoPadre.getInfo(), subraiz.getInfo()) < 0) {
                            if (nodoPadre.getLigaDer() != null && nodoPadre.getLigaDer().getInfo() == subraiz.getInfo()) {
                                NodoDoble aux = nodoPadre.getLigaIzq();
                                if (nodoAbuelo.getInfo() != null) {
                                    if (nodoAbuelo.getLigaDer().getInfo() == nodoPadre.getInfo()) {
                                        nodoAbuelo.setLigaDer(subraiz);
                                    }
                                    if (nodoAbuelo.getLigaIzq().getInfo() == nodoPadre.getInfo()) {
                                        nodoAbuelo.setLigaIzq(subraiz);
                                    }
                                }
                                if (subraiz.getLigaIzq() != null) {
                                    nodoPadre.setLigaIzq(subraiz.getLigaIzq());
                                } else {
                                    nodoPadre.setLigaIzq(null);
                                }
                                if (subraiz.getLigaDer() != null) {
                                    nodoPadre.setLigaDer(subraiz.getLigaDer());
                                } else {
                                    nodoPadre.setLigaDer(null);
                                }
                                subraiz.setLigaDer(nodoPadre);
                                subraiz.setLigaIzq(aux);
                            }
                            if (nodoPadre.getLigaIzq() != null && nodoPadre.getLigaIzq().getInfo() == subraiz.getInfo()) {
                                NodoDoble aux = nodoPadre.getLigaDer();
                                if (nodoAbuelo.getInfo() != null) {
                                    if (nodoAbuelo.getLigaDer().getInfo() == nodoPadre.getInfo()) {
                                        nodoAbuelo.setLigaDer(subraiz);
                                    }
                                    if (nodoAbuelo.getLigaIzq().getInfo() == nodoPadre.getInfo()) {
                                        nodoAbuelo.setLigaIzq(subraiz);
                                    }
                                }
                                if (subraiz.getLigaIzq() != null) {
                                    nodoPadre.setLigaIzq(subraiz.getLigaIzq());
                                } else {
                                    nodoPadre.setLigaIzq(null);
                                }
                                if (subraiz.getLigaDer() != null) {
                                    nodoPadre.setLigaDer(subraiz.getLigaDer());
                                } else {
                                    nodoPadre.setLigaDer(null);
                                }
                                subraiz.setLigaIzq(nodoPadre);
                                subraiz.setLigaDer(aux);
                            }
                        }
                    }
                }
            }
        }
    }

    /**
     * Este metodo encunetra el ultimo nodo de un arbol
     * @param nodoActual es el nodoactual/raiz
     * @return
     */
    public NodoDoble encontrarUltimoNodo(NodoDoble nodoActual) {
        ColaDinamica cola = new ColaDinamica();
        cola.poner(nodoActual);
        NodoDoble ultimoNodo = null;

        while (!cola.vacio()) {
            ultimoNodo = (NodoDoble) cola.quitar();

            if (ultimoNodo.getLigaIzq() != null) {
                cola.poner(ultimoNodo.getLigaIzq());
            }

            if (ultimoNodo.getLigaDer() != null) {
                cola.poner(ultimoNodo.getLigaDer());
            }
        }

        return ultimoNodo;
    }

    /**
     * Este metodo elimina 1 monticulo del arbol
     */
    public void eliminar(){
        NodoDoble ultimo = encontrarUltimoNodo(raiz);
        NodoDoble padre = getPadre(ultimo);
        if(padre.getLigaIzq()==ultimo){
            padre.setLigaIzq(null);
        }else if(padre.getLigaDer()==ultimo){
            padre.setLigaDer(null);
        }
        ultimo.setLigaDer(raiz.getLigaDer());
        ultimo.setLigaIzq(raiz.getLigaIzq());
        raiz=ultimo;
        if(tipoOrden==TipoOrden.DEC){
            oredenarMonticuloDEC(raiz);
        } else if (tipoOrden==TipoOrden.INC) {
            oredenarMonticuloASC(raiz);
        }
    }
}
