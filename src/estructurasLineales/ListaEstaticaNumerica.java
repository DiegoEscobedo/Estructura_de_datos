package estructurasLineales;

import entradaSalida.SalidaPorDefecto;
import utilerias.comunes.Comparador;

/**
 * @author diegod
 * @version1.0
 */
public class ListaEstaticaNumerica extends ListaEstatica{
    public ListaEstaticaNumerica(int tamanio) {
        super(tamanio);
    }
    public boolean validarNumero(Object info){
        return info instanceof Number;
    }
    @Override
    public int agregar(Object info) {
        if(validarNumero(info)){
            return super.agregar(info);
        }
        return -1;
    }
    @Override
    public boolean cambiar(int indice, Object info){
        if(validarNumero(info)){
            return super.cambiar(indice,info);
        }
        return false;
    }

    @Override
    public Object eliminar(Object info) {
        if(validarNumero(info)){
            return ((Number) super.eliminar(info)).intValue();
        }
        return null;
    }

    /**
     * Multiplica el escalar dado por cada posición del arreglo numérico.
     * @param escalar Es el valor a multiplicar
     * @return Regresa falso si el arreglo actual está vacío.
     */
    public boolean porEscalar(Number escalar){
        if(vacio() == false){
            for(int cadaValor = 0; cadaValor < MAXIMO; cadaValor++){
                informacion[cadaValor] = ((Number) obtener(cadaValor)).doubleValue() * escalar.doubleValue();
            }
            return true;
        }
        return false;
    }

    /**
     * Suma el escalar dado a cada posición del
     * arreglo numérico
     * @param escalar Es el vaalor a sumar
     * @return Regresa falso si el arreglo actual está vacío.
     */
    public boolean sumarEscalar(Number escalar){
        if(vacio() == false){
            for(int cadaValor = 0; cadaValor < MAXIMO; cadaValor++){
                informacion[cadaValor] = ((Number)obtener(cadaValor)).doubleValue() + escalar.doubleValue();
            }
            return true;
        }
        return false;
    }

    /**
     * Suma la posición 1 del arreglo
     * actual con la posición 1 de arreglo2, y así sucesivamente.
     * @param lista2 es la lista de escalares a sumar
     * @return Regresa falso si el arreglo actual está vacío
     */
    public boolean sumar(ListaEstaticaNumerica lista2){
        if((int) Comparador.comparar(tope, lista2.tope) == 0){
            for(int valoresLista = 0; valoresLista <= tope; valoresLista++){
                informacion[valoresLista] = ((Number) obtener(valoresLista)).doubleValue() + ((Number) lista2.obtener(valoresLista)).doubleValue();
            }
            return true;
        }
        return false;
    }

    /**
     * Hace el producto de
     * posición 1 del arreglo actual por
     * posición 1 de arreglo2, y así sucesivamente
     * @param lista2 es la lista de valores que se multiplican
     * @return Regresa falso si el arreglo actual está vacío.
     */
    public boolean multiplicar(ListaEstaticaNumerica lista2){
        if(!vacio()){
            if((int) Comparador.comparar(tope, lista2.tope) == 0){
                for(int valoresLista = 0; valoresLista <= tope; valoresLista++){
                    informacion[valoresLista] = ((Number) obtener(valoresLista)).doubleValue() * ((Number) lista2.obtener(valoresLista)).doubleValue();
                }
                return true;
            }
        }
        return false;
    }

    /**
     * Hace la operación de potencia de
     * cada elemento del arreglo (base) por
     * el exponente pasado como escalar
     * @param escalar es el la potencia a realizar
     * @return Regresa falso si el arreglo actual está vacío
     */
    public boolean aplicarPotencia(Number escalar){
        if(!vacio()){
            for(int cadaValor = 0; cadaValor <= tope; cadaValor++){
                int valorAuxiliar = (int) informacion[cadaValor];
                for(int exponente = 1; exponente < escalar.intValue(); exponente++){
                    informacion[cadaValor] = ((Number)obtener(cadaValor)).doubleValue() * valorAuxiliar;
                }
            }
            return true;
        }
        return false;
    }

    /**
     * que haga la operación de potencia de cada elemento del arreglo
     * (base) por el exponente pasado como arreglo,posición por posición,
     * estos arreglos necesitan ser del mismo tamaño
     * @param listaEscalares es la lista de las potencias
     * @return Regresa falso si el arreglo actual está vacío
     */
    public boolean aplicarPotencia(ListaEstaticaNumerica listaEscalares){
        if((int) Comparador.comparar(tope, listaEscalares.tope) == 0){
            for(int cadaValor = 0; cadaValor <= tope; cadaValor++){
                int valorAuxiliar = (int) informacion[cadaValor];
                for(int exponente = 1; exponente < (int)listaEscalares.obtener(cadaValor); exponente++){
                    informacion[cadaValor] = ((Number)obtener(cadaValor)).doubleValue() * valorAuxiliar;
                }
            }
            return true;
        }
        return false;
    }

