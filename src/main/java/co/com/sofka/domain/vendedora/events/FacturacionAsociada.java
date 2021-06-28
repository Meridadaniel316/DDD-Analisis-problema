package co.com.sofka.domain.vendedora.events;

import co.com.sofka.domain.facturacion.values.FacturacionId;
import co.com.sofka.domain.generic.DomainEvent;

public class FacturacionAsociada extends DomainEvent {

    private final FacturacionId facturacionId;

    public FacturacionAsociada(FacturacionId facturacionId){
        super("sofka.vendedora.facturacionasoaciada");
        this.facturacionId = facturacionId;
    }

    public FacturacionId getFacturacionId() { return facturacionId; }
}
