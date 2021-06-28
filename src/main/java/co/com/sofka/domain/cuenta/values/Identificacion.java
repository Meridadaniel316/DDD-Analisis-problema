package co.com.sofka.domain.cuenta.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class Identificacion implements ValueObject<String> {

    private final String value;

    public Identificacion(String value){
        this.value = Objects.requireNonNull(value);
        if(value.length() > 15){
            throw new IllegalArgumentException("No puede superar el usuario mas de 15 caracteres");
        }
        if(value.length() < 3){
            throw new IllegalArgumentException("Debes ingresar minimo 3 caracteres.");
        }
    }

    @Override
    public String value() { return value; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Identificacion that = (Identificacion) o;
        return Objects.equals(value, that.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
