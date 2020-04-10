package eu.tommartens.horcerace.turn.service;

import eu.tommartens.horcerace.game.data.Game;

public interface TurnPostProcessor {

    void process(Game game);

}
