package pl.kostrowski.finalny.converters;

import org.springframework.stereotype.Component;
import pl.kostrowski.finalny.entities.MyCard;
import pl.kostrowski.finalny.restclients.trellomodel.TrelloCardDto;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Component
public class CardConverter {

    public MyCard convert(TrelloCardDto toConvert) {

        MyCard result = new MyCard();

        result.setId(toConvert.getId());
        result.setName(toConvert.getName());
        result.setDescription(toConvert.getDescription());
        result.setListId(toConvert.getListId());

        if (toConvert.getDueDate() != null) {

            result.setDueDate(LocalDateTime.parse(toConvert.getDueDate().replace("Z","")));
        }

        result.setPosition(toConvert.getPositionOnList());

        return result;
    }
}