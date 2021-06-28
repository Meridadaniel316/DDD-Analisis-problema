package co.com.sofka.domain.usecase.cuenta;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.domain.cuenta.commands.CambiarUsuario;
import co.com.sofka.domain.cuenta.events.CuentaCreada;
import co.com.sofka.domain.cuenta.events.UsuarioCambiado;
import co.com.sofka.domain.cuenta.values.*;
import co.com.sofka.domain.generic.DomainEvent;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class CambiarUsuarioUseCaseTest {
    private CambiarUsuarioUseCase cambiarUsuarioUseCase;

    private DomainEventRepository repository;

    @BeforeEach
    public void setup(){
        cambiarUsuarioUseCase = new CambiarUsuarioUseCase();
        repository = mock(DomainEventRepository.class);
        cambiarUsuarioUseCase.addRepository(repository);
    }

    @Test
    void cambiarUsuario() {

        var command = new CambiarUsuario(
                CuentaId.of("aaa"),
                new Usuario("dsa")
        );

        when(repository.getEventsBy(any())).thenReturn(events());

        var response = UseCaseHandler.getInstance()
                .setIdentifyExecutor("aaaaa")
                .syncExecutor(
                        cambiarUsuarioUseCase, new RequestCommand<>(command))
                .orElseThrow();

        var events = response.getDomainEvents();

        UsuarioCambiado usuarioCambiado = (UsuarioCambiado) events.get(0);
        Assertions.assertEquals(new Usuario("dsa"), usuarioCambiado.getUsuario());
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