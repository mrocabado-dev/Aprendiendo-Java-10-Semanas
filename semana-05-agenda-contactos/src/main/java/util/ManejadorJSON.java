package util;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import modelo.Contacto;

import java.io.FileReader;
import java.io.FileWriter;

import java.lang.reflect.Type;

import java.util.ArrayList;

public class ManejadorJSON {

    private static final Gson gson =
            new GsonBuilder()
                    .setPrettyPrinting()
                    .create();

    public static ArrayList<Contacto>
    cargar(
            String ruta
    ) {

        try (

                FileReader reader =
                        new FileReader(ruta)

        ) {

            Type tipo =
                    new TypeToken<
                            ArrayList<Contacto>
                            >() {}.getType();

            ArrayList<Contacto> lista =
                    gson.fromJson(
                            reader,
                            tipo
                    );

            if (lista == null) {

                return new ArrayList<>();
            }

            return lista;

        } catch (Exception e) {

            return new ArrayList<>();
        }
    }

    public static void guardar(
            String ruta,
            ArrayList<Contacto> contactos
    ) {

        try (

                FileWriter writer =
                        new FileWriter(ruta)

        ) {

            gson.toJson(
                    contactos,
                    writer
            );

        } catch (Exception e) {

            System.out.println(
                    "Error guardando JSON"
            );
        }
    }
}