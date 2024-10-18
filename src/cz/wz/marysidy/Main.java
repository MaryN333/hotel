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

    // Method for creation of several reservations
    public static void createShortStays(int qty, BookingManager bookings, Guest karolina, Room room) {
        for (int i = 0; i < qty; i++) {
            LocalDate startDate = LocalDate.of(2023, 8, 1).plusDays(i * 2);
            LocalDate endDate = startDate.plusDays(1);
            List<Guest> guests = new ArrayList<>();
            guests.add(karolina);
            bookings.makeBooking(guests, room, startDate, endDate, VacationType.LEASURE);
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
        BookingManager bookings = new BookingManager();
        Booking b1 = bookings.makeBooking(g1, r1, LocalDate.of(2021, 7, 19), LocalDate.of(2021, 7, 26), VacationType.WORK);
        b1.addGuest(g2);
//        List<Guest> guestList = Arrays.asList(g1, g2);
        Booking b2 = bookings.makeBooking(Arrays.asList(g1,g2), r1, LocalDate.of(2021, 9, 1), LocalDate.of(2021, 9, 14), VacationType.WORK);
//        // b3 - Room is not available for the selected dates.
        Booking b3 = bookings.makeBooking(g2, r1, LocalDate.of(2021, 7, 25), LocalDate.of(2021, 7, 26), VacationType.WORK);
        Booking b4 = bookings.makeBooking(g1, r3, LocalDate.of(2024, 11, 24), LocalDate.of(2024, 11, 30), VacationType.LEASURE);
        Booking b5 = bookings.makeBooking(Arrays.asList(g1, g2), r2);


        bookings.printInfo();
        System.out.println("-*".repeat(20));
        Booking some = bookings.getBooking(1);
        System.out.println(some);
        System.out.println("-*".repeat(20));

        printInfo(bookings.getBookings());
        System.out.println("-*".repeat(20));


        // Second part
        bookings.clearBookings();

        Guest karolina = new Guest("Karolína", "Tmavá", LocalDate.of(2000,1,3));
        Guest karel = new Guest("Karel", "Dvořák", LocalDate.of(1990,5,15));

        bookings.makeBooking(karel, r3, LocalDate.of(2023, 6, 1), LocalDate.of(2023,6, 7), VacationType.WORK);
        bookings.makeBooking(new Guest("Karel", "Dvořák", LocalDate.of(1979,1,3)), r2, LocalDate.of(2023, 7, 18), LocalDate.of(2023,7, 21), VacationType.LEASURE);
        bookings.makeBooking(Arrays.asList(karolina, karel), r3, LocalDate.of(2023, 8, 1), LocalDate.of(2023,8, 31), VacationType.WORK);
        createShortStays(10, bookings, karolina, r2);
        bookings.printInfo();

        System.out.println("Celkový počet rezervací je " + bookings.getBookings().size());      // 13

        System.out.println("Průměrný počet hostů na rezervaci: " + bookings.getAverageGuests()); // 1.0769230769230769

        List<Booking> list = bookings.getTopNHolidayBookings(8);
        bookings.printInfo(list);

        System.out.println("Statistiky hostů:");
        bookings.countPeopleInReservations();

        System.out.println("Počet pracovních pobytů: " + bookings.getNumberOfWorkingBookings());      // 2


        for(Booking booking : bookings.getBookings()){
            System.out.println(booking.getFormattedSummary());
        }
//        System.out.println(b1.getVacationType());         // pracovní
    }
}
