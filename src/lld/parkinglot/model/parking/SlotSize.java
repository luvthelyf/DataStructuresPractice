package lld.parkinglot.model.parking;

import lld.parkinglot.model.vehicle.VehicleType;
import lld.parkinglot.model.vehicle.Vehicle;

import java.util.List;
import static java.util.Arrays.asList;
import static lld.parkinglot.model.vehicle.VehicleType.*;

public enum SlotSize {

    SMALL(asList(BIKE, COMPACT)),
    MEDIUM(asList(BIKE, COMPACT, SEDAN)),
    LARGE(asList(BIKE, COMPACT, SEDAN, TRUCK));

    private final List<VehicleType> vehicleTypesAllowed;

    SlotSize(List<VehicleType> vehicleTypes) {
        this.vehicleTypesAllowed = vehicleTypes;
    }

    public boolean isVehicleParkingPossible(Vehicle vehicle) {
        return vehicleTypesAllowed.contains(vehicle.getType());
    }
}