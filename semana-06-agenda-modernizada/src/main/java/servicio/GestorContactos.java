package servicio;

import modelo.Contacto;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class GestorContactos {

    private List<Contacto> contactos =
            new ArrayList<>();

    public void agregarContacto(
            Contacto contacto
    ) throws ContactoDuplicadoException {

        boolean existe =
                contactos.stream()

                        .anyMatch(
                                c -> c.getNombre()
                                        .equalsIgnoreCase(
                                                contacto.getNombre()
                                        )
                        );

        if (existe) {

            throw new ContactoDuplicadoException(
                    "Ya existe: "
                            + contacto.getNombre()
            );
        }

        contactos.add(contacto);
    }

    public Optional<Contacto>
    buscarPorNombre(
            String nombre
    ) {

        return contactos.stream()

                .filter(
                        c -> c.getNombre()
                                .equalsIgnoreCase(nombre)
                )

                .findFirst();
    }

    public List<Contacto>
    filtrarPorCategoria(
            String categoria
    ) {

        return contactos.stream()

                .filter(
                        c -> c.getCategoria()
                                .equalsIgnoreCase(categoria)
                )

                .collect(Collectors.toList());
    }

    public List<String>
    obtenerNombres() {

        return contactos.stream()

                .map(Contacto::getNombre)

                .collect(Collectors.toList());
    }

    public long contarPorCategoria(
            String categoria
    ) {

        return contactos.stream()

                .filter(
                        c -> c.getCategoria()
                                .equalsIgnoreCase(categoria)
                )

                .count();
    }

    public List<Contacto>
    listarOrdenados() {

        return contactos.stream()

                .sorted(
                        Comparator.comparing(
                                Contacto::getNombre
                        )
                )

                .collect(Collectors.toList());
    }

    public List<Contacto>
    obtenerTodos() {

        return contactos;
    }
}