package pl.kostrowski.finalny.restclients.cards;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;
import org.springframework.web.client.RestTemplate;
import pl.kostrowski.finalny.restclients.QueryPathElements;
import pl.kostrowski.finalny.restclients.dto.TrelloCardDto;
import pl.kostrowski.finalny.services.QueryBuilder;

import java.util.List;

@Component
public class TrelloCardClientImpl implements TrelloCardClient {

    private QueryBuilder queryBuilder;
    private RestTemplate restTemplate;

    @Autowired
    public TrelloCardClientImpl(QueryBuilder queryBuilder, RestTemplateBuilder restTemplateBuilder) {
        this.queryBuilder = queryBuilder;
        this.restTemplate = restTemplateBuilder.build();
    }

    @Override
    public List<TrelloCardDto> findAllCardsWithListId(String listId) {
        String request = QueryPathElements.ALL_CARDS_FROM_LIST.replaceListId(listId);
        String queryPath = queryBuilder.createQueryPath(request);
        ResponseEntity<TrelloCardDto[]> responseEntity = restTemplate.getForEntity(queryPath, TrelloCardDto[].class);
        return CollectionUtils.arrayToList(responseEntity.getBody());
    }

    @Override
    public TrelloCardDto saveToTrello(TrelloCardDto trelloCardDto) {
        String request = QueryPathElements.ADD_SINGLE_CARD.replaceListId(trelloCardDto.getListId());
        String queryPath = queryBuilder.createQueryPath(request);
        ResponseEntity<TrelloCardDto> cardDtoResponseEntity = restTemplate.postForEntity(queryPath, trelloCardDto, TrelloCardDto.class);
        return cardDtoResponseEntity.getBody();
    }
}
