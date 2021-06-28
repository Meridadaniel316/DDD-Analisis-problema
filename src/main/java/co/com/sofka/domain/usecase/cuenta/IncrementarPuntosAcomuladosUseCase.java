package co.com.sofka.domain.usecase.cuenta;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofka.domain.cuenta.Cuenta;
import co.com.sofka.domain.cuenta.commands.IncrementarPuntosAcomulados;

public class IncrementarPuntosAcomuladosUseCase extends UseCase<RequestCommand<IncrementarPuntosAcomulados>, ResponseEvents> {

    @Override
    public void executeUseCase(RequestCommand<IncrementarPuntosAcomulados> incrementarPuntosAcomuladosRequestCommand){
        var command = incrementarPuntosAcomuladosRequestCommand.getCommand();
        var cuenta = Cuenta.from(command.getId(), retrieveEvents(command.getId().value()));
        cuenta.incrementarPuntosAcomulados(command.getPuntAcomulados());
        emit().onResponse(new ResponseEvents(cuenta.getUncommittedChanges()));
    }
}