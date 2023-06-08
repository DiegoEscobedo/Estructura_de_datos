package utils.ArchivoTexto;

import entradaSalida.SalidaPorDefecto;
import estructurasLineales.ListaEstatica;
import registro.Indice.Orden;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

public class ArchivoTexto {
    public static ListaEstatica leerArchivoTabla(String archivoSrtring, int posicion) throws IOException {
        String indice = "";
        String direccion = "";
        ListaEstatica cadena = new ListaEstatica(2);
        boolean finArchivo = false;
        String cad = "";
        RandomAccessFile archivo = null;
        try {
            archivo = new RandomAccessFile(archivoSrtring, "r");
            System.out.println("El tamaño es: " + archivo.length());
            int contador = 0;
            while (contador<posicion+1) {
                cad = archivo.readLine();
                contador++;
            }
        } catch (FileNotFoundException fe) {
            System.out.println("No se encontro el archivo");
        }
        System.out.println("\n");
        archivo.seek(archivo.getFilePointer());
        direccion = String.valueOf(archivo.getFilePointer());
        if(cad!=null) {
            for (int i = 0; i < cad.length(); i++) {
                char caracter = cad.charAt(i);
                if (caracter == ',') {
                    break;
                }
                indice += caracter;
            }
        }
        cadena.agregar(indice);
        cadena.agregar(direccion);
        System.out.println("\n" + cadena.obtener(0) + cadena.obtener(1));
        archivo.close();
        return cadena;
    }
    public static ListaEstatica leerArchivoTabla2(String archivoSrtring, int posicion) throws IOException {
        String indice = "";
        String direccion = "";
        ListaEstatica cadena = new ListaEstatica(2);
        String cad = "";
        RandomAccessFile archivo = null;
        try {
            archivo = new RandomAccessFile(archivoSrtring, "r");
            System.out.println("El tamaño es: " + archivo.length());
            int contador = 0;
            while (contador<posicion+1) {
                cad = archivo.readLine();
                contador++;
            }
        } catch (FileNotFoundException fe) {
            System.out.println("No se encontro el archivo");
        }
        System.out.println("\n");
        archivo.seek(archivo.getFilePointer());
        direccion = String.valueOf(archivo.getFilePointer());
        if(cad!=null) {
            for (int i = 5; i < cad.length(); i++) {
                char caracter = cad.charAt(i);
                if (caracter == ',') {
                    break;
                }
                indice += caracter;
            }
        }
        cadena.agregar(indice);
        cadena.agregar(direccion);
        System.out.println("\n" + cadena.obtener(0) + cadena.obtener(1));
        archivo.close();
        return cadena;
    }
    public static ListaEstatica buscar(String archivoSrtring, int posicion) throws IOException {
        ListaEstatica cadena = new ListaEstatica(8);
        String cad = "";
        RandomAccessFile archivo = null;
        try {
            archivo = new RandomAccessFile(archivoSrtring, "r");
            System.out.println("El tamaño es: " + archivo.length());

        } catch (FileNotFoundException fe) {
            System.out.println("No se encontro el archivo");
        }
        System.out.println("\n");
        archivo.seek(posicion);
        cad = archivo.readLine();
        int posicionchar = 0;
        String valores = "";
        while(posicionchar<cad.length()){
            char caracter = cad.charAt(posicionchar);
            if(caracter==','){
                cadena.agregar(valores);
                valores = "";
                posicionchar++;
            }else {
                valores += caracter;
                posicionchar++;
            }
        }
        archivo.close();
        return cadena;
    }
}
