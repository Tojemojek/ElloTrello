package pl.kostrowski.finalny.restclients.boards;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;
import org.springframework.web.client.RestTemplate;
import pl.kostrowski.finalny.restclients.QueryPathElements;
import pl.kostrowski.finalny.restclients.trellomodel.TrelloBoardDto;
import pl.kostrowski.finalny.restclients.trellomodel.TrelloCardDto;
import pl.kostrowski.finalny.restclients.trellomodel.TrelloListDto;
import pl.kostrowski.finalny.services.QueryBuilder;

import java.util.List;

@Component
public class TrelloBoardClientImpl implements TrelloBoardClient {

    private QueryBuilder queryBuilder;
    private RestTemplate restTemplate;

    @Autowired
    public TrelloBoardClientImpl(QueryBuilder queryBuilder, RestTemplateBuilder restTemplateBuilder) {
        this.queryBuilder = queryBuilder;
        this.restTemplate = restTemplateBuilder.build();
    }

    @Override
    public List<TrelloBoardDto> findAllBoards() {

        String request = QueryPathElements.ALL_BOARDS.getPathParam();
        String queryPath = queryBuilder.createQueryPath(request);
        ResponseEntity<TrelloBoardDto[]> responseEntity = restTemplate.getForEntity(queryPath, TrelloBoardDto[].class);
        return CollectionUtils.arrayToList(responseEntity.getBody());
    }

    @Override
    public List<TrelloListDto> findAllListsByBoardId(String boardId) {
        String request = QueryPathElements.ALL_LISTS_FROM_BOARD.replaceBoardId(boardId);
        String queryPath = queryBuilder.createQueryPath(request);
        ResponseEntity<TrelloListDto[]> responseEntity = restTemplate.getForEntity(queryPath, TrelloListDto[].class);
        return CollectionUtils.arrayToList(responseEntity.getBody());
    }

    @Override
    public List<TrelloCardDto> findAllCardsByBoardId(String boardId) {
        String request = QueryPathElements.ALL_CARDS_FROM_BOARD.replaceBoardId(boardId);
        String queryPath = queryBuilder.createQueryPath(request);
        ResponseEntity<TrelloCardDto[]> responseEntity = restTemplate.getForEntity(queryPath, TrelloCardDto[].class);
        return CollectionUtils.arrayToList(responseEntity.getBody());
    }

    @Override
    public TrelloBoardDto findBoardById(String boardId) {
        String request = QueryPathElements.SINGLE_BOARD.replaceBoardId(boardId);
        String queryPath = queryBuilder.createQueryPath(request);
        TrelloBoardDto trelloBoardDto = restTemplate.getForObject(queryPath, TrelloBoardDto.class);
        return trelloBoardDto;
    }

}
