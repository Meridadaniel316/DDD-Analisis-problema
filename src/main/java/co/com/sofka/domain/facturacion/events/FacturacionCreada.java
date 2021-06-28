package co.com.sofka.domain.facturacion.events;

import co.com.sofka.domain.facturacion.values.Precio;
import co.com.sofka.domain.generic.DomainEvent;

public class FacturacionCreada extends DomainEvent {

    private Precio precio;

    public FacturacionCreada(Precio precio){
        super("sofka.facturacion.facturacioncreada");

        this.precio = precio;
    }

    public Precio getPrecio() {
        return precio;
    }
}
