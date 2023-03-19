package org.example;
import java.util.Scanner;

public class MostrarMain {
    public void mostrar(){
        Scanner scanner = new Scanner(System.in);
        Polinomio polinomio = new Polinomio();

        while (true) {
            System.out.println("\nMenú:");
            System.out.println("1. Agregar término");
            System.out.println("2. Modificar término");
            System.out.println("3. Eliminar término");
            System.out.println("4. Sumar otro polinomio");
            System.out.println("5. Multiplicar por otro polinomio");
            System.out.println("6. Mostrar polinomio");
            System.out.println("7. Salir");
            System.out.print("Seleccione una opción: ");

            int opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    System.out.print("Ingrese coeficiente: ");
                    int coeficiente = scanner.nextInt();
                    System.out.print("Ingrese exponente: ");
                    int exponente = scanner.nextInt();
                    polinomio.agregarTermino(coeficiente, exponente);
                    break;
                case 2:
                    System.out.print("Ingrese el nuevo coeficiente: ");
                    int nuevoCoeficiente = scanner.nextInt();
                    System.out.print("Ingrese exponente del término a modificar: ");
                    int exponenteModificar = scanner.nextInt();
                    polinomio.modificarTermino(nuevoCoeficiente, exponenteModificar);
                    break;
                case 3:
                    System.out.print("Ingrese exponente del término a eliminar: ");
                    int exponenteEliminar = scanner.nextInt();
                    polinomio.eliminarTermino(exponenteEliminar);
                    break;
                case 4:
                    Polinomio otroPolinomioSuma = leerPolinomio(scanner);
                    polinomio = (Polinomio) polinomio.sumar(otroPolinomioSuma);
                    break;
                case 5:
                    Polinomio otroPolinomioMultiplicar = leerPolinomio(scanner);
                    polinomio = (Polinomio) polinomio.multiplicar(otroPolinomioMultiplicar);
                    break;
                case 6:

                    System.out.printf("Polinomio: %s%n", polinomio.toString());
                    break;
                case 7:
                    System.out.println("Saliendo...");
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Opción inválida. Intente de nuevo.");
            }
        }
    }

    private static Polinomio leerPolinomio(Scanner scanner) {
        Polinomio polinomio = new Polinomio();
        System.out.print("Ingrese el número de términos del polinomio: ");
        int numTerminos = scanner.nextInt();

        for (int i = 0; i < numTerminos; i++) {
            System.out.print("Ingrese coeficiente: ");
            int coeficiente = scanner.nextInt();
            System.out.print("Ingrese exponente: ");
            int exponente = scanner.nextInt();
            polinomio.agregarTermino(coeficiente, exponente);
        }

        return polinomio;
    }
    public static void aux(){
        MostrarMain mostrarMain = new MostrarMain();
        mostrarMain.mostrar();
    }
}

