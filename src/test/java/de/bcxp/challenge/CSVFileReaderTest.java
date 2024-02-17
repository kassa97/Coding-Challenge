package de.bcxp.challenge;

import org.junit.jupiter.api.Test;

import de.bcxp.challenge.input.CSVFileReader;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class CSVFileReaderTest {

    @Test
    void testReadWeatherData() {
        // Provide the path to a test weather.csv file
        String filename = "src\\main\\resources\\de\\bcxp\\challenge\\test_weather.csv";

        // Test reading weather data
        assertDoesNotThrow(() -> {
            List<String[]> data = CSVFileReader.readWeatherData(filename);
            // Assert that the data contains the expected number of lines
            assertEquals(3, data.size());
        });
    }

    @Test
    void testReadCountryData() {
        // Provide the path to a test countries.csv file
        String filename = "src\\main\\resources\\de\\bcxp\\challenge\\test_countries.csv";

        // Test reading country data
        assertDoesNotThrow(() -> {
            List<String[]> data = CSVFileReader.readCountryData(filename);
            // Assert that the data contains the expected number of lines
            assertEquals(3, data.size());
        });
    }

    @Test
    void testReadInvalidFile() {
        // Provide the path to an invalid CSV file
        String filename = "non_existent_file.csv";

        // Test reading an invalid file
        assertThrows(RuntimeException.class, () -> {
            CSVFileReader.readCountryData(filename);
        });
    }
}
