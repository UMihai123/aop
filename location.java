public class location {
    private String street;
    private String city;

    private int number;

    location(){
        street = "";
        city = "";
    }

    location(String street, String city){
        this.street = street;
        this.city = city;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    @Override
    public String toString(){
        return this.city + "\n" + this.street + "\n";
    }
}
