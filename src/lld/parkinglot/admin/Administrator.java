package lld.parkinglot.admin;

import lld.parkinglot.core.Parking;
import lld.parkinglot.exceptions.AdminNotAuthenticatedException;
import lld.parkinglot.exceptions.ParkingAlreadyRegisteredException;
import lld.parkinglot.exceptions.ParkingNotRegisteredException;

import java.util.HashSet;
import java.util.Set;

public class Administrator {

    private final String userName;
    Set<Parking> parkingList;

    public Administrator(String userName) {
        this.userName = userName;
        parkingList = new HashSet<>();
    }

    public void registerParking(Parking parking) {
        if (AdminAuthApi.getInstance().verifyAdmin(this)) {
            if (parkingList.contains(parking))
                throw new ParkingAlreadyRegisteredException();
            this.parkingList.add(parking);
            System.out.println(parking + " registered by Admin!");
        } else
            throw new AdminNotAuthenticatedException();
    }

    public void unregisterParking(Parking parking) {
        if (AdminAuthApi.getInstance().verifyAdmin(this)) {
            if (!parkingList.contains(parking))
                throw new ParkingNotRegisteredException();
            this.parkingList.remove(parking);
        } else throw new AdminNotAuthenticatedException();
    }

    @Override
    public String toString() {
        return "Administrator{" +
                "userName='" + userName + '\'' +
                '}';
    }
}
