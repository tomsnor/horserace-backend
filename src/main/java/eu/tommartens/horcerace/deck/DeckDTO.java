package eu.tommartens.horcerace.deck;

import eu.tommartens.horcerace.card.CardDTO;

import java.util.List;

public class DeckDTO {

    private List<CardDTO> pile;

    public List<CardDTO> getPile() {
        return this.pile;
    }

    public void setPile(final List<CardDTO> pile) {
        this.pile = pile;
    }
}
