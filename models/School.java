package models;

import models.Location;
import models.SchoolLocation;

public class School {
    private final int schoolId;
    private static int currentId;

    private String name;
    private SchoolLocation address;

    School(){
        schoolId = currentId + 1;
        currentId++;

        name = "";
        address = new SchoolLocation();
    }

    public School(String name, SchoolLocation address){
        schoolId = currentId + 1;
        currentId++;

        this.name = name;
        this.address = address;
    }

    public static void setCurrentId(int id){
        currentId = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Location getLocation() {
        return address;
    }

    public void setLocation(SchoolLocation address) {
        this.address = address;
    }

    @Override
    public String toString(){
        return "The name of the school is: " + name + "\n" +
                "The address of the school is:\n " + address + "\n";
    }
}