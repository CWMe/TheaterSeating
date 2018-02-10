package com.codewithme.theaterseating;

import java.util.Scanner;

/**
 * Author: Shijit Dasgupta The theater is modeled as a 4 by 4 grid with the
 * seats being "Scored" from front row to back. The pricing model is the
 * opposite of a concert where the closer you are the cheaper you're seat is.
 * This is accurate since the middle and end seats are typically preferred in a
 * movie theater. Users of this program can pick a row and and number of seats
 * per row. Then they are given the option to reserve and purchase them.
 */
public class BoxOffice implements TicketService {

    static int[][] Theater_seats = {
        {10, 10, 10, 10},
        {20, 20, 20, 20},
        {30, 30, 30, 30},
        {40, 40, 40, 40}
    };

    public int numSeatsAvailable() {
        //-----------Printing the Theater Seats 2D Array----------\\
        int freeSeats = 0;
        System.out.println("--Theater--");
        for (int i = 0; i < Theater_seats.length; i++) {
            for (int j = 0; j < Theater_seats[0].length; j++) {
                System.out.print(Theater_seats[i][j] + " ");
                freeSeats++;
            }
            System.out.println("");
        }// End of printing seats.

        System.out.println("");
        System.out.println("There are " + freeSeats + " seats available in the theater.");
        return 0;
    }

    /**
     * A seat has a cost ($10-40) assigned to it. This is based on the
     * attractiveness of the seat in the movie theater. A RESERVED seat gets a
     * cost of -1 dollars implying it is unavailable for purchase. A
     * CONFIRMED/PURCHASED seat gets a cost of 0 dollars implying it is
     * gone/sold out.
     */
    public SeatHold findAndHoldSeats(int numSeats, String customerEmail) {

        // The "Ticket_Conductor" Scanner Class Instance mirrors the front desk staff in this program that takes the order from the customer.
        Scanner ticket_Conductor = new Scanner(System.in);

        //------------------------------Seat Discovery-------------------------------\\
        System.out.println("Enter the ticket price you want (10, 20, 30, 40): ");
        int ticketVal = ticket_Conductor.nextInt();

        //Print Seats Applicable to Ticket Price.
        for (int i = 0; i < Theater_seats.length; i++) {
            for (int j = 0; j < Theater_seats[i].length; j++) {

                if (Theater_seats[i][j] == ticketVal) {
                    System.out.println("Next available seat at position: [" + i + "][" + j + "]");
                }
            }
        }

        int count = 0; // Initialize the count variable for seat check.

        //------------------------------Seat Reservation ----------------------------\\
        System.out.println("Do you wish to reserve these " + numSeats + " seats. (True/False)?");
        boolean isReserved = ticket_Conductor.nextBoolean();
        System.out.println("Congratulations! You have reserved " + numSeats + " seats!");

        for (int i = 0; i < Theater_seats.length; i++) {
            for (int j = 0; j < Theater_seats[i].length; j++) {
                if (Theater_seats[i][j] == ticketVal && count < numSeats) {
                    if (isReserved) {// If user says true, the seat value will change to -1.
                        Theater_seats[i][j] = -1;
                        count++;
                    }//End of If Loop
                }
            }
        }// Ends Reserving Loop

        //-----------Printing the Theater Seats 2D Array----------\\
        System.out.println("--Theater--");
        for (int i = 0; i < Theater_seats.length; i++) {
            for (int j = 0; j < Theater_seats[0].length; j++) {
                System.out.print(Theater_seats[i][j] + " ");
            }
            System.out.println("");
        }// End of printing seats.
        return null;
    }

    public String reserveSeats(int numSeats, String customerEmail) {

        //------------------------------Seat Confirmation---------------------------\\
        System.out.println("Do you wish to confirm and buy these " + numSeats + " seats. (True/False)?");
        Scanner ticket_Conductor = new Scanner(System.in);
        boolean isBought = ticket_Conductor.nextBoolean();
        System.out.println("Congratulations! You have bought " + numSeats + " seats! Enjoy the Movie!");

        for (int i = 0; i < Theater_seats.length; i++) {
            for (int j = 0; j < Theater_seats[i].length; j++) {
                if (Theater_seats[i][j] == -1) {
                    if (isBought) {// If user says true, the seat value will change to 0.
                        Theater_seats[i][j] = 0;
                    }
                }
            }
        }// Ends Purchasing Loop

        ticket_Conductor.close();

        //-----------Printing the Theater Seats 2D Array----------\\
        System.out.println("--Theater--");
        for (int i = 0; i < Theater_seats.length; i++) {
            for (int j = 0; j < Theater_seats[0].length; j++) {
                System.out.print(Theater_seats[i][j] + " ");
            }
            System.out.println("");
        }// End of printing seats.
        return null;
    }
}

/**
 * If I had more time, I would implement:
 *
 * A database to store Ticket purchasing info. A web service to email and
 * confirm with the customer. A http request API to email confirmations and
 * store user confirmations. A UI Framework in JavaScript or Java FX to make the
 * ticket purchasing easier. Seating Rows can be labeled, but the price kept the
 * same. Lastly I would include a timer on the reservations.
 *
 * I did enjoy this exercise a fair bit and look forward to working on more!
 * Author: Shijit Dasgupta
 */
