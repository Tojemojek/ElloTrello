package pl.kostrowski.finalny.converters;

import org.springframework.stereotype.Component;
import pl.kostrowski.finalny.entities.Cards;
import pl.kostrowski.finalny.restclients.dto.TrelloCardDto;

@Component
public class CardConverter {

    public Cards convert(TrelloCardDto toConvert) {

        Cards result = new Cards();

        result.setId(toConvert.getId());
        result.setName(toConvert.getName());
        result.setDescription(toConvert.getDescription());
        result.setListId(toConvert.getListId());

        return result;
    }
}