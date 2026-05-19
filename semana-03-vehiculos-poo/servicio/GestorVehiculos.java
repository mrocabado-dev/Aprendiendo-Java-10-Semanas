package servicio;

import modelo.*;

import java.util.ArrayList;

public class GestorVehiculos {

    private ArrayList<Vehiculo> flota;

    public GestorVehiculos() {

        flota = new ArrayList<>();
    }

    public void agregarVehiculo(Vehiculo v) {

        flota.add(v);

        System.out.println("Vehiculo agregado");
    }

    public void listarTodos() {

        if (flota.isEmpty()) {

            System.out.println("No hay vehiculos");
            return;
        }

        for (Vehiculo v : flota) {

            v.mostrarInfo();
        }
    }

    public void listarAutos() {

        for (Vehiculo v : flota) {

            if (v instanceof Auto &&
                !(v instanceof AutoElectrico)) {

                v.mostrarInfo();
            }
        }
    }

    public void listarMotos() {

        for (Vehiculo v : flota) {

            if (v instanceof Moto &&
                !(v instanceof MotoElectrica)) {

                v.mostrarInfo();
            }
        }
    }

    public void listarCamiones() {

        for (Vehiculo v : flota) {

            if (v instanceof Camion) {

                v.mostrarInfo();
            }
        }
    }

    public void listarElectricos() {

        for (Vehiculo v : flota) {

            if (v instanceof Electrico) {

                v.mostrarInfo();

                Electrico e = (Electrico) v;

                System.out.println(
                    "Nivel bateria: "
                    + e.getNivelBateria()
                    + "%"
                );
            }
        }
    }

    public void cargarBateriasBajas() {

        for (Vehiculo v : flota) {

            if (v instanceof Electrico) {

                Electrico e = (Electrico) v;

                if (e.necesitaCarga()) {

                    e.cargarBateria();
                }
            }
        }
    }

    public void demostrarPolimorfismo() {

        System.out.println("\n=== POLIMORFISMO ===");

        for (Vehiculo v : flota) {

            v.acelerar();
        }
    }

    public void estadisticas() {

        int total = flota.size();

        int electricos = 0;
        int necesitanCarga = 0;

        for (Vehiculo v : flota) {

            if (v instanceof Electrico) {

                electricos++;

                Electrico e = (Electrico) v;

                if (e.necesitaCarga()) {

                    necesitanCarga++;
                }
            }
        }

        System.out.println("\n=== ESTADISTICAS ===");

        System.out.println("Total: " + total);
        System.out.println("Electricos: " + electricos);

        System.out.println(
            "Necesitan carga: "
            + necesitanCarga
        );
    }
}