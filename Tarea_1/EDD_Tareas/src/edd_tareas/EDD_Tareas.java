package edd_tareas;

import java.util.Calendar;
import java.util.Scanner;

/**
 *
 * @author cris
 */
public class EDD_Tareas {

    public static void menuPrincipal() { // metodo que despliega el menu principal

        try { // encierra el codigo donde se podria ejecutar algun error en tiempo de ejecucion

            Scanner entrada = new Scanner(System.in); // objeto de tipo Scanner que permitira leer la opcion que se ingrese
            int a;// variable que permite acceder al menu

            //se imprime el menu principal de opciones para el usuario
            System.out.println("-------------------MENU-PRINCIPAL-------------------");
            System.out.println("1. Dia de la Semana.");
            System.out.println("2. Numeros Primos.");
            System.out.println("3. Salir.");
            a = entrada.nextInt(); // se guarda el la variable a la opcion que desea el usuario

            System.out.println("----------------------------------------------------");

            switch (a) { // switch que evalua a que opcion del menu se desea ingresar

                case 1:
                    dS();
                    break;
                case 2:
                    nPrimos();
                    break;
                case 3:

                    break;

                default:
                    System.out.println("Esta opcion no existe, elegir un numero del 1 al 3"); // como la opcion ingresada es un numero invalido, regresa al menu principal
                    EDD_Tareas.menuPrincipal();
                    break;

            }
        } catch (Exception e) { // captura del error y tratamiento del mismo

            System.out.println("¡Error! caracter invalido, intente nuevamente...");
            EDD_Tareas.menuPrincipal();
        }
    }

    public static void dS() {

        String fecha = ""; //variable que guardara la fecha para luego enviar los parametros al metodo diaSemana
        Scanner entrada = new Scanner(System.in); // objeto de tipo Scanner que permitira leer la opcion que se ingrese

        System.out.println("ingrese una fecha en formato dia/mes/año");

        fecha = entrada.nextLine();
        String[] partes = fecha.split("\\/");

        String ano = partes[2];
        String mes = partes[1];
        String dia = partes[0];
        System.out.println(diaSemana(Integer.parseInt(ano), Integer.parseInt(mes) - 1, Integer.parseInt(dia)));

    }

    public static String diaSemana(int ano, int mes, int dia) {

        String respuesta = "";

        Calendar c = Calendar.getInstance();
        c.set(ano, mes, dia); // vairables int
        dia = c.get(Calendar.DAY_OF_WEEK);

        if (dia == Calendar.MONDAY) {
            respuesta = "Lunes";
        }
        if (dia == Calendar.TUESDAY) {
            respuesta = "Martes";
        }
        if (dia == Calendar.WEDNESDAY) {
            respuesta = "Miercoles";
        }
        if (dia == Calendar.THURSDAY) {
            respuesta = "Jueves";
        }
        if (dia == Calendar.FRIDAY) {
            respuesta = "Viernes";
        }
        if (dia == Calendar.SATURDAY) {
            respuesta = "Sabado";
        }
        if (dia == Calendar.SUNDAY) {

            respuesta = "Domingo";
        }

        return respuesta;
    }

    public static void nPrimos() {

        int n, m, j; //variables necesarias para encontrar los primos deseados
        m = 2;
        j = 0;
        
        System.out.println("Ingrese el numero al que se desea encontrar sus primos:");
        Scanner entrada = new Scanner(System.in); // objeto de tipo Scanner que permitira leer la opcion que se ingrese
        n = entrada.nextInt();
        System.out.println("Los primos son:");

        while (m <= n) {

            for (int i = 2; i <= m; i++) {
                if (m % i == 0) {
                    j++;
                }

            }
            if (j == 1) {
                System.out.println(m);
            }
            j = 0;
            m++;
        }
    }

    public static void main(String[] args) {

        EDD_Tareas.menuPrincipal(); // inicio de la aplicacion

    }

}
