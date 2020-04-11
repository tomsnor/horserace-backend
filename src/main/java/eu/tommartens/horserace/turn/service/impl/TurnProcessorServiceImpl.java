package eu.tommartens.horserace.turn.service.impl;

import eu.tommartens.horserace.card.data.Card;
import eu.tommartens.horserace.deck.service.DeckService;
import eu.tommartens.horserace.game.data.Game;
import eu.tommartens.horserace.turn.service.TurnProcessor;
import eu.tommartens.horserace.turn.service.TurnProcessorFactory;
import eu.tommartens.horserace.turn.service.TurnProcessorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TurnProcessorServiceImpl implements TurnProcessorService {

    private TurnProcessorFactory turnProcessorFactory;
    private DeckService deckService;

    @Autowired
    public TurnProcessorServiceImpl(TurnProcessorFactory turnProcessorFactory, DeckService deckService) {
        this.turnProcessorFactory = turnProcessorFactory;
        this.deckService = deckService;
    }

    @Override
    public void processTurn(Game game) {
        Card card = deckService.drawCardAndAddToPile(game.getDeck());
        TurnProcessor turnProcessor = turnProcessorFactory.get(game, card);
        turnProcessor.processTurn(game, card);
    }
}


