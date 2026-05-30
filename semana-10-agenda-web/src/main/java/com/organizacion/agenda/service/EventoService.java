package com.organizacion.agenda.service;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import com.organizacion.agenda.modelo.Evento;

import org.springframework.stereotype.Service;

import java.io.FileReader;
import java.io.FileWriter;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

@Service
public class EventoService {

    private static final String RUTA =
            "src/main/resources/datos/eventos.json";

    private final Gson gson =
            new GsonBuilder()
                    .setPrettyPrinting()
                    .create();

    public List<Evento> listar() {

        try (FileReader reader =
                     new FileReader(RUTA)) {

            Type tipo =
                    new TypeToken<ArrayList<Evento>>() {
                    }.getType();

            List<Evento> eventos =
                    gson.fromJson(reader, tipo);

            return eventos != null
                    ? eventos
                    : new ArrayList<>();

        } catch (Exception e) {

            return new ArrayList<>();
        }
    }

    public void guardar(Evento evento) {

        List<Evento> eventos = listar();

        eventos.add(evento);

        guardarTodos(eventos);
    }

    private void guardarTodos(
            List<Evento> eventos
    ) {

        try (FileWriter writer =
                     new FileWriter(RUTA)) {

            gson.toJson(
                    eventos,
                    writer
            );

        } catch (Exception e) {

            e.printStackTrace();
        }
    }
}