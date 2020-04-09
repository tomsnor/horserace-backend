package eu.tommartens.horcerace;

import com.github.benmanes.caffeine.cache.Caffeine;
import eu.tommartens.horcerace.card.Suit;
import eu.tommartens.horcerace.turn.AfterTurnProcessor;
import eu.tommartens.horcerace.turn.TurnPostProcessor;
import eu.tommartens.horcerace.turn.TurnPreProcessor;
import eu.tommartens.horcerace.turn.TurnProcessor;
import org.modelmapper.ModelMapper;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.caffeine.CaffeineCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import static eu.tommartens.horcerace.HorseRaceConstants.GAMES_CACHE_NAME;

@Configuration
@EnableCaching
public class HorseRaceApplicationConfiguration {

    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }

    @Bean
    public Map<Suit, TurnProcessor> turnProcessorMap(TurnProcessor jokerTurnProcessor) {
        Map<Suit, TurnProcessor> map = new HashMap<>();
        map.put(Suit.JOKER, jokerTurnProcessor);
        return map;
    }

    @Bean
    public List<TurnPreProcessor> turnPreProcessors(TurnPreProcessor reshuffleDeckPreProcessor) {
        List<TurnPreProcessor> preProcessors = new ArrayList<>();
        preProcessors.add(reshuffleDeckPreProcessor);
        return preProcessors;
    }

    @Bean
    public List<TurnPostProcessor> turnPostProcessors(TurnPostProcessor checkForFinishTurnPostProcessor) {
        List<TurnPostProcessor> postProcessors = new ArrayList<>();
        postProcessors.add(checkForFinishTurnPostProcessor);
        return postProcessors;
    }

    @Bean
    public List<AfterTurnProcessor> afterTurnProcessors(AfterTurnProcessor cleanUpGameAfterTurnProcessor) {
        List<AfterTurnProcessor> afterTurnProcessors = new ArrayList<>();
        afterTurnProcessors.add(cleanUpGameAfterTurnProcessor);
        return afterTurnProcessors;
    }

    @Bean
    public CacheManager cacheManager() {
        CaffeineCacheManager cacheManager = new CaffeineCacheManager(GAMES_CACHE_NAME);
        cacheManager.setCaffeine(caffeineCacheBuilder());
        return cacheManager;
    }

    protected Caffeine<Object, Object> caffeineCacheBuilder() {
        return Caffeine.newBuilder()
                .initialCapacity(10)
                .maximumSize(500)
                .expireAfterWrite(25, TimeUnit.MINUTES)
                .recordStats();
    }

}
