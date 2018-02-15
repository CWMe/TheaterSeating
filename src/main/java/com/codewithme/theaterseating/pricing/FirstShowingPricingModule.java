package com.codewithme.theaterseating.pricing;

import com.codewithme.theaterseating.venue.Venue;
import org.apache.commons.math3.util.Precision;

public class FirstShowingPricingModule extends BasePricingModule {

    public FirstShowingPricingModule(Venue venue) {
        super(venue);
    }

    @Override
    public SHOW_TYPE getShowType() {
        return SHOW_TYPE.FIRST_SHOWING;
    }
    
    @Override
    public double priceSeat(int row, int seat) {
        return Precision.round((super.priceSeat(row, seat) * 5.0), 2);
    }
    
}
