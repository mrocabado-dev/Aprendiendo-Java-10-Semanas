package servicio;

import exception.ContactoExistenteException;
import exception.ContactoNoEncontradoException;

import modelo.Contacto;

import util.ManejadorJSON;

import java.io.File;
import java.util.ArrayList;

public class AgendaContactos {

    private ArrayList<Contacto> contactos;

    private final String RUTA =
            "data/contactos.json";

    private final String BACKUP =
            "data/contactos.backup.json";

    public AgendaContactos() {

        contactos =
                ManejadorJSON.cargar(RUTA);
    }

    private void persistir() {

        hacerBackup();

        ManejadorJSON.guardar(
                RUTA,
                contactos
        );
    }

    private void hacerBackup() {

        File archivo =
                new File(RUTA);

        if (archivo.exists()) {

            ManejadorJSON.guardar(
                    BACKUP,
                    contactos
            );
        }
    }

    public void agregar(
            Contacto c
    ) throws ContactoExistenteException {

        for (Contacto contacto : contactos) {

            if (
                    contacto.getTelefono()
                            .equals(
                                    c.getTelefono()
                            )
            ) {

                throw new ContactoExistenteException(
                        "Telefono repetido"
                );
            }
        }

        contactos.add(c);

        persistir();
    }

    public Contacto buscarPorId(
            String id
    ) throws ContactoNoEncontradoException {

        for (Contacto c : contactos) {

            if (
                    c.getId()
                            .equalsIgnoreCase(id)
            ) {

                return c;
            }
        }

        throw new ContactoNoEncontradoException(
                "Contacto no encontrado"
        );
    }

    public ArrayList<Contacto>
    buscarPorNombre(
            String fragmento
    ) {

        ArrayList<Contacto> lista =
                new ArrayList<>();

        for (Contacto c : contactos) {

            if (
                    c.getNombre()
                            .toLowerCase()
                            .contains(
                                    fragmento.toLowerCase()
                            )
            ) {

                lista.add(c);
            }
        }

        return lista;
    }

    public void editar(
            String id,
            String telefono,
            String email
    ) throws ContactoNoEncontradoException {

        Contacto c =
                buscarPorId(id);

        c.setTelefono(telefono);

        c.setEmail(email);

        persistir();
    }

    public void eliminar(
            String id
    ) throws ContactoNoEncontradoException {

        Contacto c =
                buscarPorId(id);

        contactos.remove(c);

        persistir();
    }

    public ArrayList<Contacto>
    listarTodos() {

        return new ArrayList<>(
                contactos
        );
    }

    public int total() {

        return contactos.size();
    }

    public int totalConEmail() {

        int contador = 0;

        for (Contacto c : contactos) {

            if (
                    !c.getEmail()
                            .isEmpty()
            ) {

                contador++;
            }
        }

        return contador;
    }
}