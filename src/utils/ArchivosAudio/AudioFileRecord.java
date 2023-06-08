package utils.ArchivosAudio;

import java.io.*;

import entradaSalida.SalidaPorDefecto;
import estructurasLineales.ListaEstaticaNumerica;
import utils.ArchivosAudio.wavfile.WavFile;

/**
 * @author diego
 * @version1.0 
 */
public class AudioFileRecord {
    private long numFrames;  //numero de tramas, número de muestras totales del archivo por canal
    private long sampleRate; //numero de muestras por segundo a la que se discretiza la señal
    private int numChannels; //número de canales
    private double[] buffer; //audio original
    private ListaEstaticaNumerica buffer2; //audio modificado
    private String archivo;   //nombre de archivo dado por el usuario
    private WavFile wavFileR; //apuntador de archivo leido
    private WavFile wavFileW;  //apuntador de archivo a escribir
    private String nomArchivo; //nombre archivo (uno.wav)
    private String nomRuta;    //ruta donde esta guardado el archivo (/home)
    private int validBits;     //bits usados para la discretización


    public ListaEstaticaNumerica getBuffer2(){
        return buffer2;
    }

    public double[] getBuffer(){
        return buffer;
    }
    public AudioFileRecord(String archivo) {
        this.archivo = archivo;
        // Abre el archivo wav y asigna parámetros a las variables
        try {
            File file = new File(archivo);
            wavFileR = WavFile.openWavFile(file);
            nomArchivo = file.getName();
            nomRuta = file.getParent();
        } catch (Exception e) {

        }
        numChannels = wavFileR.getNumChannels();
        numFrames = wavFileR.getNumFrames();
        sampleRate = wavFileR.getSampleRate();
        validBits=wavFileR.getValidBits();
    }

    /**
     * Este método es utilizado para leer un archivo tipo wav.
     */
    public void leerAudio() {
        try {

            // Muestra datos del archivo
            wavFileR.display();

            // Crea buffer de origen y de temporal
            buffer = new double[(int) numFrames * numChannels];
            buffer2 = new ListaEstaticaNumerica(buffer.length);

            //tramas leidas
            int framesRead;

            // Lee tramas totales
            framesRead = wavFileR.readFrames(buffer, (int) numFrames);

            // Recorrer todas las tramas del archivo y guardarlas en el arreglo.
            buffer2.recibeBuffer(buffer);
//            for (int s = 0; s < framesRead * numChannels; s++) {
//                buffer2[s] = buffer[s];
//            }

            // Cierra archivo
            wavFileR.close();
        } catch (Exception e) {
            System.err.println(e);
        }
    }

    /**
     * Este método toma una lista estática numérica y conforme a los valores de esta lo escribe en un nuevo archivo wav.
     * @param listaEstaticaNumerica Es la lista parámetro que contiene valores asociados a ondas sonoras que se convertirá en un archivo wav.
     */
    public void escribirAudio(ListaEstaticaNumerica listaEstaticaNumerica) {
        try {

            //Crear el apuntador al archivo para guardar datos del temporal
            File file = new File(nomRuta + "/2_" + nomArchivo);

            // Creamos un nuevo archivo de audio con los mismos datos que el original
            wavFileW = WavFile.newWavFile(file, numChannels, numFrames, validBits, sampleRate);

            // Escribimos los frames o muestras totales del temporal
            wavFileW.writeFrames(listaEstaticaNumerica.leerArregloNumerico(), (int) numFrames);

            // Cerramos el archivo
            wavFileW.close();
        } catch (Exception e) {
            System.err.println(e);
        }
    }

    /**
     * Aplica un filtro FIR a las frecuencias del arreglo buffer 2, donde guardamos todas las frecuencias del archivo wav.
     */
    public void preEnfasis(){
        for(int indiceArreglo = 1; indiceArreglo < buffer2.getTope(); indiceArreglo++){
            buffer2.cambiar(indiceArreglo, (double) buffer2.obtener(indiceArreglo) + (0.97 * (double) buffer2.obtener(indiceArreglo - 1)));
        }
    }

