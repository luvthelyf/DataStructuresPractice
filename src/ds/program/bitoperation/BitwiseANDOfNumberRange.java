package ds.program.bitoperation;

import java.util.Scanner;

public class BitwiseANDOfNumberRange {
    public static void main(String[] arg) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int t = 0; t < T; t++) {
            int m = sc.nextInt();
            int n = sc.nextInt();
            BitwiseANDOfNumberRange obj = new BitwiseANDOfNumberRange();
            System.out.println("Case #" + (t + 1) + ": " + obj.rangeBitwiseAnd(m, n));
        }
    }

    public int rangeBitwiseAnd(int m, int n) {
        while (m < n) {
            n -= (n & -n);
        }
        return n;
    }
}