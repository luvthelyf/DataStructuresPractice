package ds.program.google;

import java.util.TreeSet;

public class KEmptySlots {
    public static void main(String[] args) {
        System.out.println((new KEmptySlots()).kEmptySlots(new int[]{1,3,2}, 1));
    }

    public int kEmptySlots(int[] bulbs, int K) {
        TreeSet<Integer> set = new TreeSet<>();
        int steps  = 0;
        for(int x :bulbs) {
            steps++;
            set.add(x);
            Integer h = set.higher(x);
            Integer l = set.lower(x);
            System.out.println(l+" : " + x + " : "+h);
            if(h != null) {
                if(h-x-1 == K) {
                    return steps;
                }
            }
            if(l != null) {
                if(x-l-1 == K) {
                    return steps;
                }
            }
        }
        return -1;
    }
}
