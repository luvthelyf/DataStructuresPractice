package lld.parkinglot.core;

import lld.parkinglot.model.parking.ParkingSlot;
import lld.parkinglot.model.vehicle.Vehicle;

import java.util.Date;

public class ParkingDetails {
    private Parking parking;
    private final Vehicle vehicle;
    private ParkingSlot parkingSlot;
    private final Date entryTime;
    private Date exitTime;

    public ParkingDetails(ParkingSlot slot, Vehicle vehicle, Parking parking, Date entryTime, Date exitTime) {
        this.parkingSlot = slot;
        this.vehicle = vehicle;
        this.parking = parking;
        this.entryTime = entryTime;
        this.exitTime = exitTime;
    }

    public Date getEntryTime() {
        return entryTime;
    }

    public Date getExitTime() {
        return exitTime;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setExitTime(Date exitTime) {
        this.exitTime = exitTime;
    }

    public ParkingSlot getParkingSlot() {
        return parkingSlot;

    }
}