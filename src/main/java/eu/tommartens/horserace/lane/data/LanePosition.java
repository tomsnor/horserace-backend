package eu.tommartens.horserace.lane.data;

import eu.tommartens.horserace.card.data.Card;

public class LanePosition {

    private Card card;
    private int position;

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
}
