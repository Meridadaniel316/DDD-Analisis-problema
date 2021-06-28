package co.com.sofka.domain.cliente.events;

import co.com.sofka.domain.cliente.Comprar;
import co.com.sofka.domain.cliente.values.Nombres;
import co.com.sofka.domain.cliente.values.Apellidos;
import co.com.sofka.domain.cliente.values.Identificacion;

import co.com.sofka.domain.cuenta.values.CuentaId;
import co.com.sofka.domain.generic.DomainEvent;

import java.util.Set;

public class ClienteCreado extends DomainEvent {

    private final CuentaId accountId;
    private final Set<Comprar> contratos;
    private final Nombres nombres;
    private final Apellidos apellidos;
    private final Identificacion identificacion;

    public ClienteCreado(CuentaId accountId, Set<Comprar> contratos, Nombres nombres, Apellidos apellidos, Identificacion identificacion){
        super("sofka.cliente.clientecreado");
        this.accountId = accountId;
        this.contratos = contratos;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.identificacion = identificacion;
    }

    public Nombres getNombres() {
        return nombres;
    }

    public Apellidos getApellidos() {
        return apellidos;
    }

    public Identificacion getIdentificacion() {
        return identificacion;
    }

    public Set<Comprar> getContratos() { return contratos; }

    public CuentaId getAccountId() { return accountId; }
}
