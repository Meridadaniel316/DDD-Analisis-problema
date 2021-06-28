package co.com.sofka.domain.usecase.vendedora;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofka.domain.vendedora.Vendedora;
import co.com.sofka.domain.vendedora.commands.AsociarFacuracion;

public class AsociarFacturacionUseCase extends UseCase<RequestCommand<AsociarFacuracion>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<AsociarFacuracion> asociarFacturacionRequestCommand){
        var command = asociarFacturacionRequestCommand.getCommand();
        var vendedora = Vendedora.from(command.getId(), retrieveEvents(command.getId().value()));
        vendedora.asociarFacturacion(command.getFacturacionId());
        emit().onResponse(new ResponseEvents(vendedora.getUncommittedChanges()));
    }
}