    /**
     * La accion que realiza es ejemplo considere los
     * vectores matemáticos (arreglos) siguientes de dimensión 3: {a, b, c} • {x, y, z}T
     * =a•x + b•y+ c•z. Donde la {}T es la transpuesta del vector y • es la multiplicación
     * elemento por elemento.
     * @param lista2 es la lista de los valores a multiplicar
     * @return Regresa el resultado de las operaciones ya realizadas
     */
    public double productoEscalar(ListaEstaticaNumerica lista2){
        double transformada = 0.0;
        if((int) Comparador.comparar(tope, lista2.tope) == 0){
            for(int valoresLista = 0; valoresLista <= tope; valoresLista++){
                transformada += ((Number) obtener(valoresLista)).doubleValue() * ((Number) lista2.obtener(valoresLista)).doubleValue();
            }
            return transformada;
        }
        return transformada;
    }

    /**
     * Realiza la operacion de la norma, por
     * ejemplo considere el siguiente vector numérico de dimensión 3: V= {a, b, c},
     * ||V||= sqrt(a2 + b2 + c2). Donde sqrt es la raíz cuadrada.
     * @return Regresa la norma
     */
    public double norma(){
        double normaTotal = 0.0;
        for(int valoresLista = 0; valoresLista <= tope; valoresLista++){
            normaTotal += ((Number) obtener(valoresLista)).doubleValue() * ((Number) obtener(valoresLista)).doubleValue();
        }
        return Math.abs(Math.sqrt(normaTotal));
    }

    /**
     * Calcula la norma euclidiana del vector numérico AB (arreglos n dimensionales).
     * @param lista2 es la lista que rebresenta a B en la formula de la norma euclidiana
     * @return Regesa la norma euclidiana
     */
    public double normaEuclidiana(ListaEstaticaNumerica lista2){
        if(vacio()==false && (int) Comparador.comparar(tope, lista2.tope) == 0){
            double normaTotal = 0.0;
            for(int valoresLista = 0; valoresLista <= tope; valoresLista++){
                normaTotal += (((Number) lista2.obtener(valoresLista)).doubleValue() - ((Number) obtener(valoresLista)).doubleValue()) * (((Number) lista2.obtener(valoresLista)).doubleValue() - ((Number) obtener(valoresLista)).doubleValue());
            }
            return Math.abs(Math.sqrt(normaTotal));
        }
        return 0.0;
    }

    /**
     * Suma de uno por uno un conjunto de arreglos de tipo ListaEstaticaNumerica
     * almacenados en la variable listas al arreglo actual.
     * @param listas Cada posición de listas guarda un arreglo.
     * @return Regresa 0.0 si esta vacio el arreglo actual
     */
    public double sumarListaEstatica(ListaEstatica listas){
        if(!vacio()){
            for(int indiceListas = 0; indiceListas <= listas.tope; indiceListas++){
                if(listas.obtener(indiceListas) instanceof ListaEstaticaNumerica){
                    for(int numEscalar = 0; numEscalar <= ((ListaEstaticaNumerica) listas.obtener(indiceListas)).tope; numEscalar++){
                        for(int valListaActual = 0; valListaActual <= tope; valListaActual++){
                            informacion[valListaActual] = ((Number)informacion[valListaActual]).doubleValue() + ((Number)((ListaEstaticaNumerica) listas.obtener(indiceListas)).obtener(numEscalar)).doubleValue();
                        }
                    }
                }
            }
        }
        return 0.0;
    }

    /**
     * Suma de uno por uno un conjunto de
     * escalares almacenados en la variable escalares al arreglo
     * actual.
     * @param escalares Es un arreglo que guarda en cada posición un escalar.
     * @return Regresa 0.0 si esta vacio el arreglo actual
     */
    public double sumarEscalares(ListaEstaticaNumerica escalares){
        if(vacio()==false&&(int) Comparador.comparar(tope, escalares.tope) == 0){
            for(int numEscalar = 0; numEscalar <= escalares.tope; numEscalar++){
                for (int valorDeLista = 0; valorDeLista <= tope ; valorDeLista++){
                    informacion[valorDeLista] = ((Number)informacion[valorDeLista]).doubleValue() + ((Number) escalares.obtener(numEscalar)).doubleValue();
                }
            }
            return 1.0;
        }else{
            return 0.0;
        }
    }

