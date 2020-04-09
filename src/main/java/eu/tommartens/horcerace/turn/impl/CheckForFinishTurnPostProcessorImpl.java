package eu.tommartens.horcerace.turn.impl;

import eu.tommartens.horcerace.card.Card;
import eu.tommartens.horcerace.game.Game;
import eu.tommartens.horcerace.game.GameStatus;
import eu.tommartens.horcerace.lane.Lane;
import eu.tommartens.horcerace.lane.LaneStatus;
import eu.tommartens.horcerace.turn.TurnPostProcessor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service("checkForFinishTurnPostProcessor")
public class CheckForFinishTurnPostProcessorImpl implements TurnPostProcessor {

    @Override
    public void process(Game game, Card card) {
        Optional<Lane> winningLane = findWinner(game);
        winningLane.ifPresent(winner -> {
            for (final Lane lane : game.getLanes()) {
                lane.setLaneStatus(LaneStatus.LOSER);
            }
            winner.setLaneStatus(LaneStatus.WINNER);
            game.setStatus(GameStatus.FINISHED);
        });
    }

    protected Optional<Lane> findWinner(Game game) {
        return game.getLanes().stream()
                .filter(lane -> lane.getPosition() >= game.getFinish())
                .findFirst();
    }
}
