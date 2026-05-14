import java.util.Scanner;

public class Ejer3 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String[] nombres = new String[5];
        double[][] notas = new double[5][4];
        double[] promedios = new double[5];

        double suma;
        double promedioGeneral = 0;

        int aprobados = 0;
        int reprobados = 0;

        int mejor = 0;
        int peor = 0;

        System.out.println("=== SISTEMA DE CALIFICACIONES ===");

        for (int i = 0; i < 5; i++) {

            scanner.nextLine();

            System.out.print("\nIngrese nombre del estudiante: ");
            nombres[i] = scanner.nextLine();

            suma = 0;

            for (int j = 0; j < 4; j++) {

                do {
                    System.out.print("Ingrese nota " + (j + 1) + ": ");
                    notas[i][j] = scanner.nextDouble();

                } while (notas[i][j] < 0 || notas[i][j] > 100);

                suma = suma + notas[i][j];
            }

            promedios[i] = suma / 4;

            promedioGeneral = promedioGeneral + promedios[i];

            if (promedios[i] >= 51) {
                aprobados++;
            } else {
                reprobados++;
            }

            if (promedios[i] > promedios[mejor]) {
                mejor = i;
            }

            if (promedios[i] < promedios[peor]) {
                peor = i;
            }
        }

        promedioGeneral = promedioGeneral / 5;

        System.out.println("\n=== RESULTADOS ===");

        for (int i = 0; i < 5; i++) {

            System.out.println("\nEstudiante: " + nombres[i]);
            System.out.println("Promedio: " + promedios[i]);
        }

        System.out.println("\nMejor estudiante: " + nombres[mejor]);
        System.out.println("Mejor promedio: " + promedios[mejor]);

        System.out.println("\nPeor estudiante: " + nombres[peor]);
        System.out.println("Peor promedio: " + promedios[peor]);

        System.out.println("\nAprobados: " + aprobados);
        System.out.println("Reprobados: " + reprobados);

        System.out.println("Promedio general del curso: " + promedioGeneral);

        scanner.close();
    }
}