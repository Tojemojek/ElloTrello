package pl.kostrowski.finalny.services;

import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pl.kostrowski.finalny.entities.MyUser;
import pl.kostrowski.finalny.repository.MyUserRepository;

import java.util.List;

@Component
public class UserServiceImpl implements UserService {

    @Autowired
    private MyUserRepository myUserRepository;

    @Override
    public List<MyUser> getAllFromRepository() {
        return (List<MyUser>) myUserRepository.findAll();
    }

    @Override
    public boolean authenticate(String login, String password) {

        password = DigestUtils.md5Hex(password);

        MyUser user = myUserRepository.findOneByIdAndPassword(login, password);

        return user != null ? true : false;
    }
}
