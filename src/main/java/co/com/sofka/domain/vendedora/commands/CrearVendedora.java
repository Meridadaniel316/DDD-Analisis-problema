package co.com.sofka.domain.vendedora.commands;

import co.com.sofka.domain.facturacion.values.FacturacionId;
import co.com.sofka.domain.cliente.values.ClienteId;
import co.com.sofka.domain.cuenta.values.CuentaId;
import co.com.sofka.domain.vendedora.values.*;
import co.com.sofka.domain.generic.Command;

public class CrearVendedora implements Command {

    private final VendedoraId id;
    private final CuentaId cuentaId;
    private final ClienteId clienteid;
    private final FacturacionId facturacionId;
    private final Nombres nombres;
    private final Apellidos apellidos;

    public CrearVendedora(VendedoraId id, CuentaId cuentaId, ClienteId clienteid, FacturacionId facturacionId, Nombres nombres, Apellidos apellidos){

        this.id = id;
        this.cuentaId = cuentaId;
        this.clienteid = clienteid;
        this.facturacionId = facturacionId;
        this.nombres = nombres;
        this.apellidos = apellidos;
    }

    public VendedoraId getId() { return id; }

    public Nombres getNombres() { return nombres; }

    public CuentaId getCuentaId() { return cuentaId; }

    public Apellidos getApellidos() { return apellidos; }

    public ClienteId getClienteid() { return clienteid; }

    public FacturacionId getFacturacionId() { return facturacionId; }
}
