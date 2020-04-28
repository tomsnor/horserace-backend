package eu.tommartens.horserace.room.controller;

import eu.tommartens.horserace.room.data.RoomDTO;
import eu.tommartens.horserace.room.exception.RoomNotFoundException;
import eu.tommartens.horserace.room.facade.RoomFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.annotation.SubscribeMapping;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@Controller
@RequestMapping("/room")
public class RoomController {

    private RoomFacade roomFacade;

    @ResponseBody
    @SubscribeMapping("/room/{id}/")
    public RoomDTO join(@DestinationVariable final String id) {
        return roomFacade.get(id);
    }

    @ResponseBody
    @GetMapping("/room/{id}/")
    public ResponseEntity<RoomDTO> get(@PathVariable final String id) {
        RoomDTO roomDTO = roomFacade.get(id);
        return new ResponseEntity<>(roomDTO, HttpStatus.OK);
    }

    @MessageMapping("/room/{roomId}/game/next/")
    @SendTo("/room/{roomId}/")
    public RoomDTO iterateGame(@DestinationVariable final String roomId) {
        return roomFacade.iterateGame(roomId);
    }

    @MessageMapping("/room/{roomId}/game/new/")
    @SendTo("/room/{roomId}/")
    public RoomDTO resetGame(@DestinationVariable final String roomId) {
        return roomFacade.resetGame(roomId);
    }

    @PostMapping("/")
    public ResponseEntity<RoomDTO> create() {
        final RoomDTO roomDTO = this.roomFacade.create();
        final URI location = ServletUriComponentsBuilder
                .fromCurrentRequestUri()
                .path("/{id}")
                .buildAndExpand(roomDTO.getId())
                .toUri();
        return ResponseEntity.created(location).body(roomDTO);
    }

    @Autowired
    public void setRoomFacade(final RoomFacade roomFacade) {
        this.roomFacade = roomFacade;
    }

    @ExceptionHandler(RoomNotFoundException.class)
    public ResponseEntity<Void> handleRoomNotFoundException() {
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

}
