package ds.program.linkedlist;

// { Driver Code Starts
/* package whatever; // don't place package name! */

import java.util.*;

public class RemoveDuplicateFromUnsortedLL {
    // } Driver Code Ends
/* The structure of linked list is the following
class Node
{
    int data;
    Node next;
    Node(int d) {
        data = d;
        next = null;
    }
}
*/
    private static class Node
    {
        int data;
        Node next;
        Node(int d) {
            data = d;
            next = null;
        }
    }
    private static class RDUL
    {
        // Function to remove duplicates from the given linked list
        public Node removeDuplicates(Node head)
        {
            // Your code here
            Node temp = head;
            Node prev = null;
            HashSet<Integer> map = new HashSet<>();
            while(temp != null) {
                if(!map.contains(temp.data)) {
                    map.add(temp.data);
                    prev = temp;
                    temp = temp.next;
                } else {
                    prev.next = temp.next;
                    temp.next = null;
                    temp = prev.next;
                }
            }
            return head;
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


        /* Constructed Linked List is 1->2->3->4->5->6->
           7->8->8->9->null */
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t > 0) {
            int n = sc.nextInt();
            RemoveDuplicateFromUnsortedLL llist = new RemoveDuplicateFromUnsortedLL();
            int a1 = sc.nextInt();
            Node head = new Node(a1);
            llist.addToTheLast(head);
            for (int i = 1; i < n; i++) {
                int a = sc.nextInt();
                llist.addToTheLast(new Node(a));
            }
            //llist.printList();
            RDUL g = new RDUL();
            llist.head = g.removeDuplicates(llist.head);
            llist.printList();

            t--;
        }
    }
}
