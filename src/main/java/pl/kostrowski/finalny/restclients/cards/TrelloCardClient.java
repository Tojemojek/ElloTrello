package pl.kostrowski.finalny.restclients.cards;

import pl.kostrowski.finalny.restclients.dto.TrelloCardDto;

import java.util.List;

public interface TrelloCardClient {

    public List<TrelloCardDto> findAllForList(String listId);

    public TrelloCardDto saveToTrello(TrelloCardDto trelloCardDto);

}