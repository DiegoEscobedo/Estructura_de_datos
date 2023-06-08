package utilerias.comunes;
/**
 * @author diego
 * @version1.0
 */
public enum TipoOrden {

    INC(1),
    DEC(2);
    private final int orden;
    private TipoOrden(int orden){
        this.orden=orden;
    }
    public int getOrden(){
        return orden;
    }
}
