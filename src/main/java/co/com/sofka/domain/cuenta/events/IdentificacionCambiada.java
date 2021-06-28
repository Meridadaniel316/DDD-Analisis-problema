package co.com.sofka.domain.cuenta.events;

import co.com.sofka.domain.cuenta.values.Identificacion;
import co.com.sofka.domain.generic.DomainEvent;

public class IdentificacionCambiada extends DomainEvent {
    private final Identificacion identificacion;

    public IdentificacionCambiada(Identificacion identificacion){
        super("sofka.cuenta.identificacioncambiada");
        this.identificacion = identificacion;
    }

    public Identificacion getIdentificacion() { return identificacion; }
}
