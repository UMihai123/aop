public class SchoolLocation extends Location {

    private String seismicRisk;
    private double area;

    SchoolLocation(){
        seismicRisk = "";
        area = 0.0;
    }

    SchoolLocation(String seismicRisk, double area){
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
        return getCity() + "\n" + getStreet() + " " + getNumber() + "\n" + seismicRisk + "\n" + area;
    }
}