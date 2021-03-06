package eu.tommartens.horserace.turn.service.impl;

import eu.tommartens.horserace.card.data.Card;
import eu.tommartens.horserace.game.data.Game;
import eu.tommartens.horserace.lane.data.Lane;
import eu.tommartens.horserace.turn.service.TurnProcessor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service("jokerTurnProcessor")
public class JokerTurnProcessorImpl implements TurnProcessor {

    @Override
    public void processTurn(final Game game, final Card card) {
        final List<Lane> lanes = game.getLanes();
        final List<Integer> uniqueSortedPositions = getUniqueSortedPositions(game);
        final int size = uniqueSortedPositions.size();
        final int firstPosition = uniqueSortedPositions.get(0);
        final int counterPosition = uniqueSortedPositions.get(size - 1);
        final List<Lane> initial = lanes.stream().filter(lane -> Integer.valueOf(lane.getPosition()).equals(firstPosition)).collect(Collectors.toList());
        final List<Lane> counter = lanes.stream().filter(lane -> Integer.valueOf(lane.getPosition()).equals(counterPosition)).collect(Collectors.toList());
        initial.forEach(lane -> lane.setPosition(counterPosition));
        counter.forEach(lane -> lane.setPosition(firstPosition));
    }

    protected List<Integer> getUniqueSortedPositions(final Game game) {
        return game.getLanes().stream()
                .map(Lane::getPosition)
                .sorted(Integer::compareTo)
                .distinct()
                .collect(Collectors.toList());
    }
}
