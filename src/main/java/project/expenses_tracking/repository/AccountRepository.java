package project.expenses_tracking.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import project.expenses_tracking.model.Account;

import java.util.List;

public interface AccountRepository extends MongoRepository<Account, String> {
    @Query("{'user_id' : ?0}")
    List<Account> findAllByUserId(String user_id);
}
