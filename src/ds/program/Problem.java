package ds.program;


import java.util.*;
// what about string is empty or null
// characters range a-z or other special character
// repeating characters
// length of string.

public class Problem {
    public static void main(String[] args) {
        Problem p = new Problem();


//        System.out.println(Arrays.toString(p.getNewHeightAndWidth(200, 200, 400, 400)));
//        System.out.println(Arrays.toString(p.getNewHeightAndWidth(200, 200, 200, 400)));
//        System.out.println(Arrays.toString(p.getNewHeightAndWidth(200, 200, 400, 200)));
//        System.out.println(Arrays.toString(p.getNewHeightAndWidth(400, 600, 600, 400)));
//        System.out.println(Arrays.toString(p.getNewHeightAndWidth(400, 600, 300, 700)));
//        System.out.println(Arrays.toString(p.getNewHeightAndWidth(400, 600, 400, 400)));
//        System.out.println(Arrays.toString(p.getNewHeightAndWidth(600, 400, 700, 350)));
//        System.out.println(Arrays.toString(p.getNewHeightAndWidth(600, 400, 230, 700)));
//        System.out.println(Arrays.toString(p.getNewHeightAndWidth(600, 400, 800, 800)));

//        char[][] mat = new char[][]{
//                {'1', '2', '0', '4'},
//                {'2', '3', '1', '2'},
//                {'3', '0', '2', '4'},
//                {'1', '2', '4', '3'}
//        };
//        p.convertToX(mat);

//        System.out.println(p.flowerBlossom(new int[]{1, 3, 2}, 1));
//        System.out.println(p.flowerBlossom(new int[]{3, 1, 2}, 1));
//        System.out.println(p.flowerBlossom(new int[]{1, 2, 3}, 1));
//        System.out.println(p.openLock(new String[]{"0201", "0101", "0102", "1212", "2002"}, "0202"));


//        ListNode head = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(3, new ListNode(4, new ListNode(4, new ListNode(5)))))));
//        ListNode head = new ListNode(1, new ListNode(1, new ListNode(1, new ListNode(2, new ListNode(3)))));
//        ListNode head = new ListNode(1, new ListNode(2, new ListNode(2)));
//
//        printLinkedList((p.deleteDuplicates(head)));

        System.out.println(p.specialString("aaba"));
        System.out.println(p.specialString("aababc"));
        System.out.println(p.specialString("abcdefgh"));
        System.out.println(p.specialString("hgfedcba"));
        System.out.println(p.specialString("cadb"));
        System.out.println(p.specialMatrix(new int[][]{
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        }));
    }

    public int specialMatrix(int[][] matrix) {
        int p = 0;
        int count = 0;
        boolean[] arr = new boolean[1011];
        while (p <= 1011) {
            arr[p] = true;
            count++;
            p += count;
        }
        int ans = Integer.MAX_VALUE;
        // row
        for (int i = 0; i < matrix.length; i++) {
            int changes = 0;
            for (int j = 0; j < matrix[0].length; j++) {
                int element = matrix[i][j];
                int index = 0;
                while (element - index >= 0 && element + index <= 1011 && !arr[element - index] && !arr[element + index]) {
                    index++;
                }
                changes += index;
            }
            ans = Math.min(ans, changes);
        }

        // col
        for (int j = 0; j < matrix[0].length; j++) {
            int changes = 0;
            for (int i = 0; i < matrix.length; i++) {
                int element = matrix[i][j];
                int index = 1;
                while (element - index >= 0 && element + index <= 1011 && !arr[element - index] && !arr[element + index]) {
                    index++;
                }
                changes += index;
            }
            ans = Math.min(ans, changes);
        }
        return ans;
    }

