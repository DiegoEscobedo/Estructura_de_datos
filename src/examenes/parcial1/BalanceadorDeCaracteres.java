package examenes.parcial1;

import entradaSalida.SalidaPorDefecto;
import entradaSalida.archivos.ArchivoTexto;
import estructurasLineales.ListaEstatica;
import estructurasLineales.PilaEstatica;

import java.util.StringTokenizer;

import static utilerias.matematicas.ExpresionesMatematicas.esOperando;
import static utilerias.matematicas.ExpresionesMatematicas.noEsNumero;

public class BalanceadorDeCaracteres {
    // constantes DE los colores de la terminal.
    private static final String ROJO = "\u001B[31m";
    private static final String MORADO = "\u001B[35m";
    private static final String VERDE = "\u001B[32m";
    public static final String BLANCO = "\u001B[0m";
    private PilaEstatica pilaDeCaracteres;
    private PilaEstatica pilaDeEspacios;
    private PilaEstatica pilaDeVariables;
    int accion;
    String rutaArchivo;
    String cadena;
    /**
     * Este método muestra el menu de las opciones para el usuario.
     */
    public void Menu(){
        do {
            SalidaPorDefecto.terminal("1) Leer un archivo" + "\n");
            SalidaPorDefecto.terminal("2) Leer una cadena" + "\n");
            SalidaPorDefecto.terminal("3) Salir" + "\n");
            SalidaPorDefecto.terminal("Elige una opcion... ");
            accion = entradasalida.EntradaPorDefecto.consolaDouble().intValue();
            switch (accion) {
                case 1 -> {
                    SalidaPorDefecto.terminal("Ingresa la ruta del archivo: ");
                    rutaArchivo = entradasalida.EntradaPorDefecto.consolaCadenas();
                    balaceaArchivo(rutaArchivo);
                }
                case 2 -> {
                    SalidaPorDefecto.terminal("Ingresa la cadena: ");
                    cadena = entradasalida.EntradaPorDefecto.consolaCadenas();
                    balaceaCadena(cadena, 1);
                }
                case 3 -> SalidaPorDefecto.terminal(MORADO + "Saliendo...");
                default -> SalidaPorDefecto.terminal( MORADO + "*** Opcion Invalida ***" + BLANCO + "\n");
            }
        } while (accion != 3);
    }

    public void balaceaArchivo(String rutaArchivo){
        ListaEstatica listaArchivo = ArchivoTexto.leer(rutaArchivo);
        if (listaArchivo != null) {
            // Recorrer la lista línea por línea y balancear cada línea de la lista, y mostrar los errores de cada línea;
            int numLinea = 1;
            int indice = 0;
            while (indice <= listaArchivo.getTope()) {
                String linea = (String) listaArchivo.obtener(indice);
                balaceaCadena(linea, numLinea);
                numLinea++;
                indice++;
            }
        } else {
            SalidaPorDefecto.terminal(ROJO +"*** No se pudo leer el archivo ***" + BLANCO +"\n");
        }
    }
    public StringBuilder contadorDeEspacios(){
        int espacios = (int)pilaDeEspacios.verTope();
        StringBuilder cadenaDeEspacios = new StringBuilder();
        cadenaDeEspacios.append(" ".repeat(Math.max(0, espacios)));
        return cadenaDeEspacios;
    }

