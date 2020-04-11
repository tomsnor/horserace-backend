package eu.tommartens.horserace.turn.service;

import eu.tommartens.horserace.game.data.Game;

public interface TurnPostProcessor {

    void process(Game game);

}
