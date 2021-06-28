package co.com.sofka.domain.vendedora.events;

import co.com.sofka.domain.cliente.values.ClienteId;
import co.com.sofka.domain.cuenta.values.CuentaId;
import co.com.sofka.domain.facturacion.values.FacturacionId;
import co.com.sofka.domain.vendedora.values.*;

import co.com.sofka.domain.generic.DomainEvent;

public class VendedoraCreada extends DomainEvent {

    private final CuentaId accountId;
    private final ClienteId clienteId;
    private final FacturacionId facturacionId;
    private final Nombres nombres;
    private final Apellidos apellidos;

    public VendedoraCreada(CuentaId accountId, ClienteId clienteId, FacturacionId facturacionId, Nombres nombres, Apellidos apellidos){
        super("sofka.trabajador.VendedoraCreada");
        this.accountId = accountId;
        this.clienteId = clienteId;
        this.facturacionId = facturacionId;
        this.nombres = nombres;
        this.apellidos = apellidos;
    }

    public CuentaId getAccountId() { return accountId; }

    public ClienteId getClienteId() { return clienteId; }

    public FacturacionId getFacturacionId() { return facturacionId; }

    public Nombres getNombres() {
        return nombres;
    }

    public Apellidos getApellidos() {
        return apellidos;
    }

}
