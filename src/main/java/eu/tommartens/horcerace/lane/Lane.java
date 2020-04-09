package eu.tommartens.horcerace.lane;

import eu.tommartens.horcerace.card.Card;

public class Lane {

    private Card card;
    private int position;
    private LaneStatus status;

    public Lane() {
    }

    public Lane(final Card card) {
        this.card = card;
        this.status = LaneStatus.RUNNING;
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

    public LaneStatus getStatus() {
        return this.status;
    }

    public void setStatus(final LaneStatus status) {
        this.status = status;
    }
}
