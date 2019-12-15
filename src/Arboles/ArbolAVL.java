package Arboles;

import java.util.Date;
import java.util.LinkedList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
public class ArbolAVL {

    private Empleado raiz;
private Empleado empleado;

    public void setEmpleado(Empleado empleado) {
        this.empleado = empleado;
    }

    public Empleado getEmpleado() {
        return empleado;
    }

    public ArbolAVL() {
        raiz = null;
    }

    public Empleado obtenerRaiz() {
        return raiz;
    }

    //buscar
    public Empleado buscarNodo(int d) {
        Empleado aux = raiz;
        while (aux.getAñosServicio() != d) {
            if (d < aux.getAñosServicio()) {
                aux = aux.hijoIzquierdo;

            } else {
                aux = aux.hijoDerecho;
            }
            if (aux == null) {
                return null;
            }
        }
        return aux;
    }

    //obtener factor de equilibrio
    public int obtenerFE(Empleado x) {
        if (x == null) {
            return -1;
        } else {
            return x.fe;
        }
    }

    //rotacion simple izquierda
    public Empleado rotacionIzquierda(Empleado c) {
        Empleado auxiliar = c.hijoIzquierdo;
        c.hijoIzquierdo = auxiliar.hijoDerecho;
        auxiliar.hijoDerecho = c;
        c.fe = Math.max(obtenerFE(c.hijoIzquierdo), obtenerFE(c.hijoDerecho)) + 1;
        auxiliar.fe = Math.max(obtenerFE(auxiliar.hijoIzquierdo), obtenerFE(auxiliar.hijoDerecho)) + 1;
        return auxiliar;
    }

    //rotacion simple derecha
    public Empleado rotacionDerecha(Empleado c) {
        Empleado auxiliar = c.hijoDerecho;
        c.hijoDerecho = auxiliar.hijoIzquierdo;
        auxiliar.hijoIzquierdo = c;
        c.fe = Math.max(obtenerFE(c.hijoIzquierdo), obtenerFE(c.hijoDerecho)) + 1;
        auxiliar.fe = Math.max(obtenerFE(auxiliar.hijoIzquierdo), obtenerFE(auxiliar.hijoDerecho)) + 1;
        return auxiliar;
    }

    //rotacion doble derecha
    public Empleado rotacionDobleIzquierda(Empleado c) {
        Empleado temporal;
        c.hijoIzquierdo = rotacionDerecha(c.hijoIzquierdo);
        temporal = rotacionIzquierda(c);
        return temporal;
    }

    //rotacion Doble izquierda
    public Empleado rotacionDobleDerecha(Empleado c) {
        Empleado temporal;
        c.hijoDerecho = rotacionIzquierda(c.hijoDerecho);
        temporal = rotacionDerecha(c);
        return temporal;
    }

    //insertar AVL
    public Empleado insertarAVL(Empleado nuevo, Empleado subAr) {
        Empleado nuevoPadre = subAr;
        if (nuevo.getAñosServicio() < subAr.getAñosServicio()) {
            if (subAr.hijoIzquierdo == null) {
                subAr.hijoIzquierdo = nuevo;
            } else {
                subAr.hijoIzquierdo = insertarAVL(nuevo, subAr.hijoIzquierdo);
                if ((obtenerFE(subAr.hijoIzquierdo) - obtenerFE(subAr.hijoDerecho) == 2)) {
                    nuevoPadre = rotacionIzquierda(subAr);

                }
//                else {
//                    nuevoPadre = rotacionIzquierda(subAr);
//                }
            }
        } else {
            if (nuevo.getAñosServicio() > subAr.getAñosServicio()) {
                if (subAr.hijoDerecho == null) {
                    subAr.hijoDerecho = nuevo;
                } else {
                    subAr.hijoDerecho = insertarAVL(nuevo, subAr.hijoDerecho);
                    if ((obtenerFE(subAr.hijoDerecho) - obtenerFE(subAr.hijoIzquierdo) == 2)) {
                        if (nuevo.getAñosServicio() > subAr.hijoDerecho.getAñosServicio()) {
                            nuevoPadre = rotacionDerecha(subAr);
                        } 
//                        else {
//                            nuevoPadre = rotacionDobleDerecha(subAr);
//                        }
                    }
                }
            } else {
                JOptionPane.showMessageDialog(null, "Nodo Duplicado");
            }
        }
        //actualizar altura
        if ((subAr.hijoIzquierdo == null) && (subAr.hijoDerecho != null)) {
            subAr.fe = subAr.hijoDerecho.fe + 1;
        } else {
            if ((subAr.hijoDerecho == null) && (subAr.hijoIzquierdo != null)) {
                subAr.fe = subAr.hijoIzquierdo.fe + 1;
            } else {
                subAr.fe = Math.max(obtenerFE(subAr.hijoIzquierdo), obtenerFE(subAr.hijoDerecho)) + 1;

            }
        }
        return nuevoPadre;
    }

