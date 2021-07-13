package lld.snakeandladder.services;

import lld.snakeandladder.model.Player;

import java.util.*;

public class PlayerService {

    private int initialPlayers;
    private Queue<Player> playersQueue;
    private Map<String, Integer> playersPosition;

    PlayerService(List<Player> players) {
        initialPlayers = players.size();
        playersQueue = new LinkedList<>();
        playersPosition = new HashMap<>();

        for (Player player : players) {
            playersQueue.add(player);
            playersPosition.put(player.getId(), 0);
        }

    }

    public Player getPlayerForNextTurn() {
        return playersQueue.poll();
    }

    public int getPositionOfPlayer(Player player) {
        return playersPosition.get(player.getId());
    }

    public void movePlayerToPosition(Player player, int newPosition) {
        playersPosition.put(player.getId(), newPosition);
    }

    public void removePlayerPermanently(Player player) {
        playersPosition.remove(player.getId());
    }

    public void addToQueueToWaitForNextTurn(Player player) {
        playersQueue.add(player);
    }

    public boolean hasAnyoneWon() {
        return initialPlayers != playersPosition.size();
    }

    public boolean isSinglePlayerLeft() {
        return playersQueue.size() == 1;
    }
}
