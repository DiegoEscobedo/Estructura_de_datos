package pruebas;

import entradaSalida.SalidaPorDefecto;
import utils.ArchivoImagen.*;

import java.awt.*;

public class PruebaImagen {
    public static void main(String[] args) {
        ArchivoImagen imagen = new ArchivoImagen("D:\\Estructura_de_datos\\teahub.io-abc-wallpaper-1670183.jpg");
        imagen.leerImagen();
        imagen.agregarImagen();
        imagen.escribirImagen();
    }
}
