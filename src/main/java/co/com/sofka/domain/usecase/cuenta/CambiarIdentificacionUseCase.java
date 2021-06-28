package co.com.sofka.domain.usecase.cuenta;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofka.domain.cuenta.Cuenta;
import co.com.sofka.domain.cuenta.commands.CambiarIdentificacion;

public class CambiarIdentificacionUseCase extends UseCase<RequestCommand<CambiarIdentificacion>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<CambiarIdentificacion> cambiarIdentificacionRequestCommand){
        var command = cambiarIdentificacionRequestCommand.getCommand();
        var cuenta = Cuenta.from(command.getId(), retrieveEvents(command.getId().value()));
        cuenta.cambiarIdentificacion((command.getIdentificacion()));
        emit().onResponse(new ResponseEvents(cuenta.getUncommittedChanges()));
    }
}
