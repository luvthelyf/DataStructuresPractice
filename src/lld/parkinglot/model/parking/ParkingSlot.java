package lld.parkinglot.model.parking;

import lld.parkinglot.model.parking.ParkingStatus;
import lld.parkinglot.model.vehicle.Vehicle;

public class ParkingSlot {

    private String slotId;
    private final String slotNumber;
    private ParkingStatus status;
    private final SlotSize slotSize;
    private Vehicle vehicle;

    public ParkingSlot(String slotId, String slotNumber, ParkingStatus status, SlotSize slotSize) {
        this.slotId = slotId;
        this.slotNumber = slotNumber;
        this.status = status;
        this.slotSize = slotSize;
    }

    public void parkVehicle(Vehicle vehicle) {
        if (this.slotSize.isVehicleParkingPossible(vehicle)) {
            this.vehicle = vehicle;
            status = ParkingStatus.OCCUPIED;
        } else {
            throw new IllegalArgumentException("parking not possible for this vehicle type in this slot");
        }
    }

    public SlotSize getSlotSize() {
        return slotSize;
    }

    public void emptySlot() {
        System.out.println("slot " + slotNumber + " Emptied!");
        this.vehicle = null;
        status = ParkingStatus.EMPTY;
    }

    public boolean isEmpty() {
        return status == ParkingStatus.EMPTY;
    }

    @Override
    public String toString() {
        return "ParkingSlot{" +
                "slotNumber='" + slotNumber + '\'' +
                ", status=" + status +
                ", slotSize=" + slotSize +
                '}';
    }
}