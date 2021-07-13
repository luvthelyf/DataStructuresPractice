package ds.program.linkedlist;

public class PartitionList {
    private static class ListNode {
        int val;
        ListNode next;
        ListNode(int val) {
            this.val = val;
            this.next = null;
        }
    }

    public static void main(String[] args) {
//        ListNode root = new ListNode(1);
//        root.next = new ListNode(4);
//        root.next.next = new ListNode(3);
//        root.next.next.next = new ListNode(2);
//        root.next.next.next.next = new ListNode(5);
//        root.next.next.next.next.next = new ListNode(2);
//
//        ListNode temp = (new PartitionList()).partition(root, 3);

        ListNode root = new ListNode(1);
        root.next = new ListNode(1);

        ListNode temp = (new PartitionList()).partition(root, 0);
        while(temp != null) {
            System.out.print(temp.val+ " ");
            temp = temp.next;
        }
        System.out.println();
    }

    public ListNode partition(ListNode head, int x) {
        if (head == null || head.next == null) return head;
        ListNode small = new ListNode(-1);
        ListNode largeEq = new ListNode(-1);

        ListNode smallStart = null;
        ListNode largeEqStart = null;

        while (head != null) {
            if (head.val < x) {
                if (small.next == null) {
                    smallStart = head;
                }
                small.next = head;
                small = small.next;
            } else {
                if (largeEq.next == null) {
                    largeEqStart = head;
                }
                largeEq.next = head;
                largeEq = largeEq.next;
            }
            head = head.next;
        }

        largeEq.next = null;

        if (largeEqStart != null) {
            small.next = largeEqStart;
        }
        return smallStart == null ? largeEqStart : smallStart;

    }
}
