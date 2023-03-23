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

    @Override
    public void ShowClasses() {
        //TODO NAE
    }

    @Override
    public void ShowStudents() {
        //TODO NAE
    }

    @Override
    public void ShowClassBookPages() {
        //TODO NAE
    }

    @Override
    public void ShowTeachers() {
        //TODO NAE
    }

    @Override
    public void ShowSubjects() {
        //TODO NAE
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
