package registro.empresas;

import estructurasLineales.ListaEstatica;
/**
 * @version1.0
 * @autor:Clase ED
 */
public class Empleado {
    protected int numeroEmpleado;
    protected String nombre;
    protected ListaEstatica comicionesanio;
    protected int edad;

    public Empleado(int numeroEmpleado, String nombre, int edad, ListaEstatica comicionesanio) {
        this.numeroEmpleado = numeroEmpleado;
        this.nombre = nombre;
        this.comicionesanio = comicionesanio;
        this.edad = edad;
    }

    public Empleado(int numeroEmpleado, String nombre) {
        this.numeroEmpleado = numeroEmpleado;
        this.nombre = nombre;
        this.edad = edad;
        this.comicionesanio = new ListaEstatica(12);
    }
    public boolean agregarComisiones(int valorComision){
        int retorno = comicionesanio.agregar(valorComision);
        if(retorno>=0){
            return true;
        }else {
            return false;
        }
    }

    public int getNumeroEmpleado() {
        return numeroEmpleado;
    }

    public void setNumeroEmpleado(int numeroEmpleado) {
        this.numeroEmpleado = numeroEmpleado;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public ListaEstatica getComicionesanio() {
        return comicionesanio;
    }

    public void setComicionesanio(ListaEstatica comicionesanio) {
        this.comicionesanio = comicionesanio;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    @Override
    public String toString() {
        return "Empleado:"+numeroEmpleado;
    }

    public double obtenerPromedio(){
        double promedio = 0.0;
        if(comicionesanio.cantidad()!=0){
            for(int cadaMes = 0 ; cadaMes<comicionesanio.cantidad(); cadaMes++){
                promedio += (double) comicionesanio.obtener(cadaMes);
            }
            promedio = promedio / comicionesanio.cantidad();
        }
        return promedio;
    }


}

