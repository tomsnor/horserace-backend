package eu.tommartens.horcerace.turn.impl;

import eu.tommartens.horcerace.card.Card;
import eu.tommartens.horcerace.deck.DeckService;
import eu.tommartens.horcerace.game.Game;
import eu.tommartens.horcerace.turn.*;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TurnProcessorServiceImpl implements TurnProcessorService {

    private TurnProcessorFactory turnProcessorFactory;
    private DeckService deckService;

    private List<TurnPreProcessor> turnPreProcessors;
    private List<TurnPostProcessor> turnPostProcessors;

    @Autowired
    public TurnProcessorServiceImpl(TurnProcessorFactory turnProcessorFactory, DeckService deckService) {
        this.turnProcessorFactory = turnProcessorFactory;
        this.deckService = deckService;
    }

    @Override
    public void processPreTurn(Game game) {
        for (TurnPreProcessor turnPreProcessor : CollectionUtils.emptyIfNull(turnPreProcessors)) {
            turnPreProcessor.process(game);
        }
    }

    @Override
    public Card processTurn(Game game) {
        Card card = deckService.drawCardAndAddToPile(game.getDeck());
        TurnProcessor turnProcessor = turnProcessorFactory.get(game, card);
        turnProcessor.processTurn(game, card);
        return card;
    }

    @Override
    public void processPostTurn(Game game, Card card) {
        for (TurnPostProcessor turnPostProcessor : CollectionUtils.emptyIfNull(turnPostProcessors)) {
            turnPostProcessor.process(game, card);
        }
    }

    @Autowired(required = false)
    public void setTurnPreProcessors(List<TurnPreProcessor> turnPreProcessors) {
        this.turnPreProcessors = turnPreProcessors;
    }

    @Autowired(required = false)
    protected void setTurnPostProcessors(List<TurnPostProcessor> turnPostProcessors) {
        this.turnPostProcessors = turnPostProcessors;
    }
}
