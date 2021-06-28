package co.com.sofka.domain.cliente.events;

import co.com.sofka.domain.cuenta.values.CuentaId;
import co.com.sofka.domain.generic.DomainEvent;

public class CuentaAsociada extends DomainEvent {

    private final CuentaId cuentaId;

    public CuentaAsociada(CuentaId cuentaId){
        super("sofka.cliente.cuentasociada");
        this.cuentaId = cuentaId;
    }

    public CuentaId getCuentaId() {
        return cuentaId;
    }
}
