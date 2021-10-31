import java.util.ArrayList;
import java.util.Collections;

public class ArbolBMas {

    NodoArbolBMas raiz;
    NodoArbolBMas nodoArbolBMas = new NodoArbolBMas(4);
    NodoArbolBMas padreArbolBMas = new NodoArbolBMas(4);

    // Crear el arbol
    public ArbolBMas(int orden) {
        this.raiz = new NodoArbolBMas(orden);
    }

    public void insertar(int dato) {
        insertar(dato, nodoArbolBMas, padreArbolBMas);
    }

    private void insertar(int dato, NodoArbolBMas nodo, NodoArbolBMas padre) {

        // Encontrar el nodo hoja
        // Para ver si es un nodo padre o un nodo hoja
        if(nodo.enlaces.isEmpty()) {
            // Se inserta en la hoja si hay espacio
            // Para mantener el numero de datos maximo que se puede almacenar en una pagina
            if(nodo.datos.size() < (2 * nodo.orden)) {
                nodo.datos.add(dato);
                Collections.sort(nodo.datos);
            }
            // Si la página está llena
            else {
                if(padre.datos.isEmpty()) {
                    // Se inserta los datos del nodo raiz
                    ArrayList<Integer> aux = nodo.datos;
                    // Se añade el dato a insertar
                    aux.add(dato);
                    // Se ordena la lista
                    Collections.sort(aux);

                    NodoArbolBMas raizAux = new NodoArbolBMas(nodo.orden);
                    // Se añade el nodo del medio
                    raizAux.datos.add(aux.get(nodo.orden));
                    // Hijos
                    NodoArbolBMas auxIzq = new NodoArbolBMas(nodo.orden);
                    NodoArbolBMas auxDer = new NodoArbolBMas(nodo.orden);

                    // Se recorre el arreglo auxiliar, hasta el nodo de la mitad y toda la parte izq se vuelva a otro nodo
                    for (int i = 0; i < nodo.orden; i++) {
                        auxIzq.datos.add(aux.get(i));
                    }
                    // Se recorre el arreglo auxiliar, hasta el nodo de la mitad y toda la parte derecha del arbol
                    for (int i = nodo.orden; i <= 2 * nodo.orden; i++) {
                        auxDer.datos.add(aux.get(i));
                    }
                    raizAux.enlaces.add(auxIzq);
                    raizAux.enlaces.add(auxDer);
                    this.raiz = raizAux;
                }
                // Si el padre ya tiene hijos
                else {
                    ArrayList<Integer> aux = nodo.datos;
                    aux.add(dato);
                    Collections.sort(aux);
                    padre.datos.add(aux.get(nodo.orden));
                    Collections.sort(padre.datos);

                    NodoArbolBMas auxIzq = new NodoArbolBMas(nodo.orden);
                    NodoArbolBMas auxDer = new NodoArbolBMas(nodo.orden);

                    for (int i = 0; i < nodo.orden; i++) {
                        auxIzq.datos.add(aux.get(i));
                    }

                    for (int i = nodo.orden; i <= 2 * nodo.orden; i++) {
                        auxDer.datos.add(aux.get(i));
                    }

                    padre.enlaces.remove(nodo);
                    padre.enlaces.add(auxIzq);
                    padre.enlaces.add(auxDer);
                    Collections.sort(padre.enlaces, new OrdenarNodos());
                }
            }
        } else {

            // Contador para recorrer cada uno de los datos de la página
            // indice que se va a emplear para obtener el enlace
            int contador = 0;
            // Si el dato es menor a todos se detiene el for
            for (contador = 0; contador < nodo.datos.size(); contador++) {
                if(dato < nodo.datos.get(contador)) {
                    break;
                }
            }
            insertar(dato, nodo.enlaces.get(contador), nodo);
        }
    }

    private void imprimir(NodoArbolBMas nodo) {
        // Se imprimen las hojas
        if(nodo.enlaces.isEmpty()) {
            System.out.println(nodo.datos.toString());
        }
        else {
            for(int i = 0; i < nodo.datos.size(); i++) {
                imprimir(nodo.enlaces.get(i));
                System.out.println(nodo.datos.get(i));
            }
            imprimir(nodo.enlaces.get(nodo.enlaces.size() - 1));
        }
    }

    public void imprimir() {

        imprimir(raiz);
    }
}
