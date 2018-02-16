package pl.kostrowski.finalny.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pl.kostrowski.finalny.entities.MyCard;
import pl.kostrowski.finalny.restclients.dto.TrelloCardDto;
import pl.kostrowski.finalny.services.CardService;

import java.util.List;

@RestController
@RequestMapping(value = "/cards")
public class CardsController {

    @Autowired
    private CardService cardService;

    @RequestMapping(value = "/list/{listId}")
    public List<MyCard> findCardsListId(@PathVariable("listId") String listId) {
        return cardService.getCardsByListId(listId);
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public MyCard saveNewCard(@RequestBody TrelloCardDto trelloCardDto) {

        MyCard fullCard = cardService.createNewCard(trelloCardDto);

        return fullCard;
    }

    @RequestMapping(value = "/update", method = RequestMethod.PUT)
    public MyCard updateCard(@RequestBody TrelloCardDto trelloCardDto) {

        MyCard fullCard = cardService.updateMyCard(trelloCardDto);

        return fullCard;
    }

}
