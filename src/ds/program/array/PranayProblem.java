package ds.program.array;

import java.util.*;

public class PranayProblem {
    private static class ListNode {
        int data;
        ListNode next;

        public ListNode(int data) {
            this.data = data;
            this.next = null;
        }

        public ListNode(int data, ListNode node) {
            this.data = data;
            this.next = node;
        }
    }

    public static void main(String[] args) {
//        System.out.println(new PranayProblem().stringSequence(new int[]{0,1,2,50,52,75}));
//        ListNode head = new ListNode(6, new ListNode(4, new ListNode(3, new ListNode(7))));
//        ListNode head1 = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(7))));
//        ListNode head2 = new ListNode(6, new ListNode(4, new ListNode(3, new ListNode(1))));
//        ListNode head3 = new ListNode(1, new ListNode(4, new ListNode(4, new ListNode(6))));
//        System.out.println(new PranayProblem().LinkedListOrderPrint(head));
//        System.out.println(new PranayProblem().LinkedListOrderPrint(head1));
//        System.out.println(new PranayProblem().LinkedListOrderPrint(head2));
//        System.out.println(new PranayProblem().LinkedListOrderPrint(head3));
//        new PranayProblem().insertIntoList(head3, 5);
//        printList(head3);
//        System.out.println(Arrays.toString(new PranayProblem().removeElementsFromArrayAndFillWith1(5, new int[]{22, 1, 34, 22, 16}, 22)));
        System.out.println(Arrays.deepToString(new PranayProblem().sequenceOfProcess(new int[]{0, 0, 1, 3, 4, 5}, new int[]{5, 3, 2, 1, 1, 5})));
    }

    private static class Pair {
        int start;
        int duration;
        public Pair(int start, int duration) {
            this.start = start;
            this.duration = duration;
        }

        @Override
        public String toString() {
            return "[" + start + ", " + duration + ']';
        }
    }
    public int[][] sequenceOfProcess(int[] startTimeAndDuration, int[] duration) {
        int[][] result = new int[startTimeAndDuration.length][startTimeAndDuration.length];
        PriorityQueue<Pair> queue = new PriorityQueue<>((o1, o2) -> {
            if (o1.start == o2.start) {
                return o1.duration - o2.duration;
            }
            return (o1.start + o1.duration) - (o2.start + o2.duration);
        });
// [[0,5],[0,3],[1,2],[3,1],[5,5]
        for (int i = 0; i < startTimeAndDuration.length; i++) {
            Pair arr = new Pair(startTimeAndDuration[i], duration[i]);
            queue.add(arr);
        }
        System.out.println(Arrays.toString(queue.toArray()));

        int i = 0;
        while (!queue.isEmpty()) {
            Pair pair = queue.poll();
            result[i++] = new int[]{pair.start, pair.duration};
        }
        return result;
    }

    private static void printList(ListNode head) {
        while (head != null) {
            System.out.println(head.data);
            head = head.next;
        }
    }

    private boolean ascending(ListNode head) {
        if (head == null)
            return true;
        for (ListNode t = head; t.next != null; t = t.next)
            if (t.data <= t.next.data)
                return false;
        return true;
    }

    private String LinkedListOrderPrint(ListNode head) {
        int a = head.data;
        int order = 0;
        if (head.next == null) return "asc";
        ListNode temp = head.next;
        if (temp.data < a) order = 1;
        while (temp != null) {
            if (order == 0 && temp.data < a) return "unordered";
            else if (order == 1 && temp.data > a) return "unordered";
            a = temp.data;
            temp = temp.next;
        }
        if (order == 1) return "desc";
        else return "asc";
    }

    private String stringSequence(int[] arr) {

//        int prev = -1;
//        StringBuilder sb = null;
//        for (int i = 0; i < arr.length; i++) {
//            if (arr[i] != prev + 1) {
//                if (sb == null) {
//                    sb = new StringBuilder();
//                    sb.append(String.valueOf(prev + 1));
//                } else {
//                    sb.append("-").append(String.valueOf(arr[i]));
//                    res.add(sb.toString());
//                    sb = null;
//                }
//            }
//            prev = arr[i];
//        }
//        return res;

        if (arr.length == 0) return "0-99";
        StringBuilder result = new StringBuilder();
        if (arr[0] != 0) {
            if (arr[0] == 1) {
                result.append("0,");
            } else
                result.append("0-" + arr[0] + ",");
        }
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] - arr[i - 1] == 2) {
                result.append((arr[i - 1] + 1) + ",");
            } else if (arr[i] - arr[i - 1] != 1) {
                result.append((arr[i - 1] + 1) + "-" + (arr[i] - 1) + ",");
            }
        }

        if (arr[arr.length - 1] != 99) {
            result.append((arr[arr.length - 1] + 1) + "-99");
        }
        return result.toString();
    }

    public int[] removeElementsFromArrayAndFillWith1(int N, int[] A, int X) {
        int[] result = new int[N];
        int index = 0;
        int k = N - 1;
        for (int i = N - 1; i >= 0; i--) {
            if (A[i] == X) {
                result[index++] = 1;
            } else {
                result[k--] = A[i];
            }
        }
        return result;


//        List<Integer> list = new ArrayList<>();
//        int count = 0;
//        for(int i = 0; i < N; i++) {
//            if(A[i] == X) {
//                count++;
//            } else {
//                list.add(A[i]);
//            }
//        }
//        int i = 0;
//        for(; i < count; i++) {
//            result[i] = 1;
//        }
//        for(int  j= 0; j < list.size(); j++) {
//            result[i++] = list.get(j);
//        }
//        return result;
    }
    //    private static class Pair {
//        int start;
//        int end;
//        Pair(int start, int end) {
//            this.start = start;
//            this.end = end;
//        }
//    }


    public int stringRemoveSameChar(String s) {
        recur(s, new HashSet<>());
        return ans % 1000000007;
    }

    int ans = 0;

    public void recur(String str, HashSet<String> output) {
        if (str.length() == 0) {
            return;
        }
        for (int i = 0; i < str.length(); i++) {
            String st = str.substring(0, i + 1);
            if (output.contains(st)) {
                ans++;
            }
            output.add(st);
            recur(str.substring(i + 1), output);
            output.remove(st);
        }
    }


    public void insertIntoList(ListNode node, int k) {
//        ListNode temp = head;
//        while (temp.next != null && k > temp.next.data) {
//            temp = temp.next;
//        }
//        ListNode newNode = new ListNode(k);
//        newNode.next = temp.next;
//        temp.next = newNode;

        ListNode temp = node;
        while (node.next != null && temp.next.data < k) {
            temp = temp.next;
        }
        ListNode newNode = new ListNode(k);
        newNode.next = temp.next;
        temp.next = newNode;
    }
}
