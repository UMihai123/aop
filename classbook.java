import java.util.ArrayList;
import java.util.List;

public class classbook {
    private int classbook_id;

    private int student_id;

    private int subject_id;

    private List<Integer> grades;

    private int absences;

    private float average_mark;

    classbook(){
        classbook_id = 0;
        student_id = 0;
        subject_id = 0;
        grades = new ArrayList<Integer>();
        absences = 0;
        average_mark = 0;
    }

    classbook(int classbook_id, int student_id, int subject_id, List<Integer> grades, int absences, float average_mark){
        this.classbook_id = classbook_id;
        this.student_id = student_id;
        this.subject_id = subject_id;
        this.grades = grades;
        this.absences = absences;
        this.average_mark = average_mark;
    }

    public int getClassbook_id() {
        return classbook_id;
    }

    public void setClassbook_id(int classbook_id) {
        this.classbook_id = classbook_id;
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

    public float getAverage_mark() {
        return average_mark;
    }

    public void setAverage_mark(float average_mark) {
        this.average_mark = average_mark;
    }

    @Override
    public String toString(){
        return classbook_id + "\n" + student_id + "\n" + subject_id + "\n" + grades + "\n" + absences + "\n" + average_mark;
    }
}
