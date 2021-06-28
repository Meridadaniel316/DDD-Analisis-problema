package co.com.sofka.domain.cliente.events;

import co.com.sofka.domain.cliente.values.Nombres;
import co.com.sofka.domain.generic.DomainEvent;

public class NombresCambiados extends DomainEvent {

    private final Nombres nombres;

    public NombresCambiados(Nombres nombres){
        super("sofka.cliente.nombrescambiados");

        this.nombres = nombres;
    }

    public Nombres getNombres() {
        return nombres;
    }
}
