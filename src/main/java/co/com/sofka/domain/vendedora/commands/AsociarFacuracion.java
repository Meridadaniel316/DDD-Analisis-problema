package co.com.sofka.domain.vendedora.commands;

import co.com.sofka.domain.facturacion.values.FacturacionId;
import co.com.sofka.domain.generic.Command;
import co.com.sofka.domain.vendedora.values.VendedoraId;

public class AsociarFacuracion implements Command {

    private VendedoraId id;
    private FacturacionId facturacionId;

    public AsociarFacuracion(VendedoraId id, FacturacionId facturacionId){
        this.id = id;
        this.facturacionId = facturacionId;
    }

    public VendedoraId getId() {
        return id;
    }

    public FacturacionId getFacturacionId() {
        return facturacionId;
    }
}
