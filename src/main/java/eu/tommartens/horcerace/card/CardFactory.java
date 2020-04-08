package eu.tommartens.horcerace.card;

import org.springframework.lang.NonNull;

public interface CardFactory {

    Card create(Face face, @NonNull Suit suit);

}
