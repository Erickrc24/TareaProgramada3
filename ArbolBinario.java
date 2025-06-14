/**
 * Representa un árbol binario ordenado para almacenar palabras del código Java.
 */
public class ArbolBinario {
    private NodoArbol raiz;

    /**
     * Constructor. Inicializa el árbol vacío.
     */
    public ArbolBinario() {
        raiz = null;
    }

    /**
     * Inserta una palabra en el árbol. Si ya existe, aumenta su cantidad.
     * @param palabra La palabra a insertar.
     */
    public void insertar(String palabra) {
        raiz = insertarRecursivo(raiz, palabra);
    }

    private NodoArbol insertarRecursivo(NodoArbol nodo, String palabra) {
        if (nodo == null) {
            return new NodoArbol(palabra);
        }

        int comparacion = palabra.compareTo(nodo.obtenerPalabra());

        if (comparacion < 0) {
            nodo.asignarIzquierdo(insertarRecursivo(nodo.obtenerIzquierdo(), palabra));
        } else if (comparacion > 0) {
            nodo.asignarDerecho(insertarRecursivo(nodo.obtenerDerecho(), palabra));
        } else {
            nodo.aumentarCantidad(); 
        }

        return nodo;
    }

    /**
     * Imprime en orden alfabético todas las palabras con su cantidad.
     */
    public void imprimirEnOrden() {
        imprimirRecursivo(raiz);
    }

    private void imprimirRecursivo(NodoArbol nodo) {
        if (nodo != null) {
            imprimirRecursivo(nodo.obtenerIzquierdo());
            System.out.println(nodo.obtenerPalabra() + " (" + nodo.obtenerCantidad() + ")");
            imprimirRecursivo(nodo.obtenerDerecho());
        }
    }

    /**
     * Cuenta cuántas veces aparece una palabra específica.
     * @param palabra La palabra a buscar.
     * @return La cantidad de veces que aparece (0 si no está).
     */
    public int contar(String palabra) {
        return contarRecursivo(raiz, palabra);
    }

    private int contarRecursivo(NodoArbol nodo, String palabra) {
        if (nodo == null) {
            return 0;
        }

        int comparacion = palabra.compareTo(nodo.obtenerPalabra());

        if (comparacion < 0) {
            return contarRecursivo(nodo.obtenerIzquierdo(), palabra);
        } else if (comparacion > 0) {
            return contarRecursivo(nodo.obtenerDerecho(), palabra);
        } else {
            return nodo.obtenerCantidad();
        }
    }
}
