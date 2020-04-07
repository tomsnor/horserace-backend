package eu.tommartens.horcerace.game;

import eu.tommartens.horcerace.deck.DeckDTO;
import eu.tommartens.horcerace.lane.LaneDTO;

import java.util.List;

public class GameDTO {

    private long id;
    private DeckDTO deck;
    private List<LaneDTO> lanes;
    private int finish;
    private GameStatus status;

    public long getId() {
        return this.id;
    }

    public void setId(final long id) {
        this.id = id;
    }

    public DeckDTO getDeck() {
        return this.deck;
    }

    public void setDeck(final DeckDTO deck) {
        this.deck = deck;
    }

    public List<LaneDTO> getLanes() {
        return this.lanes;
    }

    public void setLanes(final List<LaneDTO> lanes) {
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
