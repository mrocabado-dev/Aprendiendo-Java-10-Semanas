package modelo;

public class Contacto {

    private String nombre;

    private String telefono;

    private String categoria;

    public Contacto(
            String nombre,
            String telefono,
            String categoria
    ) {

        this.nombre = nombre;

        this.telefono = telefono;

        this.categoria = categoria;
    }

    public String getNombre() {

        return nombre;
    }

    public String getTelefono() {

        return telefono;
    }

    public String getCategoria() {

        return categoria;
    }

    @Override

    public String toString() {

        return nombre
                + " - "
                + telefono
                + " ("
                + categoria
                + ")";
    }
}