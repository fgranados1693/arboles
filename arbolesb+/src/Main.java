import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Gestor gestor = new Gestor();

        int opcion  = -1;
        do {
            opcion = menu();
            gestor.procesarOpcion(opcion);
        } while(opcion !=0);
    }

    public static int menu() {
        Scanner keyboard = new Scanner(System.in);
        System.out.println();
        System.out.println("1. Insertar elementos en el arbolB+");
        System.out.println("2. Imprimir");
        System.out.println("0. Salir");

        int opcion = keyboard.nextInt();
        return opcion;
    }
}
