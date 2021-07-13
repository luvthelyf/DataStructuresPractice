package ds.program.linkedlist;

public class LoopInLLPractice {
    private static class Node {
        int data;
        Node next;
        public Node(int data) {
            this.data = data;
            this.next = null;
        }

        public Node (int data, Node next) {
            this.data = data;
            this.next = next;
        }
    }
    public static void main(String[] args) {
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);
        Node lastNode = new Node(5);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = lastNode;
        Node head = node1;
        lastNode.next = node2;
        System.out.println(new LoopInLLPractice().findLoop(head));
    }

    private boolean findLoop(Node head) {
        Node slow = head;
        Node fast = head.next;
        while(fast != null && slow != fast) {
            slow = slow.next;
            fast = fast.next;
            if(fast != null)
                fast = fast.next;
        }
        System.out.println(slow.data);
        if(slow == fast) {
            slow = slow.next;
            fast = head;

            while(fast != slow) {
                fast = fast.next;
                slow = slow.next;
            }
            System.out.println(slow.data);
        }
        return slow == fast;
    }
}

// 1 -> 2 -> 3 -> 4 -> 5
//      ^               |
//      |_______________|