    /**
     * Multiplica la lista numérica (buffer2) por un entero lo que simulará que sube el volumen.
     * @param intensidad Número entero que queremos aumentar el volumen.
     */
    public void subirVolumen(int intensidad){
        buffer2.porEscalar(intensidad);
    }

    /**
     * Multiplica la lista numérica (buffer2) por un uno sobre el entero lo que simulará que baje el volumen.
     * @param intensidad Número entero que queremos bajar el volumen.
     */
    public void bajarVolumen(int intensidad){
        buffer2.porEscalar((double)1/intensidad);
    }

    /**
     * Realiza el promedio de los dos valores pasados como parámetros.
     * @param primerValor Valor del primero número.
     * @param segundoValor Valor del segundo número.
     * @return Regresa el valor double del promedio de los dos valores.
     */
    public double promedio(Number primerValor, Number segundoValor){
        return ((double) primerValor + (double) segundoValor)/2;
    }

    /**
     * Realiza el promedio de dos índices juntos y los añade a otra lista, la cual será el audio acelerado por el entero que lo queramos acelerar.
     * @param acelerador Es el valor por el cual queremos acelerar el audio.
     * @return Regresa una lista numérica que será el nuevo audio acelerado.
     */
    public ListaEstaticaNumerica acelerarAudio(int acelerador){
        ListaEstaticaNumerica audioAcelerado = new ListaEstaticaNumerica(((int) numFrames * numChannels)/acelerador);
        for(int indiceArreglo = 0; indiceArreglo < (int) numFrames * numChannels; indiceArreglo = indiceArreglo+acelerador){
            audioAcelerado.agregar(promedio((double)buffer2.obtener(indiceArreglo), (double) buffer2.obtener(indiceArreglo + 1)));
        }
        return audioAcelerado;
    }

    /**
     * Realiza el promedio de dos índices juntos y los añade a otra lista y añade el primer índice, lo cual alentará el audio.
     * @param alentador Es el valor por el cual queremos alentar el audio.
     * @return Regresa una lista numérica que será el nuevo audio pero ahora lento.
     */
    public ListaEstaticaNumerica alentarAudio(int alentador){
        ListaEstaticaNumerica audioLento = new ListaEstaticaNumerica(((int) numFrames * numChannels) * alentador + 1);
        for(int indiceArreglo = 0; indiceArreglo < ((int) numFrames * numChannels)-1; indiceArreglo++){
            audioLento.agregar(buffer2.obtener(indiceArreglo));
            for(int indiceAlentador = 0; indiceAlentador < alentador; indiceAlentador++){
                audioLento.agregar(promedio((double) buffer2.obtener(indiceArreglo), (double) buffer2.obtener(indiceArreglo + 1)));
            }
        }
        return audioLento;
    }

    /**
     * Remueve el silencio que esté en el archivo wav.
     */
    public ListaEstaticaNumerica removerSilencio(){
        ListaEstaticaNumerica listanueva = new ListaEstaticaNumerica(buffer2.getMAXIMO());
        for (int indiceArreglo = 0; indiceArreglo < buffer2.getMAXIMO(); indiceArreglo++) {
            double objeto = (double) buffer2.obtener(indiceArreglo);
            if (objeto > 0.001 || objeto < -0.001) {
                listanueva.agregar(objeto);
            }
        }
        return listanueva;
    }

    /**
     * Invierte el audio para que esté en reversa.
     */
    public void reversoX(){
        buffer2.invertir();
    }

    /**
     * Invierte el audio para que se voltee de cabeza.
     */
    public void reversoY(){
        buffer2.porEscalar(-1);
    }

    /**
     * Regresa la energia de el audio
     * @return Es la energia
     */
    public double energia(){
        return buffer2.productoEscalar(buffer2);
    }

}