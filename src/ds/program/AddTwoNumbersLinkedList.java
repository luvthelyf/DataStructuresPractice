package ds.program;

public class AddTwoNumbersLinkedList {

    private static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            next = null;
        }

        Node(int data, Node next) {
            this.data = data;
            this.next = next;
        }
    }


    public static void main(String[] args) {
        Node head1 = new Node(4);
        Node head2 = new Node(9, new Node(9, new Node(9, new Node(9))));
//        Node head2 = new Node(1, new Node(9)); // 91
        printList(addNumbers(head1, head2));
//        printList(addLists(head1, head2));
    }

    private static void printList(Node head) {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    private static Node addNumbersAndReturnNewList(Node head1, Node head2) {
        Node head = new Node(-1);
        int sum = 0;
        int rem = 0;
        while(head1 != null || head2 != null) {
            if(head1 != null) {
                sum += head1.data;
            }
            if(head2 != null) {
                sum += head2.data;
            }

        }
        return head;
    }


    public static Node reverse(Node head)
    {
        Node prev = null;
        Node current = head;
        Node next = null;
        while (current != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        head = prev;
        return head;
    }
    // Function to add two lists X and Y
    public static Node add(Node X, Node Y)
    {
        Node head = null;
        // stores last seen node
        Node prevNode = null;
        // initialize carry with 0
        int carry = 0;
        // run till both list are empty
        while (X != null || Y  != null)
        {
            // sum is X's data + Y's data + carry (if any)
            int sum = 0;
            if (X != null) {
                sum += X.data;
            }
            if (Y != null ) {
                sum += Y.data;
            }
            sum += carry;
            // if sum of 2-digit number, reduce it and update carry
            carry = sum / 10;
            sum = sum % 10;
            // create a new node with calculated sum
            Node node = new Node(sum, null);
            // if the output list is empty
            if (head == null)
            {
                // update prev and head to point to the new node
                prevNode = node;
                head = node;
            }
            else
            {
                // add new node to the output list
                prevNode.next = node;
                // update prev node to point to the new node
                prevNode = node;
            }
            // advance X and Y for next iteration of the loop
            if (X != null) {
                X = X.next;
            }
            if (Y != null) {
                Y = Y.next;
            }
        }
        if (carry != 0) {
            prevNode.next = new Node(carry, prevNode.next);
        }
        return head;
    }
    // Function to add two lists X and Y
    public static Node addLists(Node X, Node Y)
    {
        // reverse X and Y to access elements from the end
        return add(X, Y);
    }

    private static Node addNumbers(Node head1, Node head2) {
        Node temp1 = head1;
        Node temp2 = head2;
        Node prev = null;
        int remainder = 0;
        boolean isFirstNullFound = false;
        while (temp1 != null || temp2 != null) {
            int sum = (temp1 != null ? temp1.data : 0) + (temp2 != null ? temp2.data : 0) + remainder;
            if (temp1 != null) temp1.data = sum % 10;
            else {
                if(!isFirstNullFound) {
                    isFirstNullFound = true;
                    prev.next = temp2;
                }
                temp2.data = sum % 10;
            }

            remainder = sum / 10;

            if (temp1 != null) {
                prev = temp1;
                temp1 = temp1.next;
            }
            if (temp2 != null) {
                if(isFirstNullFound)
                    prev = temp2;
                temp2 = temp2.next;
            }
        }

        if(remainder != 0) {
            prev.next = new Node(remainder);
        }

        return head1;
    }
}
