package lld.parkinglot.controller;

import lld.parkinglot.core.ParkingDetails;
import lld.parkinglot.model.vehicle.Vehicle;
import lld.parkinglot.model.vehicle.VehicleType;

import java.util.Date;
import java.util.Map;

public class FareController {
    private final Map<VehicleType, Double> fareListOfEachVehicleType;

    public FareController(Map<VehicleType, Double> fareList) {
        this.fareListOfEachVehicleType = fareList;
    }

    private Double getPerHourChargeForVehicle(Vehicle vehicle) {
        return fareListOfEachVehicleType.get(vehicle.getType());
    }

    private Double getCharges(Double fare, Date entryTime, Date exitTime) {
        return ((exitTime.getTime() - entryTime.getTime()) / 1000.0) * fare;
    }

    public Double getCharges(ParkingDetails parkingDetails) {
        Double perHourCharge = getPerHourChargeForVehicle(parkingDetails.getVehicle());
        return getCharges(perHourCharge, parkingDetails.getEntryTime(), parkingDetails.getExitTime());
    }


//    private final Map<Vehicle, ParkingDetails> vehicleParkingDetailsMap = new HashMap<>();
//
//    public void onVehicleEntry(Vehicle vehicle, Parking parking) {
//        vehicleParkingDetailsMap.put(vehicle, new ParkingDetails(vehicle, parking, new Date(), null));
//    }
//
//    public void onVehicleExit(Vehicle vehicle) {
//        ParkingDetails parkingDetails = vehicleParkingDetailsMap.get(vehicle);
//        parkingDetails.exitTime = new Date();
//    }
//
//    public Double getFare(Vehicle vehicle) {
//        ParkingDetails parkingDetails = vehicleParkingDetailsMap.get(vehicle);
//        return getFare(parkingDetails.parking.getFare(vehicle), parkingDetails.entryTime, parkingDetails.exitTime);
//    }
}
