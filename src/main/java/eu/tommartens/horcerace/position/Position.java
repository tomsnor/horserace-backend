package eu.tommartens.horcerace.position;

import eu.tommartens.horcerace.card.Card;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Position {

    @Id
    @GeneratedValue
    private long id;
    @OneToOne
    private Card card;
    private boolean visible;

    public long getId() {
        return this.id;
    }

    public void setId(final long id) {
        this.id = id;
    }

    public Card getCard() {
        return this.card;
    }

    public void setCard(final Card card) {
        this.card = card;
    }

    public boolean isVisible() {
        return this.visible;
    }

    public void setVisible(final boolean visible) {
        this.visible = visible;
    }
}
