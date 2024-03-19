package project.expenses_tracking.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import project.expenses_tracking.model.User;

public interface UserRepository extends MongoRepository<User, String> {}
