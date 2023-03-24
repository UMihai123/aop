import java.util.List;

public class Controller implements IController{

    private List<School> schools;

    @Override
    public void ShowSchools() {
        int i = 1;
        for(School school : schools){
            System.out.println(i++ + ".\n");
            System.out.println(school);
        }
    }

    private List<Class> classes;
    @Override
    public void ShowClasses() {
        int i = 1;
        for(Class clasa : classes){
            System.out.println(i++ + ".\n");
            System.out.println(clasa);
        }
    }

    private List<Student> students;
    @Override
    public void ShowStudents() {
        int i = 1;
        for(Student student : students){
            System.out.println(i++ + ".\n");
            System.out.println(student);
        }
    }

    private List<ClassBookPage> classBookPages;
    @Override
    public void ShowClassBookPages() {
        int i = 1;
        for(ClassBookPage classBookPage : classBookPages){
            System.out.println(i++ + ".\n");
            System.out.println(classBookPage);
        }
    }

    private List<Teacher> teachers;
    @Override
    public void ShowTeachers() {
        int i = 1;
        for(Teacher teacher : teachers){
            System.out.println(i++ + ".\n");
            System.out.println(teacher);
        }
    }

    private List<Subject> subjects;
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
        //TODO MIAI
    }

    @Override
    public void CreateClass() {
        //TODO MIAI
    }

    @Override
    public void CreateStudent() {
        //TODO MIAI
    }

    @Override
    public void CreateTeachers() {
        //TODO MIAI
    }

    @Override
    public void CreateSubject() {
        //TODO MIAI
    }

    @Override
    public void ShowTopStudents(int numberToShow) {
        //TODO MIAI
    }
}
