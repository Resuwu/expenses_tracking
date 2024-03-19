package project.expenses_tracking.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import project.expenses_tracking.model.User;
import project.expenses_tracking.service.UserServiceImpl;

import java.util.Optional;

@RestController
@RequestMapping("/user")
public class UserController {
    private final UserServiceImpl service;
    @Autowired
    public UserController(UserServiceImpl service) {
        this.service = service;
    }
    @GetMapping
    public ResponseEntity<User> getUser(@RequestHeader("USER_ID") String id) {
        Optional<User> found = service.read(id);
        return found.map(user -> new ResponseEntity<>(user, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
}
