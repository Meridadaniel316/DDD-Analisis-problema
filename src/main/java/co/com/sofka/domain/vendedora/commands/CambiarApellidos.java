package co.com.sofka.domain.vendedora.commands;

import co.com.sofka.domain.vendedora.values.Apellidos;
import co.com.sofka.domain.generic.Command;
import co.com.sofka.domain.vendedora.values.VendedoraId;

public class CambiarApellidos implements Command {

    private final VendedoraId id;
    private final Apellidos apellidos;

    public CambiarApellidos(VendedoraId id, Apellidos apellidos){
        this.id = id;
        this.apellidos = apellidos;
    }

    public VendedoraId getId() { return id; }

    public Apellidos getApellidos() {
        return apellidos;
    }
}
