import java.util.Objects;
import java.util.OptionalInt;

class Person {
    protected final String name;
    protected final String lastname;
    protected int age = -1;
    protected String address = "";


    public Person(String name, String lastname) {
        this.name = name;
        this.lastname = lastname;
    }

    public Person(String name, String lastname, int age) {
        this.name = name;
        this.lastname = lastname;
        this.age = age;
    }

    public Person(String name, String lastname, int age, String address) {
        this.name = name;
        this.lastname = lastname;
        this.age = age;
        this.address = address;
    }

    public PersonBuilder newChildBuilder() {
        return new PersonBuilder()
                .setLastname(this.lastname)
                .setAge(0)
                .setAddress(this.address);
    }

    public boolean hasAge() {
        if (age < 0) {
            return false;
        }
        return true;
    }

    public boolean hasAddress() {
        return !address.isEmpty();
    }

    public String getName() {
        return name;
    }

    public String getLastname() {
        return lastname;
    }

    public OptionalInt getAge() {
        if (!hasAge()) {
            return OptionalInt.empty();
        }
        return OptionalInt.of(age);
    }

    public String getAddress() {
        if (!hasAddress()) {
            return "unknown";
        }
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void happyBirthday() {
        if (hasAge()) {
            age++;
        } else {
            System.out.println("Возраст неизвестен");
        }
    }

    @Override
    public String toString() {
        return "{" + "name=" + name
                + "; lastname=" + lastname
                + "; age=" + (this.hasAge() ? this.age : "unknown")
                + "; address=" + this.getAddress() + "}";
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, lastname, age, address);
    }
}