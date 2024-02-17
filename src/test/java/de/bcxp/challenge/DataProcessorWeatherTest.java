package de.bcxp.challenge;

import org.junit.jupiter.api.Test;

import de.bcxp.challenge.data.DataProcessorWeather;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DataProcessorWeatherTest {

    @Test
    void testCalculateTemperatureSpread() {
        List<String[]> data = new ArrayList<>();
        data.add(new String[]{"1", "20", "10"});
        data.add(new String[]{"2", "25", "15"});
        data.add(new String[]{"3", "18", "8"});

        int[] spreads = DataProcessorWeather.calculateTemperatureSpread(data);

        assertEquals(10, spreads[0]);
        assertEquals(10, spreads[1]);
        assertEquals(10, spreads[2]);
    }

    @Test
    void testFindDayWithSmallestSpread() {
        int[] spreads = {10, 15, 8};

        int dayWithSmallestSpread = DataProcessorWeather.findDayWithSmallestSpread(spreads);
        
        assertEquals(3, dayWithSmallestSpread);
    }
}
