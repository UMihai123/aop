package models;

import java.util.ArrayList;
import java.util.List;

public class ClassBookPage {
    private final int classbook_id;
    private static int currentId;

    private int student_id;

    private int subject_id;

    private List<Integer> grades;

    private int absences;

    private double average_mark;

    public ClassBookPage(){
        classbook_id = currentId + 1;
        currentId++;

        student_id = 0;
        subject_id = 0;
        grades = new ArrayList<Integer>();
        absences = 0;
        average_mark = 0;
    }

    ClassBookPage(int student_id, int subject_id, List<Integer> grades, int absences, float average_mark){
        this.classbook_id = currentId + 1;
        currentId++;

        this.student_id = student_id;
        this.subject_id = subject_id;
        this.grades = grades;
        this.absences = absences;
        this.average_mark = average_mark;
    }

    public static void setCurrentId(int id){
        currentId = id;
    }

    public void CalculateAverageMark(){
        for (Integer grade : grades) {
            average_mark += grade;
        }

        average_mark = average_mark/grades.size();
    }

    public int getClassbook_id() {
        return classbook_id;
    }
    public int getStudent_id() {
        return student_id;
    }

    public void setStudent_id(int student_id) {
        this.student_id = student_id;
    }

    public int getSubject_id() {
        return subject_id;
    }

    public void setSubject_id(int subjectId) {
        this.subject_id = subjectId;
    }

    public List<Integer> getGrades() {
        return grades;
    }

    public void setGrades(List<Integer> grades) {
        this.grades = grades;
    }

    public int getAbsences() {
        return absences;
    }

    public void setAbsences(int absences) {
        this.absences = absences;
    }

    public double getAverage_mark() {
        return average_mark;
    }

    public void setAverage_mark(float average_mark) {
        this.average_mark = average_mark;
    }

    @Override
    public String toString(){
        return student_id + "\n" + subject_id + "\n" + grades + "\n" + absences + "\n" + average_mark;
    }
}
