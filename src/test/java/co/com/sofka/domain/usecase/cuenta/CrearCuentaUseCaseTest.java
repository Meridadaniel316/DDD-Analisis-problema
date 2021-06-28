package co.com.sofka.domain.usecase.cuenta;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.domain.cuenta.commands.CrearCuenta;
import co.com.sofka.domain.cuenta.events.CuentaCreada;
import co.com.sofka.domain.cuenta.values.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CrearCuentaUseCaseTest {

    private CrearCuentaUseCase crearCuentaUseCase;

    @BeforeEach
    public void setup(){
        crearCuentaUseCase = new CrearCuentaUseCase();
    }

    @Test
    void crearCuenta(){
        var command = new CrearCuenta(CuentaId.of("x"),
                                      new PuntosAcomulados("100"),
                                      new Nombres("Daniel"),
                                      new Apellidos("Castaño"),
                                      new Identificacion("123"),
                                      new Usuario("Merida"),
                                      new Email("Merida@test.com"));

        var response = UseCaseHandler.getInstance().syncExecutor(
                crearCuentaUseCase, new RequestCommand<>(command)
        ).orElseThrow();

        var events = response.getDomainEvents();

        CuentaCreada cuentaCreada = (CuentaCreada)events.get(0);
        Assertions.assertEquals("Merida@test.com", cuentaCreada.getEmail().value());
        Assertions.assertEquals("100", cuentaCreada.getPuntAcomulados().value());
        Assertions.assertEquals("123", cuentaCreada.getIdentificacion().value());
        Assertions.assertEquals("Castaño", cuentaCreada.getApellidos().value());
        Assertions.assertEquals("Daniel", cuentaCreada.getNombres().value());
        Assertions.assertEquals("Merida", cuentaCreada.getUsuario().value());

    }

}