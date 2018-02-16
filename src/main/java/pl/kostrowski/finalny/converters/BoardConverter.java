package pl.kostrowski.finalny.converters;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pl.kostrowski.finalny.entities.MyBoard;
import pl.kostrowski.finalny.entities.MyList;
import pl.kostrowski.finalny.restclients.dto.TrelloBoardDto;
import pl.kostrowski.finalny.restclients.dto.TrelloListDto;

import java.util.LinkedList;
import java.util.List;

@Component
public class BoardConverter {

    @Autowired
    ListConverter listConverter;

    public MyBoard convert(TrelloBoardDto toConvert, List<TrelloListDto> listToConvert) {

        MyBoard result = new MyBoard();

        result.setId(toConvert.getId());
        result.setName(toConvert.getName());
        result.setDescription(toConvert.getDescription());

        List<MyList> myListFromTrello = new LinkedList<>();

        if (listToConvert != null) {
            for (TrelloListDto trelloListDto : listToConvert) {
                MyList convertedList = listConverter.convert(trelloListDto);
                myListFromTrello.add(convertedList);
            }
        }

        result.setLists(myListFromTrello);

        return result;
    }
}
