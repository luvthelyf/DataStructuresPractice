package ds.program.array;


import java.util.Scanner;

public class SubarraySumEqualsKCount {
    public static void main(String[] arg) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int t = 0; t < T; t++) {
            int n = sc.nextInt();
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = sc.nextInt();
            }

            int k = sc.nextInt();
            SubarraySumEqualsKCount obj = new SubarraySumEqualsKCount();
            System.out.println("Case #" + (t + 1) + ": " + obj.subarraySum(arr, k));
        }
    }

    //    public int subarraySum(int[] nums, int k) {
//        if (nums.length == 0) return 0;
//        if (nums.length == 1) return (nums[0] == k) ? nums[0] : 0;
//        int len = nums.length;
//        int count = 0;
//
//        HashMap<Integer, Integer> map = new HashMap<>();
//        int sum = 0;
//        for (int i = 0; i < len; i++) {
//            sum += nums[i];
//            if (sum == k) count++;
//
//            if (map.containsKey(sum - k)) {
//                count += map.get(sum - k);
//            }
//            if (map.containsKey(sum))
//                map.put(sum, map.get(sum) + 1);
//            else
//                map.put(sum, 1);
//        }
//
//        return count;
//    }
    public int subarraySum(int[] a, int k) {
        int s = 0, ret = 0, tmp, mn = 1 << 30, mx = -1 << 30;
        for (int i : a) {
            s += i;
            if (s > mx) mx = s;
            if (s < mn) mn = s;
        }

        System.out.println(mn + " " + mx);
        int[] hash = new int[mx - mn + 1];
        s = 0;
        for (int i : a) {
            s += i;
            if (s == k) ++ret;
            tmp = s - k;
            System.out.println("s=" + s + ", k=" + k + ", s-k=" + tmp + ", s-mn=" + (s - mn) + ", hash[" + (s - mn) + "]=" + hash[s - mn]);
            if (tmp >= mn && tmp <= mx) {
                System.out.println("temp=" + tmp + ", tmp-mn=" + (tmp - mn) + ", hash[" + (tmp - mn) + "]=" + hash[tmp - mn]);
                ret += hash[tmp - mn];
            }
            ++hash[s - mn];
        }
        return ret;
    }
}
