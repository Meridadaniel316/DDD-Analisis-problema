package co.com.sofka.domain.vendedora.events;

import co.com.sofka.domain.cliente.values.ClienteId;
import co.com.sofka.domain.generic.DomainEvent;

public class ClienteAdquirido extends DomainEvent{
    private final ClienteId clienteId;

    public ClienteAdquirido(ClienteId clienteId){
        super("sofka.cliente.clienteadquirido");
        this.clienteId = clienteId;
    }

    public ClienteId getClienteId() {
        return clienteId;
    }
}
