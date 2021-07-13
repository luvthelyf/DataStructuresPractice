package ds.program.tree;

import java.util.*;

public class Right45DegreeViewOfATree {

    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int x) {
            val = x;
            left = null;
            right = null;
        }
    }


    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.right = new TreeNode(4);
        root.right.left = new TreeNode(5);
//        root.left = new TreeNode(2);
//        root.right = new TreeNode(3);
//        root.left.left = new TreeNode(4);
//        root.left.right = new TreeNode(5);
//        root.left.right.left = new TreeNode(6);
//        root.left.right.left.right = new TreeNode(7);
//        root.left.right.left.right.left = new TreeNode(8);
        Right45DegreeViewOfATree rightViewOfATree = new Right45DegreeViewOfATree();
//        System.out.println(rightViewOfATree.right45DegreeView(root));
//        System.out.println(rightViewOfATree.right45DegreeViewAllNodesKept(root));
        System.out.println(rightViewOfATree.findMaxProfitTest(new int[]{7, 1, 5, 3, 6, 4}));
        System.out.println(rightViewOfATree.findMaxProfitTest(new int[]{7, 5, 4, 3, 2, 1}));
        System.out.println(rightViewOfATree.findMaxProfitTest(new int[]{7, 7, 7, 7, 7, 7, 7, 7}));
    }

    private static class DistanceOfNode {
        TreeNode node;
        int distance;

        public DistanceOfNode(TreeNode node, int distance) {
            this.node = node;
            this.distance = distance;
        }
    }

    private List<Integer> right45DegreeView(TreeNode root) {

        Map<Integer, Integer> map = new TreeMap<>();


        Queue<DistanceOfNode> queue = new LinkedList<>();

        map.put(0, root.val);
        queue.add(new DistanceOfNode(root, 0));

        while (!queue.isEmpty()) {
            int size = queue.size();

            for (int i = 0; i < size; i++) {

                DistanceOfNode temp = queue.poll();

                if (temp == null) continue;
                TreeNode node = temp.node;
                int distance = temp.distance;


                if (node.right != null) {
                    queue.add(new DistanceOfNode(node.right, distance));
                    map.put(distance, node.right.val);
                }
                if (node.left != null) {
                    queue.add(new DistanceOfNode(node.left, distance - 1));
                    map.put(distance - 1, node.left.val);
                }
            }
        }
        return new ArrayList<>(map.values());
    }


    public int findMaxProfitTest(int[] arr) {
        int buyMin = Integer.MAX_VALUE;
        int maxProfit = Integer.MIN_VALUE;

        for (int  price: arr) {
            maxProfit = Math.max(maxProfit, price - buyMin);
            buyMin = Math.min(buyMin, price);
        }

        return maxProfit;
    }

    public int findMaxProfit(int[] arr) {
        int maxProfit = 0;
        int length = arr.length - 1;
        int currentMaxStock = arr[length];

        int currProfit = 0;
        for (int i = length - 1; i >= 0; i--) {
            if (arr[i] < currentMaxStock && arr[i] < arr[i + 1]) {
                currProfit = Math.max(currProfit, currentMaxStock - arr[i]);
            } else {
                currentMaxStock = arr[i];
                maxProfit += currProfit;
            }

        }
        return maxProfit;
    }

    private List<List<Integer>> right45DegreeViewAllNodesKept(TreeNode root) {

        Map<Integer, ArrayList<Integer>> map = new TreeMap<>();


        Queue<DistanceOfNode> queue = new LinkedList<>();

        map.put(0, new ArrayList<>(root.val));
        queue.add(new DistanceOfNode(root, 0));

        int level = 0;
        int prevLevel = -1;
        while (!queue.isEmpty()) {
            int size = queue.size();

            for (int i = 0; i < size; i++) {

                DistanceOfNode temp = queue.poll();

                if (temp == null) continue;
                TreeNode node = temp.node;
                int distance = temp.distance;

                if (node.right != null) {
                    queue.add(new DistanceOfNode(node.right, distance));
                    ArrayList<Integer> list;
                    if (level == prevLevel) {
                        list = map.getOrDefault(distance, new ArrayList<>());
                    } else {
                        prevLevel = level;
                        list = new ArrayList<>();
                    }
                    list.add(node.right.val);
                    map.put(distance, list);

                }
                if (node.left != null) {
                    queue.add(new DistanceOfNode(node.left, distance - 1));
                    ArrayList<Integer> list;
                    if (level == prevLevel) {
                        list = map.getOrDefault(distance - 1, new ArrayList<>());
                    } else {
                        prevLevel = level;
                        list = new ArrayList<>();
                    }
                    list.add(node.left.val);
                    map.put(distance - 1, list);
                }
            }
            prevLevel = level;
            level++;
        }

        return new ArrayList<>(map.values());

    }

}
