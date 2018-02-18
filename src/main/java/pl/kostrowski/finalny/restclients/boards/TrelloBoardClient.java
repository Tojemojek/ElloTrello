package pl.kostrowski.finalny.restclients.boards;

import pl.kostrowski.finalny.restclients.trellomodel.TrelloBoardDto;
import pl.kostrowski.finalny.restclients.trellomodel.TrelloCardDto;
import pl.kostrowski.finalny.restclients.trellomodel.TrelloListDto;

import java.util.List;

public interface TrelloBoardClient {

    public List<TrelloBoardDto> findAllBoards();

    public List<TrelloListDto> findAllListsByBoardId(String boardId);

    public List<TrelloCardDto> findAllCardsByBoardId(String boardId);

    public TrelloBoardDto findBoardById(String boardId);

}
