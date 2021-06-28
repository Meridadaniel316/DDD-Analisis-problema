package co.com.sofka.domain.cuenta.commands;

import co.com.sofka.domain.cuenta.Cuenta;
import co.com.sofka.domain.cuenta.values.CuentaId;
import co.com.sofka.domain.cuenta.values.Identificacion;
import co.com.sofka.domain.generic.Command;

public class CambiarIdentificacion implements Command {
    private final CuentaId id;
    private final Identificacion identificacion;

    public CambiarIdentificacion(CuentaId id, Identificacion identificacion){
        this.id = id;
        this.identificacion = identificacion;
    }

    public CuentaId getId() {
        return id;
    }

    public Identificacion getIdentificacion() {
        return identificacion;
    }
}
