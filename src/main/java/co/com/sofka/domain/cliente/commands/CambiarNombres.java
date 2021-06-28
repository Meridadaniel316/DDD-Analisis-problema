package co.com.sofka.domain.cliente.commands;

import co.com.sofka.domain.cliente.values.ClienteId;
import co.com.sofka.domain.cliente.values.Nombres;
import co.com.sofka.domain.generic.Command;

public class CambiarNombres implements Command {

    private final ClienteId id;
    private final Nombres nombres;

    public CambiarNombres(ClienteId id, Nombres nombres){
        this.id = id;
        this.nombres = nombres;
    }

    public ClienteId getId() { return id; }

    public Nombres getNombres() {
        return nombres;
    }
}
