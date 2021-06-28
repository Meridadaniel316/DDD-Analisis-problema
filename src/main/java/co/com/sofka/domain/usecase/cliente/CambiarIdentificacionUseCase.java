package co.com.sofka.domain.usecase.cliente;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofka.domain.cliente.Cliente;
import co.com.sofka.domain.cliente.commands.CambiarIdentificacion;

public class CambiarIdentificacionUseCase extends UseCase<RequestCommand<CambiarIdentificacion>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<CambiarIdentificacion> cambiarIdentificacionRequestCommand){
        var command = cambiarIdentificacionRequestCommand.getCommand();
        var cliente = Cliente.from(command.getId(), retrieveEvents(command.getId().value()));
        cliente.cambiarIdentificacion((command.getIdentificacion()));
        emit().onResponse(new ResponseEvents(cliente.getUncommittedChanges()));
    }
}
