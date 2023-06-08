package utilerias.matematicas;

import entradaSalida.SalidaPorDefecto;
import estructurasLineales.ListaEstatica;
import estructurasLineales.PilaEstatica;

public class ExpresionesMatematicas {
    /**
     * Valida la prioridad de los operadores
     * @param operador Es el operador
     * @return Regresa la prioridad
     */
    private static int prioridadOperadores(char operador) {
        switch (operador) {
            case '+':
            case '-':
                return 1;
            case '*':
            case '/':
                return 2;
            case '^':
                return 3;
            default:
                return -1;
        }
    }

    /**
     * REcibe una expresion infija y la pasa a postfija
     * @param infija Es la expresion
     * @return Regresa la expresion ya convertida
     */
    public static String infijaAPostfija(String infija) {
        tokenizador(infija);
        PilaEstatica pila = new PilaEstatica(infija.length());
        String postfija = "";
        // Iterar a través de cada carácter en la expresión infija
        for (int i = 0; i < infija.length(); i++) {
            char c = infija.charAt(i);

            // Si el carácter es un operando, agregarlo a la cadena de salida
            if (Character.isLetterOrDigit(c)) {
                postfija += c;
            }

            // Si el carácter es un paréntesis izquierdo, empujarlo a la pila
            else if (c == '(') {
                pila.poner(c);
            }

            // Si el carácter es un paréntesis derecho, desapilar elementos de la pila y agregarlos a la cadena de salida hasta encontrar el paréntesis izquierdo correspondiente
            else if (c == ')') {
                while (!pila.vacio() && (char)pila.verTope() != '(') {
                    postfija += pila.quitar();
                }

                // Eliminar el paréntesis izquierdo de la pila
                pila.quitar();
            }

            // Si el carácter es un operador, desapilar elementos de la pila y agregarlos a la cadena de salida hasta encontrar un operador de menor precedencia o un paréntesis izquierdo
            else {
                while (!pila.vacio() && (char)pila.verTope() != '(' && prioridadOperadores((char)pila.verTope()) >= prioridadOperadores(c)) {
                    postfija += pila.quitar();
                }

                // Empujar el operador a la pila
                pila.poner(c);
            }
        }

        // Desapilar cualquier elemento restante en la pila y agregarlos a la cadena de salida
        while (!pila.vacio()) {
            postfija += pila.quitar();
        }

        return postfija;
    }
    /**
     * REcibe una expresion infija y la pasa a prefija
     * @param infija Es la expresion
     * @return Regresa la expresion ya convertida
     */
    public static String infijaAPrefija(String infija){
        infija = tokenizador(infija);
        SalidaPorDefecto.terminal(infija);
        PilaEstatica pila = new PilaEstatica(infija.length());
        String postfija = "";
        for (int cadaToken = infija.length() - 1; cadaToken >= 0; cadaToken--) {
            char token = infija.charAt(cadaToken);
            if (esOperando("" + token)) {
                postfija = token + postfija ;
            }
            else if (token == ')') {
                pila.poner(token);
            }
            else if (token == '(') {
                while (!pila.vacio() && (char)pila.verTope() != ')') {
                    postfija = pila.quitar() + postfija;
                }
                pila.quitar();
            }
            else {
                while (!pila.vacio() && (char)pila.verTope() != '(' && prioridadOperadores((char)pila.verTope()) > prioridadOperadores(token)) {
                    postfija = pila.quitar() + postfija;
                }
                pila.poner(token);
            }
        }
        while (!pila.vacio()) {
            postfija = pila.quitar() + postfija;
        }
        SalidaPorDefecto.terminal("\n" + postfija + "\n");
        return postfija;
    }

    /**
     * Evalua la expresion postfija
     * @param postfija es la expresion postfija
     * @return Regresa el resultado
     */
    public static Double evaluarPostfija (String postfija) {
        //a 8 + 3 x * 4 z ^ / -
        //0 1 2 3 4 5 6 7 8 9 10, posiciones
        PilaEstatica pila = new PilaEstatica(postfija.length());

        for (int cadaToken = 0; cadaToken < postfija.length(); cadaToken++) {
            //1. Tokenizar izq-der
            char token = postfija.charAt(cadaToken);

            //2. Si es opernado, meter a la pila
            if (esOperando("" + token) == true) {
                boolean resultadoPila = pila.poner("" + token);
                if (resultadoPila == false) {
                    return null;
                }
            } else { //es operador
                //3. Si es operador, sacar 2 operandos
                // (el primero es op2)
                String operando2 = (String) pila.quitar();
                String operando1 = (String) pila.quitar();

                if (operando1 == null || operando2 == null) {
                    return null;
                } else {
                    //Aplicar la operacion con ellos
                    Double resultadoParcial = operacion(Double.parseDouble(operando1), Double.parseDouble(operando2), token);
                    //Meter el resultado en la pila
                    if (resultadoParcial == null) {

                        return null;
                    } else {
                        boolean resultadoPila = pila.poner("" + resultadoParcial);
                        if (resultadoPila == false) {
                            return null;
                        }
                    }
                }
            }
        }
        //4. el resultado final esta en la pila.
        String resultadoFinal = (String) pila.quitar();
        if (resultadoFinal != null) {
            return Double.parseDouble(resultadoFinal);
        } else {
            return null;
        }
    }
    /**
     * Evalua la expresion pretija
     * @param prefija es la expresion prefija
     * @return Regresa el resultado
     */
    public static Double evaluarPrefija (String prefija) {
        //a 8 + 3 x * 4 z ^ / -
        //0 1 2 3 4 5 6 7 8 9 10, posiciones
        PilaEstatica pila = new PilaEstatica(prefija.length());

        for (int cadaToken = prefija.length() - 1; cadaToken >= 0; cadaToken--) {
            //1. Tokenizar der-izq
            char token = prefija.charAt(cadaToken);

            //2. Si es opernado, meter a la pila
            if (esOperando("" + token) == true) {
                boolean resultadoPila = pila.poner("" + token);
                if (resultadoPila == false) {
                    return null;
                }
            } else { //es operador
                //3. Si es operador, sacar 2 operandos
                // (el primero es op1)
                String operando1 = (String) pila.quitar();
                String operando2 = (String) pila.quitar();

                if (operando1 == null || operando2 == null) {
                    return null;
                } else {
                    //Aplicar la operacion con ellos
                    Double resultadoParcial = operacion(Double.parseDouble(operando1), Double.parseDouble(operando2), token);
                    //Meter el resultado en la pila
                    if (resultadoParcial == null) {
                        return null;
                    } else {
                        boolean resultadoPila = pila.poner("" + resultadoParcial);
                        if (resultadoPila == false) {
                            return null;
                        }
                    }
                }
            }
        }
        //4. el resultado final esta en la pila.
        String resultadoFinal = (String) pila.quitar();
        if (resultadoFinal != null) {
            return Double.parseDouble(resultadoFinal);
        } else {
            return null;
        }
    }

