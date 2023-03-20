public class school {
    private String name;
    private location address;

    school(){
        name = "";
        address = new location();
    }

    school(String name, location address){
        this.name = name;
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public location getLocation() {
        return address;
    }

    public void setLocation(location address) {
        this.address = address;
    }

    @Override
    public String toString(){
        return name + "\n" + address + "\n";
    }
}