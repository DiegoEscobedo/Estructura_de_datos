package ObjetosConPrioridad;

public class FilaEnfermos extends Proceso{
    protected String nombrePaciente;
    protected String enfermedad;

    public FilaEnfermos(String nombre, double prioridad, String nombrePaciente, String enfermedad) {
        super(nombre, prioridad);
        this.nombrePaciente = nombrePaciente;
        this.enfermedad = enfermedad;
    }

    public String getNombrePasciente() {
        return nombrePaciente;
    }

    public void setNombrePasciente(String nombrePaciente) {
        this.nombrePaciente = nombrePaciente;
    }

    public String getEnfermedad() {
        return enfermedad;
    }

    public void setEnfermedad(String enfermedad) {
        this.enfermedad = enfermedad;
    }

    @Override
    public String toString() {
        return "Paciente{" +
                "nombrePasciente:'" + nombrePaciente + '\'' +
                ", enfermedad:'" + enfermedad + '\'' +
                '}';
    }
}

