package pl.kostrowski.finalny.converters;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pl.kostrowski.finalny.entities.MyCard;
import pl.kostrowski.finalny.entities.MyList;
import pl.kostrowski.finalny.restclients.dto.TrelloCardDto;
import pl.kostrowski.finalny.restclients.dto.TrelloListDto;

import java.util.LinkedList;
import java.util.List;

@Component
public class ListConverter {

    @Autowired
    CardConverter cardConverter;

    public MyList convert(TrelloListDto toConvert) {

        MyList result = new MyList();

        result.setId(toConvert.getId());
        result.setName(toConvert.getName());
        result.setBoardId(toConvert.getTrelloBoardId());
        result.setPositionOnBoard(toConvert.getPositionOnBoard());

        List<MyCard> listOfCards = new LinkedList<>();

        if (toConvert.getCards() != null) {
            for (TrelloCardDto trelloCardDto : toConvert.getCards()) {
                MyCard convertedList = cardConverter.convert(trelloCardDto);
                listOfCards.add(convertedList);
            }
        }
        result.setCards(listOfCards);
        return result;
    }
}
