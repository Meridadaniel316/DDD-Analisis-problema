package co.com.sofka.domain.cliente.commands;

import co.com.sofka.domain.cliente.values.Apellidos;
import co.com.sofka.domain.cliente.values.ClienteId;
import co.com.sofka.domain.generic.Command;

public class CambiarApellidos implements Command {

    private final ClienteId id;
    private final Apellidos apellidos;

    public CambiarApellidos(ClienteId id, Apellidos apellidos){
        this.id = id;
        this.apellidos = apellidos;
    }

    public ClienteId getId() { return id; }

    public Apellidos getApellidos() {
        return apellidos;
    }
}
