package com.codewithme.theaterseating;

import com.codewithme.theaterseating.pricing.PricingModule;
import com.codewithme.theaterseating.venue.Venue;
import java.time.LocalDateTime;
import java.time.Month;

public class Theater {

    public static void main(String[] args) {
        PricingModuleBuilder builder = PricingModuleBuilder
                .getInstance(Venue.VENUE_TYPE.MOVIE_THEATER, 25, 9);
        PricingModule pricingModule;
        
        pricingModule = builder
            .withPricingModule(LocalDateTime.of(2018, Month.DECEMBER, 25, 9, 10))
            .build();
        
        System.out.println("Pricing based on: " + pricingModule.getShowType());
        System.out.println("Price for row 10, seat 4 = " + pricingModule.priceSeat(10, 4));
        
        pricingModule = builder
            .withPricingModule(LocalDateTime.of(2018, Month.MARCH, 23, 9, 10))
            .build();
        
        System.out.println("Pricing based on: " + pricingModule.getShowType());
        System.out.println("Price for row 10, seat 4 = " + pricingModule.priceSeat(18, 2));

        System.exit(0);
    }

}
