package estructurasLineales;

import entradaSalida.SalidaPorDefecto;

public class ColaEstatica implements Lote{
    protected int MAXIMO;
    protected int inicio;
    protected int fin;
    protected Object informacion[];

    public ColaEstatica(int tamanio) {
        this.MAXIMO = tamanio;
        this.inicio = -1;
        this.fin = -1;
        informacion = new Object[tamanio];
    }

    @Override
    public boolean lleno() {
        if((inicio == 0 && fin == (MAXIMO)-1) || (fin == inicio-1) ){
            return true;
        }else{
            return false;
        }
    }

    @Override
    public boolean vacio() {
        if(inicio == -1){
            return true;
        }else {
            return false;
        }
    }

    @Override
    public boolean poner(Object info) {
        if(lleno() == false){
            if(vacio() == true){
                inicio = 0;
                fin = 0;
            }else if(fin==(MAXIMO-1)){
                fin=0;
            }else{
                fin++;
            }
            informacion[fin]=info;
            return true;
        }else{
            return false;
        }
    }

    @Override
    public Object quitar() {
        if(!vacio()){
            Object respaldo = informacion[inicio];
            if(inicio == fin){
                inicio = -1;
                fin = -1;
            } else if(inicio == MAXIMO-1){
                inicio = 0;
            } else {
                inicio++;
            }
            return respaldo;
        }
        return null;
    }

    @Override
    public void imprimir() {
        if(!vacio()){
            if(inicio <= fin){
                for(int indice = inicio; indice <= fin; indice++){
                    SalidaPorDefecto.terminal(informacion[indice] + " ");
                }
            }
            else{
                for(int indice = inicio; indice < MAXIMO; indice++){
                    SalidaPorDefecto.terminal(informacion[indice] + " ");
                }
                for(int indice = 0; indice <= fin; indice++){
                    SalidaPorDefecto.terminal(informacion[indice] + " ");
                }
            }
        }
    }

    @Override
    public Object verTope() {
        if(!vacio()){
            return informacion[fin];
        }
        return null;
    }

    public Object verInicio(){
        if(!vacio()){
            return informacion[inicio];
        }
        return null;
    }
}
