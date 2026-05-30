package com.organizacion.agenda.service;

import com.organizacion.agenda.modelo.Contacto;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ContactoServiceTest {

    @Test

    void agregarContacto() {

        ContactoService servicio =
                new ContactoService();

        int antes =
                servicio.listar().size();

        Contacto contacto =
                new Contacto(
                        "Carlos Mamani",
                        "carlos@correo.com",
                        "79876543"
                );

        servicio.agregar(contacto);

        int despues =
                servicio.listar().size();

        assertEquals(
                antes + 1,
                despues
        );
    }

    @Test

    void buscarPorNombre() {

        ContactoService servicio =
                new ContactoService();

        Contacto contacto =
                new Contacto(
                        "Ana Lopez",
                        "ana@correo.com",
                        "71234567"
                );

        servicio.agregar(contacto);

        boolean encontrado =

                servicio

                        .buscarPorNombre("Ana")

                        .stream()

                        .anyMatch(

                                c -> c.getNombre()

                                        .equals(
                                                "Ana Lopez"
                                        )
                        );

        assertTrue(encontrado);
    }
}