package estructurasNoLineales;

import entradaSalida.SalidaPorDefecto;
import estructurasLineales.auxiliares.Nodo;
import estructurasLineales.auxiliares.NodoDoble;
import utilerias.comunes.Comparador;

public class ArbolBinarioBusqueda extends ArbolBinario{
    private void crearArbol(NodoDoble subraiz) {
        SalidaPorDefecto.terminal("¿ El nodo " + subraiz.getInfo() + "  tiene hijo izquierdo ?  \n");
        String respuestaIzq = entradasalida.EntradaPorDefecto.consolaCadenas();
        if (respuestaIzq.equalsIgnoreCase("Si")) {
            SalidaPorDefecto.terminal("Dame el contenido del hijo izquierdo de " + subraiz.getInfo() + "...  \n");
            String info = entradasalida.EntradaPorDefecto.consolaCadenas();
            //Hay que checar si es mas pequeño que la subraiz
            if ((int)Comparador.comparar(info, subraiz.getInfo().toString()) < 0) {
                NodoDoble nuevoNodoIzq = new NodoDoble(info);
                if (nuevoNodoIzq != null) {
                    subraiz.setLigaIzq(nuevoNodoIzq);
                    crearArbol(nuevoNodoIzq);
                }
            }
        }
        SalidaPorDefecto.terminal("¿ El nodo " + subraiz.getInfo() + "  tiene hijo derecho ?  \n");
        String respuestaDer = entradasalida.EntradaPorDefecto.consolaCadenas();
        if (respuestaDer.equalsIgnoreCase("Si")) {
            SalidaPorDefecto.terminal("Dame el contenido del hijo derecho de " + subraiz.getInfo() + "...  \n");
            String info = entradasalida.EntradaPorDefecto.consolaCadenas();
            //Hay que checar si es mas pequeño que la subraiz
            if ((int)Comparador.comparar(info, subraiz.getInfo().toString()) > 0) {
                NodoDoble nuevoNodoDer = new NodoDoble(info);
                if (nuevoNodoDer != null) {
                    subraiz.setLigaDer(nuevoNodoDer);
                    crearArbol(nuevoNodoDer);
                }
            }
        }
    }
    private boolean agregar(NodoDoble subraiz, Object info){
        if((int)Comparador.comparar(info, subraiz.getInfo())<0){
            if(subraiz.getLigaIzq()!=null){
                return agregar(subraiz.getLigaIzq(), info);
            }else{
                NodoDoble nuevoNodo = new NodoDoble(info);
                if(nuevoNodo!=null){
                    subraiz.setLigaIzq(nuevoNodo);
                    return true;
                }else{
                    return false;
                }
            }
        } else if ((int)Comparador.comparar(info, subraiz.getInfo())>0) {
            if(subraiz.getLigaDer()!=null){
                return agregar(subraiz.getLigaDer(), info);
            }else{
                NodoDoble nuevoNodo = new NodoDoble(info);
                if(nuevoNodo!=null){
                    subraiz.setLigaDer(nuevoNodo);
                    return true;
                }else{
                    return false;
                }
            }
        }else {
            return false;
        }
    }

    public boolean agregar(Object info){
        if(raiz==null){
            NodoDoble nuevoNodo  =  new NodoDoble(info);
            if(nuevoNodo!=null){
                raiz = nuevoNodo;
                return true;
            }else{
                return false;
            }
        }else{
            return(agregar(raiz, info));
        }
    }

    private Object buscar(NodoDoble subraiz,Object info){
        if((int)Comparador.comparar(info, subraiz.getInfo())<0){
            if(subraiz.getLigaIzq()!=null){
                return buscar(subraiz.getLigaIzq(), info);
            }else{
                return null;
            }
        } else if ((int)Comparador.comparar(info, subraiz.getInfo())>0) {
            if(subraiz.getLigaDer()!=null){
                return buscar(subraiz.getLigaDer(), info);
            }else{
                return null;
            }
        }else {
            return subraiz.getInfo();
        }
    }

    public Object buscar(Object info){
        if(raiz==null){
            return null;
        }else{
            return buscar(raiz, info);
        }
    }

    private Object eliminar(NodoDoble apnodo, NodoDoble anterior, Object info){
        if(apnodo!=null){
            if((int)Comparador.comparar(info,apnodo.getInfo())<0){
                return eliminar(apnodo.getLigaIzq(),apnodo,info);
            }else{
                if((int)Comparador.comparar(info,apnodo.getInfo())>0){
                    return eliminar(apnodo.getLigaDer(),apnodo,info);
                }else{
                    if(apnodo.getLigaIzq()!=null && apnodo.getLigaDer()!=null){
                        NodoDoble aux = apnodo.getLigaIzq();
                        boolean bo = false;
                        NodoDoble aux1 = null;
                        while(aux.getLigaDer()!=null){
                            aux1 = aux;
                            aux = aux.getLigaDer();
                            bo = true;
                        }
                        apnodo.setInfo(aux.getInfo());
                        if(bo){
                            aux1.setLigaDer(aux.getLigaIzq());
                        }else{
                            apnodo.setLigaIzq(aux.getLigaIzq());
                        }
                    }else{
                        NodoDoble otro = apnodo;
                        if(otro.getLigaDer()==null){
                            if(otro.getLigaIzq()!=null){
                                otro = apnodo.getLigaIzq();
                                if(anterior!=null){
                                    if((int)Comparador.comparar(info, anterior.getInfo())<0){
                                        anterior.setLigaIzq(otro);
                                    }else{
                                        anterior.setLigaDer(otro);
                                    }
                                }else{
                                    raiz = otro;
                                }
                            }else{
                                if(anterior==null){
                                    raiz = null;
                                }else{
                                    if((int)Comparador.comparar(info,anterior.getInfo())<0){
                                        anterior.setLigaIzq(null);
                                    }else{
                                        anterior.setLigaDer(null);
                                    }
                                }
                            }
                        }else{
                            if(otro.getLigaIzq()==null){
                                otro = apnodo.getLigaDer();
                                if(anterior!=null){
                                    if((int)Comparador.comparar(info,anterior.getInfo())<0){
                                        anterior.setLigaIzq(otro);
                                    }else{
                                        anterior.setLigaDer(otro);
                                    }
                                }else{
                                    raiz = otro;
                                }
                            }
                        }
                    }
                }
            }
        }else{
            return null;
        }
        return info;
    }
    public Object eliminar(Object info) {
        return eliminar(raiz, null, info);
    }
}
