package pl.kostrowski.finalny.restclients.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class TrelloListDto {

    @JsonProperty("id")
    private String id;

    @JsonProperty("name")
    private String name;

    @JsonProperty("pos")
    private Double positionOnBoard;

    @JsonProperty("idBoard")
    private String trelloBoardId;

    private List<TrelloCardDto> cards;

    public TrelloListDto() {
    }

    public TrelloListDto(String id, String name, Double positionOnBoard, String trelloBoardId, List<TrelloCardDto> cards) {
        this.id = id;
        this.name = name;
        this.positionOnBoard = positionOnBoard;
        this.trelloBoardId = trelloBoardId;
        this.cards = cards;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPositionOnBoard() {
        return positionOnBoard;
    }

    public void setPositionOnList(Double positionOnBoard) {
        this.positionOnBoard = positionOnBoard;
    }

    public String getTrelloBoardId() {
        return trelloBoardId;
    }

    public void setTrelloBoardId(String trelloBoardId) {
        this.trelloBoardId = trelloBoardId;
    }

    public List<TrelloCardDto> getCards() {
        return cards;
    }

    public void setCards(List<TrelloCardDto> cards) {
        this.cards = cards;
    }
}