    public void balaceaCadena(String cadena, int numeroDeLinea){
        pilaDeCaracteres = new PilaEstatica(cadena.length());
        pilaDeEspacios = new PilaEstatica(cadena.length());
        ListaEstatica listaCadena = new ListaEstatica(cadena.length());
        for (int cadaElemento = 0;  cadaElemento < cadena.length(); cadaElemento++) {
            char caracter = cadena.charAt(cadaElemento);
            listaCadena.agregar(caracter);
        }
        int cadaCaracter = 0;
        int espacios = 0;
        while (cadaCaracter < listaCadena.cantidad()){
            char caracter = (char) listaCadena.obtener(cadaCaracter);
            if (caracter == '(' || caracter == '[' || caracter == '{') {
                pilaDeCaracteres.poner(caracter);
                pilaDeEspacios.poner(espacios);
            } else if (caracter == ')' || caracter == ']' || caracter == '}') {
                if (pilaDeCaracteres.vacio()) {
                    pilaDeCaracteres.poner(caracter);
                    pilaDeEspacios.poner(espacios);
                } else {
                    pilaDeCaracteres.quitar();
                    pilaDeEspacios.vacio();
                }
            }
            espacios++;
            cadaCaracter++;
        }
        if (pilaDeCaracteres.vacio() && cadaCaracter == listaCadena.cantidad()) {
            SalidaPorDefecto.terminal( VERDE + "La linea " + numeroDeLinea + " no tiene errores" + BLANCO + "\n");
        } else {
            while (!pilaDeCaracteres.vacio()) {
                char caracter = (char) pilaDeCaracteres.quitar();
                if (caracter == '(') {
                    SalidaPorDefecto.terminal(cadena + "\n" + contadorDeEspacios() + ROJO + "^ Error: Falta un ')'" + " en la linea " +
                            numeroDeLinea +  BLANCO + "\n");
                } else if (caracter == '[') {
                    SalidaPorDefecto.terminal(cadena + "\n" + contadorDeEspacios() +ROJO + "^ Error: Falta un ']'" + " en la linea " +
                            numeroDeLinea + BLANCO + "\n");
                } else if (caracter == '{') {
                    SalidaPorDefecto.terminal(cadena + "\n" + contadorDeEspacios() +ROJO + "^ Error: Falta un '}'" + " en la linea " +
                            numeroDeLinea + BLANCO + "\n");
                } else if (caracter == ')') {
                    SalidaPorDefecto.terminal(cadena + "\n" + contadorDeEspacios() +ROJO + "^ Error: Falta un '('" + " en la linea " +
                            numeroDeLinea + BLANCO + "\n");
                } else if (caracter == ']') {
                    SalidaPorDefecto.terminal(cadena + "\n" + contadorDeEspacios() +ROJO + "^ Error: Falta un '['" + " en la linea " +
                            numeroDeLinea + BLANCO + "\n");
                } else if (caracter == '}') {
                    SalidaPorDefecto.terminal(cadena + "\n" + contadorDeEspacios() +ROJO + "^ Error: Falta un '{'" + " en la linea " +
                            numeroDeLinea + BLANCO + "\n");
                } else {
                    SalidaPorDefecto.terminal(cadena + "\n" + contadorDeEspacios() + ROJO + " Error: Caracter invalido" + BLANCO + "\n");
                }
                pilaDeEspacios.quitar();
            }
        }
    }

    public void validarVariables(String cadena, int numeroDeLinea){
        pilaDeVariables = new PilaEstatica(cadena.length());
        ListaEstatica listaCadena = new ListaEstatica(cadena.length());
        for (int cadaElemento = 0;  cadaElemento < cadena.length(); cadaElemento++) {
            char caracter = cadena.charAt(cadaElemento);
            listaCadena.agregar(caracter);
        }
        String variable = "";
        int cadaCaracter = 0;
        while (cadaCaracter < listaCadena.cantidad()) {
            char caracter = (char) listaCadena.obtener(cadaCaracter);
            while(caracter != ' ' && esOperando(caracter + "") && noEsNumero(caracter + "")){
                variable += caracter;
                caracter = (char) listaCadena.obtener(cadaCaracter++);
            }
            if(variable.equals("suma") || variable.equals("promedio") || variable.equals("x") || variable.equals("y") || variable.equals("z") || variable.equals("variable")) {
                pilaDeVariables.poner(variable);
            }
            cadaCaracter++;
        }
        cadaCaracter = 0;
        while (cadaCaracter < listaCadena.cantidad()) {
            char caracter = (char) listaCadena.obtener(cadaCaracter);
            while(caracter != ' ' && esOperando(caracter + "") && noEsNumero(caracter + "")){
                variable += caracter;
                caracter = (char) listaCadena.obtener(cadaCaracter++);
            }
            if(variable.equals("suma=") || variable.equals("promedio=") || variable.equals("x=") || variable.equals("y=") || variable.equals("z=") || variable.equals("variable=")) {
                pilaDeVariables.quitar();
            }
            cadaCaracter++;
        }
    }
}
