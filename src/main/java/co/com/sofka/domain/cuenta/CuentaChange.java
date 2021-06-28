package co.com.sofka.domain.cuenta;

import co.com.sofka.domain.cuenta.events.*;
import co.com.sofka.domain.generic.EventChange;

public class CuentaChange extends EventChange {
    public CuentaChange(Cuenta cuenta) {
        apply((CuentaCreada event) -> {
            cuenta.usuario = event.getUsuario();
            cuenta.email = event.getEmail();
            cuenta.nombres = event.getNombres();
            cuenta.apellidos = event.getApellidos();
            cuenta.identificacion = event.getIdentificacion();
        });

        apply((CorreoCambiado event) -> {
            cuenta.email = event.getEmail();
        });

        apply((UsuarioCambiado event) -> {
            cuenta.usuario = event.getUsuario();
        });

        apply((NombresCambiados event) -> {
            cuenta.nombres = event.getNombres();
        });

        apply((ApellidosCambiados event) -> {
            cuenta.apellidos = event.getApellidos();
        });

        apply((IdentificacionCambiada event) -> {
            cuenta.identificacion = event.getIdentificacion();
        });
    }
}
