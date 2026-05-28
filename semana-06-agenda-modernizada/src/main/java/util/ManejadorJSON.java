package util;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import modelo.Contacto;

import java.io.FileReader;
import java.io.FileWriter;

import java.lang.reflect.Type;

import java.util.ArrayList;
import java.util.List;

public class ManejadorJSON {

    private static final Gson gson =
            new GsonBuilder()
                    .setPrettyPrinting()
                    .create();

    public static void guardar(
            List<Contacto> contactos,
            String ruta
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

    public static List<Contacto>
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

            List<Contacto> contactos =
                    gson.fromJson(
                            reader,
                            tipo
                    );

            if (contactos == null) {

                return new ArrayList<>();
            }

            return contactos;

        } catch (Exception e) {

            return new ArrayList<>();
        }
    }
}