package ds.program.microsoft;

public class LowestCommonAncestor {
    private static class TreeNode {
        TreeNode left;
        TreeNode right;
        int val;
        TreeNode(int val) {
            this.val = val;
        }
    }
    TreeNode ans;

//                                  3
//                      5                       1
//              6               2        0               8
//                      7            4
//
//
//
//
//
//
//
//
//
//
//
//
//
    public static void main(String[] args) {
        // 3,5,1,6,2,0,8,null,null,7,4
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(5);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(6);
        root.left.right = new TreeNode(2);
        root.right.left = new TreeNode(0);
        root.right.right = new TreeNode(8);
        root.left.right.left = new TreeNode(7);
        root.left.right.right = new TreeNode(4);

        System.out.println((new LowestCommonAncestor()).lowestCommonAncestor(root, new TreeNode(5), new TreeNode(4)).val);

    }
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        return findLCS(root, p, q);
//        return ans;
    }

    public TreeNode findLCS(TreeNode root, TreeNode p, TreeNode q) {

        if(root == null) return null;

        if(root.val == p.val || root.val == q.val) return root;
        TreeNode left = findLCS(root.left, p, q);
        TreeNode right = findLCS(root.right, p, q);

        if(left != null && right != null) return root;

        return left != null ? left : right;
//    }
//    public boolean findLCS(TreeNode root, TreeNode p, TreeNode q) {
//
//        if(root == null) return false;
//
//        boolean left = findLCS(root.left, p, q);
//        boolean right = findLCS(root.right, p, q);
//        boolean mid = (p.val == root.val || q.val == root.val);
//
//        System.out.println(left + " "+mid + " "+right);
//        if(mid && left || mid && right || left && right) ans = root;
//
//        return (mid || left || right);
    }
}
