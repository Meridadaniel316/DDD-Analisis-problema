package co.com.sofka.domain.usecase.cliente;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.domain.cliente.commands.AsociarCuenta;
import co.com.sofka.domain.cliente.events.ClienteCreado;
import co.com.sofka.domain.cliente.events.CuentaAsociada;
import co.com.sofka.domain.cliente.values.Apellidos;
import co.com.sofka.domain.cliente.values.ClienteId;
import co.com.sofka.domain.cliente.values.Identificacion;
import co.com.sofka.domain.cliente.values.Nombres;
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

class AsociarCuentaUseCaseTest {
    private AsociarCuentaUseCase asociarCuentaUseCase;

    private DomainEventRepository repository;

    @BeforeEach
    public void setup(){
        asociarCuentaUseCase = new AsociarCuentaUseCase();
        repository = mock(DomainEventRepository.class);
        asociarCuentaUseCase.addRepository(repository);
    }

    @Test
    void asociarCuenta() {

        var command = new AsociarCuenta(
                ClienteId.of("ASD"),
                CuentaId.of("sad")
        );

        when(repository.getEventsBy(any())).thenReturn(events());

        var response = UseCaseHandler.getInstance()
                .setIdentifyExecutor("aaaaa")
                .syncExecutor(
                        asociarCuentaUseCase, new RequestCommand<>(command))
                .orElseThrow();

        var events = response.getDomainEvents();

        CuentaAsociada cuentaAsociada = (CuentaAsociada) events.get(0);
        Assertions.assertEquals(new CuentaId("sad"), cuentaAsociada.getCuentaId());
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