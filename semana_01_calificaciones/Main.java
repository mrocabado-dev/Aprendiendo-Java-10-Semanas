package semana_01_calificaciones;
import java.util.*;


public class Main {
    public static void main(String[] args) {

        // Ejercicio 1 
        Scanner mat = new Scanner(System.in);

        String nombre;
        int edad;
        double n1, n2, n3;
        double promedio;

        System.out.print("Ingrese su nombre: ");
        nombre = mat.nextLine();

        System.out.print("Ingrese su edad: ");
        edad = mat.nextInt();

        System.out.print("Ingrese nota 1: ");
        n1 = mat.nextDouble();

        System.out.print("Ingrese nota 2: ");
        n2 = mat.nextDouble();

        System.out.print("Ingrese nota 3: ");
        n3 = mat.nextDouble();

        promedio = (n1 + n2 + n3) / 3;

        System.out.println("\n=== RESULTADOS ===");
        System.out.println("Nombre: " + nombre);
        System.out.println("Edad: " + edad);
        System.out.println("Promedio: " + promedio);

        if (promedio >= 51) {
            System.out.println("Estado: APROBADO");
        } else {
            System.out.println("Estado: REPROBADO");
        }

        if (edad >= 18 && promedio >= 51) {
            System.out.println("Apto para practica");
        }
    }
}