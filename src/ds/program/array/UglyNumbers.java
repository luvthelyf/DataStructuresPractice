package ds.program.array;

public class UglyNumbers {

    //        StringBuffer sb1 = new StringBuffer("Amit");
//        StringBuffer sb2 = new StringBuffer("Amit");
//        String ss1 = "Amit";
//        System.out.println(sb1==sb2);
//        System.out.println(sb1.equals(sb2));
//        System.out.println(sb1.equals(ss1));
//        System.out.println("Poddar".substring(3));
//        String s = "Hello  ";
//        s+= "Adobe  ";
//        s.trim();
//        System.out.println(s);
    private int findNthUglyNumber(int n) {
        if (n == 0) return 0;
        int[] arr = new int[n];
        int i = 0, j = 0, k = 0;
        arr[0] = 1;
        for (int m = 1; m < n; m++) {
            int t1 = 2 * arr[i];
            int t2 = 3 * arr[j];
            int t3 = 7 * arr[k];
            int nextTerm = Math.min(t1, Math.min(t2, t3));
            arr[m] = nextTerm;
            if (nextTerm == t1) i++;
            if (nextTerm == t2) j++;
            if (nextTerm == t3) k++;
        }
        return arr[n - 1];
    }

    public static void main(String[] args) {
        System.out.println((new UglyNumbers()).findNthUglyNumber(5));
    }
}
