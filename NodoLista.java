/**
 * Representa un nodo de una lista enlazada simple para guardar palabras reservadas.
 */
public class NodoLista {
    String palabra;
    NodoLista siguiente;

    /**
     * Constructor del nodo con la palabra.
     * @param palabra La palabra reservada a guardar.
     */
    public NodoLista(String palabra) {
        this.palabra = palabra;
        this.siguiente = null;
    }

    /**
     * Devuelve la palabra almacenada.
     * @return palabra
     */
    public String obtenerPalabra() {
        return palabra;
    }

    /**
     * Devuelve el siguiente nodo.
     * @return siguiente nodo
     */
    public NodoLista obtenerSiguiente() {
        return siguiente;
    }

    /**
     * Asigna el siguiente nodo.
     * @param siguiente El nodo siguiente.
     */
    public void asignarSiguiente(NodoLista siguiente) {
        this.siguiente = siguiente;
    }
}
