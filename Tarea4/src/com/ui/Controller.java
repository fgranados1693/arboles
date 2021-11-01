package com.ui;

import com.bl.logic.Gestor;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;

public class Controller {

    static PrintStream out = System.out;
    static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    static Gestor gestor = new Gestor();

    public static void menuPrincipal() throws IOException {

        int op = -1;

        out.println("Menu Principal");
        out.println(" ");
        out.println("1. Árbol AVL");
        out.println("2. Árbol B");
        out.println("3. Árbol B+");
        out.println("4. Árbol Rojo-Negro");
        out.println("0. Salir");
        out.println(" ");
        out.println("Elija una opción");
        op = Integer.parseInt(in.readLine());

        procesarOpcion(op);
    }

    public static void procesarOpcion(int op) throws IOException {

        switch (op) {
            case 1:
                menuArbolAVL();
                break;
            case 2:
                menuArbolB();
                break;
            case 3:
                menuArbolBMas();
                break;
            case 4:
                menuArbolRN();
                break;
        }
    }

    public static void menuArbolAVL () throws IOException {
        int op = -1;

        out.println("Menu Árboles AVL");
        out.println(" ");
        out.println("1. Insertar un nuevo nodo en árbol AVL");
        out.println("2. Mostrar el árbol en pre-orden");
        out.println("3. Mostrar el árbol en in-orden");
        out.println("4. Mostrar el árbol en post-orden");
        out.println("5. Mostrar una represetación gráfica del arbol");
        out.println("6. Regresar al menu principal");
        out.println("0. Salir");
        out.println(" ");
        out.println("Elija una opción");
        op = Integer.parseInt(in.readLine());

        procesarOpcionAVL(op);
    }

    public static void procesarOpcionAVL(int op) throws IOException {

        switch (op) {
            case 1:
                insertarValorAVL();
                break;
            case 2:
                mostrarPreOrdenAVL();
                break;
            case 3:
                mostrarInOrdenAVL();
                break;
            case 4:
                mostrarPostOrdenAVL();
                break;

            case 5:
                mostrarGraficamenteAVL();
                break;

            case 6:
                menuPrincipal();
                break;

        }
    }

    private static void insertarValorAVL() throws IOException {

        int dato;

        out.println("Digite el valor");
        dato = Integer.parseInt(in.readLine());
        gestor.insertarValor(dato);

        menuArbolAVL();
    }

    private static void mostrarPreOrdenAVL() throws IOException {
        out.println("Los datos del árbol en PreOrden son:");
        out.println(" ");
        out.println(gestor.MostrarPreOrden());
        menuArbolAVL();
    }

    private static void mostrarInOrdenAVL() throws IOException {
        out.println("Los datos del árbol en InOrden son:");
        out.println(" ");
        out.println(gestor.MostrarInOrden());
        menuArbolAVL();
    }

    private static void mostrarPostOrdenAVL() throws IOException {
        out.println("Los datos del árbol en PostOrden son:");
        out.println(" ");
        out.println(gestor.MostrarPostOrden());
        menuArbolAVL();

    }

    private static void mostrarGraficamenteAVL() throws IOException {
        gestor.mostrarArbol();

        menuArbolAVL();
    }

    public static void menuArbolB() throws IOException {
        int op = -1;

        out.println("Menu Árboles B");
        out.println(" ");
        out.println("1. Insertar un nuevo nodo en árbol B");
        out.println("2. Mostrar el árbol");
        out.println("3. Regresar al menu principal");
        out.println(" ");
        out.println("Elija una opción");
        op = Integer.parseInt(in.readLine());

        procesarOpcionB(op);
    }

    public static void procesarOpcionB(int op) throws IOException {

        switch (op) {
            case 1:
                insertarValorB();
                break;
            case 2:
                mostrarArbolB();
                break;
            case 3:
                menuPrincipal();
                break;
        }
    }

    private static void insertarValorB() throws IOException {

        int dato;

        out.println("Digite el valor");
        dato = Integer.parseInt(in.readLine());
        gestor.insertarB(dato);

        menuArbolB();
    }

    private static void mostrarArbolB() throws IOException {
        out.println("Los datos del árbol B son:");
        out.println(" ");
        gestor.mostrarB();
        menuArbolB();
    }

