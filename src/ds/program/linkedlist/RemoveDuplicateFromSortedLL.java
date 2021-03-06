package ds.program.linkedlist;
// { Driver Code Starts
/* package whatever; // don't place package name! */

import java.util.*;

public class RemoveDuplicateFromSortedLL {
   // } Driver Code Ends
private static class Node
    {
        int data;
        Node next;
        Node(int d) {data = d; next = null; }
    }

    private static class GfG {
        // head: head node
        Node removeDuplicates(Node root) {
            // Your code here

            Node temp = root;
            Node prev = root;
            while (temp != null) {
                while (temp != null && prev.data == temp.data) {
                    temp = temp.next;
                }
                prev.next = temp;
                prev = temp;
            }
            return root;
        }
    }

    Node head;

    public void addToTheLast(Node node) {
        if (head == null) {
            head = node;
        } else {
            Node temp = head;
            while (temp.next != null)
                temp = temp.next;

            temp.next = node;
        }
    }

    void printList() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    /* Drier program to test above functions */
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t > 0) {
            int n = sc.nextInt();
            RemoveDuplicateFromSortedLL llist = new RemoveDuplicateFromSortedLL();
            int a1 = sc.nextInt();
            Node head = new Node(a1);
            llist.addToTheLast(head);
            for (int i = 1; i < n; i++) {
                int a = sc.nextInt();
                llist.addToTheLast(new Node(a));
            }

            GfG g = new GfG();
            llist.head = g.removeDuplicates(llist.head);
            llist.printList();

            t--;
        }
    }
}