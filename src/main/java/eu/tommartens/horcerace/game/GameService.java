package eu.tommartens.horcerace.game;

public interface GameService {

    Game create();

    Game get(Long id);

    Game iterate(Long id);

}