    public static void menuArbolBMas() throws IOException {
        int op = -1;

        out.println("Menu Árboles B+");
        out.println(" ");
        out.println("1. Insertar un nuevo nodo en árbol B+");
        out.println("2. Mostrar el árbol B+");
        out.println("3. Regresar al menu principal");
        out.println(" ");
        out.println("Elija una opción");
        op = Integer.parseInt(in.readLine());

        procesarOpcionBMas(op);
    }

    public static void procesarOpcionBMas(int op) throws IOException {

        switch (op) {
            case 1:
                insertarValorBMas();
                break;
            case 2:
                mostrarArbolBMas();
                break;
            case 3:
                menuPrincipal();
                break;
        }
    }

    private static void insertarValorBMas() throws IOException {
        int dato;

        out.println("Digite el valor");
        dato = Integer.parseInt(in.readLine());
        gestor.insertarBMas(dato);

        menuArbolBMas();
    }

    private static void mostrarArbolBMas() throws IOException {
        out.println("Los datos del árbol B+ son:");
        out.println(" ");
        gestor.mostrarBMas();

        menuArbolBMas();
    }

    public static void menuArbolRN() throws IOException {
        int op = -1;

        out.println("Menu Árboles Rojo-Negro");
        out.println(" ");
        out.println("1. Insertar un nuevo nodo en árbol Rojo-Negro");
        out.println("2. Buscar nodo");
        out.println("3. Desplegar el número de nodos en el árbol Rojo-Negro");
        out.println("4. Verificar si el árbol Rojo-Negro se encuentra vacío");
        out.println("5. Eliminar todos los nodos del árbol Rojo-Negro");
        out.println("6. Desplegar el árbol Rojo-Negro en pre-orden");
        out.println("7. Desplegar el árbol Rojo-Negro en en-orden");
        out.println("8. Desplegar el árbol Rojo-Negro en post-orden");
        out.println("9. Regresar al menu principal");
        out.println("0. Salir");
        out.println(" ");
        out.println("Elija una opción");
        op = Integer.parseInt(in.readLine());

        procesarOpcionRN(op);
    }

    public static void procesarOpcionRN(int op) throws IOException {

        switch (op) {
            case 1:
                insertarValorRN();
                break;
            case 2:
                searchRN();
                break;
            case 3:
                numeroNodosRN();
                break;
            case 4:
                vacioRN();
                break;

            case 5:
                eliminarRN();
                break;

            case 6:
                preordenRN();
                break;

            case 7:
                enordenRN();
                break;

            case 8:
                postordenRN();
                break;

            case 9:
                menuPrincipal();
                break;

        }
    }

    private static void insertarValorRN() throws IOException {
        int dato;

        out.println("Ingrese el número a insertar en el árbol Rojo-Negro:");
        dato = Integer.parseInt(in.readLine());
        gestor.insertarRN(dato);

        menuArbolRN();
    }

    private static void searchRN() throws IOException {
        int dato;

        out.println("Ingrese el número que desea buscar:");
        dato = Integer.parseInt(in.readLine());
        gestor.searchRN(dato);

        menuArbolRN();
    }

    private static void numeroNodosRN() throws IOException {
        out.println("\"Número de nodos en el Arbol Rojo-Negro:");
        out.println(" ");
        gestor.numeroNodosRN();

        menuArbolRN();
    }

    private static void vacioRN() throws IOException {
        gestor.vacioRN();

        menuArbolRN();
    }

    private static void eliminarRN() throws IOException {
        gestor.eliminarRN();

        menuArbolRN();
    }

    private static void preordenRN() throws IOException {
        out.println("Los datos del árbol en PreOrden son:");
        out.println(" ");
        gestor.preordenRN();

        menuArbolRN();
    }

    private static void enordenRN() throws IOException {
        out.println("Los datos del árbol en InOrden son:");
        out.println(" ");
        gestor.enordenRN();

        menuArbolRN();
    }

    private static void postordenRN() throws IOException {
        out.println("Los datos del árbol en PostOrden son:");
        out.println(" ");
        gestor.postordenRN();

        menuArbolRN();
    }

}
