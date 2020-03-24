package org.LaunchCode.darts.Model;

import java.util.Objects;

public class Player {
    private Integer id;
    private static Integer nextId = 1;

    private String name;
    private Integer gamesPlayed;
    private Integer gamesWon;

    public Player(){
        this.id= nextId;
        nextId++;
    }

    public Player(String name, Integer gamesPlayed, Integer gamesWon) {
        this.id=nextId;
        this.name = name;
        this.gamesPlayed = gamesPlayed;
        this.gamesWon = gamesWon;
        nextId++;
    }

    public Player(String name) {
        this(name, 0 , 0);
    }



    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getGamesPlayed() {
        return gamesPlayed;
    }

    public void setGamesPlayed(Integer gamesPlayed) {
        this.gamesPlayed = gamesPlayed;
    }

    public Integer getGamesWon() {
        return gamesWon;
    }

    public void setGamesWon(Integer gamesWon) {
        this.gamesWon = gamesWon;
    }


    @Override
    public String toString() {
        return "Player{" +
                "name='" + name + '\'' +
                '}';
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Player player = (Player) o;
        return Objects.equals(id, player.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
