package pl.kostrowski.finalny.services;

import pl.kostrowski.finalny.entities.Board;

import java.util.List;

public interface BoardService {

    public void saveAllToDatabase(List<Board> boards);
    public List<Board> getAllFromTrelloAndPersist();
}

