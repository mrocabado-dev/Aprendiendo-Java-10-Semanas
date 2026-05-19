package servicio;

import modelo.Estudiante;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.TreeSet;

public class GestorEstudiantes {

    private HashMap<String, Estudiante> porCarnet;

    private TreeSet<Estudiante> ranking;

    private ArrayList<String> historial;

    public GestorEstudiantes() {

        porCarnet = new HashMap<>();

        ranking = new TreeSet<>();

        historial = new ArrayList<>();
    }

    public boolean agregar(Estudiante e) {

        if (porCarnet.containsKey(
                e.getCarnet()
        )) {

            return false;
        }

        porCarnet.put(
                e.getCarnet(),
                e
        );

        ranking.add(e);

        historial.add(
                "Agregado: "
                + e.getCarnet()
        );

        return true;
    }

    public Estudiante buscar(String carnet) {

        return porCarnet.get(carnet);
    }

    public boolean eliminar(String carnet) {

        Estudiante e =
                porCarnet.get(carnet);

        if (e == null) {

            return false;
        }

        porCarnet.remove(carnet);

        ranking.remove(e);

        historial.add(
                "Eliminado: "
                + carnet
        );

        return true;
    }

    public boolean actualizarPromedio(
            String carnet,
            double nuevo
    ) {

        Estudiante e =
                porCarnet.get(carnet);

        if (e == null) {

            return false;
        }

        ranking.remove(e);

        e.setPromedio(nuevo);

        ranking.add(e);

        historial.add(
                "Actualizado promedio: "
                + carnet
        );

        return true;
    }

    public void mostrarRanking() {

        System.out.println(
                "\n=== Ranking ==="
        );

        if (ranking.isEmpty()) {

            System.out.println(
                    "No hay estudiantes"
            );

            return;
        }

        int pos = 1;

        for (Estudiante e : ranking) {

            System.out.println(
                    pos + ". " + e
            );

            pos++;
        }
    }

    public void mostrarTop5() {

        System.out.println(
                "\n=== Top 5 ==="
        );

        int count = 0;

        Estudiante[] arr =
                ranking.toArray(
                        new Estudiante[0]
                );

        int inicio =
                Math.max(
                        0,
                        arr.length - 5
                );

        for (
                int i = arr.length - 1;
                i >= inicio;
                i--
        ) {

            System.out.println(
                    (++count)
                    + ". "
                    + arr[i]
            );
        }
    }

    public void filtrarPorCarrera(
            String carrera
    ) {

        System.out.println(
                "\n=== "
                + carrera
                + " ==="
        );

        boolean encontrado = false;

        for (
                Estudiante e :
                porCarnet.values()
        ) {

            if (
                    e.getCarrera()
                    .equalsIgnoreCase(
                            carrera
                    )
            ) {

                System.out.println(e);

                encontrado = true;
            }
        }

        if (!encontrado) {

            System.out.println(
                    "Ninguno encontrado"
            );
        }
    }

    public void mostrarEstadisticas() {

        if (ranking.isEmpty()) {

            System.out.println(
                    "No hay estudiantes"
            );

            return;
        }

        double suma = 0;

        for (Estudiante e : ranking) {

            suma += e.getPromedio();
        }

        System.out.println(
                "\n=== Estadisticas ==="
        );

        System.out.println(
                "Total: "
                + ranking.size()
        );

        System.out.println(
                "Promedio general: "
                + (suma / ranking.size())
        );

        System.out.println(
                "Mejor: "
                + ranking.last()
        );

        System.out.println(
                "Peor: "
                + ranking.first()
        );
    }

    public void mostrarHistorial() {

        System.out.println(
                "\n=== Historial ==="
        );

        if (historial.isEmpty()) {

            System.out.println(
                    "Sin historial"
            );

            return;
        }

        for (String h : historial) {

            System.out.println(h);
        }
    }
}