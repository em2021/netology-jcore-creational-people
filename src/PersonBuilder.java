public class PersonBuilder {
    public String name = "";
    public String lastname = "";
    public int age = -1;
    public String address = "";

    public PersonBuilder setName(String name) {
        this.name = name;
        return this;
    }

    public PersonBuilder setLastname(String lastname) {
        this.lastname = lastname;
        return this;
    }

    public PersonBuilder setAge(int age) throws IllegalArgumentException {
        if (age < 0) {
            throw new IllegalArgumentException("Возраст человека не может быть отрицательным");
        } else {
            this.age = age;
        }
        return this;
    }

    public PersonBuilder setAddress(String address) {
        this.address = address;
        return this;
    }

    public Person build() throws IllegalStateException {
        if (name.isEmpty()) throw new IllegalStateException("У человека должно быть имя");
        if (lastname.isEmpty()) throw new IllegalStateException("У человека должна быть фамилия");
        return new Person(name, lastname, age, address);
    }
}