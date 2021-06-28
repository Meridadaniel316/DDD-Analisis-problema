package co.com.sofka.domain.usecase.vendedora;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofka.domain.vendedora.Vendedora;
import co.com.sofka.domain.vendedora.commands.AdquirirCliente;

public class AdquirirClienteUseCase extends UseCase<RequestCommand<AdquirirCliente>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<AdquirirCliente> adquirirClienteRequestCommand){
        var command = adquirirClienteRequestCommand.getCommand();
        var vendedora = Vendedora.from(command.getId(), retrieveEvents(command.getId().value()));
        vendedora.adquirirCliente(command.getIdCliente());
        emit().onResponse(new ResponseEvents(vendedora.getUncommittedChanges()));
    }
}