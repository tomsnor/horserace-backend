package eu.tommartens.horserace.room.data;

import eu.tommartens.horserace.game.data.GameDTO;

public class RoomDTO {

    private String id;
    private GameDTO game;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public GameDTO getGame() {
        return game;
    }

    public void setGame(GameDTO game) {
        this.game = game;
    }
}
