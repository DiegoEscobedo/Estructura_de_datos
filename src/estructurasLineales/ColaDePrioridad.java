package estructurasLineales;

import ObjetosConPrioridad.Proceso;

/**
 * @author diego
 * @version 1.0
 */
public class ColaDePrioridad extends ColaEstatica{

    /**
     * Constructor que hereda desde ColaEstatica
     * @param tamanio es el tamaño de la cola
     */
    public ColaDePrioridad(int tamanio) {
        super(tamanio);
    }

    /**
     * Verifica si el objeto que le pasas tiene el valor más grande de prioridad de toda la cola
     * @param info es el objeto
     * @return Regresa true si si es el mayor
     */
    public boolean esElMayor(Object info){
        for(int cadaElemento = 0; cadaElemento<=fin; cadaElemento++){
            Proceso proceso = (Proceso) informacion[cadaElemento];
            if(proceso.getPrioridad()>(((Proceso) info).getPrioridad())){
                return false;
            }
        }
        return true;
    }

    /**
     * Va agregando o poniendo los objetos en la cola segun sea su atributo de prioridad
     * @param info Es el objeto a poner
     * @return Regresa false si no pudo ponerlo
     */
    @Override
    public boolean poner(Object info) {
        if(info instanceof Proceso) {
            if (!lleno()) {
                if (vacio()) {
                    inicio = 0;
                    fin = 0;
                    informacion[fin] = info;
                } else if (esElMayor(info)) {
                    fin = fin + 1;
                    informacion[fin] = info;
                } else if (((Proceso)informacion[inicio]).getPrioridad() > (((Proceso) info).getPrioridad())) {
                    for (int movs = fin; movs >= inicio; movs--) {
                        informacion[movs + 1 ] = informacion[movs];
                    }
                    informacion[0] = info;
                    fin = fin+1;
                } else{
                    int cadaElemento = 1;
                    while(cadaElemento<=fin){
                        Proceso respaldo = (Proceso) informacion[cadaElemento];
                        Proceso anterior = (Proceso) informacion[cadaElemento-1];
                        if((respaldo.getPrioridad()) > (((Proceso) info).getPrioridad()) && (anterior.getPrioridad()) < (((Proceso) info).getPrioridad())) {
                            informacion[cadaElemento] = info;
                            for (int movs = fin; movs > cadaElemento; movs--) {
                                informacion[movs + 1] = informacion[movs];
                            }
                            informacion[cadaElemento + 1] = respaldo;
                        }
                        cadaElemento++;
                    }
                    fin = fin+1;
                }
                return true;
            }
        }
        return false;
    }
}
