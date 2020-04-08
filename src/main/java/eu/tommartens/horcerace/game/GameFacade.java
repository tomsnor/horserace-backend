package eu.tommartens.horcerace.game;

public interface GameFacade {

    GameDTO create();

    GameDTO get(String id);

    GameDTO iterate(String id);

}
