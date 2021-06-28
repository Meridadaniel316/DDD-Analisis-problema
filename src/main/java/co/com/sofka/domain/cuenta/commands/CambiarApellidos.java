package co.com.sofka.domain.cuenta.commands;

import co.com.sofka.domain.cuenta.Cuenta;
import co.com.sofka.domain.cuenta.values.Apellidos;
import co.com.sofka.domain.cuenta.values.CuentaId;
import co.com.sofka.domain.generic.Command;

public class CambiarApellidos implements Command {
    private final CuentaId id;
    private final Apellidos apellidos;

    public CambiarApellidos(CuentaId id, Apellidos apellidos){
        this.id = id;
        this.apellidos = apellidos;
    }

    public CuentaId getId() {
        return id;
    }

    public Apellidos getApellidos() {
        return apellidos;
    }
}
