package project.expenses_tracking.service;

import project.expenses_tracking.model.User;

import java.util.Optional;

public interface UserService {
    Optional<User> read(String id);
}
