package eu.tommartens.horserace.game.facade.impl;

import eu.tommartens.horserace.game.data.Game;
import eu.tommartens.horserace.game.facade.GameFacade;
import eu.tommartens.horserace.game.service.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GameFacadeImpl implements GameFacade {

    private final GameService gameService;

    @Autowired
    public GameFacadeImpl(final GameService gameService) {
        this.gameService = gameService;
    }

    @Override
    public void doTurn(Game game) {
        gameService.doTurn(game);
    }

}
