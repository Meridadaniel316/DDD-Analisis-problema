package co.com.sofka.domain.cliente.events;

import co.com.sofka.domain.cliente.values.Identificacion;
import co.com.sofka.domain.generic.DomainEvent;

public class IdentificacionCambiada extends DomainEvent {

    private final Identificacion identificacion;

    public IdentificacionCambiada(Identificacion identificacion){
        super("sofka.cliente.identificacioncambiada");
        this.identificacion = identificacion;
    }

    public Identificacion getIdentificacion() {
        return identificacion;
    }
}
