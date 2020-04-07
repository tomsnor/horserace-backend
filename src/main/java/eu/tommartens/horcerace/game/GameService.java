package eu.tommartens.horcerace.game;

public interface GameService {

    Game create();

    Game get(long id);

    Game iterate(long id);

}
