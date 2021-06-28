package co.com.sofka.domain.usecase.cuenta;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.domain.cuenta.commands.CambiarNombres;
import co.com.sofka.domain.cuenta.events.CuentaCreada;
import co.com.sofka.domain.cuenta.events.NombresCambiados;
import co.com.sofka.domain.cuenta.values.*;
import co.com.sofka.domain.generic.DomainEvent;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

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
                CuentaId.of("aaa"),
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