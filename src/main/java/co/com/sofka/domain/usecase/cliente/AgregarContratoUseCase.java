package co.com.sofka.domain.usecase.cliente;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofka.domain.cliente.Cliente;
import co.com.sofka.domain.cliente.commands.AgregarContrato;

public class AgregarContratoUseCase extends UseCase<RequestCommand<AgregarContrato>, ResponseEvents> {

    @Override
    public void executeUseCase(RequestCommand<AgregarContrato> agregarContratoRequestCommand){
        var command = agregarContratoRequestCommand.getCommand();
        var cliente = Cliente.from(command.getId(), retrieveEvents(command.getId().value()));
        cliente.agregarContrato(command.getIdContract(),command.getDescripcion());
        emit().onResponse(new ResponseEvents(cliente.getUncommittedChanges()));
    }

}