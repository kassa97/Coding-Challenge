package de.bcxp.challenge;

import org.junit.jupiter.api.Test;

import de.bcxp.challenge.data.DataProcessorCountries;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DataProcessorCountriesTest {

    @Test
    void testCalculateDensityMap() {
        // Create sample data
        List<String[]> data = new ArrayList<>();
        data.add(new String[]{"Country1", "Capital1", "Year1", "10000", "500"});
        data.add(new String[]{"Country2", "Capital2", "Year2", "20000", "1000"});

        // Calculate density map
        Map<String, Double> densityMap = DataProcessorCountries.calculateDensityMap(data);

        // Verify results
        assertEquals(20.0, densityMap.get("Country1"));
        assertEquals(20.0, densityMap.get("Country2"));
    }

    @Test
    void testFindCountryWithHighestDensity() {
        // Create sample density map
        Map<String, Double> densityMap = new HashMap<>();
        densityMap.put("Country1", 10.0);
        densityMap.put("Country2", 20.0);
        densityMap.put("Country3", 15.0);

        // Find country with highest density
        String highestDensityCountry = DataProcessorCountries.findCountryWithHighestDensity(densityMap);

        // Verify result
        assertEquals("Country2", highestDensityCountry);
    }
}
