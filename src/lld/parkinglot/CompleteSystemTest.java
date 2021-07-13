package lld.parkinglot;

import lld.parkinglot.admin.AdminAuthApi;
import lld.parkinglot.admin.Administrator;
import lld.parkinglot.controller.FareController;
import lld.parkinglot.controller.GateController;
import lld.parkinglot.controller.PaymentController;
import lld.parkinglot.core.Parking;
import lld.parkinglot.model.gate.DefaultGate;
import lld.parkinglot.model.gate.Gate;
import lld.parkinglot.model.gate.GateType;
import lld.parkinglot.model.parking.Floor;
import lld.parkinglot.model.parking.ParkingSlot;
import lld.parkinglot.model.parking.ParkingStatus;
import lld.parkinglot.model.parking.SlotSize;
import lld.parkinglot.model.vehicle.*;

import java.util.*;

public class CompleteSystemTest {
    public static void main(String[] args) {

        Administrator administrator = new Administrator("sandeep");
        System.out.println(administrator + " is created");
        AdminAuthApi.getInstance().registerAdmin(administrator);
        System.out.println(administrator + " is registered!");

        List<ParkingSlot> parkingSlots = new ArrayList<>();
        parkingSlots.add(new ParkingSlot("1", "001", ParkingStatus.EMPTY, SlotSize.SMALL));
        parkingSlots.add(new ParkingSlot("2", "002", ParkingStatus.EMPTY, SlotSize.SMALL));
        parkingSlots.add(new ParkingSlot("3", "003", ParkingStatus.EMPTY, SlotSize.SMALL));
        parkingSlots.add(new ParkingSlot("4", "004", ParkingStatus.EMPTY, SlotSize.SMALL));
        parkingSlots.add(new ParkingSlot("5", "005", ParkingStatus.EMPTY, SlotSize.MEDIUM));
        parkingSlots.add(new ParkingSlot("6", "006", ParkingStatus.EMPTY, SlotSize.MEDIUM));
        parkingSlots.add(new ParkingSlot("7", "007", ParkingStatus.EMPTY, SlotSize.MEDIUM));
        parkingSlots.add(new ParkingSlot("8", "008", ParkingStatus.EMPTY, SlotSize.LARGE));

        List<Floor> floorList = new ArrayList<>();
        floorList.add(new Floor("0", 0, "Basement", parkingSlots));
        floorList.add(new Floor("1", 1, "Upper Ground", parkingSlots));

        Map<VehicleType, Double> fareList = new HashMap<>();
        fareList.put(VehicleType.BIKE, 20.0);
        fareList.put(VehicleType.COMPACT, 40.0);
        fareList.put(VehicleType.SEDAN, 40.0);
        fareList.put(VehicleType.TRUCK, 100.0);

        Set<Gate> entryGateList = new HashSet<>();
        Set<Gate> exitGateList = new HashSet<>();

        Gate defaultEntryGate = new DefaultGate(GateType.ENTRY_EXIT);

        entryGateList.add(defaultEntryGate);
        exitGateList.add(defaultEntryGate);

        GateController gateController = new GateController(entryGateList, exitGateList);
        FareController fareController = new FareController(fareList);
        PaymentController paymentController = new PaymentController();

        Parking parking = Parking.getInstance(
                "1",
                floorList,
                "District Center Parking",
                "Janak Puri",
                fareController,
                gateController,
                paymentController
        );
        administrator.registerParking(parking);

        Vehicle car1 = new Sedan("DL0ABC0123");
        Vehicle car2 = new Sedan("DL0ABC0124");
        Vehicle car3 = new Sedan("DL0ABC0125");
        Vehicle car4 = new Bike("DL0ABC0126");
        Vehicle car5 = new HatchBackCar("DL0ABC0127");
        parking.onVehicleEntry(car1, defaultEntryGate);
        parking.onVehicleEntry(car2, defaultEntryGate);
        parking.onVehicleEntry(car3, defaultEntryGate);
        parking.onVehicleEntry(car4, defaultEntryGate);
        parking.onVehicleEntry(car5, defaultEntryGate);

        parking.onVehicleExit(car5, defaultEntryGate);
        parking.onVehicleExit(car1, defaultEntryGate);
        parking.onVehicleExit(car3, defaultEntryGate);
        parking.onVehicleExit(car4, defaultEntryGate);
        parking.onVehicleExit(car2, defaultEntryGate);
    }
}
