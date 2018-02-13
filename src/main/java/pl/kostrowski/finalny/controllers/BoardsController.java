package pl.kostrowski.finalny.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pl.kostrowski.finalny.entities.Board;
import pl.kostrowski.finalny.entities.Cards;
import pl.kostrowski.finalny.restclients.boards.TrelloBoardClient;
import pl.kostrowski.finalny.restclients.cards.TrelloCardClient;
import pl.kostrowski.finalny.restclients.dto.TrelloBoardDto;
import pl.kostrowski.finalny.restclients.dto.TrelloCardDto;
import pl.kostrowski.finalny.services.BoardService;
import pl.kostrowski.finalny.services.CardService;

import java.util.List;

@RestController
@RequestMapping(value = "/boards")
public class BoardsController {

    @Autowired
    private TrelloBoardClient trelloBoardClient;

    @Autowired
    private TrelloCardClient trelloCardClient;

    @Autowired
    private CardService cardService;

    @Autowired
    private BoardService boardService;

    @RequestMapping(value = "/")
    public List<Board> findAll() {

        List<Board> allFromTrello = boardService.getAllFromTrelloAndPersist();

        return allFromTrello;
    }

    @RequestMapping(value = "/{id}")
    public TrelloBoardDto findByBoardId(@PathVariable("id") String id) {
        return trelloBoardClient.findBoardById(id);
    }

    @RequestMapping(value = "/list/{id}/cards")
    public List<TrelloCardDto> findCardsByBoardId(@PathVariable("id") String id) {
        return trelloCardClient.findAllCardsWithListId(id);
    }

    @RequestMapping(value = "/list/cards", method = RequestMethod.POST)
    public Cards saveNewCard(@RequestBody TrelloCardDto trelloCardDto) {

        Cards fullCard = cardService.createNewCard(trelloCardDto);

        return fullCard;
    }


}
