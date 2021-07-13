package ds.program.array;

import java.util.Scanner;

public class BackspaceCompare {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T1 = sc.nextInt();
        for (int t = 0; t < T1; t++) {
            String S = sc.next();
            String T = sc.next();
            System.out.println(new BackspaceCompare().backspaceCompare(S, T));
        }
    }

    public boolean backspaceCompare(String S, String T) {
        int i, j;
        i = S.length() - 1;
        j = T.length() - 1;

        while (i >= 0 || j >= 0) {
            int hashCountInS = 0;
            int hashCountInT = 0;
            while (i >= 0 && (hashCountInS > 0 || S.charAt(i) == '#')) {
                if (S.charAt(i) == '#') hashCountInS++;
                else hashCountInS--;
                i--;
            }
            while (j >= 0 && (hashCountInT > 0 || T.charAt(j) == '#')) {
                if (T.charAt(j) == '#') hashCountInT++;
                else hashCountInT--;
                j--;
            }
            if (i >= 0 && j >= 0) {
                if (S.charAt(i) != T.charAt(j)) return false;
                else {
                    i--;
                    j--;
                }
            } else if (i >= 0 || j >= 0) return false;

        }
        return true;
    }
}
