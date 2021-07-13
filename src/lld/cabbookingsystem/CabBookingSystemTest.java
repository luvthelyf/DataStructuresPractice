package lld.cabbookingsystem;

import lld.cabbookingsystem.database.StorageType;
import lld.cabbookingsystem.manager.CabsManager;
import lld.cabbookingsystem.model.Cab;

public class CabBookingSystemTest {

    public static void main(String[] args) {

        CabsManager cabsManager = new CabsManager(StorageType.DEFAULT);
        Cab c1 = new Cab(1);
        cabsManager.registerCab(c1);
        System.out.println(cabsManager.getTotalCabsCount());
        System.out.println(cabsManager.getCabs(1));
    }
}
