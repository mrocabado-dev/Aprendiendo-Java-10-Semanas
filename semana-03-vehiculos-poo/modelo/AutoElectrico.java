package modelo;

public class AutoElectrico extends Auto implements Electrico {

    private int bateria;

    public AutoElectrico(String marca, String modelo, int anio,
                         int puertas, int bateria) {

        super(marca, modelo, anio, puertas);

        this.bateria = bateria;
    }

    @Override
    public void acelerar() {

        System.out.println(marca + " " + modelo +
                " acelera silenciosamente");
    }

    @Override
    public void cargarBateria() {

        bateria = 100;

        System.out.println("Bateria cargada");
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