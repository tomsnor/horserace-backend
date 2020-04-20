package eu.tommartens.horserace.room.service;

import eu.tommartens.horserace.room.data.Room;

public interface RoomService {

    Room get(String id);

    Room create();

    Room resetGame(Room room);

}
