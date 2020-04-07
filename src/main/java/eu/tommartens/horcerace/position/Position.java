package eu.tommartens.horcerace.position;

import eu.tommartens.horcerace.card.Card;

public class Position {

    private Card card;
    private boolean visible;

    public Card getCard() {
        return this.card;
    }

    public void setCard(final Card card) {
        this.card = card;
    }

    public boolean isVisible() {
        return this.visible;
    }

    public void setVisible(final boolean visible) {
        this.visible = visible;
    }
}
