package ds.program.array;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class RemoveAdjacentRedundant {
    public static void main(String[] args) {
        (new RemoveAdjacentRedundant()).removeRedundant("abbaca");// aabbccdd azxxzzy azxxzy abcdeedcba  geeksforgeegs
    }

    private void removeRedundant(String str) {
        Stack<Character> stack = new Stack<>();
        int i = 0;
        int len = str.length();
        while (i < len) {
            if (!stack.empty()) {
                if (str.charAt(i) == stack.peek()) {
                    System.out.println("pop " + stack.peek());
                    stack.pop();
                    i++;
                    continue;
                }
            }
            System.out.println("push " + str.charAt(i));
            stack.push(str.charAt(i));
            i++;
        }

        if (stack.empty()) {
            System.out.println("empty");
        } else {
            for (char ele : stack) {
                System.out.print(ele + "\t");
            }
        }

    }


    private void combinations(int start, int n, int k, LinkedList<Integer> list, List<List<Integer>> result) {
        if(n == 0 && list.size() == k) {
            result.add(new ArrayList(list));
            return;
        }
        for(int i = start; i <= 9; i++) {
            list.add(i);
            combinations(i + 1, n - i, k, list, result);
            list.removeLast();
        }
    }
}
