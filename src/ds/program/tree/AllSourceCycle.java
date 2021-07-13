package ds.program.tree;

import java.util.*;

public class AllSourceCycle {


    int [] res;
    boolean[] visited;
    boolean isCycleFromRootFound;
    public static void main(String[] args) {
        int n = 5;
        int m = 5;
        StringBuilder sb = new StringBuilder();



        int[][] graph = new int[][]{
                {1, 2},
                {2, 3},
                {3, 4},
                {4, 5},
                {4, 2}
        };

        Map<Integer, List<Integer>> adj = new HashMap<>();
        for (int[] e : graph) {
            int key = e[0];
            int val = e[1];
            List<Integer> v = adj.getOrDefault(key, new ArrayList<>());
            v.add(val);
            adj.put(key, v);
        }
        AllSourceCycle allSourceCycle = new AllSourceCycle();
        allSourceCycle.res = new int[n];
        allSourceCycle.visited = new boolean[n + 1];
        allSourceCycle.isCyclic(n, adj);
        System.out.println(Arrays.toString(allSourceCycle.res));
    }

    private void isCyclic(int n, Map<Integer, List<Integer>> adj)
    {
        boolean[] visited = new boolean[n + 1];
        boolean[] recStack = new boolean[n + 1];


        for (int i = 1; i <= n; i++) {
            isCycleFromRootFound = false;
            if (!visited[i] && isCyclicUtil(i, visited, recStack, adj, i)) {
                res[i - 1] = 1;
            }
        }


    }

    private boolean isCyclicUtil(int i, boolean[] visited,
                                 boolean[] recStack, Map<Integer, List<Integer>> adj, int start)
    {

        if (recStack[i]) {
            res[i - 1] = 1;
            if (start == i) {
                isCycleFromRootFound = true;
                return true;
            }
            return false;
        }

        if (visited[i])
            return false;

        visited[i] = true;

        recStack[i] = true;
        List<Integer> children = adj.get(i);

        if(children != null) {
            for (Integer c : children)
                if (isCyclicUtil(c, visited, recStack, adj, start)) {
                    return true;
                }
        }
        recStack[i] = false;

        return false;
    }


}

