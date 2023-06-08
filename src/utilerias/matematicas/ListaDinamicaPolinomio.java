package utilerias.matematicas;

import entradaSalida.SalidaPorDefecto;
import estructurasLineales.auxiliares.Nodo;

public class ListaDinamicaPolinomio {
    protected Nodo primero;

    protected Nodo ultimo;
    protected Nodo nodoActual;

    public ListaDinamicaPolinomio() {
        primero = null;
        ultimo = null;
        nodoActual = null;
    }

    public boolean vacio(){
        if(primero == null){
            return true;
        }
        return false;
    }

    public void agregar(Object info){
        agregar(info, primero);
    }

    private void agregar(Object info, Nodo nodoActual){
        if(!vacio()) {
            if (nodoActual.getLigaDer() != null) {
                agregar(info, nodoActual.getLigaDer());
            } else {
                Nodo nodoNuevo = new Nodo(info);
                nodoActual.setLigaDer(nodoNuevo);
            }
        }else{
            Nodo nodoNuevo = new Nodo(info);
            primero = nodoNuevo;
            ultimo = nodoNuevo;
        }
    }

    /**
     * Válida si el token es operando
     * @param token Es el token
     * @return Regresa true si si es
     */
    public static boolean esOperando(String token){
        if(token.equalsIgnoreCase("+")){
            return false;
        } else if(token.equalsIgnoreCase("-")){
            return false;
        } else if(token.equalsIgnoreCase("/")){
            return false;
        } else if(token.equalsIgnoreCase("*")){
            return false;
        }
        return true;
    }

    public void agregarPolinomio(String polinomio, int posicion, String miembro){
        if(posicion<polinomio.length()) {
            char caracter = polinomio.charAt(posicion);
            if (esOperando(String.valueOf(caracter))) {
                miembro += caracter;
                agregarPolinomio(polinomio, posicion + 1, miembro);
            } else {
                agregar(miembro);
                miembro = "";
                miembro+=polinomio.charAt(posicion);
                agregarPolinomio(polinomio, posicion + 1, miembro);
            }
        }
        if (posicion == polinomio.length()) {
            agregar(miembro);
        }
    }

    private void imprimir(Nodo nodo){
        if(nodo!=null){
            SalidaPorDefecto.terminal(nodo.getInfo() + " -> ");
            imprimir(nodo.getLigaDer());
        }else{
            SalidaPorDefecto.terminal("null ");
        }
    }

    public void imprimir(){
        imprimir(primero);
    }

    public void buscar(Object info){
        if(!vacio()) {
            buscar(info, primero);
        }else{
            SalidaPorDefecto.terminal("Esta vacia :)");
        }
    }

    private void buscar(Object info, Nodo nodo){
        if(nodo!=null){
            if(nodo.getInfo() == info) {
                SalidaPorDefecto.terminal((String) nodo.getInfo());
            }
        }else{
            SalidaPorDefecto.terminal("null");
        }
    }

    public String sacarNumero(String operacion, int indice, String numero){
        if(indice<operacion.length()){
            char caracter = operacion.charAt(indice);
            if(!ExpresionesMatematicas.noEsNumero(String.valueOf(caracter))){
                numero= numero+caracter;
            }
            return sacarNumero(operacion, indice+1, numero);
        }else{
            return ""+numero;
        }
    }
    public int resolverPolinomio(ListaDinamicaPolinomio lista, int valorX, int resultado){
        return resolverPolinomio(lista, valorX, resultado, primero);
    }
    private int resolverPolinomio(ListaDinamicaPolinomio lista, int valorX, int resultado, Nodo nodo){
        String operacion;
        if(nodo!=null){
            operacion = (String) nodo.getInfo();
            String signo = String.valueOf(operacion.charAt(0));
            String numero = sacarNumero(operacion, 0, "");
            if(operacion.length()>2) {
                double pow = Math.pow(valorX, Double.parseDouble(numero));
                if (!esOperando(String.valueOf(operacion.charAt(0)))) {
                    if (signo.equalsIgnoreCase("-")) {
                        resultado = (int) (resultado - pow);
                        return resolverPolinomio(lista, valorX, resultado, nodo.getLigaDer()) - resultado;
                    }
                    if (signo.equalsIgnoreCase("+")) {
                        resultado = (int) (resultado + pow);
                        return resolverPolinomio(lista, valorX, resultado, nodo.getLigaDer()) + resultado;
                    }
                    if (signo.equalsIgnoreCase("*")) {
                        resultado = (int) (resultado * pow);
                        return resolverPolinomio(lista, valorX, resultado, nodo.getLigaDer()) * resultado;
                    }
                    if (signo.equalsIgnoreCase("/")) {
                        resultado = (int) (resultado / pow);
                        return resolverPolinomio(lista, valorX, resultado, nodo.getLigaDer()) / resultado;
                    }
                } else {
                    resultado = (int) (resultado + pow);
                    return resolverPolinomio(lista, valorX, resultado, nodo.getLigaDer()) ;
                }
            }else{
                if(operacion.charAt(0) == '+' && operacion.charAt(1) == 'x'){
                    resultado = valorX;
                    return resolverPolinomio(lista, valorX, resultado, nodo.getLigaDer()) + resultado;
                }else if(operacion.charAt(0) == '-' && operacion.charAt(1) == 'x'){
                    resultado = valorX;
                    return resolverPolinomio(lista, valorX, resultado, nodo.getLigaDer()) - resultado;
                }else if (!esOperando(String.valueOf(operacion.charAt(0)))) {
                    if (signo.equalsIgnoreCase("-")) {
                        resultado = (int) (resultado - Double.parseDouble(numero));
                        return resolverPolinomio(lista, valorX, resultado, nodo.getLigaDer()) - resultado;
                    }
                    if (signo.equalsIgnoreCase("+")) {
                        resultado = (int) (resultado + Double.parseDouble(numero));
                        return resolverPolinomio(lista, valorX, resultado, nodo.getLigaDer()) + resultado;
                    }
                    if (signo.equalsIgnoreCase("*")) {
                        resultado = (int) (resultado * Double.parseDouble(numero));
                        return resolverPolinomio(lista, valorX, resultado, nodo.getLigaDer()) * resultado;
                    }
                    if (signo.equalsIgnoreCase("/")) {
                        resultado = (int) (resultado / Double.parseDouble(numero));
                        return resolverPolinomio(lista, valorX, resultado, nodo.getLigaDer()) / resultado;
                    }
                }else {
                    resultado = (int) Double.parseDouble(numero);
                    return resolverPolinomio(lista, valorX, resultado, nodo.getLigaDer());
                }
            }
        }
        return resultado-1;
    }

    private String aBinario(ListaDinamicaPolinomio lista, String resultado, Nodo nodo, int numero, int numero2){
        if(nodo!=null&&numero>numero2){
            resultado += "0";
            return aBinario(lista,resultado, nodo.getLigaDer(),numero-1,  numero2) + resultado ;
        }else{
            resultado += "1";
        }
        return resultado;
    }
    public String aBinario(ListaDinamicaPolinomio lista, String resultado){
        Nodo nodo = primero;
        if(nodo!=null||nodo.getInfo()!="x") {
            String operacion = (String) nodo.getInfo();
            String operacion2 = (String) nodo.getLigaDer().getInfo();
            int numero = Integer.parseInt(sacarNumero(operacion, 0, ""));
            int numero2 = Integer.parseInt(sacarNumero(operacion2, 0, ""));
            return aBinario(lista, resultado, nodo, numero, numero2);
        }else{
            resultado += "1";
        }
        return resultado;
    }

}
