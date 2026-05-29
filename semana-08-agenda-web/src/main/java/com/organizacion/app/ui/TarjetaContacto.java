package com.organizacion.app.ui;

import com.vaadin.flow.component.button.Button;

import com.vaadin.flow.component.html.Div;

import com.vaadin.flow.component.html.H3;

import com.vaadin.flow.component.html.Paragraph;

import com.vaadin.flow.component.notification
        .Notification;

import com.vaadin.flow.component.orderedlayout
        .VerticalLayout;

public class TarjetaContacto
        extends VerticalLayout {

    public TarjetaContacto(
            String nombre,
            String telefono,
            String categoria
    ) {

        addClassName(
                "tarjeta-contacto"
        );

        setSpacing(true);

        setPadding(true);

        setWidth("300px");

        getStyle()

                .set(
                        "border",
                        "1px solid #ccc"
                )

                .set(
                        "border-radius",
                        "10px"
                )

                .set(
                        "box-shadow",
                        "2px 2px 8px #ddd"
                );

        H3 titulo =
                new H3(nombre);

        Paragraph tel =
                new Paragraph(
                        "Telefono: "
                                + telefono
                );

        Paragraph cat =
                new Paragraph(
                        "Categoria: "
                                + categoria
                );

        Button editar =
                new Button(
                        "Editar"
                );

        editar.addClickListener(

                e -> Notification.show(
                        "Editando contacto: "
                                + nombre
                )
        );

        add(
                titulo,
                tel,
                cat,
                editar
        );
    }
}