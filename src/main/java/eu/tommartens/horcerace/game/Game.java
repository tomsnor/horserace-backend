package eu.tommartens.horcerace.game;

import eu.tommartens.horcerace.deck.Deck;
import eu.tommartens.horcerace.lane.Lane;

import javax.persistence.*;
import java.util.List;

@Entity
public class Game {

    @Id
    @GeneratedValue
    private long id;
    @OneToOne
    private Deck deck;
    @OneToMany
    private List<Lane> lanes;
    private int finish;
    private GameStatus status;

    public Game() {
    }

    public long getId() {
        return this.id;
    }

    public void setId(final long id) {
        this.id = id;
    }

    public Deck getDeck() {
        return this.deck;
    }

    public void setDeck(final Deck deck) {
        this.deck = deck;
    }

    public List<Lane> getLanes() {
        return this.lanes;
    }

    public void setLanes(final List<Lane> lanes) {
        this.lanes = lanes;
    }

    public int getFinish() {
        return this.finish;
    }

    public void setFinish(final int finish) {
        this.finish = finish;
    }

    public GameStatus getStatus() {
        return this.status;
    }

    public void setStatus(final GameStatus status) {
        this.status = status;
    }
}
