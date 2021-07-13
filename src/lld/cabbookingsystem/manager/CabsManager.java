package lld.cabbookingsystem.manager;

import lld.cabbookingsystem.database.StorageType;
import lld.cabbookingsystem.database.storages.Storage;
import lld.cabbookingsystem.errors.CabAlreadyRegisteredException;
import lld.cabbookingsystem.errors.CabNotFoundException;
import lld.cabbookingsystem.manager.StorageProvider;
import lld.cabbookingsystem.model.Cab;

public class CabsManager {
    private final Storage<Integer, Cab> cabsMap;

    public CabsManager(StorageType storageType) {
//        cabsMap = new DefaultStorage<>();
//        cabsMap = new StorageProvider<Integer, Cab>().get(DefaultStorage.class);
        cabsMap = new StorageProvider<Integer, Cab>().getStorage(storageType);
    }

    public int getTotalCabsCount() {
        return cabsMap.size();
    }

    public void registerCab(Cab cab) {
        if (cabsMap.containsKey(cab.getId()))
            throw new CabAlreadyRegisteredException();
        cabsMap.put(cab.getId(), cab);
    }

    public void unregisterCab(Cab cab) {
        if(!cabsMap.containsKey(cab.getId()))
            throw new CabNotFoundException("Cab not registed!");
    }
    public Cab getCabs(int id) {
        if(!cabsMap.containsKey(id)) throw new CabNotFoundException("No Cab found for this Id");
        return cabsMap.get(id);
    }
}
