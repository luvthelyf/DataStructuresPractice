package lld.cabbookingsystem.database.storages;

import java.util.HashMap;

public class DefaultStorage<K, V> implements Storage<K, V> {
    HashMap<K, V> map;

    public DefaultStorage() {
        map = new HashMap<>();
    }
    @Override
    public void put(K key, V value) {
        map.put(key, value);
    }

    @Override
    public V get(K key) {
        return map.get(key);
    }

    @Override
    public boolean containsKey(K key) {
        return map.containsKey(key);
    }

    @Override
    public int size() {
        return map.size();
    }
}
