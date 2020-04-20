package eu.tommartens.horserace.room.service.impl;

import eu.tommartens.horserace.game.data.Game;
import eu.tommartens.horserace.game.service.GameService;
import eu.tommartens.horserace.room.data.Room;
import eu.tommartens.horserace.room.exception.RoomNotFoundException;
import eu.tommartens.horserace.room.service.RoomFactory;
import eu.tommartens.horserace.room.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import static eu.tommartens.horserace.HorseRaceConstants.ROOMS_CACHE_NAME;

@Service
public class RoomServiceImpl implements RoomService {

    private RoomFactory roomFactory;
    private GameService gameService;

    @Autowired
    public RoomServiceImpl(RoomFactory roomFactory, GameService gameService) {
        this.roomFactory = roomFactory;
        this.gameService = gameService;
    }

    @Override
    @Cacheable(value = ROOMS_CACHE_NAME)
    public Room get(String id) {
        throw new RoomNotFoundException();
    }

    @Override
    @CachePut(value = ROOMS_CACHE_NAME, key = "#result.id")
    public Room create() {
        return roomFactory.create();
    }

    @Override
    @CachePut(value = ROOMS_CACHE_NAME, key = "#result.id")
    public Room resetGame(Room room) {
        Game game = gameService.create();
        room.setGame(game);
        return room;
    }
}
