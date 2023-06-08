package registro.Diccionario;

import entradaSalida.SalidaPorDefecto;
import estructurasLineales.ListaDinamica;
import estructurasLineales.ListaDinamicaClave;
import estructurasLineales.auxiliares.Nodo;

public class DiccionarioConceptos extends ListaDinamicaClave {

    protected String nombreDiccionario;
    protected ListaDinamicaClave listaClave;

    public DiccionarioConceptos(String nombreDiccionario) {
        this.nombreDiccionario = nombreDiccionario;
        listaClave = new ListaDinamicaClave();
    }

    /**
     * Egrega conceptos
     * @param concepto Es el concepto
     * @return Regresa true si pudo agregarlo
     */
    public boolean agregar(Concepto concepto){
        return agregar(concepto.getPalabra(), concepto.getDefinicion()
                + " Sin:"+ concepto.getUso() + " Uso:"+concepto.getUso());
    }

    /**
     * Busca conceptos por la palabra
     * @param palabra Es la palabra
     * @return Regresa el la definicion de el concepto buscado
     */
    public Object buscarConcepto(String palabra){
        return buscar(palabra);
    }

    /**
     * Busca una palabra dentro de un texto
     * @param texto Es el texto
     * @param palabra Es la palabra
     * @return REgresa true si la encontro
     */
    public boolean buscarPalabra(String texto, String palabra){
        String palabras = "";
        ListaDinamica palabraslist = new ListaDinamica();
        for(int i = 0; i<texto.length();i++){
            char caracter = texto.charAt(i);
            if(caracter != ' ' && caracter != ',' && caracter != ';' && caracter != '.' && caracter != '-' && caracter != '/' && caracter != ':'){
                palabras += caracter;
            }else{
                palabraslist.agregar(palabras);
                palabras = "";
            }
        }
        palabraslist.inicializarIterador();
        while (palabraslist.hayNodo()){
            String txt = (String) palabraslist.obtenerNodo();
            if(palabra.equalsIgnoreCase(txt)){
                return true;
            }
        }
        return false;
    }

    /**
     * Busca definiciones que contengan con una palabra en concreto
     * @param palabraClave Es la palabra a buscar
     * @return Regresa una lista de los conceptos con la palabra
     */
    public ListaDinamicaClave buscarPalabraClave(String palabraClave){
        ListaDinamicaClave listaD = new ListaDinamicaClave();
        inicializarIterador();
        while (nodoActual!=null){
            String texto = (String) nodoActual.getInfo();
            if(buscarPalabra(texto, palabraClave)){
                listaD.agregar(nodoActual.getClave(), nodoActual.getInfo());
            }
            nodoActual = nodoActual.getLigaDer();
        }
        if(listaD.contarValores()==0){
            listaD.agregar(0, "no existe");
        }
        return listaD;
    }
}
