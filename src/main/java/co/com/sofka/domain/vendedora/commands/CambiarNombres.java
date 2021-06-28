package co.com.sofka.domain.vendedora.commands;

import co.com.sofka.domain.vendedora.values.Nombres;
import co.com.sofka.domain.generic.Command;
import co.com.sofka.domain.vendedora.values.VendedoraId;

public class CambiarNombres implements Command {

    private final VendedoraId id;
    private final Nombres nombres;

    public CambiarNombres(VendedoraId id, Nombres nombres){
        this.id = id;
        this.nombres = nombres;
    }

    public VendedoraId getId() { return id; }

    public Nombres getNombres() {
        return nombres;
    }
}
