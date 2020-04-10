package eu.tommartens.horcerace.game.controller;

import eu.tommartens.horcerace.game.data.GameDTO;
import eu.tommartens.horcerace.game.exception.GameNotFoundException;
import eu.tommartens.horcerace.game.facade.GameFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.annotation.SubscribeMapping;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@CrossOrigin(origins = "*", exposedHeaders = "location")
public class GameController {

    private GameFacade gameFacade;

    @PostMapping("/game/")
    public ResponseEntity<GameDTO> create() {
        final GameDTO game = this.gameFacade.create();
        final URI location = ServletUriComponentsBuilder
                .fromCurrentRequestUri()
                .path("/{id}")
                .buildAndExpand(game.getId())
                .toUri();
        return ResponseEntity.created(location).body(game);
    }

    @GetMapping("/game/{id}/")
    @SubscribeMapping("/{id}/")
    public GameDTO join(@PathVariable @DestinationVariable final String id) {
        return this.gameFacade.get(id);
    }

    @MessageMapping("/{id}/iterate/")
    @SendTo("/game/{id}/")
    public GameDTO iterate(@DestinationVariable final String id) {
        return this.gameFacade.doTurn(id);
    }

    @Autowired
    public void setGameFacade(final GameFacade gameFacade) {
        this.gameFacade = gameFacade;
    }

    @ExceptionHandler(GameNotFoundException.class)
    public ResponseEntity<String> handleException(GameNotFoundException ex) {
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
    }
}
