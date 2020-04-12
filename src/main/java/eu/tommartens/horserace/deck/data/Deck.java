package eu.tommartens.horserace.deck.data;

import eu.tommartens.horserace.card.data.Card;

import java.util.ArrayList;
import java.util.List;

public class Deck {

    private List<Card> stack = new ArrayList<>(54);
    private List<Card> pile = new ArrayList<>();

    public List<Card> getStack() {
        return this.stack;
    }

    public void setStack(final List<Card> stack) {
        this.stack = stack;
    }

    public List<Card> getPile() {
        return this.pile;
    }

    public void setPile(final List<Card> pile) {
        this.pile = pile;
    }
}
