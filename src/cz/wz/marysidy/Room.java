package cz.wz.marysidy;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Room {
    private int roomNumber;
    private int bedsNumber;
    private boolean isBalcony;
    private boolean isSeaView;
    private BigDecimal priceKcPerNight;
    private List<Booking> bookings = new ArrayList<>();


    public Room(int roomNumber, int bedsNumber, boolean isBalcony, boolean isSeaView, BigDecimal price) {
        this.roomNumber = roomNumber;
        this.bedsNumber = bedsNumber;
        this.isBalcony = isBalcony;
        this.isSeaView = isSeaView;
        this.priceKcPerNight = price;
    }

    public int getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(int roomNumber) {
        this.roomNumber = roomNumber;
    }

    public int getBedsNumber() {
        return bedsNumber;
    }

    public void setBedsNumber(int bedsNumber) {
        this.bedsNumber = bedsNumber;
    }

    public boolean isBalcony() {
        return isBalcony;
    }

    public void setBalcony(boolean balcony) {
        isBalcony = balcony;
    }

    public boolean isSeaView() {
        return isSeaView;
    }

    public void setSeaView(boolean seaView) {
        isSeaView = seaView;
    }

    public BigDecimal getPriceKcPerNight() {
        return priceKcPerNight;
    }

    public void setPriceKcPerNight(BigDecimal priceKcPerNight) {
        this.priceKcPerNight = priceKcPerNight;
    }

    public List<Booking> getBookings() {
        return bookings;
    }

    public void addBooking(Booking booking) {
        bookings.add(booking);
    }

    // Check if the room is available for the given date range
    public boolean isAvailable(LocalDate arrivalDate, LocalDate checkOutDate) {
        for (Booking booking : bookings) {
            // Check if the new booking dates overlap with any existing bookings
            if (!(arrivalDate.isAfter(booking.getCheckOutDate()) || checkOutDate.isBefore(booking.getArrivalDate()))) {
                // If the dates overlap, the room is not available
                return false;
            }
        }
        // If no overlapping bookings, the room is available
        return true;
    }

    @Override
    public String toString() {
        return "Room{" +
                "roomNumber=" + roomNumber +
                ", bedsNumber=" + bedsNumber +
                ", isBalcony=" + isBalcony +
                ", isSeaView=" + isSeaView +
                ", priceKcPerNight=" + priceKcPerNight +
                '}';
    }
}
