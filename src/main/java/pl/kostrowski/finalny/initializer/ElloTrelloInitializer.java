package pl.kostrowski.finalny.initializer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pl.kostrowski.finalny.services.BoardService;

import javax.annotation.PostConstruct;

@Component
public class ElloTrelloInitializer {


    @Autowired
    BoardService boardService;

    @PostConstruct
    private void initialize() {

        boardService.getAllFromTrelloAndPersist();

    }

}
