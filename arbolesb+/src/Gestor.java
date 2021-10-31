import java.util.Scanner;

public class Gestor {

    ArbolBMas arbolBMas = new ArbolBMas(4);

    public void insertar() {
        Scanner keyboard = new Scanner(System.in);
        String salir;
        do {
            System.out.println("Digite el elemento a insertar: ");
            int valor = keyboard.nextInt();
            arbolBMas.insertar(valor);
            System.out.println("Desea salir (S/N)");
            salir = keyboard.next();

        } while(!salir.equals("s"));
    }

    public void imprimir() {
        arbolBMas.imprimir();
    }

    public String procesarOpcion(int opcion){

        String mensaje = "";

        switch (opcion){

            case 1: insertar();
                break;
            case 2: imprimir();
                break;
            case 0:  mensaje = "Saliendo";
                break;
            default: mensaje = "Valor incorrecto";
        }
        return mensaje;
    }
}
