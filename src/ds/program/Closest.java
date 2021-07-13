package ds.program;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Closest {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(2);
        root.right = new TreeNode(5);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);
        System.out.println(new Closest().closestKValues(root, 3.714286, 2));
    }
    private static class TreeNode {
        TreeNode left;
        TreeNode right;
        int val;

        TreeNode(int val) {
            this.val = val;
        }
    }

    public void inorder(TreeNode root, List<Integer> nums) {
        if (root == null) return;
        inorder(root.left, nums);
        nums.add(root.val);
        inorder(root.right, nums);
    }

    public List<Integer> closestKValues(TreeNode root, double target, int k) {
        List<Integer> nums = new ArrayList<>();
        inorder(root, nums);

        System.out.println(nums);
        nums.sort(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
//                System.out.println((o1 - target) + " : " +(o2 - target));
                return Math.abs(o1 - target) < Math.abs(o2 - target) ? -1 : 1;
            }
        });
        System.out.println(nums);
        return nums.subList(0, k);
    }
}
