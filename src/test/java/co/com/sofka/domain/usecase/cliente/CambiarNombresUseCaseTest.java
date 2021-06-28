package co.com.sofka.domain.usecase.cliente;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.domain.cliente.commands.CambiarNombres;
import co.com.sofka.domain.cliente.events.ClienteCreado;
import co.com.sofka.domain.cliente.events.NombresCambiados;
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

class CambiarNombresUseCaseTest {

    private CambiarNombresUseCase cambiarNombresUseCase;

    private DomainEventRepository repository;

    @BeforeEach
    public void setup(){
        cambiarNombresUseCase = new CambiarNombresUseCase();
        repository = mock(DomainEventRepository.class);
        cambiarNombresUseCase.addRepository(repository);
    }

    @Test
    void cambiarNombres() {

        var command = new CambiarNombres(
                ClienteId.of("aaa"),
                new Nombres("dsa")
        );

        when(repository.getEventsBy(any())).thenReturn(events());

        var response = UseCaseHandler.getInstance()
                .setIdentifyExecutor("aaaaa")
                .syncExecutor(
                        cambiarNombresUseCase, new RequestCommand<>(command))
                .orElseThrow();

        var events = response.getDomainEvents();

        NombresCambiados nombresCambiados = (NombresCambiados) events.get(0);
        Assertions.assertEquals(new Nombres("dsa"), nombresCambiados.getNombres());
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