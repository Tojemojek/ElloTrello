package pl.kostrowski.finalny.entities;


import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

@Entity
@Table(schema = "ellotrello", name = "cards")
public class MyCard {

    @Id
    @Column(name = "id")
    private String id;

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    @Column(name = "list_id", nullable = false)
    private String listId;

    @Column(name = "due_date")
    private LocalDateTime dueDate;

    @Column(name = "position_on_list")
    private Double position;

    public MyCard() {
    }

    public MyCard(String id, String name, String description, String listId, LocalDateTime dueDate, Double position) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.listId = listId;
        this.dueDate = dueDate;
        this.position = position;
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

    public LocalDateTime getDueDate() {
        return dueDate;
    }

    public void setDueDate(LocalDateTime dueDate) {
        this.dueDate = dueDate;
    }

    public Double getPosition() {
        return position;
    }

    public void setPosition(Double position) {
        this.position = position;
    }
}
