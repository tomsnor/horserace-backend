package eu.tommartens.horcerace.card;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Card {

    @Id
    @GeneratedValue
    private long id;
    // Koning
    private Face face;
    // Schoppen
    private Suit suit;
    private String code;

    public Card() {
    }

    public Card(final Face face, final Suit suit) {
        this.face = face;
        this.suit = suit;
        this.code = face.getCode() + suit.getCode();
    }

    public long getId() {
        return this.id;
    }

    public void setId(final long id) {
        this.id = id;
    }

    public Face getFace() {
        return this.face;
    }

    public void setFace(final Face face) {
        this.face = face;
    }

    public Suit getSuit() {
        return this.suit;
    }

    public void setSuit(final Suit suit) {
        this.suit = suit;
    }

    public String getCode() {
        return this.code;
    }

    public void setCode(final String code) {
        this.code = code;
    }

    @Override
    public int hashCode() {
        return this.face.hashCode() * 3 + this.suit.hashCode() * 7;
    }

    @Override
    public boolean equals(final Object obj) {
        if (obj == null) {
            return false;
        }
        if (obj instanceof Card) {
            final Card that = (Card) obj;
            return this.face.equals(that.face) && this.suit.equals(that.suit);
        }

        return false;
    }
}
