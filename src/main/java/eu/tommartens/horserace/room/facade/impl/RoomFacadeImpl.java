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

    private RoomService roomService;
    private ModelMapper modelMapper;
    private GameFacade gameFacade;

    @Autowired
    public RoomFacadeImpl(RoomService roomService, ModelMapper modelMapper, GameFacade gameFacade) {
        this.roomService = roomService;
        this.modelMapper = modelMapper;
        this.gameFacade = gameFacade;
    }

    @Override
    public RoomDTO get(String id) {
        Room room = roomService.get(id);
        return modelMapper.map(room, RoomDTO.class);
    }

    @Override
    public RoomDTO create() {
        Room room = roomService.create();
        return modelMapper.map(room, RoomDTO.class);
    }

    @Override
    public RoomDTO iterateGame(String roomId) {
        Room room = roomService.get(roomId);
        gameFacade.doTurn(room.getGame());
        return modelMapper.map(room, RoomDTO.class);
    }

    @Override
    public RoomDTO resetGame(String roomId) {
        Room room = roomService.get(roomId);
        room = roomService.resetGame(room);
        return modelMapper.map(room, RoomDTO.class);
    }
}
