package eu.tommartens.horcerace.turn.service.impl;

import eu.tommartens.horcerace.card.data.Card;
import eu.tommartens.horcerace.game.data.Game;
import eu.tommartens.horcerace.turn.service.TurnPreProcessor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service("reshuffleDeckPreProcessor")
public class ReshuffleDeckTurnPreProcessorImpl implements TurnPreProcessor {

    @Override
    public void process(Game game) {
        List<Card> stack = new ArrayList<>(game.getDeck().getStack());
        List<Card> pile = new ArrayList<>(game.getDeck().getPile());
        if (stack.size() <= 0) {
            stack.addAll(pile);
            pile.clear();
            Collections.shuffle(stack);
            game.getDeck().setStack(stack);
            game.getDeck().setPile(pile);
        }
    }

}
