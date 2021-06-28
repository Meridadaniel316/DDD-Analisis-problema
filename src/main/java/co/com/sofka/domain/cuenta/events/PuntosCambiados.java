package co.com.sofka.domain.cuenta.events;

import co.com.sofka.domain.cuenta.values.PuntosAcomulados;
import co.com.sofka.domain.generic.DomainEvent;

public class PuntosCambiados extends DomainEvent {

    private final PuntosAcomulados puntAcomulados;

    public PuntosCambiados(PuntosAcomulados puntAcomulados) {
        super("sofka.cuenta.nombrescambiados");
        this.puntAcomulados = puntAcomulados;
    }

    public PuntosAcomulados getPuntAcomulados() {
        return puntAcomulados;
    }
}
