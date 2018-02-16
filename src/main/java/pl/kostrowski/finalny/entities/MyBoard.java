package pl.kostrowski.finalny.entities;


import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "board")
public class MyBoard {

    @Id
    @Column(name = "id")
    private String id;

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "boardId")
    private List<MyList> lists;

    public MyBoard() {
    }

    public MyBoard(String id, String name, String description, List<MyList> lists) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.lists = lists;
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

    public List<MyList> getLists() {
        return lists;
    }

    public void setLists(List<MyList> lists) {
        this.lists = lists;
    }
}
