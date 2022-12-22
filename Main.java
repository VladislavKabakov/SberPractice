import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;


public class Main {

    public static void main(String[] args) throws FileNotFoundException {
        String path = "C:/Users/v/IdeaProjects/sber/src/city_ru.csv";
        File data = new File(path);

        Scanner scanner = new Scanner(data);
        List<City> citiesInfo = new ArrayList<>();

        while (scanner.hasNextLine()) {
            String[] currentData = scanner.nextLine().split(",");
            citiesInfo.add(new City(
                    currentData[1],
                    currentData[2],
                    currentData[3],
                    Integer.parseInt(currentData[4]),
                    currentData[5])
            );
        }
        scanner.close();

        //First Task: displaying cities info

        for (City city : citiesInfo) {
            System.out.println(city);
        }

        //Second Task (1): sorting by name (using lambda)

        List<City> sortedByName = citiesInfo.stream().sorted((x, y) -> x.getName().compareTo(y.getName())).toList();
        for (City city : sortedByName) {
            System.out.println(city);
        }

        //Second Task (2): sorting by district, then by name (using comparator)

        List<City> sortedByDistrictName = citiesInfo.stream().sorted().toList();
        for (City city : sortedByDistrictName) {
            System.out.println(city);
        }

        //Third Task: finding a city with most inhabitants

        int cityIndex = 0, maxPopulation = 0;
        for (int i = 0; i < citiesInfo.size(); ++i) {
            if (citiesInfo.get(i).getPopulation() > maxPopulation){
                maxPopulation = citiesInfo.get(i).getPopulation();
                cityIndex = i;
            }
        }
        System.out.println("[" + cityIndex + "]" + " = " + maxPopulation);


        //Fourth Task: determining the number of cities by regions
        
        Map<String, Long> grouped = citiesInfo.stream().collect(Collectors.groupingBy(city -> city.getRegion(), Collectors.counting()));
        for (String key : grouped.keySet()) {
            System.out.println(key + " - " + grouped.get(key));
        }
    }
}
