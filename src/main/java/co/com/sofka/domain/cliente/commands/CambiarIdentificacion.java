package co.com.sofka.domain.cliente.commands;

import co.com.sofka.domain.cliente.values.ClienteId;
import co.com.sofka.domain.cliente.values.Identificacion;
import co.com.sofka.domain.generic.Command;

public class CambiarIdentificacion implements Command {

    private final ClienteId id;
    private final Identificacion identificacion;

    public CambiarIdentificacion(ClienteId id, Identificacion identificacion){
        this.id = id;
        this.identificacion = identificacion;
    }

    public ClienteId getId() { return id; }
    public Identificacion getIdentificacion() {
        return identificacion;
    }
}
