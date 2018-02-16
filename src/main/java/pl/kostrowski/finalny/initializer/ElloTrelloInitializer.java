package pl.kostrowski.finalny.initializer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pl.kostrowski.finalny.converters.UserConverter;
import pl.kostrowski.finalny.entities.MyUser;
import pl.kostrowski.finalny.repository.MyUserRepository;
import pl.kostrowski.finalny.restclients.dto.MyUserDto;
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

        MyUserDto testowy = new MyUserDto("ko","k","o","dupadupa", "EAST", "TECHNICIAN");
        UserConverter converter = new UserConverter();
        MyUser converted = converter.convert(testowy);
        myUserRepository.save(converted);

    }

}
