package pruebas;

import entradaSalida.SalidaPorDefecto;
import estructurasLineales.ListaDinamica;
import registro.empresas.Empleado2;
import registro.empresas.Empresa2;

public class PruebaEmpresa {
    public static void main(String[] args) {
        Empresa2 empresa2 = new Empresa2("Patito SA", 5);

        ListaDinamica comisiones1 = new ListaDinamica();
        comisiones1.agregar(450.3);
        comisiones1.agregar(849.3);
        comisiones1.agregar(389.5);
        comisiones1.agregar(689.4);
        Empleado2 empleado1 = new Empleado2(101, "Juan", 30, comisiones1);

        ListaDinamica comisiones2 = new ListaDinamica();
        comisiones2.agregar(890.2);
        comisiones2.agregar(634.2);
        comisiones2.agregar(555.1);
        Empleado2 empleado2 = new Empleado2(115, "Roberto", 28, comisiones2);

        empresa2.agregarEmpleado(empleado1);
        empresa2.agregarEmpleado(empleado2);

        empresa2.imprimirDatosEmpresa();
        SalidaPorDefecto.terminal("\n");
        SalidaPorDefecto.terminal("----------------------------------------");
        empresa2.imprimirDatosEmpresaDetalle();

        SalidaPorDefecto.terminal("El promedio de comisiones de Juan es: " + empresa2.obtenerPromedioEmpleado(empleado1));
    }
}
