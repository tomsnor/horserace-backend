package eu.tommartens.horcerace.card;

public enum Suit {

    SPADES("S"),
    HEARTS("H"),
    DIAMONDS("D"),
    CLUBS("C"),
    JOKER("JOKER");

    private final String code;

    Suit(final String code) {
        this.code = code;
    }

    public String getCode() {
        return this.code;
    }

}
