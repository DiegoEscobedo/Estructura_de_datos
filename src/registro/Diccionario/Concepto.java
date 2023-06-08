package registro.Diccionario;

public class Concepto {
    protected String palabra;
    protected String definicion;
    protected String uso;
    protected String sinonimos;

    public Concepto(String palabra,String definicion,String uso,String sinonimos) {
        this.definicion = definicion;
        this.palabra = palabra;
        this.uso = uso;
        this.sinonimos = sinonimos;
    }

    public Concepto(String palabra, String definicion) {
        this.palabra = palabra;
        this.definicion = definicion;
        this.uso = "";
        this.sinonimos = "";
    }

    public String getPalabra() {
        return palabra;
    }

    public void setPalabra(String palabra) {
        this.palabra = palabra;
    }

    public String getUso() {
        return uso;
    }

    public void setUso(String uso) {
        this.uso = uso;
    }

    public String getSinonimos() {
        return sinonimos;
    }

    public void setSinonimos(String sinonimos) {
        this.sinonimos = sinonimos;
    }

    public String getDefinicion() {
        return definicion;
    }

    public void setDefinicion(String definicion) {
        this.definicion = definicion;
    }
}
