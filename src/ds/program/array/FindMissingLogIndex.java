package ds.program.array;

import java.util.Arrays;

public class FindMissingLogIndex {
    public static void main(String[] args) {// 4289402
//        System.out.println(Integer.MAX_VALUE);
//        System.out.println(new FindMissingLogIndex().findMissing(new int[] {1,2,3,4,5,6,8}));//191
//        System.out.println(new FindMissingLogIndex().maxLogToPrint(3, new int[]{10, 20, 1}));
        System.out.println(new FindMissingLogIndex().maxLogToPrint(4, new int[]{10, 1, 1, 100}));
    }
    int findMissingBinary(int[] a, int l, int r) {
        if(l < r) {
            int mid = (l + r) /2;
            if(a[mid] == mid + 1 && a[mid + 1] == mid + 3) {
                return a[mid] + 1;
            }
            if(mid + 1 == a[mid]) {
                return findMissingBinary(a, mid + 1, r);
            } else {
                return findMissingBinary(a, l, mid - 1);
            }
        } else {
            return l;
        }
    }
    private int findMissing(int[] arr) {

        int l = findMissingBinary(arr, 0, arr.length - 1);
        if (l == 0 && arr[0] != 1) return 1;
        if(l == arr.length - 1) return arr.length + 1;

        if(arr[0] != 1) return 1;
        if(arr[arr.length - 1] == arr.length) return arr.length + 1;
        return l;
    }

    private int maxLogToPrint(int n, int[] logsCount) {
        System.out.println(Arrays.toString(logsCount));
        int currentLog = logsCount[0];
        int excludeLogServer = 0;
        for (int i = 1; i < n; i++) {
            System.out.println(currentLog + " : " + excludeLogServer);
            int prevServerLogs = currentLog;
            currentLog = logsCount[i] + excludeLogServer;
            System.out.println("max of " + prevServerLogs + " : " + excludeLogServer);
            excludeLogServer = Math.max(prevServerLogs, excludeLogServer);
        }

        return Math.max(currentLog, excludeLogServer);
    }
}
