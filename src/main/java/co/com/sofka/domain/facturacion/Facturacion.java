package co.com.sofka.domain.facturacion;
import co.com.sofka.domain.facturacion.events.FacturacionCreada;
import co.com.sofka.domain.facturacion.values.FacturacionId;
import co.com.sofka.domain.facturacion.values.Precio;
import co.com.sofka.domain.generic.AggregateEvent;
import co.com.sofka.domain.generic.DomainEvent;

import java.util.List;

public class Facturacion extends AggregateEvent<FacturacionId> {

    public Precio precio;

    public Facturacion(FacturacionId facturacionId, Precio precio){
        super(facturacionId);
        appendChange(new FacturacionCreada(precio)).apply();

    }

    private Facturacion(FacturacionId id){
        super(id);
        subscribe(new FacturacionChange(this));
    }

    public static Facturacion from(FacturacionId id, List<DomainEvent> retrieveEvents) {
        var facturacion = new Facturacion(id);
        retrieveEvents.forEach(facturacion::applyEvent);
        return facturacion;
    }

}