    public boolean estaVacio() {
        return raiz == null;
    }

    //metodo insertar
    public boolean insertar(int d, String nom, String app, String cd, int edad) {
        Empleado nuevo = new Empleado(d, nom, app, cd, edad);
        if (raiz == null) {
            raiz = nuevo;
        } else {
            raiz = insertarAVL(nuevo, raiz);
        }return true;
    }

       //Recorrido preorden, recibe el nodo a empezar (raiz) y una linkedlist para ir guardando el recorrido
    public LinkedList preOrden() {
        LinkedList rec = new LinkedList();
        preorden(raiz, rec);
        return rec;
    }
    
    public void preorden(Empleado aux, LinkedList recorrido) {
        if (aux != null) {
            recorrido.add(aux.getAñosServicio());
            preorden(aux.getHijoIzquierdo(), recorrido);
            preorden(aux.getHijoDerecho(), recorrido);
        }
    }

    //Recorrido inorden, recibe el nodo a empezar (raiz) y una linkedlist para ir guardando el recorrido
    public LinkedList inOrden() {
        LinkedList rec = new LinkedList();
        inorden(raiz, rec);
        System.out.println(rec);
        return rec;
    }
    
    public void inorden(Empleado aux, LinkedList recorrido) {
        if (aux != null) {
            inorden(aux.getHijoIzquierdo(), recorrido);
            recorrido.add(aux.getAñosServicio());
            inorden(aux.getHijoDerecho(), recorrido);
        }
    }

    //Recorrido postorden, recibe el nodo a empezar (raiz) y una linkedlist para ir guardando el recorrido
    public LinkedList postOrden() {
        LinkedList rec = new LinkedList();
        postorden(raiz, rec);
        return rec;
    }
    public void postorden(Empleado aux, LinkedList recorrido) {
        if (aux != null) {
            postorden(aux.getHijoIzquierdo(), recorrido);
            postorden(aux.getHijoDerecho(), recorrido);
            recorrido.add(aux.getAñosServicio());
        }
    }

    public boolean eliminar(int identificador) {
        boolean r=false;
        if(eliminarAux(identificador, raiz)==null){
            r=false;
        }else{
            r=true;
        }
       // raiz = eliminarAux(identificador, raiz);
       return r;
    }
//Metodo para verificar si hay un nodo en el arbol
    public boolean existe(int dato) {
        Empleado aux = raiz;
        while (aux != null) {
            if (dato == aux.getAñosServicio()) {
                return true;
            } else if (dato > aux.getAñosServicio()) {
                aux = aux.getHijoDerecho();
            } else {
                aux = aux.getHijoIzquierdo();
            }
        }
        return false;
    }
    public Empleado eliminarAux(int identificador, Empleado nodo) {
        if (nodo == null) {
            return null;
        } else {
            if (nodo.getAñosServicio() < identificador) {
                nodo.setHijoDerecho(eliminarAux(identificador, nodo.getHijoDerecho()));
            } else {
                if (nodo.getAñosServicio() > identificador) {
                    nodo.setHijoIzquierdo(eliminarAux(identificador, nodo.getHijoIzquierdo()));
                } else {
                    if (nodo.getHijoIzquierdo() == null) {
                        nodo = nodo.getHijoDerecho();
                    } else {
                        if (nodo.getHijoDerecho() == null) {
                            nodo = nodo.getHijoIzquierdo();
                        } else {
                            if (obtenerFE(nodo.getHijoIzquierdo()) > obtenerFE(nodo.getHijoDerecho())) {
                                nodo = rotacionDerecha(nodo);
                                nodo.setHijoIzquierdo(eliminarAux(identificador, nodo.getHijoIzquierdo()));
                            } else {
                                nodo = rotacionIzquierda(nodo);
                                nodo.setHijoDerecho(eliminarAux(identificador, nodo.getHijoDerecho()));
                            }
                        }
                    }
                }
                if (nodo != null) {
                    nodo.fe = obtenerFE(nodo.getHijoIzquierdo()) + obtenerFE(nodo.getHijoDerecho());
                }
            }
        }
        return nodo;
    }

