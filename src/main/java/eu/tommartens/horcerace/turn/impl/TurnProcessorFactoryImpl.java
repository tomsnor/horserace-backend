package eu.tommartens.horcerace.turn.impl;

import eu.tommartens.horcerace.card.Card;
import eu.tommartens.horcerace.card.Suit;
import eu.tommartens.horcerace.game.Game;
import eu.tommartens.horcerace.turn.TurnProcessor;
import eu.tommartens.horcerace.turn.TurnProcessorFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class TurnProcessorFactoryImpl implements TurnProcessorFactory {

    private Map<Suit, TurnProcessor> turnProcessorMap;
    private TurnProcessor defaultTurnProcessor;

    @Autowired
    public TurnProcessorFactoryImpl(Map<Suit, TurnProcessor> turnProcessorMap, TurnProcessor defaultTurnProcessor) {
        this.turnProcessorMap = turnProcessorMap;
        this.defaultTurnProcessor = defaultTurnProcessor;
    }

    @Override
    public TurnProcessor get(Game game, Card card) {
        return turnProcessorMap.getOrDefault(card.getSuit(), defaultTurnProcessor);
    }

}
