package ds.program.array;

import java.util.*;

public class FirstNonRepeatingNumber {


    private static class FirstUnique {
        private Set<Integer> unique = new LinkedHashSet<>();
        private Set<Integer> total = new HashSet<>();

        FirstUnique(){

        }
        public FirstUnique(int[] nums) {
            for (int n : nums) {
                add(n);
            }
        }

        public int showFirstUnique() {
            for (int v : unique) {
                return v;
            }
            return -1;
        }

        public void add(int value) {
            if (total.add(value)) {
                unique.add(value);
            }else {
                unique.remove(value);
            }
        }

        public int firstUniqChar(String s) {
            if(s == null || s.length() == 0) return 0;
            Map<Character, Integer> unique = new LinkedHashMap<>();
            Set<Character> total = new HashSet<>();
            int i = 0;
            for(Character c: s.toCharArray()) {
                if(total.add(c)) {
                    unique.put(c, i);
                } else {
                    unique.remove(c);
                }
                i++;
            }
            for (Map.Entry<Character, Integer> entry: unique.entrySet()) {
                return entry.getValue();
            }
            return -1;
        }


        public int firstUniqCharBest(String s) {
            int res = Integer.MAX_VALUE;

            for(char c = 'a'; c <= 'z'; c++){
                int index = s.indexOf(c);

                if(index != -1 && index == s.lastIndexOf(c)) {
                    res = Math.min(res, index);
                }
            }

            return res == Integer.MAX_VALUE ? -1 : res;
        }
//        Map<Integer, Integer> map;
//
//        public FirstUnique(int[] nums) {
//            map = new LinkedHashMap<>();
//            for (int i = 0; i < nums.length; i++) {
//                add(nums[i]);
//            }
//        }
//
//        public int showFirstUnique() {
//            if (map == null) return -1;
//            for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
//                if (entry.getValue() == 1) {
//                    return entry.getKey();
//                }
//            }
//            return -1;
//        }
//
//        public void add(int value) {
//            if (!map.containsKey(value)) {
//                map.put(value, 1);
//            } else {
//                map.put(value, map.get(value) + 1);
//            }
//        }
    }

    public static void main(String[] args) {

//        int[] arr = {2, 3, 5};
        FirstUnique unique = new FirstUnique();
        System.out.println(unique.firstUniqCharBest("sansan"));
//        System.out.println(unique.showFirstUnique());
//        unique.add(5);
//        System.out.println(unique.showFirstUnique());
//        unique.add(2);
//        System.out.println(unique.showFirstUnique());
//        unique.add(3);
//        System.out.println(unique.showFirstUnique());
//        unique.add(3);
//        System.out.println(unique.showFirstUnique());
//        unique.add(8);
//        System.out.println(unique.showFirstUnique());
//        unique.add(9);
//        System.out.println(unique.showFirstUnique());
//        unique.add(13);
//        System.out.println(unique.showFirstUnique());
//        unique.add(11);
//        System.out.println(unique.showFirstUnique());
//        unique.add(8);
//        System.out.println(unique.showFirstUnique());
//        unique.add(9);
//        System.out.println(unique.showFirstUnique());
    }

}
/*




class FirstUnique {

        private static class DLL {
            int num;
            DLL next;
            DLL prev;

            DLL(int num) {
                this.num = num;
                this.next = null;
                this.prev = null;
            }
        }

        Map<Integer, DLL> map;
        DLL head;
        DLL tail;

        public FirstUnique(int[] nums) {
            map = new HashMap<>();
            for (int i = 0; i < nums.length; i++) {
                add(nums[i]);
            }
        }

        public int showFirstUnique() {
            if (head == null) return -1;
            return head.num;
        }

        public void add(int value) {
            if (map.containsKey(value)) {
                DLL node = map.get(value);
                if(node == null) return;
                if (node.prev == null && node.next == null) {
                    head = tail = null;
                } else if (node.prev == null) {
                    head = node.next;
                    head.prev = null;
                    node.next = null;
                } else if (tail == node) {
                    tail = node.prev;
                    node.prev = null;
                    tail.next = null;
                } else {
                    node.prev.next = node.next;
                    node.next.prev = node.prev;
                    node.prev = node.next = null;
                }
                map.put(value, null);
            } else {
                DLL node = new DLL(value);
                if (head == null) {
                    head = node;
                    tail = head;
                } else {
                    tail.next = node;
                    node.prev = tail;
                    tail = node;
                }
                map.put(value, node);
            }
        }
    }

/**
 * Your FirstUnique object will be instantiated and called as such:
 * FirstUnique obj = new FirstUnique(nums);
 * int param_1 = obj.showFirstUnique();
 * obj.add(value);
 */
