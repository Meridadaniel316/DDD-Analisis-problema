package co.com.sofka.domain.usecase.cuenta;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofka.domain.cuenta.Cuenta;
import co.com.sofka.domain.cuenta.commands.CambiarCorreo;

public class CambiarEmailUseCase extends UseCase<RequestCommand<CambiarCorreo>, ResponseEvents> {
    @Override

    public void executeUseCase(RequestCommand<CambiarCorreo> cambiarCorreoRequestCommand){
        var command = cambiarCorreoRequestCommand.getCommand();
        var cuenta = Cuenta.from(command.getId(), retrieveEvents(command.getId().value()));
        cuenta.cambiarCorreo((command.getEmail()));
        emit().onResponse(new ResponseEvents(cuenta.getUncommittedChanges()));
    }}
