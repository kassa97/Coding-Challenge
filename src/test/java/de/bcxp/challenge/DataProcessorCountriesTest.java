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
        List<String[]> data = new ArrayList<>();
        data.add(new String[]{"Country1", "Capital1", "Year1", "10000", "500"});
        data.add(new String[]{"Country2", "Capital2", "Year2", "1", "1"});

        Map<String, Double> densityMap = DataProcessorCountries.calculateDensityMap(data);

        assertEquals(20.0, densityMap.get("Country1"));
        assertEquals(1.0, densityMap.get("Country2"));
    }

    @Test
    void testFindCountryWithHighestDensity() {
        Map<String, Double> densityMap = new HashMap<>();
        densityMap.put("Country1", 10.0);
        densityMap.put("Country2", 20.0);
        densityMap.put("Country3", 15.0);

        String highestDensityCountry = DataProcessorCountries.findCountryWithHighestDensity(densityMap);

        assertEquals("Country2", highestDensityCountry);
    }
}
