package eu.tommartens.horcerace.game;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@CrossOrigin(origins = "*", exposedHeaders = "location")
public class GameController {

    private GameFacade gameFacade;

    @PostMapping("/game")
    public ResponseEntity<GameDTO> create() {
        final GameDTO game = this.gameFacade.create();
        final URI location = ServletUriComponentsBuilder
                .fromCurrentRequestUri()
                .path("/{id}")
                .buildAndExpand(game.getId())
                .toUri();
        return ResponseEntity.created(location).body(game);
    }

    @GetMapping("/game/{id}")
    public GameDTO join(@PathVariable final long id) {
        return this.gameFacade.get(id);
    }

    @GetMapping("/game/{id}/iterate")
    public GameDTO iterate(@PathVariable final long id) {
        return this.gameFacade.iterate(id);
    }

    @Autowired
    public void setGameFacade(final GameFacade gameFacade) {
        this.gameFacade = gameFacade;
    }
}
