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