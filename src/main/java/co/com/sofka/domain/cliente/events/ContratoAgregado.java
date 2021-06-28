package co.com.sofka.domain.cliente.events;

import co.com.sofka.domain.cliente.values.ContratoId;
import co.com.sofka.domain.cliente.values.Descripcion;
import co.com.sofka.domain.generic.DomainEvent;

public class ContratoAgregado extends DomainEvent {
    private final ContratoId id;
    private final Descripcion descripcion;

    public ContratoAgregado(ContratoId id, Descripcion descripcion) {
        super("sofka.cliente.contratoagregado");
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
