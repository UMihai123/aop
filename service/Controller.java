package service;

import dbConnection.DbConnection;
import models.*;

import java.lang.Class;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Controller implements IController {

    private List<School> schools;
    private List<Student> students;
    private List<ClassBookPage> classBookPages;
    private List<Teacher> teachers;
    private List<Subject> subjects;
    private List<ClassRoom> classes;
    private Scanner input;
    private DbConnection _db;

    public Controller(){
        _db = new DbConnection();
        if(_db.isNull()){
            System.exit(-1);
        }
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
        if(student.getYearlyMark() == 0){
            System.out.println("Bag pula ba");
        }

        return student;
    }

    private ClassRoom ReadClass(int schoolId){
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

        ClassRoom c = new ClassRoom(schoolId, year, letter, nrOfStudents, profile);
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
        String query = "SELECT * FROM school";
        ResultSet rs = _db.executeStatement(query);
        try{
            while(rs.next()){
                School s = new School();
                s.setName(rs.getString("Name"));
                int id = rs.getInt("locationId");
                query = "SELECT * FROM location WHERE locationId = " + id;
                ResultSet rs2 = _db.executeStatement(query);
                try{
                    while(rs2.next()){
                        SchoolLocation l = new SchoolLocation();
                        l.setArea(rs2.getDouble("Area"));
                        l.setCity(rs2.getString("City"));
                        l.setSeismicRisk(rs2.getString("SeismicRisk"));
                        l.setNumber(rs2.getInt("Number"));
                        l.setStreet(rs2.getString("Street"));
                        s.setLocation(l);
                    }
                }
                catch(SQLException ex){
                    ex.printStackTrace();
                }finally{
                    try { rs2.close(); } catch(SQLException ex) {}
                }
                schools.add(s);
            }
        }
        catch(SQLException ex){
            ex.printStackTrace();
        }finally{
            try { rs.close(); } catch(SQLException ex) {}
        }
        System.out.println();
        for(School school : schools){
            System.out.println(i++ + ".");
            System.out.println(school);
        }
    }

    @Override
    public void ShowClasses(int schoolId) {
        int i = 1;
        String query = "SELECT * FROM classroom";
        ResultSet rs = _db.executeStatement(query);
        try{
            while(rs.next()){
                ClassRoom c = new ClassRoom();
                c.setSchoolId(schoolId);
                c.setYear(rs.getInt("year"));
                c.setLetter(rs.getString("letter").charAt(0));
                c.setProfile(rs.getString("profile"));
                c.setNumber_of_students(rs.getInt("number_of_students"));
                classes.add(c);
            }
        }
        catch(SQLException ex){
            ex.printStackTrace();
        }finally{
            try { rs.close(); } catch(SQLException ex) {}
        }
        System.out.println();
        for(ClassRoom clasa : classes){
            if(clasa.getSchoolId() == schoolId) {
                System.out.println(i++ + ".");
                System.out.println(clasa);
            }
        }
    }

    @Override
    public void ShowStudents(int classId) {
        int i = 1;
        String query = "SELECT * FROM student";
        ResultSet rs = _db.executeStatement(query);
        try{
            while(rs.next()){
                Student s = new Student();
                s.setFirstName(rs.getString("firstName"));
                s.setLastName(rs.getString("lastName"));
                s.setEmail(rs.getString("email"));

                s.setYearlyMark(rs.getInt("yearlyMark"));
                s.setClassId(rs.getInt("classId"));
                query = "SELECT * FROM classbookpage where student_id = " + s.getStudentId();
                ResultSet rs2 = _db.executeStatement(query);
                try{
                    while(rs2.next()){
                        ClassBookPage c = new ClassBookPage();
                        c.setAbsences(rs2.getInt("absences"));
                        String[] grades = rs2.getString("grades").split(" ");
                        List<Integer> intGrades = new ArrayList<>();
                        for (String st : grades) {
                            intGrades.add(Integer.parseInt(st));
                        }
                        c.setGrades(intGrades);
                        c.setStudent_id(rs2.getInt("studentId"));
                        c.setAverage_mark(rs2.getInt("averageMark"));
                        List<ClassBookPage> g = s.getGrades();
                        g.add(c);
                        s.setGrades(g);
                        break;
                    }
                }catch(SQLException ex){
                    ex.printStackTrace();
                }
                finally{
                    try { rs2.close(); } catch(SQLException ex) {}
                }
                students.add(s);
            }
        }
        catch(SQLException ex){
            ex.printStackTrace();
        }finally{
            try { rs.close(); } catch(SQLException ex) {}
        }
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
        String query = "SELECT * FROM classbookpage WHERE student_id = " + studentId;
        ResultSet rs = _db.executeStatement(query);
        try{
            while(rs.next()){
                ClassBookPage c = new ClassBookPage();
                c.setAbsences(rs.getInt("absences"));
                String[] grades = rs.getString("grades").split(" ");
                List<Integer> intGrades = new ArrayList<>();
                for (String s : grades) {
                    intGrades.add(Integer.parseInt(s));
                }
                c.setGrades(intGrades);
                c.setStudent_id(rs.getInt("studentId"));
                c.setAverage_mark(rs.getInt("averageMark"));
                for (Student student : students){
                    if (student.getStudentId() == studentId){
                        List<ClassBookPage> g = student.getGrades();
                        g.add(c);
                        student.setGrades(g);
                        break;
                    }
                }
            }
        }
        catch(SQLException ex){
            ex.printStackTrace();
        }finally{
            try { rs.close(); } catch(SQLException ex) {}
        }
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
        String query = "SELECT * FROM teacher";
        ResultSet rs = _db.executeStatement(query);
        try{
            while(rs.next()){
                Teacher t = new Teacher();
                t.setFirstName(rs.getString("firstName"));
                t.setLastName(rs.getString("lastName"));
                t.setSalary(rs.getDouble("salary"));
                t.setAge(rs.getInt("age"));
                t.setEmail(rs.getString("email"));
                t.setSubjectId(rs.getInt("subjectId"));

                teachers.add(t);
            }
        }
        catch(SQLException ex){
            ex.printStackTrace();
        }finally{
            try { rs.close(); } catch(SQLException ex) {}
        }
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
        String query = "SELECT * FROM subject";
        ResultSet rs = _db.executeStatement(query);
        try{
            while(rs.next()){
                Subject s = new Subject();
                s.setSubject_name(rs.getString("subject_name"));
                s.setClasses_per_week(rs.getInt("classes_per_week"));
                s.setSchoolId(rs.getInt("schoolId"));
                s.setHas_exam(rs.getBoolean("has_exam"));

                subjects.add(s);
            }
        }
        catch(SQLException ex){
            ex.printStackTrace();
        }finally{
            try { rs.close(); } catch(SQLException ex) {}
        }
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

        SchoolLocation sl = ReadSchoolLocation();

        String query = "INSERT INTO location (street, city, number, seismicRisk, area) VALUES ('"
                            + sl.getStreet() + "', '" + sl.getCity() + "', " + sl.getNumber() + ", '" + sl.getSeismicRisk() + "', " + sl.getArea() + ")";

        _db.executeInsert(query);

        query = "SELECT MAX(locationId) FROM location";

        ResultSet rs = _db.executeStatement(query);

        try {
            if(rs.next()){
                int id = rs.getInt(1);
                query = "INSERT INTO school (name, locationId) VALUES ('" + name + "', " + id + ")";
                _db.executeInsert(query);
            }
        }
        catch(SQLException ex){
            ex.printStackTrace();
        }finally{
            try { rs.close(); } catch(SQLException ex) {}
        }
    }

    @Override
    public void CreateClass(int schoolId) {
        ClassRoom c = ReadClass(schoolId);

        String query = "INSERT INTO classroom (schoolId, year, letter, number_of_students, profile) VALUES (" +
                        c.getSchoolId() + ", " + c.getYear() + ", '" + c.getLetter() + "', " + c.getNumber_of_students() + ", '" + c.getProfile() + "')";
        _db.executeInsert(query);
    }

    @Override
    public void CreateStudent(int classId) {
        Student s = ReadStudent(classId);
        Location l = s.getAddress();

        String query = "INSERT INTO location (street, city, number) VALUES ('" +
                        l.getStreet() + "', '" + l.getCity() + "', " + l.getNumber() + ")";

        _db.executeInsert(query);

        query = "SELECT MAX(locationId) FROM location";

        ResultSet rs = _db.executeStatement(query);

        try {
            if(rs.next()){
                int id = rs.getInt(1);
                query = "INSERT INTO student (firstName, lastName, email, age, location_id, yearlyMark, classId) VALUES ('"
                        + s.getFirstName() + "', '" + s.getLastName() + "', '" + s.getEmail() + "', " + s.getAge() + ", " + id + ", " + s.getYearlyMark() + ", " + s.getClassId() + ")";
                _db.executeInsert(query);
            }
        }
        catch(SQLException ex){
            ex.printStackTrace();
        }finally{
            try { rs.close(); } catch(SQLException ex) {}
        }
    }

    @Override
    public void CreateTeachers(int subjectId) {
        Teacher t = ReadTeacher(subjectId);
        Location l = t.getAddress();

        String query = "INSERT INTO location (street, city, number) VALUES ('" +
                l.getStreet() + "', '" + l.getCity() + "', " + l.getNumber() + ")";

        _db.executeInsert(query);

        query = "SELECT MAX(locationId) FROM location";

        ResultSet rs = _db.executeStatement(query);

        try {
            if(rs.next()){
                int id = rs.getInt(1);
                query = "INSERT INTO teacher (firstName, lastName, email, age, location_id, salary, subjectId) VALUES ('"
                        + t.getFirstName() + "', '" + t.getLastName() + "', '" + t.getEmail() + "', " + t.getAge() + ", " + id + ", " + t.getSalary() + ", " + t.getSubjectId() + ")";
                _db.executeInsert(query);
            }
        }
        catch(SQLException ex){
            ex.printStackTrace();
        }finally{
            try { rs.close(); } catch(SQLException ex) {}
        }
    }

    @Override
    public void CreateSubject(int schoolId) {
        Subject s = ReadSubject(schoolId);

        String query = "INSERT INTO subject (schoolId, subject_name, classes_per_week, has_exam) Values (" +
                        s.getSchoolId() + ", '" + s.getSubject_name() + "', " + s.getClasses_per_week() + ", " + s.getHas_exam() + ")";

        _db.executeInsert(query);
    }
}
