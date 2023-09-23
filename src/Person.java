import java.util.Objects;
import java.util.OptionalInt;

public class Person {
    protected final String name;
    protected final String surname;
    protected String age;
    protected String Address;

    public Person(String name, String surname, String age, String address) {
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.Address = address;
    }

    public boolean hasAge() {
        return !(age.isEmpty());
    }

    public boolean hasAddress() {
        return !Address.isEmpty();
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public OptionalInt getAge() {
        if (!age.isEmpty()) {
            return OptionalInt.of(Integer.parseInt(age));
        }
        return OptionalInt.empty();
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        this.Address = address;
    }

    public void happyBirthday() {
        if (!age.isEmpty()) {
            age = Integer.toString(Integer.parseInt(age) + 1);
        }
    }

    @Override
    public String toString() {
        return "Имя: " + name + "\n" + "Фамилия: " + surname + "\n" + "Возраст: "
                + age + "\n" + "Адрес: " + Address;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, surname);
    }

    public PersonBuilder newChildBuilder() {
        return new PersonBuilder()
                .setSurname(surname)
                .setAge(0)
                .setAddress(Address);
    }
}
