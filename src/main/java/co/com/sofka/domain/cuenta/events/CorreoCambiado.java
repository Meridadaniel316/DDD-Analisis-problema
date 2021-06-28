package co.com.sofka.domain.cuenta.events;

import co.com.sofka.domain.cuenta.values.Email;
import co.com.sofka.domain.generic.DomainEvent;

public class CorreoCambiado extends DomainEvent {
    private final Email email;

    public CorreoCambiado(Email email){
        super("sofka.cuenta.correocambiado");
        this.email = email;
    }

    public Email getEmail() { return email; }
}
