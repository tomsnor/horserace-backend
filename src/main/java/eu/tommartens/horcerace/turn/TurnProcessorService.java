package eu.tommartens.horcerace.turn;

import eu.tommartens.horcerace.card.Card;
import eu.tommartens.horcerace.game.Game;

public interface TurnProcessorService {

    void processPreTurn(Game game);

    Card processTurn(Game game);

    void processPostTurn(Game game, Card card);

}
