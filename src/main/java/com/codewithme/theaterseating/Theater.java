package com.codewithme.theaterseating;

import com.codewithme.theaterseating.pricing.MatineePricingModule;
import com.codewithme.theaterseating.pricing.PricingModule;
import com.codewithme.theaterseating.venue.Venue;
import java.util.Scanner;   

public class Theater {

    public static void main(String[] args) {
        PricingModule pricing = new MatineePricingModule(11, 7);
        double priceSeat = pricing.priceSeat(2, 7);
        System.out.println(priceSeat);
        BoxOffice Multiplex = new BoxOffice();
        Multiplex.numSeatsAvailable();
        Boolean isInterested = false;

//        Scanner sanityCheck = new Scanner(System.in);
//
//        int seatRequest = sanityCheck.nextInt();
//        while (isInterested) {
//            System.out.println("hello");
//            Multiplex.findAndHoldSeats(3, "shijit.dasgupta@gmail.com");
//            Multiplex.reserveSeats(3, "shijit.dasgupta@gmail.com");
//        }
        System.out.println("About to exit");
        System.exit(0);
    }

}
