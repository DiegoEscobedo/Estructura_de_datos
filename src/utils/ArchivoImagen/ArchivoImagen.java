package utils.ArchivoImagen;
import entradaSalida.SalidaPorDefecto;
import estructurasNoLineales.Matriz2Numerica;
import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;

/**
 * @author diego
 * @version 1.0
 */
public class ArchivoImagen {
    public BufferedImage imagen;
    public BufferedImage imagen2;
    public Matriz2Numerica matrizImagen;
    public int width;
    public int height;
    public String archivo;
    public String nomArchivo;
    public String rutaArchivo;

    public ArchivoImagen(String archivo){
        this.archivo = archivo;
        try{
            File file = new File(archivo);
            leerImagen();
            nomArchivo = file.getName();
            rutaArchivo = file.getParent();
            height = imagen.getHeight();
            width = imagen.getWidth();
        } catch (Exception e){
            System.err.println(e);
        }
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    /**
     * Lee la imagen y pasa los valores de los pixeles a una matriz bidimensional numérica.
     */
    public void leerImagen() {
        try {
            imagen = ImageIO.read(new File(archivo));
            matrizImagen = new Matriz2Numerica(imagen.getWidth(), imagen.getHeight());
            for(int cadaHeight = 0; cadaHeight < height; cadaHeight++){
                for(int cadaWidth = 0; cadaWidth < width; cadaWidth++){
                    matrizImagen.cambiar(cadaWidth, cadaHeight, imagen.getRGB(cadaWidth, cadaHeight));
                }
            }
        } catch (Exception e) {
        }
    }

    /**
     * lee una imagen
     * @param matriz Recibe la matriz en la que guarda los pixeles
     */
    public void leerImagen(Matriz2Numerica matriz) {
        try {
            imagen = ImageIO.read(new File(archivo));
            for(int cadaHeight = 0; cadaHeight < height; cadaHeight++){
                for(int cadaWidth = 0; cadaWidth < width; cadaWidth++){
                    matriz.cambiar(cadaWidth, cadaHeight, imagen.getRGB(cadaWidth, cadaHeight));
                }
            }
        } catch (Exception e) {
        }
    }

    /**
     * Escribe la imagen
     */
    public void escribirImagen(){
        try {
            imagen2 = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
            File file = new File(rutaArchivo + "/2_" + nomArchivo);
            for(int cadaHeight = 0; cadaHeight < height; cadaHeight++){
                for(int cadaWidth = 0; cadaWidth < width; cadaWidth++){
                    imagen2.setRGB(cadaWidth, cadaHeight, (int)matrizImagen.obtener(cadaWidth, cadaHeight));
                }
            }
            ImageIO.write(imagen2, "JPEG", file);
            SalidaPorDefecto.terminal("hi");
        } catch (Exception e){
            SalidaPorDefecto.terminal("Error: " + e);
        }
    }

    /**
     *Pasa la imagen a una escala de grises
     */
    public void aEscalaGrises() {
        for (int cadaHeight = 0; cadaHeight < height; cadaHeight++) {
            for (int cadaWidth = 0; cadaWidth < width; cadaWidth++) {
                int pixel = imagen.getRGB(cadaWidth, cadaHeight);
                int alpha = pixel >> 24 & 0xff;
                int red = pixel >> 16 & 0xff;
                int green = pixel >> 8 & 0xff;
                int blue = pixel & 0xff;
                int gris = (alpha + red + green + blue) / 4;
                int nuevoPixel = (gris << 24) + (gris << 16) + (gris << 8) + (gris);
                matrizImagen.cambiar(cadaWidth, cadaHeight, nuevoPixel);
            }
        }
    }

    /**
     * Modifica el brillo de la imagen
     * @param brillo Es el nivel de brillo
     */
    public void modificarBrillo(int brillo){
        for (int cadaHeight = 0; cadaHeight < height; cadaHeight++) {
            for (int cadaWidth = 0; cadaWidth < width; cadaWidth++) {
                int pixel = (imagen.getRGB(cadaWidth, cadaHeight))+brillo;
                int alpha = pixel >> 24 & 0xff;
                int red = pixel >> 16 & 0xff;
                int green = pixel >> 8 & 0xff;
                int blue = pixel & 0xff;
                int gris = (alpha + red + green + blue) / 4;
                int nuevoPixel = (gris << 24) + (gris << 16) + (gris << 8) + (gris);
                matrizImagen.cambiar(cadaWidth, cadaHeight, nuevoPixel);
            }
        }
    }

    /**
     * Voltea la imagen como en espejo
     */
    public void invertirImagen() {
        Matriz2Numerica matrizClonada = matrizImagen.clonar();
        for (int cadaHeight = 0; cadaHeight < height; cadaHeight++) {
            int nuevoWidth = 0;
            for (int cadaWidth = width - 1; cadaWidth >= 0; cadaWidth--) {
                matrizImagen.cambiar(nuevoWidth, cadaHeight, matrizClonada.obtener(cadaWidth, cadaHeight));
                nuevoWidth++;
            }
            nuevoWidth = 0;
        }
    }

    /**
     * Voltea la imagen de cabeza
     */
    public void invertirImagenDeCabeza() {
        Matriz2Numerica matrizClonada = matrizImagen.clonar();
        int nuevoHeight = 0;
        for (int cadaHeight = height - 1; cadaHeight >= 0; cadaHeight--) {
            int nuevoWidth = 0;
            for (int cadaWidth = 0; cadaWidth < width; cadaWidth++) {
                matrizImagen.cambiar(nuevoWidth, nuevoHeight, matrizClonada.obtener(cadaWidth, cadaHeight));
                nuevoWidth++;
            }
            nuevoWidth = 0;
            nuevoHeight++;
        }
    }

    /**
     * gira l aimagen a ciertos grados;
     * @param grados Son los grados a invertir
     * @return Regresa falsé si los grados son invalidos
     */
    public boolean girarImagen(int grados){
        Matriz2Numerica matrizAuxliar = new Matriz2Numerica(height, width);
        if(grados == 90){
            for(int cadaHeight = getWidth()-1; cadaHeight >=0 ; cadaHeight--){
                int nuevo =0;
                for(int cadaWidth = getHeight()-1; cadaWidth >=0 ; cadaWidth--){
                    matrizAuxliar.cambiar(nuevo, cadaHeight, matrizImagen.obtener(cadaHeight, cadaWidth));
                    nuevo ++;
                }
            }
            setHeight(matrizAuxliar.getColumnas());
            setWidth(matrizAuxliar.getRenglones());
            matrizImagen.redefinir(matrizAuxliar);

            return true;
        }else if(grados == 180){
            Matriz2Numerica matrizClonada = matrizImagen.clonar();
            int nuevoHeight = 0;
            for(int cadaHeight = height-1; cadaHeight >= 0; cadaHeight--){
                int nuevoWidth = 0;
                for(int cadaWidth = width-1; cadaWidth >= 0; cadaWidth--){
                    matrizImagen.cambiar(nuevoWidth, nuevoHeight, matrizClonada.obtener(cadaWidth, cadaHeight));
                    nuevoWidth++;
                }
                nuevoWidth = 0;
                nuevoHeight++;}
            return true;
        }else if (grados == 270) {
            for(int cadaHeight = 0; cadaHeight < getWidth(); cadaHeight++){
                for(int cadaWidth = 0; cadaWidth < getHeight(); cadaWidth++){
                    matrizAuxliar.cambiar(cadaWidth, cadaHeight, matrizImagen.obtener(cadaHeight, cadaWidth));
                }
            }
            setWidth(matrizAuxliar.getRenglones());
            setHeight(matrizAuxliar.getColumnas());
            matrizImagen.redefinir(matrizAuxliar);
            return true;
        }else{
            return false;
        }
    }

    /**
     * Aplica el metodo de trnaspuesta
     */
    public void aplicarTranspuesta(){
        Matriz2Numerica matrizAuxiliar = matrizImagen.clonar();
        matrizAuxiliar.transpuesta();
        setWidth(matrizAuxiliar.getRenglones());
        setHeight(matrizAuxiliar.getColumnas());
        matrizImagen.redefinir(matrizAuxiliar);
    }

    /**
     * Agrega marco a la imagen
     * @param pixeles Son los pixeles del marco
     * @param color Es el color del marco
     */
    public void nuevoMarco(int pixeles, Color color){
        int nuevoWidth = width+(2*pixeles);
        int nuevoHeight = height+(2*pixeles);
        Matriz2Numerica matrizAuxiliar = new Matriz2Numerica(nuevoWidth, nuevoHeight);
        for(int cadaHeight = 0; cadaHeight < nuevoHeight; cadaHeight++){
            for(int cadaWidth = 0; cadaWidth < nuevoWidth; cadaWidth++){
                matrizAuxiliar.cambiar(cadaWidth, cadaHeight, color.getRGB());
            }
        }
        for(int cadaHeight = pixeles; cadaHeight < nuevoHeight-pixeles; cadaHeight++){
            for(int cadaWidth = pixeles; cadaWidth <nuevoWidth-pixeles; cadaWidth++){
                matrizAuxiliar.cambiar(cadaWidth, cadaHeight, matrizImagen.obtener(cadaWidth-pixeles, cadaHeight-pixeles));
            }
        }
        setHeight(nuevoHeight);
        setWidth(nuevoWidth);
        matrizImagen.redefinir(matrizAuxiliar);
    }

    /**
     * Este metodo es creado por mi y sobrepone un aimagen a la original
     */
    public void agregarImagen(){
        ArchivoImagen imagenNueva = new ArchivoImagen("D:\\Estructura_de_datos\\imagenAgregada.jpg");
        Matriz2Numerica matrizAuxiliar = new Matriz2Numerica(imagenNueva.getWidth(), imagenNueva.getHeight());
        imagenNueva.leerImagen(matrizAuxiliar);
        for(int cadaHeight = 0; cadaHeight < imagenNueva.height; cadaHeight++){
            for(int cadaWidth = 0; cadaWidth < imagenNueva.width; cadaWidth++){
                matrizImagen.cambiar(cadaWidth, cadaHeight, matrizAuxiliar.obtener(cadaWidth, cadaHeight));
            }
        }
    }
}











