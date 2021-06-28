package co.com.sofka.domain.cuenta.events;

import co.com.sofka.domain.cuenta.values.Apellidos;
import co.com.sofka.domain.cuenta.values.Nombres;
import co.com.sofka.domain.generic.DomainEvent;

public class ApellidosCambiados extends DomainEvent {
    private final Apellidos apellidos;

    public ApellidosCambiados(Apellidos apellidos){
        super("sofka.cuenta.apellidoscambiados");
        this.apellidos = apellidos;
    }

    public Apellidos getApellidos() { return apellidos; }
}
