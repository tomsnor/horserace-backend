package eu.tommartens.horcerace.turn.impl;

import eu.tommartens.horcerace.card.Card;
import eu.tommartens.horcerace.game.Game;
import eu.tommartens.horcerace.turn.TurnPreProcessor;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service("reshuffleDeckPreProcessor")
public class ReshuffleDeckTurnPreProcessorImpl implements TurnPreProcessor {

    @Override
    public void process(Game game) {
        List<Card> cards = game.getDeck().getCards();
        List<Card> pile = game.getDeck().getPile();
        if (cards.size() <= 0) {
            cards.addAll(pile);
            pile.clear();
            Collections.shuffle(cards);
        }
    }
}
