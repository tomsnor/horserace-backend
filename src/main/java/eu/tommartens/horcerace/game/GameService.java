package eu.tommartens.horcerace.game;

public interface GameService {

    Game create();

    Game get(String id);

    Game iterate(Game game);

}
