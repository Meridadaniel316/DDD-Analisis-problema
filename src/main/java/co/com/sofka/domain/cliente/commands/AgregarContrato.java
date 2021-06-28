package co.com.sofka.domain.cliente.commands;

import co.com.sofka.domain.cliente.values.ClienteId;
import co.com.sofka.domain.cliente.values.ContratoId;
import co.com.sofka.domain.cliente.values.Descripcion;
import co.com.sofka.domain.generic.Command;

public class AgregarContrato implements Command {

    private final ClienteId id;
    private final ContratoId idContract;
    private final Descripcion descripcion;

    public AgregarContrato(ClienteId id, ContratoId idContract, Descripcion descripcion){
        this.id = id;
        this.idContract = idContract;
        this.descripcion = descripcion;
    }

    public ClienteId getId() { return id; }

    public ContratoId getIdContract() {
        return idContract;
    }

    public Descripcion getDescripcion() {
        return descripcion;
    }
}
