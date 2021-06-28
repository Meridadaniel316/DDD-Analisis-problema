package co.com.sofka.domain.usecase.cliente;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofka.domain.cliente.Cliente;
import co.com.sofka.domain.cliente.commands.CambiarNombres;

public class CambiarNombresUseCase extends UseCase<RequestCommand<CambiarNombres>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<CambiarNombres> cambiarNombresRequestCommand) {
        var command = cambiarNombresRequestCommand.getCommand();
        var cliente = Cliente.from(command.getId(), retrieveEvents(command.getId().value()));
        cliente.cambiarNombres(command.getNombres());
        emit().onResponse(new ResponseEvents(cliente.getUncommittedChanges()));
    }
}