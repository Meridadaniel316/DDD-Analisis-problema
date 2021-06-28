package co.com.sofka.domain.cuenta.events;

import co.com.sofka.domain.cuenta.values.Usuario;
import co.com.sofka.domain.generic.DomainEvent;

public class UsuarioCambiado extends DomainEvent {
    private final Usuario usuario;

    public UsuarioCambiado(Usuario usuario){
        super("sofka.cuenta.usuariocambiado");
        this.usuario = usuario;
    }

    public Usuario getUsuario() { return usuario; }
}
