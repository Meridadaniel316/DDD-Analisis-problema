package co.com.sofka.domain.vendedora.values;

import co.com.sofka.domain.generic.Identity;

public class VendedoraId extends Identity {
    public VendedoraId(){

    }

    private VendedoraId(String id) { super(id); }

    public static VendedoraId of(String id) { return new VendedoraId(id); }
}
