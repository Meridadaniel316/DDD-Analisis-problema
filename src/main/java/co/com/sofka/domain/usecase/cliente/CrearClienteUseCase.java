package co.com.sofka.domain.usecase.cliente;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofka.domain.cliente.Cliente;
import co.com.sofka.domain.cliente.commands.CrearCliente;

public class CrearClienteUseCase extends UseCase<RequestCommand<CrearCliente>, ResponseEvents> {
    @Override

    public void executeUseCase(RequestCommand<CrearCliente> crearClienteRequestCommand){
        var command = crearClienteRequestCommand.getCommand();
        var cliente = new Cliente(command.getId(),
                command.getAccountId(),
                command.getContrato(),
                command.getNombres(),
                command.getApellidos(),
                command.getIdentificacion());
        emit().onResponse(new ResponseEvents(cliente.getUncommittedChanges()));
    }
}
