package edd_tareas;

import javax.swing.JOptionPane;

/**
 *
 * @author cris
 */
public class Bolsa {

    Celda ultimo; //apuntador referente a las bolsas

    public Bolsa() {

        ultimo = null;
    }

    //metodo para saber cuando la listaBolsa esta vacia
    public boolean estaVacia() {

        return ultimo == null;
    }

    //metodo para insertar Bolsas a la lista de Bolsas
    public Bolsa insertar(Object x, Object y) {

        Celda nuevo = new Celda(x, y);

        if (ultimo != null) { // solo si ultimo es diferente de null

            nuevo.siguiente = ultimo.siguiente;
            ultimo.siguiente = nuevo;
        }
        ultimo = nuevo;
        return this;

    }

    //metodo para mostrar la lista
    public void mostrarLista() {

        Celda auxiliar = ultimo.siguiente;
        String cadena = "";
        do {

            cadena = cadena + "[" + auxiliar.x + "]" + "[" + auxiliar.y + "]->";
            auxiliar = auxiliar.siguiente;
        } while (auxiliar != ultimo.siguiente);

        JOptionPane.showMessageDialog(null, cadena, "Mostrando La Lista Circular", JOptionPane.INFORMATION_MESSAGE);

    }

    public int contarDesde(Object x, Object y) {
        int contar = 0;

        Celda auxiliar = ultimo.siguiente;
        Celda aux2 = ultimo.siguiente;

        if (estaVacia()) {
            System.out.println("la lista aun no tiene bolsas");
        } else {

            if (existenParametros(x, y)) {
                contar += 1;
                while (auxiliar.siguiente != ultimo.siguiente) {

                    if (auxiliar.x == x && auxiliar.y == y) {

                        contar += 1;
                        aux2 = auxiliar;
                        aux2 = aux2.siguiente;

                        x = aux2.x;
                        y = aux2.y;
                    }

                    auxiliar = auxiliar.siguiente;

                }

                System.out.println("numero de elementos: " + contar);
            } else {
                System.out.println("elementos no encontrados");

            }

        }

        return contar;
    }

    public boolean existenParametros(Object x, Object y) {

        boolean existen = false;

        Celda auxiliar = ultimo.siguiente;

        do {
            if (auxiliar.x == x && auxiliar.y == y) {

                existen = true;
            }

            auxiliar = auxiliar.siguiente;
        } while (auxiliar != ultimo.siguiente);

        return existen;
    }

}
