package pl.kostrowski.finalny.repository;

import org.springframework.data.repository.CrudRepository;
import pl.kostrowski.finalny.entities.MyBoard;
import pl.kostrowski.finalny.entities.MyCard;

import java.util.List;

public interface BoardRepository extends CrudRepository<MyBoard,String>{

}
