package ds.program.array;

public class SearchInSortedRotatedArray {
    public static void main(String[] args) {
//        int arr[] = {4, 5, 6, 7, 0, 1, 2};
        //int arr[] = {4,5,6,7,0,1,2};
        int arr[] = {1,3};
        System.out.println((new SearchInSortedRotatedArray()).search(arr, 3));
    }

    public int search(int[] nums, int target) {
        if (nums.length == 0) return -1;
        else if (nums.length == 1) {
            if(target == nums[0]) return 0;
            else return -1;
        }

        int i = 0;
        int j = nums.length - 1;

        while (i <= j) {
            if (i == j && nums[i] == target) {
                return i;
            }
            int left = nums[i];
            int right = nums[j];
            int mid = i + (j - i) / 2;

            if(target == left) return i;
            else if (target == right) return j;
            else if (nums[mid] == target) {
                return mid;
            }

            if (left < nums[mid]) {
                if(target >= left && target < nums[mid]) {
                    j = mid - 1;
                } else {
                    i = mid + 1;
                }
            } else {
                if(target > nums[mid] && target < right) {
                    i = mid + 1;
                } else {
                    j = mid - 1;
                }
            }
        }

        return -1;
    }

}
