package eu.tommartens.horcerace.card;

public class Joker extends Card {

    public Joker() {
        super(Suit.JOKER);
    }

    @Override
    public String getCode() {
        return super.getSuit().getCode();
    }

    @Override
    public int hashCode() {
        return super.getSuit().hashCode() * 3;
    }

    @Override
    public boolean equals(final Object obj) {
        return obj instanceof Joker;
    }
}
