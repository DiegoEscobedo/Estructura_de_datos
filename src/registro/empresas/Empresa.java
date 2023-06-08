package registro.empresas;

import entradaSalida.SalidaPorDefecto;
import estructurasLineales.ListaEstatica;
/**
 * @version1.0
 * @autor:Clase ED
 */
public class Empresa {
    protected String nombre;
    protected ListaEstatica empleados;

    public Empresa(String nombre, int cantidadEmpleados) {
        this.nombre = nombre;
        this.empleados = new ListaEstatica(cantidadEmpleados);
    }

    public Empresa(String nombre) {
        this.nombre = nombre;
    }

    public boolean agregarEmpleado(Empleado2 objetoEmpleado) {
        int retornoEmpleado = (Integer) empleados.buscar(objetoEmpleado);
        if (retornoEmpleado == -1) {
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
    public void imprimirDatosEmpleadoDetalle() {
    //Recorrer todos los empleados para sacar todos sus datos
        for(int cadaEmpleado = 0; cadaEmpleado<empleados.cantidad();cadaEmpleado++) {
            Empleado2 empleadoTemporal = (Empleado2) empleados.obtener(cadaEmpleado);
            SalidaPorDefecto.terminal(empleadoTemporal.getNombre()+
                    "("+empleadoTemporal.numeroEmpleado+") \n");
            SalidaPorDefecto.terminal("Sus comisiones son: \n");
            empleadoTemporal.getComicionesanio().imprimir();
            //para que el siguiente empleado este separado
            SalidaPorDefecto.terminal("\n");
        }
    }
    public Double obtenerPromedioEmpleado(Empleado2 objetoEmpleado){
        int pocisionEmpleado = (int)empleados.buscar(objetoEmpleado);
        if(pocisionEmpleado==-1){
            return null;
        }else {
            Empleado2 empleadoTemporal = (Empleado2) empleados.obtener(pocisionEmpleado);
            return empleadoTemporal.obtenerPromedio();
        }
    }
}
