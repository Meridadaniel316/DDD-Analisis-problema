package co.com.sofka.domain.usecase.cuenta;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.domain.cuenta.Cuenta;
import co.com.sofka.domain.cuenta.commands.IncrementarPuntosAcomulados;
import co.com.sofka.domain.cuenta.events.CuentaCreada;
import co.com.sofka.domain.cuenta.events.PuntosCambiados;
import co.com.sofka.domain.cuenta.values.*;
import co.com.sofka.domain.generic.DomainEvent;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class IncrementarPuntosAcomuladosUseCaseTest {

    private IncrementarPuntosAcomuladosUseCase incrementarPuntosAcomuladosUseCase;

    private DomainEventRepository repository;

    @BeforeEach
    public void setup(){
        incrementarPuntosAcomuladosUseCase = new IncrementarPuntosAcomuladosUseCase();
        repository = mock(DomainEventRepository.class);
        incrementarPuntosAcomuladosUseCase.addRepository(repository);
    }

    @Test
    void incrementarPuntos() {

        var command = new IncrementarPuntosAcomulados(
                CuentaId.of("aaa"),
                new PuntosAcomulados("100")
        );

        when(repository.getEventsBy(any())).thenReturn(events());

        var response = UseCaseHandler.getInstance()
                .setIdentifyExecutor("aaaaa")
                .syncExecutor(
                        incrementarPuntosAcomuladosUseCase, new RequestCommand<>(command))
                .orElseThrow();

        var events = response.getDomainEvents();

        PuntosCambiados puntosCambiados = (PuntosCambiados) events.get(0);
        Assertions.assertEquals(new PuntosAcomulados("100"), puntosCambiados.getPuntAcomulados());
    }

    private List<DomainEvent> events() {
        return List.of(
                new CuentaCreada(
                        new PuntosAcomulados("100"),
                        new Nombres("Nombre"),
                        new Apellidos("Apellido "),
                        new Identificacion("Identificacion"),
                        new Usuario("Usuario"),
                        new Email("Email@gmail.com")
                ));
    }
}
