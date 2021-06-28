package co.com.sofka.domain.cuenta.values;

import co.com.sofka.domain.generic.Identity;

public class CuentaId extends Identity{
    public CuentaId(){

    }

    public CuentaId(String id) { super(id); }

    public static CuentaId of(String id) { return new CuentaId(id); }
}