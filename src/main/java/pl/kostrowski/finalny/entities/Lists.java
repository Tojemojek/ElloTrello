package pl.kostrowski.finalny.entities;


import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "lists")
public class Lists {

    @Id
    @Column(name = "id")
    private String id;

    @Column
    private String name;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "listId")
    private List<Cards> cards;

    public Lists() {
    }

    public Lists(String id, String name, List<Cards> cards) {
        this.id = id;
        this.name = name;
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

    public List<Cards> getCards() {
        return cards;
    }

    public void setCards(List<Cards> cards) {
        this.cards = cards;
    }
}
