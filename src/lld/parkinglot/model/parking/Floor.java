package lld.parkinglot.model.parking;

import lld.parkinglot.model.vehicle.Vehicle;

import java.util.ArrayList;
import java.util.List;

public class Floor {

    private String floorId;
    private int floorNumber;
    private String floorName;
    private final List<ParkingSlot> parkingSlots;


    public Floor(String floorId, int floorNumber, String floorName, List<ParkingSlot> parkingSlots) {
        this.floorId = floorId;
        this.floorNumber = floorNumber;
        this.floorName = floorName;
        this.parkingSlots = new ArrayList<>(parkingSlots);
    }

    public ParkingSlot getAvailableSlot(Vehicle vehicle) {
        for (ParkingSlot parkingSlot : parkingSlots) {
            SlotSize slotSize = parkingSlot.getSlotSize();
            if (parkingSlot.isEmpty() && slotSize.isVehicleParkingPossible(vehicle)) {
                return parkingSlot;
            }
        }
        return null;
    }

    public void emptyFloor() {
        for (ParkingSlot slot : parkingSlots) {
            slot.emptySlot();
        }
    }

    public int getFloorNumber() {
        return floorNumber;
    }
}