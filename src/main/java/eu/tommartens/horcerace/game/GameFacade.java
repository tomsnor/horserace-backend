package eu.tommartens.horcerace.game;

public interface GameFacade {

    GameDTO create();

    GameDTO get(Long id);

    GameDTO iterate(Long id);

}
