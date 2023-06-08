package pruebas;

import entradaSalida.SalidaPorDefecto;
import utilerias.matematicas.ExpresionesMatematicas;

public class PruebaPilaEM {
    public static void main(String[] args) {
        SalidaPorDefecto.terminal("Dame la operacion a realizar: \n");
        String infija = entradasalida.EntradaPorDefecto.consolaCadenas();
        String prefija = ExpresionesMatematicas.infijaAPrefija(infija);
        SalidaPorDefecto.terminal(""+ ExpresionesMatematicas.evaluarPrefija(prefija));
    }
}