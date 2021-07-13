package ds.program.microsoft;


import java.util.*;

public class ZigzagLevelOrderTraversalOfTree {
    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val) {
            this.val = val;
            left = null;
            right = null;
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);
//        root.left = new TreeNode(2);
//        root.left.left = new TreeNode(1);
//        root.right = new TreeNode(4);
//        root.right.right = new TreeNode(5);

        System.out.println((new ZigzagLevelOrderTraversalOfTree()).zigzagLevelOrder(root));

    }

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        if (root == null) return new ArrayList<>();
        int count = 0;
        List<List<Integer>> result = new ArrayList<>();
        Deque<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int len = queue.size();
            List<Integer> out = new ArrayList<>();

            for (int i = 0; i < len; i++) {
                if (count % 2 == 0) {
                    TreeNode node = queue.removeFirst();
                    out.add(node.val);

                    if (node.left != null)
                        queue.addLast(node.left);
                    if (node.right != null)
                        queue.addLast(node.right);
                } else {
                    TreeNode node = queue.removeLast();
                    out.add(node.val);

                    if (node.right != null)
                        queue.addFirst(node.right);
                    if (node.left != null)
                        queue.addFirst(node.left);
                }
            }
            count++;
            result.add(out);
        }
        return result;
    }
}
