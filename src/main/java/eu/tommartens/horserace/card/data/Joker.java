package eu.tommartens.horserace.card.data;

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
        if (!(obj instanceof Joker)) {
            return false;
        }
        Joker that = (Joker) obj;
        return this.getSuit().equals(that.getSuit());
    }
}
