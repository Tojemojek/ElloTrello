package pl.kostrowski.finalny.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.kostrowski.finalny.converters.CardConverter;
import pl.kostrowski.finalny.entities.Cards;
import pl.kostrowski.finalny.repository.CardRepository;
import pl.kostrowski.finalny.restclients.cards.TrelloCardClient;
import pl.kostrowski.finalny.restclients.dto.TrelloCardDto;

@Service
public class CardServiceImpl implements CardService {

    @Autowired
    TrelloCardClient trelloCardClient;

    @Autowired
    CardRepository cardRepository;

    @Autowired
    CardConverter cardConverter;

    @Override
    public Cards createNewCard(TrelloCardDto trelloCardDto) {


        TrelloCardDto newCard = trelloCardClient.saveToTrello(trelloCardDto);

        Cards convertedCard = cardConverter.convert(newCard);

        cardRepository.save(convertedCard);

        return convertedCard;
    }
}
