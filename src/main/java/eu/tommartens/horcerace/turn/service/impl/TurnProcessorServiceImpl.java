package eu.tommartens.horcerace.turn.service.impl;

import eu.tommartens.horcerace.card.data.Card;
import eu.tommartens.horcerace.deck.service.DeckService;
import eu.tommartens.horcerace.game.data.Game;
import eu.tommartens.horcerace.turn.service.TurnProcessor;
import eu.tommartens.horcerace.turn.service.TurnProcessorFactory;
import eu.tommartens.horcerace.turn.service.TurnProcessorService;
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


