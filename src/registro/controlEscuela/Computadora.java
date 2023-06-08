package registro.controlEscuela;

import estructurasLineales.ListaDinamica;

public class Computadora {
    protected int numeroComputadora;
    protected String centroDeComputo;
    protected int RAM;
    protected double discoDuro;
    protected String procesador;
    protected String marca;
    protected ListaDinamica aplicacionesInstaladas;
    protected ListaDinamica usuarios;

    public Computadora(int numeroComputadora, String centroDeComputo, int RAM, double discoDuro, String procesador, String marca) {
        this.numeroComputadora = numeroComputadora;
        this.centroDeComputo = centroDeComputo;
        this.RAM = RAM;
        this.discoDuro = discoDuro;
        this.procesador = procesador;
        this.marca = marca;
        this.aplicacionesInstaladas = new ListaDinamica();
        this.usuarios = new ListaDinamica();
    }

    public int getNumeroComputadora() {
        return numeroComputadora;
    }

    public void setNumeroComputadora(int numeroComputadora) {
        this.numeroComputadora = numeroComputadora;
    }

    public String getCentroDeComputo() {
        return centroDeComputo;
    }

    public void setCentroDeComputo(String centroDeComputo) {
        this.centroDeComputo = centroDeComputo;
    }

    public int getRAM() {
        return RAM;
    }

    public void setRAM(int RAM) {
        this.RAM = RAM;
    }

    public double getDiscoDuro() {
        return discoDuro;
    }

    public void setDiscoDuro(double discoDuro) {
        this.discoDuro = discoDuro;
    }

    public String getProcesador() {
        return procesador;
    }

    public void setProcesador(String procesador) {
        this.procesador = procesador;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public ListaDinamica getAplicacionesInstaladas() {
        return aplicacionesInstaladas;
    }

    public void setAplicacionesInstaladas(ListaDinamica aplicacionesInstaladas) {
        this.aplicacionesInstaladas = aplicacionesInstaladas;
    }

    public ListaDinamica getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(ListaDinamica usuarios) {
        this.usuarios = usuarios;
    }

    public int agregarApp(Aplicacion app){
        return aplicacionesInstaladas.agregar(app);
    }

    public int agregarUser(Usuario user){
        user.fechaDeUso();
        user.inicioDeUso();
        return usuarios.agregar(user);
    }
    public void  dejoDeUsarCompu(Usuario usuario){
        usuario.finDeUso();
    }
    public String tiempoDeUso(Usuario usr){
        return " en la fecha " + usr.getFecha() + " de las " + usr.getHoraInicio() + " a las " + usr.getHoraFinal();
    }


    @Override
    public String toString() {
        return "Computadora{" +
                "numeroComputadora=" + numeroComputadora +
                ", centroDeComputo='" + centroDeComputo + '\'' +
                ", RAM=" + RAM +
                ", discoDuro=" + discoDuro +
                ", procesador='" + procesador + '\'' +
                ", marca='" + marca +
                '}';
    }
}
