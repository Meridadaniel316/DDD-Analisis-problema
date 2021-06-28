package co.com.sofka.domain.facturacion.values;

import co.com.sofka.domain.cuenta.values.PuntosAcomulados;
import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class Precio implements ValueObject<String> {
    private final String value;

    public Precio(String value){
        this.value = Objects.requireNonNull(value);
        if(value.length() > 99999999){
            throw new IllegalArgumentException("El maximo de puntos no puede superar los 99.999.999");
        }
    }

    @Override
    public String value() { return value; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Precio that = (Precio) o;
        return Objects.equals(value, that.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
