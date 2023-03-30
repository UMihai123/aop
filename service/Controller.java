package service;

import models.*;

import java.lang.Class;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Controller implements IController {

    private List<School> schools;
    private List<Student> students;
    private List<ClassBookPage> classBookPages;
    private List<Teacher> teachers;
    private List<Subject> subjects;
    private List<Class> classes;
    private Scanner input;

    public Controller(){
        schools = new ArrayList<>();
        students = new ArrayList<>();
        classBookPages = new ArrayList<>();
        teachers = new ArrayList<>();
        subjects = new ArrayList<>();
        classes = new ArrayList<>();

        input = new Scanner(System.in);
    }

    public int GetNrOfSchools(){
        return schools.size();
    }
    public int GetNrOfClasses(){
        return classes.size();
    }
    public int GetNrOfSubjects(){
        return subjects.size();
    }
    public int GetNrOfStudents(){
        return students.size();
    }

    private SchoolLocation ReadSchoolLocation(){
        Location location = ReadLocation();
        System.out.println("Enter the seismic risk: ");
        String seismicRisk = input.nextLine();
        System.out.println("Enter the area: ");
        double area = input.nextDouble();
        input.nextLine();

        return new SchoolLocation(location, seismicRisk, area);
    }

    private Location ReadLocation(){
        System.out.println("Enter the street: ");
        String street = input.nextLine();
        System.out.println("Enter the city: ");
        String city = input.nextLine();
        System.out.println("Enter the number: ");
        int number = input.nextInt();
        input.nextLine();

        return new Location(street, city, number);
    }

    private List<ClassBookPage> ReadGrades(int studentId){
        List<ClassBookPage> grades = new ArrayList<>();
        for(Subject subject : subjects){
            System.out.println("What will be the number of grades for the subject: " + subject.getSubject_name());
            int total = input.nextInt();
            input.nextLine();
            System.out.println("What are the grades?");
            List<Integer> g = new ArrayList<>();
            for(;total >= 1; total--) {
                g.add(input.nextInt());
            }
            System.out.println("How many absences does the student have?");
            int absences = input.nextInt();
            input.nextLine();

            ClassBookPage grade = new ClassBookPage();
            grade.setGrades(g);
            grade.setAbsences(absences);
            grade.setStudent_id(studentId);
            grade.CalculateAverageMark();

            grades.add(grade);
        }

        return grades;
    }

    private Person ReadPerson(){
        System.out.println("What is the first name?");
        String firstName = input.nextLine();
        System.out.println("What is the last name?");
        String lastName = input.nextLine();
        System.out.println("What is the email?");
        String email = input.nextLine();
        System.out.println("What is the age?");
        int age = input.nextInt();
        input.nextLine();
        Location location = ReadLocation();

        return new Person(firstName, lastName, email, age, location);
    }

    private Student ReadStudent(int classId){
        Person person = ReadPerson();

        Student student = new Student();
        student.setClassId(classId);
        student.setFirstName(person.getFirstName());
        student.setLastName(person.getLastName());
        student.setEmail(person.getEmail());
        student.setClassId(classId);
        student.setAge(person.getAge());
        student.setAddress(person.getAddress());
        List<ClassBookPage> grades = ReadGrades(student.getStudentId());
        student.setGrades(grades);
        student.CalculateYearlyMark();

        return student;
    }

    private Class ReadClass(int schoolId){
        System.out.println("Enter the year of the class: ");
        int year = input.nextInt();
        input.nextLine();
        System.out.println("Enter the letter of the class: ");
        char letter = input.next().charAt(0);
        input.nextLine();
        System.out.println("Enter the number of students of the class: ");
        int nrOfStudents = input.nextInt();
        input.nextLine();
        System.out.println("Enter the profile of the class: ");
        String profile = input.nextLine();

        Class c = new Class(schoolId, year, letter, nrOfStudents, profile);
        return c;
    }

    private Teacher ReadTeacher(int subjectId){
        Person person = ReadPerson();
        System.out.println("Enter the teachers salary: ");
        double salary = input.nextDouble();
        input.nextLine();

        Teacher teacher = new Teacher();
        teacher.setSalary(salary);
        teacher.setSubjectId(subjectId);
        teacher.setFirstName(person.getFirstName());
        teacher.setLastName(person.getLastName());
        teacher.setEmail(person.getEmail());
        teacher.setAge(person.getAge());
        teacher.setAddress(person.getAddress());

        return teacher;
    }

    private Subject ReadSubject(int schoolId){
        System.out.println("Enter the subjects name: ");
        String name = input.nextLine();
        System.out.println("Enter the number of hours per week: ");
        int classesPerWeek = input.nextInt();
        input.nextLine();
        System.out.println("Does the subject have an exam? True/False");
        boolean hasExam = input.nextBoolean();
        input.nextLine();

        Subject s = new Subject(schoolId, name, classesPerWeek, hasExam);
        return s;
    }


    @Override
    public void ShowSchools() {
        int i = 1;
        System.out.println();
        for(School school : schools){
            System.out.println(i++ + ".");
            System.out.println(school);
        }
    }

    @Override
    public void ShowClasses(int schoolId) {
        int i = 1;
        System.out.println();
        for(Class clasa : classes){
            if(clasa.getSchoolId() == schoolId) {
                System.out.println(i++ + ".");
                System.out.println(clasa);
            }
        }
    }

    @Override
    public void ShowStudents(int classId) {
        int i = 1;
        System.out.println();
        for(Student student : students){
            if(student.getClassId() == classId) {
                System.out.println(i++ + ".");
                System.out.println(student);
            }
        }
    }

    @Override
    public void ShowClassBookPages(int studentId) {
        int i = 1;
        System.out.println();
        for(ClassBookPage classBookPage : classBookPages){
            if(classBookPage.getStudent_id() == studentId) {
                System.out.println(i++ + ".");
                System.out.println(classBookPage);
            }
        }
    }

    @Override
    public void ShowTeachers(int subjectId) {
        int i = 1;
        System.out.println();
        for(Teacher teacher : teachers){
            if(teacher.getSubjectId() == subjectId) {
                System.out.println(i++ + ".");
                System.out.println(teacher);
            }
        }
    }

    @Override
    public void ShowSubjects(int schoolId) {
        int i = 1;
        System.out.println();
        for(Subject subject : subjects){
            if(subject.getSchoolId() == schoolId){
                System.out.println(i++ + ".");
                System.out.println(subject);
            }
        }
    }

    @Override
    public void CreateSchool() {
        System.out.println("Enter the name of the school: ");
        String name = input.nextLine();

        schools.add(new School(name, ReadSchoolLocation()));
    }

    @Override
    public void CreateClass(int schoolId) {
        classes.add(ReadClass(schoolId));
    }

    @Override
    public void CreateStudent(int classId) {
        students.add(ReadStudent(classId));
    }

    @Override
    public void CreateTeachers(int subjectId) {
        teachers.add(ReadTeacher(subjectId));
    }

    @Override
    public void CreateSubject(int schoolId) {
        subjects.add(ReadSubject(schoolId));
    }
}
