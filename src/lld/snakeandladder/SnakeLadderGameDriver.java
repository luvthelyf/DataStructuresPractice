package lld.snakeandladder;

import lld.snakeandladder.model.Ladder;
import lld.snakeandladder.model.Player;
import lld.snakeandladder.model.Snakes;
import lld.snakeandladder.services.BoardService;

import java.util.ArrayList;
import java.util.List;

public class SnakeLadderGameDriver {
    public static void main(String[] args) {
        String[] playersName = {"Sandeep", "Sandy", "Gupta", "Baghira"};
        int[][] snakesPos = new int[][]{{11, 5},{17, 5}/*, {33, 7}, {39, 20}, {99, 3}, {95, 67}*/};
        int[][] ladderPos = new int[][]{/*{6, 25}, {28, 54}, {64, 86}*/{2, 5},{8, 16}};

        List<Player> players = new ArrayList<>();
        List<Snakes> snakes = new ArrayList<>();
        List<Ladder> ladders = new ArrayList<>();

        for (String name : playersName) {
            players.add(new Player(name));
        }

        for (int[] sPos : snakesPos) {
            snakes.add(new Snakes(sPos[0], sPos[1]));
        }
        for (int[] lPos : ladderPos) {
            ladders.add(new Ladder(lPos[0], lPos[1]));
        }

        BoardService service = new BoardService(100, players, snakes, ladders);
        service.startGame();

    }
}
