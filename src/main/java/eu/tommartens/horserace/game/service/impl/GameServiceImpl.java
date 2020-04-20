package eu.tommartens.horserace.game.service.impl;

import eu.tommartens.horserace.game.data.Game;
import eu.tommartens.horserace.game.exception.GameNotFoundException;
import eu.tommartens.horserace.game.service.GameFactory;
import eu.tommartens.horserace.game.service.GameService;
import eu.tommartens.horserace.turn.service.TurnPostProcessor;
import eu.tommartens.horserace.turn.service.TurnPreProcessor;
import eu.tommartens.horserace.turn.service.TurnProcessorService;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GameServiceImpl implements GameService {

    private TurnProcessorService turnProcessorService;
    private GameFactory gameFactory;

    private List<TurnPreProcessor> turnPreProcessors;
    private List<TurnPostProcessor> turnPostProcessors;

    @Autowired
    public GameServiceImpl(TurnProcessorService turnProcessorService, GameFactory gameFactory) {
        this.turnProcessorService = turnProcessorService;
        this.gameFactory = gameFactory;
    }

    @Override
    public Game create() {
        return gameFactory.create();
    }

    @Override
    public Game get(final String id) {
        throw new GameNotFoundException(String.format("The game with id %s is not active", id));
    }

    @Override
    public Game doTurn(Game game) {
        executeTurnPreProcessors(game);
        turnProcessorService.processTurn(game);
        executeTurnPostProcessors(game);
        return game;
    }

    protected void executeTurnPreProcessors(Game game) {
        for (TurnPreProcessor turnPreProcessor : CollectionUtils.emptyIfNull(turnPreProcessors)) {
            turnPreProcessor.process(game);
        }
    }

    protected void executeTurnPostProcessors(Game game) {
        for (TurnPostProcessor turnPostProcessor : CollectionUtils.emptyIfNull(turnPostProcessors)) {
            turnPostProcessor.process(game);
        }
    }

    @Autowired(required = false)
    public void setTurnPreProcessors(List<TurnPreProcessor> turnPreProcessors) {
        this.turnPreProcessors = turnPreProcessors;
    }

    @Autowired(required = false)
    protected void setTurnPostProcessors(List<TurnPostProcessor> turnPostProcessors) {
        this.turnPostProcessors = turnPostProcessors;
    }
}


