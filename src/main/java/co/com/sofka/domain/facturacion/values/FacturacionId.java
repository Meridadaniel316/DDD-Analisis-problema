package co.com.sofka.domain.facturacion.values;

import co.com.sofka.domain.cuenta.values.CuentaId;
import co.com.sofka.domain.generic.Identity;

public class FacturacionId extends Identity {

    public FacturacionId(){ }

    public FacturacionId(String id) { super(id); }

    public static FacturacionId of(String id) { return new FacturacionId(id); }
}
