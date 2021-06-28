package co.com.sofka.domain.cliente.values;

import co.com.sofka.domain.generic.Identity;

public class ContratoId extends Identity {
    public ContratoId(){}

    public ContratoId(String id) { super(id); }

    public static ContratoId of(String id) { return new ContratoId(id); }
}
