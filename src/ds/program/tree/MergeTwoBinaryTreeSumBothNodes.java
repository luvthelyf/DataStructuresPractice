package ds.program.tree;

public class MergeTwoBinaryTreeSumBothNodes {
    private static class TreeNode {
        int value;
        TreeNode left;
        TreeNode right;

        public TreeNode(int value) {
            this.value = value;
            this.left = left;
            this.right = right;
        }
    }

    public static void main(String[] args) {
        TreeNode root1 = new TreeNode(1);
        root1.left = new TreeNode(3);
        root1.right = new TreeNode(2);
        root1.left.left = new TreeNode(5);

        TreeNode root2 = new TreeNode(2);
        root2.left = new TreeNode(1);
        root2.right = new TreeNode(3);
        root2.left.right = new TreeNode(4);
        root2.right.right = new TreeNode(7);

//
//        TreeNode root1 = new TreeNode(1);
//        root1.left = new TreeNode(2);
//        root1.right = new TreeNode(3);
//        root1.left.left = new TreeNode(4);
//        root1.left.right = new TreeNode(5);
//        root1.right.right = new TreeNode(6);
//
//         /* Let us construct the second Binary Tree
//                4
//              /   \
//             1     7
//            /     /  \
//           3     2    6   */
//        TreeNode root2 = new TreeNode(4);
//        root2.left = new TreeNode(1);
//        root2.right = new TreeNode(7);
//        root2.left.left = new TreeNode(3);
//        root2.right.left = new TreeNode(2);
//        root2.right.right = new TreeNode(6);

        TreeNode root3 = mergeTrees(root1, root2);
        System.out.println("The Merged Binary Tree is:");
        inorder(root3);
        System.out.println("\n**************************************************");
        preOrder(root3);
    }

    static void inorder(TreeNode node) {
        if (node == null)
            return;
        inorder(node.left);
        System.out.printf("%d ", node.value);
        inorder(node.right);
    }

    static void preOrder(TreeNode node) {
        if (node == null)
            return;
        System.out.printf("%d ", node.value);
        preOrder(node.left);
        preOrder(node.right);
    }

    static TreeNode root3 = null;

    private static TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        root3 = mergeTreesUtil(root1, root2);
        return root3;
    }

    private static TreeNode mergeTreesUtil(TreeNode root1, TreeNode root2) {
        if (root1 == null && root2 == null) return null;

        if (root1 == null) {
            TreeNode tempNode = new TreeNode(root2.value);
            tempNode.left = mergeTreesUtil(null, root2.left);
            tempNode.right = mergeTreesUtil(null, root2.right);
            return tempNode;
        }
        if (root2 == null) {
            TreeNode tempNode = new TreeNode(root1.value);
            tempNode.left = mergeTreesUtil(root1.left, null);
            tempNode.right = mergeTreesUtil(root1.right, null);
            return tempNode;
        }

        TreeNode newNode = new TreeNode(root1.value + root2.value); // 5


        newNode.left = mergeTreesUtil(root1.left, root2.left);
        newNode.right = mergeTreesUtil(root1.right, root2.right); // (null, 7)

        return newNode;
    }

}
