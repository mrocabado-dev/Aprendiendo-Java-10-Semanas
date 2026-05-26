import exception.ContactoExistenteException;
import exception.ContactoNoEncontradoException;
import exception.DatoInvalidoException;

import modelo.Contacto;

import servicio.AgendaContactos;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc =
                new Scanner(System.in);

        AgendaContactos agenda =
                new AgendaContactos();

        int opcion = -1;

        while (opcion != 7) {

            try {

                System.out.println(
                        "\n=== AGENDA CONTACTOS ==="
                );

                System.out.println(
                        "1. Agregar contacto"
                );

                System.out.println(
                        "2. Listar contactos"
                );

                System.out.println(
                        "3. Buscar contacto"
                );

                System.out.println(
                        "4. Editar contacto"
                );

                System.out.println(
                        "5. Eliminar contacto"
                );

                System.out.println(
                        "6. Estadisticas"
                );

                System.out.println(
                        "7. Salir"
                );

                System.out.print(
                        "Opcion: "
                );

                opcion = sc.nextInt();

                sc.nextLine();

                switch (opcion) {

                    case 1:

                        agregar(sc, agenda);

                        break;

                    case 2:

                        listar(agenda);

                        break;

                    case 3:

                        buscar(sc, agenda);

                        break;

                    case 4:

                        editar(sc, agenda);

                        break;

                    case 5:

                        eliminar(sc, agenda);

                        break;

                    case 6:

                        estadisticas(agenda);

                        break;

                    case 7:

                        System.out.println(
                                "Programa finalizado"
                        );

                        break;

                    default:

                        System.out.println(
                                "Opcion invalida"
                        );
                }

            } catch (
                    InputMismatchException e
            ) {

                System.out.println(
                        "Debe ingresar numeros"
                );

                sc.nextLine();
            }
        }
    }

    public static void agregar(
            Scanner sc,
            AgendaContactos agenda
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
                    "Email: "
            );

            String email =
                    sc.nextLine();

            System.out.print(
                    "Direccion: "
            );

            String direccion =
                    sc.nextLine();

            Contacto c =
                    new Contacto(
                            nombre,
                            telefono,
                            email,
                            direccion
                    );

            agenda.agregar(c);

            System.out.println(
                    "Contacto agregado"
            );

        } catch (
                DatoInvalidoException
                        | ContactoExistenteException e
        ) {

            System.out.println(
                    e.getMessage()
            );
        }
    }

    public static void listar(
            AgendaContactos agenda
    ) {

        ArrayList<Contacto> lista =
                agenda.listarTodos();

        System.out.println(
                "\n=== CONTACTOS ==="
        );

        for (Contacto c : lista) {

            System.out.println(c);
        }
    }

    public static void buscar(
            Scanner sc,
            AgendaContactos agenda
    ) {

        try {

            System.out.println(
                    "1. Buscar por ID"
            );

            System.out.println(
                    "2. Buscar por nombre"
            );

            int op = sc.nextInt();

            sc.nextLine();

            if (op == 1) {

                System.out.print(
                        "ID: "
                );

                String id =
                        sc.nextLine();

                Contacto c =
                        agenda.buscarPorId(id);

                System.out.println(
                        c.toStringDetalle()
                );

            } else {

                System.out.print(
                        "Nombre: "
                );

                String nombre =
                        sc.nextLine();

                ArrayList<Contacto>
                        resultados =
                        agenda.buscarPorNombre(
                                nombre
                        );

                for (Contacto c :
                        resultados) {

                    System.out.println(c);
                }
            }

        } catch (
                ContactoNoEncontradoException e
        ) {

            System.out.println(
                    e.getMessage()
            );
        }
    }

    public static void editar(
            Scanner sc,
            AgendaContactos agenda
    ) {

        try {

            System.out.print(
                    "ID: "
            );

            String id =
                    sc.nextLine();

            System.out.print(
                    "Nuevo telefono: "
            );

            String tel =
                    sc.nextLine();

            System.out.print(
                    "Nuevo email: "
            );

            String email =
                    sc.nextLine();

            agenda.editar(
                    id,
                    tel,
                    email
            );

            System.out.println(
                    "Contacto actualizado"
            );

        } catch (
                Exception e
        ) {

            System.out.println(
                    e.getMessage()
            );
        }
    }

    public static void eliminar(
            Scanner sc,
            AgendaContactos agenda
    ) {

        try {

            System.out.print(
                    "ID: "
            );

            String id =
                    sc.nextLine();

            agenda.eliminar(id);

            System.out.println(
                    "Contacto eliminado"
            );

        } catch (
                Exception e
        ) {

            System.out.println(
                    e.getMessage()
            );
        }
    }

    public static void estadisticas(
            AgendaContactos agenda
    ) {

        int total =
                agenda.total();

        int conEmail =
                agenda.totalConEmail();

        int sinEmail =
                total - conEmail;

        System.out.println(
                "\n=== ESTADISTICAS ==="
        );

        System.out.println(
                "Total: " + total
        );

        System.out.println(
                "Con email: " + conEmail
        );

        System.out.println(
                "Sin email: " + sinEmail
        );
    }
}