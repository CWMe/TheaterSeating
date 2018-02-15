package com.codewithme.theaterseating;

import com.codewithme.theaterseating.pricing.FirstShowingPricingModule;
import com.codewithme.theaterseating.pricing.HolidayPricingModule;
import com.codewithme.theaterseating.pricing.MatineePricingModule;
import com.codewithme.theaterseating.pricing.NormalPricingModule;
import com.codewithme.theaterseating.pricing.PricingModule;
import com.codewithme.theaterseating.venue.LiveTheater;
import com.codewithme.theaterseating.venue.MovieTheater;
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
                venue = new LiveTheater(numRows, numSeats);
                
            case MOVIE_THEATER:
                venue = new MovieTheater(numRows, numSeats);
                
            default:
                venue = new MovieTheater(numRows, numSeats);
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
            pricingModule = new HolidayPricingModule(venue);
            return this;
        }
        
        // If the show (start) time is before 1pm (13th hour)
        if (showtime.getHour() < 13) {
            pricingModule = new MatineePricingModule(venue);
            return this;
        }
        
        // We don't have a good way to determine first showing, so just "randomly"
        // choose a number 0 > x < 10 and if it's 7, it's a first showing
        if (random.nextInt(10) == 7) {
            pricingModule = new FirstShowingPricingModule(venue);
            return this;
        }
        
        pricingModule = new NormalPricingModule(venue);
        return this;
    }
    
    public PricingModule build() {
        return pricingModule;
    }
}
