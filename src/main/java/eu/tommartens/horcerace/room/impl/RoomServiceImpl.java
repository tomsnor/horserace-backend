package eu.tommartens.horcerace.room.impl;

import eu.tommartens.horcerace.game.GameService;
import eu.tommartens.horcerace.room.Room;
import eu.tommartens.horcerace.room.RoomRepository;
import eu.tommartens.horcerace.room.RoomService;
import org.springframework.beans.factory.annotation.Autowired;

public class RoomServiceImpl implements RoomService {

    private final GameService gameService;
    private final RoomRepository roomRepository;

    @Autowired
    public RoomServiceImpl(final GameService gameService, final RoomRepository roomRepository) {
        this.gameService = gameService;
        this.roomRepository = roomRepository;
    }

    @Override
    public Room create() {
        final Room room = new Room();
        room.setGame(this.getGameService().create());
        return this.getRoomRepository().saveAndFlush(room);
    }

    @Override
    public Room get(final long id) {
        return this.getRoomRepository().getOne(id);
    }

    protected GameService getGameService() {
        return this.gameService;
    }

    protected RoomRepository getRoomRepository() {
        return this.roomRepository;
    }

}
