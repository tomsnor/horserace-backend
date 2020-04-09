package eu.tommartens.horcerace.game.impl;

import eu.tommartens.horcerace.game.Game;
import eu.tommartens.horcerace.game.GameDTO;
import eu.tommartens.horcerace.game.GameFacade;
import eu.tommartens.horcerace.game.GameManager;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GameFacadeImpl implements GameFacade {

    private final GameManager gameManager;
    private final ModelMapper modelMapper;

    @Autowired
    public GameFacadeImpl(final GameManager gameManager, final ModelMapper modelMapper) {
        this.gameManager = gameManager;
        this.modelMapper = modelMapper;
    }

    @Override
    public GameDTO create() {
        final Game game = this.gameManager.create();
        return this.modelMapper.map(game, GameDTO.class);
    }

    @Override
    public GameDTO get(final String id) {
        final Game game = this.gameManager.get(id);
        return this.modelMapper.map(game, GameDTO.class);
    }

    @Override
    public GameDTO iterate(final String id) {
        Game game = this.gameManager.get(id);
        game = gameManager.doTurn(game);
        return this.modelMapper.map(game, GameDTO.class);
    }
}
