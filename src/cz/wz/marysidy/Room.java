package cz.wz.marysidy;

import java.math.BigDecimal;

public class Room {
    private int roomNumber;
    private int bedsNumber;
    private boolean isBalcony;
    private boolean isSeaView;
    private BigDecimal priceKcPerNight;

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
