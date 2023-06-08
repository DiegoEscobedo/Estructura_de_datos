package registro.controlEscuela;

public class Aplicacion {
    protected String nombreApp;
    protected String logo;
    protected String autores;
    protected int ramMinima;
    protected String fechaUso;

    public Aplicacion(String nombreApp, String logo, String autores, int ramMinima) {
        this.nombreApp = nombreApp;
        this.logo = logo;
        this.autores = autores;
        this.ramMinima = ramMinima;
    }

    public String getNombreApp() {
        return nombreApp;
    }

    public void setNombreApp(String nombreApp) {
        this.nombreApp = nombreApp;
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

    public String getAutores() {
        return autores;
    }

    public void setAutores(String autores) {
        this.autores = autores;
    }

    public int getRamMinima() {
        return ramMinima;
    }

    public void setRamMinima(int ramMinima) {
        this.ramMinima = ramMinima;
    }

    public String getFechaUso() {
        return fechaUso;
    }

    public void setFechaUso(String fechaUso) {
        this.fechaUso = fechaUso;
    }

    @Override
    public String toString() {
        return "Aplicacion{" +
                "nombre='" + nombreApp + '\'' +
                ", ramMinima=" + ramMinima +
                '}';
    }
}
