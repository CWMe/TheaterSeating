package com.codewithme.theaterseating.pricing;

import com.codewithme.theaterseating.venue.MovieTheater;
import org.junit.Test;
import static org.junit.Assert.*;

public class FirstShowingPricingModuleTest {

    /**
     * Test of getShowType method, of class FirstShowingPricingModule.
     */
    @Test
    public void testGetShowType() {
        System.out.println("getShowType");
        MovieTheater venue = new MovieTheater(25, 11);
        FirstShowingPricingModule instance = new FirstShowingPricingModule(venue);
        BasePricingModule.SHOW_TYPE expResult = BasePricingModule.SHOW_TYPE.FIRST_SHOWING;
        BasePricingModule.SHOW_TYPE result = instance.getShowType();
        assertEquals(expResult, result);
    }

    /**
     * Test of priceSeat method, of class FirstShowingPricingModule.
     */
    @Test
    public void testPriceSeat() {
        System.out.println("priceSeat");
        int row = 25;
        int seat = 9;
        MovieTheater venue = new MovieTheater(row, seat);
        HolidayPricingModule instance = new HolidayPricingModule(venue);
        double expResult = 17.17;
        double result = instance.priceSeat(10, 4);
        assertEquals(expResult, result, 0.0);
    }
    
}
