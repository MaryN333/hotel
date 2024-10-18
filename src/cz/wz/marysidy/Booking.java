package cz.wz.marysidy;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class Booking {
    private List<Guest> guests = new ArrayList<>();
    private Room room;
    private LocalDate arrivalDate;
    private LocalDate checkOutDate;
    private VacationType vacationType;

    // Constructor
    public Booking(Room room, LocalDate arrivalDate, LocalDate checkOutDate, VacationType vacationType) {
        this.room = room;
        this.arrivalDate = arrivalDate;
        this.checkOutDate = checkOutDate;
        this.vacationType = vacationType;
    }

    // Constructor from today till 6 days
    public Booking(Room room){
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

    public int getBookingLength() {
        return arrivalDate.until(checkOutDate).getDays();
    }

    // 10. Cena rezervace
    public BigDecimal getTotalPrice() {
        return room.getPriceKcPerNight().multiply(BigDecimal.valueOf(getBookingLength()));
    }

    public String getFormattedSummary() {
        return  getArrivalDate() +" až "+ getCheckOutDate()+": " + getGuests().get(0).getName() +" " + getGuests().get(0).getSurname() +
                " ("+ getGuests().get(0).getBirth().format(DateTimeFormatter.ofPattern("dd.MM.yyyy"))+")["+
                getGuests().size() + ", " + (getRoom().isSeaView()?"ano":"ne")+"] za " + getTotalPrice() + " EUR";
    }

    @Override
    public String toString() {
        Guest guest = guests.get(0);
        return "Rezervace pro: " + guest.getName() + " " + guest.getSurname() + " (" + guest.getBirth() + ") na: "
                + getBookingLength() + (getBookingLength() == 1? " noc" : getBookingLength() > 4? " nocí":" noce") +
                ", termín: " + getArrivalDate() + " - " + getCheckOutDate() +
                " pracovní pobyt: " + (vacationType.equals(VacationType.WORK)? "ano":"ne");
    }

}
