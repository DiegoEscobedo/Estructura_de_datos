package utilerias.comunes;

/**
 * @author diego
 * @version1.0
 */
public class Comparador{
    /**
     * Compara 2 objetos segun sea su tipo (tienen que ser del mismo tipo para que los compare)
     * @param objeto1 Es el primer objeto
     * @param objeto2 Es el segundo objeto a comparar
     * @return Regresa un valor mayor a 0 si es mayor el objeto1 , regresa 0 si son iguales los 2 objetos y regresa un valos menor a 0 si el objeto1 es menor
     */
    public static Object comparar(Object objeto1, Object objeto2){
        if(objeto1 instanceof Number && objeto2 instanceof Number){
            if(((Number) objeto1).doubleValue()<((Number) objeto2).doubleValue()){
                return -1;
            } else if (((Number) objeto1).doubleValue()>((Number) objeto2).doubleValue()) {
                return 1;
            }else{
                return 0;
            }
        }else{
            return ((objeto1.toString()).compareToIgnoreCase(objeto2.toString()));
        }
    }

}
