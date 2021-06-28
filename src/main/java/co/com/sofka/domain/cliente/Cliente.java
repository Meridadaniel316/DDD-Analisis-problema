package co.com.sofka.domain.cliente;

import co.com.sofka.domain.cliente.events.*;
import co.com.sofka.domain.cliente.values.*;

import co.com.sofka.domain.cuenta.values.CuentaId;
import co.com.sofka.domain.generic.AggregateEvent;
import co.com.sofka.domain.generic.DomainEvent;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.Set;

public class Cliente extends AggregateEvent<ClienteId> {
    protected Nombres nombres;
    protected Apellidos apellidos;
    protected Identificacion identificacion;
    protected Set<Comprar> compras;
    protected CuentaId cuentaId;

    public Cliente(ClienteId id, CuentaId accountId, Set<Comprar> compras, Nombres nombres, Apellidos apellidos, Identificacion identificacion){
        super(id);
        appendChange(new ClienteCreado(accountId, compras, nombres, apellidos, identificacion)).apply();
    }

    private Cliente(ClienteId id){
        super(id);
        subscribe(new ClienteChange(this));
    }

    public static Cliente from(ClienteId id, List<DomainEvent> events){
        var cliente = new Cliente(id);
        events.forEach(cliente::applyEvent);
        return cliente;
    }

    public void agregarContrato(ContratoId id, Descripcion descripcion){
        Objects.requireNonNull(id);
        Objects.requireNonNull(descripcion);
        appendChange(new ContratoAgregado(id, descripcion)).apply();
    }
    public void asociarCuenta(CuentaId cuentaId){
        appendChange(new CuentaAsociada(cuentaId)).apply();
    }
    public void cambiarNombres(Nombres nombres){
        appendChange(new NombresCambiados(nombres)).apply();
    }

    public void cambiarApellidos(Apellidos apellidos){
        appendChange(new ApellidosCambiados(apellidos)).apply();
    }


    public void cambiarIdentificacion(Identificacion identificacion){
        appendChange(new IdentificacionCambiada(identificacion)).apply();
    }

    protected Optional<Comprar> getContratoPorId(ContratoId id){
        return contratos().stream().filter(contrato -> contrato.identity().equals(id)).findFirst();
    }

    public Nombres nombres() {
        return nombres;
    }

    public Apellidos apellidos() {
        return apellidos;
    }

    public Identificacion identificacion() {
        return identificacion;
    }

    public CuentaId cuentaId() {
        return cuentaId;
    }

    public Set<Comprar> contratos() {
        return compras;
    }

}
