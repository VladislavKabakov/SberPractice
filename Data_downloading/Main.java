package sber;

import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;


public class Main {

	public static void main(String[] args) throws FileNotFoundException {
		String path = "C:/Users/v/eclipse-workspace/sber/src/sber/city_ru.csv";
		File data = new File(path);
		
		Scanner scanner = new Scanner(data);
		ArrayList<City> citiesInfo = new ArrayList<>();
		
		while (scanner.hasNextLine()) {
			String[] currentData = scanner.nextLine().split(",");
			int size = currentData.length;
			citiesInfo.add(new City(
					currentData[1], 
					currentData[2],
					currentData[3],
					Integer.parseInt(currentData[4]),
					currentData[5])
					);
		}
		for (City city: citiesInfo) {
			System.out.println(city);
		}
		scanner.close();
	}
}

class City {
	String name, region, district, foundation;
	int population;

	
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
}