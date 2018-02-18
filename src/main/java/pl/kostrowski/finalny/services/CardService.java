package pl.kostrowski.finalny.services;

import pl.kostrowski.finalny.entities.MyCard;
import pl.kostrowski.finalny.restclients.trellomodel.TrelloCardDto;

import java.util.List;


public interface CardService {

    public MyCard createNewCard(TrelloCardDto trelloCardDto);

    public List<MyCard> getCardsByListId(String id);

    public MyCard updateMyCard(TrelloCardDto trelloCardDto);
}
