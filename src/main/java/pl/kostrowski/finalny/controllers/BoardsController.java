package pl.kostrowski.finalny.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pl.kostrowski.finalny.entities.MyBoard;
import pl.kostrowski.finalny.services.BoardService;

import java.util.List;

@RestController
@RequestMapping(value = "/boards")
public class BoardsController {

    @Autowired
    private BoardService boardService;

    @RequestMapping(value = "/")
    public List<MyBoard> findAll() {

        return boardService.getAllFromDatabase();
    }

    @RequestMapping(value = "/{id}")
    public MyBoard findByBoardId(@PathVariable("id") String id) {

        return boardService.getBoardById(id);
    }

}
