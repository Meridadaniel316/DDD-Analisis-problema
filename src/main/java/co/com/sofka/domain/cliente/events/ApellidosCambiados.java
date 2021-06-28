package co.com.sofka.domain.cliente.events;

import co.com.sofka.domain.cliente.values.Apellidos;
import co.com.sofka.domain.generic.DomainEvent;

public class ApellidosCambiados extends DomainEvent {

    private Apellidos apellidos;

    public ApellidosCambiados(Apellidos apellidos){
        super("sofka.cliente.apellidoscambiados");
        this.apellidos = apellidos;
    }

    public Apellidos getApellidos() {
        return apellidos;
    }
}
