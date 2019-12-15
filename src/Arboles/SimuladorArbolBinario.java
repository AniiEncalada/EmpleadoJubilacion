package Arboles;

import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedList;
import javax.swing.JPanel;

/**
 *
 * @author Damian Nicolai
 */
public class SimuladorArbolBinario {

    ArbolAVL miArbol = new ArbolAVL();
Empleado empleado= new Empleado(0, "", "", "", 0);

    public Empleado getEmpleado() {
        return empleado;
    }

    public SimuladorArbolBinario() {
    }

    public Empleado obtenerRaiz() {
        return miArbol.obtenerRaiz();
    }

    public boolean estaVacio() {
        return miArbol.estaVacio();
    }

    public Empleado buscarNodo(int d) {
        return miArbol.buscarNodo(d);
    }

    public boolean eliminarN(int d) {
        return miArbol.eliminarN(d);
    }

    public boolean insertar(int dato, String nom, String app, String ced, int edad) {
        return this.miArbol.insertar(dato, nom, app, ced, edad);
    }

    //metodo para mostrar los recorridos del arbol
    public String preOrden() {
        LinkedList it = this.miArbol.preOrden();
        return (recorrido(it, "Recorrido PreOrden"));
    }

    public String inOrden() {
        LinkedList it = this.miArbol.inOrden();
        return (recorrido(it, "Recorrido InOrden"));
    }

    public String postOrden() {
        LinkedList it = this.miArbol.postOrden();
        return (recorrido(it, "Recorrido PosOrden"));
    }

    //metodo para poder mostrar los tipos d recorrido
    private String recorrido(LinkedList it, String msg) {
        int i = 0;
        String r = msg + "\n";
        while (i < it.size()) {
            r += "\t" + it.get(i).toString() + "";
            i++;
        }
        return (r);
    }

    //Metodo para buscar dato en el nodo
    public String buscar(Integer dato) {
        boolean siEsta = this.miArbol.existe(dato);
        String r = "El dato:" + dato.toString() + "\n";
        r += siEsta ? "Si se encuentra en el arbol" : "No se encuentra en el arbol";
        return (r);
    }

    public JPanel getDibujo() {
        return this.miArbol.getdibujo();
    }

}
