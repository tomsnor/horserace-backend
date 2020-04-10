package eu.tommartens.horcerace.game.service;

import eu.tommartens.horcerace.game.data.Game;

public interface GameService {

    Game create();

    Game get(String id);

    Game doTurn(Game game);
}
