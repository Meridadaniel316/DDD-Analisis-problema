package co.com.sofka.domain.facturacion;

import co.com.sofka.domain.cuenta.events.CuentaCreada;
import co.com.sofka.domain.facturacion.events.FacturacionCreada;
import co.com.sofka.domain.generic.EventChange;

public class FacturacionChange extends EventChange {
    public FacturacionChange(Facturacion facturacion) {
        apply((FacturacionCreada event) -> {
            facturacion.precio = event.getPrecio();
        });

    }
}
