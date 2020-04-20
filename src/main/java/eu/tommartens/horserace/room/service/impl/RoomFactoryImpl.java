package eu.tommartens.horserace.room.service.impl;

import eu.tommartens.horserace.game.data.Game;
import eu.tommartens.horserace.game.service.GameService;
import eu.tommartens.horserace.room.data.Room;
import eu.tommartens.horserace.room.service.RoomFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoomFactoryImpl implements RoomFactory {

    private GameService gameService;

    @Autowired
    public RoomFactoryImpl(GameService gameService) {
        this.gameService = gameService;
    }

    @Override
    public Room create() {
        Game game = gameService.create();
        Room room = new Room();
        room.setId(Long.toString(System.currentTimeMillis()));
        room.setGame(game);
        return room;
    }
}
