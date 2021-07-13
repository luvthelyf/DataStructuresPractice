package ds.program.google;

/*
1422. Maximum Score After Splitting a String

Given a string s of zeros and ones, return the maximum score after splitting the string into two non-empty substrings (i.e. left substring and right substring).

The score after splitting a string is the number of zeros in the left substring plus the number of ones in the right substring.



Example 1:

Input: s = "011101"
Output: 5
Explanation:
All possible ways of splitting s into two non-empty substrings are:
left = "0" and right = "11101", score = 1 + 4 = 5
left = "01" and right = "1101", score = 1 + 3 = 4
left = "011" and right = "101", score = 1 + 2 = 3
left = "0111" and right = "01", score = 1 + 1 = 2
left = "01110" and right = "1", score = 2 + 1 = 3
Example 2:

Input: s = "00111"
Output: 5
Explanation: When left = "00" and right = "111", we get the maximum score = 2 + 3 = 5
Example 3:

Input: s = "1111"
Output: 3


Constraints:

2 <= s.length <= 500
The string s consists of characters '0' and '1' only.
 */
public class MaxScoreAfterSplittingStringInTwoSubstring {
    public static void main(String[] args) {
        System.out.println((new MaxScoreAfterSplittingStringInTwoSubstring()).maxScore("00"));
    }

    public int maxScore(String s) {
        char[] arr = s.toCharArray();

        int countZero = 0;
        int countOne = 0;
        for (Character c : arr) {
            if (c == '1') {
                countOne++;
            }
        }
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i] == '0') countZero++;
            else countOne--;
            max = Math.max(max, countZero + countOne);
        }
        return max;
    }
}


/*
An interesting solution:
public int maxScore(String s) {
         char[] array = s.toCharArray();

         int count_ones = 0;
         for(char c: array){
             if(c=='1'){
                 count_ones++;
             }
         }


        int count_zeroes = 0;
        int res = 0;
        for(int i=0;i<array.length-1;i++){
            if(array[i] == '0'){
                count_zeroes++;
            }else{
                count_ones--;
            }

            res = Math.max(res, count_zeroes+count_ones);
        }


        return res;
    }
 */
