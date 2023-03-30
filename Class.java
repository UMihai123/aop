public class Class {
    private final int classroom_id;
    private static int currentId;

    private int schoolId;

    private int year;

    private char letter;

    private int number_of_students;

    private String profile;

    Class(int schoolId, int year, char letter, int number_of_students, String profile){
        this.classroom_id = currentId + 1;
        currentId++;

        this.schoolId = schoolId;
        this.year = year;
        this.letter = letter;
        this.number_of_students = number_of_students;
        this.profile = profile;
    }

    public static void setCurrentId(int id){
        currentId = id;
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
        return "The class is in the year " + year +
                " and has the letter " + letter + "\n" +
                "The class has " + number_of_students + " students " +
                "and is of the " + profile + " profile";
    }

    public int getSchoolId() {
        return schoolId;
    }

    public void setSchoolId(int schoolId) {
        this.schoolId = schoolId;
    }
}
