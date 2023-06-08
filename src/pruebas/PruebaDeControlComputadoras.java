package pruebas;

import entradaSalida.SalidaPorDefecto;
import registro.controlEscuela.Aplicacion;
import registro.controlEscuela.Computadora;
import registro.controlEscuela.ControlComputadora;
import registro.controlEscuela.Usuario;

public class PruebaDeControlComputadoras {
    public static void main(String[] args) {
        ControlComputadora control = new ControlComputadora("UAZ");

        Usuario user1 = new Usuario("Diego");
        Usuario user2 = new Usuario("Aratt");
        Usuario user3 = new Usuario("Jesus");
        Usuario user4 = new Usuario("Valeria");

        Computadora computadora = new Computadora(01, "CC1", 16, 500,
                "AMD5", "Huawei");
        Computadora computadora2 = new Computadora(02, "CC1", 4, 500,
                "AMD5", "Huawei");
        Computadora computadora3 = new Computadora(03, "CC1", 8, 500,
                "MACOS", "Apple");

        Aplicacion app1 = new Aplicacion("Chrome", "x", "Francisco Goytia", 2);
        Aplicacion app2 = new Aplicacion("Rocket League", "x", "Ubisoft Games", 8);
        Aplicacion app3 = new Aplicacion("Word", "x", "Microsoft", 2);

        control.agregarComputadora(computadora);
        control.agregarComputadora(computadora2);
        control.agregarComputadora(computadora3);
        SalidaPorDefecto.terminal("Imprimir lista de computadoras" + "\n");
        control.imprimirComputadoras();
        SalidaPorDefecto.terminal("\n");
        SalidaPorDefecto.terminal("Imprimir computadora no. 02 con sus aplicaciones" + "\n");
        control.imprimirComputadora(02);
        SalidaPorDefecto.terminal("\n");
        SalidaPorDefecto.terminal("Agreagar todas las aplicaciones a computadoras" + "\n");
        control.agregarApps(01, app1);
        control.agregarApps(01, app2);
        control.agregarApps(01, app3);
        control.agregarApps(02, app1);
        control.agregarApps(02, app2);
        control.agregarApps(02, app3);
        control.agregarApps(03, app1);
        control.agregarApps(03, app2);
        control.agregarApps(03, app3);
        SalidaPorDefecto.terminal("\n");
        SalidaPorDefecto.terminal("Eliminar aplicacion 2 a computadora no. 03" + "\n");
        control.eliminarApps(03,app2);
        SalidaPorDefecto.terminal("\n");
        SalidaPorDefecto.terminal("Dar de alta nueva computadora" + "\n");
        Computadora computadora4 = new Computadora(04, "CC1", 32, 500,
                "intel9", "Samsung");
        control.agregarComputadora(computadora4);
        SalidaPorDefecto.terminal("\n");
        SalidaPorDefecto.terminal("Dar de baja la nueva computadora pq la neta ni servia" + "\n");
        control.eliminarComputadora(computadora4);
        SalidaPorDefecto.terminal("\n");
        SalidaPorDefecto.terminal("Buscar computadoras con Chrome instalado" + "\n");
        control.computadorasConAplicacion("Chrome").imprimir();
        SalidaPorDefecto.terminal("\n");
        SalidaPorDefecto.terminal("Buscar computadoras con la RAM suficiente para correr Rocket League" + "\n");
        control.puedenCorrerApp(app2).imprimir();
        SalidaPorDefecto.terminal("\n");
        SalidaPorDefecto.terminal("El usuario Diego uso la computadora 01"+ "\n");
        computadora.agregarUser(user1);
        SalidaPorDefecto.terminal("El usuario Aratt uso la computadora 02" +"\n");
        computadora2.agregarUser(user2);
        SalidaPorDefecto.terminal("El usuario Diego uso la computadora 03" + "\n");
        computadora3.agregarUser(user1);
        SalidaPorDefecto.terminal("El usuario Angel uso la computadora 01" + "\n");
        computadora.agregarUser(user3);
        SalidaPorDefecto.terminal("Imprimr los usuarios de la computadora 1" +"\n");
        control.usuariosQueUsaronComputadora(computadora);
        SalidaPorDefecto.terminal("\n");
        SalidaPorDefecto.terminal("El usuario Diego uso Rocket League" + "\n");
        user1.usoAplicacion(app2);
        SalidaPorDefecto.terminal("El usuario Aratt uso Rocket League" + "\n");
        user2.usoAplicacion(app2);
        SalidaPorDefecto.terminal("El usuario Angel uso Chrome"+ "\n");
        user3.usoAplicacion(app1);
        SalidaPorDefecto.terminal("El usuario Diego uso Word"+ "\n");
        user1.usoAplicacion(app3);
        SalidaPorDefecto.terminal("El usuario Diego dejo de usar la computadora 01" + "\n");
        computadora.dejoDeUsarCompu(user1);
        SalidaPorDefecto.terminal("El usuario Aratt dejo de usar la computadora 02"  + "\n");
        computadora2.dejoDeUsarCompu(user2);
        SalidaPorDefecto.terminal("El usuario Diego dejo de usar la computadora 03" + "\n");
        computadora.dejoDeUsarCompu(user1);
        SalidaPorDefecto.terminal("El usuario Angel dejo de usar la computadora 01" + "\n");
        computadora.dejoDeUsarCompu(user3);
        SalidaPorDefecto.terminal("\n");
        SalidaPorDefecto.terminal("Imprimir días y horas que el usuario Diego ha usado computadoras. Así como que CC la tiene." + "\n");
        control.tiempoDeUso("Diego");
        SalidaPorDefecto.terminal("\n");
        SalidaPorDefecto.terminal("Imprimir aplicaciones que el usuario uso en la fecha abr 01 2023" + "\n");
        control.imprimirAplicacionesQueUso(user1, "abr 01 2023");
        SalidaPorDefecto.terminal("\n");
        SalidaPorDefecto.terminal("Usuarios que no usan el centro de computo:" + "\n");
        control.usuariosQueNoUsanElCC().imprimir();


    }

}
