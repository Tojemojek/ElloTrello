package pl.kostrowski.finalny.repository;

import org.springframework.data.repository.CrudRepository;
import pl.kostrowski.finalny.entities.Cards;

public interface CardRepository extends CrudRepository<Cards, String> {
}
