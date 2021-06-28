package co.com.sofka.domain.usecase.cuenta;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.domain.cuenta.commands.CambiarIdentificacion;
import co.com.sofka.domain.cuenta.events.CuentaCreada;
import co.com.sofka.domain.cuenta.events.IdentificacionCambiada;
import co.com.sofka.domain.cuenta.values.*;
import co.com.sofka.domain.generic.DomainEvent;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class CambiarIdentificacionUseCaseTest {

    private CambiarIdentificacionUseCase cambiarIdentificacionUseCase;

    private DomainEventRepository repository;

    @BeforeEach
    public void setup(){
        cambiarIdentificacionUseCase = new CambiarIdentificacionUseCase();
        repository = mock(DomainEventRepository.class);
        cambiarIdentificacionUseCase.addRepository(repository);
    }

    @Test
    void cambiarIdentificacion() {

        var command = new CambiarIdentificacion(
                CuentaId.of("aaa"),
                new Identificacion("dsa")
        );

        when(repository.getEventsBy(any())).thenReturn(events());

        var response = UseCaseHandler.getInstance()
                .setIdentifyExecutor("aaaaa")
                .syncExecutor(
                        cambiarIdentificacionUseCase, new RequestCommand<>(command))
                .orElseThrow();

        var events = response.getDomainEvents();

        IdentificacionCambiada identificacionCambiada = (IdentificacionCambiada) events.get(0);
        Assertions.assertEquals(new Identificacion("dsa"), identificacionCambiada.getIdentificacion());
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