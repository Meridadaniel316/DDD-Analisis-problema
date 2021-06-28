package co.com.sofka.domain.vendedora.commands;

import co.com.sofka.domain.cuenta.values.CuentaId;
import co.com.sofka.domain.generic.Command;
import co.com.sofka.domain.vendedora.values.VendedoraId;

public class AsociarCuenta implements Command {

    private final VendedoraId id;
    private final CuentaId idAccount;

    public AsociarCuenta(VendedoraId id, CuentaId idAccount){
        this.id = id;
        this.idAccount = idAccount;
    }

    public VendedoraId getId() {
        return id;
    }

    public CuentaId getIdAccount() {
        return idAccount;
    }
}
