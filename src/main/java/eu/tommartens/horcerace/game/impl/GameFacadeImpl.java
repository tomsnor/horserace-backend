package eu.tommartens.horcerace.game.impl;

import eu.tommartens.horcerace.game.Game;
import eu.tommartens.horcerace.game.GameDTO;
import eu.tommartens.horcerace.game.GameFacade;
import eu.tommartens.horcerace.game.GameService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GameFacadeImpl implements GameFacade {

    private final GameService gameService;
    private final ModelMapper modelMapper;

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
    public GameDTO get(final Long id) {
        final Game game = this.gameService.get(id);
        return this.modelMapper.map(game, GameDTO.class);
    }

    @Override
    public GameDTO iterate(final Long id) {
        final Game game = this.gameService.iterate(id);
        return this.modelMapper.map(game, GameDTO.class);
    }
}
