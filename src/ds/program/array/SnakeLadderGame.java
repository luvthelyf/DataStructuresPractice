package ds.program.array;

import java.util.ArrayDeque;
import java.util.Queue;

public class SnakeLadderGame {
    public static void main(String[] args) {
        int N = 30;
        int moves[] = new int[N];
        for (int i = 0; i < N; i++)
            moves[i] = -1;

        // Ladders
        moves[2] = 21;
        moves[4] = 7;
        moves[10] = 25;
        moves[19] = 28;

        // Snakes
        moves[26] = 0;
        moves[20] = 8;
        moves[16] = 3;
        moves[18] = 6;

        System.out.println("Min Dice throws required is " +
                (new SnakeLadderGame().getMinDiceThrows(moves, N)));
    }

    class SnakeLadderEntry {
        int distance;
        int vertexNumber;
    }

    private int getMinDiceThrows(int[] moves, int n) {
        boolean[] visited = new boolean[n];
        Queue<SnakeLadderEntry> queue = new ArrayDeque<>();
        SnakeLadderEntry entry = new SnakeLadderEntry();
        entry.distance = 0;
        entry.vertexNumber = 0;
        visited[0] = true;
        queue.add(entry);

        while (!queue.isEmpty()) {
            entry = queue.poll();
            int vertex = entry.vertexNumber;

            if (vertex == n - 1) return entry.distance;
            for (int i = vertex + 1; i <= vertex + 6 && i < n; i++) {
                if (!visited[i]) {
                    visited[i] = true;

                    SnakeLadderEntry nextEntry = new SnakeLadderEntry();
                    nextEntry.distance = entry.distance + 1;

                    if (moves[i] != -1) {
                        nextEntry.vertexNumber = moves[i];
                    } else {
                        nextEntry.vertexNumber = i;
                    }

                    queue.add(nextEntry);
                }
            }

        }

        return -1;
    }
}
