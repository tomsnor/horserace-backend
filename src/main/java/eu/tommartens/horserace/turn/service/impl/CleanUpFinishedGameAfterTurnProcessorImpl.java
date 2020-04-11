package eu.tommartens.horserace.turn.service.impl;

import eu.tommartens.horserace.game.data.Game;
import eu.tommartens.horserace.turn.service.AfterTurnProcessor;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.stereotype.Service;

import static eu.tommartens.horserace.HorseRaceConstants.GAMES_CACHE_NAME;

@Service("cleanUpFinishedGameAfterTurnProcessor")
public class CleanUpFinishedGameAfterTurnProcessorImpl implements AfterTurnProcessor {

    @Override
    @CacheEvict(value = GAMES_CACHE_NAME, key = "#game.id", condition = "#game.status == T(eu.tommartens.horserace.game.data.GameStatus).FINISHED")
    public void process(Game game) {
        // Delete the game from the cache
    }
}
