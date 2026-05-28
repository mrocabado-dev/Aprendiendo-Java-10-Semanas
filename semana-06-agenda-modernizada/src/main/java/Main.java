import modelo.Contacto;

import servicio.ContactoDuplicadoException;
import servicio.GestorContactos;

import util.ManejadorJSON;

import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc =
                new Scanner(System.in);

        GestorContactos gestor =
                new GestorContactos();

        List<Contacto> datos =
                ManejadorJSON.cargar(
                        "datos/contactos.json"
                );

        for (Contacto c : datos) {

            try {

                gestor.agregarContacto(c);

            } catch (
                    ContactoDuplicadoException e
            ) {

                System.out.println(
                        e.getMessage()
                );
            }
        }

        int opcion = 0;

        while (opcion != 7) {

            System.out.println(
                    "\n=== AGENDA DE CONTACTOS ==="
            );

            System.out.println(
                    "1. Agregar contacto"
            );

            System.out.println(
                    "2. Buscar por nombre"
            );

            System.out.println(
                    "3. Listar todos"
            );

            System.out.println(
                    "4. Listar ordenados"
            );

            System.out.println(
                    "5. Filtrar por categoria"
            );

            System.out.println(
                    "6. Ver nombres"
            );

            System.out.println(
                    "7. Guardar y salir"
            );

            System.out.print(
                    "Opcion: "
            );

            opcion = sc.nextInt();

            sc.nextLine();

            switch (opcion) {

                case 1:

                    agregar(sc, gestor);

                    break;

                case 2:

                    buscar(sc, gestor);

                    break;

                case 3:

                    listar(gestor);

                    break;

                case 4:

                    listarOrdenados(gestor);

                    break;

                case 5:

                    filtrar(sc, gestor);

                    break;

                case 6:

                    verNombres(gestor);

                    break;

                case 7:

                    ManejadorJSON.guardar(
                            gestor.obtenerTodos(),
                            "datos/contactos.json"
                    );

                    System.out.println(
                            "Datos guardados"
                    );

                    break;

                default:

                    System.out.println(
                            "Opcion invalida"
                    );
            }
        }
    }

    public static void agregar(
            Scanner sc,
            GestorContactos gestor
    ) {

        try {

            System.out.print(
                    "Nombre: "
            );

            String nombre =
                    sc.nextLine();

            System.out.print(
                    "Telefono: "
            );

            String telefono =
                    sc.nextLine();

            System.out.print(
                    "Categoria: "
            );

            String categoria =
                    sc.nextLine();

            gestor.agregarContacto(
                    new Contacto(
                            nombre,
                            telefono,
                            categoria
                    )
            );

            System.out.println(
                    "Contacto agregado"
            );

        } catch (
                ContactoDuplicadoException e
        ) {

            System.out.println(
                    e.getMessage()
            );
        }
    }

    public static void buscar(
            Scanner sc,
            GestorContactos gestor
    ) {

        System.out.print(
                "Nombre a buscar: "
        );

        String nombre =
                sc.nextLine();

        Optional<Contacto> resultado =
                gestor.buscarPorNombre(nombre);

        resultado.ifPresentOrElse(

                contacto ->
                        System.out.println(
                                "Contacto encontrado: "
                                        + contacto
                        ),

                () ->
                        System.out.println(
                                "No se encontro ningun contacto"
                        )
        );
    }

    public static void listar(
            GestorContactos gestor
    ) {

        gestor.obtenerTodos()

                .forEach(System.out::println);
    }

    public static void listarOrdenados(
            GestorContactos gestor
    ) {

        gestor.listarOrdenados()

                .forEach(System.out::println);
    }

    public static void filtrar(
            Scanner sc,
            GestorContactos gestor
    ) {

        System.out.print(
                "Categoria: "
        );

        String categoria =
                sc.nextLine();

        List<Contacto> lista =
                gestor.filtrarPorCategoria(
                        categoria
                );

        lista.forEach(System.out::println);
    }

    public static void verNombres(
            GestorContactos gestor
    ) {

        gestor.obtenerNombres()

                .forEach(System.out::println);
    }
}