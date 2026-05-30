package com.organizacion.agenda.service;

import com.google.gson.Gson;

import com.google.gson.GsonBuilder;

import com.google.gson.reflect.TypeToken;

import com.organizacion.agenda.modelo.Contacto;

import java.io.FileReader;

import java.io.FileWriter;

import java.lang.reflect.Type;

import java.util.ArrayList;

import java.util.List;

public class ManejadorJSON {

    private static final String RUTA =
            "src/main/resources/datos/contactos.json";

    private static final Gson gson =
            new GsonBuilder()
                    .setPrettyPrinting()
                    .create();

    public static List<Contacto> cargar() {

        try (

                FileReader reader =
                        new FileReader(RUTA)

        ) {

            Type tipo =
                    new TypeToken<
                            ArrayList<Contacto>
                            >() {}.getType();

            List<Contacto> contactos =
                    gson.fromJson(
                            reader,
                            tipo
                    );

            return contactos != null
                    ? contactos
                    : new ArrayList<>();

        } catch (Exception e) {

            return new ArrayList<>();
        }
    }

    public static void guardar(
            List<Contacto> contactos
    ) {

        try (

                FileWriter writer =
                        new FileWriter(RUTA)

        ) {

            gson.toJson(
                    contactos,
                    writer
            );

        } catch (Exception e) {

            e.printStackTrace();
        }
    }
}