package co.com.sofka.domain.cuenta.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class Email implements ValueObject<String> {

    private final String value;

    public Email(String value){
        this.value = Objects.requireNonNull(value);
        if(value.length() > 55){
            throw new IllegalArgumentException("El email no puede superar mas de 55 caracteres.");
        }
        if(value.length() < 3){
            throw new IllegalArgumentException("Debes ingresar minimo 3 caracteres.");
        }

        if(!value.matches("^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@[a-zA-Z0-9-]+(?:\\.[a-zA-Z0-9-]+)*$")){
            throw new IllegalArgumentException("El email no es valido");
        }
    }

    @Override
    public String value() { return value; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Email email = (Email) o;
        return Objects.equals(value, email.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
