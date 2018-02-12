package pl.kostrowski.finalny.restclients.boards;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;
import org.springframework.web.client.RestTemplate;
import pl.kostrowski.finalny.restclients.PathElements;
import pl.kostrowski.finalny.restclients.dto.TrelloBoardDto;
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
    public List<TrelloBoardDto> findAll() {

        String request = PathElements.ALL_BOARDS.getPathParam();

        String queryPath = queryBuilder.createQueryPath(request);

        ResponseEntity<TrelloBoardDto[]> responseEntity = restTemplate.getForEntity(queryPath, TrelloBoardDto[].class);
        return CollectionUtils.arrayToList(responseEntity.getBody());
    }

    @Override
    public TrelloBoardDto findById(String id) {

        String request = PathElements.SINGLE_BOARD.getPathParam() + id;

        String queryPath = queryBuilder.createQueryPath(request);

        TrelloBoardDto trelloBoardDto = restTemplate.getForObject(queryPath, TrelloBoardDto.class);
        return trelloBoardDto;
    }

}
