package eu.tommartens.horcerace.turn.service.impl;

import eu.tommartens.horcerace.game.data.Game;
import eu.tommartens.horcerace.game.data.GameStatus;
import eu.tommartens.horcerace.lane.data.Lane;
import eu.tommartens.horcerace.lane.data.LaneStatus;
import eu.tommartens.horcerace.turn.service.TurnPostProcessor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service("checkForFinishTurnPostProcessor")
public class CheckForFinishTurnPostProcessorImpl implements TurnPostProcessor {

    @Override
    public void process(Game game) {
        Optional<Lane> winningLane = findWinner(game);
        winningLane.ifPresent(winner -> {
            for (final Lane lane : game.getLanes()) {
                lane.setStatus(LaneStatus.LOSER);
            }
            winner.setStatus(LaneStatus.WINNER);
            game.setStatus(GameStatus.FINISHED);
        });
    }

    protected Optional<Lane> findWinner(Game game) {
        return game.getLanes().stream()
                .filter(lane -> lane.getPosition() >= game.getFinish())
                .findFirst();
    }
}
