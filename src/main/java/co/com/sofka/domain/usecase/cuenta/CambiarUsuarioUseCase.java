package co.com.sofka.domain.usecase.cuenta;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofka.domain.cuenta.Cuenta;
import co.com.sofka.domain.cuenta.commands.CambiarUsuario;

public class CambiarUsuarioUseCase extends UseCase<RequestCommand<CambiarUsuario>, ResponseEvents> {

    @Override
    public void executeUseCase(RequestCommand<CambiarUsuario> cambiarUsuarioRequestCommand){
        var command = cambiarUsuarioRequestCommand.getCommand();
        var cuenta = Cuenta.from(command.getId(), retrieveEvents(command.getId().value()));
        cuenta.cambiarUsuario((command.getUsuario()));
        emit().onResponse(new ResponseEvents(cuenta.getUncommittedChanges()));
    }
}
