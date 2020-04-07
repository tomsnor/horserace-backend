package eu.tommartens.horcerace.position;

import eu.tommartens.horcerace.card.CardDTO;

public class PositionDTO {

    private CardDTO card;
    private boolean visible;

    public CardDTO getCard() {
        return this.card;
    }

    public void setCard(final CardDTO card) {
        this.card = card;
    }

    public boolean isVisible() {
        return this.visible;
    }

    public void setVisible(final boolean visible) {
        this.visible = visible;
    }
}
