package ds.program.tree;

/*
[0,1,0,0,1,0,null,null,1,0,0]
[0,1,0,1]
[1,8,9,null,7,6,5]
[1,9,6]
[2,9,3,null,1,null,2,null,8]
[2,9,1,8,0]

 */

public class StringValidSeqFromRootToLeaf {
    static private class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val) {
            this.val = val;
        }
    }

    public boolean isValidSequence(TreeNode root, int[] arr) {
        if (root == null) return false;
        return checkSequence(root, arr, 0);

    }

    private boolean checkSequence(TreeNode root, int[] arr, int i) {
        if (i == arr.length || root == null) return false;
        else if (root.left == null && root.right == null
                && root.val == arr[i] && i == arr.length - 1)
            return true;
        else
            return (root.val == arr[i]) && (checkSequence(root.left, arr, i + 1) || checkSequence(root.right, arr, i + 1));

    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(0);
        root.left = new TreeNode(1);
        root.right = new TreeNode(0);
        root.left.left = new TreeNode(0);
        root.left.right = new TreeNode(1);
        root.right.left = new TreeNode(0);
        root.left.left.right = new TreeNode(1);
        root.left.right.left = new TreeNode(0);
        root.left.right.right = new TreeNode(0);

        int[] arr = {0, 1, 0, 1};
        StringValidSeqFromRootToLeaf obj = new StringValidSeqFromRootToLeaf();
        System.out.println(obj.isValidSequence(root, arr));
    }
}
