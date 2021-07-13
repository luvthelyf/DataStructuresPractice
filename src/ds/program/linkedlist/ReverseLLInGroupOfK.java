package ds.program.linkedlist;

public class ReverseLLInGroupOfK {
    private static class Node {
        int data;
        Node next;

        Node() {

        }

        Node(int d) {
            data = d;
            next = null;
        }
    }

    static Node reverse(Node head, int k) {
        if (k == 0) return head;
        Node prev = null;
        Node current = head;
        Node reversedHead;
        Node next;
        Node newHead = null;
        Node tail = null;
        int steps;

        while (current != null) {
            steps = 0;
            reversedHead = current;
            while (current != null && steps++ < k) {
                next = current.next;
                current.next = prev;
                prev = current;
                current = next;
            }

            if (newHead == null) {
                newHead = prev;
            }
            if (tail != null) {
                tail.next = prev;
            }

            tail = reversedHead;
        }
        tail.next = null;
        return newHead;
    }

    // Function to insert a node at
// the head of the linked list
    static Node push(Node head_ref, int new_data) {
        // allocate node /
        Node new_node = new Node();

        // put in the data /
        new_node.data = new_data;

        // link the old list off the new node /
        new_node.next = (head_ref);

        // move the head to point to the new node /
        (head_ref) = new_node;
        return head_ref;
    }

    // Function to print the linked list
    static void printList(Node node) {
        while (node != null) {
            System.out.print(node.data + " ");
            node = node.next;
        }
    }

    // Driver code
    public static void main(String args[]) {

        // Start with the empty list
        Node head = null;

        // Created Linked list is
        // 1.2.3.4.5.6.7.8.9
        head = push(head, 9);
        head = push(head, 8);
        head = push(head, 7);
        head = push(head, 6);
        head = push(head, 5);
        head = push(head, 4);
        head = push(head, 3);
        head = push(head, 2);
        head = push(head, 1);

        int k = 80;

        System.out.print("Given linked list \n");
        printList(head);
        head = reverse(head, k);

        System.out.print("\nReversed Linked list \n");
        printList(head);
    }
}
