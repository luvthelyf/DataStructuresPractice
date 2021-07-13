package ds.program.array;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

public class ValidParenthesisString {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int t = 0; t < T; t++) {
            int n = sc.nextInt();
            ArrayList<String> list = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                list.add(sc.next());
            }

            for (String str : list)
                System.out.println(new ValidParenthesisString().checkValidString(str));

        }


    }


    public boolean checkValidString(String s) {
        if (s.length() == 0 || s.equals("*")) return true;
        if (s.length() == 1) return false;
        int leftCount = 0;
        for (char ch : s.toCharArray()) {
            if (ch == ')') {
                leftCount--;
            } else {
                leftCount++;
            }
            if (leftCount < 0) return false;
        }
        if (leftCount == 0) return true;
        int rightCount = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            char ch = s.charAt(i);
            if (ch == '(') {
                rightCount--;
            } else {
                rightCount++;
            }
            if (rightCount < 0) return false;
        }
        return true;
    }
}
