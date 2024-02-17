package de.bcxp.challenge;

import de.bcxp.challenge.data.DataProcessorCountries;
import de.bcxp.challenge.data.DataProcessorWeather;

/**
 * The entry class for your solution. This class is only aimed as starting point and not intended as baseline for your software
 * design. Read: create your own classes and packages as appropriate.
 */
public final class App {

    /**
     * This is the main entry method of your program.
     * @param args The CLI arguments passed
     */
    public static void main(String[] args) {

        // Your preparation code …

        //Day Analysis function call
        
        // Population De
        

        
        int dayWithSmallestTempSpread = DataProcessorWeather.DayWithSmallestSpread();    // Your day analysis function call …
        System.out.printf("Day with smallest temperature spread: %s%n", dayWithSmallestTempSpread);

        String countryWithHighestPopulationDensity = DataProcessorCountries.CountryWithHighestDensity();; // Your population density analysis function call …
        System.out.printf("Country with highest population density: %s%n", countryWithHighestPopulationDensity);
        
    }
}

