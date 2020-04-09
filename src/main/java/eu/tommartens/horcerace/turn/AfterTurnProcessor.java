package eu.tommartens.horcerace.turn;

import eu.tommartens.horcerace.game.Game;

public interface AfterTurnProcessor {

    void process(Game game);

}
