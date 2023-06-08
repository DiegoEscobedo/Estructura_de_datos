package utilerias.comunes;

public enum TipoTabla {
    COLUMNA(1),
    RENGLON(2);
    private int tipoTabla;
    private TipoTabla(int columna){
        this.tipoTabla = columna;
    }

    public int getColumna() {
        return tipoTabla;
    }

}
