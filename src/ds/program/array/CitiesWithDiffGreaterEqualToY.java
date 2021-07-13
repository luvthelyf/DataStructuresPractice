package ds.program.array;

import java.util.Arrays;
import java.util.Scanner;

public class CitiesWithDiffGreaterEqualToY {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
//
//        String s1 = " yes";
//        String s2 = " yes ";
//        String s3 = new String( s1);
//        System.out.println("14"+5+3);
////
//        System.out.println("asd "+(s1 == s3));
        for (int t = 0; t < T; t++) {

            int N = sc.nextInt();
            int Y = sc.nextInt();
            int arr[] = new int[N];

            for (int i = 0; i < N; i++) {
                arr[i] = sc.nextInt();
            }

            System.out.println(calculateMaxNumberOfPairs(N, Y, arr));
        }
    }

    private static int calculateMaxNumberOfPairs(int N, int Y, int[] arr) {
            int count = 0;
            Arrays.sort(arr);
            int l = 0;
            int r = 0;
            while (r < N) {
                if (arr[r] - arr[l] >= Y) {
                    count++;
                    l++;
                }
                r++;
            }
            return count;
    }

    //
//    abstract class ParkingType {
//        abstract boolean getNode();
//    }
//
//    class DefaultParkingType extends ParkingType {
//        @Override
//        boolean getNode() {
//            return false;
//        }
//    }
//
//    class SomeParkingType extends ParkingType {
//        @Override
//        boolean getNode() {
//            return true;
//        }
//    }
//
//
//    class ParkingFloor {
//        private HashMap<String, ParkingType> map;
//
//        public void getFloor() throws ParkingFullException {
//            map = new HashMap<>();
//            map.put("1", new SomeParkingType());
//            map.put("2", new DefaultParkingType());
//            throw new ParkingFullException("parking full");
//        }
//    }
//
//    static class ParkingFullException extends Exception {
//
//        public ParkingFullException(String parking_full) {
//
//        }
//    }
}

