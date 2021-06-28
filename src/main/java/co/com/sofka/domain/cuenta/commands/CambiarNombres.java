package co.com.sofka.domain.cuenta.commands;

import co.com.sofka.domain.cuenta.values.Apellidos;
import co.com.sofka.domain.cuenta.values.CuentaId;
import co.com.sofka.domain.cuenta.values.Nombres;
import co.com.sofka.domain.generic.Command;

public class CambiarNombres implements Command{
    private final CuentaId id;
    private final Nombres nombres;

    public CambiarNombres(CuentaId id, Nombres nombres){
        this.id = id;
        this.nombres = nombres;
    }

    public CuentaId getId() {
        return id;
    }

    public Nombres getNombres() {
        return nombres;
    }
}
