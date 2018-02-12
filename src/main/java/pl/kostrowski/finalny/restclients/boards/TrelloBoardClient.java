package pl.kostrowski.finalny.restclients.boards;

import pl.kostrowski.finalny.restclients.dto.TrelloBoardDto;

import java.util.List;

public interface TrelloBoardClient {

    public List<TrelloBoardDto> findAll();
    public TrelloBoardDto findById(String id);

}
