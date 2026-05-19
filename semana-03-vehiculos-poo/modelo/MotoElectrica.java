package modelo;

public class MotoElectrica extends Moto implements Electrico {

    private int bateria;

    public MotoElectrica(String marca, String modelo,
                         int anio, int bateria) {

        super(marca, modelo, anio, false);

        this.bateria = bateria;
    }

    @Override
    public void acelerar() {

        System.out.println(marca + " " + modelo +
                " acelera de forma electrica");
    }

    @Override
    public void cargarBateria() {

        bateria = 100;

        System.out.println("Moto cargada");
    }

    @Override
    public int getNivelBateria() {

        return bateria;
    }

    @Override
    public boolean necesitaCarga() {

        return bateria < 20;
    }

    @Override
    public void mostrarInfo() {

        super.mostrarInfo();

        System.out.println("Bateria: " + bateria + "%");
    }
}