package co.com.sofka.domain.vendedora.commands;

import co.com.sofka.domain.cliente.values.ClienteId;
import co.com.sofka.domain.generic.Command;
import co.com.sofka.domain.vendedora.values.VendedoraId;

public class AdquirirCliente implements Command {

    private final VendedoraId id;
    private final ClienteId idCliente;

    public AdquirirCliente(VendedoraId id, ClienteId clienteId){
        this.id = id;
        this.idCliente = clienteId;
    }

    public VendedoraId getId() {
        return id;
    }

    public ClienteId getIdCliente() {
        return idCliente;
    }
}
