package eu.tommartens.horserace.game.facade;

import eu.tommartens.horserace.game.data.GameDTO;

public interface GameFacade {

    GameDTO create();

    GameDTO get(String id);

    GameDTO doTurn(String id);

}
