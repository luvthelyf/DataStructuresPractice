package ds.program.array;

import java.util.Scanner;

public class PermutationOfAString {
    public static void main(String[] args) {
        //code
        PermutationOfAString g = new PermutationOfAString();

        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int t = 0; t < T; t++) {
            String s = sc.next();
            g.permuteString(s, 0, s.length());
            System.out.println();
        }
    }

    private void permuteString(String s, int l, int r) {
        //System.out.println(l+" "+r);
        if (l == r) {
            System.out.print(s + " ");
        } else {
            for (int i = l; i < r; i++) {
                s = swap(s, l, i);
                permuteString(s, l + 1, r);
                s = swap(s, l, i);
            }
        }
    }

    private String swap(String s, int l, int r) {

        char[] charArr = s.toCharArray();
        char temp = charArr[l];
        charArr[l] = charArr[r];
        charArr[r] = temp;
        return String.valueOf(charArr);
    }
}
