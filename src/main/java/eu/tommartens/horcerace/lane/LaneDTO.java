package eu.tommartens.horcerace.lane;

import eu.tommartens.horcerace.card.CardDTO;

public class LaneDTO {

    private CardDTO card;
    private int position;
    private LaneStatus laneStatus;

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

    public LaneStatus getLaneStatus() {
        return this.laneStatus;
    }

    public void setLaneStatus(final LaneStatus laneStatus) {
        this.laneStatus = laneStatus;
    }
}
