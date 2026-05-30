package com.organizacion.agenda.views;

import com.organizacion.agenda.modelo.Evento;
import com.organizacion.agenda.service.EventoService;

import com.organizacion.app.ui.MainLayout;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.datepicker.DatePicker;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextArea;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.binder.Binder;
import com.vaadin.flow.data.binder.ValidationException;
import com.vaadin.flow.router.Route;

@Route(
        value = "eventos",
        layout = MainLayout.class
)
public class EventosView
        extends VerticalLayout {

    private final EventoService servicio;

    private final Binder<Evento> binder =
            new Binder<>(Evento.class);

    private final TextField titulo =
            new TextField("Titulo");

    private final DatePicker fecha =
            new DatePicker("Fecha");

    private final TextArea descripcion =
            new TextArea("Descripcion");

    private final Grid<Evento> grid =
            new Grid<>(Evento.class);

    public EventosView(
            EventoService servicio
    ) {

        this.servicio = servicio;

        H2 encabezado =
                new H2("Gestion de Eventos");

        Button guardar =
                new Button(
                        "Guardar Evento",
                        e -> guardarEvento()
                );

        binder.bind(
                titulo,
                Evento::getTitulo,
                Evento::setTitulo
        );

        binder.forField(fecha)
                .bind(
                        evento ->
                                evento.getFecha() == null
                                        ? null
                                        : java.time.LocalDate.parse(
                                        evento.getFecha()
                                ),
                        (evento, valor) ->
                                evento.setFecha(
                                        valor != null
                                                ? valor.toString()
                                                : ""
                                )
                );

        binder.bind(
                descripcion,
                Evento::getDescripcion,
                Evento::setDescripcion
        );

        actualizarGrid();

        add(
                encabezado,
                titulo,
                fecha,
                descripcion,
                guardar,
                grid
        );
    }

    private void guardarEvento() {

        Evento evento =
                new Evento();

        try {

            binder.writeBean(
                    evento
            );

            servicio.guardar(
                    evento
            );

            Notification.show(
                    "Evento guardado"
            );

            binder.readBean(
                    new Evento()
            );

            actualizarGrid();

        } catch (
                ValidationException e
        ) {

            Notification.show(
                    "Datos invalidos"
            );
        }
    }

    private void actualizarGrid() {

        grid.setItems(
                servicio.listar()
        );
    }
}