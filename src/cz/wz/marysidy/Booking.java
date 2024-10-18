package cz.wz.marysidy;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Booking {
    private List<Guest> guests = new ArrayList<>();
    private Room room;
    private LocalDate arrivalDate;
    private LocalDate checkOutDate;
    private VacationType vacationType;

    // Constructor
    private Booking(Room room, LocalDate arrivalDate, LocalDate checkOutDate, VacationType vacationType) {
        this.room = room;
        this.arrivalDate = arrivalDate;
        this.checkOutDate = checkOutDate;
        this.vacationType = vacationType;
    }

    // Constructor from today till 6 days
    private Booking(Room room){
        this(room, LocalDate.now(), LocalDate.now().plusDays(6), VacationType.LEASURE);
    }

    public List<Guest> getGuests() {
        return guests;
    }

    public void addGuest(Guest guest) {
        guests.add(guest);
    }

    public void addGuests(List<Guest> guests){
        this.guests.addAll(guests);
    }

    public void removeGuest(Guest guest){
        guests.remove(guest);
    }

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    public LocalDate getArrivalDate() {
        return arrivalDate;
    }

    public void setArrivalDate(LocalDate arrivalDate) {
        this.arrivalDate = arrivalDate;
    }

    public VacationType getVacationType() {
        return vacationType;
    }

    public void setVacationType(VacationType vacationType) {
        this.vacationType = vacationType;
    }

    public LocalDate getCheckOutDate() {
        return checkOutDate;
    }

    public void setCheckOutDate(LocalDate checkOutDate) {
        this.checkOutDate = checkOutDate;
    }

    @Override
    public String toString() {
        return "Booking{" +
                "guests=" + guests +
                ", arrivalDate=" + arrivalDate +
                ", checkOutDate=" + checkOutDate +
                ", room=" + room +
                ", vacationType='" + vacationType + '\'' +
                '}';
    }

    // Booking methods
    public static Booking makeBooking(List<Guest> guests, Room room, LocalDate arrivalDate, LocalDate checkOutDate, VacationType vacationType){
        if (room.isAvailable(arrivalDate, checkOutDate)) {
            Booking newBooking = new Booking(room, arrivalDate, checkOutDate, vacationType);
            newBooking.addGuests(guests);
            room.addBooking(newBooking); // Adding booking to the room
            System.out.println("Successful reservation " + arrivalDate + " - " + checkOutDate);
            return newBooking;
        } else {
            System.out.println("Room is not available for the selected dates.");
            return null;
        }
    }

    public static Booking makeBooking(Guest guest, Room room, LocalDate arrivalDate, LocalDate checkOutDate, VacationType vacationType) {
        List<Guest> guestList = new ArrayList<>();
        guestList.add(guest);
        // calling another method makeBooking, which takes list of guest
        return makeBooking(guestList, room, arrivalDate, checkOutDate, vacationType);
    }

    // aby se při vytváření rezervace rezervovalo automaticky na rekreační pobyt od dneška na dalších 6 nocí
    public static Booking makeBooking(List<Guest> guests, Room room){
        return makeBooking(guests, room, LocalDate.now(), LocalDate.now().plusDays(6), VacationType.LEASURE);
    }

    public static Booking makeBooking(Guest guest, Room room) {
        List<Guest> guestList = new ArrayList<>();
        guestList.add(guest);
        return makeBooking(guestList, room);
    }

}
