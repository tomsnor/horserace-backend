package eu.tommartens.horcerace.deck;

import eu.tommartens.horcerace.card.Card;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
public class Deck {

    @Id
    @GeneratedValue
    private long id;
    @OneToMany
    private List<Card> cards;
    @OneToMany
    private List<Card> pile;

    public long getId() {
        return this.id;
    }

    public void setId(final long id) {
        this.id = id;
    }

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