    public boolean eliminarN(int d) {
        Empleado auxiliar = raiz;
        Empleado padre = raiz;
        boolean esHijoIzq = true;
        while (auxiliar.getAñosServicio() != d) {
            padre = auxiliar;
            if (d < auxiliar.getAñosServicio()) {
                esHijoIzq = true;
                auxiliar = auxiliar.hijoIzquierdo;
            } else {
                esHijoIzq = false;
                auxiliar = auxiliar.hijoDerecho;
            }
            if (auxiliar == null) {
                return false;
            }
        }
        if (auxiliar.hijoIzquierdo == null && auxiliar.hijoDerecho == null) {
            if (auxiliar == raiz) {
                raiz = null;
            } else {
                if (esHijoIzq) {
                    padre.hijoIzquierdo = null;

                } else {
                    padre.hijoDerecho = null;
                }
            }
        } else {
            if (auxiliar.hijoDerecho == null) {
                if (auxiliar == raiz) {
                    raiz = auxiliar.hijoIzquierdo;
                } else {
                    if (esHijoIzq) {
                        padre.hijoIzquierdo = auxiliar.hijoIzquierdo;

                    } else {
                        padre.hijoDerecho = auxiliar.hijoIzquierdo;
                    }
                }

            } else {
                if (auxiliar.hijoIzquierdo == null) {
                    if (auxiliar == raiz) {
                        raiz = auxiliar.hijoDerecho;
                    } else {
                        if (esHijoIzq) {
                            padre.hijoDerecho = auxiliar.hijoDerecho;
                            //////////////////////
                        } else {
                            padre.hijoDerecho = auxiliar.hijoIzquierdo;
                        }
                    }
                } else {
                    Empleado reemplazo = obtenerNodoReemplazo(auxiliar);
                    if (auxiliar == raiz) {
                        raiz = reemplazo;
                    } else {
                        if (esHijoIzq) {
                            padre.hijoIzquierdo = reemplazo;
                        } else {
                            padre.hijoDerecho = reemplazo;
                        }
                        reemplazo.hijoIzquierdo = auxiliar.hijoIzquierdo;
                    }
                }
            }

        }
        return true;
    }

    //Devolver el nodo Reemplazo
    public Empleado obtenerNodoReemplazo(Empleado nodoReem) {
        Empleado reemplazarPadre = nodoReem;
        Empleado reemplazo = nodoReem;
        Empleado auxiliar = nodoReem.hijoDerecho;

        while (auxiliar != null) {
            reemplazarPadre = reemplazo;
            reemplazo = auxiliar;
            auxiliar = auxiliar.hijoIzquierdo;
        }
        if (reemplazo != nodoReem.hijoDerecho) {
            reemplazarPadre.hijoIzquierdo = reemplazo.hijoDerecho;
            reemplazo.hijoDerecho = nodoReem.hijoDerecho;
        }
        System.out.println("El Nodo Reemplazo es " + reemplazo);
        return reemplazo;
    }
public JPanel getdibujo() {
        return new ArbolExpresionGrafico(this);
    }
}
