package co.com.sofka.domain.cuenta.commands;

import co.com.sofka.domain.cuenta.values.CuentaId;
import co.com.sofka.domain.cuenta.values.PuntosAcomulados;
import co.com.sofka.domain.generic.Command;

public class IncrementarPuntosAcomulados implements Command {

    private final CuentaId id;
    private final PuntosAcomulados puntAcomulados;

    public IncrementarPuntosAcomulados(CuentaId id, PuntosAcomulados puntAcomulados){
        this.id = id;
        this.puntAcomulados = puntAcomulados;
    }

    public CuentaId getId() { return id; }
    public PuntosAcomulados getPuntAcomulados() { return puntAcomulados; }
}
