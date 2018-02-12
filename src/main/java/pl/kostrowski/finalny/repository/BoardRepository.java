package pl.kostrowski.finalny.repository;

import org.springframework.data.repository.CrudRepository;
import pl.kostrowski.finalny.entities.Board;

public interface BoardRepository extends CrudRepository<Board,String>{

}
