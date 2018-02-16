package pl.kostrowski.finalny.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.kostrowski.finalny.converters.BoardConverter;
import pl.kostrowski.finalny.entities.MyBoard;
import pl.kostrowski.finalny.entities.MyCard;
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
    public void saveAllToDatabase(List<MyBoard> myBoards) {
        boardRepository.save(myBoards);
    }

    @Override
    public List<MyBoard> getAllFromTrelloAndPersist() {

        List<TrelloBoardDto> allBoardsDto = trelloBoardClient.findAllBoards();
        List<MyBoard> allMyBoards = new LinkedList<>();

        for (TrelloBoardDto trelloBoardDto : allBoardsDto) {
            String boardId = trelloBoardDto.getId();
            List<TrelloCardDto> allCardsFromBoard = getAllCardsFromTrelloForBoardId(boardId);
            List<TrelloListDto> allListsFromBoard = getListsFromTrelloForBoardId(boardId, allCardsFromBoard);
            MyBoard converted = boardConverter.convert(trelloBoardDto, allListsFromBoard);
            allMyBoards.add(converted);
        }
        boardRepository.save(allMyBoards);
        return allMyBoards;
    }

    @Override
    public List<MyBoard> getAllFromDatabase() {

        List<MyBoard> all = (List<MyBoard>) boardRepository.findAll();

        return all;
    }

    @Override
    public MyBoard getBoardById(String id) {

        MyBoard fromDatabase;
        try {
            fromDatabase = boardRepository.findOne(id);
        } catch (Exception e){
            fromDatabase = new MyBoard();
        }

        return fromDatabase;
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
