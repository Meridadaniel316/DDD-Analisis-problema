package co.com.sofka.domain.cliente.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class Descripcion implements ValueObject<String> {
    private final String value;

    public Descripcion(String value){
        this.value = Objects.requireNonNull(value);
        if(this.value.isBlank()){
            throw new IllegalArgumentException("La descripción del contrato no puede estar vacia");
        }
        if(value.length() > 35){
            throw new IllegalArgumentException("La descripción del contrato no puede superar los 35 caracteres.");
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
        Descripcion that = (Descripcion) o;
        return Objects.equals(value, that.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
