package co.com.sofka.domain.cliente.events;

import co.com.sofka.domain.cliente.values.ContratoId;
import co.com.sofka.domain.cliente.values.Descripcion;
import co.com.sofka.domain.generic.DomainEvent;

public class DescripcionDeContratoActualizada extends DomainEvent {

    private final ContratoId id;
    private final Descripcion descripcion;

    public DescripcionDeContratoActualizada(ContratoId id, Descripcion descripcion){
        super("sofka.cliente.descripciondecontratoactualizada");
        this.id = id;
        this.descripcion = descripcion;
    }

    public ContratoId getId() {
        return id;
    }

    public Descripcion getDescripcion() {
        return descripcion;
    }
}
