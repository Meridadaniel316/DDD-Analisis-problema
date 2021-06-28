package co.com.sofka.domain.usecase.cuenta;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.domain.cuenta.commands.CambiarCorreo;
import co.com.sofka.domain.cuenta.events.CorreoCambiado;
import co.com.sofka.domain.cuenta.events.CuentaCreada;
import co.com.sofka.domain.cuenta.values.*;
import co.com.sofka.domain.generic.DomainEvent;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class CambiarEmailUseCaseTest {

    private CambiarEmailUseCase cambiarEmailUseCase;

    private DomainEventRepository repository;

    @BeforeEach
    public void setup(){
        cambiarEmailUseCase = new CambiarEmailUseCase();
        repository = mock(DomainEventRepository.class);
        cambiarEmailUseCase.addRepository(repository);
    }

    @Test
    void cambiarCorreo() {
        var command = new CambiarCorreo(
                CuentaId.of("aaa"),
                new Email("asd@gmail.com")
        );

        when(repository.getEventsBy(any())).thenReturn(events());

        var response = UseCaseHandler.getInstance()
                .setIdentifyExecutor("aaaaa")
                .syncExecutor(
                        cambiarEmailUseCase, new RequestCommand<>(command))
                .orElseThrow();

        var events = response.getDomainEvents();

        CorreoCambiado correoCambiado = (CorreoCambiado) events.get(0);
        Assertions.assertEquals(new Email("asd@gmail.com"), correoCambiado.getEmail());
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