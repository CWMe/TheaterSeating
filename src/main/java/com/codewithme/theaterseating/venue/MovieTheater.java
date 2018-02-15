package com.codewithme.theaterseating.venue;

public class MovieTheater extends Venue {
    
    public MovieTheater(int numRows, int numSeats) {
        //The MovieTheater considers it's optimum seat to be the exact middle of the theater
        super(numRows, numSeats, (int) Math.round((double) numRows / 2), (int) Math.round((double) numSeats / 2));
    }

    @Override
    public int getMaxRowDifference() {
        return (int) Math.round((double) getNumRows() / 2);
    }

    @Override
    public int getMaxSeatDifference() {
        return (int) Math.round((double) getNumSeats() / 2);
    }
}
