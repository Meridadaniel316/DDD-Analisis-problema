package co.com.sofka.domain.usecase.cliente;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofka.domain.cliente.Cliente;
import co.com.sofka.domain.cliente.commands.AsociarCuenta;

public class AsociarCuentaUseCase extends UseCase<RequestCommand<AsociarCuenta>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<AsociarCuenta> asociarCuentaRequestCommand){
        var command = asociarCuentaRequestCommand.getCommand();
        var cliente = Cliente.from(command.getId(), retrieveEvents(command.getId().value()));
        cliente.asociarCuenta(command.getIdAccount());
        emit().onResponse(new ResponseEvents(cliente.getUncommittedChanges()));
    }
}