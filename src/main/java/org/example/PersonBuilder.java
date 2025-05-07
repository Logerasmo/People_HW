package org.example;

import java.util.OptionalInt;

public class PersonBuilder {
    private String name;
    private String surname;
    private OptionalInt age;
    private String city;

    public PersonBuilder setName(String name) {
        this.name = name;
        return this;
    }

    public PersonBuilder setSurname(String surname) {
        this.surname = surname;
        return this;
    }

    public PersonBuilder setAge(int age) {
        this.age = OptionalInt.of(age);
        return this;
    }

    public PersonBuilder setAddress(String address) {
        this.city = address;
        return this;
    }

    public Person build() {
        Person person;
        if (name == null || surname == null) {
            throw new IllegalStateException("Necessary arguments(name, surname) not found");
        }
        //Age check
        if (age.isPresent()) {
            if (age.getAsInt() < 0 || age.getAsInt() > 130) {
                throw new IllegalArgumentException("Wrong age set");
            }
            //City check
            if (city != null) {
                person = new Person(name, surname, age.getAsInt(), city);
            } else {
                person = new Person(name, surname, age.getAsInt());
            }
        } else if (city != null) {
            person = new Person(name, surname, city);
        } else {
            person = new Person(name, surname);
        }


        return person;
    }
}
