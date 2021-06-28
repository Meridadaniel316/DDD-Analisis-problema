package co.com.sofka.domain.usecase.cuenta;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofka.domain.cuenta.Cuenta;
import co.com.sofka.domain.cuenta.commands.CambiarApellidos;

public class CambiarApellidosUseCase extends UseCase<RequestCommand<CambiarApellidos>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<CambiarApellidos> cambiarApellidosRequestCommand) {
        var command = cambiarApellidosRequestCommand.getCommand();
        var cuenta = Cuenta.from(command.getId(), retrieveEvents(command.getId().value()));
        cuenta.cambiarApellidos(command.getApellidos());
        emit().onResponse(new ResponseEvents(cuenta.getUncommittedChanges()));
    }
}