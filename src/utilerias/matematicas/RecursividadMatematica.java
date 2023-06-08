package utilerias.matematicas;

import entradaSalida.SalidaPorDefecto;
import estructurasLineales.auxiliares.Nodo;
import estructurasNoLineales.Matriz2;

public class RecursividadMatematica {
    public static int Potencia(int numero, int exponente)
    {
        if (exponente == 0) {
            return 1;
        } else if(exponente > 0){
            return numero * Potencia(numero, exponente - 1);
        } else {
            return numero * Potencia(numero, exponente+1);
        }
    }
    public static int factorial(int numero)
    {
        if (numero == 1) {
            return 1;
        }
        else
        {
            return numero * factorial(numero - 1);
        }
    }

    public static String quitarEspacios(String cadena, int indice){
        if(indice == cadena.length()){
            return "";
        }else{
            char c = cadena.charAt(indice);
            if(c != ' '){
                return c + quitarEspacios(cadena,indice+1);
            }
            return quitarEspacios(cadena,indice);
        }
    }
    public int mayorDeArreglo(int [] arreglo, int ultimo, int indice){
        if(indice==ultimo){
            return arreglo[indice];
        }else {
            int mayorResto = mayorDeArreglo(arreglo,ultimo,indice+1);
            if (arreglo[indice] > mayorResto){
                return arreglo[indice];
            }else{
                return mayorResto;
            }
        }
    }

    public void imprimirArreglo(Object [] arreglo, int ultimo, int indice){
        if(indice<=ultimo){
            SalidaPorDefecto.terminal((String) arreglo[indice]);
            imprimirArreglo(arreglo, ultimo, indice+1);
        }
    }
    public static void imprimirListaEnlazada(Nodo nodoActual){
        if(nodoActual != null){
            SalidaPorDefecto.terminal(nodoActual.getInfo() + " -> ");
            imprimirListaEnlazada(nodoActual.getLigaDer());
        }else{
            SalidaPorDefecto.terminal("null");
        }
    }
    public static void imprimirMatriz2D(Matriz2 matriz, int renglones, int columnas, int cadaRenglon, int cadaColumna){
        SalidaPorDefecto.terminal(matriz.obtener(cadaRenglon, cadaColumna) + " ");
        if(cadaColumna<columnas-1 || cadaRenglon<renglones-1) {
            if (cadaColumna < columnas-1) {
                cadaColumna++;
            } else if (cadaRenglon < renglones-1) {
                cadaRenglon++;
                cadaColumna = 0;
                SalidaPorDefecto.terminal("\n");
            }
            imprimirMatriz2D(matriz, renglones, columnas, cadaRenglon, cadaColumna);
        }else{
        }
    }
    public static int fibonacci(int n){
        if(n>2){
            return n;
        }else{
            return fibonacci(n-1)+fibonacci(n-2);
        }
    }

    /**
     * Nos dice si un numero es primo
     * @param num es el numero
     * @param divisor el divisor
     * @return Regresa si es primo o no
     */
    public static boolean numeroPrimo(int num, int divisor){
        if(num/2 < divisor){
            return true;
        } else {
            if(num%divisor==0){
                return false;
            } else {
                return numeroPrimo(num, divisor+1);
            }
        }
    }

    /**
     * Nos dice si un numero es binario
     * @param numero es el numero
     * @param poss es la pocision de donde empieza a verificar los numeros
     * @return Regresa si es binario o no
     */
    public static boolean numeroBinario(long numero, int poss){
        String cadenaNum = String.valueOf(numero);
        char num = cadenaNum.charAt(poss);
        if(num == '2' || num == '3'  || num == '4' || num == '5' || num == '6' || num == '7' || num == '8' || num == '9'){
            return false;
        }else{
            if(poss==cadenaNum.length()-1){
                return true;
            }else{
                return numeroBinario(numero, poss+1);
            }
        }
    }


    /**
     * Transforma un numero a hexadecimal (base 16)
     * @param numero es el numero a transformar
     * @return Regresa el numero en hexadecimal
     */
    public static String aHexadecimal(int numero){
        String digito = "0123456789ABCDEF";
        int base = 16;
        if(numero>base-1){
            int residuo = numero%base;
            int division = Math.floorDiv(numero, base);
            return aHexadecimal(division) + digito.charAt(residuo);
        }else{
            return ""+digito.charAt(numero);
        }
    }

    /**
     * Transforma un numero a cualquier base
     * @param numero es el numero a transformar
     * @param base
     * @return Regresa el numero ya transformado
     */
    public static String aUnaBase(int numero, int base){
        String digito = "0123456789ABCDEF";
        if(numero>base-1){
            int residuo = numero%base;
            int division = Math.floorDiv(numero, base);
            return aUnaBase(division, base) + digito.charAt(residuo);
        }else{
            return ""+digito.charAt(numero);
        }
    }

    /**
     * Nos dice el MCD de 2 numero
     * @param numero1 es el primer numero
     * @param numero2 es el segundo numero
     * @return Regresa el MCD
     */
    public static int maximoComunDivisor(int numero1, int numero2){
        if(numero1!=numero2){
            if(numero1>numero2){
                numero1 = numero1-numero2;
                return maximoComunDivisor(numero1, numero2);
            } else {
                numero2 = numero2-numero1;
                return maximoComunDivisor(numero1, numero2);
            }
        }else{
            return numero1;
        }
    }

     /**
     * Transforma un numero decimal a binario
     * @param numero es el numero decimal
     * @return Regresa el numero binario
     */
    public static int decimalABinario(int numero){
        if(numero!=1){
            return numero%2 + decimalABinario(numero/2)*10;
        }else{
            return numero;
        }
    }

    public static int A(int m, int n){
        if(m==0){
            return n+1;
        } else if (m>0&&n==0) {
            return A(m-1,1);
        } else if (m>0&&n>0) {
            return A(m-1,A(m,n-1));
        }
        return 1;
    }
    public static int f(int x){
        if(x>11){
            return x;
        } else{
            return f(f(x+2)+f(x+2));
        }
    }
}
