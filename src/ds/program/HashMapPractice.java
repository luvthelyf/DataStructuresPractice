package ds.program;


// abc hashCode() { char ascii sum

// cba


public class HashMapPractice {
    private static class MyEntry<K, V> {
        private K key;
        private V value;
        private MyEntry<K, V> next;

        public MyEntry(K key, V value, MyEntry<K, V> next) {
            this.key = key;
            this.value = value;
            this.next = next;
        }

        public K getKey() {
            return key;
        }

        public void setKey(K key) {
            this.key = key;
        }

        public V getValue() {
            return value;
        }

        public void setValue(V value) {
            this.value = value;
        }

        public MyEntry<K, V> getNext() {
            return next;
        }

        public void setNext(MyEntry<K, V> next) {
            this.next = next;
        }
    }

    private static class MyHashMap<K, V> {
        private int capacity = 16;
        private MyEntry<K, V>[] table;

        public MyHashMap() {
            table = new MyEntry[capacity];
        }

        public MyHashMap(int capacity) {
            this.capacity = capacity;
            table = new MyEntry[capacity];
        }

        public void put(K key, V value) {
            int index = indexOfKey(key);

            MyEntry<K, V> entry = new MyEntry<>(key, value, null);

            if (table[index] == null) {
                table[index] = entry;
            } else {
                MyEntry<K, V> current = table[index];

                while (current.getNext() != null) {
                    if (current.getKey().equals(key)) {
                        current.setValue(value);
                        break;
                    }
                    current = current.getNext();
                }
                current.setNext(entry);


            }
        }

        public V get(K key) {
            // TODO
            int index = indexOfKey(key);

            MyEntry<K, V> entry = table[index];

            while(entry != null) {
                if(entry.getKey().equals(key)) {
                    return entry.getValue();
                }
                entry = entry.getNext();
            }
            return null;
        }

        private int indexOfKey(K key) {
            if (key == null) {
                return 0;
            }
            return key.hashCode() % capacity;
        }

        public boolean remove(K key) {
            //TODO
            return false;
        }
    }


}
