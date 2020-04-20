package eu.tommartens.horserace.room.data;

import eu.tommartens.horserace.game.data.Game;

public class Room {

    private String id;
    private Game game;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Game getGame() {
        return game;
    }

    public void setGame(Game game) {
        this.game = game;
    }
}
