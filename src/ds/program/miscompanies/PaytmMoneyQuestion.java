package ds.program.miscompanies;

public class PaytmMoneyQuestion {

    public static int getSplNumber(String[] strings) {
        int ans = 0;
        long[] arrip = new long[strings.length];
        for(int i = 0; i < strings.length; i++) {
            arrip[i] = Long.parseLong(strings[i]);
        }
        Integer y = null;
        int x = y;
        for (long k : arrip) {
            for (int j = 1; j <= k / 2; j++) {
                int revNum = getRevNum(j);
                if (revNum + j == k) {
                    System.out.println("num = " + k);
                    ans++;
                    break;
                }
            }
        }
        return ans;
    }

    public static int getRevNum(int num) {
        int rev = 0;
        while (num != 0) {
            int reminder = num % 10;
            rev = rev * 10 + reminder;
            num = num / 10;
        }
        return rev;
    }

    public static void main(String[] args) {
        String[] arr = {"11", "10", "3", "120", "121", "12", "110", "141"};//
        System.out.println(getSplNumber(arr));

    }
}
