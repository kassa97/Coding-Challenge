package de.bcxp.challenge;

import de.bcxp.challenge.output.Output;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class OutputTest {

    @Test
    void testDayWithSmallestSpread() {

        String filename = "src\\main\\resources\\de\\bcxp\\challenge\\test_weather.csv";

        assertEquals(2, Output.DayWithSmallestSpread(filename));
    }

    @Test
    void testCountryWithHighestDensity() {

        String filename = "src\\main\\resources\\de\\bcxp\\challenge\\test_countries.csv";

        assertEquals("Belgium", Output.CountryWithHighestDensity(filename));
    }

    @Test
    void testEmptyFile() {

        String filename = "src\\main\\resources\\de\\bcxp\\challenge\\empty.csv";

        assertEquals(-1, Output.DayWithSmallestSpread(filename));
        assertEquals("", Output.CountryWithHighestDensity(filename));
    }

}
