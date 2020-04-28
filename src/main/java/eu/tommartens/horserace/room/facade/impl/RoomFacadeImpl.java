package eu.tommartens.horserace.room.facade.impl;

import eu.tommartens.horserace.game.facade.GameFacade;
import eu.tommartens.horserace.room.data.Room;
import eu.tommartens.horserace.room.data.RoomDTO;
import eu.tommartens.horserace.room.facade.RoomFacade;
import eu.tommartens.horserace.room.service.RoomService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoomFacadeImpl implements RoomFacade {

    private final RoomService roomService;
    private final ModelMapper modelMapper;
    private final GameFacade gameFacade;

    @Autowired
    public RoomFacadeImpl(final RoomService roomService, final ModelMapper modelMapper, final GameFacade gameFacade) {
        this.roomService = roomService;
        this.modelMapper = modelMapper;
        this.gameFacade = gameFacade;
    }

    @Override
    public RoomDTO get(final String id) {
        final Room room = this.roomService.get(id);
        return this.modelMapper.map(room, RoomDTO.class);
    }

    @Override
    public RoomDTO create() {
        final Room room = this.roomService.create();
        return this.modelMapper.map(room, RoomDTO.class);
    }

    @Override
    public RoomDTO iterateGame(final String roomId) {
        final Room room = this.roomService.get(roomId);
        this.gameFacade.doTurn(room.getGame());
        return this.modelMapper.map(room, RoomDTO.class);
    }

    @Override
    public RoomDTO resetGame(final String roomId) {
        Room room = this.roomService.get(roomId);
        room = this.roomService.resetGame(room);
        return this.modelMapper.map(room, RoomDTO.class);
    }
}
