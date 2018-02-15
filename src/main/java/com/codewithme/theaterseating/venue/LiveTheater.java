package com.codewithme.theaterseating.venue;

public class LiveTheater extends Venue {
    
    private static final int OPTIMUM_ROW = 1;
    
    public LiveTheater(int numRows, int numSeats) {
        super(numRows, numSeats, OPTIMUM_ROW, numSeats / 2 + 1);
    }

    @Override
    public int getMaxRowDifference() {
        return getNumRows() - 1;
    }

    @Override
    public int getMaxSeatDifference() {
        return Math.round(getNumSeats() / 2);
    }
    
}
