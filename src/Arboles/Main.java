package Arboles;

import javax.swing.JOptionPane;

/**
 *
 * @author Usuario
 */
public class Main {
public static void main(String[] args) {
        int opcion=0;
        int elemento;
        String nombre;
        
        ArbolAVL arbolito = new ArbolAVL();
        do{
            try {
                opcion = Integer.parseInt(JOptionPane.showInputDialog(null, " 1.Insertar Nodo\n"
                +" 2.Recorrer InOrden!\n"
                +" 3.Recorrer PreOrden\n"
                +" 4.Recorrer PostOrden\n"
                +" 5.Buscar un Nodo\n"
                +" 6.Eliminar un Nodo\n"        
                +" 7.Salir\n"
                +" Elige una opcion!", JOptionPane.QUESTION_MESSAGE));
                switch(opcion){
                    case 1:
                       int añoServicio = Integer.parseInt(JOptionPane.showInputDialog(null, " Ingresa el numero del nodo.."
                                ," Agregando nodo :D!",JOptionPane.QUESTION_MESSAGE));
                       nombre = JOptionPane.showInputDialog(null, " Ingresa el nombre del nodo.."
                                ," Agregando nodo :D!",JOptionPane.QUESTION_MESSAGE);
                      String apellido = JOptionPane.showInputDialog(null, " Ingresa el nombre del nodo.."
                                ," Agregando nodo :D!",JOptionPane.QUESTION_MESSAGE);

                      String cedula = JOptionPane.showInputDialog(null, " Ingresa el nombre del nodo.."
                                ," Agregando nodo :D!",JOptionPane.QUESTION_MESSAGE);
                      int edad= Integer.parseInt(JOptionPane.showInputDialog("iNGRESE EDAD"));
                        arbolito.insertar(añoServicio,nombre, apellido, cedula, edad);
                        break;
                    case 2:
                        if(!arbolito.estaVacio()){
                            System.out.println();
                            arbolito.inOrden();
                        }else{
                            JOptionPane.showMessageDialog(null, "El arbol esta vacio!","!Cuidado!",JOptionPane.QUESTION_MESSAGE);
                        }
                        break;
                    case 3:
                        if(!arbolito.estaVacio()){
                            System.out.println();
                            arbolito.preOrden();
                        }else{
                            JOptionPane.showMessageDialog(null, "El arbol esta vacio!","!Cuidado!",JOptionPane.QUESTION_MESSAGE);
                        }
                        break;
                    case 4:
                        if(!arbolito.estaVacio()){
                            System.out.println();
                            arbolito.postOrden();
                        }else{
                            JOptionPane.showMessageDialog(null, "El arbol esta vacio!","!Cuidado!",JOptionPane.QUESTION_MESSAGE);
                        }
                        break;
                    case 5:
                        if(!arbolito.estaVacio()){
                            elemento = Integer.parseInt(JOptionPane.showInputDialog(null, " Ingresa el numero del nodo que desea buscar! "
                                ," Buscando nodo :D!",JOptionPane.QUESTION_MESSAGE));
                           
                            if(arbolito.buscarNodo(elemento)==null){
                                JOptionPane.showMessageDialog(null, "Nodo "+ elemento+" no encontrado!","!Cuidado!",JOptionPane.QUESTION_MESSAGE);
                            }else{
                                System.out.println("Nodo "+elemento+" Encontrado!");
                            }
                        }else{
                            JOptionPane.showMessageDialog(null, "El arbol esta vacio!","!Cuidado!",JOptionPane.QUESTION_MESSAGE);
                        }
                        break;
                    case 6:
                        if(!arbolito.estaVacio()){
                            elemento = Integer.parseInt(JOptionPane.showInputDialog(null, " Ingresa el numero del nodo que desea eliminar! "
                                ," Eliminando nodo :D!",JOptionPane.QUESTION_MESSAGE));
                           
                            if(arbolito.eliminarN(elemento)==false){
                                JOptionPane.showMessageDialog(null, "Nodo no encontrado!","!Cuidado!",JOptionPane.QUESTION_MESSAGE);
                            }else{
                                JOptionPane.showMessageDialog(null, "EL Nodo ha sido Eliminado!","!Nodo Eliminado!",JOptionPane.QUESTION_MESSAGE); 
                            }
                        }else{
                            JOptionPane.showMessageDialog(null, "El arbol esta vacio!","!Cuidado!",JOptionPane.QUESTION_MESSAGE);
                        }
                        break;
                    case 7:
                        JOptionPane.showMessageDialog(null, "Aplicacion Finalizada","Fin",JOptionPane.QUESTION_MESSAGE);
                        break;
                    default:
                        JOptionPane.showMessageDialog(null, "Opcion Incorrecta","Cuidado",JOptionPane.QUESTION_MESSAGE);
                }
            } catch (NumberFormatException n) {
                JOptionPane.showMessageDialog(null, " Error "+ n.getMessage());
            }
        }while(opcion !=7);
    }    
}
