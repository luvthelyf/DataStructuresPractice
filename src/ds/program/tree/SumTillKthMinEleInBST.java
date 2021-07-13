package ds.program.tree;


public class SumTillKthMinEleInBST {
    private static class BSTNode {
        int val;
        BSTNode left;
        BSTNode right;

        BSTNode(int val) {
            this.val = val;
            left = null;
            right = null;
        }
    }

    int count = 0;
    int sum = 0;

    public static void main(String[] arg) {
        //for (int t = 0; t < T; t++) {

        SumTillKthMinEleInBST sumTillKthMinEleInBST = new SumTillKthMinEleInBST();
        BSTNode root = new BSTNode(8);
        root.left = new BSTNode(5);
        root.right = new BSTNode(11);

        root.left.left = new BSTNode(2);
        root.left.right = new BSTNode(7);
        root.left.left.right = new BSTNode(3);
        sumTillKthMinEleInBST.printInorder(root);
        sumTillKthMinEleInBST.sum = 0;
        sumTillKthMinEleInBST.count = 0;
        System.out.println();
        System.out.println("Case #" + (1) + ": " + sumTillKthMinEleInBST.sumKMin(root, 3));
        //  }
    }

    public void printInorder(BSTNode node) {
        if (node == null) return;

        printInorder(node.left);
        System.out.print(node.val + " ");
        printInorder(node.right);
    }

    //
//    public int sumKMin(BSTNode root, int k) {
//        if (root == null) return 0;
//
//        int sumLeft = sumKMin(root.left, k);
//        count++;
//        if (count <= k)
//            return sumLeft + root.val + sumKMin(root.right, k);
//
//        return sumLeft;
//    }

    public int sumKMin(BSTNode root, int k) {
        if (root == null) return 0;

        int sumLeft = sumKMin(root.left, k);
        count++;
        if (count < k) return sumLeft + root.val + sumKMin(root.right, k);
        else if (count == k) return sumLeft + root.val;
        else return sumLeft;
    }
}
