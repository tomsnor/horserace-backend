package eu.tommartens.horcerace.turn.service;

import eu.tommartens.horcerace.card.data.Card;
import eu.tommartens.horcerace.game.data.Game;

public interface TurnProcessor {

    void processTurn(Game game, Card card);

}
