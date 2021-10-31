import java.util.Comparator;

public class OrdenarNodos implements Comparator<NodoArbolBMas>{

    @Override
    public int compare(NodoArbolBMas nodo1, NodoArbolBMas nodo2) {

        if(nodo1.datos.get(0) > nodo2.datos.get(0)) {
            return 1;
        }
        else if(nodo1.datos.get(0) < nodo2.datos.get(0)) {
            return -1;
        }
        else{
            return 0;
        }
    }
}
