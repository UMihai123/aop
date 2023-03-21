public class cLaSs {
    private int class_id;

    private int year;

    private char letter;

    private int number_of_students;

    private String profile;

    cLaSs(){
        class_id = 0;
        year = 0;
        letter = ' ';
        number_of_students = 0;
        profile = "";
    }

    cLaSs(int class_id, int year, char letter, int number_of_students, String profile){
        this.class_id = class_id;
        this.year = year;
        this.letter = letter;
        this.number_of_students = number_of_students;
        this.profile = profile;
    }

    public int getClass_id() {
        return class_id;
    }

    public void setClass_id(int class_id) {
        this.class_id = class_id;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public char getLetter() {
        return letter;
    }

    public void setLetter(char letter) {
        this.letter = letter;
    }

    public int getNumber_of_students() {
        return number_of_students;
    }

    public void setNumber_of_students(int number_of_students) {
        this.number_of_students = number_of_students;
    }

    public String getProfile() {
        return profile;
    }

    public void setProfile(String profile) {
        this.profile = profile;
    }

    @Override
    public String toString(){
        return class_id + "\n" + year + "\n" + letter + "\n" + number_of_students + "\n" + profile;
    }
}
