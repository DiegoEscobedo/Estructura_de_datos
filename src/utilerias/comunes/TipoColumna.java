package utilerias.comunes;
/**
 * @author diego
 * @version1.0
 */
public enum TipoColumna {
    IZQ(1),
    DER(2);
    private final int orden;
    private TipoColumna(int orden){
        this.orden=orden;
    }
    public int getOrden(){
        return orden;
    }
}
