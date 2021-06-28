package co.com.sofka.domain.cuenta.commands;

import co.com.sofka.domain.cuenta.values.*;

import co.com.sofka.domain.generic.Command;

public class CrearCuenta implements Command {
    private final CuentaId id;
    private final Nombres nombres;
    private final Apellidos apellidos;
    private final Identificacion identificacion;
    private final Usuario usuario;
    private final PuntosAcomulados puntAcomulados;
    private final Email email;

    public CrearCuenta(CuentaId id,PuntosAcomulados puntAcomulados, Nombres nombres, Apellidos apellidos, Identificacion identificacion, Usuario usuario, Email email){
        this.id = id;
        this.puntAcomulados = puntAcomulados;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.identificacion = identificacion;
        this.usuario = usuario;
        this.email = email;
    }

    public PuntosAcomulados getPuntAcomulados() {
        return puntAcomulados;
    }

    public Nombres getNombres() {
        return nombres;
    }

    public Apellidos getApellidos() {
        return apellidos;
    }

    public Identificacion getIdentificacion() {
        return identificacion;
    }
    public CuentaId getId() { return id; }

    public Usuario getUsuario() { return usuario; }

    public Email getEmail() { return email; }
}