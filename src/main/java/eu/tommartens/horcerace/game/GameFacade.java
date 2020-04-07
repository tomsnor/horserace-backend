package eu.tommartens.horcerace.game;

public interface GameFacade {

    GameDTO create();

    GameDTO get(long id);

    GameDTO iterate(long id);

}
