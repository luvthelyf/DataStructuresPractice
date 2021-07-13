package ds.program.tree;


/*
[1,2,3]
[-10,20,20,null,null,15,7]
[1,-2,3]
[-1,null,9,-6,3,null,null,null,-2]
[-10,9,20,null,null,15,7]



Given a non-empty binary tree, find the maximum path sum.

For this problem, a path is defined as any sequence of nodes from some starting node to any node in the tree along the parent-child connections. The path must contain at least one node and does not need to go through the root.

Example 1:

Input: [1,2,3]

       1
      / \
     2   3

Output: 6
Example 2:

Input: [-10,9,20,null,null,15,7]

   -10
   / \
  9  20
    /  \
   15   7

Output: 42
 */
public class BinaryTreeMaxPathSum {
    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val) {
            this.val = val;
        }
    }

    public static void main(String[] arg) {
        BinaryTreeMaxPathSum obj = new BinaryTreeMaxPathSum();
//        TreeNode root = new TreeNode(-10);
//        root.left = new TreeNode(9);
//        root.right = new TreeNode(20);
//        root.right.left = new TreeNode(15);
//        root.right.right = new TreeNode(7);
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(-2);
        root.right = new TreeNode(3);
        obj.maxPathSum(root);
        System.out.println(obj.maxPathSum(root));
    }

    int maxPathSum = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        maxPathSumUtil(root);
       return maxPathSum;
    }

    private int maxPathSumUtil(TreeNode root) {
        if (root == null) return 0;

        int left = Math.max(maxPathSumUtil(root.left), 0);
        int right = Math.max(maxPathSumUtil(root.right), 0);

        maxPathSum = Math.max(maxPathSum, root.val + left + right);
        maxPathSum = Math.max(maxPathSum, root.val);
        return Math.max(left, right) + root.val;
    }
}