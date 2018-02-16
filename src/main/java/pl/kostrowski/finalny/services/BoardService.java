package pl.kostrowski.finalny.services;

import pl.kostrowski.finalny.entities.MyBoard;
import pl.kostrowski.finalny.entities.MyCard;

import java.util.List;

public interface BoardService {

    public List<MyBoard> getAllFromTrelloAndPersist();

    public void saveAllToDatabase(List<MyBoard> myBoards);

    public List<MyBoard> getAllFromDatabase();

    public MyBoard getBoardById(String id);

}

