package ds.program.array;

import java.util.HashMap;
import java.util.Scanner;

public class LRUCache {

    public static void main(String[] arg) {
        Scanner sc = new Scanner(System.in);
//      ["LRUCache","put","get","put","get","get"]
//      [[1],[2,1],[2],[3,2],[2],[3]]
//        ["LRUCache","get","put","get","put","put","get","get"]
//[[2],[2],[2,6],[1],[1,5],[1,2],[1],[2]]

//        LRUCache cache = new LRUCache(2 /* capacity */);
//        System.out.println(cache.get(2));
//        cache.put(2, 6);
//        System.out.println(cache.get(1));
//        cache.put(1, 5);
//        cache.put(1, 2);
//        System.out.println(cache.get(1));
//        System.out.println(cache.get(2));

//
//        LRUCache cache = new LRUCache(1 /* capacity */);
//
//        cache.put(2, 1);
//        System.out.println(cache.get(2));
//        cache.put(3, 2);
//        System.out.println(cache.get(2));
//        System.out.println(cache.get(3));

//        LRUCache cache = new LRUCache(2 /* capacity */);
//        cache.put(2, 1);
//        cache.put(2, 2);
//        System.out.println(cache.get(2));
//        System.out.println(cache.get(2));
//        cache.put(1, 1);
//        cache.put(4, 1);
//        System.out.println(cache.get(2));

//        LRUCache cache = new LRUCache(2 /* capacity */);
//        cache.put(1, 1);
//        cache.put(2, 2);
//        System.out.println(cache.get(1));       // returns 1
//        cache.put(3, 3);    // evicts key 2
//        System.out.println(cache.get(2));       // returns -1 (not found)
//        cache.put(4, 4);    // evicts key 1
//        System.out.println(cache.get(1));       // returns -1 (not found)
//        System.out.println(cache.get(3));       // returns 3
//        System.out.println(cache.get(4));       // returns 4

    }

    //    LinkedHashMap<Integer, Integer> map;
//    int capacity;
//    public LRUCache(int capacity) {
//        this.capacity = capacity;
//        map = new LinkedHashMap<>();
//    }
//    public int get(int key) {
//        if (!map.containsKey(key)) return -1;
//        int val = map.remove(key);
//        map.put(key, val);
//        return val;
//    }
//    public void put(int key, int value) {
//        if (map.containsKey(key)) {
//            map.remove(key);
//            map.put(key, value);
//        } else if (map.size() == capacity) {
//            int firstKey = map.keySet().iterator().next();
//            map.remove(firstKey);
//            map.put(key, value);
//        } else
//            map.put(key, value);
//    }
    private static class DLL<K,V> {
        K key;
        V val;
        DLL<K,V> prev;
        DLL<K,V> next;
        public DLL(K key, V value) {
            this.key = key;
            this.val = value;
            this.prev = null;
            this.next = null;
        }
    }
    DLL<Integer, Integer> head;
    DLL<Integer, Integer> tail;
    int capacity;
    HashMap<Integer, DLL<Integer, Integer>> map;
    public LRUCache(int capacity) {
        this.capacity = capacity;
        head = new DLL<>(0, 0);
        tail = new DLL<>(0, 0);
        head.next = tail;
        tail.prev = head;
        map = new HashMap<>();
    }
    public int get(int key) {
        if (map.containsKey(key)) {
            DLL<Integer, Integer> node = map.get(key);
            removeNode(node);
            addToHead(node);
            return node.val;
        }
        return -1;
    }

    private void addToHead(DLL<Integer, Integer> node) {
        node.next = head.next;
        node.prev = head;
        head.next.prev = node;
        head.next = node;
    }

    private void removeNode(DLL<Integer, Integer> node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    public void put(int key, int value) {
        if (map.containsKey(key)) {
            removeNode(map.get(key));
            map.remove(key);
        }

        if (map.size() == capacity) {
            map.remove(tail.prev.key);
            removeNode(tail.prev);
        }
        DLL<Integer, Integer> node = new DLL<>(key, value);
        map.put(key, node);
        addToHead(node);
    }


//    public int get(int key) {
//        if (map.containsKey(key)) {
//            DLL node = map.get(key);
//            deleteNode(node);
//            addToHead(node);
//            return node.val;
//        }
//        return -1;
//    }
//
//    public void put(int key, int value) {
//        if (map.containsKey(key)) {
//            deleteNode(map.get(key));
//            map.remove(key);
//        } else if (map.size() == capacity) {
//            map.remove(tail.key);
//            deleteNode(tail);
//        }
//        DLL node = new DLL(key, value);
//        addToHead(node);
//        map.put(key, node);
//    }
//
//    private void deleteNode(DLL node) {
//        if(node == head) {
//            if(node == tail) {
//                head = tail = null;
//            } else {
//                head = head.next;
//                head.prev = null;
//            }
//        } else if(node == tail) {
//            tail = tail.prev;
//            tail.next = null;
//        } else {
//            node.next.prev = node.prev;
//            node.prev.next = node.next;
//        }
//    }
//
//    private void addToHead(DLL node) {
//        if(head == null) {
//            head = tail = node;
//            return;
//        }
//        head.prev = node;
//        node.next = head;
//        head = node;
//    }


    private void printDLL() {
        DLL<Integer, Integer> node = head;
        while (node != null) {
            System.out.print(node.key + ":" + node.val + " ");
            node = node.next;
        }
        System.out.println();
    }

}
