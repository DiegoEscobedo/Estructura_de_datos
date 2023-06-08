package registro.competenciasAtleticas;

public class Corredor {
    protected int numeroDeCorredor;
    protected String nombre;
    protected int edad;
    protected String nacionalidad;

    public Corredor(int numeroDeCorredor, String nombre, int edad, String nacionalidad) {
        this.numeroDeCorredor = numeroDeCorredor;
        this.nombre = nombre;
        this.edad = edad;
        this.nacionalidad = nacionalidad;
    }

    public int getNumeroDeCorredor() {
        return numeroDeCorredor;
    }

    public void setNumeroDeCorredor(int numeroDeCorredor) {
        this.numeroDeCorredor = numeroDeCorredor;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getNacionalidad() {
        return nacionalidad;
    }

    public void setNacionalidad(String nacionalidad) {
        this.nacionalidad = nacionalidad;
    }

    @Override
    public String toString() {
        return "" + getNumeroDeCorredor();
    }
}
