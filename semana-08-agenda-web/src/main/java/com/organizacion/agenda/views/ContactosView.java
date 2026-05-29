package com.organizacion.app.views;

import com.organizacion.app.ui.MainLayout;
import com.organizacion.app.ui.TarjetaContacto;

import com.vaadin.flow.component.button.Button;

import com.vaadin.flow.component.html.H2;

import com.vaadin.flow.component.notification
        .Notification;

import com.vaadin.flow.component.orderedlayout
        .HorizontalLayout;

import com.vaadin.flow.component.orderedlayout
        .VerticalLayout;

import com.vaadin.flow.router.Route;

@Route(
        value = "contactos",
        layout = MainLayout.class
)

public class ContactosView
        extends VerticalLayout {

    public ContactosView() {

        setPadding(true);

        setSpacing(true);

        H2 titulo =
                new H2(
                        "Lista de Contactos"
                );

        Button agregar =
                new Button(
                        "Agregar contacto"
                );

        agregar.addClickListener(

                e -> Notification.show(
                        "Funcion agregar pendiente"
                )
        );

        HorizontalLayout contenedor =
                new HorizontalLayout();

        contenedor.setSpacing(true);

        TarjetaContacto c1 =
                new TarjetaContacto(
                        "Ana Lopez",
                        "76543210",
                        "Amigos"
                );

        TarjetaContacto c2 =
                new TarjetaContacto(
                        "Carlos Rios",
                        "71112233",
                        "Trabajo"
                );

        TarjetaContacto c3 =
                new TarjetaContacto(
                        "Maria Vega",
                        "72223344",
                        "Familia"
                );

        contenedor.add(
                c1,
                c2,
                c3
        );

        add(
                titulo,
                agregar,
                contenedor
        );
    }
}