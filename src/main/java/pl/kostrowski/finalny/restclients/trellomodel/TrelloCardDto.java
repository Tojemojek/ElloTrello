package pl.kostrowski.finalny.restclients.trellomodel;

import com.fasterxml.jackson.annotation.JsonProperty;

public class TrelloCardDto {

    @JsonProperty("id")
    private String id;

    @JsonProperty("name")
    private String name;

    @JsonProperty("desc")
    private String description;

    @JsonProperty("due")
    private String dueDate;

    @JsonProperty("idList")
    private String listId;

    @JsonProperty("pos")
    private Double positionOnList;

    public TrelloCardDto() {
    }

    public TrelloCardDto(String id, String name, String description, String dueDate, String listId, Double positionOnList) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.dueDate = dueDate;
        this.listId = listId;
        this.positionOnList = positionOnList;
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

    public String getDueDate() {
        return dueDate;
    }

    public void setDueDate(String dueDate) {
        this.dueDate = dueDate;
    }

    public String getListId() {
        return listId;
    }

    public void setListId(String listId) {
        this.listId = listId;
    }

    public Double getPositionOnList() {
        return positionOnList;
    }

    public void setPositionOnList(Double positionOnList) {
        this.positionOnList = positionOnList;
    }
}

