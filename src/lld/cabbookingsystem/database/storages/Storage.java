package lld.cabbookingsystem.database.storages;

public interface Storage<K, V>{
    void put(K key, V value);
    V get(K key);
    boolean containsKey(K key);
    int size();
}
