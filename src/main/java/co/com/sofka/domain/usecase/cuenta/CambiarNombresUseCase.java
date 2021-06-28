package co.com.sofka.domain.usecase.cuenta;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofka.domain.cuenta.Cuenta;
import co.com.sofka.domain.cuenta.commands.CambiarNombres;
import co.com.sofka.domain.cuenta.commands.CrearCuenta;

public class CambiarNombresUseCase extends UseCase<RequestCommand<CambiarNombres>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<CambiarNombres> cambiarNombresRequestCommand) {
        var command = cambiarNombresRequestCommand.getCommand();
        var cuenta = Cuenta.from(command.getId(), retrieveEvents(command.getId().value()));
        cuenta.cambiarNombres(command.getNombres());
        emit().onResponse(new ResponseEvents(cuenta.getUncommittedChanges()));
    }
}