    /**
     * Sumar, del arreglo actual, las posiciones de él que
     * indica el arreglo llamado listaIndices
     * @param listaIndices Almacena las posiciones que se deben tomar del arreglo actual para hacer la suma.
     * @return Regresa la suma de los numeros en los indices indicados
     */
    public double sumarIndices(ListaEstaticaNumerica listaIndices){
        double sumaIndices = 0.0;
        if(vacio() == false){
            for(int indiceLista = 0; indiceLista <= listaIndices.tope; indiceLista++){
                if(obtener((int) listaIndices.obtener(indiceLista)) != null){
                    sumaIndices += ((Number) obtener((int)listaIndices.obtener(indiceLista))).doubleValue();
                }
            }
            return sumaIndices;
        }
        return sumaIndices;
    }
    @Override
    public ListaEstatica subLista(ListaEstaticaNumerica listaIndices) {
        ListaEstaticaNumerica listaNueva = new ListaEstaticaNumerica(listaIndices.tope+1);
        if(vacio() == false){
            for(int indiceLista = 0; indiceLista <= listaIndices.tope; indiceLista++){
                if(obtener((int) listaIndices.obtener(indiceLista)) != null){
                    if(obtener((int)listaIndices.obtener(indiceLista)) instanceof Number) {
                        Number objeto = ((Number) obtener((int) listaIndices.obtener(indiceLista))).doubleValue();
                        listaNueva.agregar(objeto);
                    }
                }
            }
            return listaNueva;
        }
        return listaNueva;
    }

    /**
     * Determina si el conjunto de arreglos pasado como argumentos (es un arreglo de arreglos
     * numéricos) (representa V) son linealmente dependientes.
     * @param listaVectores Es la lista de vectores
     * @return Regresa true si son Linealmente Dependientes
     */
    public boolean sonLinealmenteDependientes(ListaEstatica listaVectores){
        if(listaVectores instanceof ListaEstaticaNumerica){
            ListaEstaticaNumerica listaAuxiliar = new ListaEstaticaNumerica(tope+1);
            for(int indiceLista = 0; indiceLista <= tope; indiceLista++){
                listaAuxiliar.agregar(((Number)obtener(indiceLista)).doubleValue());
            }
            listaAuxiliar.multiplicar((ListaEstaticaNumerica) listaVectores);
            double valorFinal = 0.0;
            for(int indiceNuevaLista = 0; indiceNuevaLista <= listaAuxiliar.tope; indiceNuevaLista++){
                valorFinal += ((Number)listaAuxiliar.obtener(indiceNuevaLista)).doubleValue();
            }
            return (valorFinal == 0.0);
        }
        return false;
    }

    /**
     * Determina si el conjunto de arreglos pasado como argumentos
     * (es un arreglo de arreglos numéricos) (representa V) son linealmente independientes.
     * @param listaVectores Es la lista de vectores
     * @return Regresa true si son Linealmente Independientes
     */
    public boolean sonLinealmenteIndependientes(ListaEstatica listaVectores){
        if(listaVectores instanceof ListaEstaticaNumerica){
            for(int indiceLista = 0; indiceLista <= tope; indiceLista++){
                if(((Number) obtener(indiceLista)).doubleValue() != 0){
                    return false;
                }
            }
            return true;
        }
        return false;
    }

    /**
     * Determina si el arreglo actual es ortogonal al arreglo pasado como
     * argumento.
     * @param lista2 es el 2do arreglo
     * @return Regresa true si si es Ortogonal
     */
    public boolean esOrtogonal(ListaEstaticaNumerica lista2){
        return productoEscalar(lista2) == 0;
    }

    /**
     * Determinar si el arreglo actual es paralelo al arreglo pasado como
     * argumento.
     * @param lista2 es el otro arreglo
     * @return Regresa true si si son paralelos
     */
    public boolean esParalelo(ListaEstaticaNumerica lista2){
        if((int)Comparador.comparar(tope, lista2.tope) == 0){
            double escalar = ((Number) lista2.obtener(0)).doubleValue() / ((Number) obtener(0)).doubleValue();
            for(int indiceLista = 1; indiceLista <= tope; indiceLista++){
                if((int)Comparador.comparar(escalar, ((Number) lista2.obtener(indiceLista)).doubleValue() / ((Number) obtener(indiceLista)).doubleValue()) !=0){
                    return false;
                }
            }
            return true;
        }
        return false;
    }
    public Object verTope(){
        if(!vacio()){
            return informacion[tope];
        }else{
            return null;
        }
    }
    public void recibeBuffer(double[] buffer){
        for (int buferIndice=0;buferIndice<getMAXIMO();buferIndice++) {
            agregar(buffer[buferIndice]);
        }
    }
    public double[] leerArregloNumerico(){
        double[] arregloAuxiliar = new double[getMAXIMO()];
        for(int indiceArreglo = 0; indiceArreglo <= getTope(); indiceArreglo++){
            arregloAuxiliar[indiceArreglo] = ((Number) informacion[indiceArreglo]).doubleValue();
        }
        return arregloAuxiliar;
    }
    @Override
    public void invertir() {
        ListaEstaticaNumerica listaInvertida = new ListaEstaticaNumerica(getMAXIMO());
        for (int indice = 0; indice <= getTope() - 1; indice++) {
            listaInvertida.informacion[getTope() - 1 - indice] = informacion[indice];
        }
        for (int indice =0;indice<=tope-1;indice++){
            informacion[indice]=listaInvertida.informacion[indice];
        }
    }
}