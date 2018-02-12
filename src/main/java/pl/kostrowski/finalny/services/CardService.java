package pl.kostrowski.finalny.services;

import pl.kostrowski.finalny.entities.Cards;
import pl.kostrowski.finalny.restclients.dto.TrelloCardDto;


public interface CardService {

    public Cards createNewCard(TrelloCardDto trelloCardDto);

}
