package eu.tommartens.horcerace.deck;

import eu.tommartens.horcerace.card.Card;

import java.util.ArrayList;
import java.util.List;

public class Deck {

    private List<Card> cards = new ArrayList<>(54);
    private List<Card> pile = new ArrayList<>();

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
