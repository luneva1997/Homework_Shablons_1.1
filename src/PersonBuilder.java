import java.util.Objects;
import java.util.OptionalInt;

public class PersonBuilder {
    protected String name;
    protected String surname;
    protected String age;
    protected String address;

    public PersonBuilder setName(String name) {
        this.name = name;
        return this;
    }

    public PersonBuilder setSurname(String surname) {
        this.surname = surname;
        return this;
    }

    public PersonBuilder setAge(int age) {
        if (age >= 0 && age <= 120) {
            this.age = Integer.toString(age);
            return this;
        } else {
            throw new IllegalArgumentException("Возраст должен быть в пределах от 0 до 120");
        }
    }

    public PersonBuilder setAddress(String address) {
        this.address = address;
        return this;
    }

    public Person build() {
        if (name == null) {
            throw new IllegalStateException("Не введено имя!");
        } else if (surname == null) {
            throw new IllegalStateException("Не введена фамилия!");
        } else {
            return new Person(name, surname, age, address);
        }
    }
}
