public class Location {
    private final int locationId;
    private static int currentId;
    private String street;
    private String city;
    private int number;

    Location(){
        locationId = ++currentId;

        street = "";
        city = "";
    }

    Location(String street, String city, int number){
        locationId = ++currentId;

        this.street = street;
        this.city = city;
        this.number = number;
    }

    public static void setCurrentId(int id){
        currentId = id;
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
        return "The address is in the city of " + this.city + " on street " + this.street + "\n";
    }
}
