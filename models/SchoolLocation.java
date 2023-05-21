package models;

public class SchoolLocation extends Location {

    private String seismicRisk;
    private double area;

    SchoolLocation(){
        seismicRisk = "";
        area = 0.0;
    }

    public SchoolLocation(Location location, String seismicRisk, double area){
        super(location.getStreet(), location.getCity(), location.getNumber());
        this.seismicRisk = seismicRisk;
        this.area = area;
    }

    public String getSeismicRisk() {
        return seismicRisk;
    }

    public void setSeismicRisk(String seismicRisk) {
        this.seismicRisk = seismicRisk;
    }

    public double getArea() {
        return area;
    }

    public void setArea(double area) {
        this.area = area;
    }

    @Override
    public String toString(){
        return "The School is situated in " + getCity() + " on street " + getStreet() + " number " + getNumber() +
                " with the seismic Risk of " + seismicRisk + " and an area of " + area;
    }
}
