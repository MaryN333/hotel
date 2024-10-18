package cz.wz.marysidy;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class BookingManager {
    // We haven't studied HashMap in this course yet, we can't use them yet
    private List<Booking> bookings = new ArrayList<>();

    public List<Booking> getBookings() {
        return new ArrayList<>(bookings);
    }

    public Booking getBooking(int index){
        if(index < bookings.size()){
            return bookings.get(index);
        } else{
            System.out.println("Bad index");
            return null;
        }
    }
    public void addBooking(Booking booking){
        bookings.add(booking);
    }

    public void clearBookings(){
        bookings.clear();
        System.out.println("The booking list s empty.");
    }

    public void printInfo(){
        for(Booking booking : bookings){
            System.out.println(booking);
        }
    }

    public void printInfo(List<Booking> list){
        for(Booking booking : list){
            System.out.println(booking);
        }
    }

    // Check if the room is available for the given date range
    public boolean isAvailable(int roomNumber, LocalDate arrivalDate, LocalDate checkOutDate) {
        for (Booking booking : bookings) {
            if(booking.getRoom().getRoomNumber() == roomNumber){
                // Check if the new booking dates overlap with any existing bookings
                if (!(arrivalDate.isAfter(booking.getCheckOutDate()) || checkOutDate.isBefore(booking.getArrivalDate()))) {
                    // If the dates overlap, the room is not available
                    return false;
                }
            }
        }
        // If no overlapping bookings, the room is available
        return true;
    }

    // Booking methods
    public Booking makeBooking(List<Guest> guests, Room room, LocalDate arrivalDate, LocalDate checkOutDate, VacationType vacationType){
        if (isAvailable(room.getRoomNumber(), arrivalDate, checkOutDate)) {
            Booking newBooking = new Booking(room, arrivalDate, checkOutDate, vacationType);
            newBooking.addGuests(guests);
            addBooking(newBooking);
            System.out.println("Successful reservation " + arrivalDate + " - " + checkOutDate);
            return newBooking;
        } else {
            System.out.println("Room is not available for the selected dates.");
            return null;
        }
    }

    public Booking makeBooking(Guest guest, Room room, LocalDate arrivalDate, LocalDate checkOutDate, VacationType vacationType) {
        List<Guest> guestList = new ArrayList<>();
        guestList.add(guest);
        // calling another method makeBooking, which takes list of guest
        return makeBooking(guestList, room, arrivalDate, checkOutDate, vacationType);
    }

    // aby se při vytváření rezervace rezervovalo automaticky na rekreační pobyt od dneška na dalších 6 nocí
    public Booking makeBooking(List<Guest> guests, Room room){
        return makeBooking(guests, room, LocalDate.now(), LocalDate.now().plusDays(6), VacationType.LEASURE);
    }

    public Booking makeBooking(Guest guest, Room room) {
        List<Guest> guestList = new ArrayList<>();
        guestList.add(guest);
        return makeBooking(guestList, room);
    }

    // 5. Počet pracovních pobytů
    public int getNumberOfWorkingBookings() {
        int count = 0;
        for (Booking booking : bookings) {
            if (booking.getVacationType().equals(VacationType.WORK)) {
                count++;
            }
        }
        return count;
    }

    //6. Průměrný počet hostů na rezervaci
    public double getAverageGuests() {
        double sum = 0;
        for (Booking booking : bookings) {
            sum += booking.getGuests().size();
        }
        return sum / bookings.size();
    }

    // First N (qty) reservations with vacation type LEASURE
    public List<Booking> getTopNHolidayBookings(int qty) {
        int count = 0;
        List<Booking> result = new ArrayList<>();
        for (Booking booking : bookings) {
            if (count >= qty) {
                break;
            }
            if (booking.getVacationType().equals(VacationType.LEASURE)) {
                result.add(booking);
                count++;
            }
        }
        return result;
    }

    public void countPeopleInReservations(){
        int counterOneGuest = 0;
        int counterTwoGuests = 0;
        int counterMoreGuests = 0;
        for(Booking booking : bookings){
            switch (booking.getGuests().size()){
                case 1: counterOneGuest++; break;
                case 2: counterTwoGuests++; break;
                default: counterMoreGuests++; break;
            }
        }
        System.out.println("Počet rezervací s jedním hostem: " + counterOneGuest);
        System.out.println("Počet rezervací s dvěma hostem: " + counterTwoGuests);
        System.out.println("Počet rezervací s více hosty: " + counterMoreGuests);
    }
}
