package com.bl.entities.arbolAVL;

public class ArbolAVL {

    NodoArbolAVL raiz;

    public ArbolAVL() {
        this.raiz = null;
    }

    public NodoArbolAVL getRaiz() {
        return raiz;
    }

    public void setRaiz(NodoArbolAVL raiz) {
        this.raiz = raiz;
    }

    // MÉTODO MAX
    // Devuelve el mayor entre dos números
    private int max(int a, int b) {
        return (a > b) ? a : b;
    }

    // MÉTODO GETFE
    // Devuelve el factor de equilibrio del nodoArbolAVL
    private int getFE(NodoArbolAVL nodoArbolAVL) {
        if (nodoArbolAVL == null) {
            return 0;
        }
        return nodoArbolAVL.getFe();
    }

    // MÉTODO MAX
    // Calcula el factor de equilibrio del nodo
    private int getFactorEquilibrio(NodoArbolAVL nodoArbolAVLActual) {
        if (nodoArbolAVLActual == null) {
            return 0;
        }
        return getFE(nodoArbolAVLActual.getIzq()) - getFE(nodoArbolAVLActual.getDer());
    }



    // MÉTODO BUSCAR
    private NodoArbolAVL buscar (int d, NodoArbolAVL r){
        if (raiz == null){
            return null;
        } else if (r.getDato()== d){
            return r;
        } else if (r.getDato()<d){
            return buscar(d,r.getDer());
        } else {
            return buscar(d,r.getIzq());
        }
    }

    public NodoArbolAVL buscar(int d) {
        return buscar(d,getRaiz());
    }

    // MÉTODO INSERTAR
    public void insertaAVL(int d) {
        setRaiz(insertAVL(raiz,d));
    }

    private NodoArbolAVL insertAVL(NodoArbolAVL raiz, int nuevo) {
        if (raiz == null) {
            return (new NodoArbolAVL(nuevo));
        }

        if (nuevo < raiz.getDato()) {
            raiz.setIzq(insertAVL(raiz.getIzq(),nuevo));
        }else if (nuevo > raiz.getDato()) {
            raiz.setDer(insertAVL(raiz.getDer(),nuevo));
        }else {// Si la clave esta duplicada retorna el mismo nodo encontrado
            return raiz;
        }

        //Actualizacion del FE
        raiz.setFe(1 +
                max(getFE(raiz.getIzq()), getFE(raiz.getDer())));

        // Se obtiene el factor de equilibrio
        int fe = getFactorEquilibrio(raiz);

        // Caso Rotacion Simple a la derecha
        if (fe > 1 && nuevo < raiz.getIzq().getDato()) {
            return rotacionSimpleDerecha(raiz);
        }

        // Caso Rotacion Simple a la izquierda

        if (fe < -1 && nuevo > raiz.getDer().getDato()) {
            return rotacionSimpleIzquierda(raiz);
        }

        // Caso Rotacion Doble Izquierda Derecha
        if (fe > 1 && nuevo > raiz.getIzq().getDato()) {
            raiz.setIzq(rotacionSimpleIzquierda(raiz.getIzq()));
            return rotacionSimpleDerecha(raiz);
        }

        // Caso Rotacion Doble Derecha Izquierda
        if (fe < -1 && nuevo < raiz.getDer().getDato()) {
            raiz.setDer(rotacionSimpleDerecha(raiz.getDer()));
            return rotacionSimpleIzquierda(raiz);
        }

        return raiz;
    }

    private NodoArbolAVL rotacionSimpleIzquierda(NodoArbolAVL raiz) {
        NodoArbolAVL nuevaRaiz = raiz.getDer();
        NodoArbolAVL temp = nuevaRaiz.getIzq();

        // Se realiza la rotacion
        nuevaRaiz.setIzq(raiz);
        raiz.setDer(temp);

        // Actualiza FE
        raiz.setFe(max(getFE(raiz.getIzq()), getFE(raiz.getDer()))+ 1);
        nuevaRaiz.setFe(max(getFE(nuevaRaiz.getIzq()), getFE(nuevaRaiz.getDer()))+ 1);

        return nuevaRaiz;
    }

    private NodoArbolAVL rotacionSimpleDerecha(NodoArbolAVL raiz) {
        NodoArbolAVL nuevaRaiz = raiz.getIzq();
        NodoArbolAVL temp = nuevaRaiz.getDer();

        // Se realiza la rotacion
        nuevaRaiz.setDer(raiz);
        raiz.setIzq(temp);

        // Actualiza FE
        raiz.setFe(max(getFE(raiz.getIzq()), getFE(raiz.getDer()))+ 1);
        nuevaRaiz.setFe(max(getFE(nuevaRaiz.getIzq()), getFE(nuevaRaiz.getDer()))+ 1);

        return nuevaRaiz;
    }

    // MÉTODOS MOSTRARARBOLAVL Y SHOWTREE
    // Imprime una representación visual del arbol AVL
    public void mostrarArbolAVL() {
        System.out.println("Representación gráfica del arbol AVL");
        showTree(raiz, 0);
    }

    private void showTree(NodoArbolAVL raiz, int depth) {
        if (raiz.getDer() != null) {
            showTree(raiz.getDer(), depth + 1);
        }
        for (int i = 0; i < depth; i++) {
            System.out.print("    ");
        }
        System.out.println("(" + raiz.getDato() + ")");

        if (raiz.getIzq() != null) {
            showTree(raiz.getIzq(), depth + 1);
        }
    }

    // MÉTODO INORDEN
    // Recorre arbol AVL en in-orden
    private String inOrden(NodoArbolAVL aux, String res) {
        if (aux != null) {
            if (aux.getIzq() != null) {
                res = inOrden(aux.getIzq(), res);
            }
            res += aux.getDato() + ",";
            if (aux.getDer() != null) {
                res = inOrden(aux.getDer(), res);

            }
        }
        return res;
    }

    public String inOrden() {
        return inOrden(getRaiz(), "IN:");
    }

    // MÉTODO PREORDEN
    // Recorre arbol AVL en pre-orden
    private String preOrden(NodoArbolAVL aux, String res) {
        if (aux != null) {
            res += aux.getDato() + ",";
            if (aux.getIzq() != null) {
                res = preOrden(aux.getIzq(), res);
            }
            if (aux.getDer() != null) {
                res = preOrden(aux.getDer(), res);
            }
        }
        return res;
    }

    public String preOrden() {
        return preOrden(getRaiz(), "PRE:");
    }

    // MÉTODO POSTORDEN
    // Recorre arbol AVL en post-orden
    private String postOrden(NodoArbolAVL aux, String res) {
        if (aux != null) {
            if (aux.getIzq() != null) {
                res = postOrden(aux.getIzq(), res);
            }
            if (aux.getDer() != null) {
                res = postOrden(aux.getDer(), res);
            }
            res += aux.getDato() + ",";
        }
        return res;
    }

    public String postOrden() {
        return postOrden(getRaiz(), "POST:");
    }
}

