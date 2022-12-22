
public class City implements Comparable<City> {
    private String name, region, district, foundation;
    private int population;


    City(String name, String region, String district, int population, String foundation) {
        this.setName(name);
        this.setRegion(region);
        this.setDistrict(district);
        this.setPopulation(population);
        this.setFoundation(foundation);
    }

    @Override
    public String toString() {
        return "City{name='" + this.name + "',region='" + this.region +
                "',district='" + this.district + "',population=" + this.population +
                ",foundation='" + this.foundation + "'}";
    }

    String getName() {
        return name;
    }

    String getRegion() {
        return region;
    }

    String getDistrict() {
        return district;
    }

    int getPopulation() {
        return population;
    }

    String getFoundation() {
        return foundation;
    }

    void setName(String name) {
        this.name = name;
    }

    void setRegion(String region) {
        this.region = region;
    }

    void setDistrict(String district) {
        this.district = district;
    }

    void setPopulation(int population) {
        this.population = population;
    }

    void setFoundation(String foundation) {
        this.foundation = foundation;
    }

    @Override
    public int compareTo(City c) {
        int res = this.district.compareTo(c.getDistrict());
        if (res == 0) {
            res = this.name.compareTo(c.getName());
        }
        return res;
    }
}
