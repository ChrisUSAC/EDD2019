
package edd_tareas;

/**
 *
 * @author cris
 */
public class Celda {
     
    Object x,y; // contendra el dato del nodo de la posicion en  y la posicion en y
    Celda siguiente; // enlace correspondiente al nodo
    
    public Celda(Object x,Object y){
    
        this.x=x;
        this.y=y;
        siguiente=this; // el nodo apunta a si mismo
    }
    
}
