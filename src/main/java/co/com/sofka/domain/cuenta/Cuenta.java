package co.com.sofka.domain.cuenta;

import co.com.sofka.domain.cuenta.events.*;
import co.com.sofka.domain.generic.AggregateEvent;
import co.com.sofka.domain.cuenta.values.*;
import co.com.sofka.domain.generic.DomainEvent;

import java.util.List;

public class Cuenta extends AggregateEvent<CuentaId> {
    protected Nombres nombres;
    protected Apellidos apellidos;
    protected Identificacion identificacion;
    protected Usuario usuario;
    protected PuntosAcomulados puntAcomulados;
    protected Email email;

    public Cuenta(CuentaId id,PuntosAcomulados puntAcomulados, Nombres nombres,Apellidos apellidos,Identificacion identificacion, Usuario usuario, Email email) {
        super(id);
        appendChange(new CuentaCreada(puntAcomulados, nombres, apellidos, identificacion, usuario, email)).apply();
    }

    private Cuenta(CuentaId id) {
        super(id);
        subscribe(new CuentaChange(this));
    }

    public static Cuenta from(CuentaId id, List<DomainEvent> retrieveEvents) {
        var cuenta = new Cuenta(id);
        retrieveEvents.forEach(cuenta::applyEvent);
        return cuenta;
    }

    public void incrementarPuntosAcomulados(PuntosAcomulados puntAcomulados) { appendChange(new PuntosCambiados(puntAcomulados)).apply();}

    public void cambiarNombres(Nombres nombres){
        appendChange(new NombresCambiados(nombres)).apply();
    }

    public void cambiarApellidos(Apellidos apellidos){
        appendChange(new ApellidosCambiados(apellidos)).apply();
    }

    public void cambiarIdentificacion(Identificacion identificacion){ appendChange(new IdentificacionCambiada(identificacion)).apply(); }

    public void cambiarUsuario(Usuario usuario){
        appendChange(new UsuarioCambiado(usuario)).apply();
    }

    public void cambiarCorreo(Email email){
        appendChange(new CorreoCambiado(email)).apply();
    }

}
