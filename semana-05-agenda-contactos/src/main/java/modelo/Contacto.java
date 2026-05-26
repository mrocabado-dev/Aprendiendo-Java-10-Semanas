package modelo;

import exception.DatoInvalidoException;

public class Contacto {

    private static int contador = 1;

    private String id;

    private String nombre;

    private String telefono;

    private String email;

    private String direccion;

    public Contacto(
            String nombre,
            String telefono,
            String email,
            String direccion
    ) {

        this.id = generarId();

        setNombre(nombre);

        setTelefono(telefono);

        setEmail(email);

        setDireccion(direccion);
    }

    private String generarId() {

        return String.format(
                "C%03d",
                contador++
        );
    }

    public String getId() {

        return id;
    }

    public String getNombre() {

        return nombre;
    }

    public String getTelefono() {

        return telefono;
    }

    public String getEmail() {

        return email;
    }

    public String getDireccion() {

        return direccion;
    }

    public void setNombre(
            String nombre
    ) {

        if (nombre == null
                || nombre.trim().isEmpty()) {

            throw new DatoInvalidoException(
                    "Nombre vacio"
            );
        }

        this.nombre = nombre;
    }

    public void setTelefono(
            String telefono
    ) {

        if (!telefono.matches("\\d{7,8}")) {

            throw new DatoInvalidoException(
                    "Telefono invalido"
            );
        }

        this.telefono = telefono;
    }

    public void setEmail(
            String email
    ) {

        if (!email.isEmpty()
                && !email.contains("@")) {

            throw new DatoInvalidoException(
                    "Email invalido"
            );
        }

        this.email = email;
    }

    public void setDireccion(
            String direccion
    ) {

        this.direccion = direccion;
    }

    @Override

    public String toString() {

        return id
                + " | "
                + nombre
                + " | "
                + telefono
                + " | "
                + email;
    }

    public String toStringDetalle() {

        return "ID: " + id
                + "\nNombre: " + nombre
                + "\nTelefono: " + telefono
                + "\nEmail: " + email
                + "\nDireccion: " + direccion;
    }
}