package pl.kostrowski.finalny.services;

import pl.kostrowski.finalny.entities.MyUser;

import java.util.List;

public interface UserService {

    List<MyUser> getAllFromRepository();

    boolean authenticate(String login, String password);
}
