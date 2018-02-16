package pl.kostrowski.finalny.repository;

import org.springframework.data.repository.CrudRepository;
import pl.kostrowski.finalny.entities.MyCard;

import java.util.List;

public interface CardRepository extends CrudRepository<MyCard, String> {

    List<MyCard> getAllByListId (String listId);
}


