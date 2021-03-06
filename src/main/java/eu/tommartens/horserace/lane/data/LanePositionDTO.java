package eu.tommartens.horserace.lane.data;

import eu.tommartens.horserace.card.data.CardDTO;

public class LanePositionDTO {

    private CardDTO card;
    private int position;

    public CardDTO getCard() {
        return this.card;
    }

    public void setCard(final CardDTO card) {
        this.card = card;
    }

    public int getPosition() {
        return this.position;
    }

    public void setPosition(final int position) {
        this.position = position;
    }

}
