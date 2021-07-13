package lld.snakeandladder.services;

import lld.snakeandladder.model.Snakes;
import lld.snakeandladder.model.Ladder;
import lld.snakeandladder.model.Player;
import lld.snakeandladder.model.SnakeLadderBoard;
import lld.snakeandladder.services.PlayerService;

import java.util.List;

public class BoardService {

    private SnakeLadderBoard board;
    private PlayerService playerService;

    public BoardService(int size, List<Player> players, List<Snakes> snakes, List<Ladder> ladders) {
        this.board = new SnakeLadderBoard(size, snakes, ladders);
        this.playerService = new PlayerService(players);
    }

    public void startGame() {

        System.out.println("Starting Game!");
        while (!isGameFinished()) {
            Player player = pollPlayersForNextTurn();
            System.out.println("***** Player : " + player.getName() + " turn ! ********");

            int rolledNumberInDice = rollDiceAndGetValue();
            System.out.println("Player : " + player.getName() + " rolled dice with number = " + rolledNumberInDice);
            checkAndMovePlayer(player, rolledNumberInDice);

            if (hasCurrentPlayerWon(player)) {
                System.out.println("Player " + player.getName() + " has won the game!");
                playerService.removePlayerPermanently(player);
            } else {
                playerService.addToQueueToWaitForNextTurn(player);
            }
        }
        System.out.println("Game Finished!");

    }

    private boolean hasCurrentPlayerWon(Player player) {
        return playerService.getPositionOfPlayer(player) == board.getSize();
    }

    private void checkAndMovePlayer(Player player, int rolledNumberInDice) {
        int currentPosition = playerService.getPositionOfPlayer(player);

        int newPosition = currentPosition + rolledNumberInDice;

        if (newPosition > board.getSize()) {
            System.out.println("Rolled Dice number for " + player.getName() + " exceeds the board so not moving!");
        } else {
            System.out.println("Moving " + player.getName() + " from " + currentPosition + " to " + newPosition);
            newPosition = getFinalPositionAfterPassingThroughSnakesAndLadder(newPosition);
            playerService.movePlayerToPosition(player, newPosition);
            System.out.println("Player : " + player.getName() + " new position = " + newPosition);
        }
    }

    private int getFinalPositionAfterPassingThroughSnakesAndLadder(int newPosition) {
        int lastPosition = -1;

        while (lastPosition != newPosition) {
            lastPosition = newPosition;
            newPosition = board.getNewPositionIfLadderExistsAt(newPosition);
            newPosition = board.getNewPositionIfSnakeExistsAt(newPosition);
        }

        return newPosition;
    }

    private Player pollPlayersForNextTurn() {
        return playerService.getPlayerForNextTurn();
    }

    private boolean isGameFinished() {
        return playerService.isSinglePlayerLeft() || playerService.hasAnyoneWon();
    }

    private int rollDiceAndGetValue() {
        return Dice.roll();
    }
}
