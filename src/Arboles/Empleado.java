package Arboles;

import java.util.Date;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author Usuario
 */
@Getter
@Setter
public class Empleado {
//Atributos fundamentales
    private int añosServicio;
    int fe;
    Empleado hijoIzquierdo;
    Empleado hijoDerecho;
    //Datos extra
    private String nombre;
    private String apellido;
    private String Cedula;
    private int edad;

    public Empleado(int añoServicio,String nombre, String apellido,  String Cedula,int edad) {
        this.añosServicio = añoServicio;
        this.fe = 0;
        this.hijoIzquierdo = null;
        this.hijoDerecho = null;
        this.nombre = nombre;
        this.apellido = apellido;
        this.Cedula = Cedula;
        this.edad=edad;
    }
    

}
