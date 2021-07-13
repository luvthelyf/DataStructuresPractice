package ds.program.tree;

import java.util.TreeMap;

public class TopViewTreee {
    static class TreeNode {
        int data;
        TreeNode left;
        TreeNode right;

        TreeNode(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    static class LevelNode{
        TreeNode node;
        int depth;
        LevelNode(TreeNode node, int depth) {
            this.node = node;
            this.depth = depth;
        }

        @Override
        public String toString() {
            return ""+node.data;
        }
    }
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.right = new TreeNode(4);
        root.left.right.right = new TreeNode(5);
        root.left.right.right.right = new TreeNode(6);
//        root.right.right = new TreeNode(7);

        new TopViewTreee().topViewOfATree(root);
    }

    private void topViewOfATree(TreeNode root) {
        topViewOfATreeUtil(root, 0, 0);
        System.out.println(map.values());
    }

    TreeMap<Integer, LevelNode> map = new TreeMap<>();

    private void topViewOfATreeUtil(TreeNode root, int level, int depth) {

        if (!map.containsKey(level))
            map.put(level, new LevelNode(root, depth));
        else if(map.get(level).depth > depth) {
            map.put(level, new LevelNode(root, depth));
        }

        if (root.left != null)
            topViewOfATreeUtil(root.left, level - 1, depth + 1);
        if (root.right != null)
            topViewOfATreeUtil(root.right, level + 1, depth + 1);
    }
}
