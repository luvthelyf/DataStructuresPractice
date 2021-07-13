package ds.program.tree;

public class DiameterOfATree {
    private class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
    }

    public int diameterOfBinaryTree(TreeNode root) {
        if(root == null) return 0;
        return diameterOfBinaryTreeInternal(root, new Height()) - 1;
    }
    class Height {
        int h;
    }

    public int diameterOfBinaryTreeInternal(TreeNode root,Height currentHeight) {

        if (root == null) {
            currentHeight.h = 0;
            return 0;
        }
        Height leftMaxHeight = new Height();
        Height rightMaxHeight = new Height();


        int leftMaxPathLength = diameterOfBinaryTreeInternal(root.left, leftMaxHeight);
        int rightMaxPathLength = diameterOfBinaryTreeInternal(root.right, rightMaxHeight);

        currentHeight.h = Math.max(leftMaxHeight.h, rightMaxHeight.h) + 1;

        return Math.max(leftMaxHeight.h + rightMaxHeight.h + 1, Math.max(leftMaxPathLength, rightMaxPathLength));

    }

    // ******************************************************************************/
    int maxPathLen = 0;
    public int diameterOfBinaryTreeWithoutHeightClass(TreeNode root) {
        if(root == null) return 0;
        diameterOfBinaryTreeUtil(root);
        return maxPathLen - 1;
    }

    public int diameterOfBinaryTreeUtil(TreeNode root) {
        if(root == null) return 0;
        int left = diameterOfBinaryTreeUtil(root.left);
        int right = diameterOfBinaryTreeUtil(root.right);

        if(maxPathLen < left + right + 1) {
            maxPathLen = left + right + 1;
        }

        return Math.max(left, right) + 1;
    }
    // ******************************************************************************/

}
