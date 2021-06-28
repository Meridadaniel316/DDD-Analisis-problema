package co.com.sofka.domain.vendedora;

import co.com.sofka.domain.cliente.values.ClienteId;
import co.com.sofka.domain.cuenta.values.CuentaId;
import co.com.sofka.domain.facturacion.events.FacturacionCreada;
import co.com.sofka.domain.facturacion.values.FacturacionId;
import co.com.sofka.domain.vendedora.events.*;
import co.com.sofka.domain.generic.AggregateEvent;
import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.domain.vendedora.values.*;

import java.util.List;

public class Vendedora extends AggregateEvent<VendedoraId> {
    protected CuentaId accountId;
    protected ClienteId clienteId;
    protected FacturacionId facturacionId;
    protected Nombres nombres;
    protected Apellidos apellidos;

    private Vendedora(VendedoraId entityId) {
        super(entityId); subscribe( new VendedoraChange(this));
    }

    public Vendedora(VendedoraId entityId, CuentaId accountId, FacturacionId facturacionId, ClienteId clienteId, Nombres nombres, Apellidos apellidos){
        super(entityId);
        this.accountId = accountId;
        this.nombres = nombres;
        this.apellidos = apellidos;
        appendChange(new VendedoraCreada(accountId,clienteId,facturacionId, nombres, apellidos)).apply();
    }

    public static Vendedora from(VendedoraId id, List<DomainEvent> retrieveEvents) {
        var trabajador = new Vendedora(id);
        retrieveEvents.forEach(trabajador::applyEvent);
        return trabajador;
    }


    public void asociarFacturacion(FacturacionId facturacionId){ appendChange(new FacturacionAsociada(facturacionId)).apply(); }

    public void asociarCuenta(CuentaId cuentaId){
        appendChange(new CuentaAsociada(cuentaId)).apply();
    }

    public void adquirirCliente(ClienteId clienteId){
        appendChange(new ClienteAdquirido(clienteId)).apply();
    }

    public void cambiarNombres(Nombres nombres){
        appendChange(new NombresCambiados(nombres)).apply();
    }

    public void cambiarApellidos(Apellidos apellidos){
        appendChange(new ApellidosCambiados(apellidos)).apply();
    }

}
