package modelo;

public class Camion extends Vehiculo {

    private double capacidad;

    public Camion(String marca, String modelo, int anio, double capacidad) {

        super(marca, modelo, anio);

        this.capacidad = capacidad;
    }

    @Override
    public void acelerar() {

        System.out.println(marca + " " + modelo + " acelera lentamente");
    }

    @Override
    public void mostrarInfo() {

        super.mostrarInfo();

        System.out.println("Capacidad: " + capacidad + " toneladas");
        System.out.println("Tipo: Camion");
    }
}