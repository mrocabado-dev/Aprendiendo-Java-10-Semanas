import java.util.*;

public class Ejer2 {

    public static void main(String[] args) {

        Scanner mat = new Scanner(System.in);

        int opcion;
        int numero;
        int factorial;
        boolean primo;

        do {

            System.out.println("\n=== MENU ===");
            System.out.println("1. Calcular factorial");
            System.out.println("2. Verificar si es primo");
            System.out.println("3. Tabla de multiplicar");
            System.out.println("4. Salir");

            System.out.print("Seleccione una opcion: ");
            opcion = mat.nextInt();

            switch (opcion) {

                case 1:

                    do {
                        System.out.print("Ingrese un numero positivo: ");
                        numero = mat.nextInt();
                    } while (numero < 0);

                    factorial = 1;

                    for (int i = 1; i <= numero; i++) {
                        factorial = factorial * i;
                    }

                    System.out.println("El factorial es: " + factorial);

                    break;

                case 2:

                    do {
                        System.out.print("Ingrese un numero positivo: ");
                        numero = mat.nextInt();
                    } while (numero < 0);

                    primo = true;

                    if (numero == 0 || numero == 1) {
                        primo = false;
                    } else {

                        for (int i = 2; i < numero; i++) {

                            if (numero % i == 0) {
                                primo = false;
                            }
                        }
                    }

                    if (primo) {
                        System.out.println("El numero es primo");
                    } else {
                        System.out.println("El numero no es primo");
                    }

                    break;

                case 3:

                    do {
                        System.out.print("Ingrese un numero positivo: ");
                        numero = mat.nextInt();
                    } while (numero < 0);

                    System.out.println("\nTabla del " + numero);

                    for (int i = 1; i <= 10; i++) {

                        System.out.println(numero + " x " + i + " = " + (numero * i));
                    }

                    break;

                case 4:

                    System.out.println("Programa finalizado");
                    break;

                default:

                    System.out.println("Opcion invalida");
            }

        } while (opcion != 4);
    }
}
