public class person {
    private String firstName;
    private String lastName;
    private String email;
    private int age;
    private location address;

    person(){
        firstName = "";
        lastName = "";
        email = "";
        age = 0;
        address = new location();
    }

    person(String firstName, String lastName, String email, int age, location address){
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.age = age;
        this.address = address;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public location getAddress() {
        return address;
    }

    public void setAddress(location address) {
        this.address = address;
    }

    @Override
    public String toString(){
        return firstName + " " + lastName + "\n" + email + "\n" + age + "\n" + address;
    }
}