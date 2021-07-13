package ds.program.array;

import java.util.Scanner;

public class MinStack {

    /**
     * initialize your data structure here.
     */
    int data;
    int minUntilNow;
    MinStack top = null;

    public MinStack() {

    }

    public void push(int x) {
        if(top == null) {
            top = new MinStack();
            top.data = x;
            top.minUntilNow = x;
        } else {
            MinStack temp = new MinStack();
            temp.data = x;
            temp.top = top;
            if(x > top.minUntilNow) {
                temp.minUntilNow = top.minUntilNow;
            } else {
                temp.minUntilNow = x;
            }
            top = temp;
        }
    }

    public void pop() {
        if(top == null) return;
        top = top.top;
    }

    public int top() {
        return top != null ? top.data : 0;
    }

    public int getMin() {
        return top.minUntilNow;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for(int t = 0; t < T; t++) {
            int N = sc.nextInt();
            int[] steps = new int[N];
            int[] arr = new int[N];
            for(int i = 0; i < N; i++) {
                steps[i] = sc.nextInt();
            }
            for(int i = 0; i < N; i++) {
                arr[i] = sc.nextInt();
            }
            MinStack stack = new MinStack();
            for(int i = 0; i < N; i++) {
                switch (steps[i]) {
                    case 0 :
                        stack.push(arr[i]);
                        break;
                    case 1 :
                        stack.pop();
                        break;
                    case 2 :
                        System.out.println(stack.top());
                        break;
                    case 3 :
                        System.out.println(stack.getMin());
                        break;
                }
            }
        }
    }
}



