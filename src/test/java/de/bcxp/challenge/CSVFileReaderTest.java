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
        String filename = "src\\main\\resources\\de\\bcxp\\challenge\\test_weather.csv";

        assertDoesNotThrow(() -> {
            List<String[]> data = CSVFileReader.readWeatherData(filename);
            assertEquals(3, data.size());
        });
    }

    @Test
    void testReadCountryData() {
        String filename = "src\\main\\resources\\de\\bcxp\\challenge\\test_countries.csv";

        assertDoesNotThrow(() -> {
            List<String[]> data = CSVFileReader.readCountryData(filename);
            assertEquals(3, data.size());
        });
    }

    @Test
    void testReadInvalidFile() {
        String filename = "non_existent_file.csv";

        assertThrows(RuntimeException.class, () -> {
            CSVFileReader.readCountryData(filename);
        });
    }
}
