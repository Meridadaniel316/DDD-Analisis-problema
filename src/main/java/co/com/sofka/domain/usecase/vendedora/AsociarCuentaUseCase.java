package co.com.sofka.domain.usecase.vendedora;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofka.domain.vendedora.Vendedora;
import co.com.sofka.domain.vendedora.commands.AsociarCuenta;

public class AsociarCuentaUseCase extends UseCase<RequestCommand<AsociarCuenta>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<AsociarCuenta> asociarCuentaRequestCommand){
        var command = asociarCuentaRequestCommand.getCommand();
        var vendedora = Vendedora.from(command.getId(), retrieveEvents(command.getId().value()));
        vendedora.asociarCuenta(command.getIdAccount());
        emit().onResponse(new ResponseEvents(vendedora.getUncommittedChanges()));
    }
}