package eu.tommartens.horserace.room.facade;

import eu.tommartens.horserace.room.data.RoomDTO;

public interface RoomFacade {

    RoomDTO get(String roomId);

    RoomDTO create();

    RoomDTO iterateGame(String roomId);

    RoomDTO resetGame(String roomId);

}
