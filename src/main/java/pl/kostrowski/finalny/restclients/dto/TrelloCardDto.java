package pl.kostrowski.finalny.restclients.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class TrelloCardDto {

    @JsonProperty("id")
    private String id;

    @JsonProperty("name")
    private String name;

    @JsonProperty("desc")
    private String description;

    @JsonProperty("idList")
    private String listId;

    public TrelloCardDto() {
    }

    public TrelloCardDto(String id, String name, String description) {
        this.id = id;
        this.name = name;
        this.description = description;
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

    public String getListId() {
        return listId;
    }

    public void setListId(String listId) {
        this.listId = listId;
    }
}

