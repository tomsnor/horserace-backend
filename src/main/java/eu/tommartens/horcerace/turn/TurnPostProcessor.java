package eu.tommartens.horcerace.turn;

import eu.tommartens.horcerace.game.Game;

public interface TurnPostProcessor {

    void process(Game game);

}