    public int specialString(String str) {
        HashMap<Character, Integer> left = new HashMap<>();
        HashMap<Character, Integer> right = new HashMap<>();
        int len = str.length();

        char maxLeft = 'a';
        char maxRight = 'a';

        for (int i = 0; i < len / 2; i++) {
            char c = str.charAt(i);
            left.put(c, left.getOrDefault(c, 0) + 1);
            if (maxLeft < c) {
                maxLeft = c;
            }
        }

        for (int i = len / 2; i < len; i++) {
            char c = str.charAt(i);
            right.put(c, right.getOrDefault(c, 0) + 1);
            if (maxRight < c) {
                maxRight = c;
            }
        }
        // =
        int ans = Integer.MAX_VALUE;
        for (char c = 'a'; c <= 'z'; c++) {
            int count = left.getOrDefault(c, 0) + right.getOrDefault(c, 0);
            ans = Math.min(ans, len - count);
        }

        // >
        int count = len / 2;
        for (char c = 'a'; c <= 'z'; c++) {
            if (left.containsKey(c) && c > maxRight) {
                count -= left.get(c);
            }
        }
        ans = Math.min(ans, count);

        // <
        count = len / 2;
        for (char c = 'a'; c <= 'z'; c++) {
            if (right.containsKey(c) && c > maxLeft) {
                count -= right.get(c);
            }
        }
        ans = Math.min(ans, count);
        return ans;
    }

    private LinkedList<Integer> adj[];
    private int V;

    Boolean isCyclicUtil(int v,
                         Boolean visited[], int parent) {
        visited[v] = true;
        Integer i;
        Iterator<Integer> it = adj[v].iterator();
        while (it.hasNext()) {
            i = it.next();
            if (!visited[i]) {
                if (isCyclicUtil(i, visited, v))
                    return true;
            } else if (i != parent)
                return true;
        }
        return false;
    }

    boolean isCyclic() {
        Boolean visited[] = new Boolean[V];
        for (int i = 0; i < V; i++)
            visited[i] = false;
        for (int u = 0; u < V; u++) {
            if (!visited[u])
                if (isCyclicUtil(u, visited, -1))
                    return true;
        }
        return false;
    }


