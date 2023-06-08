package registro.empresas;

import entradaSalida.SalidaPorDefecto;
import estructurasLineales.ListaDinamica;

/**
 * @version1.0
 * @autor:Clase ED
 */
public class Empresa2 {
    protected String nombre;
    protected ListaDinamica empleados;

    public Empresa2(String nombre, int cantidadEmpleados) {
        this.nombre = nombre;
        this.empleados = new ListaDinamica();
    }

    public Empresa2(String nombre) {
        this.nombre = nombre;
    }

    public boolean agregarEmpleado(Empleado2 objetoEmpleado) {
        Object retornoEmpleado = empleados.buscar(objetoEmpleado);
        if (retornoEmpleado == null) {
            int retornoPosicionE = empleados.agregar(objetoEmpleado);
            if (retornoPosicionE >= 0) {
                return true;
            } else {
                return false;
            }
        }else{
            return false;}
    }

    public void imprimirDatosEmpresa(){
        SalidaPorDefecto.terminal("Los datos de la empresa " + nombre + " son: \n");
        empleados.imprimir();
    }
    public void imprimirDatosEmpresaDetalle() {
        SalidaPorDefecto.terminal("Los datos de la empresa " + nombre + " son:" + "\n");
        empleados.inicializarIterador();
        while(empleados.hayNodo()){
            //Recorrer todos los empleados para sacar todos sus datos
            Empleado2 empleadoTemporal = (Empleado2) empleados.obtenerNodo();
            SalidaPorDefecto.terminal(empleadoTemporal.getNombre()+
                    "("+empleadoTemporal.numeroEmpleado+") \n");
            SalidaPorDefecto.terminal("Sus comisiones son: \n");
            empleadoTemporal.getComicionesanio().imprimir();
            //para que el siguiente empleado este separado
            SalidaPorDefecto.terminal("\n");
        }
    }
    public Double obtenerPromedioEmpleado(Empleado2 objetoEmpleado){
        Object empleadoEncontrado = empleados.buscar(objetoEmpleado);
        if(empleadoEncontrado==null){
            return null;
        }else {
            return ((Empleado2)empleadoEncontrado).obtenerPromedio();
        }
    }
}

