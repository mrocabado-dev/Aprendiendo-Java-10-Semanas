package modelo;

public class Auto extends Vehiculo {

    protected int puertas;

    public Auto(String marca, String modelo, int anio, int puertas) {

        super(marca, modelo, anio);

        this.puertas = puertas;
    }

    @Override
    public void acelerar() {

        System.out.println(marca + " " + modelo + " acelera suavemente");
    }

    @Override
    public void mostrarInfo() {

        super.mostrarInfo();

        System.out.println("Puertas: " + puertas);
        System.out.println("Tipo: Auto");
    }
}