import java.util.List;
import java.util.Scanner;

public class Controller implements IController{

    private List<School> schools;
    private List<Student> students;
    private List<ClassBookPage> classBookPages;
    private List<Teacher> teachers;
    private List<Subject> subjects;
    private List<Class> classes;
    Scanner input = new Scanner(System.in);


    private SchoolLocation ReadSchoolLocation(Scanner input){
        Location location = ReadLocation(input);
        String seismicRisk = input.nextLine();
        double area = input.nextDouble();

        return new SchoolLocation(location, seismicRisk, area);
    }

    private Location ReadLocation(Scanner input){
        String street = input.nextLine();
        String city = input.nextLine();
        int number = input.nextInt();

        return new Location(street, city, number);
    }

    private List<ClassBookPage> ReadGrades(Scanner input, int studentId){
        List<ClassBookPage> grades = null;
        for(Subject subject : subjects){
            System.out.println("What will be the number of grades for the subject: " + subject.getSubject_name());
            int total = input.nextInt();
            System.out.println("What are the grades?");
            List<Integer> g = null;
            for(;total >= 0; total--) {
                g.add(input.nextInt());
            }
            System.out.println("How many absences does the student have?");
            int absences = input.nextInt();

            ClassBookPage grade = new ClassBookPage();
            grade.setGrades(g);
            grade.setAbsences(absences);
            grade.setStudent_id(studentId);
            grade.CalculateAverageMark();

            grades.add(grade);
        }

        return grades;
    }

    private Person ReadPerson(Scanner input){
        System.out.println("What is the first name?");
        String firstName = input.nextLine();
        System.out.println("What is the last name?");
        String lastName = input.nextLine();
        System.out.println("What is the email?");
        String email = input.nextLine();
        System.out.println("What is the age?");
        int age = input.nextInt();
        Location location = ReadLocation(input);

        return new Person(firstName, lastName, email, age, location);
    }


    @Override
    public void ShowSchools() {
        int i = 1;
        for(School school : schools){
            System.out.println(i++ + ".\n");
            System.out.println(school);
        }
    }

    @Override
    public void ShowClasses() {
        int i = 1;
        for(Class clasa : classes){
            System.out.println(i++ + ".\n");
            System.out.println(clasa);
        }
    }

    @Override
    public void ShowStudents() {
        int i = 1;
        for(Student student : students){
            System.out.println(i++ + ".\n");
            System.out.println(student);
        }
    }

    @Override
    public void ShowClassBookPages() {
        int i = 1;
        for(ClassBookPage classBookPage : classBookPages){
            System.out.println(i++ + ".\n");
            System.out.println(classBookPage);
        }
    }

    @Override
    public void ShowTeachers() {
        int i = 1;
        for(Teacher teacher : teachers){
            System.out.println(i++ + ".\n");
            System.out.println(teacher);
        }
    }

    @Override
    public void ShowSubjects() {
        int i = 1;
        for(Subject subject : subjects){
            System.out.println(i++ + ".\n");
            System.out.println(subject);
        }
    }

    @Override
    public void CreateSchool() {
        String name = input.nextLine();

        schools.add(new School(name, ReadSchoolLocation(input)));
    }

    @Override
    public void CreateClass() {
        int year = input.nextInt();
        char letter = input.next().charAt(0);
        int nrOfStudents = input.nextInt();
        String profile = input.nextLine();

        classes.add(new Class(year, letter, nrOfStudents, profile));
    }

    @Override
    public void CreateStudent() {
        Person person = ReadPerson(input);
        double yearlyMark = input.nextDouble();
        int classId = input.nextInt();

        Student student = new Student();
        student.setClassId(classId);
        student.setYearlyMark(yearlyMark);
        student.setFirstName(person.getFirstName());
        student.setLastName(person.getLastName());
        student.setEmail(person.getEmail());
        student.setAge(person.getAge());
        student.setAddress(person.getAddress());
        List<ClassBookPage> grades = ReadGrades(input, student.getStudentId());
        student.setGrades(grades);

        students.add(student);
    }

    @Override
    public void CreateTeachers() {
        Person person = ReadPerson(input);
        double salary = input.nextDouble();
        int subjectId = input.nextInt();

        Teacher teacher = new Teacher();
        teacher.setSalary(salary);
        teacher.setSubjectId(subjectId);
        teacher.setFirstName(person.getFirstName());
        teacher.setLastName(person.getLastName());
        teacher.setEmail(person.getEmail());
        teacher.setAge(person.getAge());
        teacher.setAddress(person.getAddress());

        teachers.add(teacher);
    }

    @Override
    public void CreateSubject() {
        String name = input.nextLine();
        int classesPerWeek = input.nextInt();
        boolean hasExam = input.nextBoolean();

        subjects.add(new Subject(name, classesPerWeek, hasExam));
    }
}
