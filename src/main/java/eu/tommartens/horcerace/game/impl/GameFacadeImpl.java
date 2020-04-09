package eu.tommartens.horcerace.game.impl;

import eu.tommartens.horcerace.game.Game;
import eu.tommartens.horcerace.game.GameDTO;
import eu.tommartens.horcerace.game.GameFacade;
import eu.tommartens.horcerace.game.GameService;
import eu.tommartens.horcerace.turn.AfterTurnProcessor;
import org.apache.commons.collections4.CollectionUtils;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GameFacadeImpl implements GameFacade {

    private final GameService gameService;
    private final ModelMapper modelMapper;

    private List<AfterTurnProcessor> afterTurnProcessors;

    @Autowired
    public GameFacadeImpl(final GameService gameService, final ModelMapper modelMapper) {
        this.gameService = gameService;
        this.modelMapper = modelMapper;
    }

    @Override
    public GameDTO create() {
        final Game game = this.gameService.create();
        return this.modelMapper.map(game, GameDTO.class);
    }

    @Override
    public GameDTO get(final String id) {
        final Game game = this.gameService.get(id);
        return this.modelMapper.map(game, GameDTO.class);
    }

    @Override
    public GameDTO doTurn(final String id) {
        Game game = this.gameService.get(id);
        game = gameService.doTurn(game);
        executeAfterTurnProcessors(game);
        return this.modelMapper.map(game, GameDTO.class);
    }

    protected void executeAfterTurnProcessors(Game game) {
        for (AfterTurnProcessor afterTurnProcessor : CollectionUtils.emptyIfNull(afterTurnProcessors)) {
            afterTurnProcessor.process(game);
        }
    }

    @Autowired(required = false)
    public void setAfterTurnProcessor(List<AfterTurnProcessor> afterTurnProcessors) {
        this.afterTurnProcessors = afterTurnProcessors;
    }
}
