/**
 * Representa un nodo de un árbol binario para palabras del código Java.
 */
public class NodoArbol {
    String palabra;
    int cantidad;
    NodoArbol izquierdo;
    NodoArbol derecho;

    /**
     * Constructor que inicializa el nodo con una palabra.
     * @param palabra La palabra a almacenar.
     */
    public NodoArbol(String palabra) {
        this.palabra = palabra;
        this.cantidad = 1;
        this.izquierdo = null;
        this.derecho = null;
    }

    /**
     * Devuelve la palabra almacenada.
     * @return palabra
     */
    public String obtenerPalabra() {
        return palabra;
    }

    /**
     * Devuelve la cantidad de repeticiones de esta palabra.
     * @return cantidad
     */
    public int obtenerCantidad() {
        return cantidad;
    }

    /**
     * Aumenta en 1 la cantidad de repeticiones.
     */
    public void aumentarCantidad() {
        cantidad++;
    }

    /**
     * Devuelve el hijo izquierdo.
     * @return hijo izquierdo
     */
    public NodoArbol obtenerIzquierdo() {
        return izquierdo;
    }

    /**
     * Devuelve el hijo derecho.
     * @return hijo derecho
     */
    public NodoArbol obtenerDerecho() {
        return derecho;
    }

    /**
     * Asigna el hijo izquierdo.
     * @param izquierdo nodo izquierdo
     */
    public void asignarIzquierdo(NodoArbol izquierdo) {
        this.izquierdo = izquierdo;
    }

    /**
     * Asigna el hijo derecho.
     * @param derecho nodo derecho
     */
    public void asignarDerecho(NodoArbol derecho) {
        this.derecho = derecho;
    }
}
