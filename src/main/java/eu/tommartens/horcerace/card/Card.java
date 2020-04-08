package eu.tommartens.horcerace.card;

public class Card {

    private Face face;
    private Suit suit;

    public Card(final Face face, final Suit suit) {
        this.face = face;
        this.suit = suit;
    }

    protected Card(Suit suit) {
        this.suit = suit;
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
        return face.getCode() + suit.getCode();
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
