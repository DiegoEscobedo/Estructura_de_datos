package registro.controlEscuela;

import estructurasLineales.ListaDinamica;
import estructurasLineales.auxiliares.Nodo;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;


public class Usuario {
    protected String nombreUsuario;
    protected String fecha;
    protected String horaInicio;
    protected String horaFinal;
    protected ListaDinamica aplicacionesUsadas;

    public Usuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
        this.aplicacionesUsadas = new ListaDinamica();
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getHoraInicio() {
        return horaInicio;
    }

    public void setHoraInicio(String horaInicio) {
        this.horaInicio = horaInicio;
    }

    public String getHoraFinal() {
        return horaFinal;
    }

    public void setHoraFinal(String horaFinal) {
        this.horaFinal = horaFinal;
    }

    public void fechaDeUso(){
        String fecha =  DateTimeFormatter.ofPattern("MMM dd yyyy")
                .format(LocalDateTime.now());
        setFecha(fecha);
    }
    public void inicioDeUso(){
        String hora =  DateTimeFormatter.ofPattern("hh:mm")
                .format(LocalDateTime.now());
        setHoraInicio(hora);
    }
    public void finDeUso(){
        String hora =  DateTimeFormatter.ofPattern("hh:mm")
                .format(LocalDateTime.now());

        setHoraFinal(hora);
    }

    public void usoAplicacion(Aplicacion app){
        String fecha =  DateTimeFormatter.ofPattern("MMM dd yyyy").format(LocalDateTime.now());
        app.setFechaUso(fecha);
        aplicacionesUsadas.agregar(app);
    }

    public ListaDinamica imprimirAplicacionesUsadas(String fecha){
        ListaDinamica listaApps = new ListaDinamica();
        Nodo appact = aplicacionesUsadas.getPrimero();
        while (appact!=null){
            Aplicacion app = (Aplicacion) appact.getInfo();
            if(app.getFechaUso().equalsIgnoreCase(fecha)){
                listaApps.agregar(app);
            }
            appact = appact.getLigaDer();
        }
        return listaApps;
    }

    @Override
    public String toString() {
        return "Usuario{" +
                "nombreUsuario='" + nombreUsuario + '\'' +
                '}';
    }
}
