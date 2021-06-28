package co.com.sofka.domain.cliente.commands;

import co.com.sofka.domain.cliente.Comprar;
import co.com.sofka.domain.cliente.values.Apellidos;
import co.com.sofka.domain.cliente.values.ClienteId;
import co.com.sofka.domain.cliente.values.Identificacion;
import co.com.sofka.domain.cliente.values.Nombres;
import co.com.sofka.domain.cuenta.values.CuentaId;
import co.com.sofka.domain.generic.Command;

import java.util.Set;

public class CrearCliente implements Command {

    private final ClienteId id;
    private final CuentaId accountId;
    private final Set<Comprar> contrato;
    private final Nombres nombres;
    private final Apellidos apellidos;
    private final Identificacion identificacion;

    public CrearCliente(ClienteId id, CuentaId accountId, Set<Comprar> contrato, Nombres nombres, Apellidos apellidos, Identificacion identificacion){
        this.id = id;
        this.accountId = accountId;
        this.contrato = contrato;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.identificacion = identificacion;
    }

    public ClienteId getId() {
        return id;
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

    public Set<Comprar> getContrato() { return contrato; }

    public CuentaId getAccountId() { return accountId; }
}
