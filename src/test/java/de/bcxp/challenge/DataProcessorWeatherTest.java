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
        data.add(new String[]{"1", "10", "0"});
        data.add(new String[]{"2", "0", "0"});
        data.add(new String[]{"3", "4", "2"});

        int[] spreads = DataProcessorWeather.calculateTemperatureSpread(data);

        assertEquals(10, spreads[0]);
        assertEquals(0, spreads[1]);
        assertEquals(2, spreads[2]);
    }

    @Test
    void testFindDayWithSmallestSpread() {
        int[] spreads = {10, 0, 2};

        int dayWithSmallestSpread = DataProcessorWeather.findDayWithSmallestSpread(spreads);

        assertEquals(2, dayWithSmallestSpread);
    }
}
