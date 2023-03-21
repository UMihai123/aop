public class subject {
    private int subject_id;

    private String subject_name;

    private  int classes_per_week;

    private  Boolean has_exam;

    subject(){
        subject_id = 0;
        subject_name = "";
        classes_per_week = 0;
        has_exam = false;
    }

    subject(int subject_id, String subject_name, int classes_per_week, Boolean has_exam){
        this.subject_id = subject_id;
        this.subject_name = subject_name;
        this.classes_per_week = classes_per_week;
        this.has_exam = has_exam;
    }

    public int getSubject_id() {
        return subject_id;
    }

    public void setSubject_id(int subjectId) {
        this.subject_id = subjectId;
    }

    public String getSubject_name() {
        return subject_name;
    }

    public void setSubject_name(String subject_name) {
        this.subject_name = subject_name;
    }

    public int getClasses_per_week() {
        return classes_per_week;
    }

    public void setClasses_per_week(int classes_per_week) {
        this.classes_per_week = classes_per_week;
    }

    public Boolean getHas_exam() {
        return has_exam;
    }

    public void setHas_exam(Boolean has_exam) {
        this.has_exam = has_exam;
    }

    @Override
    public String toString(){
        return subject_id + "\n" + subject_name + "\n" + classes_per_week + "\n" + has_exam;
    }
}
