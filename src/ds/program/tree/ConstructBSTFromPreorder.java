package ds.program.tree;


import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;

public class ConstructBSTFromPreorder {
    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val) {
            this.val = val;
            left = null;
            right = null;
        }
    }

    public static void main(String[] arg) {
//        Scanner sc = new Scanner(System.in);
//        int T = sc.nextInt();
//        for (int t = 0; t < T; t++) {
//            int n = sc.nextInt();
//            int[] arr = new int[n];
//            for (int i = 0; i < n; i++) {
//                arr[i] = sc.nextInt();
//            }
        int arr[] = {8, 5, 1, 7, 10, 12};

        System.out.println("Case #" + (1) + ": " + (new ConstructBSTFromPreorder()).bstFromPreorder(arr));
//        }
    }

    Queue<Integer> queue = new ArrayDeque<>();

    public TreeNode bstFromPreorder(int preorder[]) {
        if(preorder.length == 0) return null;
        TreeNode root = new TreeNode(preorder[0]);
        for (int i = 1; i < preorder.length; i++) {
            insert(root, preorder[i]);
        }
        return root;
    }

    private TreeNode insert(TreeNode root, int x) {
        if (root == null) return new TreeNode(x);
        if (x < root.val)
            root.left = insert(root.left, x);
        else
            root.right = insert(root.right, x);

        return root;
    }
}