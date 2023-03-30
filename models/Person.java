package models;

import models.Location;

public class Person {
    private String firstName;
    private String lastName;
    private String email;
    private int age;
    private Location address;

    Person(){
        firstName = "";
        lastName = "";
        email = "";
        age = 0;
        address = new Location();
    }

    public Person(String firstName, String lastName, String email, int age, Location address){
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.age = age;
        this.address = address;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Location getAddress() {
        return address;
    }

    public void setAddress(Location address) {
        this.address = address;
    }

    @Override
    public String toString(){
        return "models.Person's name is: " + firstName + " " + lastName + "\n" +
                "models.Person's e-mail is: " + email + "\n" +
                "models.Person's age is: " + age + "\n" +
                "models.Person's address is: " + address;
    }
}
