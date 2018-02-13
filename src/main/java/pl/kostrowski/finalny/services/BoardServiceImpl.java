package pl.kostrowski.finalny.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.kostrowski.finalny.converters.BoardConverter;
import pl.kostrowski.finalny.entities.Board;
import pl.kostrowski.finalny.repository.BoardRepository;
import pl.kostrowski.finalny.restclients.boards.TrelloBoardClient;
import pl.kostrowski.finalny.restclients.dto.TrelloBoardDto;
import pl.kostrowski.finalny.restclients.dto.TrelloCardDto;
import pl.kostrowski.finalny.restclients.dto.TrelloListDto;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

@Service
public class BoardServiceImpl implements BoardService {

    @Autowired
    BoardRepository boardRepository;

    @Autowired
    TrelloBoardClient trelloBoardClient;

    @Autowired
    BoardConverter boardConverter;

    @Override
    public void saveAllToDatabase(List<Board> boards) {
        boardRepository.save(boards);
    }

    @Override
    public List<Board> getAllFromTrelloAndPersist() {

        List<TrelloBoardDto> allBoardsDto = trelloBoardClient.findAllBoards();
        List<Board> allBoards = new LinkedList<>();

        for (TrelloBoardDto trelloBoardDto : allBoardsDto) {
            String boardId = trelloBoardDto.getId();
            List<TrelloCardDto> allCardsFromBoard = getAllCardsFromTrelloForBoardId(boardId);
            List<TrelloListDto> allListsFromBoard = getListsFromTrelloForBoardId(boardId, allCardsFromBoard);
            Board converted = boardConverter.convert(trelloBoardDto, allListsFromBoard);
            allBoards.add(converted);
        }
        boardRepository.save(allBoards);
        return allBoards;
    }

    private List<TrelloCardDto> getAllCardsFromTrelloForBoardId(String boardId) {
        List<TrelloCardDto> allCardsForBoard = trelloBoardClient.findAllCardsByBoardId(boardId);
        return allCardsForBoard;
    }

    private List<TrelloListDto> getListsFromTrelloForBoardId(String boardId, List<TrelloCardDto> allCardsFromBoard) {

        List<TrelloListDto> allListsForBoard = trelloBoardClient.findAllListsByBoardId(boardId);

        Map<String, TrelloListDto> mapOfTrelloLists = new HashMap<>();

        for (TrelloListDto trelloListDto : allListsForBoard) {
            mapOfTrelloLists.put(trelloListDto.getId(), trelloListDto);
        }

        for (TrelloCardDto trelloCardDto : allCardsFromBoard) {
            String listId = trelloCardDto.getListId();
            List<TrelloCardDto> cards = mapOfTrelloLists.get(listId).getCards();
            if (cards == null){
                cards = new LinkedList<>();
                mapOfTrelloLists.get(listId).setCards(cards);
            }
            cards.add(trelloCardDto);
        }
        return allListsForBoard;
    }
}
