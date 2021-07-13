package ds.program.array;

public class FIndTownJudge {
    public static void main(String[] arg) {
//        Scanner sc = new Scanner(System.in);
        //int T = sc.nextInt();
//        for (int t = 0; t < T; t++) {
//        int n = 4;
//        int[][] arr = {{1, 3}, {1, 4}, {2, 3}, {2, 4}, {4, 3}};
//        int n = 4;
//        int[][] arr = {{1, 3}, {2, 3}, {3, 1}};
        int n = 3;
        int[][] arr = {{1, 2}, {2, 3}};


        FIndTownJudge obj = new FIndTownJudge();
        System.out.println(obj.findJudge(n, arr));
//        }
    }

//    public int findJudge(int N, int[][] trust) {
//        int[] inDegree = new int[N + 1];
//        int[] outDegree = new int[N + 1];
//
//        for (int i = 0; i < trust.length; i++) {
//            outDegree[trust[i][0]]++;
//            inDegree[trust[i][1]]++;
//        }
//
//        for (int i = 1; i <= N; i++) {
//            if (inDegree[i] == N - 1 && outDegree[i] == 0) return i;
//        }
//        return -1;
//    }
public int findJudge(int N, int[][] trust) {
    boolean[] trusted = new boolean[N + 1];
    int[] beTrusted = new int[N + 1];


    for (int[] t : trust) {
        trusted[t[0]] = true;
        beTrusted[t[1]]++;
    }

    // judge trusted is false && beTrusted with others
    for (int i = 1; i <= N; i++) {
        if (!trusted[i] && beTrusted[i] == N - 1) {
            return i;
        }
    }
    return -1;
}
}
