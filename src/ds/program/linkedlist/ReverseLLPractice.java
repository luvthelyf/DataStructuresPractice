package ds.program.linkedlist;

public class ReverseLLPractice {
    private static class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
            this.next = null;
        }
        public Node(int data, Node next) {
            this.data = data;
            this.next = next;
        }
    }

    public static void main(String[] args) {
        Node head = new Node(1, new Node(2, new Node(3, new Node(4, new Node(5)))));
        printNodes(head);
//        Node newHead = new ReverseLLPractice().reverse(head);
        Node newHead = new ReverseLLPractice().reverseInGroupOfK(head, 3);
        printNodes(newHead);
    }

    private static void printNodes(Node newHead) {
        Node temp = newHead;

        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    //head -> 1 -> 2 -> 3 -> 4 -> 5 -> null
    //head -> 3 -> 2 -> 1 -> 5 -> 4 -> null
    private Node reverse(Node head) {
        Node prev = null;
        Node curr = head;
        Node next;
        Node newHead = null;
        while (curr != null) {
            next = curr.next;
            if (next == null) {
                newHead = curr;
            }
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return newHead;
    }

    //head -> 1 -> 2 -> 3 -> 4 -> 5 -> null
    //head -> 3 -> 2 -> 1 -> 5 -> 4 -> null
    // head -> 1 -> 2 -> null
    private Node reverseInGroupOfK(Node head, int k) {
        Node prev = null;
        Node curr = head;
        Node next = null;
        Node newHead = null;
        Node tail = null;
        Node tempNode = null;
        while (curr != null) {
            int count = 0;
            tempNode = curr;
            while (curr != null && count < k) {
                next = curr.next;
                curr.next = prev;
                prev = curr;
                curr = next;
                count++;
            }
            if(newHead == null) {
                newHead = prev;
            }
            if(tail != null) {
                tail.next = prev;
            }
            tail = tempNode;
        }
        tail.next = null;
        return newHead;
    }
}
