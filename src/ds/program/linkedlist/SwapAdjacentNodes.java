package ds.program.linkedlist;

public class SwapAdjacentNodes {


    private static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) return head;

        ListNode newHead = null;
        ListNode prevTail = null;
        ListNode curr = head;
        ListNode prev = null, next;
        ListNode currTail;


        while (curr != null) {
            currTail = curr;
            int count = 2;
            while (curr != null && count-- > 0) {
                next = curr.next;
                curr.next = prev;
                prev = curr;
                curr = next;

            }
            if (prevTail != null)
                prevTail.next = prev;
            prevTail = currTail;
            if (newHead == null) {
                newHead = prev;
            }

        }
        prevTail.next = null;
        return newHead;
    }


    public static void main(String[] args) {
        ListNode root = new ListNode(1);
        root.next = new ListNode(2);
        root.next.next = new ListNode(3);
        root.next.next.next = new ListNode(4, new ListNode(5));
        ListNode temp = root;
        while (temp != null) {
            System.out.print(temp.val + "->");
            temp = temp.next;
        }
        System.out.println("null");
        ListNode node = (new SwapAdjacentNodes()).swapPairs(root);
        temp = node;
        while (temp != null) {
            System.out.print(temp.val + "->");
            temp = temp.next;
        }
        System.out.println("null");
    }
}
