package co.com.sofka.domain.usecase.cliente;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.domain.cliente.commands.CambiarApellidos;
import co.com.sofka.domain.cliente.events.ApellidosCambiados;
import co.com.sofka.domain.cliente.events.ClienteCreado;
import co.com.sofka.domain.cliente.values.*;
import co.com.sofka.domain.cuenta.values.CuentaId;
import co.com.sofka.domain.generic.DomainEvent;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class CambiarApellidosUseCaseTest {
    private CambiarApellidosUseCase cambiarApellidosUseCase;

    private DomainEventRepository repository;

    @BeforeEach
    public void setup(){
        cambiarApellidosUseCase = new CambiarApellidosUseCase();
        repository = mock(DomainEventRepository.class);
        cambiarApellidosUseCase.addRepository(repository);
    }

    @Test
    void cambiarApellidos() {

        var command = new CambiarApellidos(
                ClienteId.of("aaa"),
                new Apellidos("dsa")
        );

        when(repository.getEventsBy(any())).thenReturn(events());

        var response = UseCaseHandler.getInstance()
                .setIdentifyExecutor("aaaaa")
                .syncExecutor(
                        cambiarApellidosUseCase, new RequestCommand<>(command))
                .orElseThrow();

        var events = response.getDomainEvents();

        ApellidosCambiados apellidosCambiados = (ApellidosCambiados) events.get(0);
        Assertions.assertEquals(new Apellidos("dsa"), apellidosCambiados.getApellidos());
    }

    private List<DomainEvent> events() {
        return List.of(
                new ClienteCreado(
                        new CuentaId("123"),
                        new HashSet<>(), new Nombres("Nombre"),
                        new Apellidos("Apellido "),
                        new Identificacion("Identificacion")
                ));
    }
}