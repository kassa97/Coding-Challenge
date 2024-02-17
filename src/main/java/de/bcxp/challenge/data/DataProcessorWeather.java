package de.bcxp.challenge.data;

import java.io.IOException;
import java.util.List;

import de.bcxp.challenge.input.CSVFileReader;

public class DataProcessorWeather {
    // Method to calculate the temperature spread for each day
    public static int[] calculateTemperatureSpread(List<String[]> data) {
        int[] spreads = new int[data.size()]; 

        for (int i = 0; i < data.size(); i++) {
            try {
                int maxTemp = Integer.parseInt(data.get(i)[1]); 
                int minTemp = Integer.parseInt(data.get(i)[2]); 
                spreads[i] = maxTemp - minTemp; 
            } catch (NumberFormatException | ArrayIndexOutOfBoundsException e) {
                throw new RuntimeException("Wrong or missing Data in the weather.csv file at day " + i+1 + ": " + e.getMessage());
            }
        }

        return spreads;
    }

    // Method to determine the day with the smallest temperature spread
    public static int findDayWithSmallestSpread(int[] spreads) {
        int minSpread = Integer.MAX_VALUE; 
        int dayWithMinSpread = -1;

        for (int i = 0; i < spreads.length; i++) {
            if (spreads[i] < minSpread) {
                minSpread = spreads[i];
                dayWithMinSpread = i + 1; 
            }
        }

        return dayWithMinSpread;
    }

    // Method to read file and return the day with the smallest spread
    public static int DayWithSmallestSpread() {
    String filename = "src\\main\\resources\\de\\bcxp\\challenge\\weather.csv";
        

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
}

