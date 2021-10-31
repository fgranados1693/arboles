import java.util.ArrayList;

public class NodoArbolBMas {

    ArrayList<Integer> datos;
    ArrayList<NodoArbolBMas> enlaces;
    NodoArbolBMas enlaceHoja;
    int orden;

    public NodoArbolBMas(int orden) {
        this.orden = orden;
        datos = new ArrayList<>(2 * orden);
        enlaces = new ArrayList<>(2 * orden + 1);
        enlaceHoja = null;
    }
}
