package ds.program.tree;

import java.util.*;

public class RightViewOfATree {

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

//    {1},{2,3},{5,6} HashMap<Integer, ArrayList<Integer>>

//                        1
//
//            2                   3
//                    5      6

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
//        root.left = new TreeNode(2);
//        root.right = new TreeNode(3);
//        root.left.left = new TreeNode(4);
//        root.left.right = new TreeNode(5);
//        root.left.right.left = new TreeNode(6);
//        root.left.right.left.right = new TreeNode(7);
//        root.left.right.left.right.left = new TreeNode(8);
        RightViewOfATree rightViewOfATree = new RightViewOfATree();
        System.out.println(rightViewOfATree.rightSideView(root));
        rightViewOfATree.printLeftView(root);
    }

    public List<Integer> rightViewOfATree(TreeNode root) {
        if (root == null) return null;
        List<Integer> list = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                TreeNode entry = queue.poll();
                if (entry == null) continue;
                if (i == size - 1) {
                    list.add(entry.val);
                }
                if (entry.left != null) queue.add(entry.left);
                if (entry.right != null) queue.add(entry.right);
            }
        }
        return list;
    }

    public List<Integer> levelOrderTraversal(TreeNode root) {
        if (root == null) return null;
        Map<Integer, ArrayList<Integer>> map = new HashMap<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int level = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                TreeNode entry = queue.poll();
                if (entry == null) continue;
                ArrayList<Integer> list = map.getOrDefault(level, new ArrayList<>());
                list.add(entry.val);
                map.put(level, list);

                if (entry.left != null) queue.add(entry.left);
                if (entry.right != null) queue.add(entry.right);
            }
            level++;
        }

        System.out.println(map.values());
        return null;
    }

    class QueueEntry {
        TreeNode node;
        int count;

        QueueEntry(TreeNode node, int count) {
            this.node = node;
            this.count = count;
        }
    }

    public List<Integer> rightSideView(TreeNode root) {
        if (root == null) return null;
        List<Integer> list = new ArrayList<>();
        Queue<QueueEntry> queue = new ArrayDeque<>();
        queue.add(new QueueEntry(root, 0));
        list.add(0, root.val);
        while (!queue.isEmpty()) {
            QueueEntry entry = queue.poll();
            TreeNode temp = entry.node;
            int count = entry.count;
            if (temp.left != null) {
                queue.add(new QueueEntry(temp.left, count + 1));
                if (list.size() > count + 1)
                    list.remove(count + 1);
                list.add(count + 1, temp.left.val);
            }
            if (temp.right != null) {
                queue.add(new QueueEntry(temp.right, count + 1));
                if (list.size() > count + 1)
                    list.remove(count + 1);
                list.add(count + 1, temp.right.val);
            }
        }
        return list;
    }




    private void printLeftView(TreeNode root) {
        if (root == null)
            return;
        Queue<TreeNode> que = new LinkedList<>();
        que.add(root);
        while (!que.isEmpty()) {
            int nodeSize = que.size();
            System.out.print(que.peek().val + " ");
            while (nodeSize > 0) {
                TreeNode temp = que.poll();
                if (temp.left != null) {
                    que.add(temp.left);
                }
                if (temp.right != null) {
                    que.add(temp.right);
                }
                nodeSize--;
            }
            System.out.println(" ");
        }
    }

}
