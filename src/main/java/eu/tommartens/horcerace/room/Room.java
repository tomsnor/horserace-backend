package eu.tommartens.horcerace.room;

import eu.tommartens.horcerace.game.Game;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Room {

    @Id
    @GeneratedValue
    private Long id;
    @OneToOne
    private Game game;

    public Long getId() {
        return this.id;
    }

    public void setId(final Long id) {
        this.id = id;
    }

    public Game getGame() {
        return this.game;
    }

    public void setGame(final Game game) {
        this.game = game;
    }
}
