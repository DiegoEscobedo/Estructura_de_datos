package pruebas;

import utils.ArchivosAudio.AudioFileRecord;

public class PruebaAudioFileRecord {
    public static void main(String[] args) {
        AudioFileRecord audio = new AudioFileRecord("D:\\Estructura_de_datos\\src\\utils\\ArchivosAudio\\wavfile\\archivo.wav");
        audio.leerAudio();
        audio.preEnfasis();
        audio.getBuffer2().imprimir();

        //audio.EscribirAudio(audio.getBuffer2());
        //SalidaPorDefecto.terminal(""+ Arrays.toString(audio.getBuffer()));
    }
}
