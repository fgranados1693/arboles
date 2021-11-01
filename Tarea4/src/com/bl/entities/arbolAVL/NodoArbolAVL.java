package com.bl.entities.arbolAVL;

public class NodoArbolAVL {

    private int dato;
    private int fe;
    private NodoArbolAVL izq;
    private NodoArbolAVL der;

    public NodoArbolAVL() {
    }

    public NodoArbolAVL(int dato) {
        this.dato = dato;
        this.fe = 1;
        this.izq = null;
        this.der = null;
    }

    public int getDato() {
        return dato;
    }

    public void setDato(int dato) {
        this.dato = dato;
    }

    public int getFe() {
        return fe;
    }

    public void setFe(int fe) {
        this.fe = fe;
    }

    public NodoArbolAVL getIzq() {
        return izq;
    }

    public void setIzq(NodoArbolAVL izq) {
        this.izq = izq;
    }

    public NodoArbolAVL getDer() {
        return der;
    }

    public void setDer(NodoArbolAVL der) {
        this.der = der;
    }
}
