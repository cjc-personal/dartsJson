package org.LaunchCode.darts.Model;

import java.util.ArrayList;
import java.util.List;

public class Game {
    private int numberOfPlayers = 0;
    private List<Player> playersPlaying = new ArrayList<>();
    private int roundCount;

    public void Game () {}
    public void Game (int numberOfPlayers) {
        this.numberOfPlayers = numberOfPlayers;
    }
    public void Game (int numberOfPlayers, List<Player> playersPlaying) {
        this.numberOfPlayers = numberOfPlayers;
        this.playersPlaying = playersPlaying;
    }


    public int getNumberOfPlayers() {
        return numberOfPlayers;
    }

    public void setNumberOfPlayers(int numberOfPlayers) {
        this.numberOfPlayers = numberOfPlayers;
    }

    public List<Player> getPlayersPlaying() {
        return playersPlaying;
    }

    public void setPlayersPlaying(List<Player> playersPlaying) {
        this.playersPlaying = playersPlaying;
    }

    public void setRoundCount(int roundCount) {
        this.roundCount = roundCount;
    }

    public int getRoundCount() {
        return roundCount;
    }

    public Boolean isPlayersPlayingFull() {
        if(playersPlaying.size() == numberOfPlayers) {
            return true;
        } else {
            return false;
        }
    }


    public void addPlayer (Player player) {
        if(!isPlayersPlayingFull()) {
            if(!playersPlaying.contains(player))
                playersPlaying.add(player);
        }
    }

    public void deletePlayer (Player player) {
        if(playersPlaying.contains(player)) {
            playersPlaying.remove(player);
        }
    }

    public void setPlayerBeginningScore (int beginningScore) {
        for(Player player : playersPlaying) {
            player.setScore(beginningScore);
        }
    }

    public void increaseRoundCount () {
        roundCount++;
    }
}
