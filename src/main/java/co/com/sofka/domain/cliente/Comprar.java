package co.com.sofka.domain.cliente;
import co.com.sofka.domain.cliente.values.ContratoId;
import co.com.sofka.domain.cliente.values.Descripcion;
import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.domain.generic.Entity;

import java.util.List;
import java.util.Objects;

public class Comprar extends Entity<ContratoId> {

    private Descripcion descripcion;

    public Comprar(ContratoId id, Descripcion descripcion){
        super(id);
        this.descripcion = descripcion;
    }

    public void actualizarDescripcion(Descripcion descripcion){
        this.descripcion = Objects.requireNonNull(descripcion);
    }

    public Descripcion descripcion() {
        return descripcion;
    }

}
