package ds.program.array;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

public class ReverseWordsOfString {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int t = 0; t < T; t++) {
            String s = sc.next();

            reverseStringWords(s.trim());
        }
    }

    private static void reverseStringWords(String s) {
        StringBuilder changedString = new StringBuilder("");

        Deque<Character> deque = new LinkedList<>();
        int len = s.length();
        for (int i = 0; i < len; i++) {
            char c = s.charAt(i);
            if (c != '.') {
                deque.addFirst(c);
            } else {
                while (!deque.isEmpty()) {
                    changedString.append(deque.pop());
                }
                changedString.append(c);

            }
        }
        while (!deque.isEmpty()) {
            changedString.append(deque.pop());
        }
        for(int i = changedString.length() - 1; i >=0; i--){
            System.out.print(changedString.charAt(i));
        }
    }
}
