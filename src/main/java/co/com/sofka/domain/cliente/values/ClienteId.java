package co.com.sofka.domain.cliente.values;

import co.com.sofka.domain.generic.Identity;

public class ClienteId extends Identity {
    public ClienteId(){}

    private ClienteId(String id) { super(id); }

    public static ClienteId of(String id) { return new ClienteId(id); }
}
