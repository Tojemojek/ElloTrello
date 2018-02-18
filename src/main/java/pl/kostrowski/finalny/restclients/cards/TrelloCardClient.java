package pl.kostrowski.finalny.restclients.cards;

import pl.kostrowski.finalny.restclients.trellomodel.TrelloCardDto;

import java.util.List;

public interface TrelloCardClient {

    public List<TrelloCardDto> findAllCardsWithListId(String listId);

    public TrelloCardDto saveToTrello(TrelloCardDto trelloCardDto);

    public TrelloCardDto updateToTrelo(TrelloCardDto trelloCardDto);


}
