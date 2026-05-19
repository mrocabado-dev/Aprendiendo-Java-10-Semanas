import modelo.*;
import servicio.GestorVehiculos;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        GestorVehiculos gestor =
                new GestorVehiculos();

        // === DEMOSTRACION DE POLIMORFISMO ===

        gestor.agregarVehiculo(
                new Auto("Toyota",
                        "Corolla",
                        2024,
                        4)
        );

        gestor.agregarVehiculo(
                new Moto("Honda",
                        "CB500",
                        2023,
                        false)
        );

        gestor.agregarVehiculo(
                new Camion("Volvo",
                        "FH16",
                        2022,
                        24.0)
        );

        gestor.agregarVehiculo(
                new AutoElectrico("Tesla",
                        "Model 3",
                        2024,
                        4,
                        80)
        );

        gestor.agregarVehiculo(
                new MotoElectrica("NIU",
                        "MQi+",
                        2023,
                        15)
        );

        gestor.demostrarPolimorfismo();

        int opcion;

        do {

            System.out.println("\n=== GESTION VEHICULOS ===");

            System.out.println("1. Agregar vehiculo");
            System.out.println("2. Listar todos");
            System.out.println("3. Filtrar por tipo");
            System.out.println("4. Ver electricos");
            System.out.println("5. Cargar baterias");
            System.out.println("6. Polimorfismo");
            System.out.println("7. Estadisticas");
            System.out.println("8. Salir");

            System.out.print("Opcion: ");

            opcion = sc.nextInt();

            switch (opcion) {

                case 1:

                    agregarVehiculo(sc, gestor);

                    break;

                case 2:

                    gestor.listarTodos();

                    break;

                case 3:

                    menuFiltros(sc, gestor);

                    break;

                case 4:

                    gestor.listarElectricos();

                    break;

                case 5:

                    gestor.cargarBateriasBajas();

                    break;

                case 6:

                    gestor.demostrarPolimorfismo();

                    break;

                case 7:

                    gestor.estadisticas();

                    break;

                case 8:

                    System.out.println("Adios");

                    break;

                default:

                    System.out.println("Opcion invalida");
            }

        } while (opcion != 8);
    }

    public static void agregarVehiculo(
            Scanner sc,
            GestorVehiculos gestor
    ) {

        System.out.println("\n1. Auto");
        System.out.println("2. Moto");
        System.out.println("3. Camion");
        System.out.println("4. Auto electrico");
        System.out.println("5. Moto electrica");

        int tipo = sc.nextInt();

        sc.nextLine();

        System.out.print("Marca: ");
        String marca = sc.nextLine();

        System.out.print("Modelo: ");
        String modelo = sc.nextLine();

        System.out.print("Año: ");
        int anio = sc.nextInt();

        switch (tipo) {

            case 1:

                System.out.print("Puertas: ");
                int puertas = sc.nextInt();

                gestor.agregarVehiculo(
                        new Auto(
                                marca,
                                modelo,
                                anio,
                                puertas
                        )
                );

                break;

            case 2:

                gestor.agregarVehiculo(
                        new Moto(
                                marca,
                                modelo,
                                anio,
                                false
                        )
                );

                break;

            case 3:

                System.out.print("Capacidad: ");
                double capacidad = sc.nextDouble();

                gestor.agregarVehiculo(
                        new Camion(
                                marca,
                                modelo,
                                anio,
                                capacidad
                        )
                );

                break;

            case 4:

                System.out.print("Puertas: ");
                int p = sc.nextInt();

                System.out.print("Bateria: ");
                int b = sc.nextInt();

                gestor.agregarVehiculo(
                        new AutoElectrico(
                                marca,
                                modelo,
                                anio,
                                p,
                                b
                        )
                );

                break;

            case 5:

                System.out.print("Bateria: ");
                int bateria = sc.nextInt();

                gestor.agregarVehiculo(
                        new MotoElectrica(
                                marca,
                                modelo,
                                anio,
                                bateria
                        )
                );

                break;

            default:

                System.out.println("Tipo invalido");
        }
    }

    public static void menuFiltros(
            Scanner sc,
            GestorVehiculos gestor
    ) {

        System.out.println("\n1. Autos");
        System.out.println("2. Motos");
        System.out.println("3. Camiones");

        int op = sc.nextInt();

        switch (op) {

            case 1:

                gestor.listarAutos();

                break;

            case 2:

                gestor.listarMotos();

                break;

            case 3:

                gestor.listarCamiones();

                break;

            default:

                System.out.println("Opcion invalida");
        }
    }
}