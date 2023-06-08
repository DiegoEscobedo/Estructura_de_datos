package ObjetosConPrioridad;

public class Proceso {
    protected String nombre;
    protected double prioridad;

    public Proceso(String nombre, double prioridad) {
        this.nombre = nombre;
        this.prioridad = prioridad;
    }

    public Proceso(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getPrioridad() {
        return prioridad;
    }

    public void setPrioridad(double prioridad) {
        this.prioridad = prioridad;
    }

    @Override
    public String toString() {
        return "Proceso{"+ nombre + '\'' +
                '}';
    }
}
