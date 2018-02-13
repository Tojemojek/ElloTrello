package pl.kostrowski.finalny.converters;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pl.kostrowski.finalny.entities.Cards;
import pl.kostrowski.finalny.entities.Lists;
import pl.kostrowski.finalny.restclients.dto.TrelloCardDto;
import pl.kostrowski.finalny.restclients.dto.TrelloListDto;

import java.util.LinkedList;
import java.util.List;

@Component
public class ListConverter {

    @Autowired
    CardConverter cardConverter;

    public Lists convert(TrelloListDto toConvert) {

        Lists result = new Lists();

        result.setId(toConvert.getId());
        result.setName(toConvert.getName());
        result.setBoardId(toConvert.getTrelloBoardId());
        result.setPositionOnBoard(toConvert.getPositionOnBoard());

        List<Cards> listOfCards = new LinkedList<>();

        if (toConvert.getCards() != null) {
            for (TrelloCardDto trelloCardDto : toConvert.getCards()) {
                Cards convertedList = cardConverter.convert(trelloCardDto);
                listOfCards.add(convertedList);
            }
        }
        result.setCards(listOfCards);
        return result;
    }
}
