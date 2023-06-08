package registro.competenciasAtleticas;

public class EventoCompetencia {
    protected String nombreCompetencia;
    protected String lugar;

    public EventoCompetencia(String nombreCompetencia, String lugar) {
        this.nombreCompetencia = nombreCompetencia;
        this.lugar = lugar;
    }

    public String getNombreCompetencia() {
        return nombreCompetencia;
    }

    public void setNombreCompetencia(String nombre) {
        this.nombreCompetencia = nombre;
    }

    public String getLugar() {
        return lugar;
    }

    public void setLugar(String lugar) {
        this.lugar = lugar;
    }

    @Override
    public String toString() {
        return nombreCompetencia;
    }
}
