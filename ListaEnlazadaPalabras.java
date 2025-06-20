/**
 * Representa una lista enlazada simple de palabras reservadas de Java.
 */
public class ListaEnlazadaPalabras {
    private NodoLista cabeza;

    /**
     * Constructor. Inicializa la lista vacía.
     */
    public ListaEnlazadaPalabras() {
        cabeza = null;
    }

    /**
     * Inserta una nueva palabra reservada al final de la lista.
     * @param palabra La palabra a insertar.
     */
    public void insertar(String palabra) {
        NodoLista nuevo = new NodoLista(palabra);
        if (cabeza == null) {
            cabeza = nuevo;
        } else {
            NodoLista actual = cabeza;
            while (actual.obtenerSiguiente() != null) {
                actual = actual.obtenerSiguiente();
            }
            actual.asignarSiguiente(nuevo);
        }
    }

    /**
     * Verifica si una palabra está en la lista (es reservada).
     * @param palabra Palabra a buscar.
     * @return true si está, false si no.
     */
    public boolean contiene(String palabra) {
        NodoLista actual = cabeza;
        while (actual != null) {
            if (actual.obtenerPalabra().equals(palabra)) {
                return true;
            }
            actual = actual.obtenerSiguiente();
        }
        return false;
    }

    /**
     * Imprime todas las palabras reservadas de la lista.
     */
    public void imprimir() {
        NodoLista actual = cabeza;
        while (actual != null) {
            System.out.println(actual.obtenerPalabra());
            actual = actual.obtenerSiguiente();
        }
    }
}
