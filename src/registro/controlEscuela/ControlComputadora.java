package registro.controlEscuela;

import entradaSalida.SalidaPorDefecto;
import estructurasLineales.ListaDinamica;
import estructurasLineales.auxiliares.Nodo;

/**
 * @version 1.0
 * @autor:Clase ED
 */
public class ControlComputadora {

    protected String nombreEscuela;
    protected ListaDinamica computadoras;

    public ControlComputadora(String nombreEscuela) {
        this.nombreEscuela = nombreEscuela;
        this.computadoras = new ListaDinamica();
    }

    /**
     * Este metodo agrega computadoras
     * @param compu
     * @return
     */
    public int agregarComputadora(Computadora compu) {
        return computadoras.agregar(compu);
    }

    /**
     * Este metodo imprime computadoras
     */
    public void imprimirComputadoras() {
        computadoras.imprimir();
    }

    /**
     * Este metodo imprime cierta computadora
     * @param numeroComputadora
     */
    public void imprimirComputadora(int numeroComputadora) {
        Nodo actual = computadoras.getPrimero();
        while (actual != null) {
            Computadora compu = (Computadora) actual.getInfo();
            if (compu.numeroComputadora == numeroComputadora) {
                SalidaPorDefecto.terminal(compu + "\n" + "Aplicaciones instaladas: ");
                compu.aplicacionesInstaladas.imprimir();
            }
            actual = actual.getLigaDer();
        }
    }

    /**
     * Este metodo agrea aplicaciones a computadoras
     * @param numeroComputadora
     * @param app
     */
    public void agregarApps(int numeroComputadora, Aplicacion app) {
        Nodo actual = computadoras.getPrimero();
        while (actual != null) {
            Computadora compu = (Computadora) actual.getInfo();
            if (compu.numeroComputadora == numeroComputadora) {
                compu.agregarApp(app);
            }
            actual = actual.getLigaDer();
        }
    }

    /**
     * Este metodo elimina aplicaciones
     * @param numeroComputadora
     * @param app
     */
    public void eliminarApps(int numeroComputadora, Aplicacion app) {
        Nodo actual = computadoras.getPrimero();
        while (actual != null) {
            Computadora compu = (Computadora) actual.getInfo();
            if (compu.numeroComputadora == numeroComputadora) {
                compu.aplicacionesInstaladas.eliminar(app);
            }
            actual = actual.getLigaDer();
        }
    }

    /**
     * Este metodo busca una computadora con una aplicacion
     * @param nombreAplicacion
     * @return
     */
    public ListaDinamica computadorasConAplicacion(String nombreAplicacion) {
        ListaDinamica listaCompus = new ListaDinamica();
        Nodo actual = computadoras.getPrimero();
        while (actual != null) {
            Computadora compu = (Computadora) actual.getInfo();
            Nodo actualApp = compu.aplicacionesInstaladas.getPrimero();
            while (actualApp != null) {
                Aplicacion app = (Aplicacion) actualApp.getInfo();
                if (app.getNombreApp().equalsIgnoreCase(nombreAplicacion)) {
                    listaCompus.agregar(compu);
                }
                actualApp = actualApp.getLigaDer();
            }
            actual = actual.getLigaDer();
        }
        return listaCompus;
    }

    /**
     * Este metodo elimina una computadora
     * @param compu
     */
    public void eliminarComputadora(Computadora compu) {
        computadoras.eliminar(compu);
    }

    /**
     * Este metodo busca computadoras que pueden correr cierta application
     * @param app
     * @return
     */
    public ListaDinamica puedenCorrerApp(Aplicacion app) {
        ListaDinamica listaCompus = new ListaDinamica();
        Nodo actual = computadoras.getPrimero();
        while (actual != null) {
            Computadora compu = (Computadora) actual.getInfo();
            if (compu.RAM >= app.getRamMinima()) {
                listaCompus.agregar(compu);
            }
            actual = actual.getLigaDer();
        }
        return listaCompus;
    }

    /**
     * Imprime los usuarios que usaron una computadora
     * @param compu
     */
    public void usuariosQueUsaronComputadora(Computadora compu) {
        compu.usuarios.imprimir();
    }

    /**
     * imprime el tiempo de uso de un usuario sobre sus computadoras
     * @param nombreUsuario
     */
    public void tiempoDeUso(String nombreUsuario) {
        Nodo actual = computadoras.getPrimero();
        while (actual != null) {
            Computadora compu = (Computadora) actual.getInfo();
            Nodo usuarioAct = compu.usuarios.getPrimero();
            while (usuarioAct != null) {
                Usuario usr = (Usuario) usuarioAct.getInfo();
                if (usr.getNombreUsuario().equalsIgnoreCase(nombreUsuario)) {
                    SalidaPorDefecto.terminal("Este ususario uso la computadora numero " + compu.getNumeroComputadora() +
                            " del centro de computo " + compu.getCentroDeComputo() + "\n" + compu.tiempoDeUso(usr) + "\n");
                }
                usuarioAct = usuarioAct.getLigaDer();
            }
            actual = actual.getLigaDer();
        }
    }

    /**
     * Imprime aplicaciones que se usaron
     * @param usr
     * @param fecha
     */
    public void imprimirAplicacionesQueUso(Usuario usr, String fecha) {
        usr.imprimirAplicacionesUsadas(fecha).imprimir();
    }

    /**
     * Imprime usuarios que no usaron el centro de computo
     * @return
     */
    public ListaDinamica usuariosQueNoUsanElCC() {
        ListaDinamica listaUsrs = new ListaDinamica();
        Nodo actual = computadoras.getPrimero();
        while (actual != null) {
            Computadora compu = (Computadora) actual.getInfo();
            Nodo usuarioAct = compu.usuarios.getPrimero();
            while (usuarioAct != null) {
                Usuario usr = (Usuario) usuarioAct.getInfo();
                if (usr.aplicacionesUsadas.vacio()) {
                    listaUsrs.agregar(usr);
                }
                usuarioAct = usuarioAct.getLigaDer();
            }
            actual = actual.getLigaDer();
        }
        return listaUsrs;
    }
}
