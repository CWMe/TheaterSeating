package com.codewithme.theaterseating;

import com.codewithme.theaterseating.pricing.PricingModule;
import com.codewithme.theaterseating.venue.Venue;
import de.jollyday.HolidayManager;
import java.time.LocalDateTime;
import java.util.Random;

public class PricingModuleBuilder {
    
    private Venue venue;
    private PricingModule pricingModule;
    private HolidayManager holidayManager;
    private Random random;

    private PricingModuleBuilder(Venue.VENUE_TYPE type, int numRows, int numSeats) {
        holidayManager = HolidayManager.getInstance();
        random = new Random();
        
        switch (type) {
            case LIVE_THEATER:
                // Instantiate and set the Live Theater class
                
            case MOVIE_THEATER:
                // Instantiate and set the Movie Theater class
                
            default:
                // Instantiate and set the Movie Theater class
        }
    }
    
    /**
     * 
     * @param type
     * @param numRows
     * @param numSeats
     * @return
     * @throws IllegalArgumentException 
     */
    public static PricingModuleBuilder getInstance(Venue.VENUE_TYPE type, int numRows, int numSeats) throws IllegalArgumentException {
        if (numRows % 2 == 0 || numSeats % 2 == 0) {
            throw new IllegalArgumentException("The number of seats and number of rows for the theater must be an odd number");
        }
        return new PricingModuleBuilder(type, numRows, numSeats);
    }
    
    public PricingModuleBuilder withPricingModule(LocalDateTime showtime) {
            
        // Uses the Jollyday library to check to see if the showdate is a holiday
        if (holidayManager.isHoliday(showtime.toLocalDate())) {
            // Instantiate and set the Holiday Pricing Module
            return this;
        }
        
        // If the show (start) time is before 1pm (13th hour)
        if (showtime.getHour() < 13) {
            // Instantiate and set the Matinee Pricing Module
            return this;
        }
        
        // We don't have a good way to determine first showing, so just "randomly"
        // choose a number 0 > x < 10 and if it's 7, it's a first showing
        if (random.nextInt(10) == 7) {
            // Instantiate and set the First Showing Pricing Module
            return this;
        }
        
        // Instantiate and set the Normal Pricing Module
        return this;
    }
    
    public PricingModule build() {
        return pricingModule;
    }
}
