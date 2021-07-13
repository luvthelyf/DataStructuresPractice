package ds.program.google;

import java.util.Arrays;

/*
1365
How Many Numbers Are Smaller Than the Current Number
Given the array nums, for each nums[i] find out how many numbers in the array are smaller than it. That is, for each nums[i] you have to count the number of valid j's such that j != i and nums[j] < nums[i].

Return the answer in an array.



Example 1:

Input: nums = [8,1,2,2,3]
Output: [4,0,1,1,3]
Explanation:
For nums[0]=8 there exist four smaller numbers than it (1, 2, 2 and 3).
For nums[1]=1 does not exist any smaller number than it.
For nums[2]=2 there exist one smaller number than it (1).
For nums[3]=2 there exist one smaller number than it (1).
For nums[4]=3 there exist three smaller numbers than it (1, 2 and 2).
Example 2:

Input: nums = [6,5,4,8]
Output: [2,1,0,3]
Example 3:

Input: nums = [7,7,7,7]
Output: [0,0,0,0]


Constraints:

2 <= nums.length <= 500
0 <= nums[i] <= 100
 */


/*
best solution:
public int[] smallerNumbersThanCurrent(int[] nums) {
        int[] buck = new int[101];

        for(int i=0; i<nums.length; i++) {
            buck[nums[i]] +=1;
        }

        for(int j=1; j<= 100; j++) {
            buck[j] += buck[j-1];
        }

        for(int k=0; k< nums.length; k++) {
            int pos = nums[k];
            nums[k] = pos==0 ? 0 : buck[pos-1];
        }

        return nums;
    }
 */
public class NumOfEleSmallerThanCurrentNum {
    public static void main(String[] args) {
        int[] arr = {8,1,2,2,3};

        System.out.println(Arrays.toString(new NumOfEleSmallerThanCurrentNum().smallerNumbersThanCurrent(arr)));

    }

    private int[] smallerNumbersThanCurrent(int[] arr) {
        int[] countSortArr = new int[102];

        for(int i = 0; i < arr.length; i++) {
            countSortArr[arr[i]]++;
        }

        System.out.println(Arrays.toString(countSortArr));
        int sum = 0;
        for(int i = 0; i < countSortArr.length; i++) {
            int currentCount = countSortArr[i];
            countSortArr[i] = sum;
            sum += currentCount;
        }
        System.out.println(Arrays.toString(countSortArr));

        int[] output = new int[arr.length];

        for(int i = 0; i < arr.length; i++) {
            output[i] = countSortArr[arr[i]];
        }
        return output;
    }
}

/*
Similar problem:
1356. Sort Integers by The Number of 1 Bits
Given an integer array arr. You have to sort the integers in the array in ascending order by the number of 1's in their binary representation and in case of two or more integers have the same number of 1's you have to sort them in ascending order.

Return the sorted array.



Example 1:

Input: arr = [0,1,2,3,4,5,6,7,8]
Output: [0,1,2,4,8,3,5,6,7]
Explantion: [0] is the only integer with 0 bits.
[1,2,4,8] all have 1 bit.
[3,5,6] have 2 bits.
[7] has 3 bits.
The sorted array by bits is [0,1,2,4,8,3,5,6,7]
Example 2:

Input: arr = [1024,512,256,128,64,32,16,8,4,2,1]
Output: [1,2,4,8,16,32,64,128,256,512,1024]
Explantion: All integers have 1 bit in the binary representation, you should just sort them in ascending order.
Example 3:

Input: arr = [10000,10000]
Output: [10000,10000]
Example 4:

Input: arr = [2,3,5,7,11,13,17,19]
Output: [2,3,5,17,7,11,13,19]
Example 5:

Input: arr = [10,100,1000,10000]
Output: [10,100,10000,1000]


Constraints:

1 <= arr.length <= 500
0 <= arr[i] <= 10^4



create pair of <num, numOfBits> and sort on the basic of numOfBits and if equal then on the basic of numbers.
 */
