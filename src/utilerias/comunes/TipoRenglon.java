package utilerias.comunes;
/**
 * @author diego
 * @version1.0
 */
public enum TipoRenglon {
    INF(1),
    SUP(2);
    private final int orden;
    private TipoRenglon(int orden){
        this.orden=orden;
    }
    public int getOrden(){
        return orden;
    }
}
