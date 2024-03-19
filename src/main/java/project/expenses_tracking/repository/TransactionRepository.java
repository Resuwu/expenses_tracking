package project.expenses_tracking.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import project.expenses_tracking.model.Transaction;

import java.time.LocalDate;
import java.util.List;

public interface TransactionRepository extends MongoRepository<Transaction, String> {
    @Query("{'user_id' : ?0}")
    List<Transaction> findAllByUserId(String user_id);

    @Query("{'user_id' : ?0, 'date : $gte' : ?1, 'date : $lte' : ?2}")
    List<Transaction> findAllByTimeBracket(String user_id, LocalDate from, LocalDate to);

    @Query("{'account_id' : ?0}")
    List<Transaction> findAllByAccountId(String account_id);
}
