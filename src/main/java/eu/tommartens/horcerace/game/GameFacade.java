package eu.tommartens.horcerace.game;

public interface GameFacade {

    GameDTO create();

    GameDTO get(String id);

    GameDTO doTurn(String id);

}
