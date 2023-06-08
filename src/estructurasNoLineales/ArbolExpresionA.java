package estructurasNoLineales;

import entradaSalida.SalidaPorDefecto;
import estructurasLineales.ListaDinamica;
import estructurasLineales.ListaDinamicaClave;
import estructurasLineales.PilaEstatica;
import estructurasLineales.auxiliares.Nodo;
import estructurasLineales.auxiliares.NodoDoble;
import utilerias.matematicas.ExpresionesMatematicas;

public class ArbolExpresionA extends ArbolBinario{
    protected ListaDinamicaClave listaOperandos = new ListaDinamicaClave();
    protected ListaDinamica listaOperadores = new ListaDinamica();

    protected ArbolBinario arbolConValores = new ArbolBinario();

    public ArbolExpresionA(){
    }

    public void crearArbolInf(String infija){

    }

    public boolean crearArbolPost(String postfija){
        PilaEstatica pila = new PilaEstatica(postfija.length());
        for(int postoken = 0; postoken<postfija.length(); postoken++){
            char token = postfija.charAt(postoken);
            if(ExpresionesMatematicas.esOperando(token+"")){
                NodoDoble nuevoNodo = new NodoDoble(token);
                if(nuevoNodo!=null) {
                    pila.poner(nuevoNodo);
                }else{
                    return false;
                }
            }else{
                NodoDoble nuevoNodo = new NodoDoble(token);
                NodoDoble operando2 = (NodoDoble) pila.quitar();
                NodoDoble operando1 = (NodoDoble) pila.quitar();
                if(nuevoNodo!=null && operando1!=null && operando2!=null){
                    nuevoNodo.setLigaIzq(operando1);
                    nuevoNodo.setLigaDer(operando2);
                    pila.poner(nuevoNodo);
                }else{
                    return false;
                }
            }
        }
        NodoDoble nodoRaiz=(NodoDoble) pila.quitar();
        if(nodoRaiz!=null){
            raiz = nodoRaiz;
            return true;
        }else {
            return false;
        }
    }
    public boolean crearArbolPref(String prefija){
        PilaEstatica pila = new PilaEstatica(prefija.length());
        for(int postoken = prefija.length()-1; postoken>=0; postoken--){
            char token = prefija.charAt(postoken);
            if(ExpresionesMatematicas.esOperando(token+"")){
                NodoDoble nuevoNodo = new NodoDoble(token);
                if(nuevoNodo!=null) {
                    pila.poner(nuevoNodo);
                }else{
                    return false;
                }
            }else{
                NodoDoble nuevoNodo = new NodoDoble(token);
                NodoDoble operando1 = (NodoDoble) pila.quitar();
                NodoDoble operando2 = (NodoDoble) pila.quitar();
                if(nuevoNodo!=null && operando1!=null && operando2!=null){
                    nuevoNodo.setLigaIzq(operando1);
                    nuevoNodo.setLigaDer(operando2);
                    pila.poner(nuevoNodo);
                }else{
                    return false;
                }
            }
        }
        NodoDoble nodoRaiz=(NodoDoble) pila.quitar();
        if(nodoRaiz!=null){
            raiz = nodoRaiz;
            return true;
        }else {
            return false;
        }
    }

    /**
     * Este metodo saca los operandos en una lista dinamica
     * @param subraiz Es la raiz
     */
    private void listaDinamicaOperandos(NodoDoble subraiz){
        if(subraiz!=null){
            if(ExpresionesMatematicas.esOperando((String) subraiz.getInfo()) && ExpresionesMatematicas.noEsNumero((String) subraiz.getInfo())){
                SalidaPorDefecto.terminal("Dame el valor de: " + subraiz.getInfo());
                double valor = entradasalida.EntradaPorDefecto.consolaDouble();
                listaOperandos.agregar(subraiz.getInfo(), valor);
            }
            listaDinamicaOperandos(subraiz.getLigaIzq());
            listaDinamicaOperandos(subraiz.getLigaDer());
        }
    }

    public void listaDinamicaOperandos(){
        listaDinamicaOperandos(raiz);
    }

    public void imprimirOperandos(){
        listaOperandos.imprimir();
    }

    /**
     * Este metodo saca los operadores en una lista estatica
     * @param subraiz Es la raiz
     */
    private void listaDinamicaOperadores(NodoDoble subraiz){
        if(subraiz!=null){
            if(!ExpresionesMatematicas.esOperando((String) subraiz.getInfo())){
                listaOperadores.agregar(subraiz.getInfo());
            }
            listaDinamicaOperadores(subraiz.getLigaIzq());
            listaDinamicaOperadores(subraiz.getLigaDer());
        }
    }
    public void imprimir(){
        imprimirInnorden();
        SalidaPorDefecto.terminal("\n");
        imprimirPreorden();
        SalidaPorDefecto.terminal("\n");
        imprimirPostorden();
        SalidaPorDefecto.terminal("\n");
    }
    public void listaDinamicaOperadores(){
        listaDinamicaOperadores(raiz);
    }

    public void imprimirOperadores(){
        listaOperadores.imprimir();
    }

    /**
     * Este metodo genera otro arbol pero con las variables ya sustituidas por el usuario
     * @param subraiz Es la raiz
     * @param subraiz2 Es la raiz del otro arbol
     */
    private void generarArbolConValores(NodoDoble subraiz, NodoDoble subraiz2){
        if(subraiz!=null){
            if(ExpresionesMatematicas.esOperando((String) subraiz.getInfo()) && ExpresionesMatematicas.noEsNumero((String) subraiz.getInfo())){
                SalidaPorDefecto.terminal("Dame el valor de: " + subraiz.getInfo());
                double valor = entradasalida.EntradaPorDefecto.consolaDouble();
                NodoDoble nuevoNodo = new NodoDoble(valor);
                subraiz2.setInfo(nuevoNodo);
                generarArbolConValores(subraiz.getLigaIzq(), subraiz2.getLigaIzq());
                generarArbolConValores(subraiz.getLigaDer(), subraiz2.getLigaDer());
            }else{
                subraiz2.setLigaIzq(subraiz.getLigaIzq());
                generarArbolConValores(subraiz.getLigaIzq(), subraiz2.getLigaIzq());
                generarArbolConValores(subraiz.getLigaDer(), subraiz2.getLigaDer());
            }
        }
    }
    public void generarArbolConValores(){
        NodoDoble nodoNuevo = new NodoDoble(raiz);
        if (nodoNuevo != null && arbolConValores.raiz==null) {
            arbolConValores.raiz=raiz;
        }
        generarArbolConValores(this.raiz, arbolConValores.raiz);
    }

    /**
     * Imprime el arbol con los valors del usuario
     */
    public void imprimirArbolConValores(){
        arbolConValores.imprimirInnorden();
        SalidaPorDefecto.terminal("\n");
        arbolConValores.imprimirPreorden();
        SalidaPorDefecto.terminal("\n");
        arbolConValores.imprimirPostorden();
        SalidaPorDefecto.terminal("\n");
    }


}
