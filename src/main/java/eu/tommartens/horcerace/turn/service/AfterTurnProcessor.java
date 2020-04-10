package eu.tommartens.horcerace.turn.service;

import eu.tommartens.horcerace.game.data.Game;

public interface AfterTurnProcessor {

    void process(Game game);

}
