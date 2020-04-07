package eu.tommartens.horcerace.room.impl;

import eu.tommartens.horcerace.room.Room;
import eu.tommartens.horcerace.room.RoomDTO;
import eu.tommartens.horcerace.room.RoomFacade;
import eu.tommartens.horcerace.room.RoomService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

public class RoomFacadeImpl implements RoomFacade {

    private RoomService roomService;
    private ModelMapper modelMapper;

    @Override
    public RoomDTO create() {
        final Room room = this.getRoomService().create();
        return this.getModelMapper().map(room, RoomDTO.class);
    }

    @Override
    public RoomDTO get(final long id) {
        final Room room = this.getRoomService().get(id);
        return this.getModelMapper().map(room, RoomDTO.class);
    }

    public RoomService getRoomService() {
        return this.roomService;
    }

    @Autowired
    public void setRoomService(final RoomService roomService) {
        this.roomService = roomService;
    }

    public ModelMapper getModelMapper() {
        return this.modelMapper;
    }

    @Autowired
    public void setModelMapper(final ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }
}
