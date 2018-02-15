package com.codewithme.theaterseating.pricing;

import com.codewithme.theaterseating.venue.Venue;
import org.apache.commons.math3.util.Precision;

public abstract class BasePricingModule implements PricingModule {
    
    public enum SHOW_TYPE {
        MATINEE,
        HOLIDAY,
        FIRST_SHOWING,
        NORMAL
    };
 
    private static final double DEFAULT_MAX_PRICE = 10.50;
    private static final double DEFAULT_MIN_PRICE = 8.50;
    
    private final Venue venue;
    private final Double maxPrice;
    private final Double minPrice;
    private final Double priceChange;
    
    /**
     * Constructor for the BasePricingModule which takes a Venue object, maximum price,
     * and minimum price.  The change in price from one seat to the next is calculated 
     * based on the maximum and minimum prices provided.  When using this constructor 
     * from within a concrete class' constructor, it does not make sense to also override
     * the priceSeat method.
     * 
     * @param venue
     * @param maxPrice
     * @param minPrice 
     */
    protected BasePricingModule(Venue venue, double maxPrice, double minPrice) {
        this.maxPrice = maxPrice;
        this.minPrice = minPrice;
        this.venue = venue;
        priceChange = (maxPrice - minPrice) / ((venue.getMaxRowDifference() + venue.getMaxSeatDifference()));
    }
    
    /**
     * Constructor for the BasePricingModule which takes a Venue object.  
     * The change in price from one seat to the next is calculated 
     * based on the DEFAULT maximum and minimum prices set in this class.  When using this constructor 
     * from within a concrete class' constructor, it would make sense to override
     * the priceSeat method, OR simply accept pricing based on the DEFAULT maximum and 
     * minimum.
     * 
     * @param venue
     * @param maxPrice
     * @param minPrice 
     */
    protected BasePricingModule(Venue venue) {
        this.venue = venue;
        maxPrice = DEFAULT_MAX_PRICE;
        minPrice = DEFAULT_MIN_PRICE;
        priceChange = (maxPrice - minPrice) / ((venue.getMaxRowDifference() + venue.getMaxSeatDifference()));
    }
    
    /**
     * The priceSeat method takes a row number and seat number, and calculates
     * the seat price based on 
     * @param row
     * @param seat
     * @return
     * @throws IllegalArgumentException 
     */
    @Override
    public double priceSeat(int row, int seat) throws IllegalArgumentException {
        if (row < 1 || row > venue.getNumRows() || seat < 1 || seat > venue.getNumSeats()) {
            throw new IllegalArgumentException("You can't ask for pricing for a seat that doesn't exist");
        }
        
        int rowDiff = Math.abs(venue.getOptimumRow() - row);
        int seatDiff = (int) Math.ceil(Math.abs(venue.getOptimumSeat() - seat));
        System.out.println("Row Diff: " + rowDiff);
        System.out.println("Seat Diff: " + seatDiff);
        
        return Precision.round(((double) maxPrice - (double) ((rowDiff + seatDiff) * priceChange)), 2);
    }
    
    @Override
    public abstract SHOW_TYPE getShowType();
}
