package ds.program.linkedlist;


import java.io.*;


public class ReverseLL {
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

// } Driver Code Ends
//function Template for Java

    /* Return reference of new head of the reverse linked list
     class Node {
         int value;
        Node next;
        Node(int value) {
            this.value = value;
        }
    }
    */
    private static class ReverseLinkedList {
        // This function should reverse linked list and return
        // head of the modified linked list.
        Node reverseList(Node head) {
            // add code here
            Node previous = null;
            Node current = head;
            Node next = current.next;

            System.out.println(previous + " " + current.data + " " + next.data);
            while (next != null) {
                current.next = previous;
                previous = current;
                current = next;
                next = current.next;
                System.out.print(previous.data + " " + current.data + " ");
                if (next != null)
                    System.out.println(next.data);

            }

            current.next = previous;
            head = current;

            Node temp = head;
            //System.out.println(temp.data+" ---- ");
            while (temp != null) {
                System.out.println(temp.data);
                temp = temp.next;
            }
            return head;
        }
    }
    Node head;  // head of lisl
    Node lastNode;
    static PrintWriter out;
    /* Linked list Node*/


    /* Utility functions */

    /* Inserts a new Node at front of the list. */
    public void addToTheLast(Node node) {

        if (head == null) {
            head = node;
            lastNode = node;
        } else {
            lastNode.next = node;
            lastNode = node;
        }
    }

    /* Function to print linked list */
    void printList() {
        Node temp = head;
        while (temp != null) {
            out.print(temp.data + " ");
            temp = temp.next;
        }
        out.println();
    }


    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        out = new PrintWriter(new BufferedOutputStream(System.out));
        int t = Integer.parseInt(br.readLine());

        while (t > 0) {
            int n = Integer.parseInt(br.readLine());

            ReverseLL gfg = new ReverseLL();
            String nums[] = br.readLine().split(" ");
            if (n > 0) {
                int a1 = Integer.parseInt(nums[0]);
                Node head = new Node(a1);
                gfg.addToTheLast(head);
            }
            for (int i = 1; i < n; i++) {
                int a = Integer.parseInt(nums[i]);
                gfg.addToTheLast(new Node(a));
            }


            gfg.head = new ReverseLinkedList().reverseList(gfg.head);

            gfg.printList();

            t--;
        }
        out.close();
    }
}

