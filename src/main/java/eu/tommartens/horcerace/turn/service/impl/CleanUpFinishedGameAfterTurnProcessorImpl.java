package eu.tommartens.horcerace.turn.service.impl;

import eu.tommartens.horcerace.game.data.Game;
import eu.tommartens.horcerace.turn.service.AfterTurnProcessor;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.stereotype.Service;

import static eu.tommartens.horcerace.HorseRaceConstants.GAMES_CACHE_NAME;

@Service("cleanUpFinishedGameAfterTurnProcessor")
public class CleanUpFinishedGameAfterTurnProcessorImpl implements AfterTurnProcessor {

    @Override
    @CacheEvict(value = GAMES_CACHE_NAME, key = "#game.id", condition = "#game.status == T(eu.tommartens.horcerace.game.data.GameStatus).FINISHED")
    public void process(Game game) {
        // Delete the game from the cache
    }
}
