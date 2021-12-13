package city;

import java.util.ArrayList;
import java.util.List;

public class City {

    private String name;
    private long fullArea;
    private List<Building> buildings = new ArrayList<>();

    public City(String name, long fullArea) {
        this.name = name;
        this.fullArea = fullArea;
    }

    public String getName() {
        return name;
    }

    public long getFullArea() {
        return fullArea;
    }

    public List<Building> getBuildings() {
        return buildings;
    }

    public void addBuilding(Building building) {
        if (getSumAreaOfBuildings(buildings) + building.getArea() > fullArea) {
            throw new IllegalArgumentException("City can't be larger than " + fullArea);
        } else {
            buildings.add(building);
        }
    }

    private long getSumAreaOfBuildings(List<Building> buildings) {
        long result = 0;

        for (Building actual : buildings) {
            result += actual.getArea();
        }
        return result;
    }

    public Building findHighestBuilding() {
        Building result = null;
        int maxlevel = 0;

        for (Building actual : buildings) {
            if (actual.getLevels() > maxlevel) {
                maxlevel = actual.getLevels();
                result = actual;
            }
        }
        return result;
    }

    public List<Building> findBuildingsByStreet(String street) {
        List<Building> result = new ArrayList<>();

        for (Building actual : buildings) {
            if (actual.getAddress().getStreet().equals(street)) {
                result.add(actual);
            }
        }
        return result;
    }

    public boolean isThereBuildingWithMorePeopleThan(int numberOfPeople) {
        List<Office> offices = new ArrayList<>();

        for (Building actual : buildings) {
            if (actual.calculateNumberOfPeopleCanFit() > numberOfPeople) {
                return true;
            }
        }
        return false;
    }
}
