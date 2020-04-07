package eu.tommartens.horcerace.lane;

import eu.tommartens.horcerace.card.Card;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Lane {

    @Id
    @GeneratedValue
    private long id;
    @OneToOne
    private Card card;
    private int position;
    private LaneStatus laneStatus;

    public Lane() {
    }

    public Lane(final Card card) {
        this.card = card;
        this.laneStatus = LaneStatus.RUNNING;
    }

    public long getId() {
        return this.id;
    }

    public void setId(final long id) {
        this.id = id;
    }

    public Card getCard() {
        return this.card;
    }

    public void setCard(final Card card) {
        this.card = card;
    }

    public int getPosition() {
        return this.position;
    }

    public void setPosition(final int position) {
        this.position = position;
    }

    public LaneStatus getLaneStatus() {
        return this.laneStatus;
    }

    public void setLaneStatus(final LaneStatus laneStatus) {
        this.laneStatus = laneStatus;
    }
}
