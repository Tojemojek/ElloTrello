package pl.kostrowski.finalny.entities;


import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "lists")
public class MyList {

    @Id
    @Column(name = "id")
    private String id;

    @Column(name = "name")
    private String name;

    @Column(name = "position_on_Board")
    private Double positionOnBoard;

    @Column(name = "board_id")
    private String boardId;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "listId")
    private List<MyCard> cards;

    public MyList() {
    }

    public MyList(String id, String name, List<MyCard> cards) {
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

    public List<MyCard> getCards() {
        return cards;
    }

    public void setCards(List<MyCard> cards) {
        this.cards = cards;
    }

    public Double getPositionOnBoard() {
        return positionOnBoard;
    }

    public void setPositionOnBoard(Double positionOnBoard) {
        this.positionOnBoard = positionOnBoard;
    }

    public String getBoardId() {
        return boardId;
    }

    public void setBoardId(String boardId) {
        this.boardId = boardId;
    }
}
