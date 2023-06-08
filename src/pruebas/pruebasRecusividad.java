package pruebas;

import entradaSalida.SalidaPorDefecto;
import utilerias.matematicas.RecursividadMatematica;

public class pruebasRecusividad {
    public static void main(String[] args) {

        /*
        SalidaPorDefecto.terminal(""+RecursividadMatematica.numeroBinario(1010416, 0) + "\n");
        SalidaPorDefecto.terminal(""+RecursividadMatematica.numeroBinario(101010, 0) + "\n");
        SalidaPorDefecto.terminal(""+RecursividadMatematica.aHexadecimal(65029)+ "\n");
        SalidaPorDefecto.terminal(""+RecursividadMatematica.aUnaBase(65029, 10)+ "\n");
        SalidaPorDefecto.terminal(""+RecursividadMatematica.maximoComunDivisor(412, 184)+ "\n");
        SalidaPorDefecto.terminal(""+RecursividadMatematica.decimalABinario(13)+ "\n");
        */
        SalidaPorDefecto.terminal(""+RecursividadMatematica.f(13)+ "\n");
        SalidaPorDefecto.terminal(""+RecursividadMatematica.f(13)+ "\n");
    }
}