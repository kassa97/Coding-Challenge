package de.bcxp.challenge.data;

import java.util.List;

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

}

