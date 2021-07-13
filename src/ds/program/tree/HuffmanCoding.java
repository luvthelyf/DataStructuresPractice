package ds.program.tree;

import java.util.Comparator;
import java.util.PriorityQueue;

public class HuffmanCoding {

    private static class HuffmanNode {
        char c;
        int freq;
        HuffmanNode left;
        HuffmanNode right;

        public HuffmanNode(char c, int freq) {
            this.c = c;
            this.freq = freq;
            left = null;
            right = null;
        }

        public HuffmanNode(char c, int freq, HuffmanNode left, HuffmanNode right) {
            this.c = c;
            this.freq = freq;
            this.left = left;
            this.right = right;
        }
    }

    public static void main(String[] args) {
        HuffmanCoding coding = new HuffmanCoding();
        char[] chArr = {'a', 'b', 'c', 'd', 'e', 'f'};
        int[] freqArr = {5, 9, 12, 13, 16, 45};
        HuffmanNode root = coding.buildHuffmanTree(chArr, freqArr);
        coding.printHuffmanCodes(root, "");
    }

    private void printHuffmanCodes(HuffmanNode root, String s) {

        if (root.left == null && root.right == null && Character.isLetter(root.c)) {
            System.out.println(root.c + " : " + s);
            return;
        }
        if (root.left != null)
            printHuffmanCodes(root.left, s + "0");
        if (root.right != null)
            printHuffmanCodes(root.right, s + "1");
    }

    private HuffmanNode buildHuffmanTree(char[] chArr, int[] freqArr) {
        PriorityQueue<HuffmanNode> queue = new PriorityQueue<>(Comparator.comparingInt(t -> t.freq));
        for (int i = 0; i < chArr.length; i++) {
            queue.add(new HuffmanNode(chArr[i], freqArr[i]));
        }
        HuffmanNode root = null;
        while (queue.size() > 1) {
            HuffmanNode a = queue.poll();
            HuffmanNode b = queue.poll();
            HuffmanNode node = new HuffmanNode('-', a.freq + b.freq, a, b);
            root = node;
            queue.add(node);
        }
        return root;
    }
}
