package pl.kostrowski.finalny.converters;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pl.kostrowski.finalny.entities.Board;
import pl.kostrowski.finalny.entities.Lists;
import pl.kostrowski.finalny.restclients.dto.TrelloBoardDto;
import pl.kostrowski.finalny.restclients.dto.TrelloListDto;

import java.util.LinkedList;
import java.util.List;

@Component
public class BoardConverter {

    @Autowired
    ListConverter listConverter;

    public Board convert(TrelloBoardDto toConvert, List<TrelloListDto> listToConvert) {

        Board result = new Board();

        result.setId(toConvert.getId());
        result.setName(toConvert.getName());
        result.setDescription(toConvert.getDescription());

        List<Lists> listsFromTrello = new LinkedList<>();

        if (listToConvert != null) {
            for (TrelloListDto trelloListDto : listToConvert) {
                Lists convertedList = listConverter.convert(trelloListDto);
                listsFromTrello.add(convertedList);
            }
        }

        result.setLists(listsFromTrello);

        return result;
    }
}
