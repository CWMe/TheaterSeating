package com.codewithme.theaterseating.venue;

/**
 * The Venue class provides a common set of properties to its subclasses, which 
 * modify those properties via the constructor.
 * 
 * This class is abstract to prevent instantiation of it.  Developers should use 
 * its subclasses.
 */
public abstract class Venue {
    
    public enum VENUE_TYPE {
        LIVE_THEATER,
        MOVIE_THEATER
    };

    private final int numRows;
    private final int numSeats;
    private final int optimumRow;
    private final int optimumSeat;
    
    protected Venue(int numRows, int numSeats, int optimumRow, int optimumSeat) {
        this.numRows = numRows;
        this.numSeats = numSeats;
        this.optimumRow = optimumRow;
        this.optimumSeat = optimumSeat;
    }

    public int getNumRows() {
        return numRows;
    }

    public int getNumSeats() {
        return numSeats;
    }

    public int getOptimumRow() {
        return optimumRow;
    }

    public int getOptimumSeat() {
        return optimumSeat;
    }
    
    public abstract int getMaxRowDifference();
    public abstract int getMaxSeatDifference();
}
