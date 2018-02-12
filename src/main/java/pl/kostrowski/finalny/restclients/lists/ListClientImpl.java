package pl.kostrowski.finalny.restclients.lists;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;
import org.springframework.web.client.RestTemplate;
import pl.kostrowski.finalny.restclients.PathElements;
import pl.kostrowski.finalny.restclients.dto.TrelloListDto;
import pl.kostrowski.finalny.services.QueryBuilder;

import java.util.List;

@Component
public class ListClientImpl implements ListClient {

    private QueryBuilder queryBuilder;
    private RestTemplate restTemplate;

    @Autowired
    public ListClientImpl(QueryBuilder queryBuilder, RestTemplateBuilder restTemplateBuilder) {
        this.queryBuilder = queryBuilder;
        this.restTemplate = restTemplateBuilder.build();
    }

    @Override
    public List<TrelloListDto> findAllForBoard(String boardId) {

        String request = PathElements.SINGLE_BOARD.getPathParam() + boardId + "/lists";

        String queryPath = queryBuilder.createQueryPath(request);

        ResponseEntity<TrelloListDto[]> responseEntity = restTemplate.getForEntity(queryPath, TrelloListDto[].class);
        return CollectionUtils.arrayToList(responseEntity.getBody());
    }

}
