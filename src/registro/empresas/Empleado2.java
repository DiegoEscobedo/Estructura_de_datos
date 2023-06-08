package registro.empresas;

import estructurasLineales.ListaDinamica;

/**
 * @version 1.0
 * @autor:Clase ED
 */
public class Empleado2 {
    protected int numeroEmpleado;
    protected String nombre;
    protected ListaDinamica comicionesanio;
    protected int edad;

    public Empleado2(int numeroEmpleado, String nombre, int edad, ListaDinamica comicionesanio) {
        this.numeroEmpleado = numeroEmpleado;
        this.nombre = nombre;
        this.comicionesanio = comicionesanio;
        this.edad = edad;
    }

    public Empleado2(int numeroEmpleado, String nombre) {
        this.numeroEmpleado = numeroEmpleado;
        this.nombre = nombre;
        this.edad = edad;
        this.comicionesanio = new ListaDinamica();
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

    public ListaDinamica getComicionesanio() {
        return comicionesanio;
    }

    public void setComicionesanio(ListaDinamica comicionesanio) {
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
        int contador = 0;
        if(!comicionesanio.vacio()){
            comicionesanio.inicializarIterador();
            while (comicionesanio.hayNodo()){
                promedio += promedio + (double)comicionesanio.obtenerNodo();
                contador++;
            }
            promedio = (promedio/contador);
        }
        return promedio;
    }


}


