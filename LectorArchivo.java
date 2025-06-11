import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * Procesa un archivo de código Java y clasifica las palabras en árboles.
 */
public class LectorArchivo {
    private ListaEnlazadaPalabras reservadas;
    private ArbolBinario arbolReservadas;
    private ArbolBinario arbolNoReservadas;
    private int llavesAbiertas;
    private int llavesCerradas;
    private int parentesisAbiertos;
    private int parentesisCerrados;

    /**
     * Constructor: crea los árboles y carga las palabras reservadas.
     */
    public LectorArchivo() {
        reservadas = new ListaEnlazadaPalabras();
        arbolReservadas = new ArbolBinario();
        arbolNoReservadas = new ArbolBinario();
        cargarPalabrasReservadas();
    }

    /**
     * Carga las palabras reservadas en la lista enlazada.
     */
    private void cargarPalabrasReservadas() {
        String[] palabras = {
            "public", "private", "class", "{", "}", "(", ")", ";",
            "int", "double", "char", "boolean", "long", "short", "byte", "float",
            "String", "ArrayList", "Random", "new", "=", "+=", "return",
            "import", "final", "null", "void", "if", "else", "while",
            "do", "for", "try", "catch", "+", "-", "*", "/", "%"
        };

        for (int i = 0; i < palabras.length; i++) {
            reservadas.insertar(palabras[i]);
        }
    }

    /**
     * Procesa el archivo línea por línea, clasifica palabras y cuenta paréntesis/llaves.
     * @param nombreArchivo El nombre del archivo a leer.
     */
    public void procesarArchivo(String nombreArchivo) {
        boolean dentroComentarioBloque = false;

        try {
            BufferedReader lector = new BufferedReader(new FileReader(nombreArchivo));
            String linea;

            while ((linea = lector.readLine()) != null) {
                linea = linea.trim();

                if (dentroComentarioBloque) {
                    if (linea.contains("*/")) {
                        dentroComentarioBloque = false;
                        linea = linea.substring(linea.indexOf("*/") + 2);
                    } else {
                        continue;
                    }
                }

                if (linea.contains("/*")) {
                    dentroComentarioBloque = true;
                    linea = linea.substring(0, linea.indexOf("/*"));
                }

                if (linea.contains("//")) {
                    linea = linea.substring(0, linea.indexOf("//"));
                }

                if (linea.isEmpty()) continue;

                String[] palabras = linea.split("\\s+");

                for (int i = 0; i < palabras.length; i++) {
                    String palabra = palabras[i].trim();

                    contarSimbolos(palabra);

                    if (palabra.isEmpty()) continue;

                    if (reservadas.contiene(palabra)) {
                        arbolReservadas.insertar(palabra);
                    } else {
                        arbolNoReservadas.insertar(palabra);
                    }
                }
            }

            lector.close();
        } catch (IOException e) {
            System.out.println("Error al leer el archivo: " + e.getMessage());
        }
    }

    private void contarSimbolos(String palabra) {
        for (int i = 0; i < palabra.length(); i++) {
            char c = palabra.charAt(i);
            if (c == '{') llavesAbiertas++;
            if (c == '}') llavesCerradas++;
            if (c == '(') parentesisAbiertos++;
            if (c == ')') parentesisCerrados++;
        }
    }

    public ArbolBinario obtenerArbolReservadas() {
        return arbolReservadas;
    }

    public ArbolBinario obtenerArbolNoReservadas() {
        return arbolNoReservadas;
    }

    public int obtenerDiferenciaLlaves() {
        return llavesAbiertas - llavesCerradas;
    }

    public int obtenerDiferenciaParentesis() {
        return parentesisAbiertos - parentesisCerrados;
    }
}
