package co.com.sofka.domain.cliente.commands;

import co.com.sofka.domain.cliente.values.ClienteId;
import co.com.sofka.domain.cuenta.values.CuentaId;
import co.com.sofka.domain.generic.Command;

public class AsociarCuenta implements Command {

    private final ClienteId id;
    private final CuentaId idAccount;

    public AsociarCuenta(ClienteId id, CuentaId idAccount){
        this.id = id;
        this.idAccount = idAccount;
    }

    public ClienteId getId() {
        return id;
    }

    public CuentaId getIdAccount() {
        return idAccount;
    }
}
