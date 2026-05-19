package modelo;

public class Estudiante
        implements Comparable<Estudiante> {

    private String carnet;
    private String nombre;
    private String carrera;
    private double promedio;

    public Estudiante(
            String carnet,
            String nombre,
            String carrera,
            double promedio
    ) {

        this.carnet = carnet;
        this.nombre = nombre;
        this.carrera = carrera;
        this.promedio = promedio;
    }

    public String getCarnet() {
        return carnet;
    }

    public String getNombre() {
        return nombre;
    }

    public String getCarrera() {
        return carrera;
    }

    public double getPromedio() {
        return promedio;
    }

    public void setPromedio(double promedio) {
        this.promedio = promedio;
    }

    @Override
    public int compareTo(Estudiante otro) {

        if (this.promedio > otro.promedio) {
            return 1;
        }

        if (this.promedio < otro.promedio) {
            return -1;
        }

        return this.carnet.compareTo(
                otro.carnet
        );
    }

    @Override
    public String toString() {

        return "[" + carnet + "] "
                + nombre + " "
                + carrera + " "
                + promedio;
    }
}