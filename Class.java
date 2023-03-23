public class Class {
    private final int classroom_id;
    private static int currentId;

    private int year;

    private char letter;

    private int number_of_students;

    private String profile;

    Class(){
        classroom_id = currentId + 1;
        currentId++;

        year = 0;
        letter = ' ';
        number_of_students = 0;
        profile = "";
    }

    Class(int year, char letter, int number_of_students, String profile){
        this.classroom_id = currentId + 1;
        currentId++;

        this.year = year;
        this.letter = letter;
        this.number_of_students = number_of_students;
        this.profile = profile;
    }

    public static void setCurrentId(int id){
        currentId = id;
    }

    public int getClass_id() {
        return classroom_id;
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
        return classroom_id + "\n" + year + "\n" + letter + "\n" + number_of_students + "\n" + profile;
    }
}