    /**
     * Valida si el token es operando
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
        } else if(token.equalsIgnoreCase("^")){
            return false;
        } else if(token.equalsIgnoreCase("%")){
            return false;
        } else if(token.equalsIgnoreCase("(")){
            return false;
        } else if(token.equalsIgnoreCase(")")){
            return false;
        } else if(token.equalsIgnoreCase("{")){
            return false;
        } else if(token.equalsIgnoreCase("}")){
            return false;
        } else if(token.equalsIgnoreCase("[")){
            return false;
        } else if(token.equalsIgnoreCase("]")){
            return false;
        }
        return true;
    }
    /**
     * Valida si el token no es numero
     * @param token Es el token
     * @return Regresa true si no es
     */
    public static boolean noEsNumero(String token) {
        if (token.equalsIgnoreCase("1")) {
            return false;
        } else if (token.equalsIgnoreCase("2")) {
            return false;
        } else if (token.equalsIgnoreCase("3")) {
            return false;
        } else if (token.equalsIgnoreCase("4")) {
            return false;
        } else if (token.equalsIgnoreCase("5")) {
            return false;
        } else if (token.equalsIgnoreCase("6")) {
            return false;
        } else if (token.equalsIgnoreCase("7")) {
            return false;
        } else if (token.equalsIgnoreCase("8")) {
            return false;
        } else if (token.equalsIgnoreCase("9")) {
            return false;
        } else if (token.equalsIgnoreCase("0")) {
            return false;
        }
        return true;
    }

    /**
     * Realiza las operaciones
     * @param operando1 Es el primer noperando
     * @param operando2 Es el segundo noperando
     * @param operador es el operador
     * @return Regesa el resultado de la operacion
     */
    public static Double operacion(double operando1, double operando2, char operador) {
        if (operador == '+') {
            return operando1 + operando2;
        } else if (operador == '-') {
            return operando1 - operando2;
        } else if (operador == '/') {
            if (operando2 == 0) {
                return null;
            }
            return operando1 / operando2;
        } else if (operador == '*') {
            return operando1 * operando2;
        } else if (operador == '^') {
            return Math.pow(operando1, operando2);
        } else if (operador == '%') {
            return operando1 % operando2;
        }
        return null;
    }

    /**
     * Tokeniza la expresion infija
     * @param infija Es la expresion infija
     * @return Regresa la expresion ya tokenizada
     */
    public static String tokenizador(String infija){
        ListaEstatica lista = new ListaEstatica(infija.length());
        int cadaToken = 0;
        while(cadaToken < infija.length()){
            String nuevaVariable = "";
            if(!noEsNumero(infija.charAt(cadaToken) + "")) {
                lista.agregar(infija.charAt(cadaToken));
            } else if(!esOperando(infija.charAt(cadaToken) + "")){
                lista.agregar(infija.charAt(cadaToken));
            } else if(esOperando(infija.charAt(cadaToken) + "") && infija.charAt(cadaToken) != ' '){
                while(esOperando(infija.charAt(cadaToken) + "")) {
                    nuevaVariable += infija.charAt(cadaToken);
                    cadaToken++;
                }
                SalidaPorDefecto.terminal("Que valor tiene la variable " + nuevaVariable + "\n");
                nuevaVariable = entradasalida.EntradaPorDefecto.consolaCadenas();
                lista.agregar(nuevaVariable);
                lista.agregar(infija.charAt(cadaToken));
            }
            cadaToken++;
        }
        String nuevaInfija = "";
        for(int nuevoToken = 0; nuevoToken <= lista.getTope(); nuevoToken++){
            nuevaInfija += lista.obtener(nuevoToken);
        }
        return nuevaInfija;
    }
}