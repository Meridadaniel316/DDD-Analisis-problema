package co.com.sofka.domain.usecase.cliente;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofka.domain.cliente.Cliente;
import co.com.sofka.domain.cliente.commands.CambiarApellidos;

public class CambiarApellidosUseCase extends UseCase<RequestCommand<CambiarApellidos>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<CambiarApellidos> cambiarApellidosRequestCommand) {
        var command = cambiarApellidosRequestCommand.getCommand();
        var cliente = Cliente.from(command.getId(), retrieveEvents(command.getId().value()));
        cliente.cambiarApellidos(command.getApellidos());
        emit().onResponse(new ResponseEvents(cliente.getUncommittedChanges()));
    }
}