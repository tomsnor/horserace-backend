package eu.tommartens.horcerace.game.impl;

import eu.tommartens.horcerace.card.Card;
import eu.tommartens.horcerace.game.Game;
import eu.tommartens.horcerace.game.GameManager;
import eu.tommartens.horcerace.game.GameService;
import eu.tommartens.horcerace.turn.TurnProcessorFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CachePut;
import org.springframework.stereotype.Service;

import static eu.tommartens.horcerace.HorseRaceConstants.GAMES_CACHE_NAME;

@Service
public class GameManagerImpl implements GameManager {

    private TurnProcessorFacade turnProcessorFacade;
    private GameService gameService;

    @Autowired
    public GameManagerImpl(TurnProcessorFacade turnProcessorFacade, GameService gameService) {
        this.turnProcessorFacade = turnProcessorFacade;
        this.gameService = gameService;
    }

    @Override
    public Game create() {
        return gameService.create();
    }

    @Override
    public Game get(String id) {
        return gameService.get(id);
    }

    @Override
    @CachePut(value = GAMES_CACHE_NAME, key = "#result.id")
    public Game doTurn(Game game) {
        turnProcessorFacade.processPreTurn(game);
        Card card = turnProcessorFacade.processTurn(game);
        turnProcessorFacade.processPostTurn(game, card);
        return game;
    }

    protected void executePreTurnProcessors(Game game) {

    }
}
