package pl.kostrowski.finalny.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.kostrowski.finalny.converters.BoardConverter;
import pl.kostrowski.finalny.entities.Board;
import pl.kostrowski.finalny.repository.BoardRepository;
import pl.kostrowski.finalny.restclients.boards.TrelloBoardClient;
import pl.kostrowski.finalny.restclients.cards.TrelloCardClient;
import pl.kostrowski.finalny.restclients.dto.TrelloBoardDto;
import pl.kostrowski.finalny.restclients.dto.TrelloCardDto;
import pl.kostrowski.finalny.restclients.dto.TrelloListDto;
import pl.kostrowski.finalny.restclients.lists.ListClient;

import java.util.LinkedList;
import java.util.List;

@Service
public class BoardServiceImpl implements BoardService {

    @Autowired
    BoardRepository boardRepository;

    @Autowired
    TrelloBoardClient trelloBoardClient;

    @Autowired
    TrelloCardClient trelloCardClient;

    @Autowired
    ListClient listClient;

    @Autowired
    BoardConverter boardConverter;

    @Override
    public void saveAllToDatabase(List<Board> boards) {
        boardRepository.save(boards);
    }

    @Override
    public List<Board> getAllFromTrelloAndPersist() {

        List<TrelloBoardDto> allBoardsDto = trelloBoardClient.findAll();
        List<Board> allBoards = new LinkedList<>();

        for (TrelloBoardDto trelloBoardDto : allBoardsDto) {
            String boardId = trelloBoardDto.getId();
            List<TrelloListDto> allForBoard = getListsFromTrelloForBoardId(boardId);
            Board converted = boardConverter.convert(trelloBoardDto, allForBoard);
            allBoards.add(converted);
        }

        boardRepository.save(allBoards);

        return allBoards;
    }

    private List<TrelloListDto> getListsFromTrelloForBoardId (String boardId){

        List<TrelloListDto> allForBoard = listClient.findAllForBoard(boardId);

        for (TrelloListDto listListsDto : allForBoard) {
            String listId = listListsDto.getId();
            List<TrelloCardDto> allForList = trelloCardClient.findAllForList(listId);
            listListsDto.setCards(allForList);
        }
        return allForBoard;
    }






}
