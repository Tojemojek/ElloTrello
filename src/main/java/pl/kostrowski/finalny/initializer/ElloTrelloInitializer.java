package pl.kostrowski.finalny.initializer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pl.kostrowski.finalny.converters.UserConverter;
import pl.kostrowski.finalny.entities.MyUser;
import pl.kostrowski.finalny.repository.MyUserRepository;
import pl.kostrowski.finalny.dto.MyUserDto;
import pl.kostrowski.finalny.services.BoardService;

import javax.annotation.PostConstruct;

@Component
public class ElloTrelloInitializer {

    @Autowired
    BoardService boardService;

    @Autowired
    MyUserRepository myUserRepository;

    @PostConstruct
    private void initialize() {
        boardService.getAllFromTrelloAndPersist();
    }
}
