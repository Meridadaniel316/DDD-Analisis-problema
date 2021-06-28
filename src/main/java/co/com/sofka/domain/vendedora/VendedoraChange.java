package co.com.sofka.domain.vendedora;

import co.com.sofka.domain.cliente.events.CuentaAsociada;
import co.com.sofka.domain.generic.EventChange;
import co.com.sofka.domain.vendedora.events.ClienteAdquirido;
import co.com.sofka.domain.vendedora.events.FacturacionAsociada;
import co.com.sofka.domain.vendedora.events.VendedoraCreada;

public class VendedoraChange extends EventChange {
    public VendedoraChange(Vendedora vendedor) {
        apply((VendedoraCreada event) -> {
            vendedor.apellidos = event.getApellidos();
            vendedor.nombres = event.getNombres();
            vendedor.accountId = event.getAccountId();
            vendedor.clienteId = event.getClienteId();
            vendedor.facturacionId = event.getFacturacionId();
        });

        apply((CuentaAsociada event) -> {
            vendedor.accountId = event.getCuentaId();
        });

        apply((ClienteAdquirido event) -> {
            vendedor.clienteId = event.getClienteId();
        });

        apply((FacturacionAsociada event) -> {
            vendedor.facturacionId = event.getFacturacionId();
        });
    }

}
