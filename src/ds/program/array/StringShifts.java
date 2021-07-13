package ds.program.array;

import java.util.Scanner;

public class StringShifts {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();

        for(int t = 0; t < T; t++) {
            String str = sc.next();
            int m = sc.nextInt();
            int shift[][] = new int[m][2];
            for(int i = 0; i < m; i++) {
                shift[i][0] = sc.nextInt();
                shift[i][1] = sc.nextInt();
            }

            System.out.println((new StringShifts()).stringShift(str, shift));
        }
    }
    public String stringShift(String s, int[][] shift) {
        int sum = 0;
        for(int i = 0; i < shift.length; i++) {
            int dir = shift[i][0];
            int pos = shift[i][1];
            if(dir == 0) {
                sum -= pos;
            } else {
                sum += pos;
            }
        }
        int len = s.length();

        String res;

        int val = sum % len;
        if(val > 0) {
            res = s.substring(len - val) + s.substring(0, len - val);
        } else {
            res = s.substring(-val) + s.substring(0, -val);
        }
        return res;
    }
}
