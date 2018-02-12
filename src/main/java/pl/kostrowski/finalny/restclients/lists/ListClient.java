package pl.kostrowski.finalny.restclients.lists;


import pl.kostrowski.finalny.restclients.dto.TrelloListDto;

import java.util.List;

public interface ListClient {

    public List<TrelloListDto> findAllForBoard(String ListId);

}
