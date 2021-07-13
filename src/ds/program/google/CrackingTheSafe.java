package ds.program.google;

import java.util.HashSet;
import java.util.Set;

public class CrackingTheSafe {
    public static void main(String[] args) {
        System.out.println((new CrackingTheSafe()).crackSafe(4, 10));
    }

    private Set<String> seen;
    private StringBuilder ans;

//    public String crackSafe(int n, int k) {
//        if (n == 1 && k == 1) return "0";
//        seen = new HashSet<>();
//        ans = new StringBuilder();
//
//        StringBuilder sb = new StringBuilder();
//        for (int i = 0; i < n - 1; ++i)
//            sb.append("0");
//        String start = sb.toString();
//
//        System.out.println("start: " + start);
//        dfs(start, k);
//        System.out.println("updated start = "+start);
//        ans.append(start);
//        return ans.toString();
//    }
//
//    public void dfs(String node, int k) {
//        for (int x = 0; x < k; ++x) {
//            String nei = node + x;
//            if (!seen.contains(nei)) {
//                seen.add(nei);
//                dfs(nei.substring(1), k);
//                ans.append(x);
//            }
//        }
//    }
public String crackSafe(int n, int k) {
    int M = (int) Math.pow(k, n-1);
    int[] P = new int[M * k];
    for (int i = 0; i < k; ++i)
        for (int q = 0; q < M; ++q)
            P[i*M + q] = q*k + i;

    StringBuilder ans = new StringBuilder();
    for (int i = 0; i < M*k; ++i) {
        int j = i;
        while (P[j] >= 0) {
            ans.append(j / M);
            int v = P[j];
            P[j] = -1;
            j = v;
        }
    }

    for (int i = 0; i < n-1; ++i)
        ans.append("0");
    return new String(ans);
}
}
