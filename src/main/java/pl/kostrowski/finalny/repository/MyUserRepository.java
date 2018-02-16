package pl.kostrowski.finalny.repository;

import org.springframework.data.repository.CrudRepository;
import pl.kostrowski.finalny.entities.MyUser;

public interface MyUserRepository extends CrudRepository<MyUser, String> {

    MyUser findOneByIdAndPassword(String id, String password);

}
