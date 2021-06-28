package co.com.sofka.domain.facturacion.commands;

import co.com.sofka.domain.facturacion.values.FacturacionId;
import co.com.sofka.domain.facturacion.values.Precio;
import co.com.sofka.domain.generic.Command;

public class CrearFacturacion implements Command {

    private final FacturacionId id;
    private final Precio precio;

    public CrearFacturacion(FacturacionId id, Precio precio){

        this.id = id;
        this.precio = precio;
    }

    public FacturacionId getId() { return id; }
    public Precio getPrecio() { return precio; }
}
