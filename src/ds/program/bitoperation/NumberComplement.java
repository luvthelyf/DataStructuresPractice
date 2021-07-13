package ds.program.bitoperation;

/**
 * Given a positive integer, output its complement number. The complement strategy is to flip the bits of its binary representation.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: 5
 * Output: 2
 * Explanation: The binary representation of 5 is 101 (no leading zero bits), and its complement is 010. So you need to output 2.
 * <p>
 * <p>
 * Example 2:
 * <p>
 * Input: 1
 * Output: 0
 * Explanation: The binary representation of 1 is 1 (no leading zero bits), and its complement is 0. So you need to output 0.
 * <p>
 * <p>
 * Note:
 * <p>
 * The given integer is guaranteed to fit within the range of a 32-bit signed integer.
 * You could assume no leading zero bit in the integer’s binary representation.
 * This question is the same as 1009: https://leetcode.com/problems/complement-of-base-10-integer/
 */
public class NumberComplement {
    public static void main(String[] args) {
        System.out.println((new NumberComplement()).findComplement(5));
    }

    public int findComplement(int num) {
        int i = 0;
        int ans = 0;
        while (num > 0) {
            if ((num & 1) == 0)
                ans += Math.pow(2, i);
            i++;
            num >>= 1;
        }
        return ans;
    }
}