    private static void printLinkedList(ListNode head) {
        ListNode temp = head;

        while (temp != null) {
            System.out.print(temp.val + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    private int[] getNewHeightAndWidth(int cw, int ch, int iw, int ih) {
        if (cw >= iw && ch >= ih) return new int[]{iw, ih};
        float wr = (float) cw / iw;
        float hr = (float) ch / ih;

        int newH = ch, newW = cw;

        if (wr < hr) {
            if (hr != 1) {
                wr = wr / hr;
                hr = 1;
                newW = (int) (cw * hr);
            }
            newH = (int) (ch * wr);
        } else if (wr > hr) {
            if (wr != 1) {
                hr = hr / wr;
                wr = 1;
                newH = (int) (ch * wr);
            }
            newW = (int) (cw * hr);
        }

        return new int[]{newW, newH};


    }


    public void convertToX(char[][] mat) {
        boolean colZero = false;
        boolean rowZero = false;
        for (int i = 0; i < mat.length; i++) {
            if (mat[i][0] == '0') {
                colZero = true;
                break;
            }
        }
        for (int j = 0; j < mat[0].length; j++) {
            if (mat[0][j] == '0') {
                rowZero = true;
                break;
            }
        }
        for (int i = 1; i < mat.length; i++) {
            for (int j = 1; j < mat[0].length; j++) {
                if (mat[i][j] == '0') {
                    mat[0][j] = mat[i][0] = 'X';
                }
            }
        }
        for (int i = 1; i < mat.length; i++) {
            for (int j = 1; j < mat[0].length; j++) {
                if (mat[0][j] == '0' || mat[i][0] == '0' || mat[0][j] == 'X' || mat[i][0] == 'X') {
                    mat[i][j] = 'X';
                }
            }
        }
        for (int i = 0; rowZero && i < mat[0].length; i++) {
            mat[0][i] = 'X';
        }

        for (int i = 0; colZero && i < mat.length; i++) {
            mat[i][0] = 'X';
        }

        for (int i = 0; i < mat.length; i++) {
            System.out.println();
            for (int j = 0; j < mat[0].length; j++) {
                System.out.print(mat[i][j] + " ");
            }
        }
        System.out.println();
    }

    private static class ListNode {
        int val;

        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }

        @Override
        public String toString() {
            return val + "";
        }
    }

    public ListNode deleteDuplicates(ListNode head) {
        HashMap<Integer, ListNode> map = new HashMap<>();

        ListNode prev = null;
        ListNode next = head;
        ListNode duplicate = null;

        while (next != null) {
            System.out.println(prev + " : " + next + " : " + duplicate);
            printLinkedList(head);
            if (map.containsKey(next.val)) {
                duplicate = next;
                if (prev != null) {
                    prev.next = next.next;
                    next.next = null;
                    next = prev.next;
                }
            } else {
                if (duplicate != null) {
                    ListNode parent = map.get(duplicate.val);
                    map.remove(duplicate.val);
                    if (parent == null) {
                        head = next;
                    } else {
                        parent.next = next;
                    }
                    System.out.println("** parent " + parent + " : " + next.val);
                    map.put(next.val, parent);
                } else {
                    map.put(next.val, prev);
                }
                prev = next;
                next = next.next;
                duplicate = null;
            }

            System.out.println(prev + " : " + next + " : " + duplicate);
            printLinkedList(head);
            System.out.println("********************************");
        }
        if (duplicate != null) {
            ListNode parent = map.get(duplicate.val);
            map.remove(duplicate.val);
            if (parent == null) {
                head = null;
            } else {
                parent.next = null;
            }
        }

        return head;
    }

    public int flowerBlossom(int[] flowers, int k) {
        boolean[] arr = new boolean[flowers.length + 1];

        for (int i = 0; i < flowers.length; i++) {
            int val = flowers[i] - 1;
            arr[val] = true;

            int leftIndex = val - k - 1;
            int rightIndex = val + k + 1;
            if (leftIndex >= 0 && arr[leftIndex]) {

                boolean isAnyBlossom = false;
                for (int j = leftIndex + 1; j < val; j++) {
                    if (arr[j]) {
                        isAnyBlossom = true;
                        break;
                    }
                }
                if (!isAnyBlossom)
                    return i + 1;
            } else if (rightIndex < flowers.length && arr[rightIndex]) {

                boolean isAnyBlossom = false;
                for (int j = val + 1; j < rightIndex; j++) {
                    if (arr[j]) {
                        isAnyBlossom = true;
                        break;
                    }
                }
                if (!isAnyBlossom)
                    return i + 1;
            }
        }
        return -1;
    }


    public int openLock(String[] deadends, String target) {
/*
["0201","0101","0102","1212","2002"]
"0202"
["8888"]
"0009"
["8887","8889","8878","8898","8788","8988","7888","9888"]
"8888"
["0000"]
"8888"
["0201","0101","0102","1212","2002"]
"0000"
        * */


        HashSet<String> visited = new HashSet<>();

        HashSet<String> set = new HashSet<>(Arrays.asList(deadends));

        String start = "0000";

        if (set.contains(start)) return -1;

        Queue<String> q = new LinkedList<>();
        int count = 0;

        q.add(start);
        visited.add(start);

        while (!q.isEmpty()) {
            int size = q.size();

            for (int i = 0; i < size; i++) {
                StringBuilder ele = new StringBuilder(q.remove());

                for (int j = 0; j < 4; j++) {
                    char temp = ele.charAt(j);
                    for (int k = -1; k <= 1; k += 2) {
                        int newChar = (Integer.parseInt(temp + "") + k + 10) % 10;
                        ele.setCharAt(j, (newChar + "").charAt(0));
                        String newPattern = ele.toString();
                        if (newPattern.equals(target)) return count + 1;
                        if (!visited.contains(newPattern) && !set.contains(newPattern)) {
                            visited.add(newPattern);
                            q.add(newPattern);
                        }
                        ele.setCharAt(j, temp);
                    }
                }
            }
            count++;
        }
        return -1;
    }

}
