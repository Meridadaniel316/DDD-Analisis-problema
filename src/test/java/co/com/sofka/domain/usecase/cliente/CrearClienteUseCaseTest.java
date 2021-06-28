package co.com.sofka.domain.usecase.cliente;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.domain.cliente.commands.CrearCliente;
import co.com.sofka.domain.cliente.events.ClienteCreado;
import co.com.sofka.domain.cliente.values.*;
import co.com.sofka.domain.cuenta.values.CuentaId;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashSet;

class CrearClienteUseCaseTest {

    private CrearClienteUseCase crearClienteUseCase;

    @BeforeEach
    public void setup(){
        crearClienteUseCase = new CrearClienteUseCase();
    }

    @Test
    void crearCliente(){
        var command = new CrearCliente(ClienteId.of("x"),
                                        new CuentaId("123"),
                                        new HashSet<>(),
                                        new Nombres("Daniel"),
                                        new Apellidos("Castaño Merida"),
                                        new Identificacion("123456"));
        var response = UseCaseHandler.getInstance().syncExecutor(
                crearClienteUseCase, new RequestCommand<>(command)
        ).orElseThrow();

        var events = response.getDomainEvents();

        ClienteCreado clienteCreado = (ClienteCreado)events.get(0);
        Assertions.assertEquals("123", clienteCreado.getAccountId().value());
        Assertions.assertEquals("Daniel", clienteCreado.getNombres().value());
        Assertions.assertEquals("Castaño Merida", clienteCreado.getApellidos().value());
        Assertions.assertEquals("123456", clienteCreado.getIdentificacion().value());

    }
}