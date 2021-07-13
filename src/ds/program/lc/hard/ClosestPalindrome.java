package ds.program.lc.hard;

/**
 *
 *just construct 3 Palindromes, first is mirror the fist half to the last,
 * second is let first half plus one and mirror to the last,
 * third is let firs half minus one and mirror to the last.
 * Then compare the three and return the nearest.
 *
 *
 * 564. Find the Closest Palindrome
 * Hard
 *
 * Given a string n representing an integer, return the closest integer (not including itself), which is a palindrome. If there is a tie, return the smaller one.
 *
 * The closest is defined as the absolute difference minimized between two integers.
 *
 *
 *
 * Example 1:
 *
 * Input: n = "123"
 * Output: "121"
 * Example 2:
 *
 * Input: n = "1"
 * Output: "0"
 * Explanation: 0 and 2 are the closest palindromes but we return the smallest which is 0.
 *
 *
 * Constraints:
 *
 * 1 <= n.length <= 18
 * n consists of only digits.
 * n does not have leading zeros.
 * n is representing an integer in the range [1, 1018 - 1].
 * Accepted
 * 25,649
 * Submissions
 * 125,870
 */
public class ClosestPalindrome {
    public String mirroring(String s) {
        String x = s.substring(0, (s.length()) / 2);
        return x + (s.length() % 2 == 1 ? s.charAt(s.length() / 2) : "") + new StringBuilder(x).reverse();
    }
    public String nearestPalindromic(String n) {
        if (n.equals("1"))
            return "0";

        String a = mirroring(n);
        long diff1;
        diff1 = Math.abs(Long.parseLong(n) - Long.parseLong(a));
        if (diff1 == 0)
            diff1 = Long.MAX_VALUE;

        StringBuilder s = new StringBuilder(n);
        int i = (s.length() - 1) / 2;
        while (i >= 0 && s.charAt(i) == '0') {
            s.replace(i, i + 1, "9");
            i--;
        }
        if (i == 0 && s.charAt(i) == '1') {
            s.delete(0, 1);
            int mid = (s.length() - 1) / 2;
            s.replace(mid, mid + 1, "9");
        } else
            s.replace(i, i + 1, "" + (char)(s.charAt(i) - 1));
        String b = mirroring(s.toString());
        long diff2 = Math.abs(Long.parseLong(n) - Long.parseLong(b));


        s = new StringBuilder(n);
        i = (s.length() - 1) / 2;
        while (i >= 0 && s.charAt(i) == '9') {
            s.replace(i, i + 1, "0");
            i--;
        }
        if (i < 0) {
            s.insert(0, "1");
        } else
            s.replace(i, i + 1, "" + (char)(s.charAt(i) + 1));
        String c = mirroring(s.toString());
        long diff3 = Math.abs(Long.parseLong(n) - Long.parseLong(c));

        if (diff2 <= diff1 && diff2 <= diff3)
            return b;
        if (diff1 <= diff3)
            return a;
        else
            return c;
    }}
