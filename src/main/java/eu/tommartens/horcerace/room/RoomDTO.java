package eu.tommartens.horcerace.room;

import com.fasterxml.jackson.annotation.JsonIgnore;
import eu.tommartens.horcerace.game.GameDTO;

public class RoomDTO {

    @JsonIgnore
    private long id;
    private GameDTO game;

    public long getId() {
        return this.id;
    }

    public void setId(final long id) {
        this.id = id;
    }

    public GameDTO getGame() {
        return this.game;
    }

    public void setGame(final GameDTO game) {
        this.game = game;
    }
}
