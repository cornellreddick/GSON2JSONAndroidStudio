package com.example.gson2json;

public class Person {
    String name;
    String id;
    String age;
    Address address;

    public Person() {
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", id='" + id + '\'' +
                ", age='" + age + '\'' +
                ", address=" + address +
                '}';
    }

    public String getName() {
        return name;
    }

    public String getId() {
        return id;
    }

    public String getAge() {
        return age;
    }

    public Address getAddress() {
        return address;
    }

    public Person(String name, String id, String age, Address address) {
        this.name = name;
        this.id = id;
        this.age = age;
        this.address = address;
    }
}
