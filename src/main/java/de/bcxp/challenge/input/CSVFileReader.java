package de.bcxp.challenge.input;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CSVFileReader {

    // Method to read data from the weather.csv file and return it as a list of String arrays
    public static List<String[]> readWeatherData(String filename) throws IOException {

        List<String[]> data = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            reader.readLine();
            while ((line = reader.readLine()) != null) {
                String[] fields = line.split(",");
                data.add(fields);
            }
        } catch (IOException e) {
            throw new RuntimeException("Error Reading the Weather.csv files: " + e.getMessage());
        }

        return data;
    }

    // Method to read data from the countries.csv file and return it as a list of String arrays
    public static List<String[]> readCountryData(String filename) throws IOException {

        List<String[]> data = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            reader.readLine();
            while ((line = reader.readLine()) != null) {
                String[] fields = line.split(";");
                for (int i = 0; i < fields.length; i++) {
                    fields[i] = fields[i].replace(".", "").replace(",", ".");
                }
                data.add(fields);
            }
        } catch (IOException e) {
            throw new RuntimeException("Error Reading the Country.csv file: " + e.getMessage());
        }

        return data;
    }
}
