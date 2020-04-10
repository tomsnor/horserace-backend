package eu.tommartens.horcerace.game.facade;

import eu.tommartens.horcerace.game.data.GameDTO;

public interface GameFacade {

    GameDTO create();

    GameDTO get(String id);

    GameDTO doTurn(String id);

}
