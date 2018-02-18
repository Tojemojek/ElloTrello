package pl.kostrowski.finalny.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import pl.kostrowski.finalny.entities.MyUser;
import pl.kostrowski.finalny.services.UserService;

import java.util.List;

@RestController
@RequestMapping(value = "/users")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/")
    public List<MyUser> getAllUsersFromDatabase() {

        return userService.getAllFromRepository();
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login() {
        return "hejka";
    }

}
