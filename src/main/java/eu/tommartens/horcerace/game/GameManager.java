package eu.tommartens.horcerace.game;

public interface GameManager {

    Game create();

    Game get(String id);

    Game doTurn(Game game);
}
