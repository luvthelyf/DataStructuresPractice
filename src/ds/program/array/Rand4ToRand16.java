package ds.program.array;

import java.util.Random;

public class Rand4ToRand16 {

//    Random random = new Random();
//
//    int rand4() {
//        return random.nextInt(4);
//    }
//
//    public static void main(String[] args) {
//        Rand4ToRand16 obj = new Rand4ToRand16();
//        obj.rand16();
//    }
//
//    int rand16() {
//        int[][] val = {
//                {1, 2, 3, 4},
//                {5, 6, 7, 8},
//                {9, 10, 11, 12},
//                {13, 14, 15, 16}
//        };
//
//        int count = 0;
//        int v = 0;
//        int arr[] = new int[17];
//        while (count++ <= 5000000) {
//            int x = rand4();
//            int y = rand4();
//            v = val[x][y];
//            arr[v]++;
//            //System.out.println(v);
//        }
//
//        for (int i = 0; i < arr.length; i++) {
//            System.out.print((arr[i]) + " ");
//        }
//        System.out.println();
//        return v;
//    }
/*    static Random random = new Random();

    static int rand4() {
        return random.nextInt(4);
    }

    public static void main(String[] args) {
        generateNumbers();
    }

    static void generateNumbers() {
        int[] arr = new int[17];
        for (int i = 0; i < 100; i++) {
            int num = rand4();
            if (num != 0) {
                int res = num % 4 + 4 * (num - 1);
                arr[res]++;
                System.out.println(res);
            }
        }
        for (int i = 0; i < arr.length; i++) {
            System.out.print((arr[i]/arr.length ) + " ");
        }
        System.out.println();
    }*/
    static Random random = new Random();
    static int rand4() {
        return random.nextInt(5);
    }
    public static void main(String[] args) {
        generateNumbers();
    }
    static void generateNumbers() {
        int[] arr = new int[17];
        for (int i=0; i<500000; i++) {
            int num = rand4();
            if (rand4() != 0) {
                int res = rand4() + 4*(rand4()-1);
                if (res>0) {
                    arr[res]++;
                    //System.out.print(res+" ");
                }
            }
        }
        for (int i = 0; i < arr.length; i++) {
            System.out.print((arr[i] ) + " ");
        }
        System.out.println();
    }
}

