package co.com.sofka.domain.cuenta.commands;

import co.com.sofka.domain.cuenta.values.CuentaId;
import co.com.sofka.domain.cuenta.values.Email;
import co.com.sofka.domain.generic.Command;

public class CambiarCorreo implements Command {
    private final CuentaId id;
    private final Email email;

    public CambiarCorreo(CuentaId id, Email email){
        this.id = id;
        this.email = email;
    }

    public CuentaId getId() {
        return id;
    }

    public Email getEmail() {
        return email;
    }
}
