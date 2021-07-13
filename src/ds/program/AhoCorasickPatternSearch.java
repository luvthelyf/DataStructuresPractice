package ds.program;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class AhoCorasickPatternSearch {

    static int MAXC = 26;
    static int[] out;

    static int[] f;

    static int[][] g;
    static int buildMatchingMachine(String[] arr, int k) {

        int totalLen = 0;

        for(String word : arr) {
            totalLen += word.length();
        }
        g = new int[totalLen][MAXC];
        out = new int[totalLen];
        f = new int[totalLen];
        Arrays.fill(out, 0);

        for (int i = 0; i < totalLen; i++)
            Arrays.fill(g[i], -1);

        int states = 1;

        for (int i = 0; i < k; ++i) {
            String word = arr[i];
            int currentState = 0;
            for (int j = 0; j < word.length(); ++j) {
                int ch = word.charAt(j) - 'a';

                if (g[currentState][ch] == -1)
                    g[currentState][ch] = states++;

                currentState = g[currentState][ch];
            }
            out[currentState] |= (1 << i);
        }

        for (int ch = 0; ch < MAXC; ++ch)
            if (g[0][ch] == -1)
                g[0][ch] = 0;

        Arrays.fill(f, -1);

        Queue<Integer> q = new LinkedList<>();

        for (int ch = 0; ch < MAXC; ++ch) {

            if (g[0][ch] != 0) {
                f[g[0][ch]] = 0;
                q.add(g[0][ch]);
            }
        }
        while (!q.isEmpty()) {
            int state = q.peek();
            q.remove();
            for (int ch = 0; ch < MAXC; ++ch) {
                if (g[state][ch] != -1) {

                    int failure = f[state];

                    while (g[failure][ch] == -1)
                        failure = f[failure];

                    failure = g[failure][ch];
                    f[g[state][ch]] = failure;

                    out[g[state][ch]] |= out[failure];

                    q.add(g[state][ch]);
                }
            }
        }
        return states;
    }

    static int findNextState(int currentState, char nextInput) {
        int answer = currentState;
        int ch = nextInput - 'a';

        while (g[answer][ch] == -1)
            answer = f[answer];

        return g[answer][ch];
    }

    static void searchWords(String arr[], int k,
                            String text) {

        System.out.println(buildMatchingMachine(arr, k));
        int currentState = 0;
        for (int i = 0; i < text.length(); ++i) {
            currentState = findNextState(currentState, text.charAt(i));
            if (out[currentState] == 0)
                continue;

            for (int j = 0; j < k; ++j) {
                if ((out[currentState] & (1 << j)) > 0) {
                    System.out.print("Word " + arr[j] +
                            " appears from " +
                            (i - arr[j].length() + 1) +
                            " to " + i + "\n");
                }
            }
        }
    }

    public static void main(String[] args) {
        String arr[] = {"he", "she", "hers", "his"};
        String text = "ahishers";
        int k = arr.length;

        searchWords(arr, k, text);
    }
}
