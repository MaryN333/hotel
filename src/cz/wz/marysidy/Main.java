package cz.wz.marysidy;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    private static <T> void printInfo(List <T> list){
        for(T item : list){
            if(item != null){
                System.out.println(item);
            }
        }
    }

    public static void main(String[] args) {
        Guest g1 = new Guest("Adela", "Malikova", LocalDate.of(1993, 3, 13));
        Guest g2 = new Guest("Jan", "Dvoracek", LocalDate.of(1995, 5, 5));
        System.out.println(g2);
        g2.setBirth(LocalDate.of(1995, 4, 5));
        System.out.println(g2);

        System.out.println("*-".repeat(15));
        List <Guest> guests = new ArrayList<>();
        guests.add(g1);
        guests.add(g2);
        printInfo(guests);

        System.out.println("*-".repeat(15));
        Room r1 = new Room(1, 1, true, true, new BigDecimal("100.20"));
        Room r2 = new Room(2, 1, true, true, new BigDecimal("100.50"));
        Room r3 = new Room(3, 3, false, true, new BigDecimal("100.90"));

        List<Room> rooms = new ArrayList<>();
        rooms.add(r1);
        rooms.add(r2);
        rooms.add(r3);
        printInfo(rooms);

        System.out.println("*-".repeat(15));
        Booking b1 = Booking.makeBooking(g1, r1, LocalDate.of(2021, 7, 19), LocalDate.of(2021, 7, 26), VacationType.WORK);
        b1.addGuest(g2);
//        List<Guest> guestList = Arrays.asList(g1, g2);
        Booking b2 = Booking.makeBooking(Arrays.asList(g1,g2), r1, LocalDate.of(2021, 9, 1), LocalDate.of(2021, 9, 14), VacationType.WORK);
//        // b3 - Room is not available for the selected dates.
        Booking b3 = Booking.makeBooking(g2, r1, LocalDate.of(2021, 7, 25), LocalDate.of(2021, 7, 26), VacationType.WORK);
        Booking b4 = Booking.makeBooking(g1, r3, LocalDate.of(2024, 11, 24), LocalDate.of(2024, 11, 30), VacationType.LEASURE);
        Booking b5 = Booking.makeBooking(Arrays.asList(g1, g2), r2);

        System.out.println("-*".repeat(20));
        List<Booking> bookings = new ArrayList<>();
        bookings.add(b1);
        bookings.add(b2);
        bookings.add(b3);
        bookings.add(b4);
        bookings.add(b5);
        System.out.println(bookings);



//        BookingManager bookings = new BookingManager();
//        bookings.addBooking(b1);
//        bookings.addBooking(b2);
//        bookings.addBooking(b3);
//        bookings.addBooking(b4);
//        bookings.addBooking(b5);
//
//        bookings.printInfo();
//
//
//        System.out.println("*-".repeat(15));
//        Booking some = bookings.getBooking(0);
//        System.out.println(some);






    }
}
