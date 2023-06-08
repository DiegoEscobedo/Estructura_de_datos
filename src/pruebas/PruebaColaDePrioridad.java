package pruebas;

import ObjetosConPrioridad.FilaEnfermos;
import ObjetosConPrioridad.Proceso;
import entradaSalida.SalidaPorDefecto;
import estructurasLineales.ColaDePrioridad;

public class PruebaColaDePrioridad {
    public static void main(String[] args) {
        ColaDePrioridad colaPrioridad = new ColaDePrioridad(5);
        Proceso ejecutando1 = new Proceso("Arranque del SO..", 1);
        Proceso ejecutando2 = new Proceso("Cargando unidades de Almacenamiento..", 2);
        Proceso ejecutando3 = new Proceso("Iniciando complementos..", 4);
        Proceso ejecutando4 = new Proceso("Finalizando el arranque..", 5);
        Proceso ejecutando5 = new Proceso("Iniciando escritorio...", 3);
        colaPrioridad.poner(ejecutando1);
        colaPrioridad.poner(ejecutando2);
        colaPrioridad.poner(ejecutando3);
        colaPrioridad.poner(ejecutando4);
        colaPrioridad.poner(ejecutando5);
        SalidaPorDefecto.terminal("Procesos faltantes ..." + "\n");
        colaPrioridad.imprimir();
        SalidaPorDefecto.terminal("\n");
        SalidaPorDefecto.terminal("Procesos faltantes ..." + "\n");
        colaPrioridad.quitar();
        colaPrioridad.imprimir();
        SalidaPorDefecto.terminal("\n");
        SalidaPorDefecto.terminal("Procesos faltantes ..." + "\n");
        colaPrioridad.quitar();
        colaPrioridad.imprimir();
        SalidaPorDefecto.terminal("\n");
        SalidaPorDefecto.terminal("Procesos faltantes ..." + "\n");
        colaPrioridad.quitar();
        colaPrioridad.imprimir();
        SalidaPorDefecto.terminal("\n");
        SalidaPorDefecto.terminal("Procesos faltantes ..." + "\n");
        colaPrioridad.quitar();
        colaPrioridad.imprimir();
    }
}
