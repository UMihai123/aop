package models;

import models.Person;

public class Teacher extends Person {
    private final int teacherId;
    private static int currentId;
    private double salary;
    private int subjectId;

    public Teacher(){
        teacherId = currentId + 1;
        currentId++;

        salary = 0.0;
        subjectId = 0;
    }

    Teacher(double salary, int subjectId){
        teacherId = currentId + 1;
        currentId++;

        this.salary = salary;
        this.subjectId = subjectId;
    }

    public static void setCurrentId(int id){
        currentId = id;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public int getSubjectId() {
        return subjectId;
    }

    public void setSubjectId(int subjectId) {
        this.subjectId = subjectId;
    }

    @Override
    public String toString(){
        return "Teacher's name is: " + getFirstName() + " " + getLastName() + "\n" +
                "Teacher's e-mail is: " + getEmail() + "\n" +
                "Teacher's age is: " + getAge() + "\n" +
                "Teacher's address is: " + getAddress() + "\n" +
                "Teacher's salary is: " + salary;
    }
}
