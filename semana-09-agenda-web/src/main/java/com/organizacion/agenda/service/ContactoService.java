package com.organizacion.agenda.service;

import com.organizacion.agenda.modelo.Contacto;

import org.springframework.stereotype.Service;

import java.util.ArrayList;

import java.util.List;

@Service

public class ContactoService {

    private List<Contacto> contactos;

    public ContactoService() {

        contactos =
                ManejadorJSON.cargar();
    }

    public List<Contacto> listar() {

        return contactos;
    }

    public void agregar(
            Contacto contacto
    ) {

        contactos.add(contacto);

        ManejadorJSON.guardar(
                contactos
        );
    }

    public void eliminar(
            Contacto contacto
    ) {

        contactos.remove(contacto);

        ManejadorJSON.guardar(
                contactos
        );
    }

    public void actualizar() {

        ManejadorJSON.guardar(
                contactos
        );
    }

    public List<Contacto>
    buscarPorNombre(
            String texto
    ) {

        if (
                texto == null
                        || texto.isBlank()
        ) {

            return contactos;
        }

        List<Contacto> filtrados =
                new ArrayList<>();

        for (Contacto c : contactos) {

            if (

                    c.getNombre()

                            .toLowerCase()

                            .contains(
                                    texto.toLowerCase()
                            )
            ) {

                filtrados.add(c);
            }
        }

        return filtrados;
    }
}