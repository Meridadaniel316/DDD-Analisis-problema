package co.com.sofka.domain.cliente;

import co.com.sofka.domain.cliente.events.*;

import co.com.sofka.domain.cliente.events.CuentaAsociada;
import co.com.sofka.domain.generic.EventChange;

import java.util.HashSet;

public class ClienteChange extends EventChange {

    public ClienteChange(Cliente cliente){

        apply((ClienteCreado event) -> {
            cliente.nombres = event.getNombres();
            cliente.apellidos = event.getApellidos();
            cliente.identificacion = event.getIdentificacion();
            cliente.compras = new HashSet<>();
        });

        apply((CuentaAsociada event) -> {
            cliente.cuentaId = event.getCuentaId();
        });

        apply((DescripcionDeContratoActualizada event) -> {
            var contrato = cliente.getContratoPorId(event.getId())
                    .orElseThrow(() -> new IllegalArgumentException("No se encuentra el contrato de la persona."));
            contrato.actualizarDescripcion(event.getDescripcion());
        });

        apply((ContratoAgregado event) -> {
            var numContratos = cliente.compras.size();
            if(numContratos == 3){
                throw new IllegalArgumentException("No se puede tener mas de 3 contratos.");
            }
            cliente.compras.add(new Comprar(
                    event.getId(),
                    event.getDescripcion()
            ));
        });

        apply((NombresCambiados event) -> {
            cliente.nombres = event.getNombres();
        });

        apply((ApellidosCambiados event) -> {
            cliente.apellidos = event.getApellidos();
        });

        apply((IdentificacionCambiada event) -> {
            cliente.identificacion = event.getIdentificacion();
        });
    }
}
