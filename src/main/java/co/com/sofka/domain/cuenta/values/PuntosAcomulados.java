package co.com.sofka.domain.cuenta.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class PuntosAcomulados implements ValueObject<String> {
    private final String value;

    public PuntosAcomulados(String value){
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
        PuntosAcomulados that = (PuntosAcomulados) o;
        return Objects.equals(value, that.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
