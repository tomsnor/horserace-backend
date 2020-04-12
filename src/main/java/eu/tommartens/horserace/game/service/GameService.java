package eu.tommartens.horserace.game.service;

import eu.tommartens.horserace.game.data.Game;

public interface GameService {

    Game create();

    Game get(String id);

    Game doTurn(Game game);
}
