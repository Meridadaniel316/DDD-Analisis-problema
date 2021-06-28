package co.com.sofka.domain.cuenta.events;

import co.com.sofka.domain.cuenta.values.Nombres;
import co.com.sofka.domain.generic.DomainEvent;

public class NombresCambiados extends DomainEvent {
    private final Nombres nombres;

    public NombresCambiados(Nombres nombres){
        super("sofka.cuenta.nombrescambiados");
        this.nombres = nombres;
    }

    public Nombres getNombres() { return nombres; }
}
