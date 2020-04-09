package eu.tommartens.horcerace.turn.impl;

import eu.tommartens.horcerace.game.Game;
import eu.tommartens.horcerace.turn.AfterTurnProcessor;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.stereotype.Service;

import static eu.tommartens.horcerace.HorseRaceConstants.GAMES_CACHE_NAME;

@Service("cleanUpFinishedGameAfterTurnProcessor")
public class CleanUpFinishedGameAfterTurnProcessorImpl implements AfterTurnProcessor {

    @Override
    @CacheEvict(value = GAMES_CACHE_NAME, key = "#game.id", condition = "#game.status == T(eu.tommartens.horcerace.game.GameStatus).FINISHED")
    public void process(Game game) {
        // Delete the game from the cache
    }
}
