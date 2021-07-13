package lld.parkinglot.core;

import lld.parkinglot.controller.FareController;
import lld.parkinglot.controller.GateController;
import lld.parkinglot.controller.PaymentController;
import lld.parkinglot.core.ParkingDetails;
import lld.parkinglot.exceptions.EntryFromWrongGateException;
import lld.parkinglot.exceptions.ExitFromWrongGateException;
import lld.parkinglot.exceptions.ParkingFullException;
import lld.parkinglot.model.gate.EntryGate;
import lld.parkinglot.model.gate.ExitGate;
import lld.parkinglot.model.gate.Gate;
import lld.parkinglot.model.parking.Floor;
import lld.parkinglot.model.parking.ParkingSlot;
import lld.parkinglot.model.vehicle.Vehicle;
import lld.parkinglot.payment.PaymentStatus;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Parking {
    private String parkingId;
    private List<Floor> floors;
    private String parkingName;
    private String address;
    private Map<Vehicle, ParkingDetails> vehicleParkingDetailsMap;
    private FareController fareController;
    private GateController gateController;
    private PaymentController paymentController;

    private static Parking mInstance;

    private Parking(String parkingId, List<Floor> floors,
                    String parkingName,
                    String address,
                    FareController fareController,
                    GateController gateController,
                    PaymentController paymentController) {
        this.parkingId = parkingId;
        this.floors = floors;
        this.parkingName = parkingName;
        this.address = address;
        this.fareController = fareController;
        this.gateController = gateController;
        this.paymentController = paymentController;
        vehicleParkingDetailsMap = new HashMap<>();
        emptyWholeParkingLot();
    }

    public static Parking getInstance(String parkingId, List<Floor> floors,
                                      String parkingName,
                                      String address,
                                      FareController fareController,
                                      GateController gateController,
                                      PaymentController paymentController) {
        if (mInstance == null) {
            mInstance = new Parking(parkingId, floors, parkingName, address, fareController, gateController, paymentController);
        }
        return mInstance;
    }

    public void addFloor(Floor floor) {
        this.floors.add(floor);
    }


    private void emptyWholeParkingLot() {
        for (Floor floor : floors) {
            floor.emptyFloor();
        }
    }

    public void onVehicleEntry(Vehicle vehicle, final Gate entryGate) {
        synchronized (entryGate) {
            if (!(entryGate instanceof EntryGate))
                throw new EntryFromWrongGateException();
            ParkingSlot slot = null;
            for (Floor floor : floors) {
                slot = floor.getAvailableSlot(vehicle);
                try {
                    if (slot != null) {
                        slot.parkVehicle(vehicle);
                        System.out.println(parkingName + ": Empty slot found at Floor : " + floor.getFloorNumber() + ", slot number : " + slot);
                        break;
                    }
                } catch (Exception ignored) {
                }
            }
            if (slot == null) throw new ParkingFullException();

            Date entryTime = new Date();
            System.out.println(parkingName + ": " + vehicle + " entered at " + entryTime + " from Gate : " + entryGate);

            vehicleParkingDetailsMap.put(vehicle, new ParkingDetails(slot, vehicle, this, entryTime, null));
            System.out.println(parkingName + ": Allowing entry for : " + vehicle);
            gateController.onVehicleEntered((EntryGate) entryGate);
        }
    }

    public void onVehicleExit(Vehicle vehicle, Gate exitGate) {
        synchronized (exitGate) {
            if (!(exitGate instanceof ExitGate))
                throw new ExitFromWrongGateException();

            ParkingDetails parkingDetails = vehicleParkingDetailsMap.get(vehicle);
            Date exitTime = new Date();
            System.out.println(parkingName + ": Noted exit time : " + exitTime + " for vehicle =" + vehicle);
            parkingDetails.setExitTime(exitTime);
            parkingDetails.getParkingSlot().emptySlot();
            double amountToBePaid = fareController.getCharges(parkingDetails);

            System.out.println(parkingName + ": Amount to be paid by :" + vehicle + " = " + amountToBePaid);
            PaymentStatus paymentStatus = PaymentStatus.PENDING;
            while (paymentStatus != PaymentStatus.SUCCESS) {
                paymentController.initiatePayment(amountToBePaid);
                paymentStatus = paymentController.getPaymentStatus();
            }
            System.out.println(parkingName + ": Allowing exit for " + vehicle);
            gateController.onVehicleExit((ExitGate) exitGate);
        }
    }

    @Override
    public String toString() {
        return "Parking{" +
                "parkingName='" + parkingName + '\'' +
                '}';
    }
}