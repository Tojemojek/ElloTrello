package pl.kostrowski.finalny.restclients.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class TrelloListDto {

    @JsonProperty("id")
    private String id;

    @JsonProperty("name")
    private String name;

    @JsonProperty("desc")
    private String description;

    private List<TrelloCardDto> cards;

    public TrelloListDto() {
    }

    public TrelloListDto(String id, String name, String description, List<TrelloCardDto> cards) {
        this.id = id;
        this.name = name;
        this.description = description;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<TrelloCardDto> getCards() {
        return cards;
    }

    public void setCards(List<TrelloCardDto> cards) {
        this.cards = cards;
    }

}
