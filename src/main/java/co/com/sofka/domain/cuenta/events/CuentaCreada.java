package co.com.sofka.domain.cuenta.events;

import co.com.sofka.domain.cuenta.values.*;
import co.com.sofka.domain.generic.DomainEvent;

public class CuentaCreada extends DomainEvent {
    private final Nombres nombres;
    private final Apellidos apellidos;
    private final Identificacion identificacion;
    private final Usuario usuario;
    private final PuntosAcomulados puntAcomulados;
    private final Email email;

    public CuentaCreada(PuntosAcomulados puntAcomulados, Nombres nombres, Apellidos apellidos, Identificacion identificacion, Usuario usuario, Email email){
        super("domain.cuenta.cuentacreada");
        this.puntAcomulados = puntAcomulados;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.identificacion = identificacion;
        this.usuario = usuario;
        this.email = email;
    }

    public Email getEmail() { return email; }
    public Usuario getUsuario() {
        return usuario;
    }
    public Nombres getNombres() {  return nombres;  }
    public Apellidos getApellidos() { return apellidos; }
    public Identificacion getIdentificacion() { return identificacion; }
    public PuntosAcomulados getPuntAcomulados() { return puntAcomulados; }
}