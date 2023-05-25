package models;

import java.util.List;

public class Student extends Person {
    private final int studentId;
    private static int CURRENT_ID;

    private double yearlyMark;
    private int classId;
    private List<ClassBookPage> grades;

    public Student(){
        studentId = CURRENT_ID + 1;
        CURRENT_ID++;

        yearlyMark = 0.0;
        classId = 0;
        grades = null;
    }

    Student(double yearlyMark, int classId, List<ClassBookPage> grades){
        studentId = CURRENT_ID + 1;
        CURRENT_ID++;

        System.out.println(yearlyMark);
        this.yearlyMark = yearlyMark;
        this.classId = classId;
        this.grades = grades;
    }

    public void CalculateYearlyMark() {

        if (grades.size() != 0) {
            for (ClassBookPage cbp : grades) {
                yearlyMark += cbp.getAverage_mark();
            }
            yearlyMark = yearlyMark / grades.size();
        } else {
            yearlyMark = 0.0;
        }

    }

    public static void setCurrentId(int id){
        CURRENT_ID = id;
    }

    public int getStudentId() {
        return studentId;
    }

    public int getClassId() {
        return classId;
    }

    public void setClassId(int classId) {
        this.classId = classId;
    }

    public List<ClassBookPage> getGrades(){
        return grades;
    }

    public void setGrades(List<ClassBookPage> grades) {
        this.grades = grades;
    }

    public double getYearlyMark(){
        return yearlyMark;
    }

    public void setYearlyMark(double yearlyMark){
        this.yearlyMark = yearlyMark;
    }

    public String toString(){
        return "Student's name is: " + getFirstName() + " " + getLastName() + "\n" +
                "Student's e-mail is: " + getEmail() + "\n" +
                "Student's age is: " + getAge() + "\n" +
                "Student's yearly mark is: " + yearlyMark + "\n" +
                "Part of class with id: " + classId + "\n";
    }
}
