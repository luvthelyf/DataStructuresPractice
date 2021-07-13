package ds.program.linkedlist;

import java.util.*;

public class NthNodeFromLast {

// } Driver Code Ends
private static class Node
{
    int data;
    Node next;
    Node(int d) {data = d; next = null; }
}

    private static class NthNode {
        // Function to find the nth node from end in the linked list
        // head: head of the linked list
        // n: nth node from end to find
        int getNthFromLast(Node head, int n) {
            if (n == 0) return -1;
            // Your code here
            Node first = head;
            Node last = head;
            for (int i = 1; i <= n; i++) {
                last = last.next;
                if (last == null && i != n) return -1;
            }

            while (last != null) {
                first = first.next;
                last = last.next;
            }
            return first.data;
        }
    }

    Node head;

    /* Function to print linked list */
    void printList(Node head) {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }


    /* Inserts a new Node at front of the list. */
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

    /* Drier program to test above functions */
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t > 0) {
            int n = sc.nextInt();
            int k = sc.nextInt();
            NthNodeFromLast llist = new NthNodeFromLast();
            //int n=Integer.parseInt(br.readLine());
            int a1 = sc.nextInt();
            Node head = new Node(a1);
            llist.addToTheLast(head);
            for (int i = 1; i < n; i++) {
                int a = sc.nextInt();
                llist.addToTheLast(new Node(a));
            }

            //System.out.println(llist.head.data);
            NthNode g = new NthNode();
            //System.out.println(k);
            System.out.println(g.getNthFromLast(llist.head, k));

            t--;
        }
    }
}

