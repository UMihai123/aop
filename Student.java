import java.util.List;

public class Student extends Person {
    private final int studentId;
    private static int currentId;
    private double yearlyMark;
    private int classId;
    private List<ClassBookPage> grades;

    Student(){
        studentId = currentId + 1;
        currentId ++;

        yearlyMark = 0.0;
        classId = 0;
        grades = null;
    }

    Student(double yearlyMark, int classId, List<ClassBookPage> grades){
        studentId = currentId + 1;
        currentId ++;

        this.yearlyMark = yearlyMark;
        this.classId = classId;
        this.grades = grades;
    }

    public void CalculateYearlyMark(){

        for(ClassBookPage cbp : grades){
            cbp.CalculateAverageMark();
            yearlyMark += cbp.getAverage_mark();
        }

        yearlyMark = yearlyMark/grades.size();
    }

    public static void setCurrentId(int id){
        currentId = id;
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
