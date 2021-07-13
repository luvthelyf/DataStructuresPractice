package lld.snakeandladder.model;

import java.util.*;

public class SnakeLadderBoard {
    private int size;
    private List<Snakes> snakes;
    private List<Ladder> ladders;

    public SnakeLadderBoard(int size, List<Snakes> snakes, List<Ladder> ladders) {
        this.size = size;
        this.snakes = snakes;
        this.ladders = ladders;
    }

    public int getSize() {
        return size;
    }

    public List<Snakes> getSnakes() {
        return snakes;
    }

    public List<Ladder> getLadders() {
        return ladders;
    }

    public int getNewPositionIfLadderExistsAt(int newPosition) {
        for (Ladder ladder : ladders) {
            if (ladder.getStart() == newPosition) {
                System.out.println("Ladder found at : " + newPosition + "! Moving to : " + ladder.getEnd());
                newPosition = ladder.getEnd();
            }
        }
        return newPosition;
    }

    public int getNewPositionIfSnakeExistsAt(int newPosition) {
        for (Snakes snake : snakes) {
            if (snake.getStart() == newPosition) {
                System.out.println("Snake found at : " + newPosition + "! Moving to : " + snake.getEnd());
                newPosition = snake.getEnd();
            }
        }
        return newPosition;
    }
}
