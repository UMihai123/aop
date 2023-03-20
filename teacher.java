public class teacher extends person{
    private double salary;
    private int subjectId;

    teacher(){
        salary = 0.0;
        subjectId = 0;
    }

    teacher(double salary, int subjectId){
        this.salary = salary;
        this.subjectId = subjectId;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public int getSubjectId() {
        return subjectId;
    }

    public void setSubjectId(int subjectId) {
        this.subjectId = subjectId;
    }

    @Override
    public String toString(){
        return getFirstName() + " " + getLastName() + "\n" + getEmail() + "\n" + getAge() + "\n" + getAddress() + "\n" + salary;
    }
}
