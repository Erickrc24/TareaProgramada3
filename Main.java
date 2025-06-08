import java.util.Scanner;

/**
 * Main.java
 * Programa principal que permite al usuario interactuar con el analizador de código Java.
 */
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        LectorArchivo lector = new LectorArchivo();

        System.out.print("Ingrese el nombre del archivo Java a analizar: ");
        String nombreArchivo = sc.nextLine();

        if (nombreArchivo == null || nombreArchivo.trim().isEmpty()) {
            System.out.println("Archivo inválido. Terminando el programa.");
            return;
        }

        lector.procesarArchivo(nombreArchivo);

        int opcion = -1;

        while (opcion != 0) {
            System.out.println("\nMenú:");
            System.out.println("1. Mostrar palabras reservadas (en orden)");
            System.out.println("2. Mostrar palabras no reservadas (en orden)");
            System.out.println("3. Contar palabra reservada");
            System.out.println("4. Contar palabra no reservada");
            System.out.println("5. Verificar llaves faltantes");
            System.out.println("6. Verificar paréntesis faltantes");
            System.out.println("0. Salir");

            System.out.print("Seleccione una opción: ");
            String entrada = sc.nextLine();

            try {
                opcion = Integer.parseInt(entrada);
            } catch (NumberFormatException e) {
                System.out.println("Entrada inválida. Debe ser un número.");
                continue;
            }

            switch (opcion) {
                case 1:
                    System.out.println("Palabras reservadas:");
                    lector.obtenerArbolReservadas().imprimirEnOrden();
                    break;
                case 2:
                    System.out.println("Palabras no reservadas:");
                    lector.obtenerArbolNoReservadas().imprimirEnOrden();
                    break;
                case 3:
                    System.out.print("Ingrese palabra reservada a buscar: ");
                    String pr = sc.nextLine();
                    int cr = lector.obtenerArbolReservadas().contar(pr);
                    System.out.println("Aparece " + cr + " veces.");
                    break;
                case 4:
                    System.out.print("Ingrese palabra no reservada a buscar: ");
                    String pnr = sc.nextLine();
                    int cnr = lector.obtenerArbolNoReservadas().contar(pnr);
                    System.out.println("Aparece " + cnr + " veces.");
                    break;
                case 5:
                    int difLlaves = lector.obtenerDiferenciaLlaves();
                    if (difLlaves == 0) {
                        System.out.println("Las llaves están balanceadas.");
                    } else if (difLlaves > 0) {
                        System.out.println("Faltan " + difLlaves + " llaves de cierre.");
                    } else {
                        System.out.println("Faltan " + (-difLlaves) + " llaves de apertura.");
                    }
                    break;
                case 6:
                    int difPar = lector.obtenerDiferenciaParentesis();
                    if (difPar == 0) {
                        System.out.println("Los paréntesis están balanceados.");
                    } else if (difPar > 0) {
                        System.out.println("Faltan " + difPar + " paréntesis de cierre.");
                    } else {
                        System.out.println("Faltan " + (-difPar) + " paréntesis de apertura.");
                    }
                    break;
                case 0:
                    System.out.println("Programa finalizado.");
                    break;
                default:
                    System.out.println("Opción inválida.");
            }
        }

        sc.close();
    }
}
