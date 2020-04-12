package eu.tommartens.horserace.turn.service.impl;

import eu.tommartens.horserace.card.data.Card;
import eu.tommartens.horserace.card.data.Suit;
import eu.tommartens.horserace.game.data.Game;
import eu.tommartens.horserace.turn.service.TurnProcessor;
import eu.tommartens.horserace.turn.service.TurnProcessorFactory;
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
