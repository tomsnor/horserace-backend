package eu.tommartens.horcerace.game.impl;

import eu.tommartens.horcerace.card.Card;
import eu.tommartens.horcerace.game.Game;
import eu.tommartens.horcerace.game.GameFactory;
import eu.tommartens.horcerace.game.GameNotFoundException;
import eu.tommartens.horcerace.game.GameService;
import eu.tommartens.horcerace.turn.TurnProcessorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import static eu.tommartens.horcerace.HorseRaceConstants.GAMES_CACHE_NAME;

@Service
public class GameServiceImpl implements GameService {

    private TurnProcessorService turnProcessorService;
    private GameFactory gameFactory;

    @Autowired
    public GameServiceImpl(TurnProcessorService turnProcessorService, GameFactory gameFactory) {
        this.turnProcessorService = turnProcessorService;
        this.gameFactory = gameFactory;
    }

    @Override
    @CachePut(value = GAMES_CACHE_NAME, key = "#result.id")
    public Game create() {
        return gameFactory.create();
    }

    @Override
    @Cacheable(value = GAMES_CACHE_NAME)
    public Game get(final String id) {
        throw new GameNotFoundException("The game is not present or has already been deleted! ");
    }

    @Override
    @CachePut(value = GAMES_CACHE_NAME, key = "#result.id")
    public Game doTurn(Game game) {
        turnProcessorService.processPreTurn(game);
        Card card = turnProcessorService.processTurn(game);
        turnProcessorService.processPostTurn(game, card);
        return game;
    }

}
