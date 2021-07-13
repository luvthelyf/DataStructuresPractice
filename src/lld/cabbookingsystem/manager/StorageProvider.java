package lld.cabbookingsystem.manager;

import lld.cabbookingsystem.database.StorageType;
import lld.cabbookingsystem.database.storages.CustomStorage;
import lld.cabbookingsystem.database.storages.DefaultStorage;
import lld.cabbookingsystem.database.storages.Storage;

import java.lang.reflect.InvocationTargetException;

public class StorageProvider<K, V> {

    public <T> T get(Class<T> storageClass) {

        try {
            return storageClass.getDeclaredConstructor().newInstance();
        } catch (
                InstantiationException |
                        NoSuchMethodException |
                        InvocationTargetException |
                        IllegalAccessException e
        ) {
            e.printStackTrace();
        }
        return null;
    }

    public Storage<K, V> getStorage(StorageType storageType) {
        if (storageType == StorageType.CUSTOM) {
            return get(CustomStorage.class);
        }
        return get(DefaultStorage.class);
    }
}
