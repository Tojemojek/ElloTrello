package pl.kostrowski.finalny.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.kostrowski.finalny.converters.CardConverter;
import pl.kostrowski.finalny.entities.MyCard;
import pl.kostrowski.finalny.repository.CardRepository;
import pl.kostrowski.finalny.restclients.cards.TrelloCardClient;
import pl.kostrowski.finalny.restclients.dto.TrelloCardDto;

import java.util.List;

@Service
public class CardServiceImpl implements CardService {

    @Autowired
    TrelloCardClient trelloCardClient;

    @Autowired
    CardRepository cardRepository;

    @Autowired
    CardConverter cardConverter;

    @Override
    public MyCard createNewCard(TrelloCardDto trelloCardDto) {

        TrelloCardDto newCard = trelloCardClient.saveToTrello(trelloCardDto);

        MyCard convertedCard = cardConverter.convert(newCard);

        cardRepository.save(convertedCard);

        return convertedCard;
    }

    @Override
    public List<MyCard> getCardsByListId(String listId) {

        List<MyCard> allByListId = cardRepository.getAllByListId(listId);

        return allByListId;
    }

    @Override
    public MyCard updateMyCard(TrelloCardDto trelloCardDto) {

        TrelloCardDto updatedTreloCard = trelloCardClient.updateToTrelo(trelloCardDto);
        MyCard convertedCard = cardConverter.convert(updatedTreloCard);
        cardRepository.save(convertedCard);

        return convertedCard;
    }
}
