package eu.tommartens.horserace.turn.service;

import eu.tommartens.horserace.card.data.Card;
import eu.tommartens.horserace.game.data.Game;

public interface TurnProcessor {

    void processTurn(Game game, Card card);

}
