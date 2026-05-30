package com.organizacion.agenda.views;

import com.organizacion.agenda.modelo.Contacto;

import com.organizacion.agenda.service.ContactoService;

import com.organizacion.app.ui.MainLayout;

import com.vaadin.flow.component.button.Button;

import com.vaadin.flow.component.formlayout.FormLayout;

import com.vaadin.flow.component.html.H2;

import com.vaadin.flow.component.notification
        .Notification;

import com.vaadin.flow.component.orderedlayout
        .VerticalLayout;

import com.vaadin.flow.component.textfield
        .EmailField;

import com.vaadin.flow.component.textfield
        .NumberField;

import com.vaadin.flow.component.textfield
        .TextField;

import com.vaadin.flow.data.binder.Binder;

import com.vaadin.flow.data.binder.ValidationException;

import com.vaadin.flow.router.Route;

@Route(
        value = "contactos",
        layout = MainLayout.class
)

public class ContactosView
        extends VerticalLayout {

    private final ContactoService servicio;

    private final Binder<Contacto> binder =
            new Binder<>(Contacto.class);

    private final TextField nombre =
            new TextField(
                    "Nombre completo"
            );

    private final EmailField email =
            new EmailField(
                    "Correo electronico"
            );

    private final NumberField telefono =
            new NumberField(
                    "Telefono"
            );

    public ContactosView(
            ContactoService servicio
    ) {

        this.servicio = servicio;

        setPadding(true);

        setSpacing(true);

        H2 titulo =
                new H2(
                        "Formulario de Contactos"
                );

        configurarCampos();

        FormLayout formulario =
                crearFormulario();

        configurarBinder();

        Button guardar =
                new Button(
                        "Guardar contacto"
                );

        Button limpiar =
                new Button(
                        "Limpiar"
                );

        guardar.addClickListener(
                e -> guardar()
        );

        limpiar.addClickListener(
                e -> limpiar()
        );

        add(
                titulo,
                formulario,
                guardar,
                limpiar
        );
    }

    private void configurarCampos() {

        nombre.setPlaceholder(
                "Ej: Carlos Mamani"
        );

        email.setPlaceholder(
                "correo@ejemplo.com"
        );

        telefono.setPlaceholder(
                "71234567"
        );
    }

    private FormLayout crearFormulario() {

        FormLayout layout =
                new FormLayout();

        layout.add(
                nombre,
                email,
                telefono
        );

        layout.setResponsiveSteps(

                new FormLayout.ResponsiveStep(
                        "0",
                        2
                )
        );

        layout.setColspan(
                nombre,
                2
        );

        return layout;
    }

    private void configurarBinder() {

        binder.forField(nombre)

                .asRequired(
                        "El nombre no puede estar vacio"
                )

                .bind(
                        Contacto::getNombre,
                        Contacto::setNombre
                );

        binder.forField(email)

                .asRequired(
                        "Ingresa un correo valido"
                )

                .bind(
                        Contacto::getEmail,
                        Contacto::setEmail
                );

        binder.forField(telefono)

                .bind(

                        contacto -> {

                            if (
                                    contacto.getTelefono()
                                            == null
                            ) {

                                return null;
                            }

                            return Double.valueOf(
                                    contacto.getTelefono()
                            );
                        },

                        (contacto, valor) -> {

                            if (valor != null) {

                                contacto.setTelefono(
                                        String.valueOf(
                                                valor.intValue()
                                        )
                                );
                            }
                        }
                );

        limpiar();
    }

    private void guardar() {

        Contacto contacto =
                new Contacto();

        try {

            binder.writeBean(contacto);

            servicio.agregar(contacto);

            Notification.show(
                    "Guardado: "
                            + contacto.getNombre()
            );

            limpiar();

        } catch (
                ValidationException e
        ) {

        }
    }

    private void limpiar() {

        binder.readBean(
                new Contacto()
        );
    }
}