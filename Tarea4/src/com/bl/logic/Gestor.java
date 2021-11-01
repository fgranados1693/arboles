package com.bl.logic;

import com.bl.entities.arbolAVL.ArbolAVL;
import com.bl.entities.arbolB.ArbolB;
import com.bl.entities.arbolBMas.ArbolBMas;
import com.bl.entities.arbolRojoNegro.RedBlackTree;

import java.io.PrintStream;

public class Gestor {

    static PrintStream out = System.out;

    private ArbolAVL arbolAVL;
    private ArbolB arbolB;
    private ArbolBMas arbolBMas;
    private RedBlackTree arbolRN;


    int t = 2;


    public Gestor(){
        arbolAVL = new ArbolAVL();
        arbolB = new ArbolB(t);
        arbolBMas = new ArbolBMas(4);
        arbolRN = new RedBlackTree(-2147483648);
    }

    public void insertarValor(int dato){
        arbolAVL.insertaAVL(dato);
    }

    public void mostrarArbol(){
        arbolAVL.mostrarArbolAVL();
    }

    public String MostrarInOrden(){
        return arbolAVL.inOrden();
    }

    public String MostrarPreOrden(){
        return arbolAVL.preOrden();
    }

    public String MostrarPostOrden(){
        return arbolAVL.postOrden();
    }

    public void insertarB(int dato){
        arbolB.insertar(dato);
    }

    public void mostrarB(){
        arbolB.showBTree();
    }

    public void insertarBMas(int dato){
        arbolBMas.insertar(dato);
    }

    public void mostrarBMas(){
        arbolBMas.imprimir();
    }

    public void insertarRN(int dato){
        arbolRN.insertNewNode(dato);
    }

    public void searchRN(int dato){
        if (arbolRN.searchNode(dato)) {
            out.println("Nodo encontrado");
        } else {
            out.println("Nodo no encontrado");
        }
        arbolRN.insertNewNode(dato);
    }

    public void numeroNodosRN() {
        out.println(arbolRN.nodesInTree());
    }

    public void vacioRN() {
        if (!arbolRN.checkEmpty()) {
            out.println("El Árbol Rojo-Negro no se encuentra vacío");
            out.println("Número de nodos en el Árbol Rojo-Negro: " + arbolRN.nodesInTree());
        } else {
            out.println("El Árbol Rojo-Negro se encuentra vacío");
        }
    }

    public void eliminarRN() {
        arbolRN.removeAll();
        out.println("Se han borrado los nodos en el Árbol Rojo-Negro");
    }

    public void preordenRN() {
        arbolRN.preorderTraversal();
    }

    public void enordenRN() {
        arbolRN.inorderTraversal();
    }

    public void postordenRN() {
        arbolRN.postorderTraversal();
    }
}
