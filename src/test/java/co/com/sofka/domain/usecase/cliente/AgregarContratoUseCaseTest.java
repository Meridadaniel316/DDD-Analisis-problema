package co.com.sofka.domain.usecase.cliente;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.domain.cliente.commands.AgregarContrato;
import co.com.sofka.domain.cliente.events.ClienteCreado;
import co.com.sofka.domain.cliente.events.ContratoAgregado;
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

class AgregarContratoUseCaseTest {
    private AgregarContratoUseCase agregarContratoUseCase;

    private DomainEventRepository repository;

    @BeforeEach
    public void setup(){
        agregarContratoUseCase = new AgregarContratoUseCase();
        repository = mock(DomainEventRepository.class);
        agregarContratoUseCase.addRepository(repository);
    }

    @Test
    void agregarContrato() {

        var command = new AgregarContrato(
                ClienteId.of("ASD"),
                ContratoId.of("sad"),
                new Descripcion("asa")
        );
        when(repository.getEventsBy(any())).thenReturn(events());

        var response = UseCaseHandler.getInstance().syncExecutor(
                agregarContratoUseCase, new RequestCommand<>(command)
        ).orElseThrow();

        var events = response.getDomainEvents();

        ContratoAgregado contratoAgregado = (ContratoAgregado) events.get(0);
        Assertions.assertEquals("sad", contratoAgregado.getId().value());
        Assertions.assertEquals("asa", contratoAgregado.getDescripcion().value());
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