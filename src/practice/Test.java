package practice;

import java.util.*;

public class Test {
    
  public static void main(String[] argv){
    Map<Integer, String> map = new HashMap<>();

    map.put(null, "value with null key");
    map.put(1, "123");
    map.put(2, "abc");
    map.put(3, null);

    System.out.println("HashMap's output:");
//    System.out.println(map.get(null));
//    System.out.println(map.get(1));
//    System.out.println(map.get(2));
//    System.out.println(map.get(3));
    System.out.println(map);
    Iterator<Integer> iterator = map.keySet().iterator();
    int count = 0;
    while (iterator.hasNext() && count++ < 2) {
      Integer key = iterator.next();
      System.out.println(map.get(key) + " ");
    }
    Integer k = iterator.next();
    map.put(k, map.get(k) + " : sandeep");
//    iterator.remove();
    System.out.println(map);
    System.out.println();

    System.out.println("****************************************************");
    // Try uncommenting the following lines.
//	    table.put(null, "xyz");
//	    table.put(3, null);
    Hashtable<Integer, String> table = new Hashtable<>();
    table.put(1, "cat");
    table.put(2, "dog");
//    table.put(null, "adsfasd"); // runtime exception

    System.out.println("\nHashTable's output:");

    Enumeration<Integer> tableKeys = table.keys();

    while(tableKeys.hasMoreElements()) {
      Integer key = tableKeys.nextElement();
      System.out.println(table.get(key)+ " ");
    }
    System.out.println();
    System.out.println("***********************************");
//    System.out.println(table.get(1));
////    System.out.println(table.get(null));
//    System.out.println(table.get(2));
  }
} 