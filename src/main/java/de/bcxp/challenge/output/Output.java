package de.bcxp.challenge.output;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import de.bcxp.challenge.data.*;
import de.bcxp.challenge.input.CSVFileReader;


public class Output {
    
    // Method to output the day with the smallest spread
    public static int DayWithSmallestSpread(String filename) {
        
        List<String[]> data = null;
        try {
            data = CSVFileReader.readWeatherData(filename);
        } catch (IOException e) {
            System.err.println("Error reading the CSV file: " + e.getMessage());
            return -1; 
        }

        if (data != null && !data.isEmpty()) {
            int[] spreads = DataProcessorWeather.calculateTemperatureSpread(data);
            int dayWithMinSpread = DataProcessorWeather.findDayWithSmallestSpread(spreads);

            return dayWithMinSpread;
        } else {
            System.out.println("No data found in the CSV file."); 
            return -1;
        }
    }

    // Method to output the country with the highest density
    public static String CountryWithHighestDensity(String filename) {
        List<String[]> data = null;
        try {
            
            data = CSVFileReader.readCountryData(filename);

        } catch (IOException e) {
            System.err.println("Error reading the CSV file: " + e.getMessage());
            return ""; 
        }
        

        
        if (data != null && !data.isEmpty()) {
            Map<String, Double> densityMap = DataProcessorCountries.calculateDensityMap(data);

          
            String highestDensityCountry = DataProcessorCountries.findCountryWithHighestDensity(densityMap);
            return highestDensityCountry;
        } else {
            System.out.println("No data found in the CSV file."); 
            return "";
        }
    }



}
