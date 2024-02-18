package de.bcxp.challenge.data;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DataProcessorCountries {

    // Method to find the country with the highest population density
    public static String findCountryWithHighestDensity(Map<String, Double> densityMap) {
        String highestDensityCountry = "";
        double maxDensity = 0.0;

        for (Map.Entry<String, Double> entry : densityMap.entrySet()) {
            String country = entry.getKey();
            double density = entry.getValue();

            if (density > maxDensity) {
                maxDensity = density;
                highestDensityCountry = country;
            }
        }

        return highestDensityCountry;
    }

    // Method to process country data and find the country with the highest population density
    public static Map<String, Double> calculateDensityMap(List<String[]> data) {
        Map<String, Double> densityMap = new HashMap<>();
        for (int i = 0; i < data.size(); i++) {
            try {
                String country = data.get(i)[0];
                double population = Double.parseDouble(data.get(i)[3]);
                double area = Double.parseDouble(data.get(i)[4]);
                double density = population / area;
                densityMap.put(country, density);
            } catch (NumberFormatException | ArrayIndexOutOfBoundsException e) {
                
                throw new RuntimeException("Wrong or missing Data in the countries.csv file for " + data.get(i)[0]
                        + ": " + e.getMessage());
            }
        }
        return densityMap;
    }

}
