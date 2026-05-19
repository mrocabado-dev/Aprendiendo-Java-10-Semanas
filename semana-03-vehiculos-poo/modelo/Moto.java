package modelo;

public class Moto extends Vehiculo {

    private boolean deportiva;

    public Moto(String marca, String modelo, int anio, boolean deportiva) {

        super(marca, modelo, anio);

        this.deportiva = deportiva;
    }

    @Override
    public void acelerar() {

        System.out.println(marca + " " + modelo + " acelera rapidamente");
    }

    @Override
    public void mostrarInfo() {

        super.mostrarInfo();

        System.out.println("Deportiva: " + deportiva);
        System.out.println("Tipo: Moto");
    }
}