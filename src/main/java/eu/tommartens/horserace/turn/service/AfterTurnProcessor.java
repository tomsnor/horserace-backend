package eu.tommartens.horserace.turn.service;

import eu.tommartens.horserace.game.data.Game;

public interface AfterTurnProcessor {

    void process(Game game);

}
