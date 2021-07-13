package ds.program.google;

import java.util.Stack;

public class DuplicateRemoval {
    public static void main(String[] args) {
        System.out.println((new DuplicateRemoval()).removeDuplicates("aa"));
    }

    public String removeDuplicates(String S) {
        int len = S.length();
        Stack<Character> stack = new Stack<>();
        for (int i = len - 1; i >= 0; i--) {

//            System.out.println(S.charAt(i));
            while (!stack.isEmpty() && i >= 0 && stack.peek() == S.charAt(i)) {
                stack.pop();
                i--;
            }

            if(i >= 0) stack.push(S.charAt(i));
        }

        StringBuilder sb = new StringBuilder();

        while (!stack.isEmpty()) {
            sb.append(stack.peek());
            stack.pop();
        }
        return sb.toString();
    }
}
