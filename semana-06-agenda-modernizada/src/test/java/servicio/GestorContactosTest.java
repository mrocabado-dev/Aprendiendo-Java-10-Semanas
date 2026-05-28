package servicio;

import modelo.Contacto;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

public class GestorContactosTest {

    private GestorContactos gestor;

    @BeforeEach

    void setUp() {

        gestor = new GestorContactos();

        try {

            gestor.agregarContacto(
                    new Contacto(
                            "Ana Lopez",
                            "76543210",
                            "Amigos"
                    )
            );

            gestor.agregarContacto(
                    new Contacto(
                            "Carlos Rios",
                            "71112233",
                            "Trabajo"
                    )
            );

            gestor.agregarContacto(
                    new Contacto(
                            "Beatriz Vega",
                            "68881234",
                            "Trabajo"
                    )
            );

            gestor.agregarContacto(
                    new Contacto(
                            "David Cruz",
                            "72223344",
                            "Familia"
                    )
            );

        } catch (
                ContactoDuplicadoException e
        ) {

            fail(
                    "No deberia lanzar excepcion"
            );
        }
    }

    @Test

    void buscarPorNombreEncuentraContactoExistente() {

        Optional<Contacto> resultado =
                gestor.buscarPorNombre(
                        "Ana Lopez"
                );

        assertTrue(
                resultado.isPresent()
        );

        assertEquals(
                "76543210",
                resultado.get().getTelefono()
        );
    }

    @Test

    void buscarPorNombreRetornaVacioSiNoExiste() {

        Optional<Contacto> resultado =
                gestor.buscarPorNombre(
                        "Pedro"
                );

        assertFalse(
                resultado.isPresent()
        );
    }

    @Test

    void filtrarPorCategoriaDevuelveCorrectos() {

        List<Contacto> trabajo =
                gestor.filtrarPorCategoria(
                        "Trabajo"
                );

        assertEquals(
                2,
                trabajo.size()
        );
    }

    @Test

    void obtenerNombresDevuelveTodos() {

        List<String> nombres =
                gestor.obtenerNombres();

        assertEquals(
                4,
                nombres.size()
        );

        assertTrue(
                nombres.contains(
                        "Ana Lopez"
                )
        );
    }

    @Test

    void contarPorCategoriaRetornaCantidadCorrecta() {

        long total =
                gestor.contarPorCategoria(
                        "Trabajo"
                );

        assertEquals(
                2,
                total
        );
    }

    @Test

    void agregarDuplicadoLanzaExcepcion() {

        assertThrows(

                ContactoDuplicadoException.class,

                () -> gestor.agregarContacto(

                        new Contacto(
                                "Ana Lopez",
                                "99999999",
                                "Trabajo"
                        )
                )
        );
    }
}