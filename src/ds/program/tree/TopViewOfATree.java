package ds.program.tree;

import java.util.*;

public class TopViewOfATree {
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

    //45

    public static void main(String[] args) {

        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(2);
        root.right.right = new TreeNode(5);
        root.right.right.right = new TreeNode(6);
        root.right.right.left = new TreeNode(3);
        root.right.right.left.right = new TreeNode(4);
//        root.right.left.left = new TreeNode(7);
//        root.right.left.right = new TreeNode(8);

        List<Integer> ans = (new TopViewOfATree()).topViewOfATree(root);
        System.out.println(ans);
    }

    private static class LevelOfNode {
        TreeNode node;
        int level;
        public LevelOfNode(TreeNode node, int level) {
            this.node = node;
            this.level = level;
        }
    }

//                          1
//                 /               \
//


//
//                        1(0)
//
//            2(-1)                   3(1)
//                    5(0)      6(0)

    //      2 1 3

    public List<Integer> topViewOfATree(TreeNode root) {
        Map<Integer, Integer> map = new TreeMap<>();
        Queue<LevelOfNode> queue = new LinkedList<>();

        map.put(0, root.val);
        queue.add(new LevelOfNode(root, 0));

        while (!queue.isEmpty()) {
            int size = queue.size();
            for(int i = 0; i < size; i++) {
                LevelOfNode temp = queue.remove();
                TreeNode node = temp.node;
                int level = temp.level;
                if(node.left != null) {
                    queue.add(new LevelOfNode(node.left, level - 1));
                    if(!map.containsKey(level - 1)) {
                        map.put(level - 1, node.left.val);
                    }
                }
                if(node.right != null) {
                    queue.add(new LevelOfNode(node.right, level + 1));
                    if(!map.containsKey(level + 1)) {
                        map.put(level + 1, node.right.val);
                    }
                }
            }
        }
        for( Integer val : map.values()) {
            System.out.print(val + " ");
        }
        System.out.println();
        return new ArrayList<>(map.values());
    }
}
