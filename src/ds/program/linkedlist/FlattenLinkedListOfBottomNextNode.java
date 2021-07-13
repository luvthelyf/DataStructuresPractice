package ds.program.linkedlist;

import java.util.Scanner;
import java.util.*;
import java.io.*;


public class FlattenLinkedListOfBottomNextNode{
    private static class FlatenNode
    {
        int data;
        FlatenNode next;
        FlatenNode bottom;

        FlatenNode(int d)
        {
            data = d;
            next = null;
            bottom = null;
        }
    }
    private static class FlattenGFG {
        FlatenNode flatten(FlatenNode root) {
            // Your code here
            if (root == null || root.next == null) return root;
            root.next = flatten(root.next);
            root = joinList(root, root.next);
            return root;
        }

        FlatenNode joinList(FlatenNode root, FlatenNode next) {
            if (root == null) return next;
            if (next == null) return root;
            FlatenNode result;
            if (root.data <= next.data) {
                result = root;
                result.bottom = joinList(root.bottom, next);
            } else {
                result = next;
                result.bottom = joinList(root, next.bottom);
            }
            return result;
        }
    }
// { Driver Code Starts
    FlatenNode head;

    void printList(FlatenNode FlatenNode)
    {
        //FlatenNode temp = head;
        while (FlatenNode != null)
        {
            System.out.print(FlatenNode.data + " ");
            FlatenNode =FlatenNode.bottom;
        }
        System.out.println();
    }
    public  static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        FlattenLinkedListOfBottomNextNode list = new FlattenLinkedListOfBottomNextNode();
        while(t>0)
        {
            int N = sc.nextInt();
            int arr[] = new int[N];
            for(int i=0;i<N;i++)
                arr[i] = sc.nextInt();

            FlatenNode temp = null;
            FlatenNode tempB = null;
            FlatenNode pre = null;
            FlatenNode preB = null;
            int flag=1;
            int flag1=1;
            for(int i=0; i<N;i++)
            {
                int m = arr[i];
                m--;
                int a1 = sc.nextInt();
                temp = new FlatenNode(a1);
                if(flag == 1)
                {
                    list.head = temp;
                    pre = temp;
                    flag = 0;
                    flag1 = 1;
                }
                else
                {
                    pre.next = temp;
                    pre = temp;
                    flag1 = 1;
                }

                for(int j=0;j<m;j++)
                {
                    int a = sc.nextInt();
                    tempB = new FlatenNode(a);
                    if(flag1 == 1)
                    {
                        temp.bottom = tempB;
                        preB = tempB;
                        flag1 = 0;
                    }
                    else
                    {
                        preB.bottom = tempB;
                        preB = tempB;
                    }
                }

            }
            //list.printList();
            FlattenGFG g = new FlattenGFG();
            FlatenNode root = g.flatten(list.head);
            list.printList(root);

            t--;
        }
    }
}// } Driver Code Ends
/*FlatenNode class  used in the program
class FlatenNode
{
	int data;
	FlatenNode next;
	FlatenNode bottom;

	FlatenNode(int d)
	{
		data = d;
		next = null;
		bottom = null;
	}
}
*/
/*  Function which returns the  root of
    the flattened linked list. */
