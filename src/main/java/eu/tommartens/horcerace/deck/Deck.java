package eu.tommartens.horcerace.deck;

import eu.tommartens.horcerace.card.Card;

import java.util.List;

public class Deck {

    private List<Card> cards;
    private List<Card> pile;

    public List<Card> getCards() {
        return this.cards;
    }

    public void setCards(final List<Card> cards) {
        this.cards = cards;
    }

    public List<Card> getPile() {
        return this.pile;
    }

    public void setPile(final List<Card> pile) {
        this.pile = pile;
    }
}
