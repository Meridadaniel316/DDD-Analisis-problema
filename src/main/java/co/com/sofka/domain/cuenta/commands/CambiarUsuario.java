package co.com.sofka.domain.cuenta.commands;

import co.com.sofka.domain.cuenta.values.CuentaId;
import co.com.sofka.domain.cuenta.values.Usuario;
import co.com.sofka.domain.generic.Command;

public class CambiarUsuario implements Command {
    private final CuentaId id;
    private final Usuario usuario;

    public CambiarUsuario(CuentaId id, Usuario usuario){
        this.id = id;
        this.usuario = usuario;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public CuentaId getId() {
        return id;
    }
}
