package co.com.sofka.domain.usecase.cuenta;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofka.domain.cuenta.Cuenta;
import co.com.sofka.domain.cuenta.commands.CrearCuenta;

public class CrearCuentaUseCase extends UseCase<RequestCommand<CrearCuenta>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<CrearCuenta> crearCuentaRequestCommand) {
        var command = crearCuentaRequestCommand.getCommand();
        var cuenta = new Cuenta(command.getId(),
                                command.getPuntAcomulados(),
                                command.getNombres(),
                                command.getApellidos(),
                                command.getIdentificacion(),
                                command.getUsuario(),
                                command.getEmail());
        emit().onResponse(new ResponseEvents(cuenta.getUncommittedChanges()));
    }
}